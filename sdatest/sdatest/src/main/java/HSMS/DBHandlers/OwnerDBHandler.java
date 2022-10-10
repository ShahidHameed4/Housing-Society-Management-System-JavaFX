package HSMS.DBHandlers;

import HSMS.Resident.Owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OwnerDBHandler {

    public void saveOwner(Owner owner){
        String sql = "insert into Owners (FirstName, LastName, Age, CNIC, EmailAddress) VALUES(?, ?, ?, ?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, owner.getFirstName());
            st.setString(2, owner.getLastName());
            st.setString(3, String.valueOf(owner.getAge()));
            st.setString(4, String.valueOf(owner.getcNIC()));
            st.setString(5, owner.getEmailAddress());
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}
