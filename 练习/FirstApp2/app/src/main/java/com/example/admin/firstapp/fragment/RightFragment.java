package com.example.admin.firstapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.firstapp.R;

/**
 * Created by admin on 2018/11/21.
 */

public class RightFragment extends Fragment implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    private FragmentManager fManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_right, container, false);
        view.findViewById(R.id.btn_one).setOnClickListener(this);
        view.findViewById(R.id.btn_two).setOnClickListener(this);
        view.findViewById(R.id.btn_three).setOnClickListener(this);
        fManager = getActivity().getSupportFragmentManager();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                ContentFragmentTwo cFragment1 = ContentFragmentTwo.newInstance("1.点击了右侧菜单项一",R.color.blue);
                fManager.beginTransaction().replace(R.id.fly_content2,cFragment1).commit();
                drawer_layout.closeDrawer(Gravity.END);
                break;
            case R.id.btn_two:
                ContentFragmentTwo cFragment2 = ContentFragmentTwo.newInstance("2.点击了右侧菜单项二",R.color.red);
                fManager.beginTransaction().replace(R.id.fly_content2,cFragment2).commit();
                drawer_layout.closeDrawer(Gravity.END);
                break;
            case R.id.btn_three:
                ContentFragmentTwo cFragment3 = ContentFragmentTwo.newInstance("3.点击了右侧菜单项三",R.color.yellow);
                fManager.beginTransaction().replace(R.id.fly_content2,cFragment3).commit();
                drawer_layout.closeDrawer(Gravity.END);
                break;
        }
    }

    //暴露给Activity，用于传入DrawerLayout，因为点击后想关掉DrawerLayout
    public void setDrawerLayout(DrawerLayout drawer_layout) {
        this.drawer_layout = drawer_layout;
    }
}
