package HSMS.Resident;

import HSMS.DBHandlers.OwnerDBHandler;
import HSMS.Property.House;

import java.util.HashMap;
import java.util.Map;

public class OwnerRecords {


    private HashMap<String,Owner> ownerRecords=new HashMap<>();
    OwnerDBHandler db = new OwnerDBHandler();

    public Owner addOwner(String fname, String lname, String email, String cnic, int age, String password, House house){
        Owner temp = new Owner(fname,lname,age, cnic,email, password);
        if(this.exist(cnic)){
            this.ownerRecords.get(cnic).alotHouse(house);
        }
        else{
            ownerRecords.put(cnic,temp);
        }
        ownerRecords.put(cnic,temp);
        // db.saveOwner(temp);
        return temp;
    }


    public boolean checkOwner(String hNo,String ownerId){
        if(this.ownerRecords.get(ownerId)!=null){
            Resident temp=this.ownerRecords.get(ownerId);
            return temp.hasHouse(hNo);
        }
        return false;
    }
    public boolean exist(String ownerId){
        if(this.ownerRecords.get(ownerId)!=null){

            return true;
        }
        return false;
    }

    Owner getOwner(String cnic) {
        return ownerRecords.get(cnic);

    }
//    Owner Login(String cNIC,String password){
//
//        for (Map.Entry<String, Owner> set : ownerRecords.entrySet()) {
//            Owner objOwner=set.getValue();
//            if (objOwner.loginVerification(cNIC,password))
//                return objOwner;
//        }
//        return null;
//    }



}
