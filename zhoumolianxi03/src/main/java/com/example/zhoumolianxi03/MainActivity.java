package com.example.zhoumolianxi03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhoumolianxi03.bean.Databean;
import com.example.zhoumolianxi03.net.OKhttpUntils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private List<String> url;
    private List<String> data;
    private CustomView mybanner;
    private String path="http://120.27.23.105/ad/getAd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybanner = (CustomView) findViewById(R.id.mybanner);
        getData();
    }

    private void getData() {
        OKhttpUntils.getHttpUtils().doGet(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                data = new ArrayList<String>();
                url = new ArrayList<String>();
                Gson gson = new Gson();
                Databean databean = gson.fromJson(string, Databean.class);
                for (int i=0;i<databean.getData().size();i++){
                    data.add(databean.getData().get(i).getIcon());
                    url.add(databean.getData().get(i).getUrl());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mybanner.setData(data,url);
                    }
                });
            }
        });
    }


}
