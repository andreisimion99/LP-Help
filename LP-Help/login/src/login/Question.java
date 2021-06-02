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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author andrei_cosmin.oprea
 */
public class Question implements Initializable {

    @FXML
    private TextArea QuestionField;

    @FXML
    private TextField Answer1;

    @FXML
    private TextField Answer2;

    @FXML
    private TextField Answer3;

    @FXML
    private TextField CorrectAnswer;

    @FXML
    private Button butonAAA;

    Connection con;
    PreparedStatement pst;
    
    @FXML
    void add(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        String question = QuestionField.getText();
        String answer1 = Answer1.getText();
        String answer2 = Answer2.getText();
        String answer3 = Answer3.getText();
        String correct = CorrectAnswer.getText();
        
        if(answer1.equals("") || answer2.equals("") || answer3.equals("") || correct.equals("") || question.equals("") )
        {
            JOptionPane.showMessageDialog(null, "Exista un camp gol");
        }
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mtdl","root","");
                
                pst = con.prepareStatement("insert into questions(Question,Answer_1,Answer_2, Answer_3,Correct_Answer)values(?,?,?,?,?)");
                
                pst.setString(1,question);
                pst.setString(2,answer1);
                pst.setString(3,answer2);
                pst.setString(4,answer3);
                pst.setString(5,correct);
                
                int status = pst.executeUpdate();
                
                if(status==1)
                {
                    JOptionPane.showMessageDialog(null,"Intrebare creeata cu succes");
                    QuestionField.setText("");
                    Answer1.setText("");
                    Answer2.setText("");
                    Answer3.setText("");
                    CorrectAnswer.setText("");
                    Answer1.requestFocus();
                    Answer2.requestFocus();
                    Answer3.requestFocus();
                    CorrectAnswer.requestFocus();
                    QuestionField.requestFocus();
                    
                    Stage homepageStage = (Stage) butonAAA.getScene().getWindow();
                    homepageStage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("Start_Prof.fxml"));
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
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(SingInController.class.getName()).log(Level.SEVERE, null, ex);  
    }

    }   
        
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
