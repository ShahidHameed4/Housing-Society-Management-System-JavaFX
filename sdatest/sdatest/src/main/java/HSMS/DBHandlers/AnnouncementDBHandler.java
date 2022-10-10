package HSMS.DBHandlers;

import HSMS.Announcement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnnouncementDBHandler {

    public void saveAnnouncement(Announcement announcement){
        String sql = "insert into announcement (Date, description) VALUES(?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1,String.valueOf(announcement.getDate()));
            st.setString(2,announcement.getDesc());

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
            sql = "select * from announcement";
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
