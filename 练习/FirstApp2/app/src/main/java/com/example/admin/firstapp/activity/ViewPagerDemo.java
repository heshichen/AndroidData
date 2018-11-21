package com.example.admin.firstapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.firstapp.R;
import com.example.admin.firstapp.adapter.MyPagerAdapter;

import java.util.ArrayList;

/**
 * Created by admin on 2018/11/16.
 */

public class ViewPagerDemo extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<View> aList;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_layout);
        viewPager = (ViewPager) findViewById(R.id.vpager_one);

        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_three,null,false));
        myPagerAdapter = new MyPagerAdapter(aList);
        viewPager.setAdapter(myPagerAdapter);
    }
}
