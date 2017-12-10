package com.example.mvp02.net;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by wan on 2017/12/9.
 */

public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private final OkHttpClient client;

    private OkHttpUtils (){
        client = new OkHttpClient.Builder().build();
    }

    public static OkHttpUtils getOkHttpUtils(){
        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils==null){
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    public void doGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    public void doPost(String url, Map<String,String> prams,Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry:prams.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        client.newCall(request).enqueue(callback);
    }
}
