package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import Controller.DetailSection;
import Controller.TransactionSection;
import Modul.DeliveryDetails;
import Modul.Status_Enum;
import Modul.Transaction;


public class DetailTransaction {
    JFrame frame;
    JPanel panel;
    File evidenceFile;

    public DetailTransaction() {
        addDetail();
    }

    public void addDetail() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 650;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        frame = new JFrame("Tambah Detail Transaksi");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT - 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel titleLabel = new JLabel("Tambah Detail Transaksi", SwingConstants.CENTER);
        titleLabel.setBounds(25, 10, 350, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(0, 102, 204));
        panel.add(titleLabel);

        JLabel transL = new JLabel("TransactionId: ");
        transL.setBounds(50, 60, 150, 20);
        panel.add(transL);

        JTextField transId = new JTextField();
        transId.setBounds(50, 85, 300, 30);
        transId.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(transId);

        JLabel statusL = new JLabel("Status");
        statusL.setBounds(50, 125, 150, 20);
        panel.add(statusL);

        JComboBox status = new JComboBox(Modul.Status_Enum.values());
        status.setSelectedIndex(0);
        status.setBounds(50,150,300,30);
        panel.add(status);

        JLabel currentPosL = new JLabel("Current Position");
        currentPosL.setBounds(50, 190, 150, 20);
        panel.add(currentPosL);

        JTextField currentPos = new JTextField();
        currentPos.setBounds(50, 215, 300, 30);
        currentPos.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(currentPos);
        
        JLabel evidenceL = new JLabel("Evidence");
        evidenceL.setBounds(50, 250,150,20);
        panel.add(evidenceL);

        JButton openEvidence = new JButton("Open File");
        openEvidence.setBounds(50, 270,150,25);
        panel.add(openEvidence);

        JLabel evidencePath = new JLabel("No File Selected");
        evidencePath.setBounds(205,270,150,20);
        panel.add(evidencePath);

        openEvidence.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                evidenceFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                evidencePath.setText(evidenceFile.getName());
            }
        });

        JLabel updateByL = new JLabel("Updated By");
        updateByL.setBounds(50, 300, 150, 20);
        panel.add(updateByL);

        JTextField updatedBy = new JTextField();
        updatedBy.setBounds(50, 325, 300, 30);
        updatedBy.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(updatedBy);
        
        JButton submit = new JButton("Simpan");
        submit.setBounds(220, 400, 100, 30);
        submit.setBackground(new Color(0, 102, 204));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        panel.add(submit);

        JButton backButton = new JButton("Back");
        backButton.setBounds(70, 400, 100, 30);
        backButton.setBackground(new Color(220, 20, 60)); 
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        panel.add(backButton);

        submit.addActionListener(e -> {
            DeliveryDetails detail = new DeliveryDetails();
            detail.setTransaction_id(Integer.parseInt(transId.getText()));
            detail.setCurrent_position(currentPos.getText());
            detail.setDate(new java.sql.Date(System.currentTimeMillis()));
            detail.setEvidence(evidenceFile.getAbsolutePath());
            detail.setStatus((Status_Enum)status.getSelectedItem());
            detail.setUpdated_by(updatedBy.getText());
            Controller.DetailSection.insertDetail(detail);
            new MenuUtama();
            frame.dispose();
        });

       
        backButton.addActionListener(e -> {
            new MenuUtama();
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
    
}
