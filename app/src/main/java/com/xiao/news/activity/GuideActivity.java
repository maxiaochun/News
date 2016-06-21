package com.xiao.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xiao.news.R;
import com.xiao.news.Utils.GlobalConstants;
import com.xiao.news.Utils.PrefUtils;

import java.util.ArrayList;

/**
 * Created by hasee on 2016/6/16.
 */
public class GuideActivity extends Activity {

    private ViewPager mViewPager;
    private Button mStart;
    private LinearLayout mContainer;
    private ImageView mRedPoint;
    private ArrayList<ImageView> mImageViewList;//ViewPager图片的imageview集合
    private int[] mImageIDs;
    private int mPointDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        initData();
        mViewPager.setAdapter(new MyAdapter());

        //viewpager页面变化监听事件
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //滑动时小红点跟随移动
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //页面滑动过程中的回调
//                Log.e("test","当前位置："+position+";移动偏移百分比："+positionOffset);
                //更新小红点的距离
                int leftMargin = (int) (mPointDis * positionOffset + position * mPointDis);
                //获取布局参数
                RelativeLayout.LayoutParams params =
                        (RelativeLayout.LayoutParams) mRedPoint.getLayoutParams();
                params.leftMargin = leftMargin;//修改左边距
                mRedPoint.setLayoutParams(params);//重新设置左边距

            }

            //滑到最后一页显示按钮
            @Override
            public void onPageSelected(int position) {

                if (position == mImageViewList.size() - 1) {
                    mStart.setVisibility(View.VISIBLE);
                } else {
                    mStart.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //移除监听，避免重复回调
                mRedPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //layout方法执行结束的回调
                // 小红点移动距离 计算两个圆点的距离，=第二个圆点left值- 第一个圆点left值
                mPointDis = mContainer.getChildAt(1).getLeft()
                        - mContainer.getChildAt(0).getLeft();
            }
        });

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //更新sp
                PrefUtils.setBoolean(getApplicationContext(), GlobalConstants.IS_FIRST_ENTER, false);
                //跳转到主页面
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }


    /**
     * 初始化控件
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        mStart = (Button) findViewById(R.id.btn_start);
        mContainer = (LinearLayout) findViewById(R.id.ll_container);
        mRedPoint = (ImageView) findViewById(R.id.iv_red_point);
    }

    /**
     * 初始化数据（图片，小圆点）
     */
    private void initData() {
        //封装viewpager展示的图片
        mImageIDs = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
        //将图片转换成ImageView封装成集合
        mImageViewList = new ArrayList<>();

        for (int i = 0; i < mImageIDs.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageIDs[i]);
            mImageViewList.add(imageView);

            //初始化小白点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.shape_point_gray);

            //设置左边距
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (i > 0) {
                params.leftMargin = 20;
            }
            point.setLayoutParams(params);//设置小白点参数
            mContainer.addView(point);//给容器添加小白点

        }
    }

    /**
     * ViewPager的adapter
     */
    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //初始化view
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = mImageViewList.get(position);
            container.addView(view);
            return view;
        }

        //销毁item
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
