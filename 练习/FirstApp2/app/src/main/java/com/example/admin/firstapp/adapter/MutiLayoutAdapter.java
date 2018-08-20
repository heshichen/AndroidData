package com.example.admin.firstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.firstapp.R;
import com.example.admin.firstapp.entity.App;
import com.example.admin.firstapp.entity.Book;

import java.util.ArrayList;

/**
 * Created by admin on 2018/8/20.
 */

public class MutiLayoutAdapter extends BaseAdapter {

    //定义两个类别
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private Context mContext;
    private ArrayList<Object> mData = null;

    public MutiLayoutAdapter(Context mContext, ArrayList<Object> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof App) {
            return TYPE_APP;
        } else if (mData.get(position) instanceof Book) {
            return TYPE_BOOK;
        } else  {
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if (convertView == null) {
            switch (type) {
                case TYPE_APP:
                    holder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent, false);
                    holder1.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
                    holder1.txt_aname = (TextView) convertView.findViewById(R.id.txt_aname);
                    convertView.setTag(R.id.Tag_App, holder1);
                    break;
                case TYPE_BOOK:
                    holder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_two, parent, false);
                    holder2.txt_bname = (TextView) convertView.findViewById(R.id.txt_bname);
                    holder2.txt_bauthor = (TextView) convertView.findViewById(R.id.txt_bauthor);
                    convertView.setTag(R.id.Tag_Book, holder2);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_APP:
                    holder1 = (ViewHolder1) convertView.getTag(R.id.Tag_App);
                    break;
                case TYPE_BOOK:
                    holder2 = (ViewHolder2) convertView.getTag(R.id.Tag_Book);
                    break;
            }
        }

        Object obj = mData.get(position);
        //设置下空间的值
        switch (type) {
            case TYPE_APP:
                App app = (App) obj;
                if (app != null) {
                    holder1.img_icon.setBackgroundResource(app.getImg_icon());
                    holder1.txt_aname.setText(app.getTxt_name());
                }
                break;
            case TYPE_BOOK:
                Book book = (Book) obj;
                if (book != null) {
                    holder2.txt_bname.setText(book.getTxt_bname());
                    holder2.txt_bauthor.setText(book.getTxt_bauthor());
                }
                break;
        }
        return convertView;
    }

    private static class ViewHolder1 {
        ImageView img_icon;
        TextView txt_aname;
    }

    private static class ViewHolder2 {
        TextView txt_bname;
        TextView txt_bauthor;
    }
}
