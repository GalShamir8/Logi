package com.example.logiui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logi.common.LoggerHelper;
import com.example.logi.models.Logger;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView base_LBL_getAllLogs;
    TextView base_LBL_deleteAllLogs;
    SearchView base_search_logs;
    LoggerHelper loggerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loggerHelper = LoggerHelper.getInstance();
    }

    private void initViews() {
        base_LBL_getAllLogs =  findViewById(R.id.base_LBL_getAllLogs);
        base_LBL_deleteAllLogs =  findViewById(R.id.base_LBL_deleteAllLogs);
        base_search_logs =  findViewById(R.id.base_search_logs);
        setListeners();
    }

    private void setListeners() {
        base_LBL_getAllLogs.setOnClickListener(e -> getLogs());
        base_LBL_deleteAllLogs.setOnClickListener(e -> deleteLogs());
    }

    private void deleteLogs() {
    }

    private void getLogs() {
        ArrayList<Logger> logs = new ArrayList<>();
        loggerHelper.getAll(params -> {
            logs.addAll((ArrayList<Logger>) params[0]);
            return true;
        });
        for (Logger l: logs){
            Toast.makeText(this, l.getMsg(), Toast.LENGTH_LONG).show();
        }
    }
}