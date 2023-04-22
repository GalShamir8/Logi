package com.example.logiui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.logi.common.LoggerHelper;
import com.example.logi.models.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView base_LBL_getAllLogs;
    private TextView base_LBL_deleteAllLogs;
    private SearchView base_search_logs;
    private LoggerHelper loggerHelper;
    private RecyclerView recyclerView;
    private List<Logger> logsCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loggerHelper = LoggerHelper.getInstance();
        logsCollection = new ArrayList<>();
    }

    private void initViews() {
        base_LBL_getAllLogs = findViewById(R.id.base_LBL_getAllLogs);
        base_LBL_deleteAllLogs = findViewById(R.id.base_LBL_deleteAllLogs);
        base_search_logs = findViewById(R.id.base_search_logs);
        recyclerView = findViewById(R.id.main_card_recycle_logs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setListeners();
    }

    private void setListeners() {
        base_LBL_getAllLogs.setOnClickListener(e -> getAllLogs());
        base_LBL_deleteAllLogs.setOnClickListener(e -> deleteLogs());
    }

    private void deleteLogs() {
    }

    private void getAllLogs() {
        loggerHelper.getAll(params -> {
            assert params[0] instanceof Collection;
            runOnUiThread(() -> {
                logsCollection.addAll((ArrayList<Logger>) params[0]);
                recyclerView.setAdapter(new LoggerAdapter(logsCollection));
            });
            return true;
        });
    }
}