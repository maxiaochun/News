package com.xiao.news.Utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hasee on 2016/6/21.
 */
public class HttpUtil {

    private static String result;

    public static void getDataFromService(final String url, final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                request(url, handler);
            }
        }).start();
    }


    /**
     * @return 返回结果
     */
    public static void request(String url, Handler handler) {
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();

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
//            processData(result);

            Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("content",result); //将数据绑定到bundle
            msg.setData(bundle);//将bundle传递到message
            handler.sendMessage(msg);//发送到主线程
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析数据
     *//*

    private static void processData(String json) {
        Gson gson = new Gson();
        mNewTabData = gson.fromJson(json, NewsTabBean.class);
        mNewsData = mNewTabData.getNewslist();
    }*/
}