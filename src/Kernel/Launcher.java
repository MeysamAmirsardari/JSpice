package Kernel;/*
 *   In the name of God
 *   JSpice Electrical circuit simulator
 *   <<<    Summer 1399/2020   >>>
 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        //Preview.main(args);

        //just for test:
        String filePath = "D:\\test2.txt";
        launch(filePath);
    }

    public static void launch(String filePath) throws FileNotFoundException {
        Circuit.nodeList.clear();
        Circuit.elementList.clear();
        Circuit.nodeList.clear();
        Circuit circuit = new Circuit(filePath);

        CirSim.setIndexesForElements();
        Node.setNodesForAllElements();
        Union.setElementListForAllUnions();

        circuit.printCircuit();
        circuit.makeUnions();
        circuit.printUnion();

        CirSim.simulate();
        CirSim.printResults();
    }



}