package Kernel;/*
 *   In the name of God
 *   JSpice Electrical circuit simulator
 *   <<<    Summer 1399/2020   >>>
 */

import UI.DrawEnvironment;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        DrawEnvironment.Args = args;
        String filePath = "D:\\test1.txt"; // Using relative address
        launch(filePath);
        CirSim.printResults();

        //DrawEnvironment.makeEnvironment(args);
    }

    public static void launch(String filePath) throws FileNotFoundException {
        FileReader reader = new FileReader(filePath);
        CirSim.Dt = reader.dt;
        CirSim.Dv = reader.dv;
        CirSim.Di = reader.di;
        CirSim.timeDomain = reader.t;
        Circuit.elementList = reader.elemList;
        Circuit.nodeList = reader.nodeList;
        Circuit circuit = new Circuit(filePath);
        circuit.printCircuit();
        circuit.makeUnions();
        circuit.printUnion();

        Node.setNodesForAllElements();
        //TODO: unionharo koo pas?
        // Hame etela'at dakhele object circuit ke shakhtam
        Union.setElementListForAllUnions();
        //TODO: getting Inputs from user.
        CirSim.simulate();
    }

}