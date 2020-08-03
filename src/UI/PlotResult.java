package UI;

import Kernel.CirSim;
import Kernel.Element;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlotResult {

    //@Override
    //public void start(Stage stage) {
    public static void plotResult (Stage stage){
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
        Element element = DrawEnvironment.element;
        double time=0;
        double Dt = CirSim.Dt;

        for (Double voltage : element.voltageList) {
            voltageSeries.getData().add(new XYChart.Data(String.format("%.2f", time), voltage));
            time+=Dt;
        }

        int index=0;
        time=0;

        for (Double current : element.currentList) {
            currentSeries.getData().add(new XYChart.Data(String.format("%.2f", time), element.currentList.get(index)));
            powerSeries.getData().add(new XYChart.Data(
                    String.format("%.2f", time),(element.currentList.get(index)*element.voltageList.get(index))));
            index++;
            time+=Dt;
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

        Button backButton =new Button();
        backButton.setPrefSize(60,25);
        backButton.setWrapText(true);
        backButton.setText("Back");
        backButton.setLayoutX(250);
        backButton.setLayoutY(20);

        //Setting the Scene
        Group root = new Group();
        ObservableList list = root.getChildren();
        list.addAll(V_pane,I_pane,P_pane,VIP_pane);

        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Simulation Result");
        stage.setScene(scene);
        stage.show();

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                root.setVisible(false);
                DrawEnvironment.rootPane.setVisible(true);
            }
        } );
    }

    //public static void plot(String args[]){
    //    launch(args);
    //}
}