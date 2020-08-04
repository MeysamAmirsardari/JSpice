package UI;

import Kernel.Element;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;

public class DrawElement {
    public static void draw(String type, Pane pane, Dot pDot, Dot nDot, Paint color) {
        if (type != null) {
            switch (type) {
                case "CAP":
                    drawCap(pane, pDot, nDot, color);
                    break;
                case "RES":
                    drawRes(pane, pDot, nDot, color);
                    break;
                case "IND":
                    drawInd(pane, pDot, nDot, color);
                    break;
                case "DIODE":
                    drawDiode(pane, pDot, nDot, color);
                    break;
                case "VOLSRC":
                    drawVolSrc(pane, pDot, nDot, color);
                    break;
                case "CURSRC":
                    drawCurSrc(pane, pDot, nDot, color);
                    break;
//                case "CCS":
//                    drawCCS(pane, pDot, nDot, color);
//                    break;
//                case "CVS":
//                    drawCVS(pane, pDot, nDot, color);
//                    break;
                case "WIRE":
                    drawWire(pane, pDot, nDot, color);
                    break;
                default:
            }
        }
    }

    public static void drawCap(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            l1 = new Line(x, pDot.y, x + 38, pDot.y);
            l2 = new Line(x + 38, pDot.y - 4, x + 38, pDot.y + 4);
            l3 = new Line(x + 42, pDot.y - 4, x + 42, pDot.y + 4);
            l4 = new Line(x + 42, pDot.y, x + 80, pDot.y);
        } else {
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(pDot.x, y, pDot.x, y + 23);
            l2 = new Line(pDot.x - 4, y + 23, pDot.x + 4, y + 23);
            l3 = new Line(pDot.x - 4, y + 27, pDot.x + 4, y + 27);
            l4 = new Line(pDot.x, y + 27, pDot.x, y + 50);
        }
        pane.getChildren().addAll(l1, l2, l3, l4);
    }

    public static void drawRes(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5, l6, l7, l8, l9;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + 13, y);
            l2 = new Line(x + 13, y, x + 15, y - 3);
            l3 = new Line(x + 15, y - 3, x + 19, y + 3);
            l4 = new Line(x + 19, y + 3, x + 23, y - 3);
            l5 = new Line(x + 23, y - 3, x + 27, y + 3);
            l6 = new Line(x + 27, y + 3, x + 31, y - 3);
            l7 = new Line(x + 31, y - 3, x + 35, y + 3);
            l8 = new Line(x + 35, y + 3, x + 37, y);
            l9 = new Line(x + 37, y, x + 50, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + 13);
            l2 = new Line(x, y + 13, x - 3, y + 15);
            l3 = new Line(x - 3, y + 15, x + 3, y + 19);
            l4 = new Line(x + 3, y + 19, x - 3, y + 23);
            l5 = new Line(x - 3, y + 23, x + 3, y + 27);
            l6 = new Line(x + 3, y + 27, x - 3, y + 31);
            l7 = new Line(x - 3, y + 31, x + 3, y + 35);
            l8 = new Line(x + 3, y + 35, x, y + 37);
            l9 = new Line(x, y + 37, x, y + 50);
        }
        pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9);
    }

    public static void drawInd(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2;
        Arc a1, a2, a3;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, pDot.y);
            int y = pDot.y;
            l1 = new Line(x, y, x + 13, y);
            a1 = new Arc(x + 17, y, 4, 4, 0, 180);
            a2 = new Arc(x + 25, y, 4, 4, 0, 180);
            a3 = new Arc(x + 33, y, 4, 4, 0, 180);
            l2 = new Line(x + 37, y, x + 50, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + 13);
            a1 = new Arc(x, y + 17, 4, 4, 90, 180);
            a2 = new Arc(x, y + 25, 4, 4, 90, 180);
            a3 = new Arc(x, y + 33, 4, 4, 90, 180);
            l2 = new Line(x, y + 37, x, y + 50);
        }
        a1.setFill(Color.TRANSPARENT);
        a2.setFill(Color.TRANSPARENT);
        a3.setFill(Color.TRANSPARENT);
        a1.setStroke(color);
        a2.setStroke(color);
        a3.setStroke(color);
        pane.getChildren().addAll(l1, l2, a1, a2, a3);
    }

    public static void drawDiode(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5, l6;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + 22, y);
            l2 = new Line(x + 22, y - 4, x + 22, y + 4);
            if (pDot.x < nDot.x) {
                l3 = new Line(x + 22, y - 4, x + 28, y);
                l4 = new Line(x + 22, y + 4, x + 28, y);
            } else {
                l3 = new Line(x + 22, y, x + 28, y - 4);
                l4 = new Line(x + 22, y, x + 28, y + 4);
            }
            l5 = new Line(x + 28, y - 4, x + 28, y + 4);
            l6 = new Line(x + 28, y, x + 50, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + 22);
            l2 = new Line(x - 4, y + 22, x + 4, y + 22);
            if (pDot.y < nDot.y) {
                l3 = new Line(x - 4, y + 22, x, y + 28);
                l4 = new Line(x + 4, y + 22, x, y + 28);
            } else {
                l3 = new Line(x - 4, y + 28, x, y + 22);
                l4 = new Line(x + 4, y + 28, x, y + 22);
            }
            l5 = new Line(x - 4, y + 28, x + 4, y + 28);
            l6 = new Line(x, y + 28, x, y + 50);
        }
        pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
    }

    public static void drawVolSrc(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4;
        Arc a1;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + 15, y);
            a1 = new Arc(x + 25, y, 10, 10, 0, 360);
            l2 = new Line(x + 23, y - 3, x + 25, y + 3);
            l3 = new Line(x + 27, y - 3, x + 25, y + 3);
            l4 = new Line(x + 35, y, x + 50, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + 15);
            a1 = new Arc(x, y + 25, 10, 10, 0, 360);
            l2 = new Line(x - 2, y + 22, x, y + 28);
            l3 = new Line(x + 2, y + 22, x, y + 28);
            l4 = new Line(x, y + 35, x, y + 50);
        }
        a1.setFill(Color.TRANSPARENT);
        a1.setStroke(color);
        pane.getChildren().addAll(l1, l2, l3, l4, a1);
    }

    public static void drawCurSrc(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5;
        Arc a1;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + 15, y);
            a1 = new Arc(x + 25, y, 10, 10, 0, 360);
            l2 = new Line(x + 22, y, x + 28, y);
            l3 = new Line(x + 22, y - 1, x + 22, y + 1);
            l4 = new Line(x + 28, y - 1, x + 28, y + 1);
            ;
            l5 = new Line(x + 35, y, x + 50, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + 15);
            a1 = new Arc(x, y + 25, 10, 10, 0, 360);
            l2 = new Line(x, y + 22, x, y + 28);
            l3 = new Line(x - 1, y + 22, x + 1, y + 22);
            l4 = new Line(x - 1, y + 28, x + 1, y + 28);
            ;
            l5 = new Line(x, y + 35, x, y + 50);

        }
        a1.setFill(Color.TRANSPARENT);
        a1.setStroke(color);
        pane.getChildren().addAll(l1, l2, l3, l4, l5, a1);
    }

    public static void drawWire(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l;
        l = new Line(pDot.x, pDot.y, nDot.x, nDot.y);
        l.setStroke(color);
        pane.getChildren().add(l);
    }
}
