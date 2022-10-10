package com.example.sdatest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationStatusPOPUPController {


    @FXML
    private Label appIDinsertion;

    @FXML
    private Label appStatusInsertion;

    @FXML
    private Label applicantNameInsertion;

    public void display(String appID, String Status, String Name){
        appIDinsertion.setText(appID);
        appStatusInsertion.setText(Status);
        applicantNameInsertion.setText(Name);
    }
}
