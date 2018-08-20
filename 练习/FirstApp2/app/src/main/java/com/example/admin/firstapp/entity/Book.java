package com.example.admin.firstapp.entity;

/**
 * Created by admin on 2018/8/20.
 */

public class Book {
    private String txt_bname;
    private String txt_bauthor;

    public Book(String txt_bname, String txt_bauthor) {
        this.txt_bname = txt_bname;
        this.txt_bauthor = txt_bauthor;
    }

    public String getTxt_bname() {
        return txt_bname;
    }

    public void setTxt_bname(String txt_bname) {
        this.txt_bname = txt_bname;
    }

    public String getTxt_bauthor() {
        return txt_bauthor;
    }

    public void setTxt_bauthor(String txt_bauthor) {
        this.txt_bauthor = txt_bauthor;
    }
}
