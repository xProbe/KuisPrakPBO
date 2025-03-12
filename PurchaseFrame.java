package pkg123230169_kuis;



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