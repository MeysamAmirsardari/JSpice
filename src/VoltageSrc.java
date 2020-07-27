public class VoltageSrc extends Element {
    double Vpk;
    double Vdc;
    double phase;
    double frequency;

    public VoltageSrc() {
        super();
    }

    public VoltageSrc(String[] details) {
        name = details[0].trim();
        //TODO: node1 = Integer.parseInt(details[1].trim());
        //node2 = Integer.parseInt(details[2].trim());
        Vdc = Double.parseDouble(details[3].trim());
        Vpk = Double.parseDouble(details[4].trim());
        frequency = Double.parseDouble(details[5].trim());
        phase = Double.parseDouble(details[6].trim());
    }

    @Override
    public double getVoltage(double time) {
        if (Vpk != 0.0)
            return (Vdc + (Vpk * Math.sin((time * frequency * (2 * Math.PI)) + phase)));
        else
            return Vdc;
    }
}
