public class CurrentDepVoltageSrc extends Element {
    Element refElm;
    double R;

    public CurrentDepVoltageSrc() {
        super();
    }

    public CurrentDepVoltageSrc(String[] details) {
        name = details[0].trim();
        //node1 = Integer.parseInt(details[1].trim());
        //node2 = Integer.parseInt(details[2].trim());
        String refElmName = details[3].trim();
        R = Double.parseDouble(details[4].trim());
        //TODO: finding refElm
    }


    @Override
    public double getVoltage(double time) {
        return (R * refElm.getCurrent(time));
    }

    @Override
    public double getCurrent(double time) {
        return super.getCurrent(time);
        //TODO
    }
}
