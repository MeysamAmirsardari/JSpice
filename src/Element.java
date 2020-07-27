import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    List<Double> currentList = new ArrayList<Double>();
    List<Double> voltageList = new ArrayList<Double>();
    String name;
    protected int unionIndex;
    protected double deltaV;
    Node positiveNode;
    Node negativeNode;

    public Element() {
    }

    public double getDeltaV() {
        return deltaV;
    }

    public void setDeltaV(double dv) {
        deltaV = dv;
    }

    public void setUnionIndex(int index) {
        unionIndex = index;
    }

    Element(String elemName, Node pN, Node nN) {
        name = elemName;
        positiveNode = pN;
        negativeNode = nN;
    }

    public double getCurrent(double time) {
        return 0;
        // TODO: overRiding for Elements (Based on the value of V not voltageList!)
    }

    public double getVoltage(double time) {
        return positiveNode.getVoltage() - negativeNode.getVoltage();
    }
}
