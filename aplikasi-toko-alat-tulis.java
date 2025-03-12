import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

// Kelas utama untuk menjalankan aplikasi
public class AplikasiTokoAlatTulis {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrameLogin("Danendra", "123230169");
        });
    }
}

// Frame Login - Frame 1
class FrameLogin extends JFrame {
    private JTextField fieldNama;
    private JPasswordField fieldPassword;
    private JButton tombolLogin;
    private JButton tombolReset;
    private int percobaan = 0;
    private String namaValid;
    private String passwordValid;

    public FrameLogin(String nama, String password) {
        this.namaValid = nama;
        this.passwordValid = password;
        
        setTitle("Halaman Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Membuat komponen
        JLabel labelNama = new JLabel("Username:");
        JLabel labelPassword = new JLabel("Password:");
        fieldNama = new JTextField(20);
        fieldPassword = new JPasswordField(20);
        tombolLogin = new JButton("Login");
        tombolReset = new JButton("Reset");
        
        // Mengatur tata letak
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Menambahkan komponen ke panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelNama, gbc);
        
        gbc.gridx = 1;
        panel.add(fieldNama, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelPassword, gbc);
        
        gbc.gridx = 1;
        panel.add(fieldPassword, gbc);
        
        // Panel tombol
        JPanel panelTombol = new JPanel();
        panelTombol.add(tombolLogin);
        panelTombol.add(tombolReset);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelTombol, gbc);
        
        // Menambahkan panel ke frame
        add(panel);
        
        // Menambahkan aksi untuk tombol
        tombolLogin.addActionListener(e -> login());
        tombolReset.addActionListener(e -> resetField());
        
        setVisible(true);
    }
    
    private void login() {
        String namaMasukan = fieldNama.getText();
        String passwordMasukan = new String(fieldPassword.getPassword());
        
        if (namaMasukan.equals(namaValid) && passwordMasukan.equals(passwordValid)) {
            dispose(); // Tutup jendela login
            new FrameUtama(namaValid); // Buka jendela utama
        } else {
            percobaan++;
            if (percobaan >= 3) {
                JOptionPane.showMessageDialog(this, 
                    "Akun terkunci, hubungi admin.", 
                    "Pesan", 
                    JOptionPane.INFORMATION_MESSAGE);
                tombolLogin.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Username atau password salah.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void resetField() {
        fieldNama.setText("");
        fieldPassword.setText("");
    }
}

// Frame Utama - Frame 2
class FrameUtama extends JFrame {
    private JTextField fieldPensil;
    private JTextField fieldPulpen;
    private JTextField fieldBuku;
    private JButton tombolBeli;
    private JButton tombolLogout;
    private String nama;
    
    public FrameUtama(String nama) {
        this.nama = nama;
        
        setTitle("Halaman Utama");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Membuat komponen
        JLabel labelSambutan = new JLabel("Selamat Datang, " + nama);
        JLabel labelPensil = new JLabel("Pensil (Rp2.000):");
        JLabel labelPulpen = new JLabel("Pulpen (Rp5.000):");
        JLabel labelBuku = new JLabel("Buku Tulis (Rp10.000):");
        
        fieldPensil = new JTextField("0", 5);
        fieldPulpen = new JTextField("0", 5);
        fieldBuku = new JTextField("0", 5);
        
        tombolBeli = new JButton("Beli");
        tombolLogout = new JButton("Logout");
        
        // Mengatur tata letak
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Menambahkan komponen ke panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(labelSambutan, gbc);
        
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelPensil, gbc);
        
        gbc.gridx = 1;
        panel.add(fieldPensil, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelPulpen, gbc);
        
        gbc.gridx = 1;
        panel.add(fieldPulpen, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelBuku, gbc);
        
        gbc.gridx = 1;
        panel.add(fieldBuku, gbc);
        
        // Panel tombol
        JPanel panelTombol = new JPanel();
        panelTombol.add(tombolBeli);
        panelTombol.add(tombolLogout);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelTombol, gbc);
        
        // Menambahkan panel ke frame
        add(panel);
        
        // Menambahkan aksi untuk tombol
        tombolBeli.addActionListener(e -> prosesPembelian());
        tombolLogout.addActionListener(e -> logout());
        
        setVisible(true);
    }
    
    private void prosesPembelian() {
        try {
            int jumlahPensil = Integer.parseInt(fieldPensil.getText());
            int jumlahPulpen = Integer.parseInt(fieldPulpen.getText());
            int jumlahBuku = Integer.parseInt(fieldBuku.getText());
            
            if (jumlahPensil < 0 || jumlahPulpen < 0 || jumlahBuku < 0) {
                JOptionPane.showMessageDialog(this, 
                    "Tidak boleh memasukkan bilangan negatif.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Menghitung subtotal
            int totalPensil = jumlahPensil * 2000;
            int totalPulpen = jumlahPulpen * 5000;
            int totalBuku = jumlahBuku * 10000;
            int subtotal = totalPensil + totalPulpen + totalBuku;
            
            // Menghitung diskon
            int diskon = 0;
            int persenDiskon = 0;
            
            if (subtotal > 100000) {
                persenDiskon = 20;
                diskon = subtotal * 20 / 100;
            } else if (subtotal > 50000) {
                persenDiskon = 10;
                diskon = subtotal * 10 / 100;
            }
            
            // Jika ada diskon, tampilkan pesan
            if (persenDiskon > 0) {
                JOptionPane.showMessageDialog(this, 
                    "Selamat, Anda mendapatkan diskon " + persenDiskon + "%!", 
                    "Pesan", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Menghitung total setelah diskon
            int total = subtotal - diskon;
            
            // Membuka frame pembelian
            new FramePembelian(
                nama,
                jumlahPensil, jumlahPulpen, jumlahBuku,
                totalPensil, totalPulpen, totalBuku,
                subtotal, persenDiskon, diskon, total
            );
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Masukkan angka yang valid.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void logout() {
        dispose(); // Tutup jendela utama
        new FrameLogin("Danendra", "123230169"); // Buka kembali jendela login
    }
}

// Frame Pembelian - Frame 3
class FramePembelian extends JFrame {
    private JButton tombolKembali;
    
    public FramePembelian(
        String nama,
        int jumlahPensil, int jumlahPulpen, int jumlahBuku,
        int totalPensil, int totalPulpen, int totalBuku,
        int subtotal, int persenDiskon, int diskon, int total
    ) {
        setTitle("Halaman Pembelian");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Format mata uang dengan locale Indonesia
        NumberFormat formatUang = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        
        // Membuat komponen
        JLabel labelJudul = new JLabel("Daftar Pembelian:");
        
        JPanel panelBarang = new JPanel(new GridLayout(0, 1));
        if (jumlahPensil > 0) {
            panelBarang.add(new JLabel("Pensil: " + jumlahPensil + " x Rp2.000 = Rp" + totalPensil));
        }
        if (jumlahPulpen > 0) {
            panelBarang.add(new JLabel("Pulpen: " + jumlahPulpen + " x Rp5.000 = Rp" + totalPulpen));
        }
        if (jumlahBuku > 0) {
            panelBarang.add(new JLabel("Buku Tulis: " + jumlahBuku + " x Rp10.000 = Rp" + totalBuku));
        }
        
        JLabel labelSubtotal = new JLabel("Subtotal: Rp" + subtotal);
        
        JLabel labelDiskon = null;
        if (diskon > 0) {
            labelDiskon = new JLabel("Diskon " + persenDiskon + "% : " + diskon);
        }
        
        JLabel labelTotal = new JLabel("Total Harga: Rp" + total);
        
        tombolKembali = new JButton("Kembali");
        
        // Mengatur tata letak
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Menambahkan komponen ke panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelJudul, gbc);
        
        gbc.gridy = 1;
        panel.add(panelBarang, gbc);
        
        gbc.gridy = 2;
        panel.add(labelSubtotal, gbc);
        
        if (labelDiskon != null) {
            gbc.gridy = 3;
            panel.add(labelDiskon, gbc);
            
            gbc.gridy = 4;
            panel.add(labelTotal, gbc);
            
            gbc.gridy = 5;
        } else {
            gbc.gridy = 3;
            panel.add(labelTotal, gbc);
            
            gbc.gridy = 4;
        }
        
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(tombolKembali, gbc);
        
        // Menambahkan panel ke frame
        add(panel);
        
        // Menambahkan aksi untuk tombol
        tombolKembali.addActionListener(e -> dispose()); // Tutup jendela pembelian
        
        setVisible(true);
    }
}
