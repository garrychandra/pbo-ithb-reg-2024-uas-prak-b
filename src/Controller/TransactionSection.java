package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TransactionSection {
    public static ArrayList<String> getCategory(){
        String query = "select * from category";
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
}
