package HSMS.Applicant;

import HSMS.Complaint.Complaint;
import HSMS.DBHandlers.ApplicantDBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicantRecords {

    //private static ApplicantRecords applicantRecords = null;

    ArrayList<Applicant> ApplicantRecords = new ArrayList<Applicant>();
    ApplicantDBHandler db = new ApplicantDBHandler();

    private int assignID(){
        int t = 0;
        boolean check = false;
        while(!check){
            t = genID();
            if(!exists(t)){
                return t;
            }
        }
        return t;
    }

    private int genID(){
        int min = 10000;
        int max = 20000;

        int tempID = (int)(Math.random()*(max-min+1)+min);

        return tempID;
    }

    private boolean exists(int ID){
        for(Applicant a: ApplicantRecords){
            if (a.getID() == ID)
                return true;
        }

        return false;
    }

    public Applicant applicantCreation(String fname, String lname, int cninc, String email){
        int tempID = assignID();
        Applicant temp = new Applicant(tempID,fname,lname,cninc,email);
        ApplicantRecords.add(temp);
        db.saveApplicant(temp);

        return temp;
    }

    public Applicant applicantCreation(String fname, String lname, int cninc, String email, boolean check){
        // owner DBHandler check if applicant cnic  ==  registered owner CNIC

        Applicant temp = new Applicant(assignID(),fname,lname,cninc,email);
        ApplicantRecords.add(temp);
        db.saveApplicant(temp);

        return temp;
    }

    public Applicant getApplicant(int ID){
        for(Applicant a : ApplicantRecords){
            if(a.getID() == ID){
                return a;
            }
        }
        return null;
    }

    public void updateRecords() throws SQLException {
        ResultSet rs = db.retrieveList();
        if(rs != null){
            while(rs.next()){
                Applicant temp = new Applicant();
                temp.setID(rs.getInt("ID"));
                temp.setFirstName(rs.getString("FirstName"));
                temp.setLastName(rs.getString("LastName"));
                temp.setCnic(rs.getInt("CNIC"));
                temp.setEmailAddress(rs.getString("Email"));
            }
        }

    }
}
