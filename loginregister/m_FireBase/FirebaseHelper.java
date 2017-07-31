package com.example.lamaalesmail.loginregister.m_FireBase;

import com.example.lamaalesmail.loginregister.m_Model.Users;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by lamaalesmail on 7/26/2017 AD.
 */

public class FirebaseHelper {
    DatabaseReference db ;
    Boolean saved = null ;

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public Boolean seve (Users user ){
        if (user == null){
            saved = false ;
        }else {

            try {

                db.child("Users").push().setValue(user);
                saved= true ;

            }catch (DatabaseException e){
                e.printStackTrace();
                saved =  false ;
            }
        }
        return saved ;
    }

}
