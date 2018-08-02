package com.example.admin.firstapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    //初始化变量，帧布局
    FrameLayout frame = null;
    //自定义一个用于定时更新UI界面的handler类对象
    Handler handler = new Handler()
    {
        int i = 0;
        @Override
        public void handleMessage(Message msg) {
            //判断消息是否为本应用发出
            if (msg.what == 0x123)
            {
                i++;
                move(i % 8);
            }
            super.handleMessage(msg);
        }
    };

    void move(int i)
    {
        Drawable a = getResources().getDrawable(R.drawable.s_1);
        Drawable b = getResources().getDrawable(R.drawable.s_2);
        Drawable c = getResources().getDrawable(R.drawable.s_3);
        Drawable d = getResources().getDrawable(R.drawable.s_4);
        Drawable e = getResources().getDrawable(R.drawable.s_5);
        Drawable f = getResources().getDrawable(R.drawable.s_6);
        Drawable g = getResources().getDrawable(R.drawable.s_7);
        Drawable h = getResources().getDrawable(R.drawable.s_8);
        //通过setForeground来设置前景图片
        switch (i)
        {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FrameLayout frame = (FrameLayout)findViewById(R.id.mylayout);
//        final MeziView mezi = new MeziView(MainActivity.this);
//        为我们的萌妹子添加触摸事件监听器
//        mezi.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                //设置妹子显示的位置
//                mezi.bitmapX = event.getX() - 150;
//                mezi.bitmapY = event.getY() - 150;
//                //调用重绘方法
//                mezi.invalidate();
//                return true;
//            }
//        });
//        frame.addView(mezi);

        frame = (FrameLayout) findViewById(R.id.mylayout);
        //定义一个定时器对象，定时发送消息给handler
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 170);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
