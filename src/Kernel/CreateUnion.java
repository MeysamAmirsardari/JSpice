package Kernel;

import Kernel.Circuit;

import java.util.ArrayList;

public class CreateUnion {
    Circuit circuit;
    public CreateUnion(Circuit circuit){
        this.circuit = circuit;
    }

    public boolean create() {
        Node groundNode = null;
        for (Node node : Circuit.nodeList) {
            if (node.name.equals("0")) {
                groundNode = node;
            }
        }
        if (groundNode == null) {
            System.out.println("No ground found in circuit!!");
            return false;
        }

        setAllNodeNotAdded();
        dependantNodeInquiry(groundNode);
        ArrayList<Node> tempNodeList = new ArrayList<Node>(Circuit.nodeList);
        unionAdd(tempNodeList);
        return true;
    }

    void setAllNodeNotAdded() {
        for (Node node : Circuit.nodeList) {
            node.isAdded = false;
        }
    }

    void unionAdd(ArrayList<Node> nodeList){
        ArrayList<Node> unionStarters = new ArrayList<Node>();

        for(Node node:nodeList){
            if(!isCollection(node) && node.parentNode == node){
                makeUnion(node);
                nodeList.remove(node);
            }
        }
        for(Node node:nodeList){
            if(node.parentNode == node){
                unionStarters.add(node);
            }
        }
        for(Node unionStarter: unionStarters){
            ArrayList<Node> addedNodes = new ArrayList<Node>();
            adjacentSearch(unionStarter,addedNodes, nodeList);
            makeUnion(unionStarter,addedNodes);
        }
    }

    void adjacentSearch(Node node, ArrayList<Node> addedNodes, ArrayList<Node> nodeList){
        for(Node tNode:nodeList){
            if(node.parentNode == node){
                ArrayList<Node> subNodeList = new ArrayList<Node>(nodeList);
                addedNodes.add(tNode);
                subNodeList.remove(tNode);
                adjacentSearch(tNode, addedNodes, subNodeList);
            }
        }
    }

    void makeUnion(Node node){
        Union union = new Union(node);
        Circuit.unionList.add(union);
    }

    void makeUnion(Node unionStarter, ArrayList<Node> addedNodes){
        Union union = new Union(unionStarter, addedNodes);
        Circuit.unionList.add(union);
    }

    boolean isCollection(Node node){
        ArrayList<Node> nodeList = new ArrayList<Node>(Circuit.nodeList);
        nodeList.remove(node);
        for(Node tNode: nodeList){
            if(tNode.parentNode == node)
                return true;
        }
        return false;
    }

    void dependantNodeInquiry(Node inNode) {
        if (inNode.parentNode == null) {
            inNode.parentNode = inNode;
        }
        ArrayList<Node> notAddedAdjacentNodeList = new ArrayList<Node>();
        for(Node adjacentNode: inNode.adjacentNodes){
        if(!adjacentNode.isAdded){
        notAddedAdjacentNodeList.add(adjacentNode);
        for(VoltageSrc vSrc : circuit.volSrcList){
            if((vSrc.positiveNode == inNode && vSrc.negativeNode == adjacentNode) || 
            (vSrc.negativeNode == inNode && vSrc.positiveNode == adjacentNode)){
                if(adjacentNode.parentNode == null){
                    adjacentNode.parentNode = inNode;
                }
                else{
                    inNode.parentNode = adjacentNode;
                }
            }
        }
        }
        }
        inNode.isAdded = true;
        for(Node node: notAddedAdjacentNodeList){
            dependantNodeInquiry(node);
        }
    }

}