import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SeatSelection_EconomyClass.java
 * <p>
 * This class provides a page of economy class seats selection which contains 49 seats.
 *
 * @author Group 76
 * @version 5.0
 */
public class SeatSelection_EconomyClass
{
    public static JFrame frame;
    private JPanel panel1 = new JPanel(null);
    private JLabel label0, label1;
    private JRadioButton[] seats;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private ImageIcon homeIcon, backIcon, nextIcon, logoIcon, iconInfo, ecoIcon;
    private ImageIcon availableIcon, extraIcon, occupiedIcon, selectedIcon;
    private Font signFont;

    /**
     * This method sets up the frame.
     */
    public void setUpFrame()
    {
        frame = new JFrame();
        frame.setTitle("Business Class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    /**
     * This method sets up buttons and images.
     */
    public void setButton()
    {
        homeIcon = new ImageIcon("resource/SeatsIcon/home.png");
        backIcon = new ImageIcon("resource/SeatsIcon/back.png");
        nextIcon = new ImageIcon("resource/SeatsIcon/next.png");
        logoIcon = new ImageIcon("resource/Buttons/BritishAirline.png");
        availableIcon = new ImageIcon("resource/SeatsIcon/Available.png");
        extraIcon = new ImageIcon("resource/SeatsIcon/Extra.png");
        occupiedIcon = new ImageIcon("resource/SeatsIcon/Occupied.png");
        selectedIcon = new ImageIcon("resource/SeatsIcon/Selected.png");
        iconInfo = new ImageIcon("resource/SeatsIcon/SeatInfo.png");
        ecoIcon = new ImageIcon("resource/SeatsIcon/Economy.png");

        homeIcon.setImage(homeIcon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        backIcon.setImage(backIcon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        nextIcon.setImage(nextIcon.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
        logoIcon.setImage(logoIcon.getImage().getScaledInstance(320, 50, Image.SCALE_DEFAULT));
        availableIcon.setImage(availableIcon.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));
        extraIcon.setImage(extraIcon.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));
        occupiedIcon.setImage(occupiedIcon.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));
        selectedIcon.setImage(selectedIcon.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));
        iconInfo.setImage(iconInfo.getImage().getScaledInstance(268, 224, Image.SCALE_DEFAULT));
        ecoIcon.setImage(ecoIcon.getImage().getScaledInstance(200, 64, Image.SCALE_DEFAULT));

        //Home.Back.Next
        JButton home = new JButton(homeIcon);
        home.setBorderPainted(false);
        JButton back = new JButton(backIcon);
        JButton next = new JButton(nextIcon);

        next.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int j = 0;
                while(!seats[j].isSelected()){
                    j++;
                    if(j == 49){
                        JOptionPane.showMessageDialog(frame, "Please select a seat!",
                                "NOTICE", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if(j != 49) {
                    frame.setVisible(false);
                    OptionPanel frame = new OptionPanel();
                    frame.init();
                }
            }
        });

        JLabel logo = new JLabel(logoIcon);
        home.setBounds(32, 32, 64, 64);
        back.setBounds(128, 32, 64, 64);
        next.setBounds(815, 554, 128, 128);
        logo.setBounds(352, 32, 320, 50);
        next.setBorderPainted(false);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                InfoDisplay.frame.setVisible(true);
//                ReadAndWriterCsvFile readAndWriterCsvFile = new ReadAndWriterCsvFile();
//                readAndWriterCsvFile.readDataFromFlightCSV();
            }
        });
        home.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                WelcomePanel welcome = new WelcomePanel();
                welcome.initial();
            }
        });
        frame.add(home);
        frame.add(back);
        frame.add(next);
        frame.add(logo);

        seats = new JRadioButton[49];
        panel1 = new JPanel(new GridLayout(8, 10));
        panel1.setBounds(64, 120, 600, 512);
        signFont = new Font("Arial", Font.PLAIN, 40);
        String[] status = SeatsReader.seatStatusEconomy;
        JLabel label1_1 = new JLabel(" A");
        JLabel label1_2 = new JLabel(" B");
        JLabel label1_3 = new JLabel(" D");
        JLabel label1_4 = new JLabel(" E");
        JLabel label1_5 = new JLabel(" F");
        JLabel label1_6 = new JLabel(" J");
        JLabel label1_7 = new JLabel(" K");
        JLabel label6 = new JLabel("6");
        JLabel label7 = new JLabel("7");
        JLabel label8 = new JLabel("8");
        JLabel label9 = new JLabel("9");
        JLabel label10 = new JLabel("10");
        JLabel label11 = new JLabel("11");
        JLabel label12 = new JLabel("12");

        label1_1.setFont(signFont);
        label1_2.setFont(signFont);
        label1_3.setFont(signFont);
        label1_4.setFont(signFont);
        label1_5.setFont(signFont);
        label1_6.setFont(signFont);
        label1_7.setFont(signFont);
        label6.setFont(signFont);
        label7.setFont(signFont);
        label8.setFont(signFont);
        label9.setFont(signFont);
        label10.setFont(signFont);
        label11.setFont(signFont);
        label12.setFont(signFont);


        panel1.add(new JLabel(""));
        panel1.add(label1_1);
        panel1.add(label1_2);
        panel1.add(new JLabel(""));
        panel1.add(label1_3);
        panel1.add(label1_4);
        panel1.add(label1_5);
        panel1.add(new JLabel(""));
        panel1.add(label1_6);
        panel1.add(label1_7);

        panel1.add(label6);
        for (int i = 0; i < 49; i++)
        {
            if (i % 7 == 2 || i % 7 == 5)
            {
                panel1.add(new JLabel(""));
            }
            if (i == 7)
                panel1.add(label7);
            else if (i == 14)
                panel1.add(label8);
            else if (i == 21)
                panel1.add(label9);
            else if (i == 28)
                panel1.add(label10);
            else if (i == 35)
                panel1.add(label11);
            else if (i == 42)
                panel1.add(label12);

            if (status[i].equals("A"))
            {
                seats[i] = new JRadioButton(availableIcon);
                seats[i].setSelectedIcon(selectedIcon);
                buttonGroup.add(seats[i]);
            }
            else if (status[i].equals("O"))
            {
                seats[i] = new JRadioButton(occupiedIcon);
                seats[i].setEnabled(false);
            }
            else if (status[i].equals("P"))
            {
                seats[i] = new JRadioButton(extraIcon);
                seats[i].setSelectedIcon(selectedIcon);
                buttonGroup.add(seats[i]);
            }
            else
            {
                System.out.println("Error!");
            }
            seats[i].setBorderPainted(false);

            panel1.add(seats[i]);
        }
    }

    /**
     * This method sets up panels.
     */
    public void setPanels()
    {
        frame.add(panel1);
        label0 = new JLabel(iconInfo);
        label0.setBounds(720, 240, 268, 224);
        label1 = new JLabel(ecoIcon);
        label1.setBounds(768, 32, 200, 64);
        frame.add(label0);
        frame.add(label1);
    }

    /**
     * This method launches up the frame.
     */
    public void LaunchUp()
    {
        setUpFrame();
        setButton();
        setPanels();

        frame.setVisible(true);
    }
}
