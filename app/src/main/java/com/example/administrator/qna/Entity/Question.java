package com.example.administrator.qna.Entity;

/**
 * Created by Administrator on 5/21/2015.
 */
public class Question {

    int id;
    String info;
    String username;

    public Question(){
        super();
    }

    public Question(int id, String username,String info){
        this.id = id;
        this.username = username;
        this.info = info;

    }

    public Question(String username,String info){
        this.username = username;
        this.info = info;

    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setInfo(String info) {
        this.info=info;
    }

    public String getInfo() {
        return this.info;
    }


}
