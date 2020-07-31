package UI;

import Kernel.CirSim;
import Kernel.Circuit;
import Kernel.Element;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawResults extends JPanel{
    JFrame frame3 = new JFrame("Simulation Result");
    Stage stage3 = new Stage();
    Pane voltageDiagram = new Pane();
    Pane currentDiagram = new Pane();
    Pane powerDiagram = new Pane();
    List<Element> elementList = Circuit.elementList;

    public void drawResult(Element element){
        frame3.setBounds(100, 50, 1200, 750);
        frame3.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container container = frame3.getContentPane();
        container.setBackground(Color.LIGHT_GRAY);
        JRootPane rootPane = frame3.getRootPane();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
        rootPane.setBorder(border);
        //LayoutManager mgr = new GroupLayout(container);
        frame3.setLayout(null);

        plotVoltage(element);
        plotCurrent(element);
        plotPower(element);

        stage3.setTitle("Simulation Result");

        //frame3.add(voltageDiagram);
        //frame3.add(currentDiagram);
        //frame3.add(powerDiagram);
        frame3.pack();
        frame3.setBounds(100, 100, 1200, 700);
        frame3.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.drawLine(10,10,10,110);
        g.drawLine(10,110,110,110);
    }

    private void plotVoltage(Element element){
        int x=0;
        int y=0;
        double Dt = CirSim.Dt;
        double timeDomain = CirSim.timeDomain;

        DrawResults panel = new DrawResults();
        panel.print(getGraphics());
        Pane pane = new Pane();
        Line line1 = new Line(10,100,110,100);
        Line line2 = new Line(10,100,10,10);
        pane.getChildren().addAll(line1,line2);

        for (Double voltage : element.voltageList) {

        }

    }

    private void plotCurrent(Element element){

    }

    private void plotPower(Element element){

    }


    /*
    public class test extends Application {
        @Override
        public void start(Stage stage) {
            //javafx.scene.control.TextArea textArea = new TextArea();
        /*textArea.setLayoutX(1);
        textArea.setEditable(true);
        textArea.setLayoutX(10);
        textArea.setLayoutY(60);
        textArea.setPrefSize(600,620);
        textArea.setText("");

        Pane pane = new Pane();
        pane.setLayoutX(650);
        pane.setLayoutY(60);
        pane.setPrefSize(100,200);

        XYChart.Series voltageSeries = new XYChart.Series();
        XYChart.Series currentSeries = new XYChart.Series();
        XYChart.Series powerSeries = new XYChart.Series();
        voltageSeries.setName("Voltage");
        currentSeries.setName("Current");
        powerSeries.setName("Power");
        NumberAxis xAxis = new NumberAxis(0, 12, 3);
        xAxis.setLabel("Time");
        NumberAxis V_yAxis = new NumberAxis(0, 16, 4);
        V_yAxis.setLabel("V");
        NumberAxis I_yAxis = new NumberAxis(0, 16, 4);
        V_yAxis.setLabel("I");
        NumberAxis P_yAxis = new NumberAxis(0, 16, 4);
        V_yAxis.setLabel("V");
        //Creating the Scatter chart
        ScatterChart<String, Number> V_scatterChart =
                new ScatterChart(xAxis, V_yAxis);
        ScatterChart<String, Number> I_scatterChart =
                new ScatterChart(xAxis, V_yAxis);
        ScatterChart<String, Number> P_scatterChart =
                new ScatterChart(xAxis, V_yAxis);
        ArrayList<Double> testList = new ArrayList<Double>();
        for (int i = 0; i < 10; i++)
            testList.add((double) (i/10));


            //Prepare XYChart.Series objects by setting data
        double time=0;
        double Dt= CirSim.Dt;
        int index=0;

        for (Element element : Circuit.elementList) {
            voltageSeries.getData().add(new XYChart.Data(String.format("%.2f", time), element.voltageList.get(index)));
            currentSeries.getData().add(new XYChart.Data(String.format("%.2f", time), element.currentList.get(index)));
            powerSeries.getData().add(
                    new XYChart.Data(String.format("%.2f", time), element.currentList.get(index)*element.voltageList.get(index)));
            index++;
            time +=Dt;
        }

            // test!!:
            double time=0;
            double Dt= 0.1;
            int index=0;
            for (Double aDouble : testList) {
                voltageSeries.getData().add(new XYChart.Data(String.format("%.2f", time), testList.get(index)));
                currentSeries.getData().add(new XYChart.Data(String.format("%.2f", time), testList.get(index)));
                powerSeries.getData().add(
                        new XYChart.Data(String.format("%.2f", time), testList.get(index)));

                index++;
                time+=Dt;

            }

            //Setting the data to scatter chart
            V_scatterChart.getData().addAll(voltageSeries);
            I_scatterChart.getData().addAll(currentSeries);
            P_scatterChart.getData().addAll(powerSeries);

            V_scatterChart.setLayoutX(10);
            V_scatterChart.setLayoutY(10);
            I_scatterChart.setLayoutX(300);
            I_scatterChart.setLayoutY(10);
            P_scatterChart.setLayoutX(300);
            P_scatterChart.setLayoutY(10);

            Group root = new Group();
            ObservableList list = root.getChildren();
            list.addAll(V_scatterChart,I_scatterChart,P_scatterChart);

            Scene scene = new Scene(root, 1000, 700);
            stage.setTitle("JSpice");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String args[]){
            launch(args);
        }
    }

     */

