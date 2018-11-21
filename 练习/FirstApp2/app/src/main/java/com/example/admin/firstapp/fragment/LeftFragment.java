package com.example.admin.firstapp.fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.firstapp.R;
import com.example.admin.firstapp.activity.OtherActivity;

/**
 * Created by admin on 2018/11/21.
 */

public class LeftFragment extends Fragment {

    private DrawerLayout drawer_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_left, container, false);
        ImageView img_bg = (ImageView) view.findViewById(R.id.img_bg);
        img_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(),OtherActivity.class));
                drawer_layout.closeDrawer(Gravity.START);
            }
        });
        return view;
    }

    //暴露给Activity，用于传入DrawerLayout，因为点击后想关掉DrawerLayout
    public void setDrawerLayout(DrawerLayout drawer_layout) {
        this.drawer_layout = drawer_layout;
    }
}
