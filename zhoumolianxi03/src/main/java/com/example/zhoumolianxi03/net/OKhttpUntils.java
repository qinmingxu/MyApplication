package com.example.zhoumolianxi03.net;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by wan on 2017/12/3.
 */

public class OKhttpUntils  {
    private static OKhttpUntils oKhttpUntils;
    private final OkHttpClient client;

    private OKhttpUntils(){
        client = new OkHttpClient();
    }
    public static OKhttpUntils getHttpUtils(){
        if(oKhttpUntils==null){
            synchronized (OKhttpUntils.class){
                if(oKhttpUntils==null){
                    oKhttpUntils = new OKhttpUntils();
                }
            }
        }
        return oKhttpUntils;
    }
    public void doGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
