package HSMS.Complaint;

public class Complaint {
    int ID;
    String houseNo;
    String emailAddress;
    String problem;
    String complaintStatus; // A = Approved ,  R = Rejected , NE =  NotEvaluated

    public String getComplaintStatus() {
        if(complaintStatus.equals("NE"))
            return "PENDING";
        else
            return "SOLVED";
    }

    public String getStatus(){
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
