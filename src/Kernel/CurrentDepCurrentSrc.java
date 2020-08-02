package Kernel;

import Kernel.Circuit;

public class CurrentDepCurrentSrc extends CurrentSrc {
    Element refElm;
    double gain;

    public CurrentDepCurrentSrc() {
        super();
    }

    public CurrentDepCurrentSrc(String[] details) {
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
        String refElmName = details[3].trim();
        gain = Double.parseDouble(details[4].trim()); //TODO: code1
        refElm = Circuit.searchInElementList(refElmName);
        if (refElm.equals(null)) {
            //TODO: Error!
        }
    }

    @Override
    public double getCurrent(double time) {
        return (refElm.getCurrent(time) * gain);
    }
}
