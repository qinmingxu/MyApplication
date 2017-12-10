package com.example.mvp02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp02.presenter.RegPresenter;
import com.example.mvp02.view.MainListener;
import com.example.mvp02.view.SecondActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainListener {

    private String path = "http://120.27.23.105/user/reg";
    /**
     * 开始请求
     */
    private Button mButton;
    /**
     * 请输入账号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        regPresenter = new RegPresenter(this);
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                regPresenter.register();
                break;
        }
    }
    public String getPhone(){
        return mPhone.getText().toString().trim();
    }
    public String getPwd(){
        return mPwd.getText().toString().trim();
    }

    public void goTo(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }


    public void show(String string){
        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        regPresenter.deach();

    }
}
