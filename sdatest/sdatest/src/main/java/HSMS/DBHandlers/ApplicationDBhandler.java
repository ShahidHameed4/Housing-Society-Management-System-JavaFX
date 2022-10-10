package HSMS.DBHandlers;

import HSMS.ApplicationTypes.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ApplicationDBhandler {

    public void saveRegApplication(RegistrationApplication application){
        String sql = "insert into Registration_Applications (AFirstName, ALastName, Acnic, AEmailAddress, ID, houseNo, Size, OFName, OLName, Oage, oCNIC,ApplicationType, ApplicationStatus) VALUES(?,?,?, ?, ?, ?,?, ?, ?, ?,?,?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1,application.getApplicant().getFirstName());
            st.setString(2, application.getApplicant().getLastName());
            st.setString(3, String.valueOf(application.getApplicant().getCnic()));
            st.setString(4, application.getApplicant().getEmailAddress());
            st.setString(5, String.valueOf(application.getID()));
            st.setString(6, application.getHouseNo());
            st.setString(7, application.getSize());
            st.setString(8, application.getOFName());
            st.setString(9, application.getOLName());
            st.setString(10, String.valueOf(application.getoAge()));
            st.setString(11, String.valueOf(application.getoCnic()));
            st.setString(12, String.valueOf(application.getType()));
            st.setString(13, String.valueOf(application.getStatus()));
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void saveRentingApplication(RentingApplication application){
        String sql = "insert into Renting_Applications ( ID,OFName, OLName, oCNIC, RFName,RLName, RCNIC, RENT, INCREMENT,ApplicationType, ApplicationStatus) VALUES(?, ?,?, ?, ?, ?,?, ?, ?, ?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, String.valueOf(application.getID()));
            st.setString(2, application.getOFName());
            st.setString(3, application.getOLName());
            st.setString(4, String.valueOf(application.getoCnic()));
            st.setString(5, application.getRFName());
            st.setString(6, application.getRLName());
            st.setString(7, String.valueOf(application.getRCnic()));
            st.setString(8, String.valueOf(application.getRent()));
            st.setString(9, String.valueOf(application.getIncrement()));
            st.setString(10, String.valueOf(application.getType()));
            st.setString(11,application.getStatus());
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void saveOTApplication(OwnerTransferApplication application){
        String sql = "insert into OT_Applications ( ID,OFName, OLName, oCNIC, RFName,RLName, RCNIC,ApplicationType, ApplicationStatus) VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, String.valueOf(application.getID()));
            st.setString(2, application.getOFName());
            st.setString(3, application.getOLName());
            st.setString(4, String.valueOf(application.getoCnic()));
            st.setString(5, application.getRFName());
            st.setString(6, application.getRLName());
            st.setString(7, String.valueOf(application.getRCnic()));
            st.setString(8, String.valueOf(application.getType()));
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void saveEtagApplication(EtagApplication application){
        String sql = "insert into Etag_Applications ( ID,OFName, OLName, oCNIC, VehichleNo, VehicleType, VehicleMake, VehicleYear, EngineSize, Others,ApplicationType, ApplicationStatus) VALUES(?,?, ?, ?, ?,?, ?, ?, ?,?,?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, String.valueOf(application.getID()));
            st.setString(2, application.getOFName());
            st.setString(3, application.getOLName());
            st.setString(4, String.valueOf(application.getoCnic()));
            st.setString(5, application.getvNo());
            st.setString(6, application.getvType());
            st.setString(7, application.getvMake());
            st.setString(8, application.getvYear());
            st.setString(9, String.valueOf(application.getvEngineSize()));
            st.setString(10, application.isOthers());
            st.setString(11, String.valueOf(application.getType()));
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public ResultSet retrieveList(int n){
        String sql;
        ResultSet rs;
        if(n == 1){
            try {
                sql = "select * from Registration_Applications";
                String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
                //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
                Connection conn = DriverManager.getConnection(url,"User","qwerty");
                PreparedStatement p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                return rs;
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }


        if(n == 2){
            try {

                sql = "select * from OT_Applications";
                String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
                //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
                Connection conn = DriverManager.getConnection(url,"User","qwerty");
                PreparedStatement p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                return rs;
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }

        if(n == 3){
            try {

                sql = "select * from Renting_Applications";
                String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
                //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
                Connection conn = DriverManager.getConnection(url,"User","qwerty");
                PreparedStatement p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                return rs;
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }
        if(n == 4){
            try {

            sql = "select * from Etag_Applications";
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            return rs;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        }

        return null;
    }

}
