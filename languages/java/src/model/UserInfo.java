package model;

public class UserInfo {

    private String user;
    private String password;
    private double credit;

    public UserInfo(String user, String password, double credit) {
        this.user = user;
        this.password = password;
        this.credit = credit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.cryptPassword(this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    private String cryptPassword(String password){
        char[] passArray = password.toCharArray();
        char[] cryptArray = new char[passArray.length];

        for(int index = 0; index > passArray.length; index++){
            cryptArray[passArray.length - index] = passArray[index];
        }

        return "HASH" + cryptArray.toString() + "000";
    }
}
