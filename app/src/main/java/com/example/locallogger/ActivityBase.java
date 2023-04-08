package com.example.locallogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logi.common.Callable;
import com.example.logi.common.LoggerHelper;
import com.example.logi.models.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ActivityBase extends AppCompatActivity {
    TextView base_LBL_getAllLogs;
    TextView base_LBL_deleteAllLogs;
    TextView base_search_logs;
    LoggerHelper loggerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
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
        loggerHelper.getAll(new Callable() {
            @Override
            public Object setData(Object... params) {
                logs.addAll(Arrays.stream(params)
                        .map(param -> (Logger) param)
                        .collect(Collectors.toList()));
                return true;
            }
        });
        for (Logger l: logs){
            Toast.makeText(this, l.getMsg(), Toast.LENGTH_LONG).show();
        }
    }

}