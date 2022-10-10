package com.example.sdatest;

import HSMS.ApplicationTypes.Application;
import HSMS.Complaint.Complaint;
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

public class ResidentController {

    @FXML
    private Button RentApp;

    @FXML
    private Button transApp;

    @FXML
    private Button EtagApp;

    @FXML
    private Button Complaints;

    @FXML
    private Button AppStatus;

    @FXML
    private Button CallResidentCare;

    @FXML
    private Button BackBtn;


    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlRentApp;

    @FXML
    private Pane pnltransApp;

    @FXML
    private Pane pnlEtagApp;

    @FXML
    private Pane pnlComplaints;

    @FXML
    private Pane pnlAppStatus;

    @FXML
    private Pane pnlCallResidentCare;

    @FXML
    Label nameLabel;

    @FXML
    Label cnicLabel;
    @FXML
    Label ageLabel;
    @FXML
    Label emailLabel;


    @FXML
    void initialize(){
        pnlOverview.setStyle("-fx-background-color : #FF7700");
        pnlOverview.toFront();
        nameLabel.setText(getHsms().getResident().getFirstName() + " " + getHsms().getResident().getLastName());
        cnicLabel.setText(getHsms().getResident().getCnic());
        ageLabel.setText(String.valueOf(getHsms().getResident().getAge()));
        emailLabel.setText(getHsms().getResident().getEmailAddress());
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label ResidentLabel;

    @FXML
    public void gotoDashboard(){
        pnlOverview.setStyle("-fx-background-color : #FF7700");
        pnlOverview.toFront();
    }

    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == RentApp) {
            pnlRentApp.setStyle("-fx-background-color : #FF7700");
            pnlRentApp.toFront();
        }
        if (actionEvent.getSource() == transApp) {
            pnltransApp.setStyle("-fx-background-color : #FF7700");
            pnltransApp.toFront();
        }
        if (actionEvent.getSource() == EtagApp) {
            pnlEtagApp.setStyle("-fx-background-color : #FF7700");
            pnlEtagApp.toFront();
        }
        if (actionEvent.getSource() == Complaints) {
            pnlComplaints.setStyle("-fx-background-color : #FF7700");
            pnlComplaints.toFront();
        }
        if (actionEvent.getSource() == AppStatus) {
            pnlAppStatus.setStyle("-fx-background-color : #FF7700");
            pnlAppStatus.toFront();
        }
        if (actionEvent.getSource() == CallResidentCare) {
            pnlCallResidentCare.setStyle("-fx-background-color : #FF7700");
            pnlCallResidentCare.toFront();
        }
        if (actionEvent.getSource() == BackBtn) {
            //pnlOverview.setStyle("-fx-background-color : #02030A");
            root = FXMLLoader.load(getClass().getResource("newUI/Login.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }




    @FXML
    private TextField emailTextField;

    @FXML
    private TextField houseTextField;

    @FXML
    private ChoiceBox<String> problemChoiceBox;



    @FXML
    public void ComplaintReg(ActionEvent actionEvent) throws IOException {

        int temp =  getHsms().complaintRegistration(houseTextField.getText(),problemChoiceBox.getValue(),emailTextField.getText());

        Parent root1;
        String complaintID = String.valueOf(temp);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("newUI/ComplaintIDPopUP.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayComplaintID(complaintID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    @FXML
    private TextField complaintIDtextField;
    @FXML
    private Label checkComplaintIDLabel;
    @FXML
    private Label checkComplaintProblemLabel;
    @FXML
    private Label checkComplaintStatusLabel;

    @FXML
    Button ComplaintStatusButton;

    public void getComplaintInfo(ActionEvent actionEvent){
        Complaint temp = getHsms().getComplaint(Integer.parseInt(complaintIDtextField.getText()));

        checkComplaintIDLabel.setText(String.valueOf(temp.getID()));
        checkComplaintProblemLabel.setText(temp.getProblem());
        checkComplaintStatusLabel.setText(temp.getComplaintStatus());

    }


    //RENTING APPLICATION

    @FXML
    private TextField RPHouseNo;

    @FXML
    private TextField RPincrement;

    @FXML
    private TextField RPoCNIC;

    @FXML
    private TextField RPofname;

    @FXML
    private TextField RPolname;

    @FXML
    private TextField RPrent;

    @FXML
    private TextField RPtCNIC;

    @FXML
    private TextField RPtfname;

    @FXML
    private TextField RPtlname;

    @FXML
    Button RentingApplicationButton;

    @FXML
    void createRPApplication(ActionEvent actionEvent) throws IOException {
        Application app = getHsms().propertyRentingApplication(RPtfname.getText(),RPtlname.getText(),Integer.parseInt(RPtCNIC.getText()),
                RPofname.getText(),RPolname.getText(),Integer.parseInt(RPoCNIC.getText()),Integer.parseInt(RPrent.getText()),Integer.parseInt(RPincrement.getText()));

        Parent root1;
        String appID = String.valueOf(app.getID());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ApplicationSuccessPopUPscreen.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayapplicationID(appID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }


    //OT Application

    @FXML
    private TextField OThouseNo;

    @FXML
    private TextField OToCNIC;

    @FXML
    private TextField OTofname;

    @FXML
    private TextField OTolname;

    @FXML
    private TextField OTrCNIC;

    @FXML
    private TextField OTrfname;

    @FXML
    private TextField OTrlname;

    @FXML
    Button TransferAppButton;

    @FXML
    void createOTApplication(ActionEvent actionEvent) throws IOException {
        Application app = getHsms().propertyTransApplication(OTrfname.getText(), OTrlname.getText(), Integer.parseInt(OTrCNIC.getText()),
                OTofname.getText(), OTolname.getText(), Integer.parseInt(OToCNIC.getText()), OThouseNo.getText());

        Parent root1;
        String appID = String.valueOf(app.getID());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ApplicationSuccessPopUPscreen.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayapplicationID(appID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }


    //ETAG APPLICATION

    @FXML
    private RadioButton ERrbNO;

    @FXML
    private TextField ETengineSize;

    @FXML
    private TextField EToCNIC;

    @FXML
    private TextField ETofname;

    @FXML
    private TextField ETolname;

    @FXML
    private RadioButton ETrbYES;

    @FXML
    private TextField ETvMake;

    @FXML
    private TextField ETvNo;

    @FXML
    private ChoiceBox<String> ETvType;

    @FXML
    private ChoiceBox<String> ETvYear;

    @FXML
    Button EtagAppButton;

    @FXML
    void createETApplication(ActionEvent actionEvent) throws IOException {

        if(ETrbYES.isSelected()){
            Application app = getHsms().etagApplication(ETofname.getText(),ETolname.getText(),Integer.parseInt(EToCNIC.getText()),ETvNo.getText(),
                    ETvType.getValue(),ETvYear.getValue(),ETvMake.getText(),Integer.parseInt(ETengineSize.getText()),true);

            Parent root1;
            String appID = String.valueOf(app.getID());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ApplicationSuccessPopUPscreen.fxml"));
            root1 = loader.load();

            popUPcontroller p = loader.getController();
            p.displayapplicationID(appID);

            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();

        }
        if(ERrbNO.isSelected()){
            Application app = getHsms().etagApplication(ETofname.getText(),ETolname.getText(),Integer.parseInt(EToCNIC.getText()),ETvNo.getText(),
                    ETvType.getValue(),ETvYear.getValue(),ETvMake.getText(),Integer.parseInt(ETengineSize.getText()),false);

            Parent root1;
            String appID = String.valueOf(app.getID());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ApplicationSuccessPopUPscreen.fxml"));
            root1 = loader.load();

            popUPcontroller p = loader.getController();
            p.displayapplicationID(appID);

            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        }
    }

    //APPLICATION STATUS
    @FXML
    TextField appIDStatusField;

    @FXML
    Label appIDinsertion;

    @FXML
    Label applicantNameInsertion;

    @FXML
    Label appStatusInsertion;

    @FXML
    Button appStatusSubmit;

    @FXML
    void applicationStatusShow(ActionEvent event) throws IOException {

        //Application application = getHsms().getApplicationStatus(Integer.parseInt(appIDStatusField.getText()));
        Application application = getHsms().getApplicationRecords().getApplication(Integer.parseInt(appIDStatusField.getText()));

        if(application !=null){
            appIDinsertion.setText(String.valueOf(application.getID()));
            applicantNameInsertion.setText(application.getApplicationType());
            appStatusInsertion.setText(application.getApplicationStatus());
        }


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
