package com.example.sdatest;

import HSMS.Applicant.Applicant;
import HSMS.ApplicationTypes.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static HSMS.HSMS.getHsms;

public class GuestController {

    @FXML
    void initialize(){
        pnlDashboard.setStyle("-fx-background-color : #FF7700");
        pnlDashboard.toFront();
    }

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRapp;

    @FXML
    private Button btnappStatus;

    @FXML
    private Pane pnlDashboard;

    @FXML
    private Pane pnlRegapp;

    @FXML
    private Pane pnlappStatus;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnRapp) {
            pnlRegapp.setStyle("-fx-background-color : #FF7700");
            pnlRegapp.toFront();
        }
        if (actionEvent.getSource() == btnappStatus) {
            pnlappStatus.setStyle("-fx-background-color : #FF7700");
            pnlappStatus.toFront();
        }
        if (actionEvent.getSource() == btnBack) {
            //pnlOverview.setStyle("-fx-background-color : #02030A");
            root = FXMLLoader.load(getClass().getResource("newUI/Login.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private TextField aCNIC;

    @FXML
    private TextField aEmail;

    @FXML
    private TextField afName;

    @FXML
    private TextField alName;

    @FXML
    private TextField appID;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField oLName;

    @FXML
    private TextField oFName;

    @FXML // fx:id="HouseSize"
    private ChoiceBox<String> HouseSize; // Value injected by FXMLLoader


    @FXML // fx:id="houseNo"
    private TextField houseNo; // Value injected by FXMLLoader

    @FXML // fx:id="oAge"
    private TextField oAge; // Value injected by FXMLLoader

    @FXML // fx:id="oCNIC"
    private TextField oCNIC; // Value injected by FXMLLoader


    @FXML
    void createApplicant(ActionEvent event) throws IOException {
        Applicant app =  getHsms().createApplicant(afName.getText(),alName.getText(),Integer.parseInt(aCNIC.getText()), aEmail.getText(),false);
        Parent root1;
        String appID = String.valueOf(app.getID());
        this.appID.setText(appID);

        tabPane.getSelectionModel().selectNext();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Guest/ApplicantSuccessPopUP.fxml"));
//        root1 = loader.load();
//
//        popUPcontroller p = loader.getController();
//        p.displayapplicantID(appID);
//
//        Stage stage1 = new Stage();
//        stage1.setScene(new Scene(root1));
//        stage1.show();
    }

    @FXML
    void propertyRegistrationApplication(ActionEvent event) throws IOException {
        Application app =  getHsms().propertyRegistrationApplication(Integer.parseInt(appID.getText()),houseNo.getText(),HouseSize.getValue(),oFName.getText(),oLName.getText(),Integer.parseInt(oAge.getText()),Integer.parseInt(oCNIC.getText()));
        Parent root1;
        String appID = String.valueOf(app.getID());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("newUI/GuestApplicationPopUP.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayapplicationID(appID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    @FXML
    TextField appIDStatusField;

    @FXML
    Label appIDinsertion;

    @FXML
    Label applicantNameInsertion;

    @FXML
    Label appStatusInsertion;

    @FXML
    void applicationStatusShow(ActionEvent event) throws IOException {
        Application application = getHsms().getApplicationStatus(Integer.parseInt(appIDStatusField.getText()));

        appIDinsertion.setText(String.valueOf(application.getID()));
        applicantNameInsertion.setText(application.getApplicant().getFirstName() + " " + application.getApplicant().getLastName());
        appStatusInsertion.setText(application.getApplicationStatus());

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("newUI/ApplicationSuccessPopUP.fxml"));
//        root1 = loader.load();
//
//        popUPcontroller p = loader.getController();
//        p.displayapplicationID(appID);
//
//        Stage stage1 = new Stage();
//        stage1.setScene(new Scene(root1));
//        stage1.show();
    }






}
