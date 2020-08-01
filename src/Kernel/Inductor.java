package Kernel;

import Kernel.CirSim;
import Kernel.Element;

public class Inductor extends Element {
    double ind;
    double IC = 0;

    public Inductor(String name, double val, Node pNode, Node nNode) {
        super(name,pNode,nNode);
        ind = val;
    }

    @Override
    public double getCurrent(double time) {
        double sum = this.voltageIntegratorFrom0();
        return (IC + (1 / ind) * sum);
    }

    @Override
    public double getCurrentFromNegativeNode(double time) {
        double sum = this.voltageIntegratorFrom0() + ((positiveNode.getLastVoltage() - negativeNode.tempV) * CirSim.Dt);
        return (IC + (1 / ind) * sum);
    }

    @Override
    public double getCurrentFromPositiveNode(double time) {
        double sum = this.voltageIntegratorFrom0() + ((positiveNode.tempV - negativeNode.getLastVoltage()) * CirSim.Dt);
        return (IC + (1 / ind) * sum);
    }

    public double voltageIntegratorFrom0() {
        double sum = 0;
        for (Double volt : voltageList) {
            sum += (volt * CirSim.Dt);
        }
        return sum;
    }
}
