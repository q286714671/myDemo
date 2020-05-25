package com.example.yongqi.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;

/**
 * Created by yongqi on 2017/12/10.
 */

public class WebViewActivity extends AppCompatActivity {

    private AgentWeb mAgentWeb;

    private LinearLayout mLinearLayout;

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        mLinearLayout = findViewById(R.id.linearlayout);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /*mAgentWeb = AgentWeb.with(this)//传入Activity or Fragment
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .setReceivedTitleCallback(new ChromeClientCallbackManager.ReceivedTitleCallback() {
                    @Override
                    public void onReceivedTitle(WebView view, String title) {

                        toolbar.setTitle(title);
                    }
                }) //设置 Web 页面的 title 回调
                .createAgentWeb()//
                .ready()
                .go("https://www.baidu.com");*/

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready().go("about:blank");

        mAgentWeb.getUrlLoader().loadData("<p>　　<b>网易娱乐专稿9月7日报道</b>(文/小易)" +
        " 今日凌晨，郭德纲鹤字辈徒弟在微博发文对德云社表忠心，称自己之前在外私自接活，离开德云社，" +
                "因羞愧两年没有师父郭德纲与师娘联系，本应该被清出师门，但承蒙师父郭德纲不离不弃。" +
                "随后，郭德纲转发该微博并附文“知错能改善莫大焉”。加上前几天曹云金与何云伟撕郭德纲内幕一事，" +
                "本应告一段落的郭德纲与徒弟的各种纠纷若如此下去，恐难彻底收场。</p><p>　　<b>韩鹤晓微博原文：" +
                "</b></p><p>　　2006年考入鹤字科取名鹤晓，2009年6月13日恩师郭德纲先生收我为郭门弟子。" +
                "数年期间吃、住、学艺在德云基地，师父师娘分文未取。2010年结婚师父师娘给我和爱人赠送了红包与婚戒，" +
                "并在德云基地给我们提供了婚房。2014年9月，我由于个人原因，私自赴外地发展。后来返京羞于面对恩师，" +
                "两年未敢与恩师见面。后到上海发展，2016年6月师父上海演出期间，终于鼓起勇气向师父认错，" +
                "师父宽宏大量原谅了我。时隔两月回京之际，专程上家中看望师娘，并求得了原谅。以鶴晓所犯之错，" +
                "本足可导致“清门”，重修德云家谱之际，蒙恩师不弃，给于“暂留察看”实乃对徒儿网开一面。" +
                "罪徒鶴晓感念恩师授业之恩、不弃之情。鶴晓虽距京城数千之遥，定当永远心系德云。" +
                "未敢忘却恩师之谆谆教导，踏实做艺、好好做人!唯愿师父师娘身体安泰!徒儿鶴晓顿首遥拜！</p>","text/html","utf-8");

        Log.e("xs",mAgentWeb.getWebCreator().getWebView().getClass().getName());
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }


    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }
}
