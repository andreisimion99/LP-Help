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
public class Crud implements Initializable {

    @FXML 
    private Button buton;
    
    @FXML
    private TableView<users> table_users;

    @FXML
    private TableColumn<users, Integer> col_id;

    @FXML
    private TableColumn<users, String > col_username;

    @FXML
    private TableColumn<users, String> col_password;
    
     @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_password;
    
     @FXML
    private TextField txt_id;
     
    @FXML
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
    
    @FXML
    void logOut(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) buton.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("prof_stud_adm.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    
    ObservableList<users> listM;
    int index = 1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @FXML
    public void Add_users () {
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into users(username,password) values (?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_username.getText());
            pst.setString(2,txt_password.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Succes add");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e );
    }
    }
    
    
    ////////select users//////
    public void getSelected(MouseEvent event) {
        index = table_users.getSelectionModel().getSelectedIndex();
        if ( index <= -1) {
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_username.setText(col_username.getCellData(index).toString());
        txt_password.setText(col_password.getCellData(index).toString());
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       col_id.setCellValueFactory(new PropertyValueFactory<users,Integer>("id"));
       col_username.setCellValueFactory(new PropertyValueFactory<users, String >("username"));
       col_password.setCellValueFactory(new PropertyValueFactory<users, String >("password"));
       
       listM = mysqlconnect.getDatausers();
       table_users.setItems(listM);
    }    

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = table_users.getSelectionModel().getSelectedIndex();
        if ( index <= -1) {
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_username.setText(col_username.getCellData(index).toString());
        txt_password.setText(col_password.getCellData(index).toString());
    }
    
    public void Edit() {
        try {
            conn=mysqlconnect.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_username.getText();
            String value3 = txt_password.getText();
            
            String sql = "update users set user_id=  '"+value1+"' , username='"+value2+"',  password='"+value3+"'   where user_id='"+value1+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    public void Delete() {
        conn = mysqlconnect.ConnectDb();
        String sql = "delete from users where user_id = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Delete");
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
