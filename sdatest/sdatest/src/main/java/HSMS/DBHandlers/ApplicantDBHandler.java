package HSMS.DBHandlers;

import HSMS.Applicant.Applicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplicantDBHandler {


    public void saveApplicant(Applicant applicant){
        String sql = "insert into Applicants (ID,FirstName, LastName, CNIC, Email) VALUES(?,?, ?, ?, ?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1,String.valueOf(applicant.getID()));
            st.setString(2,applicant.getFirstName());
            st.setString(3, applicant.getLastName());
            st.setString(4, String.valueOf(applicant.getCnic()));
            st.setString(5, applicant.getEmailAddress());
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }


    public ResultSet retrieveList() {
        String sql;
        ResultSet rs;
        try {
            sql = "select * from Applicants";
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url, "User", "qwerty");
            PreparedStatement p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            return rs;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
        return null;
    }


}
