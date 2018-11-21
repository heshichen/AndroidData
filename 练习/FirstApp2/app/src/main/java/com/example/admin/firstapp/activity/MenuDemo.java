package com.example.admin.firstapp.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.firstapp.R;

/**
 * Created by admin on 2018/11/15.
 */

public class MenuDemo extends AppCompatActivity {

    //1.定义不同颜色的菜单项的标识:
    final private int RED = 110;
    final private int GREEN = 111;
    final private int BLUE = 112;
    final private int YELLOW = 113;
    final private int GRAY = 114;
    final private int CYAN = 115;
    final private int BLACK = 116;

    private TextView tv_test;
    private TextView tv_content;
    private Button btn_one;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        mContext = MenuDemo.this;
        tv_test = (TextView) findViewById(R.id.text_one);
        tv_content = (TextView) findViewById(R.id.text_two);
        registerForContextMenu(tv_content);

        btn_one = (Button) findViewById(R.id.btn_one);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(mContext,btn_one);
                popup.getMenuInflater().inflate(R.menu.menu_pop, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.lpig:
                                Toast.makeText(mContext,"你点了小猪~",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.bpig:
                                Toast.makeText(mContext,"你点了大猪~",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,RED,4,"红色");
        menu.add(1,GREEN,2,"绿色");
        menu.add(1,BLUE,3,"蓝色");
        menu.add(1,YELLOW,1,"黄色");
        menu.add(1,GRAY,5,"灰色");
        menu.add(1,CYAN,6,"蓝绿色");
        menu.add(1,BLACK,7,"黑色");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case RED:
                tv_test.setTextColor(Color.RED);
                break;
            case GREEN:
                tv_test.setTextColor(Color.GREEN);
                break;
            case BLUE:
                tv_test.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                tv_test.setTextColor(Color.YELLOW);
                break;
            case GRAY:
                tv_test.setTextColor(Color.GRAY);
                break;
            case CYAN:
                tv_test.setTextColor(Color.CYAN);
                break;
            case BLACK:
                tv_test.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_sub, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //上下文菜单被点击是触发该方法
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue:
                tv_content.setTextColor(Color.BLUE);
                break;
            case R.id.green:
                tv_content.setTextColor(Color.GREEN);
                break;
            case R.id.red:
                tv_content.setTextColor(Color.RED);
                break;
            case R.id.one:
                Toast.makeText(mContext,"你点击了子菜单一",Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                Toast.makeText(mContext,"你点击了子菜单二",Toast.LENGTH_SHORT).show();
                break;
            case R.id.three:
                Toast.makeText(mContext,"你点击了子菜单三",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
