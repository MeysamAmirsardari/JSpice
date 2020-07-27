import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Circuit {
    public static List<Element> elementList = new ArrayList<Element>();
    public static List<Node> nodeList = new ArrayList<Node>();
    //public static Node[] nodes = new Node[100];
    public static List<Union> unionList = new ArrayList<Union>();
    public static HashMap<Union, Union> unionMap = new HashMap<>();

}
