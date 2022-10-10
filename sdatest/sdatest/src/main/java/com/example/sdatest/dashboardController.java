package com.example.sdatest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void handleBtnResident(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("new.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void handleBtnAdministrator(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("new.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void handleBtnEmployee(ActionEvent actionEvent) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("EmployeeDashboard.fxml"));
//        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }
    @FXML
    public void handleBtnChairman(ActionEvent actionEvent) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Chairman.fxml"));
//        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    @FXML
    public void handleBtnGuest(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Guest/GuestDashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void handleBtnAbout(ActionEvent actionEvent) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("GuestDashboard.fxml"));
//        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
}
