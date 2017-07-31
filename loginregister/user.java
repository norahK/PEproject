package com.example.lamaalesmail.loginregister;

/**
 * Created by lamaalesmail on 7/24/2017 AD.
 */

public class user {
    String fullName , email,password;

    public user (String name ,  String e,String pass){
        fullName = name;
        email=e ;
        password = pass;
    }
    public user(String name , String pass) {
        fullName = name;
        password = pass;

    }

}
