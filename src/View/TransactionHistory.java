package View;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Modul.Transaction;

public class TransactionHistory {
    private JFrame frame;
    private JPanel panel;

    public TransactionHistory() {
        transactionHistory();
    }

    public void transactionHistory(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize(); // Get screen size

        int screenWidth = screenSize.width; // Screen width
        int screenHeight = screenSize.height; // Screen height

        final int FRAME_WIDTH = 750; // Set frame width
        final int FRAME_HEIGHT = 400; // Set frame height

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // Center frame horizontally
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // Center frame vertically

        frame = new JFrame("Menu Utama"); // Create frame and set title

        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // Set frame bounds
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT-100);
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        String[] col= {"transaction_id","delivery_type","expected_weight", "total_cost", "created_at", "updated_at"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        ArrayList<Transaction> transactions = Controller.TransactionHistorySection.getData();
        for(Transaction transaction : transactions){
            Object[] row = {transaction.getId(), transaction.getDelivery_type(), transaction.getExpected_weight(), transaction.getTotal_cost(), transaction.getCreated_at(), Controller.DetailSection.getUpdateDate(transaction.getId())};
            tableModel.addRow(row);
        }

        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);

        panel.add(new JScrollPane(table),BorderLayout.NORTH);

        JButton next = new JButton("Next");
        next.addActionListener(e -> {
            System.out.println(transactions.get(table.getSelectedRowCount()).getReceipt_name());
        });
        next.setSize(100,50);
        panel.add(next,BorderLayout.SOUTH);
        frame.add(panel);
        
        frame.setVisible(true);
    }
}