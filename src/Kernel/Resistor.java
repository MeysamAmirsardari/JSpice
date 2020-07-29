package Kernel;

import Kernel.Element;
import Kernel.Launcher;

public class Resistor extends Element {
    double res;

    public Resistor() {
        super();
    }

    public Resistor(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        res = Launcher.stringToDouble(details[3].trim());  //TODO: code1
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
