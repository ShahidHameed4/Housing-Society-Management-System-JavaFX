package HSMS.DBHandlers;

import HSMS.Complaint.Complaint;
import HSMS.Property.House;

import java.sql.*;

public class HouseDBHandler {

    public void saveHouse(House house) {
        String sql = "insert into Houses (hNo, blockN, description, type, rCNIC, oCNIC) VALUES(?, ?,  ?,?,?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url, "User", "qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, house.gethNo());
            st.setString(2, house.getBlockN());
            st.setString(3, house.getDesc());
            st.setString(4, house.getType());
            st.setString(5, String.valueOf(house.getrCNIC()));
            st.setString(6, String.valueOf(house.getoCNIC()));
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
            sql = "select * from Houses";
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url, "User", "qwerty");
            PreparedStatement p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            return rs;
        } catch (Exception e) {
            System.err.println("Got an exception! in retrieving ");
            System.err.println(e.getMessage());

        }
        return null;
    }

    public void udpateDB(House house) {
        //String sql = "insert into Complaints (ID, HouseNO, EmailAddress, Problem, status) VALUES(?, ?, ?, ?,?)";
        String sql = "UPDATE Houses SET oCNIC = ?, rCNIC = ? WHERE hNO = ?";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url, "User", "qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, String.valueOf(house.getoCNIC()) );
            st.setString(2, String.valueOf(house.getrCNIC()));
            st.setString(3, house.gethNo());
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }


}
