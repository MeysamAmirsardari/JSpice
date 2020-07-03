public class VoltageDepCurrentSrc extends Element {
    int refNode1;
    int refNode2;
    double R;

    public VoltageDepCurrentSrc(String[] details) {
        name = details[0].trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        refNode1 = Integer.parseInt(details[3].trim());
        refNode2 = Integer.parseInt(details[4].trim());
        R = Integer.parseInt(details[5].trim());
    }

    @Override
    public double getCurrent(double time) {
        double refVoltage = Circuit.nodeList.get(refNode1).getVoltage() - Circuit.nodeList.get(refNode2).getVoltage();
        return (R * refVoltage);
    }
}
