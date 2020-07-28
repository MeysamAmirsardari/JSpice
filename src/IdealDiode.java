public class IdealDiode extends Element{
    public IdealDiode(String[] details){
        name = details[0].trim();
        positiveNodeIndex = Integer.parseInt(details[1].trim());
        negativeNodeIndex = Integer.parseInt(details[2].trim());
    }
}
