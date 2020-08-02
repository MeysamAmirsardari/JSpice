package Kernel;

import Kernel.Circuit;
import Kernel.Element;

public class VoltageDepCurrentSrc extends VoltageSrc {
    int refNode1;
    int refNode2;
    double gain;

    public VoltageDepCurrentSrc() {
        super();
    }

    public VoltageDepCurrentSrc(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        refNode1 = Integer.parseInt(details[3].trim());
        refNode2 = Integer.parseInt(details[4].trim());  //TODO: code1
        gain = Integer.parseInt(details[5].trim());
    }

    @Override
    public double getCurrent(double time) {
        double refVoltage = Circuit.nodeList.get(refNode1).getVoltage() - Circuit.nodeList.get(refNode2).getVoltage();
        return (gain * refVoltage);
    }
}
