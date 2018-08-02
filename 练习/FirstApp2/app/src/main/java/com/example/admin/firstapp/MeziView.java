package com.example.admin.firstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by admin on 2018/8/2.
 */

public class MeziView extends View{
    //定义相关变量，依次是妹子显示位置的X,Y坐标
    public float bitmapX;
    public float bitmapY;
    public MeziView(Context content) {
        super(content);
        //设置妹子的起始坐标
        bitmapX = 0;
        bitmapY = 200;
    }

    //重写View类的OnDraw()方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建，并实例化Paint对象
        Paint paint = new Paint();
        //根据图片生成位图对象
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_jump);
        //绘制萌妹子
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);
        //判断突变是否回收，没有回收的话强制回收图片
        if (bitmap.isRecycled())
        {
            bitmap.recycle();
        }

        Log.d("width",bitmap.getWidth()+"");
        Log.d("height",bitmap.getHeight()+"");
    }
}




