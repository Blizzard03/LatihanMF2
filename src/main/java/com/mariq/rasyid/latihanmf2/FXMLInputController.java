/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariq.rasyid.latihanmf2;

import com.mariq.rasyid.latihanmf2.Models.LatihanMF2Models;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLInputController implements Initializable {

    LatihanMF2Models mdl = new LatihanMF2Models();

    @FXML
    private TextField txtname;
    @FXML
    private ComboBox<String> cmbjadwal;
    @FXML
    private TextField txtjam;
    @FXML
    private Button Hitungbtn;
    @FXML
    private Button batalbtn;
    @FXML
    private Button keluarbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*
        Initialize Funitures List
         */
        cmbjadwal.setItems(FXCollections.observableArrayList(
                "--Pilih Jadwal--", "Pagi", "Siang", "Malam"));
        cmbjadwal.getSelectionModel().select(0);
    }

    @FXML
    private void hitungklik(ActionEvent event) {
        mdl.setName_Customer(txtname.getText());
        mdl.setClock(Integer.parseInt(txtjam.getText()));
        mdl.setJadwal(cmbjadwal.getSelectionModel().getSelectedIndex());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mariq/rasyid/latihanmf2/FXMLOutput.fxml"));
            Parent root = (Parent) loader.load();
            FXMLOutputController ctrl
                    = (FXMLOutputController) loader.getController();
            ctrl.getDataOutput(mdl);

            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setResizable(false);
            stg.setIconified(false);

            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void batalklik(ActionEvent event) {
        txtname.setText(null);
        cmbjadwal.getSelectionModel().select(0);
        txtjam.setText(null);

    }

    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

}
