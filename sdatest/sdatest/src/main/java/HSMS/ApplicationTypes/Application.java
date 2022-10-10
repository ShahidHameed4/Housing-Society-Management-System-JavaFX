package HSMS.ApplicationTypes;

import HSMS.Applicant.Applicant;

import java.util.Date;

public abstract class Application extends ApplicationRecords {

    Applicant applicant;
    int ID;
    int type; // 1 => Registration, 2 => Transfer, 3 => Renting,  4 => ETagApplication
    String applicationStatus; // A = Approved ,  R = Rejected , NE =  NotEvaluated
    Date applyingDate;

    public Date getDate() {
        return applyingDate;
    }

    public int getID() {
        return ID;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public String getApplicationStatus() {
        if(applicationStatus.equals("NE"))
            return "NOT EVALUATED";
        else if(applicationStatus.equals("RE"))
            return "REJECTED";
        else
            return "Approved";
    }

    public String getStatus(){
        return applicationStatus;
    }

    public int getType() {
        return type;
    }

    public String getApplicationType(){
        if(type == 1){
            return "Registration Application";
        }
        if(type == 2){
            return "Transfer Application";
        }
        if(type == 3){
            return "Renting Application";
        }
        if(type == 4){
            return "Etag Application";
        }

        return null;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    //    Property property;
//    Tenant tenant;
//    int type;

//    Application(Applicant applicant, Property property){
//        this.applicant = applicant;
//        this.property = property;
//    }
//
//    Application(Applicant applicant, Property property, Tenant tenant){
//        this.applicant = applicant;
//        this.property = property;
//        this.tenant = tenant;
//    }

//    void createRegApplication(Applicant a, Property p) {
//        Application tempApplication = new Application(a,p);
//
//        //save tempApplicaiton to SQL
//    }





}
