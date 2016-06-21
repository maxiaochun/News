package com.xiao.news.pager.channels;

import android.view.View;

import com.xiao.news.R;
import com.xiao.news.pager.BaseFragment;

/**
 * Created by hasee on 2016/6/21.
 */
public class GuoneiFragment extends BaseFragment {


    /*public GuoneiFragment(String url) {
        this.url = url;
    }*/

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.news_guonei, null);
        return view;

    }

    @Override
    public void initData() {

    }
}
