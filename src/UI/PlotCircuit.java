package UI;

import Kernel.Circuit;
import Kernel.Element;
import Kernel.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PlotCircuit {
    public static void plot(Pane pane){
        Dot [][] dot = new Dot[6][6];
        pane.getChildren().clear();
        // Plotting ground
        for(int i = 0; i < 6; i++){
            dot[0][i] = new Dot(25+i*50,325,0);
        }
        Label label;
        HashMap<Byte, Dot> dotMap = new HashMap();
        // Plotting non-ground dots in the circuit
        for(int i =1; i < 6; i++){
            for(int j = 0;j< 6;j++){
                dot[i][j] = new Dot(25+i*50,325-50*j,6*i+j-5);
                dotMap.put((byte)dot[i][j].num,dot[i][j]);
                label = new Label(Integer.toString(dot[i][j].num));
                label.setTextFill(Color.CRIMSON);
                label.setFont(new Font(10));
                label.setLayoutX(dot[i][j].x+5);
                label.setLayoutY(dot[i][j].y-5);
                pane.getChildren().add(label);
            }
        }
        boolean goodNode;
        int[] connectCount;
        ArrayList<Element> tempElem = new ArrayList<>();
        ArrayList<Byte> collectionElem = new ArrayList<>();
        Dot pDot, nDot, dot1,dot2;
        for(Node node: Circuit.nodeList){
            tempElem = node.elementList;
            goodNode = true;
            connectCount = Circuit.linkMat[Integer.parseInt(node.name)];
            for(byte i = 0; i<31;i++){
                if(connectCount[i] >=2){
                    collectionElem.add(i);
                    goodNode = false;
                }
            }
            if(!goodNode){
                // We are told that in case of parallel elements, there will be at most 3 parallel elements so the code is based on this fact
                for(Byte num: collectionElem){
                    Dot dot00,dot01,dot10,dot11;
                    int counter = 0;
                    if(Integer.parseInt(node.name)==0){
                        dot1 = dot[0][(num-1)%6];
                    }
                    else{
                        dot1 = dotMap.get(Integer.parseInt(node.name));
                    }
                    if(Integer.parseInt(node.name)==0){
                        dot2 = dot[0][(Integer.parseInt(node.name)-1)%6];
                    }
                    else{
                        dot2 = dotMap.get(num);
                    }
                    if(num==0 || Integer.parseInt(node.name) == 0 || Math.abs(num - Integer.parseInt(node.name))%6==0){
                        dot00 = new Dot(dot1.x-6,dot1.y,dot1.num);
                        dot10 = new Dot(dot2.x-6,dot2.y,dot2.num);
                        dot01 = new Dot(dot1.x+6,dot1.y,dot1.num);
                        dot11 = new Dot(dot2.x+6,dot2.y,dot2.num);
                    }
                    else{
                        dot00 = new Dot(dot1.x,dot1.y-6,dot1.num);
                        dot10 = new Dot(dot2.x,dot2.y-6,dot2.num);
                        dot01 = new Dot(dot1.x,dot1.y+6,dot1.num);
                        dot11 = new Dot(dot2.x,dot2.y+6,dot2.num);
                    }
                    for(Element elem: tempElem){
                        pDot = nDot = null;
                        if(Integer.parseInt(elem.positiveNode.name) == num &&
                        Integer.parseInt(node.name) == Integer.parseInt(elem.negativeNode.name)){
                            if(counter == 0){
                                nDot = dot00;
                                pDot = dot10;
                            }
                            else if(counter == 1){
                                nDot = dot01;
                                pDot = dot11;
                            }
                            counter++;
                        }
                        else if(num == Integer.parseInt(elem.negativeNode.name) &&
                        Integer.parseInt(node.name) == Integer.parseInt(elem.positiveNode.name)){
                            if(counter == 0){
                                nDot = dot10;
                                pDot = dot00;
                            }
                            else if(counter == 1){
                                nDot = dot11;
                                pDot = dot01;
                            }
                            counter++;
                        }
                        if(counter == 1){
                            DrawElement.drawWire(pane,dot1,dot00,Color.BLACK);
                            DrawElement.drawWire(pane,dot2,dot10,Color.BLACK);
                        }
                        if(counter==2){
                            DrawElement.drawWire(pane,dot1,dot01,Color.BLACK);
                            DrawElement.drawWire(pane,dot2,dot11,Color.BLACK);
                        }
                        if(pDot!=null && nDot != null){
                            DrawElement.draw(elem.type,pane,pDot,nDot,Color.BLACK);
                            label = new Label(elem.name);
                            label.setTextFill(Color.CRIMSON);
                            label.setFont(new Font(10));
                            label.setLayoutX(((pDot.x+nDot.x)/2)+5);
                            label.setLayoutY(((pDot.y+nDot.y)/2)+5);
                            pane.getChildren().add(label);
                        }
                    }
                }
            }
            else{
                // We now know there are no parallel elements connected to the node
                for(Element elem: Circuit.elementList){
                    if(Integer.parseInt(elem.negativeNode.name) == 0){
                        nDot = dot[0][(Integer.parseInt(elem.positiveNode.name)-1) % 6];
                    }
                    else{
                        nDot = dotMap.get(Byte.parseByte(elem.negativeNode.name));
                    }
                    if(Integer.parseInt(elem.positiveNode.name) == 0){
                        pDot = dot[0][(Integer.parseInt(elem.negativeNode.name)-1) % 6];
                    }
                    else{
                        pDot = dotMap.get(Byte.parseByte(elem.positiveNode.name));
                    }
                    DrawElement.draw(elem.type,pane,pDot,nDot,Color.BLACK);
                    label = new Label(elem.name);
                    label.setTextFill(Color.CRIMSON);
                    label.setFont(new Font(10));
                    label.setLayoutX(((pDot.x+nDot.x)/2)+5);
                    label.setLayoutY(((pDot.y+nDot.y)/2)+5);
                    pane.getChildren().add(label);
                }
            }
        }

    }
}
