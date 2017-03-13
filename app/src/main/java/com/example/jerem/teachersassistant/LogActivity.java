package com.example.jerem.teachersassistant;

import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import static com.example.jerem.teachersassistant.R.id.e3;

public class LogActivity extends AppCompatActivity {
ArrayAdapter<String> a;
    Spinner s1;
    EditText e3;
    HttpClient httpclient;
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    String notes,returnedstring,Selection;
    CharSequence t1="invalid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        // Spinner element
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        e3 = (EditText) findViewById(R.id.e3);
        s1 = (Spinner) findViewById(R.id.spinner);
        // Spinner click listener
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();


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
        a=new ArrayAdapter<String>(LogActivity.this,android.R.layout.simple_spinner_item,categories);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s1.setAdapter(dataAdapter);
    }
    public void submit(View v){
        notes = e3.getText().toString();
        Selection = s1.getSelectedItem().toString();
        if(s1.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_LONG).show();
        }
        else {
            nameValuePairs = new ArrayList<NameValuePair>();
            httpclient = new DefaultHttpClient();
            response = new BasicResponseHandler();
            nameValuePairs.add(new BasicNameValuePair("Notes", notes));
            nameValuePairs.add(new BasicNameValuePair("Spinner", Selection));

            httppost = new HttpPost("http://10.0.2.2/log.php");
            try {
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                returnedstring = httpclient.execute(httppost, response);
                System.out.println("res" + returnedstring);

                if (returnedstring.equals("true")) {
                    Intent s = new Intent(LogActivity.this, MainActivity.class);
                    startActivity(s);
                } else {
                    Toast.makeText(getApplicationContext(), t1, Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

            /*Intent i = new Intent(register.this, CombinedActivity.class);
            startActivity(i);*/
}

