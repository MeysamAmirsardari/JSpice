public class CurrentDepCurrentSrc extends Element{
    String refElm;
    double R;

    public CurrentDepCurrentSrc(String[] details){
        name = details[0].replaceFirst("[F]","").trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        refElm = details[3].trim();
        R = Double.parseDouble(details[4].trim());
    }

    public void setCurrent(){
        //TODO
    }
}
