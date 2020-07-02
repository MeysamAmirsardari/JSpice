public class Resistor extends Element{
    String res;

    public Resistor(String[] details){
        name = details[0].replaceFirst("[R]","").trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        res = details[3].trim();
    }
}
