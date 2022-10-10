package HSMS.Resident;

public class Owner extends Resident {

    public Owner(String firstName, String lastName, int age, String cNIC, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cnic = cNIC;
        this.emailAddress = emailAddress;
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

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getcNIC() {
        return cnic;
    }

    public void setcNIC(String cNIC) {
        this.cnic = cNIC;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getPassword() {
        return password;
    }
//
//    public boolean loginVerification(String cNIC, String password){
//        if(this.password.equals(password)&&this.cnic.equals(cNIC)||this.emailAddress.equals(cNIC)){
//            return true;
//        }
//        return false;
//    }

}
