/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author andrei_cosmin.oprea
 */
public class TESTGENERAT implements Initializable {

    private Button buton;
    
    @FXML
    private TableView<usersQ> table_questions;

    @FXML
    private TableColumn<usersQ, Integer> col_id;

    @FXML
    private TableColumn<usersQ, String > col_question;

    @FXML
    private TableColumn<usersQ, String> col_answer1;
    
    @FXML
    private TableColumn<usersQ, String> col_answer2;
    
    @FXML
    private TableColumn<usersQ, String> col_answer3;
    
    @FXML
    private TableColumn<usersQ, String> col_correctAnswer;
    
    
     @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_question;
    @FXML
    private TextField txt_answer1;
    @FXML
    private TextField txt_answer2;
    @FXML
    private TextField txt_answer3;
    @FXML
    private TextField txt_correctAnswer;
    
    @FXML
    private Label label;
     
    void loadBack(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) buton.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Crud.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    
    ObservableList<usersQ> listMM;
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @FXML
    public void Add_users () {
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into teste(question, answer1, answer2, answer3, correctAnswer) values (?,?,?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_question.getText());
            pst.setString(2,txt_answer1.getText());
            pst.setString(3,txt_answer2.getText());
            pst.setString(4,txt_answer3.getText());
            pst.setString(5,txt_correctAnswer.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Succes add");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e );
    }
    }
    
    
    ////////select users//////
    public void getSelected(javafx.scene.input.MouseEvent event) {
        index = table_questions.getSelectionModel().getSelectedIndex();
        if ( index <= -1) {
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_question.setText(col_question.getCellData(index).toString());
        txt_answer1.setText(col_answer1.getCellData(index).toString());
        txt_answer2.setText(col_answer2.getCellData(index).toString());
        txt_answer3.setText(col_answer3.getCellData(index).toString());
        txt_correctAnswer.setText(col_correctAnswer.getCellData(index).toString());
        
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       col_id.setCellValueFactory(new PropertyValueFactory<usersQ,Integer>("id"));
       col_question.setCellValueFactory(new PropertyValueFactory<usersQ, String >("question"));
       col_answer1.setCellValueFactory(new PropertyValueFactory<usersQ, String >("answer1"));
       col_answer2.setCellValueFactory(new PropertyValueFactory<usersQ, String >("answer2"));
       col_answer3.setCellValueFactory(new PropertyValueFactory<usersQ, String >("answer3"));
       col_correctAnswer.setCellValueFactory(new PropertyValueFactory<usersQ, String >("correctAnswer"));
       label.setText(col_question.getCellData(index).toString());
       
       listMM = mysqlconnect2.getDatausers();
       table_questions.setItems(listMM);
    }     
}