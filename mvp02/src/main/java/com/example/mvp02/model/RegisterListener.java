package com.example.mvp02.model;

import com.example.mvp02.net.onNetListener;

import java.util.Map;

/**
 * Created by wan on 2017/12/9.
 */

public interface RegisterListener {
    public void register(Map<String,String> parms, final onNetListener onNetListener);
}
