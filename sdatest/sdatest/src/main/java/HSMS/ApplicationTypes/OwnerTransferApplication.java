package HSMS.ApplicationTypes;

public class OwnerTransferApplication extends Application {
    String OFName;
    String OLName;
    int oCnic;
    String RFName;
    String RLName;
    int RCnic;
    String HouseNo;

    public String getHouseNo() {
        return HouseNo;
    }

    public String getOFName() {
        return OFName;
    }

    public String getOLName() {
        return OLName;
    }

    public int getoCnic() {
        return oCnic;
    }

    public String getRFName() {
        return RFName;
    }

    public String getRLName() {
        return RLName;
    }

    public int getRCnic() {
        return RCnic;
    }

    //    public Application createTransferApplication(Applicant applicant,  String RFName, String RLName,  int RCnic, String oFName, String oLName,  int oCnic){
//        OwnerTransferApplication temp = new OwnerTransferApplication();
//        temp.applicant = applicant;
//        temp.OFName = oFName;
//        temp.OLName = oLName;
//        temp.oCnic = oCnic;
//        temp.RCnic = RCnic;
//        temp.RFName = RFName;
//        temp.RLName = RLName;
//
//        temp.type = 2;
//        //super.ApplicationRecords.add(temp);
//        temp.applicationStatus = "NE";
//        return temp;
//    }


}
