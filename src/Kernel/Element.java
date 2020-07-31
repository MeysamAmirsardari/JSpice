package Kernel;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    List<Double> currentList = new ArrayList<Double>();
    List<Double> voltageList = new ArrayList<Double>();
    String name;
    Node positiveNode;
    Node negativeNode;
    double current;
    double resCurrent;

    protected int unionIndex;
    int positiveNodeIndex = 0;
    int negativeNodeIndex = 0;

    public Element(String elemName, Node pN, Node nN) {
        name = elemName;
        positiveNode = pN;
        negativeNode = nN;
        this.current = 0;
        this.resCurrent = 0;

        // Initialize currentList
        currentList = new ArrayList<Double>();
        currentList.add(0.00);
    }


    public void setUnionIndex(int index) {
        unionIndex = index;
    }
    
    public double getVoltage(double time) {
        return positiveNode.getVoltage() - negativeNode.getVoltage();
    }

    public double getCurrent(double time) {
        return 0;
    }

    public double getCurrentFromNegativeNode(double time) {
        return this.getCurrent(time);
    }

    public double getCurrentFromPositiveNode(double time) {
        return this.getCurrent(time);
    }
}
