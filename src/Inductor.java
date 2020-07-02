public class Inductor extends Element{
    String ind;
    double IC=0;

    public Inductor(String[] details){
        name = details[0].replaceFirst("[L]","").trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        ind = details[3].trim();
    }
}
