public abstract class CirSim {
    public static double Dv;
    public static double Di;
    public static double Dt;
    public static double timeDomain;

    public static void simulate() {
        int n = (int) (timeDomain / Dt);
        for (int i = 0; i < n; i++) {
            calculator(n * Dt);
        }
    }

    public static void calculator(double time) {
        int j = 0;
        while (checkAllDelta()) {
            for (Union union : Circuit.unionList) {
                union.doStep(time);
            }
            j++;
        }
        for (Union union : Circuit.unionList) {
            for (Node node : union.nodeList) {
                node.voltage.add(node.V);
            }
        }
    }

    public static boolean checkAllDelta() {
        boolean isSet = true;
        for (Union union : Circuit.unionList) {
            if (union.delta > 0.01)
                isSet = false;
        }
        return isSet;
    }
}
