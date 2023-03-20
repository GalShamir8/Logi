package com.example.logi.services;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.logi.models.Logger;

import java.util.List;

@Dao
public interface LoggerDao {
    @Query("SELECT * FROM logger")
    List<Logger> getAll();

    @Query("SELECT * FROM logger WHERE id IN (:loggerIds)")
    List<Logger> loadAllByIds(int[] loggerIds);

    @Query("SELECT * FROM logger WHERE tag LIKE :tag LIMIT 1")
    Logger findByTag(String tag);

    @Query("SELECT * FROM logger WHERE timestamp > :timestamp ")
    List<Logger> findFromDate(long timestamp);

    @Query("SELECT * FROM logger WHERE timestamp BETWEEN :startTimeStamp AND :endTimeStamp")
    List<Logger> findBetweenDate(long startTimeStamp, long endTimeStamp);

    @Insert
    void insertAll(Logger... logs);

    @Insert
    void insert(Logger log);

    @Delete
    void delete(Logger log);
}

