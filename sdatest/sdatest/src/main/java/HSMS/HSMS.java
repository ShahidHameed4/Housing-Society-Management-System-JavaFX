package HSMS;

import HSMS.Applicant.Applicant;
import HSMS.Applicant.ApplicantRecords;
import HSMS.ApplicationTypes.*;
import HSMS.Complaint.Complaint;
import HSMS.Complaint.ComplaintRecords;
import HSMS.Property.House;
import HSMS.Property.HouseRecords;
import HSMS.Resident.Owner;
import HSMS.Resident.OwnerRecords;
import HSMS.Resident.Resident;
import HSMS.Resident.residentRecords;

import java.sql.SQLException;
import java.util.ArrayList;


public class HSMS {

    private static HSMS hsms = null;
    private static Admin admin = new Admin();
    private static Resident  resident = null;
//    Application regApplication = new RegistrationApplication();
//    Application oTApplication = new OwnerTransferApplication();
//    Application rentingApplication = new RentingApplication();
//    Application EtagApplication = new EtagApplication();
    ApplicationRecords applicationRecords = new ApplicationRecords();
    ComplaintRecords complaintRecords = new ComplaintRecords();
    ApplicantRecords applicantRecords = new ApplicantRecords();

    HouseRecords houseRecords = new HouseRecords();
    residentRecords residentRecords = new residentRecords();
    OwnerRecords owners = new OwnerRecords();
    private Announcement announcement =  new Announcement();


    public ApplicationRecords getApplicationRecords() {
        return applicationRecords;
    }

    public ComplaintRecords getComplaintRecords() {
        return complaintRecords;
    }



    //Admin admin=new Admin();
    //ArrayList<House> houses=new ArrayList<House>();


    public static HSMS getHsms(){
        if(hsms == null){
            hsms = new HSMS();
        }
        return hsms;
    }

//    public Resident getResident(){
//
//    }

    public Resident getResident(){
        return resident;
    }

    public boolean loginResident(String cnic, String password){
        resident =  residentRecords.login(cnic,password);
        if(resident != null){
            return true;
        }

        return false;
    }

    public boolean loginAdmin(String username, String password){
        return admin.login(username, password);
    }

    public static Admin getAdmin(){
        return admin;
    }


    public void start() throws SQLException {
        applicationRecords.updateRecords();
        complaintRecords.updateRecords();
        applicantRecords.updateRecords();

        //applicationRecords.getApplications();r

        announcement.updateAnnouncementData();
        houseRecords.updateHouses();
        residentRecords.updateResidents();
    }


    public Applicant createApplicant(String fname, String lname, int cnic, String email, boolean check){
        if(!check)
            return applicantRecords.applicantCreation(fname, lname, cnic,email);
        else
          return applicantRecords.applicantCreation(fname, lname,cnic,email,check);
    }

    public Application propertyRegistrationApplication(int ApplicationNo,String houseNo, String size, String oFName, String oLName, int oAge, int oCnic){
        Applicant tempApplicant = applicantRecords.getApplicant(ApplicationNo);
        if(tempApplicant.getID() != 0)
              return  applicationRecords.createRegApplication(tempApplicant,houseNo,size,oFName,oLName,oAge,oCnic);

        return null;
    }

    public Application propertyTransApplication(String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic, String HouseNo){

        return  applicationRecords.createTransferApplication(RFName,RLName,RCNIC,oFName,oLName,oCnic,HouseNo);
    }

    public Application propertyRentingApplication(String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic, int rent, int increment){
        return  applicationRecords.createRentApplication(RFName,RLName,RCNIC,oFName,oLName,oCnic, rent, increment);
    }

    public Application etagApplication(String oFName, String oLName, int oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others){
        return  applicationRecords.createEtagApplication(oFName,oLName,oCnic,vNo,vType,vYear,vMake,vEngineSize,others);
    }

    public int complaintRegistration(String HouseNo, String problem, String email){
        return complaintRecords.launchComplaint(HouseNo, email, problem).getID();
    }

    public Application getApplicationStatus(int appID){
            return applicationRecords.getApplication(appID);
    }

    public Complaint getComplaint(int ID){
        Complaint temp = complaintRecords.getComplaint(ID);

        return temp;
    }


    //2.0

    public void regHouse(String fname, String lname, String email, String cnic, int age, String password, String hNo){
        House temp = houseRecords.getHouse(hNo);

        residentRecords.addResident(fname,lname,email,cnic,age,password,temp);
        Owner obj= this.owners.addOwner(fname,lname,email,cnic,age,password,temp);
        houseRecords.alotHouse(obj,hNo);
    }


    public ArrayList<EtagApplication> getEtagApps() {

        return this.applicationRecords.getEtagApps();
    }

    public boolean checkOwner(String hNo,String owner){
        return this.residentRecords.checkOwner(hNo,owner);
    }

    public void updateApplicationStatus(String status, String applicationId){
        this.applicationRecords.updateApplicationStatus(status,applicationId);
    }

    public HouseRecords getHouses() {
        return houseRecords;
    }

    public void addHouse(String block,String Desc,String type){
        houseRecords.addHouse(block,Desc,type);
    }

//    public Resident residentLogin(String cnic,String pass){
//        return this.residentRecords.Login(cnic,pass);
//    }

    //3.0

    public void updateComplainStatus(String status, String compId){
        this.complaintRecords.updateComplaintStatus(status,compId);
    }

    public ArrayList<OwnerTransferApplication> getTransferApplications() {
        return applicationRecords.getTransferApplications();
    }

    public ArrayList<RentingApplication> getRentingApplications(){
        return applicationRecords.getRentingApplications();
    }

    public residentRecords getResidentRecords() {
        return residentRecords;
    }

    public void addAnnoucement(String desc){
        this.announcement.addAnnoucement(desc);
    }

    public ArrayList<Announcement> getAnnoucements(){
        return this.announcement.getAnnouncements();
    }
}
