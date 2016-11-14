package com.swjtu.deanstar.testbed;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread(){

            @Override
            public void run(){

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我在执行啊");
            }
        };
        t.start();
        t = null;
        System.gc();
    }
}
