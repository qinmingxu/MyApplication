package com.example.wan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends AppCompatActivity {

    private EditText mobile1;
    private EditText pwd1;
    private Button button;
    private String path="http://120.27.23.105/user/reg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mobile1 = (EditText) findViewById(R.id.mobile1);
        pwd1 = (EditText) findViewById(R.id.pwd1);
        button = (Button) findViewById(R.id.button);

        final OkHttpClient client = new OkHttpClient();
        button.setOnClickListener(new View.OnClickListener() {

            private String stringnews;

            @Override
            public void onClick(View v) {
                String name = mobile1.getText().toString().trim();
                String pass = pwd1.getText().toString().trim();
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("mobile",name);
                builder.add("password",pass);
                FormBody build = builder.build();
                Request request = new Request.Builder().url(path).post(build).build();
                client.newCall(request).enqueue(new Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        stringnews = response.body().string();
                        runOnUiThread(new Runnable() {


                            @Override
                            public void run() {
                                Toast.makeText(SecondActivity.this,stringnews,Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });
            }
        });
    }
}
