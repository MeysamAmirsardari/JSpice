import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    List<Double> currentList = new ArrayList<Double>();
    List<Double> voltageList = new ArrayList<Double>();
    String name;
    double deltaV;
    double current;
    Node positiveNode;
    Node negativeNode;

    Element(String elemName, Node pN, Node nN) {
        name = elemName;
        positiveNode = pN;
        negativeNode = nN;
        current = 0;
    }

    public double getCurrent(double time) {
        return 0;
        // TODO: overRiding for Elements (Based on the value of V not voltageList!)
    }

    public double getVoltage(double time) {
        return positiveNode.voltage - negativeNode.voltage;
    }

}
