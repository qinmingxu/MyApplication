package com.example.okhttpfengzhuang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.okhttpfengzhuang.net.HttpUtils;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 开始请求
     */
    private Button mButton;
    private RelativeLayout mActivityMain;
    private String path="http://120.27.23.105/user/login?mobile=15701577141&password=123456";
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                //http://120.27.23.105/user/login
                client = new OkHttpClient();
                //method1();
                //method2();
                //method3();
                //method4();
                method5();
                break;
        }
    }

    private void method5() {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile","15701577141");
        map.put("password","123456");
        HttpUtils.getHttpUtils().doPost("http://120.27.23.105/user/login", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("sdghgfjgdhre",response.body().string());

            }
        });
    }

    private void method4() {
        HttpUtils.getHttpUtils().doGet(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("sdghgfjgdhre",response.body().string());

            }
        });
    }

    private void method3() {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("mobile","15701577141");
        builder.add("password","123456");
        FormBody body = builder.build();
        Request request = new Request.Builder().url("http://120.27.23.105/user/login").post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("sdghgfjgdhre",response.body().string());
            }
        });
    }

    private void method2() {
        Request request = new Request.Builder().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("sdghgfjgdhre",response.body().string());
            }
        });
    }

    private void method1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Request request = new Request.Builder().url(path).build();
                    Response response = client.newCall(request).execute();

                    Log.e("sdghgfjgdhre",response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
