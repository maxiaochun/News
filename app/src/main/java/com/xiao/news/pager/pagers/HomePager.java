package com.xiao.news.pager.pagers;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.viewpagerindicator.TabPageIndicator;
import com.xiao.news.R;
import com.xiao.news.pager.BaseFragment;
import com.xiao.news.pager.channels.CaijingFragment;
import com.xiao.news.pager.channels.GuojiFragment;
import com.xiao.news.pager.channels.GuoneiFragment;
import com.xiao.news.pager.channels.JunshiFragment;
import com.xiao.news.pager.channels.YuleFragment;

import java.util.ArrayList;

/**
 * Created by hasee on 2016/6/17.
 */
public class HomePager extends BaseFragment {


    private static final String TAG = "HomePager";
    private TabPageIndicator mIndicator;//页签指示器
    private ImageButton mAdd;//添加按钮
    private ImageButton mQuery;//查询按钮
    private ViewPager mNewsDetailViewPager;//新闻详情viewpager
    private String[] PageTitle;//页签内容
    private ArrayList<BaseFragment> mChannelList; //每个频道pager的集合



    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_home, null);
        mIndicator = (TabPageIndicator) view.findViewById(R.id.indicator);
        mAdd = (ImageButton) view.findViewById(R.id.ib_add);
        mQuery = (ImageButton) view.findViewById(R.id.ib_query);
        mNewsDetailViewPager = (ViewPager)view.findViewById(R.id.vp_news_tab_detail);
        return view;
    }


    @Override
    public void initData() {

        //indicator 数据
        PageTitle = new String[]{"国内", "国际", "军事", "财经", "娱乐"};

        //viewpager数据
        mChannelList = new ArrayList<>();
        GuoneiFragment guoneiFragment = new GuoneiFragment();
        GuojiFragment guojiFragment = new GuojiFragment();
        JunshiFragment junshiFragment = new JunshiFragment();
        CaijingFragment caijingFragment = new CaijingFragment();
        YuleFragment yuleFragment = new YuleFragment();
        mChannelList.add(guojiFragment);
        mChannelList.add(guoneiFragment);
        mChannelList.add(junshiFragment);
        mChannelList.add(caijingFragment);
        mChannelList.add(yuleFragment);

        //设置viewpager适配器
        if (mIndicator == null){
            Log.e(TAG, "initData: null" );
        }
       mNewsDetailViewPager.setAdapter(new ChannelAdapter());
        mNewsDetailViewPager.setCurrentItem(0);

        //将viewpager和指示器绑定在一起
        mIndicator.setViewPager(mNewsDetailViewPager);

    }

    private class ChannelAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mChannelList.size();
        }


      /*  @Override
        public CharSequence getPageTitle(int position) {

            return PageTitle[position] ;//每个标签的名字
        }
*/

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BaseFragment fragment = mChannelList.get(position);
            View view = fragment.mRootView;
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}