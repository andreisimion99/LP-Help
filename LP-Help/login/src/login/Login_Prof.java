/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Login_Prof implements Initializable {
    
   @FXML
    private TextField txtuname;

    @FXML
    private PasswordField txtpass;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private Button btnok;
    
    @FXML
    private Button btnBack;

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        
        
        String uname = txtuname.getText();
        String pass = txtpass.getText();
        
        if(uname.equals("") && pass.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username or password blank");
        }
        else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mtdl","root","");
                
                pst = con.prepareStatement("select * from users where username=? and password=?");
                
                pst.setString(1,uname);
                pst.setString(2,pass);
                
                rs = pst.executeQuery();
                
                if(rs.next() ) 
                {
                    Stage homepageStage = (Stage) btnok.getScene().getWindow();
                    homepageStage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("Home_Prof.fxml"));
                    Stage newsStage = new Stage();
                    Scene scene = new Scene(root);
                    newsStage.setTitle("School Manager - Info");
                    newsStage.setScene(scene);
                    newsStage.show();
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, " login Failed");
                    txtuname.setText("");
                    txtpass.setText("");
                    txtuname.requestFocus();
                    
                    
                }
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login_Prof.class.getName()).log(Level.SEVERE, null, ex);
                
                
            }
            
        }
        
        
        
    }
    
    @FXML
    void loadBack(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) btnBack.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Start_Prof.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
    }    
    
}