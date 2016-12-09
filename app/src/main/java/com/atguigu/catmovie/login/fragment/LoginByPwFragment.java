package com.atguigu.catmovie.login.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.login.MyConstants;
import com.atguigu.catmovie.utils.DensityUtil;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * 登陆页面----账号密码登陆
 */
public class LoginByPwFragment extends BaseFragment implements View.OnClickListener {
    private static final int RESULT_OK = 11;
    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.iv_clear)
    ImageView ivClear;
    @Bind(R.id.iv_eyes)
    ImageView ivEyes;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @Bind(R.id.iv_xinlang)
    ImageView ivXinlang;
    @Bind(R.id.iv_weixin)
    ImageView ivWeixin;
    @Bind(R.id.iv_qq)
    ImageView ivQq;
    //第三方qq登陆
    @Bind(R.id.fl_arrow)
    FrameLayout flArrow;
    @Bind(R.id.fl_xinlang)
    FrameLayout flXinlang;
    @Bind(R.id.fl_weichat)
    FrameLayout flWeichat;
    @Bind(R.id.fl_qq)
    FrameLayout flQq;
    @Bind(R.id.fl_baidu)
    FrameLayout flBaidu;
    @Bind(R.id.ll_sanfang_denglu)
    LinearLayout llSanfangDenglu;
    private static Tencent mTencent;
    private UserInfo mInfo;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_login_by_pw, null);
        ButterKnife.bind(this, view);

        return view;
    }
    private boolean isHide = false;

    /**
     * 属性动画
     * @param view
     */
    @OnClick(R.id.fl_arrow)
    void hideSanfang(View view){
        isHide=!isHide;
        ObjectAnimator animator1;
        ObjectAnimator animator2;
        //第一个参数为 view对象，第二个参数为 动画改变的类型，第三，第四个参数依次是开始透明度和结束透明度
        if(isHide) {
            //开始动画，隐藏三方登录按钮
            animator1 = ObjectAnimator.ofFloat(flArrow,"rotation",0f,180f);//旋转动画
            animator2=ObjectAnimator.ofFloat(llSanfangDenglu,"translationY",0, DensityUtil.dip2px(DensityUtil.dip2px(getActivity(), 30)));//平移动画
        }else{
            animator1 = ObjectAnimator.ofFloat(flArrow,"rotation",180f,360f);
            animator2=ObjectAnimator.ofFloat(llSanfangDenglu,"translationY", DensityUtil.dip2px(getActivity(), 30),0);
        }
        AnimatorSet animatorSet = new AnimatorSet();//组合动画
        animatorSet.setDuration(400);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(animator1).with(animator2);//两个动画同时开始play...with...with....
        animatorSet.start();
    }
    @Override
    public void initData() {
        mTencent = Tencent.createInstance("1105704769", getActivity());
        Log.e("TAG", "mTencent");
        mInfo = new UserInfo(getActivity(), mTencent.getQQToken());
        initListener();
    }

    private void initListener() {
        ivQq.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        ivWeixin.setOnClickListener(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_qq:
                //qq第三方登陆
                mTencent.login(LoginByPwFragment.this, "all", loginListener);
                break;
            case R.id.btn_login:
                //手机验证登录
                phoneCheck();
                break;
            case R.id.iv_weixin:
                //微信第三方登录
                WXLogin();
                Toast.makeText(getActivity(), "微信登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // 微信登录
    private IWXAPI api;
    private String WX_APP_ID = "wx19424d3a9c8ee316";

    /**
     * 登录微信
     */
    private void WXLogin() {
        //api注册
        api = WXAPIFactory.createWXAPI(getActivity(), WX_APP_ID, true);
        api.registerApp(WX_APP_ID);

        SendAuth.Req req = new SendAuth.Req();

        //授权读取用户信息
//        req.scope = "snsapi_userinfo";
        req.scope = "snsapi_base";

        //自定义信息
        req.state = "wechat_sdk_demo_test";

        //向微信发送请求
        api.sendReq(req);

    }

    /**
     * 集成手机验证码登陆
     */
    public void phoneCheck() {
//打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    Toast.makeText(getActivity(), "phone" + phone, Toast.LENGTH_SHORT).show();

// 提交用户信息（此方法可以不调用）
//                    registerUser(country, phone);
                }
            }
        });
        registerPage.show(getActivity());
    }

    /**
     * 集成第三方登陆
     */

    private String imgurl;
    private String nickname;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            JSONObject response = (JSONObject) msg.obj;

            try {
                imgurl = response.getString("figureurl_qq_2");
                nickname = response.getString("nickname");

                //保存qq图像和昵称
                PreferenceUtils.putString(getActivity(),
                        MyConstants.USER_NAME, nickname);
                PreferenceUtils.putString(getActivity(),
                        MyConstants.IMAGE_URL, imgurl);

                //设置返回的结果
                Log.e("TAG", "nick_name==" + nickname + "imageUrl ====" + imgurl);
//                getActivity().finish();
                EventBus.getDefault().post("login_success");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("ruolan", "-->onActivityResult " + requestCode + " resultCode=" + resultCode);
        Log.e("TAG", "onActivityResult");
        if (requestCode == Constants.REQUEST_LOGIN ||
                requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public IUiListener loginListener = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {

            initOpenidAndToken(values);

            //下面的这个必须放到这个地方，要不然就会出错
            updateUserInfo();

        }
    };

    public static void initOpenidAndToken(JSONObject jsonObject) {
        try {
            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
                    && !TextUtils.isEmpty(openId)) {
                mTencent.setAccessToken(token, expires);
                mTencent.setOpenId(openId);
            }
        } catch (Exception e) {
        }
    }

    private void updateUserInfo() {
        if (mTencent != null && mTencent.isSessionValid()) {
            IUiListener listener = new IUiListener() {

                @Override
                public void onError(UiError e) {

                }

                @Override
                public void onComplete(final Object response) {
                    Message msg = new Message();
                    msg.obj = response;
                    msg.what = 0;
                    mHandler.sendMessage(msg);

                }

                @Override
                public void onCancel() {

                }
            };

            mInfo.getUserInfo(listener);

        } else {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            if (null == response) {
                return;
            }
            JSONObject jsonResponse = (JSONObject) response;
            if (null != jsonResponse && jsonResponse.length() == 0) {
                return;
            }
            doComplete((JSONObject) response);
        }

        @Override
        public void onError(UiError e) {

        }

        @Override
        public void onCancel() {

        }

        protected void doComplete(JSONObject values) {

        }
    }

}
