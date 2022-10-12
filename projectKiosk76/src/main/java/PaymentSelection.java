import javax.swing.*;
import java.awt.*;

/**
 * PaymentSelection.java
 *
 * This is the payment selection panel in which 3 payment methods could be selected.
 *
 * @author Group 76
 * @version 5.0
 */
public class PaymentSelection {
    public static JFrame frame;

    public void setFrame(){
        frame = new JFrame();
        frame.setTitle("Payment Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public void setButtons() {
        ImageIcon homeIcon = new ImageIcon("resource/SeatsIcon/home.png");
        ImageIcon backIcon = new ImageIcon("resource/SeatsIcon/back.png");
        ImageIcon logoIcon = new ImageIcon("resource/Buttons/BritishAirline.png");
        ImageIcon nextIcon = new ImageIcon("resource/SeatsIcon/next.png");
        ImageIcon masterSelectedIcon = new ImageIcon("resource/PaymentLogo/MasterCardSelected.png");
        ImageIcon masterUnselectedIcon = new ImageIcon("resource/PaymentLogo/MasterCardUnselected.png");
        ImageIcon visaSelectedIcon = new ImageIcon("resource/PaymentLogo/VisaSelected.png");
        ImageIcon visaUnselectedIcon = new ImageIcon("resource/PaymentLogo/VisaCardUnselected.png");
        ImageIcon paypalSelectedIcon = new ImageIcon("resource/PaymentLogo/PaypalSelected.png");
        ImageIcon paypalUnselectedIcon = new ImageIcon("resource/PaymentLogo/PaypalUnselected.png");
        homeIcon.setImage(homeIcon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        backIcon.setImage(backIcon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        logoIcon.setImage(logoIcon.getImage().getScaledInstance(320, 50, Image.SCALE_DEFAULT));
        nextIcon.setImage(nextIcon.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
        masterSelectedIcon.setImage(masterSelectedIcon.getImage().getScaledInstance(500,120, Image.SCALE_DEFAULT));
        masterUnselectedIcon.setImage(masterUnselectedIcon.getImage().getScaledInstance(500,120, Image.SCALE_DEFAULT));
        visaSelectedIcon.setImage(visaSelectedIcon.getImage().getScaledInstance(500,120, Image.SCALE_DEFAULT));
        visaUnselectedIcon.setImage(visaUnselectedIcon.getImage().getScaledInstance(500,120, Image.SCALE_DEFAULT));
        paypalSelectedIcon.setImage(paypalSelectedIcon.getImage().getScaledInstance(500,120, Image.SCALE_DEFAULT));
        paypalUnselectedIcon.setImage(paypalUnselectedIcon.getImage().getScaledInstance(500,120, Image.SCALE_DEFAULT));

        JLabel logo = new JLabel(logoIcon);
        JButton home = new JButton(homeIcon);
        JButton back = new JButton(backIcon);
        JButton next = new JButton(nextIcon);
        JRadioButton master = new JRadioButton(masterUnselectedIcon);
        JRadioButton visa = new JRadioButton(visaUnselectedIcon);
        JRadioButton paypal = new JRadioButton(paypalUnselectedIcon);
        master.setSelectedIcon(masterSelectedIcon);
        visa.setSelectedIcon(visaSelectedIcon);
        paypal.setSelectedIcon(paypalSelectedIcon);
        home.setBorderPainted(false);
        next.setBorderPainted(false);

        home.setBounds(32, 32, 64, 64);
        back.setBounds(128, 32, 64, 64);
        logo.setBounds(352, 32, 320, 50);
        next.setBounds(815, 554, 128, 128);
        visa.setBounds(234,256,500,120);
        master.setBounds(234,373,500,120);
        paypal.setBounds(234,490,500,120);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(master);
        buttonGroup.add(visa);
        buttonGroup.add(paypal);

        frame.add(home);
        frame.add(back);
        frame.add(logo);
        frame.add(next);
        frame.add(master);
        frame.add(visa);
        frame.add(paypal);


        back.addActionListener(e -> {
            frame.setVisible(false);
            OptionPanel.frame.setVisible(true);
        });
        home.addActionListener(e -> {
            frame.setVisible(false);
            WelcomePanel welcome = new WelcomePanel();
            welcome.initial();
        });
        next.addActionListener(e -> {
            frame.setVisible(false);
            if(visa.isSelected()){
                CreditPanel creditPanel = new CreditPanel();
                creditPanel.init();
            }
            else if(master.isSelected()){
                MasterPanel masterPanel = new MasterPanel();
                masterPanel.init();
            }
            else if(paypal.isSelected()){
                PaypalPanel paypalPanel = new PaypalPanel();
                paypalPanel.init();
            }
        });

    }

    public void setLabel(){
        JLabel jLabel1 = new JLabel("Please select your payment method: ");
        JLabel jLabel2 = new JLabel("Your total payment is " + OptionPanel.price + "\u00A3"+".");
        jLabel1.setFont(new Font(null, Font.BOLD, 40));
        jLabel2.setFont(new Font(null, Font.BOLD, 40));
        jLabel1.setBounds(150,100,800,100);
        jLabel2.setBounds(150,150,800,100);
        frame.add(jLabel1);
        frame.add(jLabel2);
    }

    public void init(){
        setFrame();
        setButtons();
        setLabel();
        frame.setVisible(true);
    }

}
