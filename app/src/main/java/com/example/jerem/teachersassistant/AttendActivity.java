package com.example.jerem.teachersassistant;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class AttendActivity extends AppCompatActivity {

    public RecyclerView mRecycleView;
    public AttendanceAdapter mAdapter;
    public ArrayList<String> mArrayList;
    TextView mtotal,present,abscent;
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
        mAdapter.notifyDataSetChanged();


    }

    public void stu (View v){
        Toast.makeText(getApplicationContext(), "Attendance updated", Toast.LENGTH_SHORT).show();
    }
}
