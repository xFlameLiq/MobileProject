package com.example.mobileproject;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private int id;
    private String pass;

    public User() {
    }

    public User(String email, String pass, int id) {
        this.email = email;
        this.pass = pass;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
