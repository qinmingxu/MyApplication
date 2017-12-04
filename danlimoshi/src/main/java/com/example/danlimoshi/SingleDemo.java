package com.example.danlimoshi;

/**
 * Created by wan on 2017/11/30.
 */

public class SingleDemo {
    private static SingleDemo singleDemo;
    private SingleDemo() {
        super();
    }

    public static SingleDemo getInstance(){
        if(singleDemo==null){
            synchronized (SingleDemo.class){
                if(singleDemo==null){
                    singleDemo= new SingleDemo();
                }

            }

        }
        return singleDemo;
    }
}
