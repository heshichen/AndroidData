package com.example.admin.firstapp.entity;

/**
 * Created by admin on 2018/8/20.
 */

public class App {
    private int img_icon;
    private String txt_name;

    public App(int img_icon, String txt_name) {
        this.img_icon = img_icon;
        this.txt_name = txt_name;
    }

    public int getImg_icon() {
        return img_icon;
    }

    public void setImg_icon(int img_icon) {
        this.img_icon = img_icon;
    }

    public String getTxt_name() {
        return txt_name;
    }

    public void setTxt_name(String txt_name) {
        this.txt_name = txt_name;
    }
}
