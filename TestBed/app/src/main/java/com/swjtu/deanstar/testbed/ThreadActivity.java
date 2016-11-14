package com.swjtu.deanstar.testbed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadActivity extends AppCompatActivity {

    ExecutorService singleTaskExecutor = Executors.newSingleThreadExecutor();
    ExecutorService limitedTaskExecutor  = Executors.newFixedThreadPool(10);
    ExecutorService allTaskExecutor = Executors.newCachedThreadPool();
    ExecutorService scheduledTaskExecutor = Executors.newScheduledThreadPool(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
    }
}
