package HSMS;

import HSMS.DBHandlers.AnnouncementDBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Announcement {
    String date;
    String desc;
    ArrayList<Announcement> announcements =new ArrayList<>();

    AnnouncementDBHandler db = new AnnouncementDBHandler();
    static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;


    void addAnnoucement(String desc){
        Announcement temp=new Announcement();
        temp.desc=desc;
        temp.date= (LocalDateTime.now()).format(formatter);
        this.announcements.add(temp);
        db.saveAnnouncement(temp);
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(ArrayList<Announcement> announcements) {
        this.announcements = announcements;
    }

    public void updateAnnouncementData() throws SQLException {
        ResultSet rs = db.retrieveList();
        if(rs != null){
            while(rs.next()){
                Announcement temp = new Announcement();
                temp.date = rs.getString("Date");
                temp.desc = rs.getString("description");
                announcements.add(temp);

            }
        }
    }
}
