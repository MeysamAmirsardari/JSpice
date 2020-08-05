package Kernel;/*
 *   In the name of God
 *   JSpice Electrical circuit simulator
 *   <<<    Summer 1399/2020   >>>
 *   Meysam Amirsardari + Amirmahdi Soleimanifar
 */

import UI.Preview;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        Preview.show(args);

        //just for test:
        //String filePath = "D:\\Diode_circuit.txt";
        //launch(filePath);
    }

    public static void launch(String filePath) throws FileNotFoundException {
        Circuit.nodeList.clear();
        Circuit.elementList.clear();
        Circuit.nodeList.clear();
        Circuit.diodeList.clear();
        Circuit circuit = new Circuit(filePath);
        circuit.printCircuit();
        CirSim.simulate(circuit);
        circuit.printUnion();
        CirSim.arrange();
        CirSim.printResults();
    }

}