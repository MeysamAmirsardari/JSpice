public class CurrentDepCurrentSrc extends Element {
    Element refElm;
    double R;

    public CurrentDepCurrentSrc(String[] details) {
        name = details[0].trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        String refElmName = details[3].trim();
        R = Double.parseDouble(details[4].trim());
        //TODO: finding refElm
    }

    @Override
    public double getCurrent(double time) {
        return (refElm.getCurrent(time) * R);
    }
}
