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

    public double getTotalCurrent(double time) {
        double i = 0;
        for (Element element : elementList) {
            if (element.unionIndex != index)
                i += element.getCurrent(time);
        }
        return i;
    }

    public void doStep(double time) {
        this.setV_ForAllNodes_FromList();
        double Dv = CirSim.Dv;
        double Di = CirSim.Di;
        I_total1 = this.getTotalCurrent(time);
        this.addToV_ForAllNodes(Dv);
        I_total2 = this.getTotalCurrent(time);
        delta = ((Math.abs(I_total1) - Math.abs(I_total2)) * Dv) / Di;
        this.addToV_ForAllNodes(Dv);
    }

    private void setV_ForAllNodes_FromList() {
        for (Node node : Circuit.nodeList) {
            node.V = node.voltageList.get(node.voltageList.size() - 1);
        }
    }

    private void addToV_ForAllNodes(Double Dv) {
        for (Node node : nodeList) {
            node.V += Dv;
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
