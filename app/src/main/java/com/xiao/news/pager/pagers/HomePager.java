package com.xiao.news.pager.pagers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
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
    public View mRootView;

    private static final String TAG = "HomePager";
    private TabPageIndicator mIndicator;//页签指示器
    private ImageButton mAdd;//添加按钮
    private ImageButton mQuery;//查询按钮
    private ViewPager mNewsDetailViewPager;//新闻详情viewpager
    private String[] PageTitle;//页签内容


    private ArrayList<BaseFragment> mChannelList; //每个频道pager的集合

    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.pager_home, null);
        mIndicator = (TabPageIndicator) view.findViewById(R.id.indicator);
//        mAdd = (ImageButton) view.findViewById(R.id.ib_add);
//        mQuery = (ImageButton) view.findViewById(R.id.ib_query);
        mNewsDetailViewPager = (ViewPager) view.findViewById(R.id.vp_news_tab_detail);
        return view;
    }


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
        mChannelList.add(guoneiFragment);
        mChannelList.add(guojiFragment);
        mChannelList.add(junshiFragment);
        mChannelList.add(caijingFragment);
        mChannelList.add(yuleFragment);


        /**
         * to 老婆：
         * 当viewpager里面嵌套fragment时，viewpager的适配器必须继承FragmentPagerAdapter才有效果！！！
         * 适配器构造方法需要传入 FragmentManager 必须用getChildFragmentManager()这个方法才能有效果！！！
         * 这是系统源码规定的，不需要理解为什么
         * 可能是底层对嵌入fragment加入了特殊的优化，你就需要用对应的类才行
         */
        //设置viewpager适配器
        FragmentManager fm = getChildFragmentManager();  //获得Fragment管理器
        mNewsDetailViewPager.setAdapter(new ChannelAdapter(fm));
        mNewsDetailViewPager.setCurrentItem(0);


        //将viewpager和指示器绑定在一起
        mIndicator.setViewPager(mNewsDetailViewPager);

    }

    /**
     * to 老婆：
     * 当viewpager里面嵌套fragment时，viewpager的适配器必须继承FragmentPagerAdapter才有效果！！！
     */
    private class ChannelAdapter extends FragmentPagerAdapter {
        /**
         * 构造方法需要传入 FragmentManager
         * @param fm
         */
            public ChannelAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public int getCount() {
                return mChannelList.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mChannelList.get(arg0);
            }

        @Override
        public CharSequence getPageTitle(int position) {
            return PageTitle[position];
        }
        }
}