package qrcure.qrcure;

import java.util.Date;

/**
 * when user regester new user created and save info from database until log out
 */

public class User {
    private kind_of_users userID;
    private String Name;
    private String Username;
    private String Email;

    public User() {

    }

    public User(String name, String email) {
        this.Name=name;
        this.Email=email;
    }

    public kind_of_users getUserID() {
        return userID;
    }

    public String getName() {
        return Name;
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
