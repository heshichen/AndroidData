package com.example.admin.firstapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.firstapp.R;
import com.example.admin.firstapp.entity.Person;

import java.util.List;

/**
 * Created by admin on 2018/8/17.
 */

public class ContactListAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    private List<Person> mData;
    private Context mContext;

    public ContactListAdapter(List<Person> data, Context context) {
        mData = data;
        mContext = context;
    }

    public void changeData(List<Person> data) {
        mData = data;
        notifyDataSetChanged();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final int index = position;
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);
            viewHolder = new ViewHolder();
//            viewHolder.ly = (RelativeLayout) convertView.findViewById(R.id.lyContactListItem);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtNumber = (TextView) convertView.findViewById(R.id.txtNumber);
            viewHolder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
            viewHolder.cbxStatus = (CheckBox) convertView.findViewById(R.id.cbxStatus);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.cbxStatus.setTag(index);
        viewHolder.cbxStatus.setOnCheckedChangeListener(this);
        viewHolder.cbxStatus.setChecked(mData.get(position).getCheckStatus());
        viewHolder.txtName.setText(mData.get(index).getName());
        viewHolder.txtNumber.setText(mData.get(index).getNumber());
        viewHolder.imgIcon.setBackgroundResource(mData.get(index).getIcon());
        return convertView;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int index = (int)buttonView.getTag();
        if (isChecked)
            mData.get(index).setCheckStatus(true);
        else
            mData.get(index).setCheckStatus(false);
    }

    private class ViewHolder {
        RelativeLayout ly;
        TextView txtName;
        TextView txtNumber;
        ImageView imgIcon;
        CheckBox cbxStatus;
    }
}
