public class CurrentSrc extends Element{
    double Ipk;
    double Idc;
    double phase;
    double frequency;

    public CurrentSrc(String[] details){
        name = details[0].replaceFirst("[I]","").trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        Idc = Double.parseDouble(details[3].trim());
        Ipk = Double.parseDouble(details[4].trim());
        frequency = Double.parseDouble(details[5].trim());
        phase = Double.parseDouble(details[6].trim());
    }
}
