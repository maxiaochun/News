package com.xiao.news.pager.pagers;

import android.view.View;

import com.xiao.news.R;
import com.xiao.news.pager.BaseFragment;

/**
 * Created by hasee on 2016/6/17.
 */
public class MinePager extends BaseFragment {



    public View initView(){
        View view = View.inflate(getActivity(),R.layout.pager_mine,null);

        return view;

    }

    @Override
    public void initData() {

    }
}
