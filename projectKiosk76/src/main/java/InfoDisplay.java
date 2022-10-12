import javax.swing.*;
import java.awt.*;

/**
 * InfoDisplay.java
 *
 * This is the information display panel which displays flight information.
 *
 * @author Group 76
 * @version 5.0
 */
public class InfoDisplay
{
    // This string is to carry those information entered in the MyFrame.java.
    public String[] flightString = new String[10];
    public static JFrame frame;
    public static char[] classType;
    // Instantiating three JPanels.
    JLabel jLabel0 = new JLabel();
    JPanel jPanel1 = new JPanel();// jPanel1 is the heading of the frame, displaying the title with a jLabel.
    JPanel jPanel2 = new JPanel();// jPanel2 has a JTextArea, displaying the information entered in MyFrame.java.
    JPanel jPanel3 = new JPanel();// jPanel3 has a JButton: "Finish".
    // Instantiating a JTextArea, in order to display the information.
    JTextArea jTextArea = new JTextArea();// Used to display the information entered.

    /**
     * This method sets the first panel of the frame.
     */
    public void setJPanel1()
    {
        // Setting jPanel to BorderLayout, and setting the title on its center.
        jPanel1.setLayout(null);
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        button1.setSize(64, 64);
        button1.setLocation(128, 32);
        ImageIcon image1 = new ImageIcon("resource/Buttons/back.png");
        image1.setImage(image1.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        button1.setIcon(image1);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.addActionListener(e -> {
            frame.setVisible(false);
            LogInPanels logInPanels = new LogInPanels();
            logInPanels.setMainFrame();
        });
        button2.addActionListener(e -> {
            frame.setVisible(false);
            WelcomePanel welcome = new WelcomePanel();
            welcome.initial();
        });

        jPanel1.add(button1);

        button2.setSize(64, 64);//ID NUMBER按钮
        button2.setLocation(32, 32);
        ImageIcon image2 = new ImageIcon("resource/Buttons/home.png");//按钮图片
        image2.setImage(image2.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));//图片大小
        button2.setIcon(image2);//图片插到按钮里
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        jPanel1.add(button2);

        jLabel0.setSize(320, 50);
        jLabel0.setLocation(352, 32);
        ImageIcon image3 = new ImageIcon("resource/Background/BritishAirline.png");//图片
        image3.setImage(image3.getImage().getScaledInstance(320, 50, Image.SCALE_DEFAULT));//图片大小
        jLabel0.setIcon(image3);

        JLabel jLabel1 = new JLabel("Dear passenger, have you prepared for your flight?");
        jLabel1.setSize(1000, 150);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 33));
        jLabel1.setLocation(60, 100);
        jPanel1.add(jLabel0);
        jPanel1.add(jLabel1);
    }

    /**
     * This method sets the second panel of the frame.
     */
    public void setJPanel2()
    {
        // Displaying the information obtained in MyFrame.java.
        jTextArea.append("\n" + "      " + flightString[1] + "-->" + flightString[2] + "          " + flightString[6] +
                "\n" + "      " + "Flight No.: " + flightString[0] + "               " + "Gate: " + flightString[3] +
                "\n" + "      " + "Boarding Time: " + flightString[4] + "\n" + "      " + "Departure Time: " + flightString[5])
        ;
        // Therefore the JTextArea can change line automatically.
        jTextArea.setLineWrap(true);
        // Setting fonts of the JTextArea.
        jTextArea.setFont(new Font("Arial", Font.ITALIC, 40));
        jTextArea.setForeground(Color.BLACK);
        // Disabling edition of the JTextArea.
        jTextArea.setEditable(false);
        jTextArea.setBounds(112, 250, 800, 300);
        // Creating two borders with lower bevel.
        jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
        jTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
        frame.add(jTextArea);
    }

    /**
     * This method sets the third panel of the frame.
     */
    public void setJPanel3()
    {
        frame.setLayout(new BorderLayout());

        JButton jButton = new JButton();
        ImageIcon image3 = new ImageIcon("resource/Buttons/next.png");
        image3.setImage(image3.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        jButton.setIcon(image3);
        jButton.setBorderPainted(false);
        jButton.setContentAreaFilled(false);
        jButton.setLocation(600, 700);
        // When the button is pressed, it will quit the program.
        jButton.addActionListener(e -> {
            frame.setVisible(false);
            SeatsReader f = new SeatsReader();
            f.ReadStatusData();
            if (classType[0] == 'F') {
                SeatSelection_FirstClass fClass = new SeatSelection_FirstClass();
                fClass.LaunchUp();
            } else if (classType[0] == 'B') {
                SeatSelection_BusinessClass bClass = new SeatSelection_BusinessClass();
                bClass.LaunchUp();
            } else if (classType[0] == 'E') {
                SeatSelection_EconomyClass ecoClass = new SeatSelection_EconomyClass();
                ecoClass.LaunchUp();
            } else {
                System.out.println("Booking Error.");
            }
        });
        jPanel3.add(jButton);
    }

    /**
     * This method initials a new derived frame of the program.
     */
    public void initial()
    {
        frame = new JFrame();
        frame.setTitle("Check in complete!");
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        jPanel1.setBounds(0, 0, 1000, 200);
        jPanel3.setBounds(0, 580, 1024, 150);
        frame.add(jPanel1);
        frame.add(jPanel2);
        frame.add(jPanel3);
        setJPanel1();
        setJPanel2();
        setJPanel3();
        frame.setVisible(true);
    }
}
