package Kernel;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Circuit {
    public static ArrayList<Element> elementList = new ArrayList<Element>();
    public static ArrayList<Node> nodeList = new ArrayList<Node>();
    public static ArrayList<Union> unionList = new ArrayList<Union>();
    public static int[][] linkMat = new int[31][31];

    // Simulation determining factors
    public double timeD = 0;
    public double transientTime = 0;
    public double voltageD = 0;
    public double currentD = 0;

    // Element Specific arrayLists
    public ArrayList<Resistor> resList = new ArrayList<Resistor>();
    public ArrayList<Capacitor> capList = new ArrayList<Capacitor>();
    public ArrayList<Inductor> indList = new ArrayList<Inductor>();
    public ArrayList<IdealDiode> diodeList = new ArrayList<>();
    public ArrayList<CurrentSrc> curSrcList = new ArrayList <CurrentSrc>();
    public ArrayList<VoltageSrc> volSrcList = new ArrayList<VoltageSrc>();
    public ArrayList<CurrentDepCurrentSrc> CCCSList = new ArrayList<>();
    public ArrayList<VoltageDepCurrentSrc> VCCSList = new ArrayList<>();
    public ArrayList<CurrentDepVoltageSrc> CCVSList = new ArrayList<>();
    public ArrayList<VoltageDepVoltageSrc> VCVSList = new ArrayList<>();

    // Circuit constructor
    public Circuit(String fileName){
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(fileName);
        }
        catch(FileNotFoundException e){
            System.out.println("Circuit input file not found!");
            System.out.println("Terminating the simulation...");
            System.exit(0);
        }
        if(fileReader.reader()){
            System.out.println("Reading from file successful!");
        }
        else{
            System.out.println("Error in reading the input file from the line above!");
            System.out.println("Terminating the simulation...");
            System.exit(0);
        }


        // Simulation parameters
        timeD = fileReader.t;
        transientTime = fileReader.dt;
        voltageD = fileReader.dv;
        currentD = fileReader.di;

        // Element and Node list
        elementList = fileReader.elemList;
        nodeList = fileReader.nodeList;
        unionList = new ArrayList<Union>();
        linkMat = fileReader.linkMat;

        // Element specific arrayLists
        resList = fileReader.resList;
        capList = fileReader.capList;
        indList = fileReader.indList;
        diodeList = fileReader.diodeList;
        curSrcList = fileReader.curSrcList;
        volSrcList = fileReader.volSrcList;
        CCCSList = fileReader.CCCSList;
        VCCSList = fileReader.VCCSList;
        CCVSList = fileReader.CCVSList;
        VCVSList = fileReader.VCVSList;
    }

    public void makeUnions(){
        CreateUnion union = new CreateUnion(this);
        //union.create();
    }

    public void printUnion(){
        for(int i = 0; i< 40; i++){
            System.out.print("-");
        }
        System.out.println("CIRCUIT DESCRIPTION");
        System.out.println();
        for(int i = 0; i< unionList.size();i++){
            System.out.println("Union "+(i+1)+": ");
            System.out.print("Element names: ");
            for(Element elem: unionList.get(i).elementList){
                System.out.printf("%s\t",elem.name);
            }
            System.out.println();
            System.out.print("Node names: ");
            for(Node node: unionList.get(i).nodeList){
                System.out.printf("%s\t",node.name);
            }
            System.out.printf("\n\n");
        }
        for(int i = 0; i< 40; i++){
            System.out.print("-");
        }
        System.out.println("CIRCUIT DESCRIPTION");
        System.out.println();
    }

    public void printCircuit(){
        for(int i = 0; i< 40; i++){
            System.out.print("-");
        }
        System.out.println("CIRCUIT DESCRIPTION");
        System.out.println();

        // Printing Resistors
        System.out.println("Resistors in the circuit:");
        for(Resistor res: resList){
            System.out.printf("%s\tResistance:%eOhm(s)\t+Node:%s\t-Node:%s\n",res.name,res.resistance,res.positiveNode.name,res.negativeNode.name);
        }
        System.out.println();

        // Printing Capacitors
        System.out.println("Capacitors in the circuit:");
        for(Capacitor cap: capList){
            System.out.printf("%s\tCapacitance:%eFarad(s)\t+Node:%s\t-Node:%s\n",cap.name,cap.capacity,cap.positiveNode.name,cap.negativeNode.name);
        }
        System.out.println();

        // Printing Inductors
        System.out.println("Inductors in the circuit:");
        for(Inductor ind: indList){
            System.out.printf("%s\tInductance:%eHenry(ies)\t+Node:%s\t-Node:%s\n",ind.name,ind.inductance,ind.positiveNode.name,ind.negativeNode.name);
        }
        System.out.println();

        // Printing Diodes
        System.out.println("Ideal Diodes in the circuit:");
        for(IdealDiode diode: diodeList){
            System.out.printf("%s\t+Node:%s\t-Node:%s\n",diode.name,diode.positiveNode.name,diode.negativeNode.name);
        }
        System.out.println();

        // Printing Current Sources List
        System.out.println("Current sources in the circuit:");
        System.out.println("1) Independent current sources:");
        for(CurrentSrc src: curSrcList){
            if(src.Ipk == 0.0){
                System.out.printf("%s\tAmplitude:%eAmpere(s)\t+Node:%s\t-Node:%s\n",src.name,src.Idc,src.positiveNode.name,src.negativeNode.name);
            }
            else {
                System.out.printf("%s\tOffset:%eAmpere(s)\tAmplitude:%eAmpere(s)\tFrequency:%e\tPhase:%e\t+Node:%s\t-Node:%s\n",src.name, src.Idc
                ,src.Ipk,src.frequency,src.phase,src.positiveNode.name,src.negativeNode.name);
            }
        }
        System.out.println("2) Current controlled current sources:");
        for(CurrentDepCurrentSrc src:CCCSList){
            System.out.printf("%s\tGain:%e\t+Node:%s\t-Node:%s\n",src.name,src.gain,src.positiveNode.name,src.negativeNode.name);
        }
        System.out.println("3) Voltage controlled current sources:");
        for(VoltageDepCurrentSrc src:VCCSList){
            System.out.printf("%s\tGain:%e\t+Node:%s\t-Node:%s\n",src.name,src.gain,src.positiveNode.name,src.negativeNode.name);
        }
        System.out.println();

        // Printing Voltage Sources List
        System.out.println("Voltage sources in the circuit:");
        System.out.println("1) Independent voltage sources:");
        for(VoltageSrc src: volSrcList){
            if(src.Vpk == 0.0){
                System.out.printf("%s\tAmplitude:%eVolt(s)\t+Node:%s\t-Node:%s\n",src.name,src.Vdc,src.positiveNode.name,src.negativeNode.name);
            }
            else {
                System.out.printf("%s\tOffset:%eVolt(s)\tAmplitude:%eVolt(s)\tFrequency:%e\tPhase:%e\t+Node:%s\t-Node:%s\n",src.name, src.Vdc
                        ,src.Vpk,src.frequency,src.phase,src.positiveNode.name,src.negativeNode.name);
            }
        }
        System.out.println("2) Current controlled voltage sources:");
        for(CurrentDepVoltageSrc src:CCVSList){
            System.out.printf("%s\tGain:%e\t+Node:%s\t-Node:%s\n",src.name,src.gain,src.positiveNode.name,src.negativeNode.name);
        }
        System.out.println("3) Voltage controlled voltage sources:");
        for(VoltageDepVoltageSrc src:VCVSList){
            System.out.printf("%s\tGain:%e\t+Node:%s\t-Node:%s\n",src.name,src.gain,src.positiveNode.name,src.negativeNode.name);
        }
        for(int i = 0; i< 40; i++){
            System.out.print("-");
        }
        System.out.println();

    }


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
