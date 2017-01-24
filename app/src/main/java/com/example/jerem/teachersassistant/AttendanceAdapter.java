package com.example.jerem.teachersassistant;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jerem on 24-01-2017.
 */

public class AttendanceAdapter  extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {
Context context;
    ArrayList<String> attendenceArray;

    public AttendanceAdapter(Context context, ArrayList<String> attendenceArray){
this.context = context;
        this.attendenceArray=attendenceArray;
    }
    @Override
    public AttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attendance,parent,false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttendanceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AttendanceViewHolder extends RecyclerView.ViewHolder{

        public AttendanceViewHolder(View itemView) {
            super(itemView);
        }
    }
}
