package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Modul.Transaction;

public class TransactionSection {
    public static ArrayList<String> getCategory(){
        String query = "select * from delivery_category";
        ArrayList<String> category = new ArrayList<>();
        try {
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                category.add(rs.getString(1));
            }
            return category;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Checking Unique Username", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static int getFee(String category){
        String query = "select fee from delivery_category where category = ?";
        try {
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);
            st.setString(1, category);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return -1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Checking Unique Username", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public static void insertTransaction(Transaction transaction){
        try {
            String query = "INSERT INTO transaction (receipt_name, receipt_address, receipt_phone, expected_weight, created_at, total_cost, delivery_type) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);
            st.setString(1, transaction.getReceipt_name());
            st.setString(2, transaction.getReceipt_address());
            st.setString(3,transaction.getReceipt_phone());
            st.setInt(4, transaction.getExpected_weight());
            st.setDate(5, transaction.getCreated_at());
            st.setInt(6, transaction.getTotal_cost());
            st.setString(7,transaction.getDelivery_type());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Insert Berhasil", "Insert", JOptionPane.INFORMATION_MESSAGE);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Input Data", "Error", JOptionPane.ERROR_MESSAGE);
        }
        DatabaseHandler.disconnect();
    }
}
