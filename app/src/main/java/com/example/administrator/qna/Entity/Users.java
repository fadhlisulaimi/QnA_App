package com.example.administrator.qna.Entity;

/**
 * Created by Administrator on 5/21/2015.
 */
public class Users {

    int id;
    String username;

    public Users(){

    }

    public Users(int id, String username){
        this.id = id;
        this.username = username;

    }

    public Users(String username){
        this.username = username;

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
}
