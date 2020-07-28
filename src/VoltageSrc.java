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
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        Vdc = Double.parseDouble(details[3].trim());
        Vpk = Double.parseDouble(details[4].trim());
        frequency = Double.parseDouble(details[5].trim()); //TODO: code1
        phase = Double.parseDouble(details[6].trim());
    }

    @Override
    public double getVoltage(double time) {
        if (Vpk != 0.0)
            return (Vdc + (Vpk * Math.sin((time * frequency * (2 * Math.PI)) + phase)));
        else
            return Vdc;
    }

    @Override
    public double getCurrent(double time) {
        double totalCurrent = 0;
        boolean isItOk = true;
        for (Element element : negativeNode.elementList) {
            if (element.getClass().equals(VoltageSrc.class))
                isItOk = false;
            else if (element.getClass().equals(VoltageDepVoltageSrc.class))
                isItOk = false;
            else if (element.getClass().equals(CurrentDepVoltageSrc.class))
                isItOk = false;
        }
        if (isItOk) {
            for (Element element : negativeNode.elementList) {
                totalCurrent += element.getCurrent(time);
            }
        } else {
            for (Element element : positiveNode.elementList) {
                totalCurrent += element.getCurrent(time);
            }
        }
        return -1 * totalCurrent;
    }
}
