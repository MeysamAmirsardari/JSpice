package Kernel;

import Kernel.CirSim;
import Kernel.Element;

public class Inductor extends Element {
    double ind;
    double IC = 0;

    public Inductor() {
        super();
    }

    public Inductor(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        ind = Launcher.stringToDouble(details[3].trim()); //TODO: code1
    }

    @Override
    public double getCurrent(double time) {
        double sum = this.integratorFrom0();
        return (IC + (1 / ind) * sum);
    }

    public double integratorFrom0() {
        double sum = 0;
        for (Double volt : voltageList) {
            sum += (volt * CirSim.Dt);
        }
        return sum;
    }
}
