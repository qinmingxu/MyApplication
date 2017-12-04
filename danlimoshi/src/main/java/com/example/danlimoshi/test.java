package com.example.danlimoshi;

/**
 * Created by wan on 2017/11/30.
 */

public class test {
        public static void main(String[] args){
            SingleDemo instance = SingleDemo.getInstance();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleDemo instance1 = SingleDemo.getInstance();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleDemo instance1 = SingleDemo.getInstance();
                }
            }).start();
        }

}
