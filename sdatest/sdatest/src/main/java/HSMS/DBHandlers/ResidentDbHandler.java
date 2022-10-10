package HSMS.DBHandlers;

import HSMS.Resident.Owner;
import HSMS.Resident.Resident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResidentDbHandler {

    public void saveResident(Resident owner){
        String sql = "insert into Residents (CNIC, FirstName, LastName, Age, EmailAdress,Password) VALUES(?,?, ?, ?, ?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1,owner.getCnic());
            st.setString(2, owner.getFirstName());
            st.setString(3, owner.getLastName());
            st.setString(4, String.valueOf(22));
            //st.setString(4, String.valueOf(owner.getcNIC()));
            st.setString(5, owner.getEmailAddress());
            st.setString(6, owner.getPassword());
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
            sql = "select * from Residents";
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
