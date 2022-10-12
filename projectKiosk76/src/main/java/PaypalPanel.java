import javax.swing.*;
import java.awt.*;

/**
 * PaypalPanel.java
 *
 * This is the Paypal panel which accomplishes paypal payment.
 *
 * @author Group 76
 * @version 5.0
 */
public class PaypalPanel {
    public static JFrame frame;
    private ImageIcon homeIcon, backIcon, nextIcon, logoIcon, typeIcon;
    public PayReader readAndWriterCsvFile = new PayReader();
    Font font = new Font("Arial", Font.PLAIN, 40);
    JLabel label1 = new JLabel("Account ID");
    JLabel label2 = new JLabel("Password");
    JTextField field1 = new JTextField("", 15);
    JTextField field2 = new JTextField("", 15);

    /**
     * This method sets up the main frame.
     */
    public void setFrame(){
        frame = new JFrame();
        frame.setTitle("Visa Card Payment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    /**
     * This methods sets up panels.
     */
    public void setPanel(){
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.setBounds(64, 240, 860, 200);
        label1.setFont(font);
        label2.setFont(font);
        field1.setSize(300,50);
        field2.setSize(300,50);
        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);

        frame.add(panel);
    }

    /**
     * This method sets up buttons.
     */
    public void setButton(){
        homeIcon = new ImageIcon("resource/SeatsIcon/home.png");
        backIcon = new ImageIcon("resource/SeatsIcon/back.png");
        nextIcon = new ImageIcon("resource/SeatsIcon/next.png");
        logoIcon = new ImageIcon("resource/Buttons/BritishAirline.png");
        typeIcon = new ImageIcon("resource/PaymentLogo/Paypal.png");

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
        next.addActionListener(e ->
        {
            if(field1.getText().isEmpty() || field2.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please Input full information!",
                        "NOTICE", JOptionPane.ERROR_MESSAGE);
            }
            else if(field1.getText().equals("1231231231231231") && field2.getText().equals("444")) {
                frame.setVisible(false);
                DisplayInfoPanel displayInfoPanel = new DisplayInfoPanel();
                displayInfoPanel.initial();
            }
            else{
                JOptionPane.showMessageDialog(frame, "Wrong Information",
                        "NOTICE", JOptionPane.ERROR_MESSAGE);
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
