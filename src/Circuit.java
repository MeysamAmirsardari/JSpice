import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Circuit {
    public static List<Element> elementList = new ArrayList<Element>();
    public static List<Node> nodeList = new ArrayList<Node>();
    public static List<Union> unionList = new ArrayList<Union>();
    public static HashMap<Union, Union> unionMap = new HashMap<>();

    public static Element searchInElementList(String name) {
        for (Element element : elementList) {
            if (element.name.equals(name))
                return element;
        }
        return null;
    }
}
