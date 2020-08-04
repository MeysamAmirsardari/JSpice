package Kernel;

import Kernel.Element;

public class IdealDiode extends Element {
    public IdealDiode(String name, double val, Node pNode, Node nNode) {
        super(name, pNode, nNode);
        type = "DIODE";
    }
}
