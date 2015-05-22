package com.example.administrator.qna.Database;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Fadhli on 05/21/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {



    //Tables
    public static final String TABLE_USERS ="Users";
    public static final String TABLE_QUESTIONS ="Questions";
    public static final String TABLE_ANSWERS ="Answers";


    public static final String ID ="ID";
    public static final String USERNAME ="USERNAME";
    public static final String QUESTION ="QUESTION";
    public static final String QUESTION_ID ="QUESTION_ID";
    public static final String ANSWER ="ANSWER";
    public static final String ANSWERED ="ANSWERED";
    public static final String ANSWERED_BY ="ANSWERED_BY";


    private static final String DATABASE_NAME = "qa.db";
    private static final int DATABASE_VERSION = 1;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ USERNAME + " TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_QUESTIONS + "("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ USERNAME + " TEXT, "+ QUESTION + " TEXT, "+ ANSWERED + " INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ANSWERS + "("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ QUESTION_ID + " INTEGER, "+ ANSWER + " TEXT, "+ ANSWERED_BY + " TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWERS);
    }


}

