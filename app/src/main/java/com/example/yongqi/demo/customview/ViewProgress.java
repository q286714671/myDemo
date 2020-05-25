package com.example.yongqi.demo.customview;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yongqi on 2018/4/23.
 */

public class ViewProgress extends View{

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    private float progress;

    public ViewProgress(Context context) {
        super(context);
    }

    public ViewProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeWidth(20);

        paint.setStrokeCap(Paint.Cap.ROUND);

        paint.setColor(Color.BLUE);

        RectF r = new RectF(0,0,480,480);

        r.offset(100,100);

        canvas.drawArc(r,270,progress * 4f,false,paint);

    }

    public void setData(float num){
        ObjectAnimator animator  = ObjectAnimator.ofFloat(this,"progress",0,num);
        animator.setDuration(5000);
        animator.start();
    }

    public void setDatas(){
        Keyframe keyframe1 = Keyframe.ofFloat(0,0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.7f,100);
        Keyframe keyframe3 = Keyframe.ofFloat(1f,70);
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress",keyframe1,keyframe2,keyframe3);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(this,holder);
        animator.setDuration(800);
        animator.start();
    }
}
