public class VoltageDepCurrentSrc extends Element{
    String refElm;
    double R;

    public VoltageDepCurrentSrc(String[] details){
        name = details[0].replaceFirst("[G]","").trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        refElm = details[3].trim();
        R = Double.parseDouble(details[4].trim());
    }

    public void setCurrent(){
        //TODO
    }
}
