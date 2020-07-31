package Kernel;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Circuit {
    public static ArrayList<Element> elementList = new ArrayList<Element>();
    public static ArrayList<Node> nodeList = new ArrayList<Node>();
    public static ArrayList<Union> unionList = new ArrayList<Union>();
    public static HashMap<Union, Union> unionMap = new HashMap<>();
    
    // Simulation determining factors
    public double timeD = 0;
    public double transientTime = 0;
    public double voltageD = 0;
    public double currentD = 0;


    // Element Specific arrayLists
    public static ArrayList<Resistor> resList = new ArrayList<Resistor>();
    public static ArrayList<Capacitor> capList = new ArrayList<Capacitor>();
    public static ArrayList<Inductor> indList = new ArrayList<Inductor>();
    public static ArrayList<CurrentSrc> curList = new ArrayList <CurrentSrc>();
    public static ArrayList<VoltageSrc> volList = new ArrayList<VoltageSrc>();


    public static Node returnNode(String name){
        for(Node node:nodeList){
            if(node.name.equals(name))
                return node;
        }
        return null;
    }

    public static Element searchInElementList(String name) {
        for (Element element : elementList) {
            if (element.getName().equals(name))
                return element;
        }
        return null;
    }
}
