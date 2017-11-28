package com.example.wan.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText phone;
    private EditText pwd;
    private OkHttpClient client;
    private  String path = "http://120.27.23.105/user/login?mobile=%s&password=%s";
    private String sphone;
    private String spwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.mobile);
        pwd = (EditText) findViewById(R.id.pwd);

        client = new OkHttpClient();
    }
    public void button1(View v){
        sphone = phone.getText().toString().trim();
        spwd = pwd.getText().toString().trim();
        if(isChinaPhoneLegal(sphone)&&isPwd(spwd)){
            String url = String.format(path,sphone,spwd);

            Request request = new Request.Builder().url(url).build();
            client.newCall(request).enqueue(new Callback() {

                private String string;

                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    string = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, string,Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            });
        }else {
            Toast.makeText(MainActivity.this,"格式不正确",Toast.LENGTH_SHORT).show();
        }

    }

    public void button2(View v){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
    private boolean isPwd(String spwd){
        int length = spwd.length();
        if(length<6){
            return false;
        }
        return true;
    }
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
