package Kernel;

public abstract class CirSim {
    public static double Dv;
    public static double Di;
    public static double Dt;
    public static double timeDomain;

    public static void simulate() {
        setUnionIndexForAllElements();
        setTempVForAllNodes(0);
        int n = (int) (timeDomain / Dt);
        while (checkAllDeltas()) {       //DC analyze
            solver(0);
        }
        for (int i = 1; i < n; i++) {
            solver(n * Dt);
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

    public static void printResults() {
        int j = 1;
        System.out.println("******          Nodes voltages:         ******");
        for (Node node : Circuit.nodeList) {
            System.out.printf("%d", j++);
            for (Double voltage : node.voltageList) {
                System.out.printf(" %f ", voltage);
            }
            System.out.printf("\n");
        }
        System.out.println("******          Nodes voltages:         ******");
        j = 0;
        for (Element element : Circuit.elementList) {
            System.out.printf(element.name + " ");
            System.out.printf("(%f , %f ,", element.voltageList.get(j), element.currentList.get(j));
            System.out.printf(" %f) \n", element.voltageList.get(j) * element.currentList.get(j));
            j++;
        }
    }
}
