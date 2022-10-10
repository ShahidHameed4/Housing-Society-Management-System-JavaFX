package HSMS.Complaint;

import HSMS.ApplicationTypes.ApplicationRecords;
import HSMS.ApplicationTypes.OwnerTransferApplication;
import HSMS.DBHandlers.ComplaintsDBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComplaintRecords extends ApplicationRecords {

    ArrayList<Complaint> ComplaintRecord = new ArrayList<>();
    ComplaintsDBHandler db = new ComplaintsDBHandler();

    public ArrayList<Complaint> getComplaintRecord() {
        return ComplaintRecord;
    }

    public int genID(){
        int min = 10000;
        int max = 20000;

        int tempID = (int)(Math.random()*(max-min+1)+min);

        return tempID;
    }

    public boolean exists(int ID){
        for(Complaint c: ComplaintRecord){
            if (c.getID() == ID)
                return true;
        }

        return false;
    }

    public Complaint getComplaint(int ID){
        for(Complaint c: ComplaintRecord){
            if (c.getID() == ID)
                return c;
        }

       return null;
    }

    public Complaint launchComplaint(String HouseNo, String email, String problem){
                Complaint temp =  new Complaint();
                temp.emailAddress = email;
                temp.houseNo = HouseNo;
                temp.problem = problem;
                temp.complaintStatus = "NE";
                boolean check = false;
                while(!check){
                    int t = genID();
                    if(!exists(t)){
                        temp.ID = t;
                        check = true;
                    }
                }
                //SQL
                db.saveComplaint(temp);
                ComplaintRecord.add(temp);

                return temp;
    }

    public void updateRecords() throws SQLException {
        ResultSet rs = db.retrieveList();
        if(rs != null){
            while(rs.next()){
                Complaint temp = new Complaint();
                temp.ID = rs.getInt("ID");
                temp.houseNo = rs.getString("HouseNo");
                temp.emailAddress = rs.getString("EmailAddress");
                temp.problem = rs.getString("Problem");
                temp.setComplaintStatus(rs.getString("status"));
                ComplaintRecord.add(temp);
            }
        }
    }

    public void updateComplaintStatus(String status, String compId) {
        for(Complaint a: ComplaintRecord) {
            if (a.getID() == Integer.parseInt(compId)){
                a.setComplaintStatus(status);
                db.udpateDB(a);
            }
        }
    }

}
