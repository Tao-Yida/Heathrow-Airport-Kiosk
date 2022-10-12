import javax.swing.*;
import java.awt.*;

/**
 * This is the Master card panel which accomplishes paypal payment.
 *
 * @author Group 76
 * @version 5.0
 */
public class MasterPanel {
    public static JFrame frame;
    public PayReader readAndWriterCsvFile = new PayReader();
    Font font = new Font("Arial", Font.PLAIN, 40);
    JLabel label1 = new JLabel("Email");
    JLabel label4 = new JLabel("Card number");
    JLabel label5 = new JLabel("Expire month");
    JLabel label6 = new JLabel("Expire year");
    JLabel label7 = new JLabel("CVV");

    JTextField field1 = new JTextField("", 15);
    JTextField field2 = new JTextField("", 15);
    JTextField field3 = new JTextField("", 10);
    String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};
    String[] year = new String[]{"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"};
    JComboBox<String> monthBox = new JComboBox<>(month);
    JComboBox<String> yearBox = new JComboBox<>(year);
    public void setFrame(){
        frame = new JFrame();
        frame.setTitle("Visa Card Payment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public void setPanel(){
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.setBounds(64, 120, 860, 400);
        label1.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);
        label7.setFont(font);
        panel.add(label1);
        panel.add(field1);
        panel.add(label4);
        panel.add(field2);
        panel.add(label5);
        panel.add(monthBox);
        panel.add(label6);
        panel.add(yearBox);
        panel.add(label7);
        panel.add(field3);
        frame.add(panel);
    }
    public void setButton(){

        ImageIcon homeIcon = new ImageIcon("resource/SeatsIcon/home.png");
        ImageIcon backIcon = new ImageIcon("resource/SeatsIcon/back.png");
        ImageIcon nextIcon = new ImageIcon("resource/SeatsIcon/next.png");
        ImageIcon logoIcon = new ImageIcon("resource/Buttons/BritishAirline.png");
        ImageIcon typeIcon = new ImageIcon("resource/PaymentLogo/MasterCard.png");

        homeIcon.setImage(homeIcon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        backIcon.setImage(backIcon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        nextIcon.setImage(nextIcon.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
        logoIcon.setImage(logoIcon.getImage().getScaledInstance(320, 50, Image.SCALE_DEFAULT));
        typeIcon.setImage(typeIcon.getImage().getScaledInstance(120, 80, Image.SCALE_DEFAULT));
        JButton home = new JButton(homeIcon);
        JButton back = new JButton(backIcon);
        JButton next = new JButton(nextIcon);
        JLabel logo = new JLabel(logoIcon);
        JLabel icon = new JLabel(typeIcon);
        home.setBounds(32, 32, 64, 64);
        back.setBounds(128, 32, 64, 64);
        next.setBounds(815, 554, 128, 128);
        logo.setBounds(352, 32, 320, 50);
        icon.setBounds(832,32,120,80);
        home.setBorderPainted(false);
        next.setBorderPainted(false);

        frame.add(home);
        frame.add(back);
        frame.add(next);
        frame.add(logo);
        frame.add(icon);
        home.addActionListener(e -> {
            frame.setVisible(false);
            WelcomePanel welcome = new WelcomePanel();
            welcome.initial();
        });
        back.addActionListener(e -> {
            frame.setVisible(false);
            PaymentSelection.frame.setVisible(true);
        });
        next.addActionListener(e -> {
            readAndWriterCsvFile.logString[1] = field2.getText();    //Get Surname from the input.
            readAndWriterCsvFile.logString[2] = field3.getText();    //Get ID Number from the input
            if(field2.getText().isEmpty() || field3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please Input full information!",
                        "NOTICE", JOptionPane.ERROR_MESSAGE);}
            else{
                if (readAndWriterCsvFile.readTwoDataFromCSV(readAndWriterCsvFile.logString[1],
                        readAndWriterCsvFile.logString[2])) {
                    JOptionPane.showConfirmDialog(null, "Successful Payment", "Successful Payment",
                            JOptionPane.DEFAULT_OPTION);
                    frame.setVisible(false);
                    DisplayInfoPanel displayInfoPanel = new DisplayInfoPanel();
                    displayInfoPanel.initial();
                } else {
                    JOptionPane.showMessageDialog(frame, "Wrong Card number or CVV!",
                            "NOTICE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * This method starts the panel.
     */
    public void init(){
        setFrame();
        setPanel();
        setButton();
        frame.setVisible(true);
    }
}
