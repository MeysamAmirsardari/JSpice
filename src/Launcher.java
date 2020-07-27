/*
 *   In the name of God
 *   JSpice Electrical circuit simulator
 *   <<<    Summer 1399/2020   >>>
 */

public class Launcher {
    public static void main(String[] args) {
        Initialize.fileReader();
        //TODO: unionharo koo pas?
        Union.setElementListForAllUnions();
        //TODO: getting Inputs from user.
        CirSim.simulate();
        CirSim.printResults();
    }

    public static double stringToDouble(String input) { //TODO: code1
        double num = Double.parseDouble(input.replaceAll("\\w+", ""));
        String suffix = input.replaceAll("\\W+", "");
        double a;

        if (suffix.equals("d")) {
            a = divideByTenForNTimes(num, -1);
        } else if (suffix.equals("c")) {
            a = divideByTenForNTimes(num, -2);
        } else if (suffix.equals("m")) {
            a = divideByTenForNTimes(num, -3);
        } else if (suffix.equals("u")) {
            a = divideByTenForNTimes(num, -6);
        } else if (suffix.equals("n")) {
            a = divideByTenForNTimes(num, -9);
        } else if (suffix.equals("p")) {
            a = divideByTenForNTimes(num, -12);
        } else if (suffix.equals("da")) {
            a = divideByTenForNTimes(num, 1);
        } else if (suffix.equals("h")) {
            a = divideByTenForNTimes(num, 2);
        } else if (suffix.equals("k")) {
            a = divideByTenForNTimes(num, 3);
        } else if (suffix.equals("M")) {
            a = divideByTenForNTimes(num, 6);
        } else if (suffix.equals("G")) {
            a = divideByTenForNTimes(num, 9);
        } else if (suffix.equals("T")) {
            a = divideByTenForNTimes(num, 12);
        } else {
            //TODO: Error!
            return Double.parseDouble(null);
        }
        return a;
    }

    public static double divideByTenForNTimes(double num, int n) {
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