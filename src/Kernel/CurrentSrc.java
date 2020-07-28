package Kernel;

public class CurrentSrc extends Element {
    double Ipk;
    double Idc;
    double phase;
    double frequency;

    public CurrentSrc() {
        super();
    }

    public CurrentSrc(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        Idc = Double.parseDouble(details[3].trim());
        Ipk = Double.parseDouble(details[4].trim());
        frequency = Double.parseDouble(details[5].trim());
        phase = Double.parseDouble(details[6].trim()); //TODO: code1
    }

    @Override
    public double getCurrent(double time) {
        if (Ipk != 0.0)
            return (Idc + (Ipk * Math.sin((time * frequency * (2 * Math.PI)) + phase)));
        else
            return Idc;
    }
}
