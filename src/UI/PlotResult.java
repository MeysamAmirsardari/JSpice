package UI;

import Kernel.CirSim;
import Kernel.Circuit;
import Kernel.Element;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlotResult extends Application {

    @Override
    public void start(Stage stage) {
        //Defining the x an y axes
        CategoryAxis timeAxis = new CategoryAxis();
        NumberAxis VIP_Axis = new NumberAxis();
        NumberAxis V_Axis = new NumberAxis();
        NumberAxis I_Axis = new NumberAxis();
        NumberAxis P_Axis = new NumberAxis();

        //Setting labels for the axes
        timeAxis.setLabel("Time");
        VIP_Axis.setLabel("Value");
        V_Axis.setLabel("Voltage");
        I_Axis.setLabel("Current");
        P_Axis.setLabel("Power");

        //Creating a line chart
        LineChart<String, Number> vipChart = new LineChart<String, Number>(timeAxis, VIP_Axis);
        LineChart<String, Number> voltageChart = new LineChart<String, Number>(timeAxis, V_Axis);
        LineChart<String, Number> currentChart = new LineChart<String, Number>(timeAxis, I_Axis);
        LineChart<String, Number> powerChart = new LineChart<String, Number>(timeAxis, P_Axis);


        XYChart.Series voltageSeries = new XYChart.Series();
        XYChart.Series currentSeries = new XYChart.Series();
        XYChart.Series powerSeries = new XYChart.Series();


        //Preparing the data points for the lines:
        int index=0;
        double time=0;
        double Dt = CirSim.Dt;
        for (Element element : Circuit.elementList) {
            voltageSeries.getData().add(new XYChart.Data(String.format("%.2f", time), element.voltageList.get(index)));
            currentSeries.getData().add(new XYChart.Data(String.format("%.2f", time), element.currentList.get(index)));
            powerSeries.getData().add(new XYChart.Data(
                    String.format("%.2f", time),(element.currentList.get(index)*element.voltageList.get(index))));
            time+=Dt;
            index++;
        }


        // just for test!!
        /*
        ArrayList<Double> testList = new ArrayList<Double>();
        for (int i = 0; i < 10; i++)
            testList.add(-1*i/10.0+0.5);

        double time=0;
        double Dt= 0.1;
        for (Double aDouble : testList) {
            voltageSeries.getData().add(new XYChart.Data(String.format("%.2f", time), aDouble));
            currentSeries.getData().add(new XYChart.Data(String.format("%.2f", time), 1-aDouble));
            powerSeries.getData().add(
                    new XYChart.Data(String.format("%.2f", time), 0.2));
            time+=Dt;
        }*/

        //Setting the name to the line (series)
        voltageSeries.setName("Voltage");
        currentSeries.setName("Current");
        powerSeries.setName("Power");

        //Setting the data to Line chart
        vipChart.getData().addAll(voltageSeries,currentSeries,powerSeries);
        voltageChart.getData().addAll(voltageSeries);
        currentChart.getData().addAll(currentSeries);
        powerChart.getData().addAll(powerSeries);

        //Creating a stack pane to hold the chart
        StackPane VIP_pane = new StackPane(vipChart);
        StackPane V_pane = new StackPane(voltageChart);
        StackPane I_pane = new StackPane(currentChart);
        StackPane P_pane = new StackPane(powerChart);

        //set Locations:
        VIP_pane.setLayoutY(0);
        VIP_pane.setLayoutX(0);
        V_pane.setLayoutY(0);
        V_pane.setLayoutX(500);
        I_pane.setLayoutY(400);
        I_pane.setLayoutX(0);
        P_pane.setLayoutY(400);
        P_pane.setLayoutX(500);

        //pane.setPadding(new Insets(15, 15, 15, 15));
        VIP_pane.setStyle("-fx-background-color: BEIGE");
        V_pane.setStyle("-fx-background-color: azure");
        I_pane.setStyle("-fx-background-color: azure");
        P_pane.setStyle("-fx-background-color: BEIGE");

        //Setting the Scene
        Group root = new Group();
        ObservableList list = root.getChildren();
        list.addAll(V_pane,I_pane,P_pane,VIP_pane);

        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Simulation Result");
        stage.setScene(scene);
        stage.show();
    }

    public static void plot(String args[]){
        launch(args);
    }
}