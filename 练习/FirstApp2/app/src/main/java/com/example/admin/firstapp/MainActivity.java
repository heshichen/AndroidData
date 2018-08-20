package com.example.admin.firstapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.firstapp.adapter.ContactListAdapter;
import com.example.admin.firstapp.adapter.MutiLayoutAdapter;
import com.example.admin.firstapp.adapter.MyAdapter;
import com.example.admin.firstapp.entity.Animal;
import com.example.admin.firstapp.entity.App;
import com.example.admin.firstapp.entity.Book;
import com.example.admin.firstapp.entity.Data;
import com.example.admin.firstapp.entity.Person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener,DatePicker.OnDateChangedListener,AdapterView.OnItemClickListener{


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
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = MainActivity.this;
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
//        radioTest();

        //多选按钮
//        checkBoxTest();

        //自定义菊花
//        imgPgbarTest();

        //拖动条
//        mContext = MainActivity.this;
//        bindViews();

        //星星
//        ratingBarTest();

        //scrollView
//        bindViews();

        //日期选择器
//        dateTest();

        //ArrayAdapter使用示例
//        adapterTest();

//        simpleAdapterTest();

//        simpleCursorAdapterTest();

//        baseAdapterTest();

//        listViewTest();

//        listViewDataUpdateTest();

//        reuseBaseAdapterTest();

        mutiLayoutAdapterTest();
    }

    //ListView Item多布局的实现
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private ListView list_content;
    private ArrayList<Object> mData3 = null;
    private MutiLayoutAdapter mutiAdapter = null;

    void mutiLayoutAdapterTest()
    {
        mData3 = new ArrayList<Object>();
        for (int i = 0; i < 20; i++) {
            switch ((int)(Math.random() * 2)) {
                case TYPE_BOOK:
                    mData3.add(new Book("《第一行代码》", "郭霖"));
                    break;
                case TYPE_APP:
                    mData3.add(new App(R.drawable.img1, "百度"));
                    break;
            }
        }

        list_content = (ListView) findViewById(R.id.list_test);
        mutiAdapter = new MutiLayoutAdapter(mContext, mData3);
        list_content.setAdapter(mutiAdapter);
    }

    //构建一个可复用的自定义BaseAdapter
//    private ListView list_book;
//    private ListView list_app;
//
//    private MyAdapter<App> myAdapter1 = null;
//    private MyAdapter<Book> myAdapter2 = null;
//    private List<App> mData1 = null;
//    private List<Book> mData2 = null;
//
//    void reuseBaseAdapterTest() {
//        list_book = (ListView) findViewById(R.id.list_book);
//        list_app = (ListView) findViewById(R.id.list_app);
//
//        //数据初始化
//        mData1 = new ArrayList<App>();
//        mData1.add(new App(R.drawable.img1, "百度"));
//        mData1.add(new App(R.drawable.img2, "豆瓣"));
//        mData1.add(new App(R.drawable.img3, "支付宝"));
//
//        mData2 = new ArrayList<Book>();
//        mData2.add(new Book("《第一行代码Android》", "郭霖"));
//        mData2.add(new Book("《Android群英传》","徐宜生"));
//        mData2.add(new Book("《Android开发艺术探索》","任玉刚"));
//
//        //Adapter 初始化
//        myAdapter1 = new MyAdapter<App>((ArrayList)mData1, R.layout.item_one) {
//            @Override
//            public void bindView(ViewHolder holder, App obj) {
//                holder.setImageResource(R.id.img_icon, obj.getImg_icon());
//                holder.setText(R.id.txt_aname, obj.getTxt_name());
//            }
//        };
//        myAdapter2 = new MyAdapter<Book>((ArrayList)mData2, R.layout.item_two) {
//            @Override
//            public void bindView(ViewHolder holder, Book obj) {
//                holder.setText(R.id.txt_bname, obj.getTxt_bname());
//                holder.setText(R.id.txt_bauthor, obj.getTxt_bauthor());
//            }
//        };
//
//        //ListView设置下Adapter：
//        list_app.setAdapter(myAdapter1);
//        list_book.setAdapter(myAdapter2);
//    }

    //ListView的数据更新问题
    private ListView list_one;
    private MyAdapter myAdapter = null;
    private List<Data> myData = null;
//    void listViewDataUpdateTest() {
//        list_one = (ListView) findViewById(R.id.list_test);
//        myData = new LinkedList<Data>();
//
//        myAdapter = new MyAdapter((LinkedList<Data>) myData, mContext);
//        list_one.setAdapter(myAdapter);
//
//        Button btn_add = (Button)findViewById(R.id.add_btn);
//        btn_add.setOnClickListener(this);
//
//        Button btn_add2 = (Button)findViewById(R.id.add_btn2);
//        btn_add2.setOnClickListener(this);
//
//        Button btn_remove = (Button)findViewById(R.id.remove_btn);
//        btn_remove.setOnClickListener(this);
//
//        Button btn_remove2 = (Button)findViewById(R.id.remove_btn2);
//        btn_remove2.setOnClickListener(this);
//    }

    //ListView之checkbox错位问题解决
    private List<Person> aData = null;
    private ContactListAdapter aAdapter = null;
    private ListView list_person;

    void listViewTest() {

        list_person = (ListView) findViewById(R.id.list_test);
        list_person.setVerticalScrollBarEnabled(false);
        aData = new LinkedList<Person>();
        for (int i = 0; i < 20; i++) {
            aData.add(new Person("何炅" + i,"18565610000", R.mipmap.head_icon1));
            aData.add(new Person("谢娜" + i,"18565611111", R.mipmap.head_icon2));
            aData.add(new Person("何炅" + i,"18565613333", R.mipmap.head_icon3));
        }
        aAdapter = new ContactListAdapter((LinkedList<Person>) aData, mContext);

//        list_person.setAdapter(aAdapter);
//        list_person.setOnItemClickListener(this);
    }

    //自定义BaseAdapter，然后绑定ListView的最简单例子
    private List<Animal> mData = null;
    private AnimalAdapter mAdapter = null;
    private ListView list_animal;

    void baseAdapterTest()
    {
        list_animal = (ListView) findViewById(R.id.list_test);
        //动态加载顶部View和底部View
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.view_header, null, false);
        View footView = inflater.inflate(R.layout.view_footer, null, false);

        mData = new LinkedList<Animal>();
        for (int i = 0; i < 20; i++){
            mData.add(new Animal("狗说", "你是狗么？", R.mipmap.ic_icon_dog));
            mData.add(new Animal("牛说", "你是牛么?", R.mipmap.ic_icon_cow));
            mData.add(new Animal("鸭说", "你是鸭么?", R.mipmap.ic_icon_duck));
            mData.add(new Animal("鱼说", "你是鱼么?", R.mipmap.ic_icon_fish));
            mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_icon_horse));
        }
        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, mContext);
        //添加表头表尾需要写在setAdapter方法调用之前
        list_animal.addHeaderView(headView);
        list_animal.addFooterView(footView);
        //列表从底部开始显示
        list_animal.setStackFromBottom(false);

        list_animal.setAdapter(mAdapter);
        list_animal.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"你点击了第" + position + "项",Toast.LENGTH_SHORT).show();
    }

    //SimpleCursorAdapter使用示例
    void simpleCursorAdapterTest()
    {

        //读取联系人
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        Log.d(String.valueOf(cursor.getColumnNames()), "simpleCursorAdapterTest: ");
//        cursor.getColumnNames();

        SimpleCursorAdapter spcAdapter = new SimpleCursorAdapter(this, R.layout.simple_cursor_list_item, cursor,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
                new int[]{R.id.list_name, R.id.list_phone});

        ListView list_test = (ListView) findViewById(R.id.list_test);
        list_test.setAdapter(spcAdapter);
    }

    //SimpleAdapter 使用示例
    private String[] names = new String[]{"B神","基神","曹神"};
    private String[] says = new String[]{"无形被黑，最为致命", "大神好厉害~", "我将带头日狗~"};
    private int[] imgIds = new int[]{R.mipmap.head_icon1, R.mipmap.head_icon2, R.mipmap.head_icon3};

    void simpleAdapterTest() {
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("name", names[i]);
            showitem.put("says", says[i]);
            listitem.add(showitem);
        }
        //创建一个 SimpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(),
                listitem, R.layout.list_item,
                new String[]{"touxiang", "name", "says"},
                new int[]{R.id.imgtou, R.id.name, R.id.says});
        ListView listView = (ListView) findViewById(R.id.list_test);
        listView.setAdapter(myAdapter);
    }

    void adapterTest() {
        String[] strs = {"机身","B神","象神","槽深","J神","机身","B神","象神","槽深","J神"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.myarray,android.R.layout.simple_list_item_multiple_choice );
        ListView list_test = (ListView) findViewById(R.id.list_test);
        list_test.setAdapter(adapter);
    }

    void dateTest()
    {
        DatePicker dp_test = (DatePicker) findViewById(R.id.dp_test);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dp_test.init(year,monthOfYear,dayOfMonth,this);
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(mContext,"您选择的日期是：" + year + "年" + monthOfYear + "月" + dayOfMonth + "日",Toast.LENGTH_SHORT).show();;
    }

    private Button btn_down;
    private Button btn_up;
    private ScrollView scrollView;
    private TextView txt_show;

    public void bindViews() {
        btn_down = (Button) findViewById(R.id.btn_down);
        btn_up = (Button) findViewById(R.id.btn_up);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        txt_show = (TextView) findViewById(R.id.txt_cur);
        btn_down.setOnClickListener(this);
        btn_up.setOnClickListener(this);

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 100; i++) {
            sb.append("呵呵 * " + i + "\n");
        }
        txt_show.setText(sb.toString());
    }

    private int flag = 1;
    private Data mData_5 = null;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_down:
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                break;
            case R.id.btn_up:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
//            case R.id.add_btn:
//                mData_5 =  new Data(R.mipmap.head_icon1, "给诸葛跪了！~~~ x " + flag);
//                myAdapter.add(mData_5);
//                flag++;
//                break;
//            case R.id.add_btn2:
//                if (flag >= 5) {
//                    mData_5 =  new Data(R.mipmap.head_icon1, "给诸葛跪了！~~~ x " + flag);
//                    myAdapter.add(4, mData_5);
//                } else
//                {
//                    myAdapter.add(new Data(R.mipmap.head_icon1, "给诸葛跪了！~~~ x " + flag));
//                }
//                break;
//            case R.id.remove_btn:
//                if (mData_5 != null) {
//                    myAdapter.remove(mData_5);
//                }
//                break;
//            case R.id.remove_btn2:
//                myAdapter.remove(0);
//                break;
        }
    }

    public static void scrollToBtoom(final  View scroll, final View inner) {
        Handler mHandler = new Handler();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (scroll == null || inner == null) {
                    return;
                }
                int offset = inner.getMeasuredHeight() - scroll.getHeight();
                if (offset < 0) {
                    offset = 0;
                }
                scroll.scrollTo(0, offset);
            }
        });
    }

    //    private RatingBar rb_normal;
//
//    public void ratingBarTest() {
//        rb_normal = (RatingBar) findViewById(R.id.rb_normal);
//        rb_normal.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                Toast.makeText(mContext, "rating:" + String.valueOf(rating), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private SeekBar sb_normal;
//    private TextView txt_cur;
//    private Context mContext;
//
//    public void bindViews() {
//        sb_normal = (SeekBar) findViewById(R.id.sb_normal);
//        txt_cur = (TextView) findViewById(R.id.txt_cur);
//        sb_normal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                txt_cur.setText("当前进度值：" + progress + " / 100");
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(mContext, "触碰SeekBar", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(mContext, "放开SeekBar", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//    private ImageView img_pgbar;
//    AnimationDrawable ad;
//
//    void imgPgbarTest()
//    {
//        img_pgbar = (ImageView) findViewById(R.id.img_pgbar);
//        ad = (AnimationDrawable) img_pgbar.getDrawable();
//        img_pgbar.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ad.start();
//            }
//        }, 100);
//    }

//    private CheckBox cb_one;
//    private CheckBox cb_two;
//    private CheckBox cb_three;
//    private Button btn_send;
//
//    void checkBoxTest() {
//        cb_one = (CheckBox) findViewById(R.id.cb_one);
//        cb_two = (CheckBox) findViewById(R.id.cb_two);
//        cb_three = (CheckBox) findViewById(R.id.cb_three);
//        btn_send = (Button) findViewById(R.id.btnPost2);
//
//        cb_one.setOnCheckedChangeListener(this);
//        cb_two.setOnCheckedChangeListener(this);
//        cb_three.setOnCheckedChangeListener(this);
//        btn_send.setOnClickListener(this);
//    }
//
//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        if(compoundButton.isChecked()) Toast.makeText(this,compoundButton.getText().toString(),Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onClick(View view) {
//        String choose = "";
//        if(cb_one.isChecked())choose += cb_one.getText().toString() + "";
//        if(cb_two.isChecked())choose += cb_two.getText().toString() + "";
//        if(cb_three.isChecked())choose += cb_three.getText().toString() + "";
//        Toast.makeText(this,choose,Toast.LENGTH_SHORT).show();
//    }
//
//    void radioTest() {
//        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
//        //第一种获取单选按钮值的方法
//        //为radioGroup设置一个监听器:setOnCheckedChanged()
//        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton radBtn = (RadioButton) findViewById(checkedId);
//                Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radBtn.getText(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }


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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
