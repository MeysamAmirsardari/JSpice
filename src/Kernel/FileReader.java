package Kernel;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.regex.Pattern.*;

public class FileReader {
    // The interval values of time, voltage and current
    public double dt = 0;
    public double t = 0;
    public double dv = 0;
    public double di = 0;

    // Arrays of elements and nodes
    public ArrayList<VoltageSrc> VSrcList = new ArrayList<VoltageSrc>();
    public ArrayList<Element> elemList = new ArrayList<Element>();
    public ArrayList<Node> nodeList = new ArrayList<Node>();

    // Constructor of FileReader
    Scanner sc;
    public FileReader(File file) throws FileNotFoundException{
        sc = new Scanner(file);
    }

    public double numProcess(String string, String line){

        Pattern num = Pattern.compile("[+-]?\\d(\\.\\d+)?");
        Matcher numVal = num.matcher(string);
        Pattern error = Pattern.compile("[a-zA-z]");
        Matcher errVal = error.matcher(string);
        Pattern suffix = Pattern.compile("[GMkmunp]");
        Matcher sufVal = suffix.matcher(string);

        double value = Double.parseDouble(numVal.group());
        String sufStr = sufVal.group();
        if(!sufStr.equals(errVal.group())){
            // READING EXCEPTION
        }
        else{
            if(sufVal.equals("G")){
                value *= Math.pow(10,9);
            }
            else if(sufVal.equals("M")){
                value *= Math.pow(10,6);
            }
            else if(sufVal.equals("k")){
                value *= Math.pow(10,3);
            }
            else if(sufVal.equals("m")){
                value *= Math.pow(10,-3);
            }
            else if(sufVal.equals("u")){
                value *= Math.pow(10,-6);
            }
            else if(sufVal.equals("n")){
                value *= Math.pow(10,-9);
            }
            else if(sufVal.equals("p")){
                value *= Math.pow(10,-12);
            }
        }
        return value;
    }

    public void reader(){
        double val;
        boolean readEnd = false;
        String line;
        while((readEnd == false) && sc.hasNextLine()){
            line = sc.nextLine();
            if(line.startsWith("*")){
                // Comment Line: No Action Needed
            }
            else{
                String[] input = line.split("\\s+");
                int num = input.length;
                // Case where we are determining conditions of simulation or creating elements
                if(num < 2){
                    // READING EXCEPTION
                }
                else if(num == 2){
                    double val = numProcess(input[1], line);
                    if(val >= 0){
                        if(input[0].equals("dt") || input[0].equals("dT")){
                            dt = val;
                        }
                        else if(input[0].equals("dv") || input[0].equals("dV")){
                            dv = val;
                        }
                        else if(input[0].equals("di") || input[0].equals("dI")){
                            di = val;
                        }
                        else if(input[0].equals(".tran")){
                            t = val;
                            readEnd = true;
                            break;
                        }
                        else {
                            // READING EXCEPTION
                        }
                    }
                    else{
                        // READING EXCEPTION
                    }
                }
                else if(num > 2){
                    Node pN, nN;
                    String elemName = input[0];
                    String pTName = input[1];
                    String nTName = input[2];
                    for(int i = 0; i< elemList.size();i++){
                        if(elemName.equals(elemList.get(i).name)){
                            // READING EXCEPTION
                        }
                    }
                    boolean pFound = false;
                    boolean nFound = false;
                    // IDE Gives warning for uninitialized objects
                    pN = null;
                    nN = null;
                    for(int i = 0; i< nodeList.size();i++){
                        if(pTName.equals(nodeList.get(i).name)){
                            pN = nodeList.get(i);
                            pFound = true;
                        }
                        if(nTName.equals(nodeList.get(i).name)){
                            nN = nodeList.get(i);
                            nFound = true;
                        }
                    }
                    if(!pFound || !nFound){
                        if(!pFound){
                            pN = new Node(pTName);
                            nodeList.add(pN);
                        }
                        if(!nFound){
                            nN = new Node(nTName);
                            nodeList.add(nN);
                        }
                    }
                    if(pN.adjacentNodes.contains(nN) == false) {
                        pN.adjacentNodes.add(nN);
                        nN.adjacentNodes.add(pN);
                    }

                    // The condition for passive elements
                    if(num == 4){
                        val = numProcess(input[3],line);
                        if(input[0].startsWith("r") || input[0].startsWith("R")){
                            if(val<0){
                                // READING EXCEPTION
                            }
                            Resistor resistor = new Resistor(elemName,val,pN, nN);
                            elemList.add(resistor);
                            pN.elementList.add(resistor);
                            nN.elementList.add(resistor);
                        }
                        else if(input[0].startsWith("c") || input[0].startsWith("C")){
                            if(val<0){
                                // READING EXCEPTION
                            }
                            Capacitor capacitor = new Capacitor(elemName,val,pN, nN);
                            elemList.add(capacitor);
                            pN.elementList.add(capacitor);
                            nN.elementList.add(capacitor);
                        }
                        else if(input[0].startsWith("i") || input[0].startsWith("I")){
                            if(val<0){
                                // READING EXCEPTION
                            }
                            Inductor inductor = new Inductor(elemName,val,pN, nN);
                            elemList.add(inductor);
                            pN.elementList.add(inductor);
                            nN.elementList.add(inductor);
                        } else if(input[0].startsWith("d") || input[0].startsWith("D")){
                            if(val<0){
                                // READING EXCEPTION
                            }
                            IdealDiode idealDiode = new IdealDiode(elemName,val,pN, nN);
                            elemList.add(idealDiode);
                            pN.elementList.add(idealDiode);
                            nN.elementList.add(idealDiode);
                        }
                    }
                }
            }
        }
    }

}