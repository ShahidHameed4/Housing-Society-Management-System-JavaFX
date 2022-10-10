package com.example.sdatest;

import HSMS.Applicant.Applicant;
import HSMS.ApplicationTypes.Application;
import HSMS.Complaint.Complaint;
import HSMS.Resident.Resident;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static HSMS.HSMS.getHsms;

public class ResidentController1 {

    public static Resident owner;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label name=new Label();


    @FXML
    private Button refreshBtn;

    @FXML
    public void BackBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentDashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void MenuBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ApplyRent(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentRentingApplication.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void TransferProperty(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentOwnershipTransfer.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void EtagApplication(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/EtagApplication.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Complaints(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentComplaintReg.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //COMPLAINTS
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ComplaintIDPopUP.fxml"));
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

    public void getComplaintInfo(ActionEvent actionEvent){
        Complaint temp = getHsms().getComplaint(Integer.parseInt(complaintIDtextField.getText()));

        checkComplaintIDLabel.setText(String.valueOf(temp.getID()));
        checkComplaintProblemLabel.setText(temp.getProblem());
        checkComplaintStatusLabel.setText(temp.getComplaintStatus());

    }

    //CREATE APPLICANT
    @FXML
    private TextField aCNIC;

    @FXML
    private TextField aEmail;

    @FXML
    private TextField afName;

    @FXML
    private TextField alName;


    @FXML
    void createApplicant(ActionEvent event) throws IOException {
        Applicant app =  getHsms().createApplicant(afName.getText(),alName.getText(),Integer.parseInt(aCNIC.getText()), aEmail.getText(),true);
        Parent root1;
        String appID = String.valueOf(app.getID());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ApplicantSuccessPopUPscreen.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayapplicantID(appID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    //OT APPLICATION

    @FXML
    private TextField OTapplicantID;

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
    //RENTING APPLICATION

    @FXML
    private TextField RPApplicantID;

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


    //GET APPLICATION STATUS

    @FXML
    public void ApplicationStatusBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ApplicationStatus.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField appIDStatusField;

    @FXML
    public void ApplicationStatusPopUP(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Resident/ApplicationStatusPopUPscreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Application application = getHsms().getApplicationStatus(Integer.parseInt(appIDStatusField.getText()));


        ApplicationStatusPOPUPController a = fxmlLoader.getController();
        a.display(String.valueOf(application.getID()) ,application.getApplicationStatus(),application.getApplicant().getFirstName() + " " + application.getApplicant().getLastName());

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }




}
