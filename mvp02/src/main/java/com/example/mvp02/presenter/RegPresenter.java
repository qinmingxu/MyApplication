package com.example.mvp02.presenter;

import android.util.Log;

import com.example.mvp02.MainActivity;
import com.example.mvp02.bean.Databean;
import com.example.mvp02.model.RegisterListener;
import com.example.mvp02.model.RegisterModel;
import com.example.mvp02.net.onNetListener;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by wan on 2017/12/9.
 */

public class RegPresenter {

    private MainActivity mainActivity;
    private final RegisterListener registerListener;

    public RegPresenter(MainActivity mainActivity){
        registerListener = new RegisterModel();
        this.mainActivity=mainActivity;
    }
    public void deach(){
        mainActivity=null;
    }
    public void register(){
        String phone = mainActivity.getPhone();
        String pwd = mainActivity.getPwd();
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile","15701577141");
        map.put("password","123456");

        registerListener.register(map, new onNetListener() {
            @Override
            public void onSuccess(String string) {
                Gson gson = new Gson();
                Databean databean = gson.fromJson(string, Databean.class);
                mainActivity.show(databean.getMsg());
                //Log.e("秦明旭秦明旭",string);
                //mainActivity.goTo();
            }

            @Override
            public void onfailue(Exception e) {
                Log.e("发生错误",e.toString());
            }
        });
    }
}
