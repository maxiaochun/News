package com.xiao.news.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.xiao.news.R;
import com.xiao.news.pager.BasePager;
import com.xiao.news.pager.ConcernPager;
import com.xiao.news.pager.HomePager;
import com.xiao.news.pager.MinePager;
import com.xiao.news.pager.VideoPager;
import com.xiao.news.view.NoScrollViewPager;

import java.util.ArrayList;

/**
 * Created by hasee on 2016/6/16.
 */
public class MainActivity extends AppCompatActivity {

    private NoScrollViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private ArrayList<BasePager> mPagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mViewPager = (NoScrollViewPager) findViewById(R.id.vp_content);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_group);

        initData();

    }


    private void initData() {
        //封装四个页面
        mPagers = new ArrayList<>();
        mPagers.add(new HomePager(this));
        mPagers.add(new VideoPager(this));
        mPagers.add(new ConcernPager(this));
        mPagers.add(new MinePager(this));

        mViewPager.setAdapter(new MyAdapter());


        //手动加载第一页数据
        mPagers.get(0).initData();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_video:
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_concern:
                        mViewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_mine:
                        mViewPager.setCurrentItem(3, false);
                        break;

                    default:
                        break;
                }
            }
        });
    }


    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.mRootView;
            container.addView(view);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
