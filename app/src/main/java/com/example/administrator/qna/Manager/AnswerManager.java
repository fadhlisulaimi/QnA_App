package com.example.administrator.qna.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.qna.Database.DatabaseHelper;

/**
 * Created by Administrator on 5/22/2015.
 */
public class AnswerManager {

    private SQLiteDatabase database;
    private DatabaseHelper databasehelper;
    private Context mContext;

    public AnswerManager(Context context){
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

    public void addAnswer(int questionID, String answer, int answered, String answeredby){

        open();

        ContentValues values = new ContentValues();
        values.put("QUESTION_ID",questionID);
        values.put("ANSWER", answer);
        values.put("ANSWERED_BY", answeredby);
        database.insert("Answers", null, values);

        ContentValues values2 = new ContentValues();
        values2.put("ANSWERED",answered);

        database.update("Questions", values2, "ID = '"+ questionID +"'",null);

        close();

    }

    public Cursor fetchAnswersById(int questionID){

        read();

        Cursor c = database.rawQuery("SELECT ID _id,ANSWER,ANSWERED_BY FROM Answers WHERE QUESTION_ID = '"+ questionID +"' ORDER BY ID DESC", null);

        return c;

    }
}
