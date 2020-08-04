package Kernel;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String name;
    public boolean isAdded = false;
    public Node parentNode = null;
    public Union belongUnion = null;
    public ArrayList<Element> elementList = new ArrayList<Element>();
    public ArrayList<Node> adjacentNodes = new ArrayList<Node>();
    public ArrayList<Double> voltageList = new ArrayList<Double>();
    public ArrayList<VoltageSrc> adjacentSources = new ArrayList<VoltageSrc>();

    protected double tempV;
    // Declare variable voltage to hold the latest element of voltageList
    protected double voltage;
    public ArrayList<Element> negativeElementList = new ArrayList<Element>();
    public ArrayList<Element> positiveElementList = new ArrayList<Element>();

    Node() {
    }

    Node(String givenName) {
        name = givenName;
        voltage = 0;
        tempV = 0;
        voltageList.add(0.00);
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

    // Current related methods

    // According to KCL this value must be equal to 0, this function is merely for simulation purposes
    public double getCurrent() {
        double current = 0;
        for (Element element : elementList) {
            current += element.getCurrent(Circuit.returnNode(name));
        }
        return current;
    }

    // Voltage related methods
    public double getTempV() {
        return tempV;
    }

    public void setTempV(double inputV) {
        this.tempV = inputV;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getLastVoltage() {
        int lastIndex = voltageList.size() - 1;
        return (voltageList.get(lastIndex));
    } // Isn't this the same as getVoltage()??!

    public void setVoltage(double voltage) {
        if (name.equals("0")) {
            System.out.println("Trying to set voltage for ground node!!");
        } else {
            this.voltage = voltage;
        }
    }
}
