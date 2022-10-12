import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * DisplayInfoPanel.java
 *
 * This is the last panel which displays information.
 *
 * @author Group 76
 * @version 5.0
 */
public class DisplayInfoPanel extends JFrame
{
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();

    JCheckBox jCheckBox1 = new JCheckBox();
    JCheckBox jCheckBox2 = new JCheckBox();
    JCheckBox jCheckBox3 = new JCheckBox();

    JLabel jLabel1 = new JLabel("Boarding Pass");
    JLabel jLabel2 = new JLabel("Baggage Tag");
    JLabel jLabel3 = new JLabel("Baggage Ticket");

    Waiting waiting = new Waiting();
    Thread thread = new Thread(waiting);

    /**
     * This method sets up panel1.
     */
    public void setJPanel1()
    {
        jPanel1.setLayout(new BorderLayout());
        JLabel jLabel1 = new JLabel("Congratulations!", JLabel.CENTER);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 40));
        jLabel1.setForeground(Color.WHITE);
        jPanel1.setOpaque(false);
        jPanel1.add(jLabel1, BorderLayout.SOUTH);
    }

    /**
     * This method sets up panel2.
     */
    public void setJPanel2()
    {
        jPanel2.setLayout(new BorderLayout());
        JLabel jLabel2 = new JLabel("You have completed all steps!", JLabel.CENTER);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 40));
        jLabel2.setForeground(Color.WHITE);
        jPanel2.setOpaque(false);
        jPanel2.add(jLabel2, BorderLayout.NORTH);
    }

    /**
     * This method sets up panel3.
     */
    public void setJPanel3()
    {
        jPanel3.setLayout(new BorderLayout());
        jPanel3.setOpaque(false);
    }

    /**
     * This method sets up panel4.
     */
    public void setJPanel4()
    {
        JButton jButton = new JButton("Print");
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setBackground(Color.LIGHT_GRAY);
        jButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
        jButton.setFocusPainted(false);
        jButton.setForeground(Color.WHITE);
        Dimension dimension = new Dimension(100, 50);
        jButton.setPreferredSize(dimension);
        jPanel4.setOpaque(false);
        jPanel4.add(jButton);
        jPanel4.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        jButton.addActionListener(e -> {
            jButton.setVisible(false);
            alterPanel4();
            alterPanel5();
        });
    }

    /**
     * This method sets up alter panel4.
     */
    public synchronized void alterPanel4()
    {
        JLabel printingLabel = new JLabel("Printing...");
        printingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        jPanel4.add(printingLabel);
        printingLabel.setVisible(true);

        thread.start();
        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        printingLabel.setVisible(false);


    }

    /**
     * This method sets up alter panel4_2.
     */
    public void alterPanel4_2()
    {
        JLabel printingLabel = new JLabel("All Material Printed.");
        printingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        jPanel4.add(printingLabel);
        printingLabel.setVisible(true);
        printingLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });
    }

    /**
     * This method sets up panel5.
     */
    public void setJPanel5()
    {
        jLabel1.setFont(new Font("Arial", Font.BOLD, 30));
        jLabel1.setForeground(Color.BLACK);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 30));
        jLabel2.setForeground(Color.BLACK);
        jLabel3.setFont(new Font("Arial", Font.BOLD, 30));
        jLabel3.setForeground(Color.BLACK);
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox1.setEnabled(false);
        jCheckBox2.setEnabled(false);
        jCheckBox3.setEnabled(false);
        jCheckBox1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jCheckBox2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jCheckBox3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jCheckBox1.setOpaque(false);
        jCheckBox2.setOpaque(false);
        jCheckBox3.setOpaque(false);
        jPanel5.add(jLabel1);
        jPanel5.add(jCheckBox1);
        jPanel5.add(jLabel2);
        jPanel5.add(jCheckBox2);
        jPanel5.add(jLabel3);
        jPanel5.add(jCheckBox3);
        jPanel5.setOpaque(false);
    }

    /**
     * This method sets up alter panel5.
     */
    public void alterPanel5()
    {
        jCheckBox1.setSelected(true);
        jCheckBox2.setSelected(true);
        jCheckBox3.setSelected(true);
    }

    /**
     * This method starts the class.
     */
    public void initial()
    {
        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
        add(jPanel4);
        add(jPanel5);
        setJPanel1();
        setJPanel2();
        setJPanel3();
        setJPanel4();
        setJPanel5();
        new JFrame();
        ImageIcon backgroundImage = new ImageIcon("resource/Background/plane.png");//这是背景图片
        JLabel background = new JLabel(backgroundImage);
        getLayeredPane().add(background, Integer.MIN_VALUE);
        background.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        Container cp = background.getRootPane().getContentPane();
        ((JPanel) cp).setOpaque(false);
        cp.setLayout(new FlowLayout());
        getLayeredPane().setLayout(null);
        getLayeredPane().add(background, Integer.MIN_VALUE);
        setTitle("Printing");
        setSize(1024, 768);
        setLayout(new GridLayout(5, 1));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    class Waiting implements Runnable
    {
        public void run()
        {
            try
            {
                thread.join(1500);
                alterPanel4_2();

            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }

}
