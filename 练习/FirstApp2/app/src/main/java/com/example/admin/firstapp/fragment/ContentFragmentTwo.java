package com.example.admin.firstapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.firstapp.R;

/**
 * Created by admin on 2018/11/21.
 */

public class ContentFragmentTwo extends Fragment {

    private TextView tv_content;
    private String strContent;
    private int bgColor;

    public ContentFragmentTwo(){
        this.strContent = "hhh";
        this.bgColor = R.color.blue;
    }

    public static ContentFragmentTwo newInstance(String strContent,int bgColor) {
        ContentFragmentTwo newFragment = new ContentFragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString("strContent",strContent);
        bundle.putInt("bgColor",bgColor);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        if (args != null) {
            strContent = args.getString("strContent");
            bgColor = args.getInt("bgColor");
        }
        View view = inflater.inflate(R.layout.fg_content, container, false);
        view.setBackgroundColor(getResources().getColor(bgColor));
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText(strContent);
        return view;
    }
}
