package com.example.jerem.teachersassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import static com.example.jerem.teachersassistant.R.id.parent;
import static com.example.jerem.teachersassistant.R.id.radioButton1;
import static com.example.jerem.teachersassistant.R.id.update;

public class AttendanceActivity extends AppCompatActivity {
    Intent i;
    EditText e1;
    String date,sp1,sp2,sp3,sp4,sp5, sp6,returnedstring;
    String sRadioFirst,sRadioSecond,sRadioThird,sRadioFour,sRadioFive,sRadioSix,sRadioSeven,sRadioEight,sRadioNine,sRadioTen,sRadioEleven;
    ArrayAdapter<String> a, b, c, d, e,f;
    Spinner s1, s2, s3,s4, s5,s6;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11;
    HttpClient httpclient;
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    List<String> subject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        e1 = (EditText) findViewById(R.id.editText4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        s1 = (Spinner) findViewById(R.id.spinner8);
        s2 = (Spinner) findViewById(R.id.spinner9);
        s3 = (Spinner) findViewById(R.id.spinner10);
        s6 = (Spinner) findViewById(R.id.spinner7);
        s4= (Spinner) findViewById(R.id.spinner4);
        s5 = (Spinner) findViewById(R.id.spinner5);

        r1 = (RadioButton) findViewById(R.id.radioButton);
        sRadioFirst = r1.getText().toString();
        r2 = (RadioButton) findViewById(R.id.radioButton);
        sRadioSecond = r2.getText().toString();
        r3 = (RadioButton) findViewById(R.id.radioButton);
        sRadioThird = r3.getText().toString();
        r4 = (RadioButton) findViewById(R.id.radioButton);
        sRadioFour = r4.getText().toString();
        r5 = (RadioButton) findViewById(R.id.radioButton);
        sRadioFive = r5.getText().toString();
        r6 = (RadioButton) findViewById(R.id.radioButton);
        sRadioSix = r6.getText().toString();
        r7 = (RadioButton) findViewById(R.id.radioButton);
        sRadioSeven = r7.getText().toString();
        r8 = (RadioButton) findViewById(R.id.radioButton);
        sRadioEight= r8.getText().toString();
        r9 = (RadioButton) findViewById(R.id.radioButton);
        sRadioNine = r9.getText().toString();
        r10= (RadioButton) findViewById(R.id.radioButton);
        sRadioTen = r10.getText().toString();
        r11 = (RadioButton) findViewById(R.id.radioButton);
        sRadioEleven= r11.getText().toString();


      /*  s6 = (Spinner) findViewById(R.id.spinner11);*/
        // Spinner click listener


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("B.E CSE");
        categories.add("B.E ECE");
        categories.add("B.E IT");
        categories.add("B.E CIVIL");
        categories.add("B.E MECH");

        a = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item, categories);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s1.setAdapter(dataAdapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        // Spinner Drop down elements
        List<String> section = new ArrayList<String>();
        section.add("A");
        section.add("B");
       /* section.add("B.E IT");
        section.add("B.E CIVIL");
        section.add("B.E MECH");*/

        b = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item, section);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, section);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s2.setAdapter(dataAdapter1);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        // Spinner Drop down elements
        List<String> room = new ArrayList<String>();
        room.add("I year");
        room.add("II year");
        room.add("III year");
        room.add("IV year");


        c = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item, room);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, room);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s3.setAdapter(dataAdapter3);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        List<String> semester = new ArrayList<String>();
        semester.add("I semester");
        semester.add("II semester");
        semester.add("III semester");
        semester.add("IV semester");
        semester.add("V semester");
        semester.add("VI semester");
        semester.add("VII semester");
        semester.add("VIII semester");


        f = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item,semester);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, semester);

        // Drop down layout style - list view with radio button
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s4.setAdapter(dataAdapter6);

        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("I semester")) {
                    subject = new ArrayList<String>();
                    subject.add("physicsI");
                    subject.add("chemistryI");
                    subject.add("M1");
                    subject.add("FOCP");
                }else if (item.equals("II semester")){
                    subject = new ArrayList<String>();
                    subject.add("physicsII");
                    subject.add("chemistryII");
                    subject.add("M2");
                    subject.add("PDS");
                }
                else if (item.equals("III semester")) {
                    subject = new ArrayList<String>();
                    subject.add("PDSII");
                    subject.add("OPERATING SYSTEM");
                    subject.add("EVS");
                    subject.add("COMPUTER ARCHITECTURE");
                }else if (item.equals("IV semester")) {
                    subject = new ArrayList<String>();
                    subject.add("MPMC");
                    subject.add("DAA");
                    subject.add("SE");
                    subject.add("DBMS");
                }
                else if (item.equals("V semester")) {
                    subject = new ArrayList<String>();
                    subject.add("AI");
                    subject.add("ADC");
                    subject.add("CG");
                    subject.add("CNS");
                }
                else if (item.equals("VI semester")) {
                    subject = new ArrayList<String>();
                    subject.add("TOC");
                    subject.add("TQM");
                    subject.add("ST");
                    subject.add("IP");
                }
                else if (item.equals("VII semester")) {
                    subject = new ArrayList<String>();
                    subject.add("MC");
                    subject.add("RMT");
                    subject.add("GTA");
                    subject.add("DA");
                }
                else{

                        subject = new ArrayList<String>();
                        subject.add("PE");
                        subject.add("HCI");
                        subject.add("MCA");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements



        d = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item,subject);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subject);

        // Drop down layout style - list view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s5.setAdapter(dataAdapter4);
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> unit = new ArrayList<String>();
        unit.add("Unit I");
        unit.add("Unit II");
        unit.add("Unit III");
        unit.add("Unit IV");
        unit.add("Unit V");

        e = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item,unit);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unit);

        // Drop down layout style - list view with radio button
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s6.setAdapter(dataAdapter5);
        s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements





    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radioButton1:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radioButton2:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radioButton3:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radioButton4:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radioButton5:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radioButton6:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radioButton7:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
public void onclick(View view) {
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch (view.getId()) {
        case R.id.radioButton9:
            if (checked)
                // Pirates are the best
                break;
        case R.id.radioButton10:
            if (checked)
                // Ninjas rule
                break;
    }
}

    public void aar(View v) {

        date = e1.getText().toString();
        sp1 = s1.getSelectedItem().toString();
        sp2= s2.getSelectedItem().toString();
        sp3 = s3.getSelectedItem().toString();

        sp4 = s4.getSelectedItem().toString();
        sp5 = s5.getSelectedItem().toString();
        sp6 = s6.getSelectedItem().toString();

        if (r1.isChecked()) {
            r1.getText().toString();
        }
        if (r2.isChecked()) {
            r2.getText().toString();
        }
        if (r3.isChecked()) {
            r3.getText().toString();
        }
        if (r4.isChecked()) {
            r4.getText().toString();
        }
         if (r5.isChecked()) {
            r5.getText().toString();
        }
         if (r6.isChecked()) {
            r6.getText().toString();
        }
        if (r7.isChecked()) {
            r7.getText().toString();
        }
        if (r8.isChecked()) {
            r8.getText().toString();
        }
        if (r9.isChecked()) {
            r9.getText().toString();
        }
        if (r10.isChecked()) {
            r10.getText().toString();
        }
        if (r11.isChecked()) {
            r11.getText().toString();
        }

        if(e1.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_LONG).show();
        }
        else {
            nameValuePairs = new ArrayList<NameValuePair>();
            httpclient = new DefaultHttpClient();
            response = new BasicResponseHandler();
            nameValuePairs.add(new BasicNameValuePair("date", date));
            nameValuePairs.add(new BasicNameValuePair("Spinner1",sp1));
            nameValuePairs.add(new BasicNameValuePair("Spinner2",sp2));
            nameValuePairs.add(new BasicNameValuePair("Spinner3",sp3));
            nameValuePairs.add(new BasicNameValuePair("Spinner4",sp4));
            nameValuePairs.add(new BasicNameValuePair("Spinner5",sp5));
            nameValuePairs.add(new BasicNameValuePair("Spinner6",sp6));
            nameValuePairs.add(new BasicNameValuePair("Rb1",sRadioFirst));
            nameValuePairs.add(new BasicNameValuePair("Rb2",sRadioSecond));
            nameValuePairs.add(new BasicNameValuePair("Rb3",sRadioThird));
            nameValuePairs.add(new BasicNameValuePair("Rb4",sRadioFour));
            nameValuePairs.add(new BasicNameValuePair("Rb5",sRadioFive));
            nameValuePairs.add(new BasicNameValuePair("Rb6",sRadioSix));
            nameValuePairs.add(new BasicNameValuePair("Rb7",sRadioSeven));
            nameValuePairs.add(new BasicNameValuePair("Rb8",sRadioEight));
            nameValuePairs.add(new BasicNameValuePair("Rb9",sRadioNine));
            nameValuePairs.add(new BasicNameValuePair("Rb10",sRadioTen));
            nameValuePairs.add(new BasicNameValuePair("Rb11",sRadioEleven));






            httppost = new HttpPost("http://10.0.2.2:8080/attendance.php");
            try {
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                returnedstring = httpclient.execute(httppost, response);
                System.out.println("res" + returnedstring);
                Intent s = new Intent(AttendanceActivity.this, AttendActivity.class);
                startActivity(s);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

            /*Intent i = new Intent(register.this, CombinedActivity.class);
            startActivity(i);*/
}



