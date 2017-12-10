package com.example.mvp02.model;

import android.os.Handler;
import android.util.Log;

import com.example.mvp02.net.OkHttpUtils;
import com.example.mvp02.net.onNetListener;
import com.example.mvp02.presenter.Api;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by wan on 2017/12/9.
 */

public class RegisterModel implements RegisterListener{
    private Handler handler = new Handler();
    public void register(Map<String,String> parms, final onNetListener onNetListener){
        OkHttpUtils.getOkHttpUtils().doPost(Api.REGISTER, parms, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onNetListener.onfailue(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(string);
                    }
                });
            }
        });
    }
}
