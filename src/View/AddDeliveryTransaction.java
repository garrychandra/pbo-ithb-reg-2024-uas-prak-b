package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Modul.Customer;

public class AddDeliveryTransaction {
    JFrame frame;
    JPanel panel;

    public AddDeliveryTransaction() {
        addDelivery();
    }

    public void addDelivery() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 650;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        frame = new JFrame("Tambah Transaksi Pengiriman");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT - 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel titleLabel = new JLabel("Tambah Transaksi Pengiriman", SwingConstants.CENTER);
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

        JLabel nameL = new JLabel("Nama");
        nameL.setBounds(50, 125, 150, 20);
        panel.add(nameL);

        JTextField name = new JTextField();
        name.setBounds(50, 150, 300, 30);
        name.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(name);

        JLabel addressL = new JLabel("Alamat");
        addressL.setBounds(50, 190, 150, 20);
        panel.add(addressL);

        JTextField address = new JTextField();
        address.setBounds(50, 215, 300, 30);
        address.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(address);

        JLabel weightL = new JLabel("Berat:");
        weightL.setBounds(50, 255, 150, 20);
        panel.add(weightL);

        JTextField weight = new JTextField();
        weight.setBounds(50, 280, 300, 30);
        weight.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(weight);

        
        //ArrayList<String> category = Controller.TransactionSection.getCategory();
        String category[] = {"a","b"};

        JComboBox typeCombo = new JComboBox(category);
        typeCombo.setSelectedIndex(0);
        typeCombo.setBounds(50,320,300,20);
        panel.add(typeCombo);

        JButton submit = new JButton("Simpan");
        submit.setBounds(220, 350, 100, 30);
        submit.setBackground(new Color(0, 102, 204));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        panel.add(submit);

        JButton backButton = new JButton("Back");
        backButton.setBounds(70, 350, 100, 30);
        backButton.setBackground(new Color(220, 20, 60)); 
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        panel.add(backButton);



        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (telNo.getText().isEmpty() || weight.getText().isEmpty()||
                            address.getText().isEmpty() || name.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill all required fields.");
                    } else if (Integer.parseInt(weight.getText().trim()) <= 0) {
                        JOptionPane.showMessageDialog(frame, "Weight can't be 0 or negative");
                    } else {
                        //bikin database category + fee
                        //cost = fee * weight
                        //masukan database
                        frame.dispose();
                        new MenuUtama();
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(frame, "Invalid Input");
                }
            }
        });

       
        backButton.addActionListener(e -> {
            new MenuUtama();
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
    
}
