package com.estyle.kotlindemo;

import android.util.Log;

/**
 * Created by zhangyi on 2018/10/16.
 */
public class ZYLog {

    public static void e() {
        e("", "-------------------------------------------------------------------------");
    }

    public static void e(Object obj) {
        e("", obj);
    }

    public static void e(String tag, Object obj) {
        Log.e("zhangyi", tag + " -> " + obj);
    }

}
