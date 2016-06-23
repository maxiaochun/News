package com.xiao.news.pager.channels;

import android.view.LayoutInflater;
import android.view.View;

import com.xiao.news.R;
import com.xiao.news.pager.BaseFragment;

/**
 * Created by hasee on 2016/6/21.
 */
public class GuojiFragment extends BaseFragment {


    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(mActivity, R.layout.news_guoji, null);
        return view;

    }

    @Override
    public void initData() {

    }
}
