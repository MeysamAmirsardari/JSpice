import java.util.ArrayList;
import java.util.List;

public class Union {
    public List<Node> nodeList = new ArrayList<Node>();
    public List<Element> elementList = new ArrayList<Element>();
    public boolean visited = false;
    public ArrayList<Double> voltage = new ArrayList<Double>();
    public double V;
    public double I_total1;
    public double I_total2;
    public double delta;

    public static void setElementListForAllUnions() {
        for (Union union : Circuit.unionList) {
            for (Node node : union.nodeList) {
                for (Element element : node.elementList) {
                    union.elementList.add(element);
                }
            }
        }
    }

    public double getTotalCurrent(double time) {
        double i = 0;
        for (Element element : elementList) {
            i += element.getCurrent(time);
        }
        return i;
    }

    public void doStep(double time) {
        double Dv = CirSim.Dv;
        double Di = CirSim.Di;
        I_total1 = this.getTotalCurrent(time);
        V += Dv;
        this.setV_ForAllNodes(V);
        I_total2 = this.getTotalCurrent(time);
        delta = ((Math.abs(I_total1) - Math.abs(I_total2)) * Dv) / Di;
        V += delta;
        this.setV_ForAllNodes(V);
    }

    private void setV_ForAllNodes(Double V) {
        for (Node node : nodeList) {
            node.V = V;
        }
    }
}
