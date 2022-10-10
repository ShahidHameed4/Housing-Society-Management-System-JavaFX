package HSMS.ApplicationTypes;

import HSMS.Applicant.Applicant;

public class RegistrationApplication extends Application{

    String houseNo;
    String size;
    String OFName;
    String OLName;
    int age;
    int oCnic;

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOFName() {
        return OFName;
    }

    public void setOFName(String OFName) {
        this.OFName = OFName;
    }

    public String getOLName() {
        return OLName;
    }

    public void setOLName(String OLName) {
        this.OLName = OLName;
    }

    public int getoAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getoCnic() {
        return oCnic;
    }

    public void setoCnic(int oCnic) {
        this.oCnic = oCnic;
    }

    //    public Application createRegApplication(Applicant applicant, String houseNo, String size, String oFName, String oLName, int oAge, int oCnic, String oEmail){
//        RegistrationApplication temp = new RegistrationApplication();
//        temp.applicant = applicant;
//        temp.houseNo = houseNo;
//        temp.size = size;
//        temp.OFName = oFName;
//        temp.OLName = oLName;
//        temp.age = oAge;
//        temp.oCnic = oCnic;
//        temp.oEmailAddress = oEmail;
//        temp.type = 1;
//        //super.ApplicationRecords.add(temp);
//        temp.applicationStatus = "NE";
//
//        return temp;
//    }

    RegistrationApplication(){
        applicant = new Applicant();
    }

    @Override
    public String toString() {
        return "RegistrationApplication{" +
                "houseNo='" + houseNo + '\'' +
                ", size='" + size + '\'' +
                ", OFName='" + OFName + '\'' +
                ", OLName='" + OLName + '\'' +
                ", age=" + age +
                ", oCnice=" + oCnic +
                '}';
    }
}
