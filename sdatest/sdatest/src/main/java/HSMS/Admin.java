package HSMS;

public class Admin {
    String username="1";
    String password="2";

    public boolean login(String username, String password){
        return username.equals("1") && password.equals("2");
    }

}
