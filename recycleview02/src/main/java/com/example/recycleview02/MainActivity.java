package com.example.recycleview02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.recycleview02.adapter.Myadapter;
import com.example.recycleview02.net.Databean;
import com.example.recycleview02.net.OkhttpUntils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    List<Databean.DataBean> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private String path = "http://120.27.23.105/product/getCatagory";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        Myadapter myadapter = new Myadapter(MainActivity.this, list);
        recyclerView.setAdapter(myadapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void getData() {
        OkhttpUntils.getOkhttpUntils().doGet(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                Gson gson = new Gson();
                Databean databean = gson.fromJson(string, Databean.class);
                list.addAll(databean.getData());
            }
        });
    }
}
