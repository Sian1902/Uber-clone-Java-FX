package com.example.osc;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import login.FileWriter;
import login.Passenger;

import java.io.IOException;

import java.util.Hashtable;


public class RegisterController {

    FileWriter file = new FileWriter();
    Hashtable <String, Passenger> customerMap;

    @FXML
    private TextField regName;
    @FXML
    private TextField regEmail;
    @FXML
    private TextField regPassword;
    @FXML
    private TextField regNumber;
    @FXML
    private ToggleGroup togglePayment;

    @FXML
    private void submitUser() throws IOException {
        // Make sure no textfield is unfulfilled
        assert (regName !=null);
        assert (regEmail !=null);
        assert (regPassword !=null);
        assert (regNumber !=null);
        assert (togglePayment !=null);

        // Create new passenger using input data
        Passenger p =new Passenger();
        p.setName(regName.getText());
        p.setEmail(regEmail.getText());
        p.setPassword(regPassword.getText());
        p.setNumber(regNumber.getText());
        String payment = ((RadioButton) togglePayment.getSelectedToggle()).getText();
        if (payment.equals("Paypal"))
            p.setPaymentMethod('p');
        else
            p.setPaymentMethod('c');

        //Add new customer to file
        customerMap.put(p.getNumber(), p);
        file.write(customerMap);

        // Clear Input textfields
        regName.clear();
        regEmail.clear();
        regPassword.clear();
        regNumber.clear();
        togglePayment.getToggles().clear();


    }

    @FXML
    void initialize() {

        // when screen loads, copy customers into hashtable from file
        try {
            customerMap = file.read();
        } catch (IOException e) {
            System.out.println(e + ": No Data in file Yet");
        }

    }

}