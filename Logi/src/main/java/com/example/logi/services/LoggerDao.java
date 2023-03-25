package com.example.logi.services;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.logi.models.Logger;

import java.util.List;

@Dao
public interface LoggerDao {
    @Query("SELECT * FROM logs")
    List<Logger> getAll();

    @Query("SELECT * FROM logs WHERE id IN (:loggerIds)")
    List<Logger> loadAllByIds(int[] loggerIds);

    @Query("SELECT * FROM logs WHERE tag LIKE :tag LIMIT 1")
    Logger findByTag(String tag);

    @Query("SELECT * FROM logs WHERE timestamp > :timestamp ")
    List<Logger> findFromDate(long timestamp);

    @Query("SELECT * FROM logs WHERE timestamp BETWEEN :startTimeStamp AND :endTimeStamp")
    List<Logger> findBetweenDate(long startTimeStamp, long endTimeStamp);

    @Insert
    void insertAll(Logger... logs);

    @Insert
    void insert(Logger log);

    @Delete
    void delete(Logger log);
}

