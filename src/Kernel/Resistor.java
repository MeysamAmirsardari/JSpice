package Kernel;

import Kernel.Element;
import Kernel.Launcher;

public class Resistor extends Element {
    double res;

    public Resistor(String name, double val, Node pNode, Node nNode) {
        super(name,pNode,nNode);
        res = val;
    }

    @Override
    public double getCurrent(double time) {
        return (this.getVoltage(time) / res);
    }

    @Override
    public double getCurrentFromNegativeNode(double time) {
        return ((positiveNode.getLastVoltage() - negativeNode.tempV) / res);
    }

    @Override
    public double getCurrentFromPositiveNode(double time) {
        return ((positiveNode.tempV - negativeNode.getLastVoltage()) / res);
    }
}
