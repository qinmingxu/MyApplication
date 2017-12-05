package com.example.recycleview03.net;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by wan on 2017/12/5.
 */

public class OkhttpUntils {
    private static OkhttpUntils okhttpUntils;
    private final OkHttpClient client;

    private OkhttpUntils(){
        client = new OkHttpClient();
    }
    public static OkhttpUntils getOkhttpUntils(){
        if(okhttpUntils==null){
            synchronized (OkhttpUntils.class){
                if(okhttpUntils==null){
                    okhttpUntils = new OkhttpUntils();
                }
            }
        }
        return okhttpUntils;
    }
    public void doGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
