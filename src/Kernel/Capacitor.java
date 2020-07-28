package Kernel;

import Kernel.CirSim;
import Kernel.Element;
import Kernel.Launcher;

public class Capacitor extends Element {
    double capacity;
    double IC = 0;

    public Capacitor() {
        super();
    }

    public Capacitor(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        capacity = Launcher.stringToDouble(details[3].trim()); //TODO: code1
    }

    @Override
    public double getCurrent(double time) {
        int lastIndex = voltageList.size() - 1;
        return (capacity * (voltageList.get(lastIndex) - voltageList.get(lastIndex - 1)) / CirSim.Dt);
    }
}