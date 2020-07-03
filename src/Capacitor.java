public class Capacitor extends Element {
    double capacity;
    double IC = 0;

    Capacitor() {
    }

    public Capacitor(String[] details) {
        name = details[0].trim();
        node1 = Integer.parseInt(details[1].trim());
        node2 = Integer.parseInt(details[2].trim());
        capacity = Launcher.stringToDouble(details[3].trim()); //TODO: code1
    }

    @Override
    public double getCurrent(double time) {
        int lastIndex = voltage.size() - 1;
        return (capacity * (voltage.get(lastIndex) - voltage.get(lastIndex - 1)) / CirSim.Dt);
    }
}
