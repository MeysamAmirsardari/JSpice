package Kernel;

import java.util.ArrayList;

public class Union {
    public ArrayList<Node> nodeList = new ArrayList<Node>();
    public ArrayList<Element> elementList = new ArrayList<Element>();
    public boolean visited = false;
    public ArrayList<Double> voltage = new ArrayList<Double>();
    public double V;
    public double I_total1;
    public double I_total2;
    public double delta;
    public int index;
    public Node parentUnion;

    /***************** getter ***************/
    public ArrayList<Node> getNodeList() {
        return nodeList;
    }
    public Node getParentUnion() {
        return parentUnion;
    }

    /***************** setter ***************/
    public void setParentUnion(Node pUnion) {
        parentUnion = pUnion;
    }

    public void addNode(Node node) {
        this.nodeList.add(node);
    }

    public static void setElementListForAllUnions() {
        for (Union union : Circuit.unionList) {
            for (Node node : union.nodeList) {
                for (Element element : node.elementList) {
                    union.elementList.add(element);
                    element.unionIndex = union.index;
                }
            }
        }
    }

    public void doStep(double time) {
        this.setTempV_ForAllNodes_FromList();
        double Dv = CirSim.Dv;
        double Di = CirSim.Di;
        I_total1 = this.getTotalCurrent(time);
        this.addToTempV_ForAllNodes(Dv);
        I_total2 = this.getTotalCurrent(time);
        delta = ((Math.abs(I_total1) - Math.abs(I_total2)) * Dv) / Di;
        this.addToTempV_ForAllNodes(delta);
    }

    public double getTotalCurrent(double time) {
        double i = 0;
        for (Node node : nodeList) {
            for (Element element : node.negativeElementList) {
                if (element.unionIndex != index)
                    i += element.getCurrentFromNegativeNode(time);
            }
            for (Element element : node.positiveElementList) {
                if (element.unionIndex != index)
                    i -= element.getCurrentFromPositiveNode(time);
            }
        }
        return i;
    }

    private void setTempV_ForAllNodes_FromList() {
        for (Node node : Circuit.nodeList) {
            node.tempV = node.voltageList.get(node.voltageList.size() - 1);
        }
    }

    private void addToTempV_ForAllNodes(Double Dv) {
        for (Node node : nodeList) {
            node.tempV += Dv;
        }
    }

    public void addNodeList(ArrayList<Node> nList) {
        for (Node nNode : nList) {
            if (!nodeList.contains(nNode)) {
                nodeList.add(nNode);
            }
        }
    }
}
