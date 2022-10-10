package com.example.sdatest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static HSMS.HSMS.getHsms;


public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button button;

    @FXML
    private Hyperlink guestlink;

    @FXML
    private TextField password;

    @FXML
    private RadioButton radiobtnadmincheck;

    @FXML
    private TextField userName;

    @FXML
    private Label wrongLogIn;

    @FXML
    void rdGuestDashboard(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newUI/GuestDashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void userLogIn(ActionEvent actionEvent) throws IOException {

        //System.out.println(userName.getText() + "  " + password.getText());

        if(radiobtnadmincheck.isSelected()){
            if(getHsms().loginAdmin(this.userName.getText(),this.password.getText())){
                root = FXMLLoader.load(getClass().getResource("newUI/AdminDashboard.fxml"));

                //ApplicationStatusPOPUPController a = fxmlLoader.getController();
                //a.display(String.valueOf(application.getID()) ,application.getApplicationStatus(),application.getApplicant().getFirstName() + " " + application.getApplicant().getLastName());
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
           // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Guest/ApplicationStatusPopUP.fxml"));
        }

        else {
            if(getHsms().loginResident(this.userName.getText(),this.password.getText())){
                root = FXMLLoader.load(getClass().getResource("newUI/ResidentDashboard.fxml"));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }

    }


}
