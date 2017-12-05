package com.example.day07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i=1/0;
    }
    /*public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {

        private XListView xListView;
        private int page = 1;

        //装页面展示所有数据的集合
        private List<DataDataBean.DataBean> list = new ArrayList<>();
        private MyAdapter myAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            xListView = (XListView) findViewById(R.id.x_listview);

            //设置
            xListView.setPullLoadEnable(true);
            xListView.setPullRefreshEnable(true);

            //获取网络上的数据
            getDataFromNet();

            //设置监听
            xListView.setXListViewListener(this);

        }

        *//**
         * 获取网络数据
         *//*
        private void getDataFromNet() {
            AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {

                    String path = "http://www.yulin520.com/a2a/impressApi/news/mergeList?pageSize=10&page="+page;
                    try {
                        URL url = new URL(path);

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        //设置
                        connection.setRequestMethod("GET");
                        connection.setReadTimeout(5000);
                        connection.setConnectTimeout(5000);

                        //获取
                        int responseCode = connection.getResponseCode();
                        if (responseCode == 200){
                            InputStream inputStream = connection.getInputStream();

                            String json = streamToString(inputStream,"utf-8");

                            return json;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return "";
                }

                @Override
                protected void onPostExecute(String json) {
                    Gson gson = new Gson();
                    DataDataBean dataDataBean = gson.fromJson(json, DataDataBean.class);


                    //添加
                    list.addAll(dataDataBean.getData());

                    //设置适配器
                    setAdapter();

                    //加载完成之后
                    xListView.stopLoadMore();
                }
            };

            asyncTask.execute();

        }

        *//**
         * 设置适配器
         *//*
        private void setAdapter() {
            if (myAdapter == null){

                myAdapter = new MyAdapter(MainActivity.this,list);
                xListView.setAdapter(myAdapter);
            }else {
                myAdapter.notifyDataSetChanged();
            }
        }

        *//**
         * 下拉刷新
         *//*
        @Override
        public void onRefresh() {
            getRefreshData();
        }

        private void getRefreshData() {
            AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {
                    //下拉刷新的时候之请求第一页的数据
                    String path = "http://www.yulin520.com/a2a/impressApi/news/mergeList?pageSize=10&page=1";
                    try {
                        URL url = new URL(path);

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        //设置
                        connection.setRequestMethod("GET");
                        connection.setReadTimeout(5000);
                        connection.setConnectTimeout(5000);

                        //获取
                        int responseCode = connection.getResponseCode();
                        if (responseCode == 200){
                            InputStream inputStream = connection.getInputStream();

                            String json = streamToString(inputStream,"utf-8");

                            return json;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return "";
                }

                @Override
                protected void onPostExecute(String json) {
                    Gson gson = new Gson();
                    DataDataBean dataDataBean = gson.fromJson(json, DataDataBean.class);


                    //添加
                    list.addAll(0,dataDataBean.getData());

                    //设置适配器
                    setAdapter();

                    //刷新完成之后
                    xListView.stopRefresh();
                    xListView.setRefreshTime("刚刚");
                }
            };

            asyncTask.execute();
        }

        *//**
         * 上拉加载更多
         *//*
        @Override
        public void onLoadMore() {
            page ++;
            getDataFromNet();
        }

        private String streamToString(InputStream inputStream,String charset) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charset);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s = null;
                StringBuilder builder = new StringBuilder();
                while ((s = bufferedReader.readLine()) != null){
                    builder.append(s);
                }

                bufferedReader.close();
                return builder.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return  null;
        }
    }*/

}
