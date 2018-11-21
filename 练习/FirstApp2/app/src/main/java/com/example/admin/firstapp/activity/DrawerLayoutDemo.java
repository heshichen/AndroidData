package com.example.admin.firstapp.activity;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.firstapp.R;
import com.example.admin.firstapp.adapter.MyAdapter;
import com.example.admin.firstapp.entity.Item;
import com.example.admin.firstapp.fragment.ContentFragment;

import java.util.ArrayList;

/**
 * Created by admin on 2018/11/20.
 */

public class DrawerLayoutDemo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawer_layout;
    private ListView list_left_drawer;
    private ArrayList<Item> menuLists;
    private MyAdapter<Item> myAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawe_layout);

        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        list_left_drawer = (ListView) findViewById(R.id.list_left_drawer);

        menuLists = new ArrayList<Item>();
        menuLists.add(new Item(R.mipmap.iv_menu_realtime,"实时性息"));
        menuLists.add(new Item(R.mipmap.iv_menu_alert,"提醒通知"));
        menuLists.add(new Item(R.mipmap.iv_menu_trace,"活动路线"));
        menuLists.add(new Item(R.mipmap.iv_menu_settings,"相关设置"));
        myAdapter = new MyAdapter<Item>(menuLists,R.layout.item_list2) {
            @Override
            public void bindView(ViewHolder holder, Item obj) {
                holder.setImageResource(R.id.img_icon,obj.getImg_icon());
                holder.setText(R.id.tv_content, obj.getTv_name());
            }
        };
        list_left_drawer.setAdapter(myAdapter);
        list_left_drawer.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuLists.get(position).getTv_name());
        contentFragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
        drawer_layout.closeDrawer(list_left_drawer);
    }
}
