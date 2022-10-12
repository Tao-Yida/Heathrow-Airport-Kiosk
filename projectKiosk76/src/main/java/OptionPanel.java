import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * OptionPanel.java
 * <p>
 * This is the Option panel which offers extra options.
 *
 * @author Group 76
 * @version 5.0
 */
public class OptionPanel
{
    public static JFrame frame = new JFrame();
    public static int price;
    int flag = 0;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JPanel panel8 = new JPanel();
    JPanel panel9 = new JPanel();
    JButton button1 = new JButton();//home
    JButton button2 = new JButton();//back
    JButton button3 = new JButton();//next
    JButton button4 = new JButton("Calculate");
    JLabel label1 = new JLabel();//British Airway
    JLabel label2 = new JLabel("Please select your meal type:");
    JLabel label3 = new JLabel("Free");
    JLabel label4 = new JLabel("Extra Option");
    JLabel label5 = new JLabel("Total");
    JLabel label6 = new JLabel();
    ButtonGroup btnGroup1 = new ButtonGroup();
    JRadioButton radioBtn01 = new JRadioButton("Standard");
    JRadioButton radioBtn02 = new JRadioButton("Vegetarian");
    JRadioButton radioBtn03 = new JRadioButton("Halal");
    JCheckBox checkBox01 = new JCheckBox("<html>Fried steak<br>(\u00A320)</html>");
    JCheckBox checkBox02 = new JCheckBox("<html>Kung pao chicken & Rice<br>(\u00A315)</html>");
    JCheckBox checkBox03 = new JCheckBox("<html>Japanese Tonkotsu ramen<br>(\u00A315)</html>");
    JCheckBox checkBox04 = new JCheckBox("<html>Vodka(350ml)<br>(\u00A340)</html>");
    JCheckBox checkBox05 = new JCheckBox("<html>Wine(350ml)<br>(\u00A340)</html>");
    JCheckBox checkBox06 = new JCheckBox("<html>Teddy Bear<br>(\u00A320)</html>");

    /**
     * This method is the initialization method.
     */
    public void init()
    {
        setPanel1();
        setPanel2();
        setPanel4();
        setPanel3();
        setPanel5();
        setPanel6();
        setPanel7();
        setPanel8();
        setPanel9();
        setFrame();
    }

    /**
     * This method is to set the frame.
     */
    public void setFrame()
    {
        frame.setSize(1024, 768);
        frame.setTitle("U0910");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * This method is to set the Panel1.
     */
    public void setPanel1()
    {
        panel1.setLayout(null);
        panel1.setSize(1024, 100);
        panel1.setLocation(0, 0);
        frame.add(panel1);

        button1.setSize(64, 64);
        button1.setLocation(128, 32);
        ImageIcon image1 = new ImageIcon("resource/Buttons/back.png");
        image1.setImage(image1.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        button1.setIcon(image1);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                if (InfoDisplay.classType[0] == 'F')
                {
                    SeatSelection_FirstClass.frame.setVisible(true);
                }
                else if (InfoDisplay.classType[0] == 'B')
                {
                    SeatSelection_BusinessClass.frame.setVisible(true);
                }
                else if (InfoDisplay.classType[0] == 'E')
                {
                    SeatSelection_EconomyClass.frame.setVisible(true);
                }
            }
        });
        panel1.add(button1);

        button2.setSize(64, 64);//ID NUMBER
        button2.setLocation(32, 32);
        ImageIcon image2 = new ImageIcon("resource/Buttons/home.png");
        image2.setImage(image2.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        button2.setIcon(image2);
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                WelcomePanel welcome = new WelcomePanel();
                welcome.initial();
            }
        });
        panel1.add(button2);

        label1.setSize(320, 50);
        label1.setLocation(352, 32);
        ImageIcon image3 = new ImageIcon("resource/Background/BritishAirline.png");
        image3.setImage(image3.getImage().getScaledInstance(320, 50, Image.SCALE_DEFAULT));
        label1.setIcon(image3);
        panel1.add(label1);
    }

    /**
     * This method is to set the Panel2.
     */
    public void setPanel2()
    {
        panel2.setSize(600, 60);
        panel2.setLocation(200, 120);
        frame.add(panel2);

        label2.setFont(new Font(null, Font.BOLD, 30));
        panel2.add(label2, BorderLayout.CENTER);
    }

    /**
     * This method is to set the Panel3.
     */
    public void setPanel3()
    {
        // panel3.setLayout(new GridLayout(4, 1));
        panel3.setSize(250, 350);
        panel3.setLocation(30, 230);
        panel3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        frame.add(panel3);

        label3.setFont(new Font(null, Font.BOLD, 25));
        label3.setLocation(50, 230);
        panel3.add(label3);

    }

    /**
     * This method is to set the Panel4.
     */
    public void setPanel4()
    {
        panel4.setLayout(new GridLayout(3, 1));
        panel4.setSize(130, 200);
        panel4.setLocation(100, 300);
        // panel4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        frame.add(panel4);

        //  radioBtn01.setLocation(50,300);
        radioBtn01.setFont(new Font(null, Font.PLAIN, 16));
        //  radioBtn02.setLocation(50,300);
        radioBtn02.setFont(new Font(null, Font.PLAIN, 16));
        // radioBtn03.setLocation(50,300);
        radioBtn03.setFont(new Font(null, Font.PLAIN, 16));
        radioBtn01.setSelected(true);
        btnGroup1.add(radioBtn01);
        btnGroup1.add(radioBtn02);
        btnGroup1.add(radioBtn03);
        panel4.add(radioBtn01);
        panel4.add(radioBtn02);
        panel4.add(radioBtn03);
    }

    /**
     * This method is to set the Panel5.
     */
    public void setPanel5()
    {
        panel5.setLayout(new GridLayout(3, 1));
        panel5.setSize(230, 200);
        panel5.setLocation(320, 320);
        frame.add(panel5);

        checkBox01.setFont(new Font(null, Font.PLAIN, 16));
        checkBox02.setFont(new Font(null, Font.PLAIN, 16));
        checkBox03.setFont(new Font(null, Font.PLAIN, 16));
        panel5.add(checkBox01);
        panel5.add(checkBox02);
        panel5.add(checkBox03);

    }

    /**
     * This method is to set the Panel6.
     */
    public void setPanel6()
    {
        panel6.setLayout(new GridLayout(3, 1));
        panel6.setSize(180, 200);
        panel6.setLocation(570, 320);
        frame.add(panel6);


        checkBox04.setFont(new Font(null, Font.PLAIN, 16));
        checkBox05.setFont(new Font(null, Font.PLAIN, 16));
        checkBox06.setFont(new Font(null, Font.PLAIN, 16));
        panel6.add(checkBox04);
        panel6.add(checkBox05);
        panel6.add(checkBox06);
    }

    /**
     * This method is to set the Panel7.
     */
    public void setPanel7()
    {
        panel7.setSize(480, 350);
        panel7.setLocation(310, 230);
        panel7.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        frame.add(panel7);

        label4.setFont(new Font(null, Font.BOLD, 25));
        label4.setLocation(310, 230);
        panel7.add(label4);

    }

    /**
     * This method is to set the Panel8.
     */
    public void setPanel8()
    {
        panel8.setLayout(new GridLayout(3, 1));
        panel8.setSize(120, 150);
        panel8.setLocation(820, 350);
        panel8.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        frame.add(panel8);

        label5.setFont(new Font(null, Font.BOLD, 30));
        label5.setLocation(310, 230);
        label6.setFont(new Font(null, Font.BOLD, 30));
        label6.setLocation(310, 250);
        panel8.add(label5);
        panel8.add(label6);
        panel8.add(button4);

        button4.addActionListener(e ->
        {
            flag = 1;
            String strPrice = Integer.toString(calculate());
            label6.setText("\u00A3" + strPrice);
            frame.validate();
        });
    }

    /**
     * This method calculates the total price of all extra goods.
     *
     * @return The total price of goods.
     */
    public int calculate()
    {
        int price = 0;
        if (checkBox01.isSelected())
        {
            price = price + 20;
        }
        if (checkBox02.isSelected())
        {
            price = price + 15;
        }
        if (checkBox03.isSelected())
        {
            price = price + 15;
        }
        if (checkBox04.isSelected())
        {
            price = price + 40;
        }
        if (checkBox05.isSelected())
        {
            price = price + 40;
        }
        if (checkBox06.isSelected())
        {
            price = price + 20;
        }
        this.price = price;
        return price;
    }

    /**
     * This method is to set the Panel9.
     */
    public void setPanel9()
    {
        panel9.setSize(700, 400);
        panel9.setLocation(530, 580);
        frame.add(panel9);

        button3.setSize(140, 140);//next
        ImageIcon image3 = new ImageIcon("resource/Buttons/next.png");
        image3.setImage(image3.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        button3.setIcon(image3);
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (flag == 0)
                {
                    flag = 1;
                    String strPrice = Integer.toString(calculate());
                    label6.setText("\u00A3" + strPrice);
                    frame.validate();
                }
                else if (price == 0)
                {
                    DisplayInfoPanel displayInfoPanel = new DisplayInfoPanel();
                    displayInfoPanel.initial();
                }
                else
                {
                    new OptionReader();
                    OptionReader rc = new OptionReader();
                    rc.ReadStatusData(1);
                    frame.setVisible(false);
                    PaymentSelection selection = new PaymentSelection();
                    selection.init();
                }
            }
        });
        panel9.add(button3);
    }
}
