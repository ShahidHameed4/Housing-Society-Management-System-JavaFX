package com.example.sdatest;

import HSMS.Admin;
import HSMS.ApplicationTypes.EtagApplication;
import HSMS.ApplicationTypes.OwnerTransferApplication;
import HSMS.ApplicationTypes.RentingApplication;
import HSMS.Complaint.Complaint;
import HSMS.Complaint.ComplaintRecords;
import HSMS.HSMS;
import HSMS.Property.House;
import HSMS.Property.HouseRecords;

import HSMS.Resident.Resident;
import HSMS.Announcement;
import HSMS.Resident.residentRecords;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static HSMS.HSMS.getHsms;

public class AdminController {







//    @FXML
//    private URL location;
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
//

    @FXML
    private ResourceBundle resources;
    @FXML
    private ChoiceBox<?> role11;

    @FXML
    private ChoiceBox<?> role;

    @FXML
    private Label allocatedHouses;

    @FXML
    private TextField bkNo;



    @FXML
    private ChoiceBox<String> houseType;





    @FXML
    private Label remainingHouses;

    @FXML
    private Label confirmationHouseAdd;

    @FXML
    private Label totalHouses;



    @FXML
    private Button addHouse1;

    @FXML
    private Button viewSocietyDetails1;

    @FXML
    private TableView<TableData> TableHouses;

    @FXML
    private TableColumn<TableData, String> HouseBlock;
    @FXML
    private TableColumn<TableData, String> hrSR;
    @FXML
    private TableColumn<TableData, String> Htype;
    @FXML
    private TextField descriptionHouse;
    @FXML
    private TableColumn<TableData, String> DescHouse;

    @FXML
    private TableView<TableData> TableHouses1;

    @FXML
    private TableColumn<TableData, String> HouseBlock1;
    @FXML
    private TableColumn<TableData, String> hrSR1;
    @FXML
    private TableColumn<TableData, String> Htype1;
    @FXML
    private TableColumn<TableData, String> DescHouse1;


    @FXML
    private HBox loaderPane;

    @FXML
    private Button viewSocietyDetails;

    @FXML
    private Button Logout;

    @FXML
    private TextField deleteHouseSr;



    @FXML
    private StackPane mainPane;

    @FXML
    private VBox detailsPane;

//    @FXML
//    void handleLogout(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Admin/new.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }



    @FXML
    void handleLoginBtn(ActionEvent event) {

    }



    @FXML
    void handleAddHouse(ActionEvent event) {
        try{
            HSMS.getHsms().addHouse(bkNo.getText(),descriptionHouse.getText().toString(),houseType.getValue());
        }catch (Exception e){
        }
    }




    @FXML
    void handleSocietyDetails(ActionEvent event) {
        HouseRecords houses= HSMS.getHsms().getHouses();
        int i=0;
            final ObservableList<TableData> data = FXCollections.observableArrayList();
            for (int z = 0; z < houses.getHouseRecords().size(); z++) {
                data.add(new TableData(houses.getHouseRecords().get(i).gethNo(),houses.getHouseRecords().get(i).getBlockN(),houses.getHouseRecords().get(i).getDesc(),houses.getHouseRecords().get(i).getType()));

                System.out.println("aaaa  "+houses.getHouseRecords().get(i).gethNo());
                i++;
            }

            hrSR.setCellValueFactory(new PropertyValueFactory("data1"));
            Htype.setCellValueFactory(new PropertyValueFactory("data2"));
            DescHouse.setCellValueFactory(new PropertyValueFactory("data3"));
            HouseBlock.setCellValueFactory(new PropertyValueFactory("data4"));

            TableHouses.setItems(data);
    }


    @FXML
    void handleSocietyDetails1(ActionEvent event) {

        HouseRecords houses= HSMS.getHsms().getHouses();
        int i=0;
        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for (int z = 0; z < houses.getHouseRecords().size(); z++) {
            data.add(new TableData(houses.getHouseRecords().get(i).gethNo(),houses.getHouseRecords().get(i).getBlockN(),houses.getHouseRecords().get(i).getDesc(),houses.getHouseRecords().get(i).getType()));
            i++;
        }

        hrSR1.setCellValueFactory(new PropertyValueFactory("data1"));
        Htype1.setCellValueFactory(new PropertyValueFactory("data2"));
        DescHouse1.setCellValueFactory(new PropertyValueFactory("data3"));
        HouseBlock1.setCellValueFactory(new PropertyValueFactory("data4"));


        TableHouses1.setItems(data);
    }

//
//
//    @FXML
//    void handleHouses(ActionEvent event) {
//
//
//
//    }
//
//
//


    @FXML
    private TextField passAlot;

    @FXML
    private TextField cnicAlot;
    @FXML
    private TextField emailAlot;
    @FXML
    private TextField LnameAlot;

    @FXML
    private TextField fnameAlot;
    public void handleHouseAlot(ActionEvent actionEvent) {
        HSMS.getHsms().regHouse(fnameAlot.getText(),LnameAlot.getText(),emailAlot.getText(),cnicAlot.getText(),20,passAlot.getText(),TableHouses1.getSelectionModel().getSelectedItem().getData1());
    }

        @FXML
    void handleHouseDel(ActionEvent event) {

    }


    @FXML
    private TableView<TableData> TableEtag;

    @FXML
    private TableColumn<TableData,String> applicantNameEtag;
    @FXML
    private TableColumn<TableData, String> vehNo;
    @FXML
    private TableColumn<TableData, String> appNoEtag;
    @FXML
    private TableColumn<TableData, String> vType;
    @FXML
    private TableColumn<TableData, String> dateVehicle;


    public void viewEtag(ActionEvent actionEvent) {
        ArrayList<EtagApplication> eTag= HSMS.getHsms().getEtagApps();
        int i=0;
        final ObservableList<TableData> data = FXCollections.observableArrayList(
        );
        for ( i = 0; i < eTag.size(); i++) {
           if( eTag.get(i).getApplicationStatus().equals("NOT EVALUATED")) {
                data.add(new TableData(Integer.toString(eTag.get(i).getID()), eTag.get(i).getvNo(), eTag.get(i).getvType(), eTag.get(i).getOFName()));

                System.out.println("aaaa  " + eTag.get(i).getID());
            }
        }
        appNoEtag.setCellValueFactory(new PropertyValueFactory("data1"));
        vehNo.setCellValueFactory(new PropertyValueFactory("data2"));
        vType.setCellValueFactory(new PropertyValueFactory("data3"));
        applicantNameEtag.setCellValueFactory(new PropertyValueFactory("data4"));
        dateVehicle.setCellValueFactory(new PropertyValueFactory("data5"));


        TableEtag.setItems(data);
    }

    public void handleEtag(SortEvent<TableView> tableViewSortEvent) {
    }

    public void approveEtag(ActionEvent actionEvent) {
        try{
            TableData temp=TableEtag.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("A", temp.getData1());

        }catch(Exception e){

        }
    }

    public void rejEtag(ActionEvent actionEvent) {
        try{
            TableData temp=TableEtag.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("R", temp.getData1());

        }catch(Exception e){
        }
    }

    public void handleHouses1(SortEvent<TableView<TableData>> tableViewSortEvent) {
    }

    @FXML
    Pane pnlResidents;

    @FXML
    Pane pnlAlloctateProperty;

    @FXML
    Pane pnlComplaints;

    @FXML
    Pane pnlManageProperty;

    @FXML
    Pane pnlOverview;

    @FXML
    Pane pnlRegApp;

    @FXML
    Pane pnlRentingApp;

    @FXML
    Pane pnlTransferApp;

    @FXML
    Pane pnlEtagApps;


    @FXML
    Button btnMngProp;

    @FXML
    Button btnViewComplaints;

    @FXML
    Button btnEtagApps;

    @FXML
    Button btnRegApps;

    @FXML
    Button btnTransApps;

    @FXML
    Button btnRentApps;

    @FXML
    Button btnResidents;

    @FXML
    Button BackButton;
    @FXML
    Button btnAllocateProp;

    @FXML
    Pane pnlAnnouncement;

    @FXML
    Button BtnAnnouncement;

    @FXML
    Label Labeladmin;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void initialize(){
        pnlOverview.setStyle("-fx-background-color : #FF7700");
        pnlOverview.toFront();
//        nameLabel.setText(getHsms().getResident().getFirstName() + " " + getHsms().getResident().getLastName());
//        cnicLabel.setText(getHsms().getResident().getCnic());
//        ageLabel.setText(String.valueOf(getHsms().getResident().getAge()));
//        emailLabel.setText(getHsms().getResident().getEmailAddress());
    }

    @FXML
    public void gotoDashboard(){
        pnlOverview.setStyle("-fx-background-color : #FF7700");
        pnlOverview.toFront();
    }

    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnAllocateProp) {
            pnlAlloctateProperty.setStyle("-fx-background-color : #FF7700");
            pnlAlloctateProperty.toFront();
        }
        if (actionEvent.getSource() == btnResidents) {
            pnlResidents.setStyle("-fx-background-color : #FF7700");
            pnlResidents.toFront();
        }
        if (actionEvent.getSource() == btnMngProp) {
            pnlManageProperty.setStyle("-fx-background-color : #FF7700");
            pnlManageProperty.toFront();
        }
        if (actionEvent.getSource() == btnViewComplaints) {
            pnlComplaints.setStyle("-fx-background-color : #FF7700");
            pnlComplaints.toFront();
        }
        if (actionEvent.getSource() == btnEtagApps) {
            pnlEtagApps.setStyle("-fx-background-color : #FF7700");
            pnlEtagApps.toFront();
        }
        if (actionEvent.getSource() == btnRegApps) {
            pnlRegApp.setStyle("-fx-background-color : #FF7700");
            pnlRegApp.toFront();
        }
        if (actionEvent.getSource() == btnTransApps) {
            pnlTransferApp.setStyle("-fx-background-color : #FF7700");
            pnlTransferApp.toFront();
        }
        if (actionEvent.getSource() == btnRentApps) {
            pnlRentingApp.setStyle("-fx-background-color : #FF7700");
            pnlRentingApp.toFront();
        }
        if (actionEvent.getSource() == BtnAnnouncement) {
            pnlAnnouncement.setStyle("-fx-background-color : #FF7700");
            pnlAnnouncement.toFront();
        }
        if (actionEvent.getSource() == BackButton) {
            //pnlOverview.setStyle("-fx-background-color : #02030A");
            root = FXMLLoader.load(getClass().getResource("newUI/Login.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    // COMPLAINTS

    @FXML
    private TableView<TableData> tableComplain;

    @FXML
    private TableColumn<TableData, ?> complainId;

    @FXML
    private TableColumn<TableData, ?> compType;

    @FXML
    private TableColumn<TableData, ?> compHno;

    @FXML
    private TableColumn<TableData, ?> compStatus;


    public void viewComps2(ActionEvent actionEvent) {
        ComplaintRecords complaints= getHsms().getComplaintRecords();
        for ( Complaint c: complaints.getComplaintRecord()) {
            System.out.println(c.getID() + " " + c.getStatus());
        }

        int i=0;

        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for ( i = 0; i < complaints.getComplaintRecord().size(); i++) {
            if( complaints.getComplaintRecord().get(i).getComplaintStatus().equals("PENDING")) {
                data.add(new TableData(Integer.toString(complaints.getComplaintRecord().get(i).getID()), complaints.getComplaintRecord().get(i).getProblem(),
                        complaints.getComplaintRecord().get(i).getComplaintStatus(), complaints.getComplaintRecord().get(i).getHouseNo()));

                System.out.println("aaaa11s  " + complaints.getComplaintRecord().get(i).getID());
            }
        }
        complainId.setCellValueFactory(new PropertyValueFactory("data1"));
        compType.setCellValueFactory(new PropertyValueFactory("data2"));
        compStatus.setCellValueFactory(new PropertyValueFactory("data3"));
        compHno.setCellValueFactory(new PropertyValueFactory("data4"));


        tableComplain.setItems(data);
    }

    public void approveComp(ActionEvent actionEvent) {

        try{
            TableData temp=tableComplain.getSelectionModel().getSelectedItem();
            // System.out.println(temp.getData2());
            HSMS.getHsms().updateComplainStatus("S", temp.getData1());

        }catch(Exception e){

        }
    }

    //TRANSFER APPLICATIONS

    @FXML
    private TableView<TableData> tableTransfer;

    @FXML
    private TableColumn<TableData, ?> transferId;

    @FXML
    private TableColumn<TableData, ?> transferNewOwner;

    @FXML
    private TableColumn<TableData, ?> transferHno;

    @FXML
    private TableColumn<TableData, ?> TransferOldOwnerID;

    @FXML
    private TableColumn<TableData, String> transferStatus;



    public void viewtransfer(ActionEvent actionEvent) {
        ArrayList<OwnerTransferApplication> transfers= HSMS.getHsms().getTransferApplications();
        int i=0;

        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for ( i = 0; i < transfers.size(); i++) {
            if( transfers.get(i).getApplicationStatus().equals("NOT EVALUATED")) {
                data.add(new TableData(Integer.toString(transfers.get(i).getID()),Integer.toString(transfers.get(i).getRCnic()), Integer.toString(transfers.get(i).getoCnic()),transfers.get(i).getApplicationStatus(), transfers.get(i).getHouseNo()));

                System.out.println("aaaa11s  " + transfers.get(i).getID());
            }
        }
        transferId.setCellValueFactory(new PropertyValueFactory("data1"));
        transferNewOwner.setCellValueFactory(new PropertyValueFactory("data2"));
        TransferOldOwnerID.setCellValueFactory(new PropertyValueFactory("data3"));
        transferStatus.setCellValueFactory(new PropertyValueFactory("data4"));
        transferHno.setCellValueFactory(new PropertyValueFactory("data5"));

        tableTransfer.setItems(data);
    }

    public void rejtransfers(ActionEvent actionEvent) {
        try{
            TableData temp=tableTransfer.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("R", temp.getData1());

        }catch(Exception e){

        }

    }

    public void approveTran(ActionEvent actionEvent) {
        try{
            TableData temp=tableTransfer.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("A", temp.getData1());

        }catch(Exception e){

        }



    }


    @FXML
    private TableView<TableData> tableRent;

    @FXML
    private TableColumn<TableData, ?> rentId;

    @FXML
    private TableColumn<TableData, ?> rentnewRenterId;

    @FXML
    private TableColumn<TableData, ?> rentOwnerID;

    @FXML
    private TableColumn<TableData, ?> rentStatus;

    public void approveRent(ActionEvent actionEvent) {
        try{
            TableData temp=tableRent.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("A", temp.getData1());




        }catch(Exception e){

        }
    }

    public void rejRent(ActionEvent actionEvent) {

        try{
            TableData temp=tableRent.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("R", temp.getData1());




        }catch(Exception e){

        }
    }

    public void viewRent1(ActionEvent actionEvent) {

        ArrayList<RentingApplication> rentApps= HSMS.getHsms().getRentingApplications();
        int i=0;

        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for ( i = 0; i < rentApps.size(); i++) {
            if( rentApps.get(i).getApplicationStatus().equals("NOT EVALUATED")) {
                data.add(new TableData(Integer.toString(rentApps.get(i).getID()),Integer.toString(rentApps.get(i).getRCnic()), Integer.toString(rentApps.get(i).getoCnic()),rentApps.get(i).getApplicationStatus()));

                System.out.println("aaaa11s  " + rentApps.get(i).getID());
            }
        }
        rentId.setCellValueFactory(new PropertyValueFactory("data1"));
        rentnewRenterId.setCellValueFactory(new PropertyValueFactory("data2"));
        rentOwnerID.setCellValueFactory(new PropertyValueFactory("data3"));
        rentStatus.setCellValueFactory(new PropertyValueFactory("data4"));




        tableRent.setItems(data);

    }


    //ANNOUNCEMENT

    @FXML
    private TextField annoucementdescription;

    @FXML
    private TableView<TableData> tableAnnoucement;

    @FXML
    private TableColumn<TableData, ?> annoucementDate;

    @FXML
    private TableColumn<TableData, ?> AnnoucementDate;





    public void postAnnoucement(ActionEvent actionEvent) {

        if(!annoucementdescription.getText().equals("")){
            HSMS.getHsms().addAnnoucement(annoucementdescription.getText().toString());
        }


        ArrayList<Announcement> transfers= getHsms().getAnnoucements();
        int i=0;

        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for ( i = 0; i < transfers.size(); i++) {

            data.add(new TableData(String.valueOf(transfers.get(i).getDate()) ,transfers.get(i).getDesc()));
        }
        annoucementDate.setCellValueFactory(new PropertyValueFactory("data1"));
        AnnoucementDate.setCellValueFactory(new PropertyValueFactory("data2"));

        tableAnnoucement.setItems(data);
    }

    //RESIDENTS


    @FXML
    private TableColumn<TableData, ?> nameMem;

    @FXML
    private TableColumn<TableData, ?> emailMem;

    @FXML
    TableColumn<TableData, String> cnicMem;

    @FXML
    private TableView<TableData> memberHouses;

    public void viewMembers1(ActionEvent actionEvent) {
        residentRecords residents= getHsms().getResidentRecords();
        int i=0;

        final ObservableList<TableData> data = FXCollections.observableArrayList();

        for (Map.Entry<String,Resident> obj:residents.getResidentRecords().entrySet()) {

            String key=obj.getKey();
            HashMap<String,House> houses= residents.getResidentRecords().get(key).getHouses();
            House temp=new House();
            for (Map.Entry<String,House> house:houses.entrySet()) {
                String hKey=house.getKey();
                temp=houses.get(hKey);
            }


            data.add(new TableData(temp.gethNo(),residents.getResidentRecords().get(key).getFirstName(),
                    residents.getResidentRecords().get(key).getEmailAddress(),residents.getResidentRecords().get(key).getCnic()));

            // System.out.println("aaaa11s  " + residents.get(i).getID());

        }

        nameMem.setCellValueFactory(new PropertyValueFactory("data2"));
        emailMem.setCellValueFactory(new PropertyValueFactory("data3"));
        cnicMem.setCellValueFactory(new PropertyValueFactory("data4"));


        memberHouses.setItems(data);
    }


}

