/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg123230169_kuis;

/**
 *
 * @author Lab Informatika
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}















































/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author dann
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String reversedNIM = new StringBuilder(username).reverse().toString();

                if (password.equals(reversedNIM)) {
                    new LoginFrame(username).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}







/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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










/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dann
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseFrame extends JFrame {
    public PurchaseFrame(String category, int price) {
        setTitle("Purchase");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel categoryLabel = new JLabel("Kategori: " + category);
        JLabel priceLabel = new JLabel("Harga: Rp" + price + " /pcs");
        JLabel quantityLabel = new JLabel("Jumlah:");
        JTextField quantityField = new JTextField(10);
        JButton buyButton = new JButton("Beli");
        JButton backButton = new JButton("Kembali");

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    double total = price * quantity;
                    double ppn = total * 0.11;
                    double grandTotal = total + ppn;

                    JOptionPane.showMessageDialog(PurchaseFrame.this,
                            "Total Pembelian\n" +
                                    "Harga Satuan: Rp" + price + "\n" +
                                    "Jumlah: " + quantity + " pcs\n" +
                                    "PPN (11%): Rp" + ppn + "\n" +
                                    "Total Harga: Rp" + grandTotal,
                            "Total Pembelian", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PurchaseFrame.this, "Invalid quantity", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame("123456789").setVisible(true);
                dispose();
            }
        });

        panel.add(categoryLabel);
        panel.add(priceLabel);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(buyButton);
        panel.add(backButton);

        add(panel);
    }
}