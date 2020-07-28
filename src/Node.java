import java.util.ArrayList;
import java.util.List;

public class Node {
    public static Node ground;
    public boolean isAdded = false;
    public Node parentNode = null;
    public int union;
    protected double V;
    boolean internal = true;
    public int index;
    public String name;
    public Union belongUnion;

    public List<Element> elementList = new ArrayList<Element>();
    public List<Node> adjacentNodes = new ArrayList<Node>();
    public List<Double> voltageList = new ArrayList<Double>();

    Node(String givenName) {
        name = givenName;
    }

    Node() {
    }

    public double getV() {
        return V;
    }

    public void setV(double inputV) {
        this.V = inputV;
    }

    public double getVoltage() {
        return (voltageList.get(voltageList.size() - 1));
    }

    protected static void setNodesForAllElements() {
        creatNodeList();
        for (Element element : Circuit.elementList) {
            element.negativeNode = Circuit.nodeList.get(element.negativeNodeIndex);
            element.positiveNode = Circuit.nodeList.get(element.positiveNodeIndex);
        }
    }

    protected static void creatNodeList() {
        int maxIndex = 0;
        for (Element element : Circuit.elementList) {
            if (maxIndex < element.negativeNodeIndex)
                maxIndex = Math.max(element.negativeNodeIndex, element.positiveNodeIndex);
        }
        for (int i = 0; i < maxIndex + 1; i++) {
            Node node = new Node();
            Circuit.nodeList.add(node);
        }
    }
}
