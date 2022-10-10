package HSMS.DBHandlers;

import HSMS.Complaint.Complaint;

import java.sql.*;

public class ComplaintsDBHandler {

    public void saveComplaint(Complaint complaint) {
        String sql = "insert into Complaints (ID, HouseNO, EmailAddress, Problem, status) VALUES(?, ?, ?, ?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url, "User", "qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, String.valueOf(complaint.getID()));
            st.setString(2, complaint.getHouseNo());
            st.setString(3, complaint.getEmailAddress());
            st.setString(4, complaint.getProblem());
            st.setString(5, complaint.getStatus());
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void udpateDB(Complaint complaint) {
        //String sql = "insert into Complaints (ID, HouseNO, EmailAddress, Problem, status) VALUES(?, ?, ?, ?,?)";
        String sql = "UPDATE Complaints SET status = ? WHERE ID = ?";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url, "User", "qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, complaint.getStatus());
            st.setString(2, String.valueOf(complaint.getID()));
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }



    public ResultSet retrieveList() throws SQLException {

        String sql;
        ResultSet rs;
        try {
            sql = "select * from Complaints";
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
