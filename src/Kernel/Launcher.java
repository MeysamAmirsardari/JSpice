package Kernel;/*
 *   In the name of God
 *   JSpice Electrical circuit simulator
 *   <<<    Summer 1399/2020   >>>
 */

import UI.DrawEnvironment;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        DrawEnvironment.Args = args;
        String filePath = "test.txt"; // Using relative address
        launch(filePath);
        CirSim.printResults();

        //DrawEnvironment.makeEnvironment(args);
    }

    public static void launch(String filePath) {

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

    protected static double divideByTenForNTimes(double num, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++)
                num *= 10.0;
        } else if (n < 0) {
            for (int i = n; i < 0; i++) {
                num /= 10.0;
            }
        }
        return num;
    }
}