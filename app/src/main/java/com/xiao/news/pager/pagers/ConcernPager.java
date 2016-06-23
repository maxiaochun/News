package com.xiao.news.pager.pagers;

import android.view.LayoutInflater;
import android.view.View;

import com.xiao.news.R;
import com.xiao.news.pager.BaseFragment;

/**
 * Created by hasee on 2016/6/17.
 */
public class ConcernPager extends BaseFragment {


    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.pager_concern, null);

        return view;
    }

    @Override
    public void initData() {

    }
}
