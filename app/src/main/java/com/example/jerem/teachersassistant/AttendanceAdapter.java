package com.example.jerem.teachersassistant;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by jerem on 24-01-2017.
 */

public class AttendanceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity context;
    ArrayList<String> attendenceArray;
    public int count = 0;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    public int mTotalCount = 13;

    public AttendanceAdapter(Activity context, ArrayList<String> attendenceArray) {
        this.context = context;
        this.attendenceArray = attendenceArray;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_view, parent, false);
            return new AttendanceViewHolderTwo(view);
        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attendance, parent, false);
            return new AttendanceViewHolder(view);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AttendanceViewHolder) {
            ((AttendanceViewHolder) holder).mStudentRollNo.setText(attendenceArray.get(position).toString());
        }else if (holder instanceof AttendanceViewHolderTwo){

            ((AttendanceViewHolderTwo) holder).mAbsent.setText(String.valueOf(count));
            ((AttendanceViewHolderTwo) holder).mPresent.setText(String.valueOf(mTotalCount));
        }

    }





    @Override
    public int getItemCount() {
        return attendenceArray.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)){
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position){
        return position ==0;
    }

    public void updateData(ArrayList<String> map){
        notifyDataSetChanged();

    }
    public class AttendanceViewHolder extends RecyclerView.ViewHolder {

        public ImageView mStudentImage;
        public TextView mStudentRollNo;


        public AttendanceViewHolder(View itemView) {
            super(itemView);
            mStudentImage = (ImageView) itemView.findViewById(R.id.student_image);
            mStudentRollNo = (TextView) itemView.findViewById(R.id.student_rno);
            mStudentImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    absent();
                    present();
                }
            });

        }


        public void absent() {
            if (count >=0) {
                count++;
                updateData(attendenceArray);
            }
        }
        public void present() {
            if (mTotalCount>=0) {
                mTotalCount--;
                updateData(attendenceArray);
            }
        }


    }
    public class AttendanceViewHolderTwo extends RecyclerView.ViewHolder {

        TextView mTotal;
        TextView mPresent;
        TextView mAbsent;

        public AttendanceViewHolderTwo(View itemView) {
            super(itemView);
            mTotal = (TextView) itemView.findViewById(R.id.Textview5);
            mPresent = (TextView) itemView.findViewById(R.id.Textview6);
            mAbsent = (TextView) itemView.findViewById(R.id.Textview7);

        }

    }

}