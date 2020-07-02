import java.util.ArrayList;
import java.util.List;

public class Node {
    public static Node ground;

    protected double voltage;
    public int union;
    public boolean added = false;
    boolean internal = true;
    public List<Element> elements = new ArrayList<Element>();
    public List<Node> adjacentNodes = new ArrayList<Node>();

    public void setVoltage(double input){
        voltage = input;
    }
}
