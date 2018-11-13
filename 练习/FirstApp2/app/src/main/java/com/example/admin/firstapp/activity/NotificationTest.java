package com.example.admin.firstapp.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.firstapp.R;

/**
 * Created by admin on 2018/11/13.
 */

public class NotificationTest extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private NotificationManager mNManager;
    private Notification notifiy1;
    Bitmap LargeBitmap = null;
    private static final int NOTIFYYID_1 = 1;

    private Button btn_show_normal;
    private Button btn_close_normal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_test);
        mContext = NotificationTest.this;
        //创建大图标的Bitmap
        LargeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.iv_icon_1);
        mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        bindView();
    }

    private void bindView() {
        btn_show_normal = (Button) findViewById(R.id.btn_show_normal);
        btn_close_normal = (Button) findViewById(R.id.btn_close_normal);
        btn_show_normal.setOnClickListener(this);
        btn_close_normal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_normal:
                //定义一个PendingIntent点击Notification后启动一个Activity
                Intent it = new Intent(mContext, OtherActivity.class);
                PendingIntent pit = PendingIntent.getActivity(mContext, 0, it, 0);

                //设置图片，通知标题，发送时间，提示方法等属性
                Notification.Builder mBuilder = new Notification.Builder(this);
                mBuilder.setContentTitle("叶良辰")
                        .setContentText("我有一百种方法让你呆不下去~")
                        .setSubText("——记住我叫叶良辰")
                        .setTicker("收到叶良辰发送过来的信息~")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_tur_icon)
                        .setLargeIcon(LargeBitmap)
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
                        .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))
                        .setAutoCancel(true)
                        .setContentIntent(pit);
                notifiy1 = mBuilder.build();
                mNManager.notify(NOTIFYYID_1, notifiy1);
                break;
            case R.id.btn_close_normal:
                //除了可以根据ID来取消Notification外，还可以调用cancelAll();关闭该应用产生的所有通知
                mNManager.cancel(NOTIFYYID_1);
                break;
        }
    }
}
