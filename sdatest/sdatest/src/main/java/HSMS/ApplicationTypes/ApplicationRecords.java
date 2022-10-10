package HSMS.ApplicationTypes;

import HSMS.Applicant.Applicant;
import HSMS.DBHandlers.ApplicationDBhandler;
import HSMS.HSMS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationRecords  {

    ArrayList<Application> ApplicationRecord = new ArrayList<Application>();
    ArrayList<EtagApplication> etagApplications = new ArrayList<EtagApplication>();
    ArrayList<RentingApplication> RentingApplications = new ArrayList<RentingApplication>();
    ArrayList<OwnerTransferApplication> TransferApplications = new ArrayList<OwnerTransferApplication>();
    ArrayList<RegistrationApplication> PropRegApplications = new ArrayList<RegistrationApplication>();
    ApplicationDBhandler db = new ApplicationDBhandler();


    public ArrayList<OwnerTransferApplication> getTransferApplications() {
        return TransferApplications;
    }

    public ArrayList<RentingApplication> getRentingApplications() {
        return RentingApplications;
    }

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
        for(Application a: ApplicationRecord){
            if (a.getID() == ID)
                return true;
        }

        return false;
    }

    public Application getApplication(int ID){
        for(Application a: ApplicationRecord){
            if (a.getID() == ID)
                return a;
        }
        return null;
    }

    public Application getApplication(int type, int ID){
        if(type == 1){
            for(RegistrationApplication a: PropRegApplications){
                if (a.getID() == ID)
                    return a;
            }
        }
        if(type == 2){
            for(OwnerTransferApplication a: TransferApplications){
                if (a.getID() == ID)
                    return a;
            }
        }
        if(type == 3){
            for(RentingApplication a: RentingApplications){
                if (a.getID() == ID)
                    return a;
            }
        }
        if(type == 4){
            for(EtagApplication a: etagApplications){
                if (a.getID() == ID)
                    return a;
            }
        }

        return null;
    }

    //ADDING APPLICATIONS TO RECORDS
    public Application createRegApplication(Applicant applicant, String houseNo, String size, String oFName, String oLName, int oAge, int oCnic){
        RegistrationApplication temp = new RegistrationApplication();
        temp.applicant = applicant;
        temp.houseNo = houseNo;
        temp.size = size;
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.age = oAge;
        temp.oCnic = oCnic;
        temp.type = 1;
        temp.ID = assignID();
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        PropRegApplications.add(temp);
        db.saveRegApplication(temp);

        return temp;
    }

    public Application createTransferApplication(String RFName, String RLName,  int RCnic, String oFName, String oLName,  int oCnic, String HouseNo){
        OwnerTransferApplication temp = new OwnerTransferApplication();
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.oCnic = oCnic;
        temp.RCnic = RCnic;
        temp.RFName = RFName;
        temp.RLName = RLName;
        temp.type = 2;
        temp.ID = assignID();
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        TransferApplications.add(temp);
        db.saveOTApplication(temp);
        return temp;
    }

    public Application createRentApplication(String RFName, String RLName, int RCnic, String oFName, String oLName, int oCnic, int rent, int increment){
        RentingApplication temp = new RentingApplication();
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.oCnic = oCnic;
        temp.RCnic = RCnic;
        temp.RFName = RFName;
        temp.RLName = RLName;
        temp. rent = rent;
        temp. increment = increment;
        temp.ID = assignID();
        temp.type = 3;
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        RentingApplications.add(temp);
        db.saveRentingApplication(temp);
        return temp;
    }

    public Application createEtagApplication( String oFName, String oLName, int oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others){
        EtagApplication temp = new EtagApplication();
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.oCnic = oCnic;
        temp.others = others;
        temp.vNo = vNo;
        temp.vType = vType;
        temp.vMake = vMake;
        temp.vYear = vYear;
        temp.vEngineSize = vEngineSize;
        temp.type = 4;
        temp.ID = assignID();
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        etagApplications.add(temp);

        //System.out.println("CREATED");
        db.saveEtagApplication(temp);
        return temp;
    }

    public void updateRecords() throws SQLException {
        updateOTRecords();
        updateRTRecords();
        updateETRecords();
        updateRegRecords();
    }


    public void updateRegRecords() throws SQLException {
        ResultSet rs = db.retrieveList(1);
        if(rs != null){
            while(rs.next()){
                RegistrationApplication temp = new RegistrationApplication();
                temp.ID = rs.getInt("ID");
                temp.OFName = rs.getString("OFName");
                temp.OLName = rs.getString("OLName");
                temp.oCnic = rs.getInt("oCNIC");
                temp.age = rs.getInt("oage");
                temp.type = rs.getInt("ApplicationType");
                temp.applicant.setFirstName(rs.getString("AFirstName"));
                temp.applicant.setLastName(rs.getString("ALastName"));
                temp.applicant.setCnic(rs.getInt("Acnic"));
                temp.applicant.setEmailAddress(rs.getString("AEmailAddress"));
                temp.applicationStatus = rs.getString("ApplicationStatus");
                ApplicationRecord.add(temp);
                PropRegApplications.add(temp);
            }
        }
    }


    public void updateOTRecords() throws SQLException {
        ResultSet rs = db.retrieveList(2);
        if(rs != null){
            while(rs.next()){
                OwnerTransferApplication temp = new OwnerTransferApplication();
                temp.ID = rs.getInt("ID");
                temp.OFName = rs.getString("OFName");
                temp.OLName = rs.getString("OLName");
                temp.oCnic = rs.getInt("oCNIC");
                temp.RFName = rs.getString("RFName");
                temp.RLName = rs.getString("RLName");
                temp.RCnic = rs.getInt("RCNIC");
                temp.type = rs.getInt("ApplicationType");
                temp.applicationStatus = rs.getString("ApplicationStatus");
                ApplicationRecord.add(temp);
                TransferApplications.add(temp);
            }
        }
    }

    public void updateRTRecords() throws SQLException {
        ResultSet rs = db.retrieveList(3);

        while(rs.next()){
            RentingApplication temp = new RentingApplication();
            temp.ID = rs.getInt("ID");
            temp.OFName = rs.getString("OFName");
            temp.OLName = rs.getString("OLName");
            temp.oCnic = rs.getInt("oCNIC");
            temp.RFName = rs.getString("RFName");
            temp.RLName = rs.getString("RLName");
            temp.RCnic = rs.getInt("RCNIC");
            temp.rent = rs.getInt("RENT");
            temp.increment = rs.getInt("INCREMENT");
            temp.type = rs.getInt("ApplicationType");
            temp.applicationStatus = rs.getString("ApplicationStatus");
            ApplicationRecord.add(temp);
            RentingApplications.add(temp);
        }
    }

    public void updateETRecords() throws SQLException {
        ResultSet rs = db.retrieveList(4);

        while(rs.next()){
            EtagApplication temp = new EtagApplication();
            temp.ID = rs.getInt("ID");
            temp.OFName = rs.getString("OFName");
            temp.OLName = rs.getString("OLName");
            temp.vNo =  rs.getString("VehichleNo");
            temp.vType  = rs.getString("vehicleType");
            temp.vMake = rs.getString("VehicleMake");
            temp.vYear = rs.getString("VehicleYear");
            temp.vEngineSize = rs.getInt("EngineSize");
            temp.others = !rs.getString("Others").equals("0");
            temp.type = rs.getInt("ApplicationType");
            //System.out.println(rs.getInt("ApplicationType"));
            temp.applicationStatus = rs.getString("ApplicationStatus");
            temp.oCnic = rs.getInt("oCNIC");
            ApplicationRecord.add(temp);
            etagApplications.add(temp);
        }
    }


    public void getApplications(){
        for(Application app : ApplicationRecord){
            System.out.println(app.getID() + " " + app.getStatus() + " " + app.getApplicationStatus());
        }
    }


    public ArrayList<EtagApplication> getEtagApps() {
        return this.etagApplications;
    }

    public void updateApplicationStatus(String status, String applicationId) {
        for(Application a: ApplicationRecord){
            if (a.getID()== Integer.parseInt(applicationId)){
                a.setApplicationStatus(status);
                if(a.getType() == 1){
                  int var = PropRegApplications.indexOf(a);
                    (PropRegApplications.get(var)).setApplicationStatus(status);
                }
                if(a.getType() == 2){
                    int var = TransferApplications.indexOf(a);
                    (TransferApplications.get(var)).setApplicationStatus(status);
                }
                if(a.getType() == 3){
                    int var = RentingApplications.indexOf(a);
                    (RentingApplications.get(var)).setApplicationStatus(status);
                }
                if(a.getType() == 4){
                    int var = etagApplications.indexOf(a);
                    (etagApplications.get(var)).setApplicationStatus(status);
                }
            }
        }
    }



}
