import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * WelcomePanel.java
 *
 * This is our first welcome page.
 *
 * @author Group 76
 * @version 5.0
 */
public class WelcomePanel extends JFrame
{
    JPanel jPanel1 = new JPanel();

    public void setJPanel1()
    {
        jPanel1.setLayout(new GridLayout(2, 1));
        JLabel jLabel1 = new JLabel("Welcome to London Heathrow Kiosk.", JLabel.CENTER);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 45));
        jLabel1.setForeground(Color.WHITE);
        jPanel1.setOpaque(false);
        jPanel1.add(jLabel1, BorderLayout.CENTER);
        JLabel jLabel2 = new JLabel("Press Anywhere to Start", JLabel.CENTER);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 30));
        jPanel1.add(jLabel2, BorderLayout.CENTER);
        jumpFrame();
        Timer timer = new Timer(800, e ->
        {
            if (!jLabel2.isVisible())
            {
                jLabel2.setVisible(true);
            }
            else if (jLabel2.isVisible())
            {
                jLabel2.setVisible(false);
            }
        });
        timer.start();
    }

    public void jumpFrame()
    {
        jPanel1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                dispose();
                LogInPanels logInPanels = new LogInPanels();
                logInPanels.setMainFrame();
            }
        });
    }

    public void setBackgroundImage()
    {
        ImageIcon backgroundImage = new ImageIcon("resource/Background/plane.png");//这是背景图片
        JLabel background = new JLabel(backgroundImage);
        getLayeredPane().add(background, Integer.MIN_VALUE);
        background.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        Container cp = background.getRootPane().getContentPane();
        ((JPanel) cp).setOpaque(false);
        cp.setLayout(new FlowLayout());
        getLayeredPane().setLayout(null);
        getLayeredPane().add(background, Integer.MIN_VALUE);
    }

    public void initial()
    {
        add(jPanel1);
        setJPanel1();
        new JFrame();
        setBackgroundImage();
        setSize(1024, 768);
        setLayout(new CardLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
