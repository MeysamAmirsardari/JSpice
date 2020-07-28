public class CurrentDepCurrentSrc extends Element {
    Element refElm;
    double R;

    public CurrentDepCurrentSrc() {
        super();
    }

    public CurrentDepCurrentSrc(String[] details) {
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
    public double getCurrent(double time) {
        return (refElm.getCurrent(time) * R);
    }
}
