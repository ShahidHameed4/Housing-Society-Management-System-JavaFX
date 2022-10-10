package HSMS.ApplicationTypes;

public class RentingApplication extends Application{
    String OFName;
    String OLName;
    int oCnic;
    String RFName;
    String RLName;
    int RCnic;
    int rent;
    float increment;

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

    public int getRent() {
        return rent;
    }

    public float getIncrement() {
        return increment;
    }

    //    public Application createRentApplication(Applicant applicant, String RFName, String RLName, int RCnic, String oFName, String oLName, int oCnic, int rent, int increment){
//        RentingApplication temp = new RentingApplication();
//        temp.applicant = applicant;
//        temp.OFName = oFName;
//        temp.OLName = oLName;
//        temp.oCnic = oCnic;
//        temp.RCnic = RCnic;
//        temp.RFName = RFName;
//        temp.RLName = RLName;
//        temp. rent = rent;
//        temp. increment = increment;
//
//        temp.type = 3;
//        temp.applicationStatus = "NE";
//        //super.ApplicationRecords.add(temp);
//
//        return temp;
//    }

}
