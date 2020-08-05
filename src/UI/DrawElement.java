package UI;

import Kernel.Element;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;

public class DrawElement {
    public static int s = 80;
    public static int z = 4;
    static Color secondary = Color.CORAL;

    public static void draw(String type, Pane pane, Dot pDot, Dot nDot, Paint first, int index) {
        if (type != null) {
            switch (type) {
                case "CAP":
                    drawCap(pane, pDot, nDot, first, index);
                    break;
                case "RES":
                    drawRes(pane, pDot, nDot, first, index);
                    break;
                case "IND":
                    drawInd(pane, pDot, nDot, first, index);
                    break;
                case "DIODE":
                    drawDirectional("DIODE", pane, pDot, nDot, first, index);
                    break;
                case "VOLSRC":
                    drawDirectional("VOLSRC", pane, pDot, nDot, first, index);
                    break;
                case "CURSRC":
                    drawDirectional("CURSRC", pane, pDot, nDot, first, index);
                    break;
                case "CCS":
                    drawDirectional("CCS", pane, pDot, nDot, first, index);
                    break;
                case "CVS":
                    drawDirectional("CVS", pane, pDot, nDot, first, index);
                    break;
                case "WIRE":
                    drawWire(pane, pDot, nDot, first);
                    break;
                default:
                    break;
            }
        }
    }

    public static void drawCap(Pane pane, Dot pDot, Dot nDot, Paint first, int index) {
        Line l1, l2, l3, l4, l5, l6;
        if (pDot.y == nDot.y && Math.abs(pDot.x - nDot.x) == s) {
            if (index == 0) {
                int x = Math.min(pDot.x, nDot.x);
                l1 = new Line(x, pDot.y, x + s / 2 - z / 2, pDot.y);
                l2 = new Line(x + s / 2 - z / 2, pDot.y - z, x + s / 2 - z / 2, pDot.y + z);
                l3 = new Line(x + s / 2 + z / 2, pDot.y - z, x + s / 2 + z / 2, pDot.y + z);
                l4 = new Line(x + s / 2 + z / 2, pDot.y, x + s, pDot.y);
                pane.getChildren().addAll(l1, l2, l3, l4);
            } else if (index == 1) {
                int x = Math.min(pDot.x, nDot.x);
                l1 = new Line(x, pDot.y, x + s / 4, pDot.y - s / 4);
                l2 = new Line(x + s / 4, pDot.y - s / 4, x + s / 2 - z / 2, pDot.y - s / 4);
                l3 = new Line(x + s / 2 - z / 2, pDot.y - s / 4 - z, x + s / 2 - z / 2, pDot.y - s / 4 + z);
                l4 = new Line(x + s / 2 + z / 2, pDot.y - s / 4 - z, x + s / 2 + z / 2, pDot.y - s / 4 + z);
                l5 = new Line(x + s / 2 + z / 2, pDot.y - s / 4, x + s - s / 4, pDot.y - s / 4);
                l6 = new Line(x + s - s / 4, pDot.y - s / 4, x + s, pDot.y);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
            } else if (index == 2) {
                int x = Math.min(pDot.x, nDot.x);
                l1 = new Line(x, pDot.y, x + s / 4, pDot.y + s / 4);
                l2 = new Line(x + s / 4, pDot.y + s / 4, x + s / 2 - z / 2, pDot.y + s / 4);
                l3 = new Line(x + s / 2 - z / 2, pDot.y + s / 4 - z, x + s / 2 - z / 2, pDot.y + s / 4 + z);
                l4 = new Line(x + s / 2 + z / 2, pDot.y + s / 4 - z, x + s / 2 + z / 2, pDot.y + s / 4 + z);
                l5 = new Line(x + s / 2 + z / 2, pDot.y + s / 4, x + s - s / 4, pDot.y + s / 4);
                l6 = new Line(x + s - s / 4, pDot.y + s / 4, x + s, pDot.y);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
            }
        } else if (pDot.x == nDot.x && Math.abs(pDot.y - nDot.y) == s) {
            if (index == 0) {
                int y = Math.min(pDot.y, nDot.y);
                l1 = new Line(pDot.x, y, pDot.x, y + s / 2 - z / 2);
                l2 = new Line(pDot.x - z, y + s / 2 - z / 2, pDot.x + z, y + s / 2 - z / 2);
                l3 = new Line(pDot.x - z, y + s / 2 + z / 2, pDot.x + z, y + s / 2 + z / 2);
                l4 = new Line(pDot.x, y + s / 2 + z / 2, pDot.x, y + s);
                pane.getChildren().addAll(l1, l2, l3, l4);
            } else if (index == 1) {
                int y = Math.min(pDot.y, nDot.y);
                l1 = new Line(pDot.x, y, pDot.x - s / 4, y + s / 4);
                l2 = new Line(pDot.x - s / 4, y + s / 4, pDot.x - s / 4, y + s / 2 - z / 2);
                l3 = new Line(pDot.x - s / 4 - z, y + s / 2 - z / 2, pDot.x - s / 4 + z, y + s / 2 - z / 2);
                l4 = new Line(pDot.x - s / 4 - z, y + s / 2 + z / 2, pDot.x - s / 4 + z, y + s / 2 + z / 2);
                l5 = new Line(pDot.x - s / 4, y + s / 2 + z / 2, pDot.x - s / 4, y + s - s / 4);
                l6 = new Line(pDot.x - s / 4, y + s - s / 4, pDot.x, y + s);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
            } else if (index == 2) {
                int y = Math.min(pDot.y, nDot.y);
                l1 = new Line(pDot.x, y, pDot.x + s / 4, y + s / 4);
                l2 = new Line(pDot.x + s / 4, y + s / 4, pDot.x + s / 4, y + s / 2 - z / 2);
                l3 = new Line(pDot.x + s / 4 - z, y + s / 2 - z / 2, pDot.x + s / 4 + z, y + s / 2 - z / 2);
                l4 = new Line(pDot.x + s / 4 - z, y + s / 2 + z / 2, pDot.x + s / 4 + z, y + s / 2 + z / 2);
                l5 = new Line(pDot.x + s / 4, y + s / 2 + z / 2, pDot.x + s / 4, y + s - s / 4);
                l6 = new Line(pDot.x + s / 4, y + s - s / 4, pDot.x, y + s);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
            }
        } else if ((pDot.x > nDot.x && pDot.y > nDot.y) || (nDot.x > pDot.x && nDot.y > pDot.y)) {
            int hX = Math.max(pDot.x, nDot.x);
            int lX = Math.min(pDot.x, nDot.x);
            int hY = Math.max(pDot.y, nDot.y);
            int lY = Math.min(pDot.y, nDot.y);
            l1 = new Line(lX, lY, lX + s / 2, lY + s / 4);
            l2 = new Line(lX + s / 2, lY + s / 4, lX + s / 2, lY + s / 2 - z / 2);
            l3 = new Line(lX + s / 2 - z, lY + s / 2 - z / 2, lX + s / 2 + z, lY + s / 2 - z / 2);
            l4 = new Line(lX + s / 2 - z, lY + s / 2 + z / 2, lX + s / 2 + z, lY + s / 2 + z / 2);
            l5 = new Line(lX + s / 2, lY + s / 2 + z / 2, lX + s / 2, lY + s - s / 4);
            l6 = new Line(lX + s / 2, lY + s - s / 4, hX, hY);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            l3.setStroke(secondary);
            l4.setStroke(secondary);
            l5.setStroke(secondary);
            l6.setStroke(secondary);
            pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
        } else {
            int hX = Math.max(pDot.x, nDot.x);
            int lX = Math.min(pDot.x, nDot.x);
            int hY = Math.max(pDot.y, nDot.y);
            int lY = Math.min(pDot.y, nDot.y);
            l1 = new Line(hX, lY, hX - s / 2, lY + s / 4);
            l2 = new Line(hX - s / 2, lY + s / 4, hX - s / 2, lY + s / 2 - z / 2);
            l3 = new Line(hX - s / 2 - z, lY + s / 2 - z / 2, hX - s / 2 + z, lY + s / 2 - z / 2);
            l4 = new Line(hX - s / 2 - z, lY + s / 2 + z / 2, hX - s / 2 + z, lY + s / 2 + z / 2);
            l5 = new Line(hX - s / 2, lY + s / 2 + z / 2, hX - s / 2, lY + s - s / 4);
            l6 = new Line(hX - s / 2, lY + s - s / 4, lX, hY);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            l3.setStroke(secondary);
            l4.setStroke(secondary);
            l5.setStroke(secondary);
            l6.setStroke(secondary);
            pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
        }

    }

    public static void drawRes(Pane pane, Dot pDot, Dot nDot, Paint first, int index) {
        Line l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
        if (pDot.y == nDot.y && Math.abs(pDot.x - nDot.x) == s) {
            if (index == 0) {
                int x = Math.min(pDot.x, nDot.x);
                int y = pDot.y;
                l1 = new Line(x, y, x + s / 2 - 3 * z, y);
                l2 = new Line(x + +s / 2 - 3 * z, y, x + +s / 2 - 2.5 * z, y - z);
                l3 = new Line(x + +s / 2 - 2.5 * z, y - z, x + +s / 2 - 1.5 * z, y + z);
                l4 = new Line(x + +s / 2 - 1.5 * z, y + z, x + +s / 2 - 0.5 * z, y - z);
                l5 = new Line(x + +s / 2 - 0.5 * z, y - z, x + +s / 2 + 0.5 * z, y + z);
                l6 = new Line(x + s / 2 + 0.5 * z, y + z, x + s / 2 + 1.5 * z, y - z);
                l7 = new Line(x + s / 2 + 1.5 * z, y - z, x + s / 2 + 2.5 * z, y + z);
                l8 = new Line(x + s / 2 + 2.5 * z, y + z, x + s / 2 + 3 * z, y);
                l9 = new Line(x + s / 2 + 3 * z, y, x + s, y);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9);
            } else if (index == 1) {
                int x = Math.min(pDot.x, nDot.x);
                int y = pDot.y;
                l1 = new Line(x, y, x + s / 4, y - s / 4);
                l2 = new Line(x + s / 4, y - s / 4, x + s / 2 - 3 * z, y - s / 4);
                l3 = new Line(x + +s / 2 - 3 * z, y - s / 4, x + +s / 2 - 2.5 * z, y - s / 4 - z);
                l4 = new Line(x + +s / 2 - 2.5 * z, y - s / 4 - z, x + +s / 2 - 1.5 * z, y - s / 4 + z);
                l5 = new Line(x + +s / 2 - 1.5 * z, y - s / 4 + z, x + +s / 2 - 0.5 * z, y - s / 4 - z);
                l6 = new Line(x + +s / 2 - 0.5 * z, y - s / 4 - z, x + +s / 2 + 0.5 * z, y - s / 4 + z);
                l7 = new Line(x + s / 2 + 0.5 * z, y - s / 4 + z, x + s / 2 + 1.5 * z, y - s / 4 - z);
                l8 = new Line(x + s / 2 + 1.5 * z, y - s / 4 - z, x + s / 2 + 2.5 * z, y - s / 4 + z);
                l9 = new Line(x + s / 2 + 2.5 * z, y - s / 4 + z, x + s / 2 + 3 * z, y - s / 4);
                l10 = new Line(x + s / 2 + 3 * z, y - s / 4, x + s - s / 4, y - s / 4);
                l11 = new Line(x + s - s / 4, y - s / 4, x + s, y);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
            } else if (index == 2) {
                int x = Math.min(pDot.x, nDot.x);
                int y = pDot.y;
                l1 = new Line(x, y, x + s / 4, y + s / 4);
                l2 = new Line(x + s / 4, y + s / 4, x + s / 2 - 3 * z, y + s / 4);
                l3 = new Line(x + +s / 2 - 3 * z, y + s / 4, x + +s / 2 - 2.5 * z, y + s / 4 - z);
                l4 = new Line(x + +s / 2 - 2.5 * z, y + s / 4 - z, x + +s / 2 - 1.5 * z, y + s / 4 + z);
                l5 = new Line(x + +s / 2 - 1.5 * z, y + s / 4 + z, x + +s / 2 - 0.5 * z, y + s / 4 - z);
                l6 = new Line(x + +s / 2 - 0.5 * z, y + s / 4 - z, x + +s / 2 + 0.5 * z, y + s / 4 + z);
                l7 = new Line(x + s / 2 + 0.5 * z, y + s / 4 + z, x + s / 2 + 1.5 * z, y + s / 4 - z);
                l8 = new Line(x + s / 2 + 1.5 * z, y + s / 4 - z, x + s / 2 + 2.5 * z, y + s / 4 + z);
                l9 = new Line(x + s / 2 + 2.5 * z, y + s / 4 + z, x + s / 2 + 3 * z, y + s / 4);
                l10 = new Line(x + s / 2 + 3 * z, y + s / 4, x + s - s / 4, y + s / 4);
                l11 = new Line(x + s - s / 4, y + s / 4, x + s, y);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
            }
        } else if (pDot.x == nDot.x && Math.abs(pDot.y - nDot.y) == s) {
            if (index == 0) {
                int x = pDot.x;
                int y = Math.min(pDot.y, nDot.y);
                l1 = new Line(x, y, x, y + s / 2 - 3 * z);
                l2 = new Line(x, y + s / 2 - 3 * z, x - z, y + s / 2 - 2.5 * z);
                l3 = new Line(x - z, y + s / 2 - 2.5 * z, x + z, y + s / 2 - 1.5 * z);
                l4 = new Line(x + z, y + s / 2 - 1.5 * z, x - z, y + s / 2 - 0.5 * z);
                l5 = new Line(x - z, y + s / 2 - 0.5 * z, x + z, y + s / 2 + 0.5 * z);
                l6 = new Line(x + z, y + s / 2 + 0.5 * z, x - z, y + s / 2 + 1.5 * z);
                l7 = new Line(x - z, y + s / 2 + 1.5 * z, x + z, y + s / 2 + 2.5 * z);
                l8 = new Line(x + z, y + s / 2 + 2.5 * z, x, y + s / 2 + 3 * z);
                l9 = new Line(x, y + s / 2 + 3 * z, x, y + s);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9);
            } else if (index == 1) {
                int x = pDot.x;
                int y = Math.min(pDot.y, nDot.y);
                l1 = new Line(x, y, x - s / 4, y + s / 4);
                l2 = new Line(x - s / 4, y + s / 4, x - s / 4, y + s / 2 - 3 * z);
                l3 = new Line(x - s / 4, y + s / 2 - 3 * z, x - z - s / 4, y + s / 2 - 2.5 * z);
                l4 = new Line(x - z - s / 4, y + s / 2 - 2.5 * z, x + z - s / 4, y + s / 2 - 1.5 * z);
                l5 = new Line(x + z - s / 4, y + s / 2 - 1.5 * z, x - z - s / 4, y + s / 2 - 0.5 * z);
                l6 = new Line(x - z - s / 4, y + s / 2 - 0.5 * z, x + z - s / 4, y + s / 2 + 0.5 * z);
                l7 = new Line(x + z - s / 4, y + s / 2 + 0.5 * z, x - z - s / 4, y + s / 2 + 1.5 * z);
                l8 = new Line(x - z - s / 4, y + s / 2 + 1.5 * z, x + z - s / 4, y + s / 2 + 2.5 * z);
                l9 = new Line(x + z - s / 4, y + s / 2 + 2.5 * z, x - s / 4, y + s / 2 + 3 * z);
                l10 = new Line(x - s / 4, y + s / 2 + 3 * z, x - s / 4, y + s - s / 4);
                l11 = new Line(x - s / 4, y + s - s / 4, x, y + s);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
            } else if (index == 2) {
                int x = pDot.x;
                int y = Math.min(pDot.y, nDot.y);
                l1 = new Line(x, y, x + s / 4, y + s / 4);
                l2 = new Line(x + s / 4, y + s / 4, x + s / 4, y + s / 2 - 3 * z);
                l3 = new Line(x + s / 4, y + s / 2 - 3 * z, x - z + s / 4, y + s / 2 - 2.5 * z);
                l4 = new Line(x - z + s / 4, y + s / 2 - 2.5 * z, x + z + s / 4, y + s / 2 - 1.5 * z);
                l5 = new Line(x + z + s / 4, y + s / 2 - 1.5 * z, x - z + s / 4, y + s / 2 - 0.5 * z);
                l6 = new Line(x - z + s / 4, y + s / 2 - 0.5 * z, x + z + s / 4, y + s / 2 + 0.5 * z);
                l7 = new Line(x + z + s / 4, y + s / 2 + 0.5 * z, x - z + s / 4, y + s / 2 + 1.5 * z);
                l8 = new Line(x - z + s / 4, y + s / 2 + 1.5 * z, x + z + s / 4, y + s / 2 + 2.5 * z);
                l9 = new Line(x + z + s / 4, y + s / 2 + 2.5 * z, x + s / 4, y + s / 2 + 3 * z);
                l10 = new Line(x + s / 4, y + s / 2 + 3 * z, x + s / 4, y + s - s / 4);
                l11 = new Line(x + s / 4, y + s - s / 4, x, y + s);
                pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
            }
        } else if ((pDot.x > nDot.x && pDot.y > nDot.y) || (nDot.x > pDot.x && nDot.y > pDot.y)) {
            int hX = Math.max(pDot.x, nDot.x);
            int lX = Math.min(pDot.x, nDot.x);
            int hY = Math.max(pDot.y, nDot.y);
            int lY = Math.min(pDot.y, nDot.y);
            l1 = new Line(lX, lY, lX + s / 2, lY + s / 4);
            l2 = new Line(lX + s / 2, lY + s / 4, lX + s / 2, lY + s / 2 - 3 * z);
            l3 = new Line(lX + s / 2, lY + s / 2 - 3 * z, lX - z + s / 2, lY + s / 2 - 2.5 * z);
            l4 = new Line(lX - z + s / 2, lY + s / 2 - 2.5 * z, lX + z + s / 2, lY + s / 2 - 1.5 * z);
            l5 = new Line(lX + z + s / 2, lY + s / 2 - 1.5 * z, lX - z + s / 2, lY + s / 2 - 0.5 * z);
            l6 = new Line(lX - z + s / 2, lY + s / 2 - 0.5 * z, lX + z + s / 2, lY + s / 2 + 0.5 * z);
            l7 = new Line(lX + z + s / 2, lY + s / 2 + 0.5 * z, lX - z + s / 2, lY + s / 2 + 1.5 * z);
            l8 = new Line(lX - z + s / 2, lY + s / 2 + 1.5 * z, lX + z + s / 2, lY + s / 2 + 2.5 * z);
            l9 = new Line(lX + z + s / 2, lY + s / 2 + 2.5 * z, lX + s / 2, lY + s / 2 + 3 * z);
            l10 = new Line(lX + s / 2, lY + s / 2 + 3 * z, lX + s / 2, lY + s - s / 4);
            l11 = new Line(lX + s / 2, lY + s - s / 4, hX, hY);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            l3.setStroke(secondary);
            l4.setStroke(secondary);
            l5.setStroke(secondary);
            l6.setStroke(secondary);
            l7.setStroke(secondary);
            l8.setStroke(secondary);
            l9.setStroke(secondary);
            l10.setStroke(secondary);
            l11.setStroke(secondary);
            pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
        } else {
            int hX = Math.max(pDot.x, nDot.x);
            int lX = Math.min(pDot.x, nDot.x);
            int hY = Math.max(pDot.y, nDot.y);
            int lY = Math.min(pDot.y, nDot.y);
            l1 = new Line(hX, lY, hX - s / 2, lY + s / 4);
            l2 = new Line(hX - s / 2, lY + s / 4, hX - s / 2, lY + s / 2 - 3 * z);
            l3 = new Line(hX - s / 2, lY + s / 2 - 3 * z, hX - z - s / 2, lY + s / 2 - 2.5 * z);
            l4 = new Line(hX - z - s / 2, lY + s / 2 - 2.5 * z, hX + z - s / 2, lY + s / 2 - 1.5 * z);
            l5 = new Line(hX + z - s / 2, lY + s / 2 - 1.5 * z, hX - z - s / 2, lY + s / 2 - 0.5 * z);
            l6 = new Line(hX - z - s / 2, lY + s / 2 - 0.5 * z, hX + z - s / 2, lY + s / 2 + 0.5 * z);
            l7 = new Line(hX + z - s / 2, lY + s / 2 + 0.5 * z, hX - z - s / 2, lY + s / 2 + 1.5 * z);
            l8 = new Line(hX - z - s / 2, lY + s / 2 + 1.5 * z, hX + z - s / 2, lY + s / 2 + 2.5 * z);
            l9 = new Line(hX + z - s / 2, lY + s / 2 + 2.5 * z, hX - s / 2, lY + s / 2 + 3 * z);
            l10 = new Line(hX - s / 2, lY + s / 2 + 3 * z, hX - s / 2, lY + s - s / 4);
            l11 = new Line(hX - s / 2, lY + s - s / 4, lX, hY);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            l3.setStroke(secondary);
            l4.setStroke(secondary);
            l5.setStroke(secondary);
            l6.setStroke(secondary);
            l7.setStroke(secondary);
            l8.setStroke(secondary);
            l9.setStroke(secondary);
            l10.setStroke(secondary);
            l11.setStroke(secondary);
            pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
        }

    }

    public static void drawInd(Pane pane, Dot pDot, Dot nDot, Paint first, int index) {
        Line l1, l2;
        Dot dot1, dot2;
        if (pDot.y == nDot.y && Math.abs(pDot.x - nDot.x) == s) {
            int mX = Math.min(pDot.x, nDot.x);
            if (index == 0) {
                dot1 = new Dot(mX + s / 4, pDot.y, 0);
                dot2 = new Dot(mX + 3 * s / 4, pDot.y, 0);
                l1 = new Line(mX, pDot.y, dot1.x, pDot.y);
                l2 = new Line(dot2.x, pDot.y, mX + s, pDot.y);
                pane.getChildren().addAll(l1, l2);
                pvtInd(pane, dot1, dot2, first);
            } else if (index == 1) {
                dot1 = new Dot(mX + s / 4, pDot.y - s / 4, 0);
                dot2 = new Dot(mX + 3 * s / 4, pDot.y - s / 4, 0);
                l1 = new Line(mX, pDot.y, dot1.x, dot1.y);
                l2 = new Line(dot2.x, dot2.y, mX + s, pDot.y);
                pane.getChildren().addAll(l1, l2);
                pvtInd(pane, dot1, dot2, first);
            } else if (index == 2) {
                dot1 = new Dot(mX + s / 4, pDot.y + s / 4, 0);
                dot2 = new Dot(mX + 3 * s / 4, pDot.y + s / 4, 0);
                l1 = new Line(mX, pDot.y, dot1.x, dot1.y);
                l2 = new Line(dot2.x, dot2.y, mX + s, pDot.y);
                pane.getChildren().addAll(l1, l2);
                pvtInd(pane, dot1, dot2, first);
            }
        } else if (pDot.x == nDot.x && Math.abs(pDot.y - nDot.y) == s) {
            int mY = Math.min(pDot.y, nDot.y);
            int x = pDot.x;
            if (index == 0) {
                dot1 = new Dot(x, mY + s / 4, 0);
                dot2 = new Dot(x, mY + 3 * s / 4, 0);
                l1 = new Line(x, mY, dot1.x, dot1.y);
                l2 = new Line(dot2.x, dot2.y, x, mY + s);
                pane.getChildren().addAll(l1, l2);
                pvtInd(pane, dot1, dot2, first);
            } else if (index == 1) {
                dot1 = new Dot(x - s / 4, mY + s / 4, 0);
                dot2 = new Dot(x - s / 4, mY + 3 * s / 4, 0);
                l1 = new Line(x, mY, dot1.x, dot1.y);
                l2 = new Line(dot2.x, dot2.y, x, mY + s);
                pane.getChildren().addAll(l1, l2);
                pvtInd(pane, dot1, dot2, first);
            } else if (index == 2) {
                dot1 = new Dot(x + s / 4, mY + s / 4, 0);
                dot2 = new Dot(x + s / 4, mY + 3 * s / 4, 0);
                l1 = new Line(x, mY, dot1.x, dot1.y);
                l2 = new Line(dot2.x, dot2.y, x, mY + s);
                pane.getChildren().addAll(l1, l2);
                pvtInd(pane, dot1, dot2, first);
            }
        } else if ((pDot.x > nDot.x && pDot.y > nDot.y) || (nDot.x > pDot.x && nDot.y > pDot.y)) {
            int hX = Math.max(pDot.x, nDot.x);
            int lX = Math.min(pDot.x, nDot.x);
            int hY = Math.max(pDot.y, nDot.y);
            int lY = Math.min(pDot.y, nDot.y);
            dot1 = new Dot(lX + s / 2, lY + s / 4, 0);
            dot2 = new Dot(lX + s / 2, lY + 3 * s / 4, 0);
            l1 = new Line(lX, lY, dot1.x, dot1.y);
            l2 = new Line(dot2.x, dot2.y, hX, hY);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            pvtInd(pane, dot1, dot2, secondary);
            pane.getChildren().addAll(l1, l2);
        } else {
            int hX = Math.max(pDot.x, nDot.x);
            int lX = Math.min(pDot.x, nDot.x);
            int hY = Math.max(pDot.y, nDot.y);
            int lY = Math.min(pDot.y, nDot.y);
            dot1 = new Dot(hX - s / 2, lY + s / 4, 0);
            dot2 = new Dot(hX - s / 2, lY + 3 * s / 4, 0);
            l1 = new Line(hX, lY, dot1.x, dot1.y);
            l2 = new Line(dot2.x, dot2.y, lX, hY);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            pvtInd(pane, dot1, dot2, secondary);
            pane.getChildren().addAll(l1, l2);
        }
    }

    private static void pvtInd(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2;
        Arc a1, a2, a3;
        if (pDot.x == nDot.x) {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + s / 4 - 3 * z);
            a1 = new Arc(x, y + s / 4 - 2 * z, z, z, 90, 180);
            a2 = new Arc(x, y + s / 4, z, z, 90, 180);
            a3 = new Arc(x, y + s / 4 + 2 * z, z, z, 90, 180);
            l2 = new Line(x, y + s / 4 + 3 * z, x, y + s / 2);
        } else {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + s / 4 - 3 * z, y);
            a1 = new Arc(x + s / 4 - 2 * z, y, z, z, 0, 180);
            a2 = new Arc(x + s / 4, y, z, z, 0, 180);
            a3 = new Arc(x + s / 4 + 2 * z, y, z, z, 0, 180);
            l2 = new Line(x + s / 4 + 3 * z, y, x + s / 2, y);
        }
        a1.setFill(Color.TRANSPARENT);
        a2.setFill(Color.TRANSPARENT);
        a3.setFill(Color.TRANSPARENT);
        a1.setStroke(color);
        a2.setStroke(color);
        a3.setStroke(color);
        l1.setStroke(color);
        l2.setStroke(color);
        pane.getChildren().addAll(l1, l2, a1, a2, a3);
    }

    public static void drawDirectional(String type, Pane pane, Dot pDot, Dot nDot, Paint first, int index) {
        Line l1, l2;
        Dot dot1, dot2;
        if (pDot.y == nDot.y && Math.abs(pDot.x - nDot.x) == s) {
            if (index == 0) {
                if (pDot.x < nDot.x) {
                    dot1 = new Dot(pDot.x + s / 4, pDot.y, 0);
                    dot2 = new Dot(pDot.x + 3 * s / 4, pDot.y, 0);
                } else {
                    dot2 = new Dot(nDot.x + s / 4, pDot.y, 0);
                    dot1 = new Dot(nDot.x + 3 * s / 4, pDot.y, 0);
                }
                l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
                l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
                switch (type) {
                    case "DIODE":
                        pvtDiode(pane, dot1, dot2, first);
                        break;
                    case "VOLSRC":
                        pvtVolSrc(pane, dot1, dot2, first);
                        break;
                    case "CURSRC":
                        pvtCurSrc(pane, dot1, dot2, first);
                        break;
                    case "CCS":
                        pvtCCS(pane, dot1, dot2, first);
                        break;
                    case "CVS":
                        pvtCVS(pane, dot1, dot2, first);
                        break;
                }
                pane.getChildren().addAll(l1, l2);
            } else if (index == 1) {
                if (pDot.x < nDot.x) {
                    dot1 = new Dot(pDot.x + s / 4, pDot.y - s / 4, 0);
                    dot2 = new Dot(pDot.x + 3 * s / 4, pDot.y - s / 4, 0);
                } else {
                    dot2 = new Dot(nDot.x + s / 4, pDot.y - s / 4, 0);
                    dot1 = new Dot(nDot.x + 3 * s / 4, pDot.y - s / 4, 0);
                }
                l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
                l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
                switch (type) {
                    case "DIODE":
                        pvtDiode(pane, dot1, dot2, first);
                        break;
                    case "VOLSRC":
                        pvtVolSrc(pane, dot1, dot2, first);
                        break;
                    case "CURSRC":
                        pvtCurSrc(pane, dot1, dot2, first);
                        break;
                    case "CCS":
                        pvtCCS(pane, dot1, dot2, first);
                        break;
                    case "CVS":
                        pvtCVS(pane, dot1, dot2, first);
                        break;
                }
                pane.getChildren().addAll(l1, l2);
            } else if (index == 2) {
                if (pDot.x < nDot.x) {
                    dot1 = new Dot(pDot.x + s / 4, pDot.y + s / 4, 0);
                    dot2 = new Dot(pDot.x + 3 * s / 4, pDot.y + s / 4, 0);
                } else {
                    dot2 = new Dot(nDot.x + s / 4, pDot.y + s / 4, 0);
                    dot1 = new Dot(nDot.x + 3 * s / 4, pDot.y + s / 4, 0);
                }
                l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
                l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
                switch (type) {
                    case "DIODE":
                        pvtDiode(pane, dot1, dot2, first);
                        break;
                    case "VOLSRC":
                        pvtVolSrc(pane, dot1, dot2, first);
                        break;
                    case "CURSRC":
                        pvtCurSrc(pane, dot1, dot2, first);
                        break;
                    case "CCS":
                        pvtCCS(pane, dot1, dot2, first);
                        break;
                    case "CVS":
                        pvtCVS(pane, dot1, dot2, first);
                        break;
                }
                pane.getChildren().addAll(l1, l2);
            }
        } else if (pDot.x == nDot.x && Math.abs(pDot.y - nDot.y) == s) {
            if (index == 0) {
                if (pDot.y < nDot.y) {
                    dot1 = new Dot(pDot.x, pDot.y + s / 4, 0);
                    dot2 = new Dot(pDot.x, pDot.y + 3 * s / 4, 0);
                } else {
                    dot2 = new Dot(pDot.x, nDot.y + s / 4, 0);
                    dot1 = new Dot(pDot.x, nDot.y + 3 * s / 4, 0);
                }
                l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
                l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
                switch (type) {
                    case "DIODE":
                        pvtDiode(pane, dot1, dot2, first);
                        break;
                    case "VOLSRC":
                        pvtVolSrc(pane, dot1, dot2, first);
                        break;
                    case "CURSRC":
                        pvtCurSrc(pane, dot1, dot2, first);
                        break;
                    case "CCS":
                        pvtCCS(pane, dot1, dot2, first);
                        break;
                    case "CVS":
                        pvtCVS(pane, dot1, dot2, first);
                        break;
                }
                pane.getChildren().addAll(l1, l2);
            } else if (index == 1) {
                if (pDot.y < nDot.y) {
                    dot1 = new Dot(pDot.x - s / 4, pDot.y + s / 4, 0);
                    dot2 = new Dot(pDot.x - s / 4, pDot.y + 3 * s / 4, 0);
                } else {
                    dot2 = new Dot(pDot.x - s / 4, nDot.y + s / 4, 0);
                    dot1 = new Dot(pDot.x - s / 4, nDot.y + 3 * s / 4, 0);
                }
                l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
                l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
                switch (type) {
                    case "DIODE":
                        pvtDiode(pane, dot1, dot2, first);
                        break;
                    case "VOLSRC":
                        pvtVolSrc(pane, dot1, dot2, first);
                        break;
                    case "CURSRC":
                        pvtCurSrc(pane, dot1, dot2, first);
                        break;
                    case "CCS":
                        pvtCCS(pane, dot1, dot2, first);
                        break;
                    case "CVS":
                        pvtCVS(pane, dot1, dot2, first);
                        break;
                }
                pane.getChildren().addAll(l1, l2);
            } else if (index == 2) {
                if (pDot.y < nDot.y) {
                    dot1 = new Dot(pDot.x + s / 4, pDot.y + s / 4, 0);
                    dot2 = new Dot(pDot.x + s / 4, pDot.y + 3 * s / 4, 0);
                } else {
                    dot2 = new Dot(pDot.x + s / 4, nDot.y + s / 4, 0);
                    dot1 = new Dot(pDot.x + s / 4, nDot.y + 3 * s / 4, 0);
                }
                l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
                l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
                switch (type) {
                    case "DIODE":
                        pvtDiode(pane, dot1, dot2, first);
                        break;
                    case "VOLSRC":
                        pvtVolSrc(pane, dot1, dot2, first);
                        break;
                    case "CURSRC":
                        pvtCurSrc(pane, dot1, dot2, first);
                        break;
                    case "CCS":
                        pvtCCS(pane, dot1, dot2, first);
                        break;
                    case "CVS":
                        pvtCVS(pane, dot1, dot2, first);
                        break;
                }
                pane.getChildren().addAll(l1, l2);
            }
        } else if (pDot.x > nDot.x && pDot.y > nDot.y) {
            dot2 = new Dot(nDot.x + s / 2, nDot.y + s / 4, 0);
            dot1 = new Dot(nDot.x + s / 2, nDot.y + 3 * s / 4, 0);
            l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
            l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            switch (type) {
                case "DIODE":
                    pvtDiode(pane, dot1, dot2, secondary);
                    break;
                case "VOLSRC":
                    pvtVolSrc(pane, dot1, dot2, secondary);
                    break;
                case "CURSRC":
                    pvtCurSrc(pane, dot1, dot2, secondary);
                    break;
                case "CCS":
                    pvtCCS(pane, dot1, dot2, secondary);
                    break;
                case "CVS":
                    pvtCVS(pane, dot1, dot2, secondary);
                    break;
            }
            pane.getChildren().addAll(l1, l2);
        } else if (nDot.x > pDot.x && nDot.y > pDot.y) {
            dot1 = new Dot(pDot.x + s / 2, pDot.y + s / 4, 0);
            dot2 = new Dot(pDot.x + s / 2, pDot.y + 3 * s / 4, 0);
            l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
            l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            switch (type) {
                case "DIODE":
                    pvtDiode(pane, dot1, dot2, secondary);
                    break;
                case "VOLSRC":
                    pvtVolSrc(pane, dot1, dot2, secondary);
                    break;
                case "CURSRC":
                    pvtCurSrc(pane, dot1, dot2, secondary);
                    break;
                case "CCS":
                    pvtCCS(pane, dot1, dot2, secondary);
                    break;
                case "CVS":
                    pvtCVS(pane, dot1, dot2, secondary);
                    break;
            }
            pane.getChildren().addAll(l1, l2);
        } else if (nDot.x > pDot.x && nDot.y < pDot.y) {
            dot1 = new Dot(nDot.x - s / 2, nDot.y + 3 * s / 4, 0);
            dot2 = new Dot(nDot.x - s / 2, nDot.y + s / 4, 0);
            l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
            l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            switch (type) {
                case "DIODE":
                    pvtDiode(pane, dot1, dot2, secondary);
                    break;
                case "VOLSRC":
                    pvtVolSrc(pane, dot1, dot2, secondary);
                    break;
                case "CURSRC":
                    pvtCurSrc(pane, dot1, dot2, secondary);
                    break;
                case "CCS":
                    pvtCCS(pane, dot1, dot2, secondary);
                    break;
                case "CVS":
                    pvtCVS(pane, dot1, dot2, secondary);
                    break;
            }
            pane.getChildren().addAll(l1, l2);
        } else {
            dot1 = new Dot(pDot.x - s / 2, pDot.y + s / 4, 0);
            dot2 = new Dot(pDot.x - s / 2, pDot.y + 3 * s / 4, 0);
            l1 = new Line(nDot.x, nDot.y, dot2.x, dot2.y);
            l2 = new Line(pDot.x, pDot.y, dot1.x, dot1.y);
            l1.setStroke(secondary);
            l2.setStroke(secondary);
            switch (type) {
                case "DIODE":
                    pvtDiode(pane, dot1, dot2, secondary);
                    break;
                case "VOLSRC":
                    pvtVolSrc(pane, dot1, dot2, secondary);
                    break;
                case "CURSRC":
                    pvtCurSrc(pane, dot1, dot2, secondary);
                    break;
                case "CCS":
                    pvtCCS(pane, dot1, dot2, secondary);
                    break;
                case "CVS":
                    pvtCVS(pane, dot1, dot2, secondary);
                    break;
            }
            pane.getChildren().addAll(l1, l2);
        }
    }

    private static void pvtDiode(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5, l6;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + s / 4 - z / 2, y);
            l2 = new Line(x + s / 4 - z / 2, y - z, x + s / 4 - z / 2, y + z);
            if (pDot.x < nDot.x) {
                l3 = new Line(x + s / 4 - z / 2, y - z, x + s / 4 + z / 2, y);
                l4 = new Line(x + s / 4 - z / 2, y + z, x + s / 4 + z / 2, y);
            } else {
                l3 = new Line(x + s / 4 - z / 2, y, x + s / 4 + z / 2, y - z);
                l4 = new Line(x + s / 4 - z / 2, y, x + s / 4 + z / 2, y + z);
            }
            l5 = new Line(x + s / 4 + z / 2, y - z, x + s / 4 + z / 2, y + z);
            l6 = new Line(x + s / 4 + z / 2, y, x + s / 2, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + s / 4 - z / 2);
            l2 = new Line(x - z, y + s / 4 - z / 2, x + z, y + s / 4 - z / 2);
            if (pDot.y < nDot.y) {
                l3 = new Line(x - z, y + s / 4 - z / 2, x, y + s / 4 + z / 2);
                l4 = new Line(x + z, y + s / 4 - z / 2, x, y + s / 4 + z / 2);
            } else {
                l3 = new Line(x - z, y + s / 4 + z / 2, x, y + s / 4 - z / 2);
                l4 = new Line(x + z, y + s / 4 + z / 2, x, y + s / 4 - z / 2);
            }
            l5 = new Line(x - z, y + s / 4 + z / 2, x + 4, y + s / 4 + z / 2);
            l6 = new Line(x, y + s / 4 + z / 2, x, y + s / 2);
        }
        l1.setStroke(color);
        l2.setStroke(color);
        l3.setStroke(color);
        l4.setStroke(color);
        l5.setStroke(color);
        l6.setStroke(color);
        pane.getChildren().addAll(l1, l2, l3, l4, l5, l6);
    }

    private static void pvtVolSrc(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5;
        Arc a1;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + s / 4 - z * 2, y);
            a1 = new Arc(x + s / 4, y, z * 2, z * 2, 0, 360);
            l2 = new Line(x + s / 4 - z, y - 0.5 * z, x + s / 4 - z, y + 0.5 * z);
            l3 = new Line(x + s / 4 + z, y - 0.5 * z, x + s / 4 + z, y + 0.5 * z);
            if (pDot.x < nDot.x) {
                l4 = new Line(x + s / 4 - .5 * z, y, x + s / 4 - 1.5 * z, y);
            } else {
                l4 = new Line(x + s / 4 + .5 * z, y, x + s / 4 + 1.5 * z, y);
            }
            l5 = new Line(x + s / 4 + 2 * z, y, x + s / 2, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + s / 4 - z * 2);
            a1 = new Arc(x, y + s / 4, z * 2, z * 2, 0, 360);
            l2 = new Line(x - .5 * z, y + s / 4 - z, x + .5 * z, y + s / 4 - z);
            l3 = new Line(x - .5 * z, y + s / 4 + z, x + .5 * z, y + s / 4 + z);
            if (pDot.y < nDot.y) {
                l4 = new Line(x, y + s / 4 - .5 * z, x, y + s / 4 - 1.5 * z);
            } else {
                l4 = new Line(x, y + s / 4 + .5 * z, x, y + s / 4 + 1.5 * z);
            }
            l5 = new Line(x, y + s / 4 + 2 * z, x, y + s / 2);
        }
        l1.setStroke(color);
        l2.setStroke(color);
        l3.setStroke(color);
        l4.setStroke(color);
        l5.setStroke(color);
        a1.setFill(Color.TRANSPARENT);
        a1.setStroke(color);
        pane.getChildren().addAll(l1, l2, l3, l4, l5, a1);
    }

    private static void pvtCurSrc(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5;
        Arc a1;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + s / 4 - z * 2, y);
            a1 = new Arc(x + s / 4, y, z * 2, z * 2, 0, 360);
            l2 = new Line(x + s / 4 - z, y, x + s / 4 + z, y);
            if (pDot.x < nDot.x) {
                l3 = new Line(x + s / 4 + z, y, x + s / 4, y - 0.5 * z);
                l4 = new Line(x + s / 4 + z, y, x + s / 4, y + 0.5 * z);
            } else {
                l3 = new Line(x + s / 4 - z, y, x + s / 4, y - 0.5 * z);
                l4 = new Line(x + s / 4 - z, y, x + s / 4, y + 0.5 * z);
            }
            l5 = new Line(x + s / 4 + 2 * z, y, x + s / 2, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + s / 4 - z * 2);
            a1 = new Arc(x, y + s / 4, z * 2, z * 2, 0, 360);
            l2 = new Line(x, y + s / 4 - z, x, y + s / 4 + z);
            if (pDot.y < nDot.y) {
                l3 = new Line(x, y + s / 4 + z, x - .5 * z, y + s / 4);
                l4 = new Line(x, y + s / 4 + z, x + .5 * z, y + s / 4);
            } else {
                l3 = new Line(x, y + s / 4 - z, x - .5 * z, y + s / 4);
                l4 = new Line(x, y + s / 4 - z, x + .5 * z, y + s / 4);
            }
            l5 = new Line(x, y + s / 4 + 2 * z, x, y + s / 2);
        }
        l1.setStroke(color);
        l2.setStroke(color);
        l3.setStroke(color);
        l4.setStroke(color);
        l5.setStroke(color);
        a1.setFill(Color.TRANSPARENT);
        a1.setStroke(color);
        pane.getChildren().addAll(l1, l2, l3, l4, l5, a1);
    }

    private static void pvtCCS(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5, l6, l7, l8, l9;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + s / 4 - z * 2, y);
            l6 = new Line(x + s / 4 - z * 2, y, x + s / 4, y - z * 2);
            l7 = new Line(x + s / 4 - z * 2, y, x + s / 4, y + z * 2);
            l8 = new Line(x + s / 4 + z * 2, y, x + s / 4, y - z * 2);
            l9 = new Line(x + s / 4 + z * 2, y, x + s / 4, y + z * 2);
            l2 = new Line(x + s / 4 - z, y, x + s / 4 + z, y);
            if (pDot.x < nDot.x) {
                l3 = new Line(x + s / 4 + z, y, x + s / 4, y - 0.5 * z);
                l4 = new Line(x + s / 4 + z, y, x + s / 4, y + 0.5 * z);
            } else {
                l3 = new Line(x + s / 4 - z, y, x + s / 4, y - 0.5 * z);
                l4 = new Line(x + s / 4 - z, y, x + s / 4, y + 0.5 * z);
            }
            l5 = new Line(x + s / 4 + 2 * z, y, x + s / 2, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + s / 4 - z * 2);
            l6 = new Line(x, y + s / 4 - z * 2, x + 2 * z, y + s / 4);
            l7 = new Line(x, y + s / 4 - z * 2, x - 2 * z, y + s / 4);
            l8 = new Line(x, y + s / 4 + z * 2, x + 2 * z, y + s / 4);
            l9 = new Line(x, y + s / 4 + z * 2, x - 2 * z, y + s / 4);
            l2 = new Line(x, y + s / 4 - z, x, y + s / 4 + z);
            if (pDot.y < nDot.y) {
                l3 = new Line(x, y + s / 4 + z, x - .5 * z, y + s / 4);
                l4 = new Line(x, y + s / 4 + z, x + .5 * z, y + s / 4);
            } else {
                l3 = new Line(x, y + s / 4 - z, x - .5 * z, y + s / 4);
                l4 = new Line(x, y + s / 4 - z, x + .5 * z, y + s / 4);
            }
            l5 = new Line(x, y + s / 4 + 2 * z, x, y + s / 2);
        }
        l1.setStroke(color);
        l2.setStroke(color);
        l3.setStroke(color);
        l4.setStroke(color);
        l5.setStroke(color);
        l6.setStroke(color);
        l7.setStroke(color);
        l8.setStroke(color);
        l9.setStroke(color);
        pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9);
    }

    private static void pvtCVS(Pane pane, Dot pDot, Dot nDot, Paint color) {
        Line l1, l2, l3, l4, l5, l6, l7, l8, l9;
        if (pDot.x != nDot.x) {
            int x = Math.min(pDot.x, nDot.x);
            int y = pDot.y;
            l1 = new Line(x, y, x + s / 4 - z * 2, y);
            l6 = new Line(x + s / 4 - z * 2, y, x + s / 4, y - z * 2);
            l7 = new Line(x + s / 4 - z * 2, y, x + s / 4, y + z * 2);
            l8 = new Line(x + s / 4 + z * 2, y, x + s / 4, y - z * 2);
            l9 = new Line(x + s / 4 + z * 2, y, x + s / 4, y + z * 2);
            l2 = new Line(x + s / 4 - z, y - 0.5 * z, x + s / 4 - z, y + 0.5 * z);
            l3 = new Line(x + s / 4 + z, y - 0.5 * z, x + s / 4 + z, y + 0.5 * z);
            if (pDot.x < nDot.x) {
                l4 = new Line(x + s / 4 - .5 * z, y, x + s / 4 - 1.5 * z, y);
            } else {
                l4 = new Line(x + s / 4 + .5 * z, y, x + s / 4 + 1.5 * z, y);
            }
            l5 = new Line(x + s / 4 + 2 * z, y, x + s / 2, y);
        } else {
            int x = pDot.x;
            int y = Math.min(pDot.y, nDot.y);
            l1 = new Line(x, y, x, y + s / 4 - z * 2);
            l6 = new Line(x, y + s / 4 - z * 2, x + 2 * z, y + s / 4);
            l7 = new Line(x, y + s / 4 - z * 2, x - 2 * z, y + s / 4);
            l8 = new Line(x, y + s / 4 + z * 2, x + 2 * z, y + s / 4);
            l9 = new Line(x, y + s / 4 + z * 2, x - 2 * z, y + s / 4);
            l2 = new Line(x - .5 * z, y + s / 4 - z, x + .5 * z, y + s / 4 - z);
            l3 = new Line(x - .5 * z, y + s / 4 + z, x + .5 * z, y + s / 4 + z);
            if (pDot.y < nDot.y) {
                l4 = new Line(x, y + s / 4 - .5 * z, x, y + s / 4 - 1.5 * z);
            } else {
                l4 = new Line(x, y + s / 4 + .5 * z, x, y + s / 4 + 1.5 * z);
            }
            l5 = new Line(x, y + s / 4 + 2 * z, x, y + s / 2);
        }
        l1.setStroke(color);
        l2.setStroke(color);
        l3.setStroke(color);
        l4.setStroke(color);
        l5.setStroke(color);
        l6.setStroke(color);
        l7.setStroke(color);
        l8.setStroke(color);
        l9.setStroke(color);
        pane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9);
    }

    public static void drawWire(Pane pane, Dot pDot, Dot nDot, Paint first) {
        Line l;
        l = new Line(pDot.x, pDot.y, nDot.x, nDot.y);
        l.setStroke(first);
        pane.getChildren().add(l);
    }
}
