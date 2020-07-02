public class VoltageDepVoltageSrc extends Element{
    int refNode1;
    int refNode2;
    double R;

    public VoltageDepVoltageSrc(String[] details){
        name = details[0].replaceFirst("[E]","").trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        refNode1 = Integer.parseInt(details[3].trim());
        refNode2 = Integer.parseInt(details[4].trim());
        R = Integer.parseInt(details[5].trim());
    }

    public void setVoltage(){
        deltaV = R*(refNode1-refNode2);
    }
}
