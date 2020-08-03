package UI;

import Kernel.Circuit;
import Kernel.Element;
import Kernel.Launcher;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class DrawEnvironment extends Application {
    public static File selectedFile=null;
    public static String[] Args;
    public static Element element;

    @Override
    public void start(Stage stage) throws Exception {
        Preview.showFirstPage(Args);
        DropShadow shadow = new DropShadow();

        TextArea editorArea = new TextArea();
        editorArea.setPrefColumnCount(15);
        editorArea.setPrefSize(660,720);
        editorArea.setLayoutX(10);
        editorArea.setLayoutY(70);
        editorArea.setEffect(shadow);

        TextField dataField = new TextField();
        dataField.setEditable(false);
        dataField.setPrefSize(300,410);
        dataField.setLayoutX(690);
        dataField.setLayoutY(380);
        writeDetails(dataField);
        dataField.setEffect(shadow);

        Pane schematicPane = new Pane();
        schematicPane.setPrefSize(300,300);
        schematicPane.setLayoutX(690);
        schematicPane.setLayoutY(70);
        schematicPane.setVisible(true);
        //drawElements(schematicPane);
        schematicPane.setEffect(shadow);

        Button loadButton = new Button();
        loadButton.setPrefSize(60,25);
        loadButton.setWrapText(true);
        loadButton.setEffect(shadow);
        loadButton.setText("Load");
        loadButton.setLayoutX(70);
        loadButton.setLayoutY(20);

        // create a File chooser
        FileChooser fil_chooser = new FileChooser();
        fil_chooser.setTitle("Select File");
        fil_chooser.setInitialDirectory(new File("D:\\"));

        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                File file = fil_chooser.showOpenDialog(stage);
                if (file != null) {
                    selectedFile = new File(file.getAbsolutePath());
                    String filepath = selectedFile.getPath();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(filepath));
                        String step = "", input = "";
                        while ((step = br.readLine()) != null) {
                            input += step + "\n";
                        }
                        editorArea.setText(input);
                        br.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } );


        Button runButton =new Button();
        runButton.setPrefSize(60,25);
        runButton.setWrapText(true);
        runButton.setEffect(shadow);
        runButton.setText("Run");
        runButton.setLayoutX(160);
        runButton.setLayoutY(20);

        runButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (selectedFile!=null) {
                    if (!editorArea.getText().isEmpty()) {
                        try {
                            FileWriter fileWriter = new FileWriter(selectedFile);
                            String inputText = editorArea.getText();
                            fileWriter.write("");
                            fileWriter.write(inputText);
                            fileWriter.close();
                        } catch(FileNotFoundException notFoundException){
                            notFoundException.printStackTrace();
                        } catch(IOException ioException){
                            ioException.printStackTrace();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error!");
                        alert.setHeaderText("Error!");
                        alert.setContentText("No command entered!");
                        alert.showAndWait();
                    }
                    try {
                        Launcher.launch(selectedFile.getPath());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Error!");
                    alert.setContentText("The elected file is not available!");
                    alert.showAndWait();
                }
            }
        } );


        Button plotButton =new Button();
        plotButton.setPrefSize(60,25);
        plotButton.setWrapText(true);
        plotButton.setEffect(shadow);
        plotButton.setText("Plot");
        plotButton.setLayoutX(250);
        plotButton.setLayoutY(20);

        plotButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                TextInputDialog textDialog = new TextInputDialog("");
                textDialog.setHeaderText("Please enter the name of the element:");
                textDialog.showAndWait();
                String elementName = textDialog.getResult();
                element = findElement(elementName);
                if (element!=null)
                    PlotResult.plot(Args);
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Error!");
                    alert.setContentText("Element not found!");
                    alert.showAndWait();
                }
            }
        } );


        //Group root = new Group();
        Pane rootPane = new Pane();
        ObservableList list = rootPane.getChildren();
        rootPane.setStyle("-fx-background-color: azure");
        list.addAll(loadButton,runButton,plotButton,editorArea,dataField,schematicPane);
        Scene scene=new Scene(rootPane,1000,800);
        //root.getChildren().add(loadButton);
        stage.setScene(scene);
        stage.setTitle("JSpice");
        stage.show();
    }
    public static void makeEnvironment(String[] args) {
        Args = args;
        launch(args);
    }

    private static void writeDetails(TextField field){
    }

    private static Element findElement(String elementName){
        for (Element element1 : Circuit.elementList) {
            if (element1.getName().equals(elementName))
                return element1;
        }
        return null;
    }
}

