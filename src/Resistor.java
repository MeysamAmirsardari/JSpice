public class Resistor extends Element {
    double res;

    public Resistor() {
        super();
    }

    public Resistor(String[] details) {
        name = details[0].trim();
        //TODO: node1 = Integer.parseInt(details[1].trim());
        //node2 = Integer.parseInt(details[2].trim());
        res = Launcher.stringToDouble(details[3].trim());
    }


    @Override
    public double getCurrent(double time) {
        return (this.getVoltage(time) / res);
    }
}
