package com.xiao.news.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * sharePreference 封装
 * Created by hasee on 2016/6/16.
 */
public class PrefUtils {
    /** 从sharepreference 获取string类型数据*/
    public static String getString(Context ctx,String key,String value){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key,value);
    }

    /** 从sharepreference 存取string类型数据*/
    public static void setString(Context ctx,String key,String value){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

    /** 从sharepreference 获取boolean类型数据*/
    public static boolean getBoolean(Context ctx,String key,boolean defValue){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }

    /** 从sharepreference 存取boolean类型数据*/
    public static void setBoolean(Context ctx,String key,boolean value){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }

    /** 从sharepreference 获取int类型数据*/
    public static int getInt(Context ctx,String key,int defValue){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }

    /** 从sharepreference 存取int类型数据*/
    public static void setInt(Context ctx,String key,int value){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }

}
