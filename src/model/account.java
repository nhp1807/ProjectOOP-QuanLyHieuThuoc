package model;

public class account {
    public static String username;
    public static String password;

    public account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
