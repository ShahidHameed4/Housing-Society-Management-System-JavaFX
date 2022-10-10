package HSMS.Property;

import HSMS.Complaint.Complaint;
import HSMS.DBHandlers.HouseDBHandler;
import HSMS.Resident.Owner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HouseRecords {


    ArrayList<House> houseRecords = new ArrayList<House>();
    HouseDBHandler db = new HouseDBHandler();


    public ArrayList<House> getHouseRecords() {
        return houseRecords;
    }


    public int assignID() {
        int t = 0;
        boolean check = false;
        while (!check) {
            t = genID();
            if (!exists(t)) {
                // System.out.println("house "+t);
                return t;
            }
        }
        return t;
    }

    public int genID() {
        int min = 100;
        int max = 200;

        int tempID = (int) (Math.random() * (max - min + 1) + min);

        return tempID;
    }

    public boolean exists(int ID) {
        for (House a : houseRecords) {
            if (a.gethNo().equals(Integer.toString(ID)))
                return true;
        }
        return false;
    }

    public House getHouse(String ID){
        for(House a: houseRecords){
            if (a.gethNo().equals(ID))
                return a;
        }

        return null;
    }


    public void addHouse(String block,String Desc,String type){
        String temphNo = String.valueOf(assignID());

        House temp =  new House(temphNo, block,Desc,type);
        houseRecords.add(temp);
        db.saveHouse(temp);
    }


//    public House getHouse(String ID){
//        for(House a: houseRecords){
//            if (a.gethNo().equals(ID))
//                return a;
//        }
//
//        return null;
//    }


    public void alotHouse(Owner obj,String hNo){
        for(House a: houseRecords){
            if (a.gethNo().equals(hNo)){
                a.setrCNIC(Integer.parseInt(obj.getCnic()));
                a.setoCNIC(Integer.parseInt(obj.getCnic()));
                db.udpateDB(a);
            }
        }
    }

    public void updateHouses() throws SQLException {
        ResultSet rs = db.retrieveList();
        if(rs != null){
            while(rs.next()){
                House temp = new House();
                temp.sethNo(rs.getString(1));
                temp.setBlockN(rs.getString(2));
                temp.setDesc(rs.getString(3));
                temp.setType(rs.getString(4));
                temp.setrCNIC(rs.getInt(5));
                temp.setoCNIC(rs.getInt(6));
                houseRecords.add(temp);
            }
        }
    }




}
