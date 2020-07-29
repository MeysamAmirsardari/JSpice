package Kernel;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public static Node ground;
    public boolean isAdded = false;
    public Node parentNode = null;
    public int union;
    public List<Element> negativeElementList = new ArrayList<Element>();
    public List<Element> positiveElementList = new ArrayList<Element>();
    boolean internal = true;
    public int index;
    public String name;
    public Union belongUnion;

    public List<Element> elementList = new ArrayList<Element>();
    public List<Node> adjacentNodes = new ArrayList<Node>();
    public List<Double> voltageList = new ArrayList<Double>();
    protected double tempV;
    protected double V_minus;

    Node(String givenName) {
        name = givenName;
    }

    Node() {
    }

    protected static void setNodesForAllElements() {
        creatNodeList();
        for (Element element : Circuit.elementList) {
            element.negativeNode = Circuit.nodeList.get(element.negativeNodeIndex);
            Circuit.nodeList.get(element.negativeNodeIndex).negativeElementList.add(element);
            Circuit.nodeList.get(element.negativeNodeIndex).elementList.add(element);
            element.positiveNode = Circuit.nodeList.get(element.positiveNodeIndex);
            Circuit.nodeList.get(element.positiveNodeIndex).positiveElementList.add(element);
            Circuit.nodeList.get(element.positiveNodeIndex).elementList.add(element);
        }
    }

    public double getTempV() {
        return tempV;
    }

    public double getVoltage() {
        return (voltageList.get(voltageList.size() - 1));
    }

    public void setTempV(double inputV) {
        this.tempV = inputV;
    }

    protected static void creatNodeList() {
        int maxIndex = 0;
        for (Element element : Circuit.elementList) {
            if (maxIndex < element.negativeNodeIndex)
                maxIndex = Math.max(element.negativeNodeIndex, element.positiveNodeIndex);
        }
        for (int i = 0; i < maxIndex + 1; i++) {
            Node node = new Node();
            Circuit.nodeList.add(node);
        }
    }

    public double getLastVoltage() {
        int lastIndex = voltageList.size() - 1;
        return (voltageList.get(lastIndex));
    }
}
