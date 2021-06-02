/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class SingInController implements Initializable {

    
    @FXML
    private TextField txtname;

    @FXML
    private PasswordField txtpass;

    @FXML
    private Button btnadd;
    
    Connection con;
    PreparedStatement pst;
    
    
    @FXML
    void Add(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        
        String uname = txtname.getText();
        String pass = txtpass.getText();
        
        
        if(uname.equals("") && pass.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username or password blank");
        }
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mtdl","root","");
                
                pst = con.prepareStatement("insert into users(username,password)values(?,?)");
                
                pst.setString(1,uname);
                pst.setString(2,pass);
                int status = pst.executeUpdate();
                
                if(status==1)
                {
                    JOptionPane.showMessageDialog(null,"Cont creat cu succes");
                    txtname.setText("");
                    txtpass.setText("");
                    txtname.requestFocus();
                    Stage homepageStage = (Stage) btnadd.getScene().getWindow();
                    homepageStage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("prof_stud_adm.fxml"));
                    Stage newsStage = new Stage();
                    Scene scene = new Scene(root);
                    newsStage.setTitle("School Manager - Info");
                    newsStage.setScene(scene);
                    newsStage.show();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Record fail");
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SingInController.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
