package com.example.administrator.qna.Manager;

/**
 * Created by Administrator on 5/21/2015.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import com.example.administrator.qna.Database.DatabaseHelper;
import com.example.administrator.qna.Entity.Users;

public class UserManager {

    private SQLiteDatabase database;
    private DatabaseHelper databasehelper;
    private Context mContext;

    public UserManager(Context context){
        mContext = context;
        databasehelper = new DatabaseHelper(mContext);
    }

    public void open(){
        database = databasehelper.getWritableDatabase();
    }

    public void read(){
        database = databasehelper.getReadableDatabase();
    }

    public void close(){
        database.close();

    }

    public void addName(String name){

        open();

        ContentValues values = new ContentValues();
        values.put("USERNAME",name);


        database.insert("Users", null,values);
        close();

    }

    public Users getName(String username){

        read();

        Cursor c = null;
        c = database.rawQuery("SELECT * FROM Users WHERE USERNAME = '"+ username +"'", null);
        if (c.moveToFirst()) {


            Users user = new Users(c.getInt(0), c.getString(1));

            close();
            return user;

        }else{

            return null;

        }

    }


}
