package com.example.administrator.qna.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.qna.Database.DatabaseHelper;
import com.example.administrator.qna.Entity.Question;
import com.example.administrator.qna.Entity.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 5/21/2015.
 */
public class QuestionManager {



    private SQLiteDatabase database;
    private DatabaseHelper databasehelper;
    private Context mContext;

    public QuestionManager(Context context){
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

    public void addQuestion(String question, String username, int answered){

        open();

        ContentValues values = new ContentValues();
        values.put("QUESTION",question);
        values.put("USERNAME",username);
        values.put("ANSWERED",answered);


        database.insert("Questions", null,values);
        close();

    }



    public Cursor fetchAllQuestions() {

        read();

        Cursor c = database.rawQuery("SELECT ID _id,USERNAME,QUESTION,ANSWERED FROM Questions ORDER BY ID DESC", null);

        return c;
    }
}
