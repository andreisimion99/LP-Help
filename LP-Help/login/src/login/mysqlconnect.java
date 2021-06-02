/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author andrei_cosmin.oprea
 */
public class mysqlconnect {
    Connection conn = null;
    
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mtdl", "root","");
            return conn;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static ObservableList<users> getDatausers() {
        
        Connection conn = ConnectDb();
        ObservableList<users> list = FXCollections.observableArrayList();
        
        try {
            String query = "select * from users ";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                list.add(new users(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3)
                ));
                
        }
        }catch(Exception e){
            
        }
        
        return list;
    }
}
