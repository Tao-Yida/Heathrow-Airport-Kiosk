import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * LogInPanels.java
 *
 * This is the log in panel which deals with 3 different log in methods.
 *
 * @author Group 76
 * @version 5.0
 */
public class LogInPanels extends JFrame
{
    public ReadAndWriterCsvFile readAndWriterCsvFile = new ReadAndWriterCsvFile();
    JFrame mainFrame;
    JLabel label0, label1, label2_1, label2_2, label3_1, label3_2;
    JButton button1, button2, button3, buttonNext;
    JTextField textField1, textField2_1, textField2_2;
    ImageIcon icon1, icon2, icon3, icon1_1, icon2_1, icon3_1;
    JPanel panel1 = new JPanel(null);
    JPanel panel2 = new JPanel(null);
    Color lightGray = new Color(247, 247, 247);
    Border border;
    int status = 0;

    /**
     * This method sets up main frame.
     */
    public void setMainFrame()
    {
        mainFrame = new JFrame();
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setSize(1024, 768);
        mainFrame.setLocationRelativeTo(null);
        panel1.setBounds(0, 0, 224, 768);
        panel2.setBounds(224, 0, 800, 768);
        panel2.setBackground(lightGray);

        setLefts(1);
        setRights(1);

        mainFrame.add(panel1);
        mainFrame.add(panel2);
        button1.addActionListener(e -> changeLefts(1));
        button2.addActionListener(e -> changeLefts(2));
        button3.addActionListener(e -> changeLefts(3));
        buttonNext.addActionListener(e ->
        {
            border = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED);
            readAndWriterCsvFile.logString[0] = textField1.getText();      //Get bookingID from the input.
            readAndWriterCsvFile.logString[1] = textField2_1.getText();    //Get Surname from the input.
            readAndWriterCsvFile.logString[2] = textField2_2.getText();    //Get ID Number from the input

            /*
            From now on it will be three different kinds of situations
            The first two require identification
            */
            if (status == 1)
            {
                if (readAndWriterCsvFile.readOneDataFromCSV(readAndWriterCsvFile.logString[0]))
                {
                    int option = JOptionPane.showConfirmDialog(mainFrame, "Have you checked your" +
                            " Booking ID CORRECT?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == 0) {
                        mainFrame.setVisible(false);
                        readAndWriterCsvFile.readDataFromFlightCSV();
                    }
                    else {
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                }
                else
                {
                    textField1.setBorder(border);
                    JOptionPane.showMessageDialog(mainFrame, "Wrong booking number!",
                            "NOTICE", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (status == 2)
            {
                if (readAndWriterCsvFile.readTwoDataFromCSV(readAndWriterCsvFile.logString[1],
                        readAndWriterCsvFile.logString[2]))
                {
                    int option = JOptionPane.showConfirmDialog(mainFrame, "Have you checked your" +
                            " Surname and ID Number CORRECT?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == 0)
                    {
                        mainFrame.setVisible(false);
                        readAndWriterCsvFile.readDataFromFlightCSV();
                    }
                    else
                    {
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                }
                else
                {
                    textField1.setBorder(border);
                    JOptionPane.showMessageDialog(mainFrame, "Wrong Surname or ID Number!",
                            "NOTICE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainFrame.setVisible(true);
    }

    /**
     * This method sets up left options.
     */
    public void setLefts(int i)
    {
        icon1 = new ImageIcon("resource/Buttons/button1.png");
        icon2 = new ImageIcon("resource/Buttons/button2.png");
        icon3 = new ImageIcon("resource/Buttons/button3.png");
        icon1_1 = new ImageIcon("resource/Buttons/button1_1.png");
        icon2_1 = new ImageIcon("resource/Buttons/button2_1.png");
        icon3_1 = new ImageIcon("resource/Buttons/button3_1.png");

        icon1.setImage(icon1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
        icon2.setImage(icon2.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
        icon3.setImage(icon3.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
        icon1_1.setImage(icon1_1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
        icon2_1.setImage(icon2_1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
        icon3_1.setImage(icon3_1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));

        switch (i)
        {
            case (1):
            {
                button1 = new JButton(icon1_1);
                button2 = new JButton(icon2);
                button3 = new JButton(icon3);
                status = 1;
                break;
            }
            case (2):
            {
                button1 = new JButton(icon1);
                button2 = new JButton(icon2_1);
                button3 = new JButton(icon3);
                status = 2;
                break;
            }
            case (3):
            {
                button1 = new JButton(icon1);
                button2 = new JButton(icon2);
                button3 = new JButton(icon3_1);
                status = 3;
                break;
            }
            default:
                JOptionPane.showMessageDialog(mainFrame, "Error");
        }

        button1.setBounds(32, 48, 160, 160);
        button1.setFocusPainted(false);
        button1.setBorderPainted(false);
        button1.setBackground(lightGray);
        button2.setBounds(32, 240, 160, 160);
        button2.setFocusPainted(false);
        button2.setBorderPainted(false);
        button2.setBackground(lightGray);
        button3.setBounds(32, 432, 160, 160);
        button3.setFocusPainted(false);
        button3.setBorderPainted(false);
        button3.setBackground(lightGray);

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
    }

    /**
     * This method provides the function of switching log in methods.
     */
    public void changeLefts(int i)
    {
        switch (i)
        {
            case (1):
            {
                button1.setIcon(icon1_1);
                button2.setIcon(icon2);
                button3.setIcon(icon3);
                status = 1;
                changeRights(1);
                break;
            }
            case (2):
            {
                button1.setIcon(icon1);
                button2.setIcon(icon2_1);
                button3.setIcon(icon3);
                status = 2;
                changeRights(2);
                break;
            }
            case (3):
            {
                button1.setIcon(icon1);
                button2.setIcon(icon2);
                button3.setIcon(icon3_1);
                status = 3;
                changeRights(3);
                break;
            }
            default:
                JOptionPane.showMessageDialog(mainFrame, "Error");
        }
    }

    /**
     * This method sets up right panels.
     */
    public void setRights(int i)
    {
        ImageIcon icon0 = new ImageIcon("resource/Buttons/BritishAirline.png");
        ImageIcon iconNext = new ImageIcon("resource/Buttons/next.png");
        icon0.setImage(icon0.getImage().getScaledInstance(320, 50, Image.SCALE_DEFAULT));
        iconNext.setImage(iconNext.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
        label0 = new JLabel(icon0);
        buttonNext = new JButton(iconNext);
        buttonNext.setBackground(lightGray);
        buttonNext.setFocusPainted(false);
        buttonNext.setBorderPainted(false);
        label0.setBounds(240, 32, 320, 50);
        buttonNext.setBounds(328, 552, 144, 144);
        panel2.add(label0);
        panel2.add(buttonNext);

        // 1
        label1 = new JLabel("Please Input the Booking Number", JLabel.CENTER);
        textField1 = new JTextField(20);
        label1.setFont(new Font("Arial", Font.PLAIN, 30));
        label1.setBounds(160, 180, 500, 50);
        textField1.setFont(new Font("Arial", Font.PLAIN, 30));
        textField1.setBounds(160, 340, 500, 50);
        panel2.add(label1);
        panel2.add(textField1);
        // 2
        label2_1 = new JLabel("Please input your surname:");
        label2_2 = new JLabel("Please input your ID number:");
        textField2_1 = new JTextField(15);
        textField2_2 = new JTextField(20);
        label2_1.setFont(new Font("Arial", Font.PLAIN, 30));
        label2_1.setBounds(160, 180, 500, 50);
        textField2_1.setFont(new Font("Arial", Font.PLAIN, 30));
        textField2_1.setBounds(160, 240, 500, 50);
        label2_2.setFont(new Font("Arial", Font.PLAIN, 30));
        label2_2.setBounds(160, 300, 500, 50);
        textField2_2.setFont(new Font("Arial", Font.PLAIN, 30));
        textField2_2.setBounds(160, 360, 500, 50);
        panel2.add(label2_1);
        panel2.add(label2_2);
        panel2.add(textField2_1);
        panel2.add(textField2_2);

        // 3
        label3_1 = new JLabel("Please scan your ID card");
        label3_2 = new JLabel();
        label3_1.setBounds(240, 100, 500, 50);
        label3_1.setFont(new Font("Arial", Font.PLAIN, 30));
        ImageIcon scanIcon = new ImageIcon("resource/Background/ID-card.gif");
        scanIcon.setImage(scanIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        label3_2.setIcon(scanIcon);
        label3_2.setBounds(140, 140, 550, 550);
        panel2.add(label3_1);
        panel2.add(label3_2);

        switch (i)
        {
            case (1): changeRights(1); break;
            case (2): changeRights(2); break;
            case (3): changeRights(3); break;
            default: JOptionPane.showMessageDialog(mainFrame, "Error");
        }
    }

    /**
     * This method switch right panels.
     */
    public void changeRights(int i)
    {
        switch (i)
        {
            case (1):
            {
                label1.setVisible(true);
                label2_1.setVisible(false);
                label2_2.setVisible(false);
                label3_1.setVisible(false);
                label3_2.setVisible(false);
                textField1.setVisible(true);
                textField2_1.setVisible(false);
                textField2_2.setVisible(false);
                buttonNext.setVisible(true);
                break;
            }
            case (2):
            {
                label1.setVisible(false);
                label2_1.setVisible(true);
                label2_2.setVisible(true);
                label3_1.setVisible(false);
                label3_2.setVisible(false);
                textField1.setVisible(false);
                textField2_1.setVisible(true);
                textField2_2.setVisible(true);
                buttonNext.setVisible(true);
                break;
            }
            case (3):
            {
                label1.setVisible(false);
                label2_1.setVisible(false);
                label2_2.setVisible(false);
                label3_1.setVisible(true);
                label3_2.setVisible(true);
                textField1.setVisible(false);
                textField2_1.setVisible(false);
                textField2_2.setVisible(false);
                buttonNext.setVisible(false);
                break;
            }
            default:
                JOptionPane.showMessageDialog(mainFrame, "Error");
        }
        panel2.updateUI();
    }
}


