package com.atguigu.catmovie.find.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.atguigu.catmovie.R;

public class PiaoFangActivity extends Activity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piao_fang);
        webview = (WebView) findViewById(R.id.webview);
        String url = "http://m.maoyan.com/newGuide/maoyanpiaofang?f=nohdft&share=Android";

        LoadWebView(url);
    }

    private void LoadWebView(final String url) {
        if(url!=null) {
            webview.loadUrl(url);
            WebSettings settings = webview.getSettings();
            //启用支持javascript
            settings.setJavaScriptEnabled(true);
            //优先使用缓存
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
            webview.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView webview, WebResourceRequest request) {
                    webview.loadUrl(url);
                    return true;
                }
            });
        }
    }

}
