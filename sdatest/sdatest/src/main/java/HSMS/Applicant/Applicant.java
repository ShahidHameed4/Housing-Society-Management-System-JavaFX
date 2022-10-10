package HSMS.Applicant;

import HSMS.ApplicationTypes.Application;
import HSMS.DBHandlers.ApplicantDBHandler;

import java.util.HashMap;

public class Applicant {

    private int ID;
    private String firstName;
    private String lastName;
    private int cnic;
    private String emailAddress;


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCnic() {
        return cnic;
    }

    public void setCnic(int cnic) {
        this.cnic = cnic;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Applicant(int ID, String firstName, String lastName, int cnic, String emailAddress) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnic = cnic;
        this.emailAddress = emailAddress;
    }

    public Applicant(){

    }


}
