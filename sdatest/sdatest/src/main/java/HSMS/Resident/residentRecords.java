package HSMS.Resident;

import HSMS.ApplicationTypes.EtagApplication;
import HSMS.DBHandlers.OwnerDBHandler;
import HSMS.DBHandlers.ResidentDbHandler;
import HSMS.Property.House;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class residentRecords {

    private HashMap<String,Resident> residentRecords =new HashMap<>();
    ResidentDbHandler db = new ResidentDbHandler();

    public HashMap<String, Resident> getResidentRecords() {
        return residentRecords;
    }

    public Resident addResident(String fname, String lname, String email, String cnic, int age, String password, House house){
        Resident temp = new Resident(fname,lname,age, cnic,email, password,house);

        if(exist(cnic)){
            residentRecords.get(cnic).alotHouse(house);
        }
        else{
            residentRecords.put(cnic,temp);
        }
        db.saveResident(temp);
        return temp;
    }

    Resident getResident(String cnic) {
        return residentRecords.get(cnic);
    }

    public boolean checkOwner(String hNo,String ownerId){
        if(this.residentRecords.get(ownerId)!=null){
            Resident temp=this.residentRecords.get(ownerId);
            return temp.hasHouse(hNo);
        }
        return false;
    }
    public boolean exist(String ownerId){
        if(this.residentRecords.get(ownerId)!=null){

            return true;
        }
        return false;
    }

    public Resident login(String cNIC, String password){
        for (Map.Entry<String, Resident> set : residentRecords.entrySet()) {
            Resident temp=set.getValue();
            if (temp.loginVerification(cNIC,password))
                return temp;
        }
        return null;
    }

    public void updateResidents() throws SQLException {
        ResultSet rs = db.retrieveList();

        while(rs.next()){
            Resident temp = new Resident();
            temp.cnic = rs.getString(1);
            temp.firstName = rs.getString(2);
            temp.lastName = rs.getString(3);
            temp.age = rs.getInt(4);
            temp.emailAddress = rs.getString(5);
            temp.password =  rs.getString(6);
            residentRecords.put(temp.cnic, temp);

        }
    }



}
