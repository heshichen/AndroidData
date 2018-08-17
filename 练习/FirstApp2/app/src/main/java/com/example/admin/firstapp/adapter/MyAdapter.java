package com.example.admin.firstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.firstapp.R;
import com.example.admin.firstapp.entity.Data;

import java.util.LinkedList;

/**
 * Created by admin on 2018/8/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<Data> mData;

    public MyAdapter(){}

    public MyAdapter(LinkedList<Data> mData, Context mContext){
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list2,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            viewHolder.txt_content = (TextView) convertView.findViewById(R.id.txt_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.img_icon.setBackgroundResource(mData.get(position).getImgId());
        viewHolder.txt_content.setText(mData.get(position).getContent());
        return convertView;
    }

    private class ViewHolder {
        ImageView img_icon;
        TextView txt_content;
    }

    public void add(Data data) {
        if (mData == null) {
            mData = new LinkedList<Data>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    public void add(int postion, Data data) {
        if (mData == null) {
            mData = new LinkedList<Data>();
        }
        if (mData.size() > postion) {
            mData.add(postion, data);
            notifyDataSetChanged();
        }
    }

    public void remove(Data data) {
        if (mData.size() != 0 && mData != null) {
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    public void remove(int positon) {
        if (mData.size() != 0 && mData != null) {
            mData.remove(positon);
        }
        notifyDataSetChanged();
    }
}
