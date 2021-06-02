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

/**
 * FXML Controller class
 *
 * @author andrei_cosmin.oprea
 */
public class Home_Prof implements Initializable {

    @FXML
    private Button butonQuestion;

    @FXML
    private Button butonTest;

    @FXML
    private Button btnBack;

    @FXML
    void loadQuestion(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) butonQuestion.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Question.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    
    @FXML
    void loadTest(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) butonTest.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    
    @FXML
    void loadBack(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) btnBack.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Login_Prof.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
