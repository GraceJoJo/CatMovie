package com.atguigu.catmovie.cityindex.citylist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atguigu.catmovie.MyApplication;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.cityindex.adapter.HotCityGridAdapter;
import com.atguigu.catmovie.cityindex.helper.ContactsHelper;
import com.atguigu.catmovie.utils.SpUtil;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 城市选择--列表
 *
 * @author 娟娟
 */
public class CityList extends Activity {
    private BaseAdapter adapter;
    private ListView mCityLit;
    private TextView overlay, citysearch;
    private Button backbutton;
    private MyLetterListView letterListView;
    private HashMap<String, Integer> alphaIndexer;
    private String[] sections;
    private Handler handler;
    private OverlayThread overlayThread;
    private SQLiteDatabase database;
    private ArrayList<CityModel> mCityNames;
    private View city_locating_state;
    private View city_locate_failed;
    private TextView city_locate_state;
    private ProgressBar city_locating_progress;
    private ImageView city_locate_success_img;
    private LocationClient locationClient = null;

    View hotcityall;

    String[] hotcity = new String[]{"北京", "上海", "广州", "深圳", "杭州", "南京", "天津", "武汉", "重庆"};
    WindowManager windowManager;
    private LinearLayout city_location_success;
    private TextView current_city;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater localLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View city_layout = localLayoutInflater.inflate(R.layout.public_cityhot, null);
        setContentView(city_layout);

        citysearch = (TextView) city_layout.findViewById(R.id.city_search_edittext);
        backbutton = (Button) city_layout.findViewById(R.id.title_left_txt_btn);
        mCityLit = (ListView) city_layout.findViewById(R.id.public_allcity_list);//所有城市的ListView
        letterListView = (MyLetterListView) city_layout.findViewById(R.id.cityLetterListView);
        //热门城市--加头
        View cityhot_header_blank = localLayoutInflater.inflate(R.layout.public_cityhot_header_padding_blank, mCityLit, false);
        mCityLit.addHeaderView(cityhot_header_blank, null, false);
        //定位城市--加头
        cityhot_header_blank = localLayoutInflater.inflate(R.layout.city_locate_layout, mCityLit, false);

        city_location_success = (LinearLayout) cityhot_header_blank.findViewById(R.id.city_location_success);//定位成功的布局
        //定位到的当前的城市
        current_city = (TextView) cityhot_header_blank.findViewById(R.id.current_city);//定位成功的布局

        city_locating_state = cityhot_header_blank.findViewById(R.id.city_locating_state);
        city_locate_state = ((TextView) cityhot_header_blank.findViewById(R.id.city_locate_state));
        city_locating_progress = ((ProgressBar) cityhot_header_blank.findViewById(R.id.city_locating_progress));
        city_locate_success_img = ((ImageView) cityhot_header_blank.findViewById(R.id.city_locate_success_img));
        city_locate_failed = cityhot_header_blank.findViewById(R.id.city_locate_failed);
        mCityLit.addHeaderView(cityhot_header_blank);

        View hotheadview = localLayoutInflater.inflate(R.layout.public_cityhot_header_padding, mCityLit, false);
        mCityLit.addHeaderView(hotheadview, null, false);
        hotcityall = localLayoutInflater.inflate(R.layout.public_cityhot_allcity, mCityLit, false);
        final GridView localGridView = (GridView) hotcityall.findViewById(R.id.public_hotcity_list);

        mCityLit.addHeaderView(hotcityall);//将热门城市加到头布局
        HotCityGridAdapter adapter = new HotCityGridAdapter(this, Arrays.asList(hotcity));
        localGridView.setAdapter(adapter);
        //热门城市的GridView，设置item的点击事件---将选择的城市结果返回给启动的Activity
        localGridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cityModel = parent.getAdapter()
                        .getItem(position).toString();
//                Setting.Save2SharedPreferences(CityList.this, "city",
//                        cityModel);
                SpUtil.getInstance(getApplicationContext()).save("city", cityModel);
                Intent intent = new Intent();
                intent.putExtra("city", cityModel);
                setResult(2, intent);
                finish();
            }
        });

        city_locating_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityModel = city_locate_state.getText().toString();
//                Setting.Save2SharedPreferences(CityList.this, "city",
//                        cityModel.substring(0,2));
                SpUtil.getInstance(MyApplication.getmContext()).save("city",cityModel.substring(0,2));
                Intent intent = new Intent();
                intent.putExtra("city", cityModel.substring(0,2));
                Log.e("TAG", "5555555555"+cityModel);
                setResult(2, intent);
                finish();
            }
        });

        city_locate_failed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(CityList.this, "重新定位", Toast.LENGTH_SHORT).show();
                city_locating_state.setVisibility(View.VISIBLE);
                city_locating_progress.setVisibility(View.VISIBLE);
                city_locate_failed.setVisibility(View.GONE);
                location();
            }
        });

        /**
         * 百度定位
         */
        location();
        DBManager dbManager = new DBManager(this);
        dbManager.openDateBase();
        dbManager.closeDatabase();
        database = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/"
                + DBManager.DB_NAME, null);
        mCityNames = getCityNames();
        database.close();
        letterListView
                .setOnTouchingLetterChangedListener(new LetterListViewListener());
        alphaIndexer = new HashMap<String, Integer>();
        handler = new Handler();
        overlayThread = new OverlayThread();
        initOverlay();
        setAdapter(mCityNames);
        mCityLit.setOnItemClickListener(new CityListOnItemClick());
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        citysearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean startLoad = ContactsHelper.getInstance().startLoadContacts();

                Intent intent = new Intent(CityList.this, searchactivity.class);
                startActivityForResult(intent, 2);
                return false;
            }
        });


    }

    /**
     * 百度定位
     */
    private static final int BAIDU_READ_PHONE_STATE = 100;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    private void location() {
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数
        initLocation();
        mLocationClient.start();
    }


    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 0;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }


    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("BaiduLocationApiDem", sb.toString());
            /**
             * 得到当前定位的地址.location.getAddrStr()
             */
            city_locating_progress.setVisibility(View.GONE);
            Log.e("TAG", "11111111111111" + location.getCity());
            if (location != null) {

                if (location.getAddrStr() != null && !location.getCity().equals("")) {
                    Log.e("TAG", "定位成功");
                    mLocationClient.stop();
                    city_locate_failed.setVisibility(View.GONE);
                    city_locating_progress.setVisibility(View.GONE);
                    city_locate_state.setVisibility(View.VISIBLE);
                    city_locate_success_img.setVisibility(View.VISIBLE);
                    //当前城市值
                    city_locate_state.setText(location.getCity().substring(0,2));

                    //把定位的城市保存起来
                    SpUtil.getInstance(MyApplication.getmContext()).save("location_city",location.getCity().substring(0,2));

                } else {
                    city_locating_state.setVisibility(View.GONE);
                    city_locate_failed.setVisibility(View.VISIBLE);
                }
            } else {
                // 定位失败
                city_locating_state.setVisibility(View.GONE);
                city_locating_progress.setVisibility(View.GONE);
                city_locate_failed.setVisibility(View.VISIBLE);
            }

        }
    }
    //***********百度定位********************

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                String city = data.getStringExtra("city");
                Intent intent = new Intent();
                intent.putExtra("city", city.substring(0,2));
                setResult(2, intent);
                finish();
                break;

            default:
                break;
        }
    }

    /**
     * @return
     */
    private ArrayList<CityModel> getCityNames() {
        ArrayList<CityModel> names = new ArrayList<CityModel>();
        Cursor cursor = database.rawQuery(
                "SELECT * FROM T_City ORDER BY NameSort", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            CityModel cityModel = new CityModel();
            cityModel.setCityName(cursor.getString(cursor
                    .getColumnIndex("CityName")));
            cityModel.setNameSort(cursor.getString(cursor
                    .getColumnIndex("NameSort")));
            names.add(cityModel);
        }
        cursor.close();
        return names;
    }

    /**
     * б 1/4
     *
     * @author
     */
    class CityListOnItemClick implements OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                long arg3) {
            CityModel cityModel = (CityModel) mCityLit.getAdapter()
                    .getItem(pos);
            if (cityModel != null) {
                //Setting---SP存储工具类
//                Setting.Save2SharedPreferences(CityList.this, "city",
//                        cityModel.getCityName().substring(0,2));
                SpUtil.getInstance(MyApplication.getmContext()).save("city",cityModel.getCityName().substring(0,2));
                Intent intent = new Intent();
                intent.putExtra("city", cityModel.getCityName().substring(0,2));
                setResult(2, intent);
                finish();
            }
        }

    }

    /**
     * ListView
     *
     * @param list
     */
    private void setAdapter(List<CityModel> list) {
        if (list != null) {
            adapter = new ListAdapter(this, list);
            mCityLit.setAdapter(adapter);
        }

    }

    /**
     * ListViewAdapter
     *
     * @author gugalor
     */
    private class ListAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private List<CityModel> list;

        public ListAdapter(Context context, List<CityModel> list) {

            this.inflater = LayoutInflater.from(context);
            this.list = list;
            alphaIndexer = new HashMap<String, Integer>();
            sections = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                //
                // getAlpha(list.get(i));
                String currentStr = list.get(i).getNameSort();
                //
                String previewStr = (i - 1) >= 0 ? list.get(i - 1)
                        .getNameSort() : " ";
                if (!previewStr.equals(currentStr)) {
                    String name = list.get(i).getNameSort();
                    alphaIndexer.put(name, i);
                    sections[i] = name;
                }
            }

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.public_cityhot_item,
                        null);
                holder = new ViewHolder();
                holder.alpha = (TextView) convertView.findViewById(R.id.alpha);
                holder.name = (TextView) convertView
                        .findViewById(R.id.public_cityhot_item_textview);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.name.setText(list.get(position).getCityName());
            String currentStr = list.get(position).getNameSort();
            String previewStr = (position - 1) >= 0 ? list.get(position - 1)
                    .getNameSort() : " ";
            if (!previewStr.equals(currentStr)) {
                holder.alpha.setVisibility(View.VISIBLE);
                holder.alpha.setText(currentStr);
            } else {
                holder.alpha.setVisibility(View.GONE);
            }
            return convertView;
        }

        private class ViewHolder {
            TextView alpha;
            TextView name;
        }

    }

    // ’
    private void initOverlay() {
        LayoutInflater inflater = LayoutInflater.from(this);
        overlay = (TextView) inflater.inflate(R.layout.overlay, null);
        overlay.setVisibility(View.INVISIBLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        windowManager = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(overlay, lp);
    }

    @Override
    protected void onDestroy() {
        windowManager.removeView(overlay);
        super.onDestroy();
    }

    private class LetterListViewListener implements
            MyLetterListView.OnTouchingLetterChangedListener {

        @Override
        public void onTouchingLetterChanged(final String s) {
            if (alphaIndexer.get(s) != null) {
                int position = alphaIndexer.get(s);
                mCityLit.setSelection(position);
                overlay.setText(sections[position]);
                overlay.setVisibility(View.VISIBLE);
                handler.removeCallbacks(overlayThread);
                // Уoverlay
                handler.postDelayed(overlayThread, 1500);
            }
        }

    }

    // overlay
    private class OverlayThread implements Runnable {

        @Override
        public void run() {
            overlay.setVisibility(View.GONE);
        }

    }

}