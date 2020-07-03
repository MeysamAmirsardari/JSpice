import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    List<Double> current = new ArrayList<Double>();
    List<Double> voltage = new ArrayList<Double>();
    double deltaV;
    int node1;
    int node2;
    String name;

    public double getCurrent(double time) {
        return 0; //TODO: overRiding for Elements (Based on the value of V not voltageList!)
    }

    public double getVoltage(double time) {
        return (Circuit.nodeList.get(node1).getVoltage() - Circuit.nodeList.get(node2).getVoltage());
    }
}
