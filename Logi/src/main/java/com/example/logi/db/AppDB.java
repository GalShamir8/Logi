package com.example.logi.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.logi.models.Logger;
import com.example.logi.services.LoggerDao;

@Database(entities = {Logger.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract LoggerDao loggerDao();
}
