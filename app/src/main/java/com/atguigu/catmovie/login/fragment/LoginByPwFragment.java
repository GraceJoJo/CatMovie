package com.atguigu.catmovie.login.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.login.MyConstants;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
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
    @Bind(R.id.iv_baidu)
    ImageView ivBaidu;
    @Bind(R.id.rl_san_fang_login)
    RelativeLayout rlSanFangLogin;
    //第三方qq登陆
    private static Tencent mTencent;
    private UserInfo mInfo;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_login_by_pw, null);
        ButterKnife.bind(this, view);

        return view;
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
                phoneCheck();
                break;
        }
    }
    /**
     * 集成手机验证码登陆
     */
    public void phoneCheck(){
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
     *     集成第三方登陆
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
