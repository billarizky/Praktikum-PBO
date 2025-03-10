package tugas1pbo_123230210;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class LoginApp {
    private static ArrayList<String> dataList = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginApp::buatHalamanLogin);
    }

    private static void buatHalamanLogin() {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        
        JLabel lblUser = new JLabel("Username:");
        JTextField txtUser = new JTextField(15);
        JLabel lblPass = new JLabel("Password:");
        JPasswordField txtPass = new JPasswordField(15);
        JButton btnLogin = new JButton("Login");
        JLabel lblMessage = new JLabel("");
        
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(btnLogin);
        panel.add(lblMessage);
        
        btnLogin.addActionListener(e -> {
            String user = txtUser.getText().toLowerCase();
            String pass = new String(txtPass.getPassword()).toLowerCase();
            if (user.equals("pbo") && pass.equals("if-d")) {
                frame.dispose();
                buatHalamanUtama();
            } else {
                lblMessage.setText("Gagal Login!");
            }
        });
        
        frame.setVisible(true);
    }

    private static void buatHalamanUtama() {
        JFrame frame = new JFrame("Halaman Utama");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        
        JLabel lblDepan = new JLabel("Nama Depan:");
        JTextField txtDepan = new JTextField(15);
        JLabel lblBelakang = new JLabel("Nama Belakang:");
        JTextField txtBelakang = new JTextField(15);
        JLabel lblGender = new JLabel("Jenis Kelamin:");
        JTextField txtGender = new JTextField(10);
        JButton btnSimpan = new JButton("Simpan");
        JTextArea txtArea = new JTextArea(8, 30);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        JButton btnSimpanFile = new JButton("Simpan ke File");
        
        panel.add(lblDepan);
        panel.add(txtDepan);
        panel.add(lblBelakang);
        panel.add(txtBelakang);
        panel.add(lblGender);
        panel.add(txtGender);
        panel.add(btnSimpan);
        panel.add(scrollPane);
        panel.add(btnSimpanFile);
        
        btnSimpan.addActionListener(e -> {
            String depan = txtDepan.getText().trim();
            String belakang = txtBelakang.getText().trim();
            String gender = txtGender.getText().trim();
            if (depan.isEmpty() || belakang.isEmpty() || gender.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Data belum lengkap!");
            } else {
                String data = depan + " " + belakang + " - " + gender;
                dataList.add(data);
                txtArea.append(data + "\n");
            }
        });
        
        btnSimpanFile.addActionListener(e -> {
            if (dataList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Tidak ada data untuk disimpan!");
            } else {
                simpanKeFile();
                JOptionPane.showMessageDialog(frame, "Data tersimpan di data_nim.txt");
            }
        });
        
        frame.setVisible(true);
    }

    private static void simpanKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data_nim.txt"))) {
            for (String data : dataList) {
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


public class Tugas1PBO_123230210 {
    public static void main(String[] args) {
       
    }
    
}
