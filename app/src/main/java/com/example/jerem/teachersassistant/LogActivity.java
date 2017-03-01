package com.example.jerem.teachersassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class LogActivity extends AppCompatActivity {
ArrayAdapter<String> a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        // Spinner element
a=new ArrayAdapter<String>(LogActivity.this,android.R.layout.simple_spinner_item,categories);
        a.setDropDownViewResource(android.R.layout.simple_spinner_item,categories);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();
if(position==1)
{

}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("I CSE A");
        categories.add("I CSE B");
        categories.add("II CSE A");
        categories.add("II CSE B");
        categories.add("III CSE A");
        categories.add("III CSE B");
        categories.add("IV CSE A");
        categories.add("IV CSE B");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

}
