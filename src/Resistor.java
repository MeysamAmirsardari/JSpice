public class Resistor extends Element {
    double res;

    public Resistor() {
        super();
    }

    public Resistor(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        res = Launcher.stringToDouble(details[3].trim());  //TODO: code1
    }


    @Override
    public double getCurrent(double time) {
        return (this.getVoltage(time) / res);
    }
}
