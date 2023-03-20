package com.example.logi.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "logger")
public class Logger {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tag;
    private String msg;
    private long timestamp;

    public Logger() { }

    public Logger(int id, String tag, String msg, long timestamp) {
        this.id = id;
        this.tag = tag;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
