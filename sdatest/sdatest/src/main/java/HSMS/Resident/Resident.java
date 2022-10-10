package HSMS.Resident;

import HSMS.ApplicationTypes.Application;
import HSMS.Property.House;

import java.util.ArrayList;
import java.util.HashMap;

public class Resident {
    protected int age;
    //private int ID;
    String firstName;
    String lastName;
    protected String cnic;
    protected String emailAddress;
    protected String password;
    private HashMap<String, House> houses=new HashMap<>();
    private ArrayList<Application> apps=new ArrayList<Application>();


    public Resident(){

    }

//    public int getID() {
//        return ID;
//    }


    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
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

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Resident( String firstName, String lastName, int age, String cnic, String emailAddress,String password,House house) {
        //this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnic = cnic;
        this.emailAddress = emailAddress;
        this.password=password;
      //  this.houses.put(house.gethNo(),house);  null for now, update later
    }

    public HashMap<String, House> getHouses() {
        return houses;
    }
    public House getHouse(String iD) {
        return houses.get(iD);
    }




    public boolean loginVerification(String cNIC, String password){
        if(this.password.equals(password)&&this.cnic.equals(cNIC)){
            return true;
        }
        return false;
    }

    public void addApplications(Application application){
        this.apps.add(application);
    }

    public boolean hasHouse(String iD){
        if(this.houses.get(iD)!=null)
            return true;
        return false;
    }


    public void alotHouse(House obj){
        this.houses.put(obj.gethNo(),obj);
    }



}
