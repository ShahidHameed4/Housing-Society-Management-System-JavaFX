package com.example.sdatest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class popUPcontroller {

    @FXML
    private Label appIDLabel;

    @FXML
    private Label applicationIDLabel;

    @FXML
    private Label complaintID;

    public void displayapplicantID(String appID) {
        appIDLabel.setText(appID);
    }

    public void displayapplicationID(String appID) {
        applicationIDLabel.setText(appID);
    }

    public void displayComplaintID(String complaintID){
        this.complaintID.setText(complaintID);
    }




}
