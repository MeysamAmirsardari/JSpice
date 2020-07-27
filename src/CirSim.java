public abstract class CirSim {
    public static double Dv;
    public static double Di;
    public static double Dt;
    public static double timeDomain;

    public static void simulate() {
        int n = (int) (timeDomain / Dt);
        for (int i = 0; i < n; i++) {
            solver(n * Dt);
        }
    }

    private static void solver(double time) {
        for (Union union : Circuit.unionList) {
            union.doStep(time);
            for (Node node : union.nodeList) {
                node.voltageList.add(node.getV());
            }
        }
        updateElementsDetails(time);
    }

    private static void updateElementsDetails(double time) {
        for (Element element : Circuit.elementList) {
            element.voltageList.add(element.getVoltage(time));
            element.currentList.add(element.getCurrent(time));
        }
    }

    private static boolean checkAllDeltas() {
        boolean isSet = true;
        for (Union union : Circuit.unionList) {
            if (union.delta > 0.1)
                isSet = false;
        }
        return isSet;
    }
}
