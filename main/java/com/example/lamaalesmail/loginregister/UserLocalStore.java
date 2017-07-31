package com.example.lamaalesmail.loginregister;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lamaalesmail on 7/24/2017 AD.
 */

public class UserLocalStore {
    public static final String SP_NAME = "userDatails";
    SharedPreferences userLacalDatabase ;

    public UserLocalStore(Context context){
        userLacalDatabase = context.getSharedPreferences(SP_NAME,0);

    }
    public void storeUserData( user u ){
        SharedPreferences.Editor spEditor = userLacalDatabase.edit ();
        spEditor.putString ("Full name ",u.fullName);
        spEditor.putString ("Email ",u.email);
        spEditor.putString ("Password ",u.password);
        spEditor.commit();


    }
    public user getLoggedInUser (){
        String name = userLacalDatabase.getString ("full Name" ,"");
        String email = userLacalDatabase.getString ("Email ","");
        String password = userLacalDatabase.getString ("Password","");

        user storedUser = new user (name , email,password);
        return storedUser;
    }
    public void  setUserLoggedIn (boolean loggedIn ){
        SharedPreferences.Editor spEditor = userLacalDatabase.edit();
        spEditor.putBoolean("LoggedIn",loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if(userLacalDatabase.getBoolean("loggedIn",false)==true){
            return true ;
        }
        else
            return false ;

    }

    public void clearUserData (){
        SharedPreferences.Editor spEditor = userLacalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
