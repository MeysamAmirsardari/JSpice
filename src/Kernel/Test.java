package Kernel;

import UI.Dot;
import UI.DrawElement;
import UI.PlotCircuit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.awt.*;

// DO NOT MODIFY THIS ONLY FOR PLOT CIRCUIT TESTING

public class Test extends Application {
    public static void main(String[] args) {
        System.out.println("hi");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hi there");
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 250);
        Dot dot = new Dot(100, 100, 1);
        Dot dot2 = new Dot(100, 200, 2);
        Dot dot3 = new Dot(200, 100, 3);
        DrawElement.draw("DIODE", pane, dot2, dot, Color.BLACK);
        DrawElement.draw("DIODE", pane, dot3, dot, Color.BLACK);
        stage.setScene(scene);
        stage.show();

    }
}
