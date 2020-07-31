package UI;


import Kernel.Circuit;
import Kernel.Element;
import Kernel.Launcher;
import javafx.scene.control.TextArea;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class DrawEnvironment {
    JFrame frame2;
    JTextArea editorField;
    JScrollPane scroll;

    public static void main(String[] args) throws IOException {
        DrawEnvironment environment = new DrawEnvironment();
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                environment.createAndShowGui();
            }
        });*/
        environment.drawEnvironment();
    }

    public void drawEnvironment() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 3, true);

        // frame setting:
        frame2 = new JFrame("JSpice");
        frame2.setBounds(100, 50, 1200, 750);
        frame2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container container = frame2.getContentPane();
        container.setBackground(Color.LIGHT_GRAY);
        JRootPane rootPane = frame2.getRootPane();
        rootPane.setBorder(border);
        LayoutManager mgr = new GroupLayout(container);
        frame2.setLayout(null);

        JScrollPane scroll;
        JTextArea editorField = new JTextArea(10, 20);
        editorField.setBounds(10, 50, 600, 650);
        editorField.setBorder(border);
        scroll = new JScrollPane(editorField);


        // Button setting:
        JButton loadButton = new JButton("Load");
        loadButton.setBounds(60, 10, 60, 25);
        loadButton.setBackground(Color.GRAY);
        loadButton.setForeground(Color.WHITE);
        border1 = BorderFactory.createLineBorder(Color.cyan, 3, true);
        loadButton.setBorder(border1);
        frame2.add(loadButton);
        //frame2.add(scroll);
        frame2.add(editorField);
        File selectedFile = null;

        loadButton.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             JFileChooser fileChooser = new JFileChooser();
                                             int in = fileChooser.showOpenDialog(frame2);
                                             if (in == JFileChooser.APPROVE_OPTION) {
                                                 File selectedFile = fileChooser.getSelectedFile();
                                                 String filepath = selectedFile.getPath();
                                                 try {
                                                     BufferedReader br = new BufferedReader(new FileReader(filepath));
                                                     String step = "", input = "";
                                                     while ((step = br.readLine()) != null) {
                                                         input += step + "\n";
                                                     }
                                                     editorField.setText(input);
                                                     br.close();
                                                 } catch (Exception ex) {
                                                     ex.printStackTrace();
                                                 }
                                             }
                                         }
                                     }
        );

        JButton runButton = new JButton("Run");
        runButton.setBounds(160, 10, 60, 25);
        runButton.setBackground(Color.GRAY);
        runButton.setForeground(Color.WHITE);
        runButton.setBorder(border1);
        frame2.add(runButton);

        runButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if (!(selectedFile.equals(null))) {
                                                try {
                                                    FileWriter fileWriter = new FileWriter(selectedFile);
                                                    String inputText = editorField.getText();
                                                    fileWriter.write(inputText);
                                                    fileWriter.close();
                                                } catch (FileNotFoundException notFoundException) {
                                                    notFoundException.printStackTrace();
                                                } catch (IOException ioException) {
                                                    ioException.printStackTrace();
                                                }
                                                Launcher.launch(selectedFile.getPath());
                                            } else {
                                                //TODO: Error!
                                            }
                                        }
                                    }
        );

        JButton plotButton = new JButton("Plot");
        plotButton.setBounds(260, 10, 60, 25);
        plotButton.setBackground(Color.GRAY);
        plotButton.setForeground(Color.WHITE);
        plotButton.setBorder(border1);
        frame2.add(plotButton);

        plotButton.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             DrawResults result = new DrawResults();
                                             String elementName = JOptionPane.showInputDialog(frame2,"Enter Name");
                                             Element element = findElement(elementName);
                                             result.drawResult(element);
                                         }
                                     }
        );

        JPanel schematicPanel = new JPanel();
        schematicPanel.setBounds(620, 50, 300, 300);
        schematicPanel.setBackground(Color.WHITE);
        schematicPanel.setBorder(border);
        frame2.add(schematicPanel);

        JTextArea elementsDetails = new JTextArea();
        elementsDetails.setBounds(620, 365, 300, 335);
        elementsDetails.setBackground(Color.WHITE);
        elementsDetails.setBorder(border);
        elementsDetails.setEditable(false);
        frame2.add(elementsDetails);


        frame2.pack();
        frame2.setBounds(100, 100, 1200, 700);
        frame2.setVisible(true);
    }

    public void createAndShowGui() {
        JFrame frame;
        JTextArea textArea;
        frame = new JFrame("ScrollPane to TextArea");
        frame.setLayout(null);
        //JPanel panel = new JPanel();
        //panel.setBounds(10, 10, 500, 500);
        textArea = new JTextArea(); //Rows and cols to be displayed
        textArea.setEditable(true);
        textArea.setSize(100, 100);

        textArea.setBounds(10,10,100,100);
        //scroll = new JScrollPane(textArea);
        //JScrollPane scrollableTextArea = new JScrollPane(textArea);

        //scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        TextArea textArea1 = new TextArea();


        //frame.getContentPane().add(scrollableTextArea);

        //panel.add(textArea);
        //frame.add(scroll); //We add the scroll, since the scroll already contains the textArea
        frame.pack();
        frame.setBounds(0, 0, 1100, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static Element findElement(String elementName){
        for (Element element : Circuit.elementList) {
            if (element.getName().equalsIgnoreCase(elementName))
                return element;
        }
        return null;
    }
}
