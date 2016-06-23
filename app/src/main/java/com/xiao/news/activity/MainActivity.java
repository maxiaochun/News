package com.xiao.news.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xiao.news.R;
import com.xiao.news.pager.pagers.ConcernPager;
import com.xiao.news.pager.pagers.HomePager;
import com.xiao.news.pager.pagers.MinePager;
import com.xiao.news.pager.pagers.VideoPager;


    /**
     * Created by hasee on 2016/6/16.
     */
    public  class MainActivity extends FragmentActivity {

        private FrameLayout mViewPager;
        private RadioGroup mRadioGroup;
        private long exitTime;
        private HomePager homePager;
        private VideoPager videoPager;
        private ConcernPager concernPager;
        private MinePager minePager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mViewPager = (FrameLayout) findViewById(R.id.fragment_container);
            mRadioGroup = (RadioGroup) findViewById(R.id.rg_group);
            initData();
        }


        private void initData() {
            //手动加载第一页数据
            select(0);

            mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i) {
                        case R.id.rb_home:
                            select(0);
                            break;
                        case R.id.rb_video:
                            select(1);
                            break;
                        case R.id.rb_concern:
                            select(2);
                            break;
                        case R.id.rb_mine:
                            select(3);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        private void select(int i) {
            FragmentManager fm = getSupportFragmentManager();  //获得Fragment管理器
            FragmentTransaction ft = fm.beginTransaction(); //开启一个事务

            hidtFragment(ft);   //先隐藏 Fragment

            switch (i) {
                case 0:
                    if (homePager == null) {
                        homePager = new HomePager();
                        ft.replace(R.id.fragment_container, homePager);
                    } else {
                        ft.show(homePager);
                    }
                    break;
                case 1:
                    if (videoPager == null) {
                        videoPager = new VideoPager();
                        ft.add(R.id.fragment_container, videoPager);
                    } else {
                        ft.show(videoPager);
                    }
                    break;
                case 2:
                    if (concernPager == null) {
                        concernPager = new ConcernPager();
                        ft.add(R.id.fragment_container, concernPager);
                    } else {
                        ft.show(concernPager);
                    }
                    break;
                case 3:
                    if (minePager == null) {
                        minePager = new MinePager();
                        ft.add(R.id.fragment_container, minePager);
                    } else {
                        ft.show(minePager);
                    }
                    break;
            }
            ft.commit();   //提交事务
        }

        //隐藏所有Fragment
        private void hidtFragment(FragmentTransaction fragmentTransaction) {
            if (homePager != null) {
                fragmentTransaction.hide(homePager);
            }
            if (videoPager != null) {
                fragmentTransaction.hide(videoPager);
            }
            if (concernPager != null) {
                fragmentTransaction.hide(concernPager);
            }
            if (minePager != null) {
                fragmentTransaction.hide(minePager);
            }
        }
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK
                    && event.getAction() == KeyEvent.ACTION_DOWN) {
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                } else {
                    finish();
                }
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }

    }

