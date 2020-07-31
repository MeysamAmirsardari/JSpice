package Kernel;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    ArrayList<Double> currentList = new ArrayList<Double>();
    ArrayList<Double> voltageList = new ArrayList<Double>();
    final String name; // Element cannot alter its type after initialization
    Node positiveNode;
    Node negativeNode;
    // Declare variable current to hold the latest element of currentList
    double current;

    protected int unionIndex;
    int positiveNodeIndex = 0;
    int negativeNodeIndex = 0;

    // Element Constructor
    public Element(String elemName, Node pN, Node nN) {
        name = elemName;
        positiveNode = pN;
        negativeNode = nN;
        this.current = 0;
        
        // Initialize currentList and voltageList
        currentList = new ArrayList<Double>();
        voltageList = new ArrayList<Double>();
    }


    public void setUnionIndex(int index) {
        unionIndex = index;
    }
    
    // Voltage related methods
    public double getVoltage(double time) {
        return positiveNode.getVoltage() - negativeNode.getVoltage();
    }
    
    // Current related methods
    public double getCurrent(Node node){
        if(positiveNode.name.equals(node.name)){
            return current;
        }
        else if(negativeNode.name.equals(negativeNode.name)){
            return current * -1;
        }
        else{
            System.out.println("This condition should not happen!");
            return  0; // Control current for errors
        }
    }

    public double getCurrent(double time) {
        return 0;
        // TODO: getCurrent Implementation (I THINK!!)
    }

    public ArrayList<Double> getCurrentList(){
        return currentList;
    }

    public double getCurrentFromNegativeNode(double time) {
        return this.getCurrent(time) * -1;
    }

    public double getCurrentFromPositiveNode(double time) {
        return this.getCurrent(time);
    }
}
