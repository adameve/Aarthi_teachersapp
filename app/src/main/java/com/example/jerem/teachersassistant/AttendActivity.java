package com.example.jerem.teachersassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class AttendActivity extends AppCompatActivity {

    public RecyclerView mRecycleView;
    public AttendanceAdapter mAdapter;
    public ArrayList<String> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend);
        mRecycleView = (RecyclerView) findViewById(R.id.recycler_view);
        mArrayList  = new ArrayList<>();
        mArrayList.add("Jerry");
        mArrayList.add("Aarthi");
        mArrayList.add("Vinith");
        mArrayList.add("giri pragash");
        mArrayList.add("keerthi");
        mArrayList.add("ganga");
        mArrayList.add("gowsalya");
        mArrayList.add("gopi kannan");
        mArrayList.add("Akshykanna");
        mArrayList.add("karthick");
        mArrayList.add("Aishwarya");
        mArrayList.add("AncyMeja");
        mArrayList.add("Prasad thangavel");
        mAdapter    = new AttendanceAdapter(this,mArrayList);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(mAdapter);
    }
    public void stu (View v){
        Toast.makeText(getApplicationContext(), "Attendance updated", Toast.LENGTH_SHORT).show();
    }
}
