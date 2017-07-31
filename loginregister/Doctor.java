package com.example.lamaalesmail.loginregister;

/**
 * Created by lamaalesmail on 7/25/2017 AD.
 */

public class Doctor {
    String Fname ,Lname , username , email , password ;

    public Doctor(){

    }

    public Doctor(String fname, String lname, String username, String email, String password) {

        Fname = fname;
        Lname = lname;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
