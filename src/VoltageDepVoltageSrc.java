public class VoltageDepVoltageSrc extends Element {
    int refNode1;
    int refNode2;
    double R;

    public VoltageDepVoltageSrc() {
        super();
    }

    public VoltageDepVoltageSrc(String[] details) {
        name = details[0].trim();
        //TODO:node1 = Integer.parseInt(details[1].trim());
        //node2 = Integer.parseInt(details[2].trim());
        refNode1 = Integer.parseInt(details[3].trim());
        refNode2 = Integer.parseInt(details[4].trim());
        R = Integer.parseInt(details[5].trim());
    }

    @Override
    public double getVoltage(double time) {
        double refVoltage = Circuit.nodeList.get(refNode1).getVoltage() - Circuit.nodeList.get(refNode2).getVoltage();
        return (R * refVoltage);
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
