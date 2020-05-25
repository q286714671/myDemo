package com.example.yongqi.demo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yongqi on 2018/1/15.
 */

public class MyView extends View{


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置画笔基本属性
        Paint paint = new Paint();

        paint.setAntiAlias(true);  //设置抗锯齿
        paint.setColor(Color.RED);

        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeWidth(5);  //设置画笔宽度

        //paint.setShadowLayer(10,15,15,Color.GREEN);

        canvas.drawRGB(255,255,255); //设置画布


        canvas.drawCircle(200,200,100,paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
