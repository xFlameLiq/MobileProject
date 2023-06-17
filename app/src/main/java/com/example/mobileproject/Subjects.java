package com.example.mobileproject;

import android.os.Parcelable;

import java.io.Serializable;

public class Subjects implements Serializable {

    private String nameSub;
    private String nameTea;

    public Subjects() {
    }

    public Subjects(String nameSub, String nameTea) {
        this.nameSub = nameSub;
        this.nameTea = nameTea;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public String getNameTea() {
        return nameTea;
    }

    public void setNameTea(String nameTea) {
        this.nameTea = nameTea;
    }
}
