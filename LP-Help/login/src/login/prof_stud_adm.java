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
public class prof_stud_adm implements Initializable {

    @FXML
    private Button butonProf;

    @FXML
    private Button butonStud;

    @FXML
    private Button butonAdm;

    @FXML
    void loadAdm(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) butonProf.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Start_Adm.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();

    }

    @FXML
    void loadProf(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) butonProf.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Start_Prof.fxml"));
        Stage newsStage = new Stage();
        Scene scene = new Scene(root);
        newsStage.setTitle("School Manager - Info");
        newsStage.setScene(scene);
        newsStage.show();

    }

    @FXML
    void loadStud(ActionEvent event) throws IOException {
        Stage homepageStage = (Stage) butonProf.getScene().getWindow();
        homepageStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Start_Stud.fxml"));
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
