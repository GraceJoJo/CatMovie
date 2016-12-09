package com.atguigu.catmovie.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * Created by JOJO on 2016/12/8.
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler{

    private IWXAPI api;
    private String WX_APP_ID = "wx19424d3a9c8ee316";
    private String WX_APP_SECRET = "bbbc8edb2399c9ce0e5f395201ff6da4";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //注册API
        api = WXAPIFactory.createWXAPI(this, WX_APP_ID);
        api.handleIntent(getIntent(), this);
    }


    @Override
    public void onReq(BaseReq baseReq) {

    }
//    private String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    private String url = "https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
//    private String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx19424d3a9c8ee316&redirect_uri=http://nba.bluewebgame.com/oauth_response.php&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    @Override
    public void onResp(BaseResp resp) {

        if(resp instanceof SendAuth.Resp){
            SendAuth.Resp newResp = (SendAuth.Resp) resp;

            //获取微信传回的code
            String code = newResp.code;
            url = url.replace("CODE",code);
            Log.e("TAG", "url==" + url);
//            getDataFromNet(url);
        }

    }

    private void getDataFromNet(String url) {
        RequestNet
                .url(url, new CallBack() {
                    @Override
                    public void onError(Exception e) {

                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.e("TAG", "response===="+response);
                    }
                });
    }

}

