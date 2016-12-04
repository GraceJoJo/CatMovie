package com.atguigu.catmovie;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.cityindex.citylist.CityList;
import com.atguigu.catmovie.fragment.CinemaFragment;
import com.atguigu.catmovie.fragment.FindFragment;
import com.atguigu.catmovie.fragment.MeFragment;
import com.atguigu.catmovie.fragment.MovieFragment;
import com.atguigu.catmovie.utils.SpUtil;
import com.flyco.tablayout.SlidingTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "main";
    @Bind(R.id.fl_main_content)
    FrameLayout flMainContent;
    @Bind(R.id.rb_movie)
    RadioButton rbMovie;
    @Bind(R.id.rb_cinema)
    RadioButton rbCinema;
    @Bind(R.id.rb_find)
    RadioButton rbFind;
    @Bind(R.id.rb_me)
    RadioButton rbMe;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    //同一处理城市的切换的逻辑
    @Bind(R.id.rl_select_city)
    RelativeLayout rlSelectCity;
    @Bind(R.id.text_cinema_center)
    TextView textCinemaCenter;
    @Bind(R.id.tl_10)
    SlidingTabLayout tl10;
    @Bind(R.id.slidelayout)
    LinearLayout slidelayout;
    @Bind(R.id.iv_select_city)
    ImageView ivSelectCity;
    @Bind(R.id.ll_cinema_select)
    LinearLayout llCinemaSelect;
    @Bind(R.id.iv_search_icon)
    ImageView ivSearchIcon;
    @Bind(R.id.ll_cinema_search)
    LinearLayout llCinemaSearch;
    @Bind(R.id.ll_common_titl)
    LinearLayout llCommonTitl;
    private MovieFragment movieFragment;
    private CinemaFragment cinemaFragment;

    private FindFragment findFragment;
    private MeFragment meFragment;
    private FragmentTransaction transaction;
    private int position;
    private LocalBroadcastManager mLBM;
    private TextView curCity;

    //测试git
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initListener();
        rgMain.check(R.id.rb_movie);

    }

    private void initData() {
        /**
         * 当前所选的城市
         */
        curCity = (TextView) findViewById(R.id.tv_select_city);
        /**  City---1.判断之前选择的城市：SP中读取
         *          //判断是否需要切换城市
         */
        mLBM = LocalBroadcastManager.getInstance(this);
        mLBM.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String firstLocation = intent.getStringExtra("firstLocation");
                if (!TextUtils.isEmpty(firstLocation)) {
                    curCity.setText(firstLocation);
                }
            }
        }, new IntentFilter("isFrist"));
        isSwichCity();
    }

    private void initListener() {

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_movie:
                        position = 0;
                        break;
                    case R.id.rb_cinema:
                        position = 1;
                        break;
                    case R.id.rb_find:
                        position = 2;
                        break;
                    case R.id.rb_me:
                        position = 3;
                        break;
                }
                selectTab(position);
            }

        });

        rlSelectCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "选择城市", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CityList.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    private void selectTab(int position) {
        transaction = getSupportFragmentManager().beginTransaction();
        //先隐藏之前的Fragment
        hideFragment();
        switch (position) {
            case 0:
                if (movieFragment == null) {
                    movieFragment = new MovieFragment();
                    transaction.add(R.id.fl_main_content, movieFragment);
                }
                transaction.show(movieFragment);
                break;
            case 1:
                if (cinemaFragment == null) {
                    cinemaFragment = new CinemaFragment();
                    transaction.add(R.id.fl_main_content, cinemaFragment);
                }
                transaction.show(cinemaFragment);
                break;
            case 2:
                if (findFragment == null) {
                    findFragment = new FindFragment();
                    transaction.add(R.id.fl_main_content, findFragment);
                }

                transaction.show(findFragment);
                break;
            case 3:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.fl_main_content, meFragment);
                }
                transaction.show(meFragment);
                break;
        }
        transaction.commit();
    }

    private void hideFragment() {
        //先隐藏之前的Fragment
        if (movieFragment != null) {
            transaction.hide(movieFragment);
        }
        if (cinemaFragment != null) {
            transaction.hide(cinemaFragment);
        }
        if (findFragment != null) {
            transaction.hide(findFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }

    }

    private void isSwichCity() {
        final String city = SpUtil.getInstance(MyApplication.getmContext()).getString("city", "");
        //定位获得的城市---第二次进来时进行判断是否需要切换
        final String location_city = SpUtil.getInstance(MyApplication.getmContext()).getString("location_city", "");
        if (!TextUtils.isEmpty(city)) {
            if (!TextUtils.isEmpty(location_city) && !location_city.equals(city)) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("检测到您所在城市为" + location_city + ",是否需要切换")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                curCity.setText(location_city);
                                SpUtil.getInstance(MyApplication.getmContext()).save("city", location_city);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                curCity.setText(city);
                            }
                        })
                        .show();
            }
            curCity.setText(location_city);
        } else {
            //默认设置"长沙"
            curCity.setText("长沙");
        }
    }

    /**
     * 处理选择城市的返回结果
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null)
            switch (resultCode) {
                case 2:
                    isSwichCity();
                    curCity.setText(data.getStringExtra("city"));
                    break;
                default:
                    break;
            }
    }

    public RelativeLayout getRlSelectCity() {
        return rlSelectCity;
    }

    public TextView getTextCinemaCenter() {
        return textCinemaCenter;
    }

    public SlidingTabLayout getTl10() {
        return tl10;
    }

    public LinearLayout getSlidelayout() {
        return slidelayout;
    }

    public ImageView getIvSelectCity() {
        return ivSelectCity;
    }

    public LinearLayout getLlCinemaSelect() {
        return llCinemaSelect;
    }

    public ImageView getIvSearchIcon() {
        return ivSearchIcon;
    }

    public LinearLayout getLlCinemaSearch() {
        return llCinemaSearch;
    }

    public LinearLayout getLlCommonTitl() {
        return llCommonTitl;
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
//        llCommonTitl.setVisibility(View.VISIBLE);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
////        llCommonTitl.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
////        llCommonTitl.setVisibility(View.VISIBLE);
//    }
}
