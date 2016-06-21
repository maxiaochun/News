package com.xiao.news.Utils;

/**
 * Created by hasee on 2016/6/21.
 */
public class UrlUtils {
    /**
     * 服务器主域名
     */
    public static final String HTTPURL = "http://apis.baidu.com/showapi_open_bus/channel_news/search_news";

    /**
     * 各频道url
     */
    public static final String GUONEI = HTTPURL + "?" + "channelId=5572a109b3cdc86cf39001db&page=1&needContent=0&needHtml=0";
    public static final String GUOJI = HTTPURL + "?" + "channelId=5572a108b3cdc86cf39001ce&page=1&needContent=0&needHtml=0";
    public static final String JUNSHI = HTTPURL + "?" + "channelId=5572a108b3cdc86cf39001cf&page=1&needContent=0&needHtml=0";
    public static final String CAIJING = HTTPURL + "?" + "channelId=5572a108b3cdc86cf39001d0&page=1&needContent=0&needHtml=0";
    public static final String YULE = HTTPURL + "?" + "channelId=5572a108b3cdc86cf39001d5&page=1&needContent=0&needHtml=0";


}
