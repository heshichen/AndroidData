package com.example.admin.firstapp.entity;

/**
 * Created by admin on 2018/8/21.
 */

public class Icon {
    private int iId;
    private String iName;

    public Icon() {}

    public Icon(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
