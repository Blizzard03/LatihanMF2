/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariq.rasyid.latihanmf2;

import com.mariq.rasyid.latihanmf2.Models.LatihanMF2Models;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLOutputController implements Initializable {

    //Curency Formatter
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);

    @FXML
    private Label name_customer;
    @FXML
    private Label schejule_name;
    @FXML
    private Label hours;
    @FXML
    private Label firsthoursprice;
    @FXML
    private Label sumcal;
    @FXML
    private Label timeleft;
    @FXML
    private Label allcal;
    @FXML
    private Label totalprice;
    @FXML
    private Button closebtn;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closebtn(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void backclick(ActionEvent event) {
        btnback.getScene().getWindow().hide();
    }

    public void getDataOutput(LatihanMF2Models mdl) {
        String jadwal = "";
        double first = 0, left = 0;
        switch (mdl.getJadwal()) {
            case 1: {
                jadwal = "Pagi";
                schejule_name.setText(jadwal);
                first = 5000;
                firsthoursprice.setText(formater.format(first));
                left = 4000;
                timeleft.setText(formater.format(left));
                break;
            }
            case 2: {
                jadwal = "Siang";
                schejule_name.setText(jadwal);
                first = 4000;
                firsthoursprice.setText(formater.format(first));
                left = 3500;
                timeleft.setText(formater.format(left));
                break;
            }
            case 3: {
                jadwal = "Malam";
                schejule_name.setText(jadwal);
                first = 3500;
                firsthoursprice.setText(formater.format(first));
                left = 2500;
                timeleft.setText(formater.format(left));
                break;
            }
            default: {
                jadwal = null;
                schejule_name.setText(jadwal);
                first = 0;
                firsthoursprice.setText(formater.format(first));
                left = 0;
                timeleft.setText(formater.format(left));
            }

        }

        double pay = (mdl.getClock() - 1) * left;
        double paymentcal = first + pay;
        name_customer.setText(mdl.getName_Customer());
        hours.setText(String.valueOf(mdl.getClock()));
        sumcal.setText(formater.format(first));
        allcal.setText(formater.format(paymentcal));
        totalprice.setText(formater.format(paymentcal));
    }

}
