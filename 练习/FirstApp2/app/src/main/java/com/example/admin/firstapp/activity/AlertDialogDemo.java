package com.example.admin.firstapp.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.firstapp.R;

/**
 * Created by admin on 2018/11/14.
 */

public class AlertDialogDemo extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    private Context mContext;
    private boolean[] checkItems;

    private View view_custom;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog_test);
        mContext = AlertDialogDemo.this;
        bindView();
    }

    private void bindView() {
        button1 = (Button) findViewById(R.id.btn_show_dialog_1);
        button2 = (Button) findViewById(R.id.btn_show_dialog_2);
        button3 = (Button) findViewById(R.id.btn_show_dialog_3);
        button4 = (Button) findViewById(R.id.btn_show_dialog_4);
        button5 = (Button) findViewById(R.id.btn_show_dialog_5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_dialog_1:
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setIcon(R.mipmap.ic_icon_fish)
                        .setTitle("系统提示：")
                        .setMessage("这是一个最普通的AlertDialog,\n带有三个按钮，分别是取消，中立和确定")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "你点击了中立按钮", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alert.show();
                break;
            case R.id.btn_show_dialog_2:
                final String[] lesson = new String[]{"语文", "数学", "英语", "化学", "生物", "物理", "体育"};
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setIcon(R.mipmap.ic_icon_fish)
                        .setTitle("选择你喜欢的课程")
                        .setItems(lesson, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "你选择了" + lesson[which], Toast.LENGTH_SHORT).show();
                    }
                }).create();
                alert.show();
                break;
            case R.id.btn_show_dialog_3:
                final String[] fruits = new String[]{"苹果", "雪梨", "香蕉", "葡萄", "西瓜"};
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setIcon(R.mipmap.ic_icon_fish)
                        .setTitle("选择你喜欢的水果，只能选一个哦~")
                        .setSingleChoiceItems(fruits, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "你选择了" + fruits[which], Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alert.show();
                break;
            case R.id.btn_show_dialog_4:
                final String[] menu = new String[]{"水煮豆腐", "萝卜牛腩", "酱油鸡", "胡椒猪肚鸡"};
                //定义一个用来记录个列表项状态的boolean数组
                checkItems = new boolean[]{false, false, false, false};
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setIcon(R.mipmap.ic_icon_fish)
                        .setTitle("菜单:")
                        .setMultiChoiceItems(menu, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkItems[which] = isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String result = "";
                                for (int i = 0; i < checkItems.length; i++) {
                                    if (checkItems[i]) {
                                        result += menu[i] + " ";
                                    }
                                }
                                Toast.makeText(mContext, "客官你点了:" + result, Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alert.show();
                break;
            case R.id.btn_show_dialog_5:
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                //加载自定义的View
                final LayoutInflater inflater = AlertDialogDemo.this.getLayoutInflater();
                view_custom = inflater.inflate(R.layout.view_dialog_custom, null, false);
                builder.setView(view_custom);
                builder.setCancelable(false);
                alert = builder.create();
                alert.show();

                view_custom.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();
                    }
                });

                view_custom.findViewById(R.id.btn_blog).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "对话框已关闭~", Toast.LENGTH_SHORT).show();
                        Uri uri = Uri.parse("http://www.baidu.com/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        alert.dismiss();
                    }
                });

                view_custom.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();
                    }
                });

                break;
            default:
                    break;
        }

    }
}
