package com.xiao.news.pager;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hasee on 2016/6/17.
 */
public abstract class BaseFragment extends android.support.v4.app.Fragment {
    public View mRootView;
    public Activity mActivity;

    //Fragment创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //当前fragment依赖的activity
        mActivity = getActivity();
    }
    // 初始化fragment布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = initView(inflater);//当前页面布局
        return mRootView;
    }
    // fragment所依赖的activity的onCreate方法执行结束
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    //初始化布局
    public abstract View initView(LayoutInflater inflater) ;
    //初始化数据
    public abstract void initData();

    }


