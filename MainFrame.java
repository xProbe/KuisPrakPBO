package pkg123230169_kuis;

/**
 *
 * @author dann
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(String nim) {
        setTitle("Main Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Selamat Datang, " + nim);
        JButton anakButton = new JButton("DVD Anak");
        JButton dewasaButton = new JButton("DVD Dewasa");
        JButton lansiaButton = new JButton("DVD Lansia");

        anakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaseFrame("DVD Anak", 27891).setVisible(true);
                dispose();
            }
        });

        dewasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaseFrame("DVD Dewasa", 35396).setVisible(true);
                dispose();
            }
        });

        lansiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaseFrame("DVD Lansia", 38550).setVisible(true);
                dispose();
            }
        });

        panel.add(welcomeLabel);
        panel.add(anakButton);
        panel.add(dewasaButton);
        panel.add(lansiaButton);

        add(panel);
    }
}

