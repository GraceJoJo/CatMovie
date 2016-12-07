package com.atguigu.catmovie.find.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.atguigu.catmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 集成实现share-sdk分享的功能
 */

public class PiaoFangActivity extends Activity {

    @Bind(R.id.iv_close)
    ImageView ivClose;
    @Bind(R.id.iv_share)
    ImageView ivShare;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piao_fang);
        ButterKnife.bind(this);
        webview = (WebView) findViewById(R.id.webview);
        String url = "http://m.maoyan.com/newGuide/maoyanpiaofang?f=nohdft&share=Android";

        LoadWebView(url);

        initListener();
    }

    private void initListener() {
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showShare();
            }
        });
    }

    private void LoadWebView(final String url) {
        if (url != null) {
            webview.loadUrl(url);
            WebSettings settings = webview.getSettings();
            //启用支持javascript
            settings.setJavaScriptEnabled(true);
            //优先使用缓存
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
            webview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView webview, WebResourceRequest request) {
                    webview.loadUrl(url);
                    return true;
                }
            });
        }
    }
////    /**
////     * SharedSDK分享到其他平台应用
////     */
//    private void showShare() {
//        ShareSDK.initSDK(this);
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
//        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
//        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//        oks.setTitle(getString(R.string.app_name));
//        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//        oks.setTitleUrl("http://atguigu.com/teacher.shtml");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("儿子发烧了。我抱着他测体温。看着儿子烧到三十八度多了。我心疼的对儿子说:“宝宝,你想要什么呀?爸爸去给你买!”儿子眼睛一亮,灰常灰常高兴的说:“我想吃雪糕。”我说不行,换一个!儿子想了想接着说:“我想要妈妈给我生个哥哥...”你还是吃雪糕吧……");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl("http://atguigu.com/teacher.shtml");
//        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("平生不识尚硅谷，阅尽Android也枉然");
//        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite(getString(R.string.app_name));
//        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://atguigu.com/teacher.shtml");
//// 启动分享GUI
//        oks.show(this);
//    }
}
