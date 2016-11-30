package com.atguigu.catmovie;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.atguigu.catmovie.movie.CinemaFragment;
import com.atguigu.catmovie.movie.FindFragment;
import com.atguigu.catmovie.movie.MeFragment;
import com.atguigu.catmovie.movie.MovieFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

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
    private MovieFragment movieFragment;
    private CinemaFragment cinemaFragment;

    private FindFragment findFragment;
    private MeFragment meFragment;
    private FragmentTransaction transaction;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
        rgMain.check(R.id.rb_movie);

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

}
