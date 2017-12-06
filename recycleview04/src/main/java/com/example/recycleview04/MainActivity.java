package com.example.recycleview04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.recycleview04.adapter.Myadapter;
import com.example.recycleview04.net.Databean;
import com.example.recycleview04.net.OkhttpUntils;
import com.example.recycleview04.picture.Imagelist;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private Myadapter myadapter;
    private List<String> list2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<Imagelist.imageThumbUrls.length;i++){
            list2.add(Imagelist.imageThumbUrls[i]);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);

        myadapter = new Myadapter(this, list2);

        recyclerView.setAdapter(myadapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        myadapter.setMyonitem(new Myadapter.Myonitem() {
            @Override
            public void onitemClick(int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
                myadapter.add();

            }

            @Override
            public void onitemLongClick() {
                Toast.makeText(MainActivity.this,"长安",Toast.LENGTH_SHORT).show();
                myadapter.remove();
            }
        });
    }


}
