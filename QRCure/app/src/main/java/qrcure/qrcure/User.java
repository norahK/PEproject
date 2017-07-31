package qrcure.qrcure;

import java.util.Date;

/**
 * when user regester new user created and save info from database until log out
 */

public class User {
    private kind_of_users userID;
    private String Fname,Lname;
    private String Username;
    private String Email;
    private String password ;

    public User() {

    }

    public User(String name, String email) {
        this.Fname=name;
        this.Email=email;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getPassword() {
        return password;
    }

    public kind_of_users getUserID() {
        return userID;
    }

    public void setUserID(kind_of_users userID) {
        this.userID = userID;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public Object getPhoto() {
        return photo;
    }

    private Object photo;
    public Date LastVisit;


}
