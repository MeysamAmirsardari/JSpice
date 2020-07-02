public abstract class Element {
    double deltaV;
    double current;
    int node1;
    int node2;
    String name;
    int num;

    public void setCurrent(){}
    public void setDeltaV(){deltaV = Circuit.nodeList.get(node1).voltage - Circuit.nodeList.get(node2).voltage;}
}
