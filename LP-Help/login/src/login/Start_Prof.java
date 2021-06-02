/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;





public class Start_Prof implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML 
    private Button buton;
    @FXML
    void loadLogin(ActionEvent event) throws IOException {

        Stage homepageStage = (Stage) buton.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Login_Prof.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();

    }
    
    @FXML
    void loadSignIn(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) buton.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("SingIn.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    
    @FXML
    void loadBack(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) buton.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("prof_stud_adm.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    
}
