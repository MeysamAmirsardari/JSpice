import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    List<Double> currentList = new ArrayList<Double>();
    List<Double> voltageList = new ArrayList<Double>();
    String name;
    protected int unionIndex;
    Node positiveNode;
    Node negativeNode;
    int positiveNodeIndex = 0;
    int negativeNodeIndex = 0;

    public Element() {
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
    }

    public double getVoltage(double time) {
        return positiveNode.getVoltage() - negativeNode.getVoltage();
    }
}
