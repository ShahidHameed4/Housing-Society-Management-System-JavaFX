module com.example.sdatest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sdatest to javafx.fxml;
    exports com.example.sdatest;
}