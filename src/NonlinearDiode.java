public class NonlinearDiode extends Element{
    public NonlinearDiode(String[] details){
        name = details[0].trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
    }
}
