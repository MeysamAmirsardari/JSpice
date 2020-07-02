public class Capacitor extends Element {
    String capacity;
    double  IC=0;

    Capacitor(){}

    public Capacitor(String[] details){
        name = details[0].replaceFirst("[C]","").trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        capacity = details[3].trim();
    }

}
