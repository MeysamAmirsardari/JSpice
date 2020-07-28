package Kernel;

import Kernel.Circuit;

import java.util.ArrayList;

public class CreateUnion {
    public boolean create() {
        Node groundNode = null;
        for (Node node : Circuit.nodeList) {
            if (node.name.equals("0")) {
                groundNode = node;
            }
        }
        if (groundNode == null) {
            System.out.println("No ground in circuit!");
            return false;
        }

        dependantNodeInquiry(groundNode);
        setAllNodeNotAdded();
        ArrayList<Node> tempNodeList = new ArrayList<Node>(Circuit.nodeList);
        // unionAdd(tempNodeList); TODO: method implementation
        return true;
    }

    void setAllNodeNotAdded() {
        for (Node node : Circuit.nodeList) {
            node.isAdded = false;
        }
    }

    void dependantNodeInquiry(Node inNode) {
        // if (inNode.parentNode == null) {
        // inNode.parentNode = inNode;
        // }
        // ArrayList<Kernel.Node> notAddedAdjacentNodeList = new ArrayList<>;
        // for(Kernel.Node adjacentNode: inNode.adjacentNodes){
        // if(!adjacentNode.isAdded){
        // notAddedAdjacentNodeList.add(adjacentNode);
        // for()
        // }
        // }
    }

}