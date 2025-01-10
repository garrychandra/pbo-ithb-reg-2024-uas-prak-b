package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;

public class Login {
    private JFrame frame;
    private JPanel panel;

    public Login() {
        LogIn();
    }

    public void LogIn() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize(); // Get screen size

        int screenWidth = screenSize.width; // Screen width
        int screenHeight = screenSize.height; // Screen height

        final int FRAME_WIDTH = 400; // Set frame width
        final int FRAME_HEIGHT = 500; // Set frame height

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // Center frame horizontally
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // Center frame vertically

        frame = new JFrame("Login Menu"); // Create frame and set title

        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // Set frame bounds
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel titleLabel = new JLabel("Pratama Delivery Login", SwingConstants.CENTER);
        titleLabel.setBounds(50, 20, 300, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(25, 25, 112)); // Dark blue text
        panel.add(titleLabel);


        System.out.println(Paths.get("").toAbsolutePath());

        JLabel iconLabel = new JLabel();
        iconLabel.setBounds(125, 50, 120, 120); // Adjust photo position
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setIcon(new ImageIcon(new ImageIcon((new File("src/img/icon.png")).getAbsolutePath()).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
        panel.add(iconLabel);
        
        JLabel telLabel = new JLabel("No Telp.:");
        telLabel.setBounds(50, 160, 300, 30);
        telLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        telLabel.setForeground(Color.BLACK);
        panel.add(telLabel);

        JTextField telno = new JTextField();
        telno.setBounds(50, 190, 300, 30);
        telno.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(telno);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(50, 240, 300, 30);
        pass.setFont(new Font("Arial", Font.PLAIN, 14));
        pass.setForeground(Color.BLACK);
        panel.add(pass);

        JPasswordField password = new JPasswordField();
        password.setBounds(50, 270, 300, 30);
        password.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(password);

        JButton submit = new JButton("Login");
        submit.setBounds(50, 330, 300, 40);
        submit.setFont(new Font("Arial", Font.BOLD, 16));
        submit.setBackground(new Color(100, 149, 237));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        panel.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.Login.login(telno.getText(), new String(password.getPassword()));
                frame.dispose();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 390, 300, 40);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(220, 20, 60)); 
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuUtama(); 
                frame.dispose();
            }
        });

        frame.setVisible(true);
        frame.add(panel);
    }
}