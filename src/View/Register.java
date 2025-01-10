package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Modul.Customer;

public class Register {
    JFrame frame;
    JPanel panel;

    public Register() {
        regist();
    }

    public void regist() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 575;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        frame = new JFrame("Register Form");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT - 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel titleLabel = new JLabel("Registration", SwingConstants.CENTER);
        titleLabel.setBounds(50, 10, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(0, 102, 204));
        panel.add(titleLabel);

        JLabel telnoL = new JLabel("Telphone Number: ");
        telnoL.setBounds(50, 60, 150, 20);
        panel.add(telnoL);

        JTextField telNo = new JTextField();
        telNo.setBounds(50, 85, 300, 30);
        telNo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(telNo);

        JLabel passwordL = new JLabel("Password");
        passwordL.setBounds(50, 125, 150, 20);
        panel.add(passwordL);

        JPasswordField password = new JPasswordField();
        password.setBounds(50, 150, 300, 30);
        password.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(password);

        JLabel addressL = new JLabel("Alamat");
        addressL.setBounds(50, 190, 150, 20);
        panel.add(addressL);

        JTextField address = new JTextField();
        address.setBounds(50, 215, 300, 30);
        address.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(address);

        JLabel nameL = new JLabel("Nama");
        nameL.setBounds(50, 255, 150, 20);
        panel.add(nameL);

        JTextField name = new JTextField();
        name.setBounds(50, 280, 300, 30);
        name.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(name);

        JButton submit = new JButton("Register");
        submit.setBounds(220, 330, 100, 30);
        submit.setBackground(new Color(0, 102, 204));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        panel.add(submit);

        JButton backButton = new JButton("Back");
        backButton.setBounds(70, 330, 100, 30);
        backButton.setBackground(new Color(220, 20, 60)); 
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        panel.add(backButton);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (telNo.getText().isEmpty() || new String(password.getPassword()).isEmpty() ||
                        address.getText().isEmpty() || name.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all required fields.");
                } else if (Controller.Register.checkUniqueTelno(telNo.getText()) == 0) {
                    JOptionPane.showMessageDialog(frame, "Username is already taken!");
                } else {
                    Customer customer = new Customer(
                        -1,
                        new String(password.getPassword()), 
                        name.getText(), 
                        address.getText(), 
                        telNo.getText());

                    Controller.Register.register(customer);
                    JOptionPane.showMessageDialog(frame, "Data Berhasil Disimpan");
                    frame.dispose();
                    new MenuUtama();
                }
        }});

       
        backButton.addActionListener(e -> {
            new MenuUtama();
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}