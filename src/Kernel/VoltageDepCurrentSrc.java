package Kernel;

import Kernel.Circuit;
import Kernel.Element;

public class VoltageDepCurrentSrc extends CurrentSrc {
    int refNode1;
    int refNode2;
    Node node1;
    Node node2;
    double gain;

    public VoltageDepCurrentSrc() {
        super();
    }

    public VoltageDepCurrentSrc(String name, double gain, Node pN, Node nN, Node pDepNode, Node nDepNode) {
        super(name, pN, nN);
        this.gain = gain;
        refNode1 = Integer.parseInt(pN.name);
        refNode2 = Integer.parseInt(nN.name);
        node1 = pN;
        node2 = nN;
        isDependent = true;
    }

    @Override
    public double getCurrent(double time) {
        double refVoltage = Circuit.nodeList.get(refNode1).getVoltage() - Circuit.nodeList.get(refNode2).getVoltage();
        return (gain * refVoltage);
    }
}
