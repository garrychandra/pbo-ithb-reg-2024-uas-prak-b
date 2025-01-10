package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modul.Customer;

import javax.swing.JOptionPane;

public class Login {

    public static void login(String telno, String password) {
        String query = "select * from  where telno = ?";
        try {
            PreparedStatement st = DatabaseHandler.connect().prepareStatement(query);
            st.setString(1, telno);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil", "Login", JOptionPane.DEFAULT_OPTION);

                        String query2 = "select id, password, name, address, phone from customer where u.username = ?";
                        PreparedStatement st2 = DatabaseHandler.connect().prepareStatement(query2);
                        st2.setString(1, telno);

                        ResultSet rsCust = st2.executeQuery();

                        Customer user1 = new Customer(
                        rsCust.getInt(1),
                        rsCust.getString(2),
                        rsCust.getString(3),
                        rsCust.getString(4),
                        rsCust.getString(5)
                        );
                        new View.HomeSeller();

                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal\nPassword Salah", "Login Gagal",
                            JOptionPane.DEFAULT_OPTION);
                    new View.Login();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal\nUsername not found", "Login Gagal",
                        JOptionPane.DEFAULT_OPTION);
                new View.Login();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        DatabaseHandler.disconnect();
    }
    
}
