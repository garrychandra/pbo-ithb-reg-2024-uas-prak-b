package View;

import java.awt.*;
import javax.swing.*;

public class MenuUtama {
    private JFrame frame;
    private JPanel panel;

    public MenuUtama() {
        menuUtama();
    }

    public void menuUtama(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize(); // Get screen size

        int screenWidth = screenSize.width; // Screen width
        int screenHeight = screenSize.height; // Screen height

        final int FRAME_WIDTH = 300; // Set frame width
        final int FRAME_HEIGHT = 400; // Set frame height

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // Center frame horizontally
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // Center frame vertically

        frame = new JFrame("Menu Utama"); // Create frame and set title

        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // Set frame bounds
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        JButton loginButton = createButton("Login",Color.blue);
        JButton registerButton = createButton("Registrasi", Color.green);
        JButton tambahTransaksi = createButton("Tambah Transaksi", Color.GRAY);
        JButton tambahDetailTransaksi = createButton("Tambah Detail", Color.magenta);
        JButton historyButton = createButton("History Pengiriman", Color.red);

        
        
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(tambahTransaksi);
        panel.add(tambahDetailTransaksi);
        panel.add(historyButton);
        
    
        loginButton.addActionListener(e -> {
            frame.dispose();
            new Login();
        });

        registerButton.addActionListener(e -> {
            frame.dispose();
            new Register();
        });

        tambahTransaksi.addActionListener(e -> {
            frame.dispose();
            new AddDeliveryTransaction();
        });

        tambahDetailTransaksi.addActionListener(e -> {
            frame.dispose();
            new DetailTransaction();
        });

        historyButton.addActionListener(e -> {
            frame.dispose();
            new TransactionHistory();
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private JButton createButton(String text, Color backgroundColor){
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(backgroundColor.darker(), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        return button;
    }
}
