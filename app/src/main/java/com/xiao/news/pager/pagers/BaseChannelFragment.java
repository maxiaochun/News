package com.xiao.news.pager.pagers;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.xiao.news.R;
import com.xiao.news.Utils.HttpUtil;
import com.xiao.news.Utils.UrlUtils;
import com.xiao.news.domin.NewsTabBean;
import com.xiao.news.pager.BaseFragment;

import java.util.List;

/**
 * Created by hasee on 2016/6/23.
 */
public class BaseChannelFragment extends BaseFragment {
    private ListView mListView;
    private List<NewsTabBean.NewslistBean> mContentList;
    private final String url;

    public BaseChannelFragment(String URL) {
        url = URL;
    }


    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            Toast.makeText(mActivity, "OK", Toast.LENGTH_SHORT).show();

            String json = msg.getData().getString("content");

            Gson gson = new Gson();
            NewsTabBean mContent = gson.fromJson(json, NewsTabBean.class);
            mContentList = mContent.getNewslist();
            mListView.setAdapter(new NewsAdapter());

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String mContentUrl = mContentList.get(i).getUrl();
                    Uri uri = Uri.parse(mContentUrl);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);

                }
            });
        }
    };

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(mActivity, R.layout.news_guoji, null);
        mListView = (ListView) view.findViewById(R.id.lv_guoji);
        return view;

    }

    @Override
    public void initData() {

        HttpUtil.getDataFromService(url, mHandler);

    }


    public class NewsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mContentList.size();
        }

        @Override
        public Object getItem(int i) {
            return mContentList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int positon, View convertView, ViewGroup viewGroup) {


            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(mActivity, R.layout.news_item, null);
                holder = new ViewHolder();
                holder.pic = (ImageView) convertView.findViewById(R.id.iv_pic);
                holder.title = (TextView) convertView.findViewById(R.id.tv_title);
                holder.ctime = (TextView) convertView.findViewById(R.id.tv_ctime);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(mContentList.get(positon).getTitle());
            holder.ctime.setText(mContentList.get(positon).getCtime());

            Glide.with(mActivity)
                    .load(mContentList.get(positon).getPicUrl())
                    .into(holder.pic);
            return convertView;
        }
    }

    static class ViewHolder {
        TextView title;
        TextView ctime;
        ImageView pic;

    }

    //设置条目点击事件

}


