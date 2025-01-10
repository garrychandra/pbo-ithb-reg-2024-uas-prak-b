package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Modul.Customer;

public class Register {
    public static int checkUniqueTelno(String telno) {
        String query = "select * from customer where phone = ?";
        try {
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);

            st.setString(1, telno);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Checking Unique Username", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public static boolean register(Customer customer){
        try {
            String query = "INSERT INTO customer VALUES (?,?,?,?,?)";
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);
            st.setInt(1, 0);
            st.setString(2, customer.getPassword());
            st.setString(3, customer.getName());
            st.setString(4,customer.getAddress());
            st.setString(5, customer.getPhone());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrasi Berhasil", "Registrasi", JOptionPane.INFORMATION_MESSAGE);
            st.close();
            DatabaseHandler.disconnect();
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Input Data", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        DatabaseHandler.disconnect();
        return false;
    }
    
}
