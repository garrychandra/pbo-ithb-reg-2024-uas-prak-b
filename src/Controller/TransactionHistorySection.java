package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modul.Transaction;

public class TransactionHistorySection {
    public static ArrayList<Transaction> getData(){
        String query = "select * from transaction order by created_at desc";
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Transaction transaction = new Transaction();
                transaction.setDelivery_type(rs.getString(3));
                transaction.setExpected_weight(rs.getInt("expected_weight"));
                transaction.setTotal_cost(rs.getInt(5));
                transaction.setId(rs.getInt(1));
                transaction.setCreated_at(rs.getDate(6));
                transactions.add(transaction);
            }
            DatabaseHandler.disconnect();
            return transactions;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Checking Unique Username", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }
}
