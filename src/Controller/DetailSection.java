package Controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Modul.DeliveryDetails;
import Modul.Transaction;

public class DetailSection {
    public static void insertDetail(DeliveryDetails details){
        try {
            String query = "INSERT INTO delivery_details VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);
            st.setInt(1,0);
            st.setInt(2, details.getTransaction_id());
            st.setString(3, details.getStatus().toString());
            st.setString(4,details.getCurrent_position());
            st.setString(5, details.getEvidence());
            st.setDate(6, details.getDate());
            st.setString(7, details.getUpdated_by());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Insert Berhasil", "Insert", JOptionPane.INFORMATION_MESSAGE);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Input Data", "Error", JOptionPane.ERROR_MESSAGE);
        }
        DatabaseHandler.disconnect();
    }

    public static Date getUpdateDate(int transactionId){
        String query = "select date from delivery_details where transaction_id = ? order by date desc";
        try {
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);

            st.setInt(1, transactionId);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getDate("date");
        } catch(Exception e){

        } 
        DatabaseHandler.disconnect();
        return null;       
    }
}
