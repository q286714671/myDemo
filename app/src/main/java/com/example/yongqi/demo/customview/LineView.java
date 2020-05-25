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

public class LineView extends View{


    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置画笔基本属性
        Paint paint = new Paint();

        //paint.setAntiAlias(true);  //设置抗锯齿
        paint.setColor(Color.RED);

        paint.setStyle(Paint.Style.FILL);

        paint.setStrokeWidth(5);  //设置画笔宽度

        //paint.setShadowLayer(10,15,15,Color.GREEN);

        //canvas.drawRGB(255,255,255); //设置画布


        canvas.drawLine(300,300,500,500,paint);

    }
}
