import java.util.ArrayList;
import java.util.List;

public class Node {
    public static Node ground;
    public boolean added = false;
    public double V;
    public int union;
    boolean internal = true;
    public List<Element> elementList = new ArrayList<Element>();
    public List<Node> adjacentNodes = new ArrayList<Node>();
    public List<Double> voltage = new ArrayList<Double>();

    public double getVoltage() {
        return (voltage.get(voltage.size() - 1));
    }
}
