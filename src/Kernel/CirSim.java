package Kernel;

import java.util.ArrayList;

public abstract class CirSim {
    public static double Dv;
    public static double Di;
    public static double Dt;
    public static double timeDomain;

    public static void simulate() {
        reArrangeElementListForNodes();

        ArrayList<Node> temp = Circuit.nodeList;
        Circuit.nodeList = new ArrayList<Node>();

        for (Node node : temp) {
            if (!node.name.equals("0"))
                Circuit.nodeList.add(node);
        }

        setTempVForAllNodes(0);
        setUnionIndexForAllElements();
        for (Element element : Circuit.elementList) {
            if (element.voltageList.size()==0)
                element.voltageList.add(0.0);
        }
        for (Node node : Circuit.nodeList) {
            if (node.voltageList.size()==0)
                node.voltageList.add(0.0);
        }
        int n = (int) (timeDomain / Dt);
        //while (checkAllDeltas()) {       //DC analyze
        //    solver(0);
        //}
        for (int i = 1; i < n; i++) {
            solver(i * Dt);
        }
    }

    private static void reArrangeElementListForNodes(){
        boolean found;
        for (Node node : Circuit.nodeList) {
            ArrayList<Element> temp = node.elementList;
            node.elementList = new ArrayList<Element>();
            for (Element element : temp) {
                found = false;
                for (Element addedElm : node.elementList) {
                    if (addedElm.name.equals(element.name))
                        found=true;
                }
                if (!found){
                    node.elementList.add(element);
                }
            }
        }
    }

    private static void solver(double time) {
        for (Union union : Circuit.unionList) {
            union.doStep(time);
            for (Node node : union.nodeList) {
                node.voltageList.add(node.getTempV());
            }
        }
        updateElementsDetails(time);
    }

    private static void updateElementsDetails(double time) {
        for (Element element : Circuit.elementList) {
            element.voltageList.add(element.getVoltage(time));
            element.currentList.add(element.getCurrent(time));
        }
    }

    private static boolean checkAllDeltas() {
        boolean isSet = true;
        for (Union union : Circuit.unionList) {
            if (union.delta > 0.1)
                isSet = false;
        }
        return isSet;
    }

    private static void setTempVForAllNodes(double tempVoltage) {
        for (Node node : Circuit.nodeList) {
            node.tempV = tempVoltage;
        }
    }

    private static void setUnionIndexForAllElements() {
        int i = 0;
        for (Union union : Circuit.unionList) {
            union.index = i;
            i++;
        }
        for (Union union : Circuit.unionList) {
            for (Node node : union.nodeList) {
                for (Element element : node.elementList) {
                    element.unionIndex = union.index;
                }
            }
        }
    }

    public static void setNodesIndexesForElements(){
        for (Element element : Circuit.elementList) {
            element.negativeNodeIndex = Integer.parseInt(element.negativeNode.name);
            element.positiveNodeIndex = Integer.parseInt(element.positiveNode.name);
        }
    }

    public static void printResults() {
        int j = 1;
        System.out.println("******          Nodes voltages:         ******");
        //for (Node node : Circuit.nodeList) {
        //    System.out.printf("%d", j++);
        //    for (Double voltage : node.voltageList) {
        //        System.out.printf(" %f ", voltage);
        //    }
        //    System.out.printf("\n");
        //}
        for (Node element : Circuit.nodeList) {
            Double b = element.voltageList.get(element.voltageList.size()-1);
            System.out.printf("( %f ) \n",b);
        }
        System.out.println("******          Elements voltages:         ******");

        for (Element element : Circuit.elementList) {
            Double a = element.currentList.get(element.currentList.size()-1);
            Double b = element.voltageList.get(element.voltageList.size()-1);
            System.out.printf(element.getName() + " ");
            System.out.printf("(%f , %f ,", element.voltageList.get(element.voltageList.size()-1),
                    element.currentList.get(element.currentList.size()-1));
            System.out.printf(" %f) \n",
                    element.voltageList.get(element.voltageList.size()-1) * element.currentList.get(element.currentList.size()-1));
        }
    }
}
