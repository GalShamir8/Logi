package com.example.locallogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.logi.common.Callable;
import com.example.logi.common.LoggerHelper;
import com.example.logi.models.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_BTN_click).setOnClickListener(e -> addLogs());
    }

    private void addLogs() {
        LoggerHelper.getInstance().insert(new Logger("pttt", "testLogger"));
    }
}