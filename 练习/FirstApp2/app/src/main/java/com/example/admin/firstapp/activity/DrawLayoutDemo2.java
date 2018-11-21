package com.example.admin.firstapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.admin.firstapp.R;
import com.example.admin.firstapp.fragment.LeftFragment;
import com.example.admin.firstapp.fragment.RightFragment;

/**
 * Created by admin on 2018/11/21.
 */

public class DrawLayoutDemo2 extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    private FrameLayout fly_content;
    private View topbar;
    private Button btn_right;
    private RightFragment fg_right_menu;
    private LeftFragment fg_left_menu;
    private FragmentManager fManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawe_layout2);
        fManager = getSupportFragmentManager();
        fg_right_menu = (RightFragment) fManager.findFragmentById(R.id.fg_right_menu);
        fg_left_menu = (LeftFragment) fManager.findFragmentById(R.id.fg_left_menu);
        initViews();
    }

    private void initViews() {
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        fly_content = (FrameLayout) findViewById(R.id.fly_content2);
        topbar = findViewById(R.id.topbar);
        btn_right = (Button) topbar.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(this);

        //设置右面的侧滑菜单只能通过编程来打开
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);

        drawer_layout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                drawer_layout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        fg_right_menu.setDrawerLayout(drawer_layout);
        fg_left_menu.setDrawerLayout(drawer_layout);
    }

    @Override
    public void onClick(View v) {
        drawer_layout.openDrawer(Gravity.RIGHT);
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,Gravity.END); //解除锁定
    }
}
