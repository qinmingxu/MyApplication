package com.example.okhttpfengzhuang.net;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by wan on 2017/11/30.
 */

public class HttpUtils {
    private static HttpUtils httpUtils;
    private final OkHttpClient client;

    private HttpUtils(){
        client = new OkHttpClient();
    };

    public static HttpUtils getHttpUtils(){
        if(httpUtils==null){
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils= new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    public void doGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
    public void doPost(String url, Map<String,String> parms,Callback  callback){
        if(parms==null){
            //throw new RuntimeException("参数不能为空");
            return;
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry:parms.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        client.newCall(request).enqueue(callback);
    }
}
