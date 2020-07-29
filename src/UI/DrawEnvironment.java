package UI;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.File;
import java.io.FileNotFoundException;

public class DrawEnvironment {
    public static void main(String[] args) throws IOException {
        JFrame frame1 = new JFrame("JSpice");
        frame1.setBounds(100, 100, 1200, 700);
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container container = frame1.getContentPane();
        container.setBackground(Color.CYAN);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
        JRootPane rootPane = frame1.getRootPane();
        rootPane.setBorder(border);

        LayoutManager mgr = new GroupLayout(container);
        frame1.setLayout(mgr);

       /* JPanel gifPanel = new JPanel();

        File file = new File("D://LaunchIcon.gif");
        ImageIcon ImageIcon = new ImageIcon("D://LaunchIcon.gif");
        Image image = ImageIcon.getImage();
        frame1.setIconImage(image);*/

        /*BufferedImage myPicture = ImageIO.read(new File("D://LaunchIcon.gif"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        frame1.add(picLabel);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        picLabel.setBounds(300,150,480,330);  //external panel
        p2.setBounds(300,190,400,290);  //inner panel
*/

        URL url = new URL("/res/images/animated.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);

        frame1.getContentPane().add(label);
        frame1.pack();
        frame1.setLocationRelativeTo(null);

        frame1.setLayout(null);
        frame1.pack();
        frame1.setBounds(100, 100, 1200, 700);
        frame1.setVisible(true);
    }
}
