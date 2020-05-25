package com.example.yongqi.demo;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yongqi.demo.testkt.TestKTKt;

/**
 * Created by yongqi on 2018/1/13.
 */

public class AddAnimActivity extends AppCompatActivity implements View.OnClickListener {


    private Button add, remove;

    private LinearLayout parent;

    private ImageButton item1, item2, item3, item4, item5, item6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        //TestKTKt.echo();

        add = findViewById(R.id.add);
        remove = findViewById(R.id.remove);

        add.setOnClickListener(this);
        remove.setOnClickListener(this);

        parent = findViewById(R.id.ll);

        LayoutTransition mTransitioner = new LayoutTransition();
        //入场动画:view在这个容器中消失时触发的动画
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f, 0f);
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animIn);

        //出场动画:view显示时的动画
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animOut);

        parent.setLayoutTransition(mTransitioner);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        item5 = findViewById(R.id.item5);
        item6 = findViewById(R.id.item6);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);
        item6.setOnClickListener(this);
    }


    boolean isOpen = false;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
            case R.id.remove:
                remove();
                break;
            case R.id.item1:
                if(isOpen){
                    isOpen = false;
                    closeAnim(item2,0);
                    closeAnim(item3,1);
                    closeAnim(item4,2);
                    closeAnim(item5,3);
                    closeAnim(item6,4);
                }else{
                    isOpen = true;
                    openAnim(item2,0);
                    openAnim(item3,1);
                    openAnim(item4,2);
                    openAnim(item5,3);
                    openAnim(item6,4);
                }

                break;
            case R.id.item2:
                Toast.makeText(this,"点击了" + 2,Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                break;
            case R.id.item4:
                break;
            case R.id.item5:
                break;
            case R.id.item6:
                break;
        }
    }


    private void openAnim(ImageButton image,int index){
        if(image.getVisibility() != View.VISIBLE){
            image.setVisibility(View.VISIBLE);
        }

        double degree = Math.toRadians(90 * index / 4);

        int translationX = - (int) (500 * Math.sin(degree));
        int translationY = - (int) (500 * Math.cos(degree));

        AnimatorSet set = new AnimatorSet();

        set.playTogether(
                ObjectAnimator.ofFloat(image,"translationX",translationX),
                ObjectAnimator.ofFloat(image,"translationY",translationY),
                ObjectAnimator.ofFloat(image,"scaleX",0f,1f),
                ObjectAnimator.ofFloat(image,"scaleY",0f,1f),
                ObjectAnimator.ofFloat(image,"alpha",0f,1f)
        );

        set.setDuration(500).start();
    }

    private void closeAnim(ImageButton image,int index){
        if(image.getVisibility() != View.VISIBLE){
            image.setVisibility(View.VISIBLE);
        }

        double degree = Math.toRadians(90 * index / 4);

        int translationX = (int) (500 * Math.sin(degree));
        int translationY = (int) (500 * Math.cos(degree));

        AnimatorSet set = new AnimatorSet();

        set.playTogether(
                ObjectAnimator.ofFloat(image,"translationX",translationX),
                ObjectAnimator.ofFloat(image,"translationY",translationY),
                ObjectAnimator.ofFloat(image,"scaleX",1f,0.1f),
                ObjectAnimator.ofFloat(image,"scaleY",1f,0.1f),
                ObjectAnimator.ofFloat(image,"alpha",1f,0f)
        );

        set.setDuration(500).start();
    }

    private int i;

    private void remove() {
        if (i > 0) {
            parent.removeViewAt(0);
        }
        i--;
    }

    private void add() {
        i++;
        Button button = new Button(this);
        button.setText("按钮" + i);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(lp);
        parent.addView(button, 0);
    }
}
