package com.example.lanjieqi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请求网络
     */
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                addParmsPost();
                break;
        }
    }
    //post方法
    private void addParmsPost(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new MYinterceptor())
                .build();

        FormBody formBody = new FormBody.Builder().add("pid", "7").build();
        final Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/product/getProductDetail")
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("秦明旭秦明旭",string);
            }
        });
    }
//get方法
    private void addParms(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new MYinterceptor())
                .build();

        final Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/product/getProductDetail?pid=1")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("秦明旭秦明旭",string);
            }
        });
    }
    private void Myintercepter2(){
        final OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();

        final Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    private void Myintercepter(){
        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        final Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
