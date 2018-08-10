package com.example.admin.firstapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
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
        if (frame != null)
        {
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
        else
        {
            frame = (FrameLayout) findViewById(R.id.myframe);
            Log.d("frame", "move: 重新创建对象");
        }
    }

    private TextView txtZQD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FrameLayout frame = (FrameLayout)findViewById(R.id.myframe);
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

//        frame = (FrameLayout) findViewById(R.id.myframe);
//        //定义一个定时器对象，定时发送消息给handler
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(0x123);
//            }
//        }, 0, 170);

//        txtZQD = (TextView) findViewById(R.id.txtZQD);
//        Drawable[] drawable = txtZQD.getCompoundDrawables();
//        // 数组下表0~3,依次是:左上右下
//        drawable[1].setBounds(0, 0, 100, 100);
//        txtZQD.setCompoundDrawables(drawable[0], drawable[1], drawable[2],
//                drawable[3]);

        //TextView 显示HTML
//        TextView t1 = (TextView)findViewById(R.id.txtSix);
//        String s1 = "<font color='blue'><b>百度一下，你就知道~：</b></font><br>";
//        s1 += "<a href = 'http://www.baidu.com'>百度</a>";
//        t1.setText(Html.fromHtml(s1));
//        t1.setMovementMethod(LinkMovementMethod.getInstance());

        //TextView 显示HTML Image
//        final TextView t1 = (TextView)findViewById(R.id.txtSix);
//        String s1 = "图片：<img src = 'button_red'/><br>";
//        t1.setText(Html.fromHtml(s1, new Html.ImageGetter() {
//            @Override
//            public Drawable getDrawable(String source) {
//                Drawable draw = null;
//                try {
//                    Field field = R.drawable.class.getField(source);
//                    int resourceId = Integer.parseInt(field.get(null).toString());
//                    draw = getResources().getDrawable(resourceId);
//                    draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return draw;
//            }
//        }, null));
//        richextTest();

        //Button
//        final Button btnOne = (Button) findViewById(R.id.btnOne);
//        final Button btnTwo = (Button) findViewById(R.id.btnTwo);
//        btnTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (btnTwo.getText().toString().equals("按钮不可用"))
//                {
//                    btnOne.setEnabled(false);
//                    btnTwo.setText("按钮可用");
//                }
//                else
//                {
//                    btnOne.setEnabled(true);
//                    btnTwo.setText("按钮不可用");
//                }
//            }
//        });

        //单选按钮 radio button
        radioTest();

        //多选按钮
        checkBoxTest();
    }

    private CheckBox cb_one;
    private CheckBox cb_two;
    private CheckBox cb_three;
    private Button btn_send;

    void checkBoxTest() {
        cb_one = (CheckBox) findViewById(R.id.cb_one);
        cb_two = (CheckBox) findViewById(R.id.cb_two);
        cb_three = (CheckBox) findViewById(R.id.cb_three);
        btn_send = (Button) findViewById(R.id.btnPost2);

        cb_one.setOnCheckedChangeListener(this);
        cb_two.setOnCheckedChangeListener(this);
        cb_three.setOnCheckedChangeListener(this);
        btn_send.setOnClickListener(this);
    }

    void radioTest() {
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        //第一种获取单选按钮值的方法
        //为radioGroup设置一个监听器:setOnCheckedChanged()
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radBtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radBtn.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }


//    void richextTest () {
//        TextView t1 = (TextView) findViewById(R.id.txtSeven);
//        TextView t2 = (TextView) findViewById(R.id.txtEight);
//
//        SpannableString span = new SpannableString("红色打电话斜体删除线绿色下划线图片:.");
//        //1.设置背景色,setSpan时需要指定的flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括)
//        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //2.用超链接标记文本
//        span.setSpan(new URLSpan("tel:4155551212"), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //3.用样式标记文本（斜体）
//        span.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 5,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //4.用删除线标记文本
//        span.setSpan(new StrikethroughSpan(), 7, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //5.用下划线标记文本
//        span.setSpan(new UnderlineSpan(), 10,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //6.用颜色标记
//        span.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 13,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //7.获取Drawable资源
//        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
//        d.setBounds(0,0,d.getIntrinsicWidth(), d.getIntrinsicHeight());
//        //8.创建ImageSpan,然后用ImageSpan来替换文本
//        ImageSpan imgSpan = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
//        span.setSpan(imgSpan, 18,19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        t1.setText(span);
//    }

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
