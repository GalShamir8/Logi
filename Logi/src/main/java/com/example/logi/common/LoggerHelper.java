package com.example.logi.common;

import android.content.Context;

import androidx.room.Room;

import com.example.logi.models.Logger;
import com.example.logi.db.AppDB;
import com.example.logi.services.LoggerDao;

import java.util.Locale;

public class LoggerHelper {

    private final LoggerDao loggerDao;
    private static LoggerHelper instance = null;

    public static LoggerHelper getInstance(){
        return instance;
    }

    public static LoggerHelper init(Context ctx){
        if (instance == null)
            instance = new LoggerHelper(ctx);
        return instance;
    }

    private LoggerHelper(Context ctx) {
        loggerDao = Room
                .databaseBuilder(ctx, AppDB.class, "local-logger-db")
                .build()
                .loggerDao();
    }

    public void getAll(Callable callable) {
        new Thread(() -> callable.setData(loggerDao.getAll())).start();
    }

    public void loadAllByIds(int[] loggerIds, Callable callable) {
        new Thread(() -> callable.setData(loggerDao.loadAllByIds(loggerIds))).start();
    }

    public void findByTag(String tag, Callable callable) {
        new Thread(() -> callable.setData(loggerDao.findByTag(tag))).start();
    }

    public void findByTagStartWith(String tagPrefix, Callable callable) {
        String query = "%" + tagPrefix;
        new Thread(() -> callable.setData(loggerDao.findByTagStartsWith(query))).start();
    }

    public void findFromDate(long timestamp, Callable callable) {
        new Thread(() -> callable.setData(loggerDao.findFromDate(timestamp))).start();
    }

    public void findBetweenDate(long startTimeStamp, long endTimeStamp, Callable callable) {
        new Thread(() -> callable.setData(loggerDao.findBetweenDate(startTimeStamp, endTimeStamp))).start();
    }

    public void insertAll(Logger... logs) {
        new Thread(() -> loggerDao.insertAll(logs)).start();
    }

    public void insert(Logger log) {
        new Thread(() -> loggerDao.insert(log)).start();
    }

    public void delete(Logger log) {
        new Thread(() -> loggerDao.delete(log)).start();
    }

    public void deleteAll(Callable callable) {
        new Thread(() -> loggerDao.deleteAll()).start();
    }
}
