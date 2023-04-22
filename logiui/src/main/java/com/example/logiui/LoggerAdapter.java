package com.example.logiui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logi.models.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LoggerAdapter extends RecyclerView.Adapter<LoggerAdapter.ViewHolder> {

    private List<Logger> logList;

    public LoggerAdapter(List<Logger> logList) {
        this.logList = logList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_log, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Logger log = logList.get(position);
        holder.tagTextView.setText(log.getTag());
        holder.msgTextView.setText(log.getMsg());
        holder.timeTextView.setText(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).format(new Date(log.getTimestamp())));
    }

    @Override
    public int getItemCount() {
        return logList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tagTextView;
        TextView msgTextView;
        TextView timeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            tagTextView = itemView.findViewById(R.id.tagTextView);
            msgTextView = itemView.findViewById(R.id.msgTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }
}

