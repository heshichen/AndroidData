package com.example.admin.firstapp.entity;

import java.io.Serializable;

/**
 * Created by admin on 2018/8/17.
 */

public class Person implements Serializable {
    private String name;
    private String number;
    private boolean checkStatus;
    private int icon;

    public Person(String name, String number, int icon) {
        super();
        this.name = name;
        this.number = number;
        this.icon = icon;
        this.checkStatus = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }
}
