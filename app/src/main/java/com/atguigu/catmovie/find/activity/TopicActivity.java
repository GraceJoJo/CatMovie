package com.atguigu.catmovie.find.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.atguigu.catmovie.R;

public class TopicActivity extends Activity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        webview = (WebView)findViewById(R.id.webview);
        String url = "http://m.maoyan.com/groups?_v_=yes&f=android&userid=-1&pushToken=7e6bd5fe73912116ed3ca24d473265cc37ad738879f590efaf0a436f905b945b103b4d6d4a8cb7a6cd70f822f26ffff9&cityId=1";
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
