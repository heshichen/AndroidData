package com.example.admin.firstapp.entity;

/**
 * Created by admin on 2018/8/21.
 */

public class Item {
    private int img_icon;
    private String tv_name;

    public Item(int img_icon, String tv_name) {
        this.img_icon = img_icon;
        this.tv_name = tv_name;
    }

    public int getImg_icon() {
        return img_icon;
    }

    public void setImg_icon(int img_icon) {
        this.img_icon = img_icon;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }
}
