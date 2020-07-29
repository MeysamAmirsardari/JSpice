package Kernel;

public class CurrentDepVoltageSrc extends Element {
    Element refElm;
    double R;

    public CurrentDepVoltageSrc() {
        super();
    }

    public CurrentDepVoltageSrc(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        String refElmName = details[3].trim();
        R = Double.parseDouble(details[4].trim()); //TODO: code1
        refElm = Circuit.searchInElementList(refElmName);
        if (refElm.equals(null)) {
            //TODO: Error!
        }
    }


    @Override
    public double getVoltage(double time) {
        return (R * refElm.getCurrent(time));
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
            for (Element element : negativeNode.positiveElementList) {
                totalCurrent -= element.getCurrent(time);
            }
            for (Element element : negativeNode.negativeElementList) {
                totalCurrent += element.getCurrent(time);
            }
        } else {
            for (Element element : positiveNode.positiveElementList) {
                totalCurrent -= element.getCurrent(time);
            }
            for (Element element : positiveNode.negativeElementList) {
                totalCurrent += element.getCurrent(time);
            }
        }
        return -1 * totalCurrent;
    }
}
