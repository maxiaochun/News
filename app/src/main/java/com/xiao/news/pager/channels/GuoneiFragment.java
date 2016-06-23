package com.xiao.news.pager.channels;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xiao.news.R;
import com.xiao.news.domin.NewsTabBean;
import com.xiao.news.pager.BaseFragment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by hasee on 2016/6/21.
 */
public class GuoneiFragment extends BaseFragment {

    private static final String TAG = "GuoneiFragment";

    private String url;
    private String result;
    private NewsTabBean mNewTabData;
    private List<NewsTabBean.NewslistBean> mContentlist;
    private ListView mListView;
    private TextView mContent;

    public GuoneiFragment() {

//        this.url = url;
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mListView.setAdapter(new MyAdapter());

        }
    };


    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(mActivity, R.layout.news_guonei, null);
        mListView = (ListView) view.findViewById(R.id.lv_guonei);
        mContent = (TextView) view.findViewById(R.id.tv_content);
        return view;

    }

    @Override
    public void initData() {
        //获取数据
//        HttpUtil.getDataFromService(url,mHandler);
//        url = UrlUtils.GUONEI;
        url = "http://apis.baidu.com/txapi/social/social?num=10&page=1";
        new Thread(new Runnable() {
            @Override
            public void run() {
                request(url, mHandler);
            }
        }).start();
    }

    public void request(String url, Handler handler) {
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
//        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", "46f381e0f57b540e8e288081876bfbd1");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            processData(result);
          /*  Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("content", mContentList.toString());//将数据绑定到bundle
            msg.setData(bundle);//将bundle传递到message*/
            handler.sendEmptyMessage(0);//发送到主线程
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析数据
     */
    private void processData(String json) {
        Gson gson = new Gson();
        NewsTabBean mNewTabData = gson.fromJson(json, NewsTabBean.class);
        mContentlist = mNewTabData.getNewslist();


    }

    private class MyAdapter extends BaseAdapter {



        @Override
        public int getCount() {
            return mContentlist.size();
        }

        @Override
        public Object getItem(int i) {
            return mContentlist.get(i);
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

            }else {
               holder = (ViewHolder) convertView.getTag();
            }
//            holder.pic.setImageResource(mContentlist.get(positon).getPicUrl());
//            holder.pic.setImageResource(R.mipmap.ic_launcher);
            holder.title.setText(mContentlist.get(positon).getTitle());
            holder.ctime.setText(mContentlist.get(positon).getCtime());
            return convertView;
        }
    }

    static class ViewHolder {
        TextView title;
        TextView ctime;
        ImageView pic;

    }
}
