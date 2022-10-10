package HSMS.ApplicationTypes;

public class EtagApplication extends Application{

    String OFName;
    String OLName;
    int oCnic;

    String vNo;
    String vType;
    String vMake;
    String vYear;
    int vEngineSize;
    boolean others;

    public String getOFName() {
        return OFName;
    }

    public String getOLName() {
        return OLName;
    }

    public int getoCnic() {
        return oCnic;
    }

    public String getvNo() {
        return vNo;
    }

    public String getvType() {
        return vType;
    }

    public String getvMake() {
        return vMake;
    }

    public String getvYear() {
        return vYear;
    }

    public int getvEngineSize() {
        return vEngineSize;
    }

    public String isOthers() {
        if(others)
            return "1";
        else
            return "0";
    }

    //    public Application createEtagApplication(Applicant applicant, String oFName, String oLName, int oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others){
//        EtagApplication temp = new EtagApplication();
//        temp.applicant = applicant;
//        temp.OFName = oFName;
//        temp.OLName = oLName;
//        temp.oCnic = oCnic;
//        temp.others = others;
//        temp.vNo = vNo;
//        temp.vType = vType;
//        temp.vMake = vMake;
//        temp.vYear = vYear;
//        temp.vEngineSize = vEngineSize;
//        temp.type = 4;
//        //super.ApplicationRecords.add(temp);
//        temp.applicationStatus = "NE";
//        return temp;
//    }


}
