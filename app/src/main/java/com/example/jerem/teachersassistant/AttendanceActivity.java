package com.example.jerem.teachersassistant;

import android.content.Intent;
import android.content.SharedPreferences;
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
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.jerem.teachersassistant.R.id.parent;
import static com.example.jerem.teachersassistant.R.id.radioButton1;
import static com.example.jerem.teachersassistant.R.id.update;

public class AttendanceActivity extends AppCompatActivity {
    Intent i;
    EditText e1;
    String date, sp1, sp2, sp3, sp4, sp5, sp6, returnedstring;
    String sRadioFirst, sRadioSecond, sRadioThird, sRadioFour, sRadioFive, sRadioSix, sRadioSeven, sRadioEight, sRadioNine, sRadioTen, sRadioEleven;
    ArrayAdapter<String> a, b, c, d, e, f;
    Spinner dept, year, sec, sub, sem, uni;
    String mDepartment = "";
    String mYear = "";
    String mSem = "";
    RadioButton r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11;
    private RadioGroup rGroup, Group1;
    HttpClient httpclient;
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    List<String> subject = null;
    ArrayAdapter<String> dataAdapter4;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        SharedPreferences prefs = getSharedPreferences("userid", MODE_PRIVATE);
        userid = prefs.getString("userid", null); //0 is the default value.

        System.out.print(userid);
//        rGroup=(RadioGroup)findViewById(R.id.rGroup);
//        Group1=(RadioGroup)findViewById(R.id.Group1);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        e1 = (EditText) findViewById(R.id.editText4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dept = (Spinner) findViewById(R.id.spinner8);
        year = (Spinner) findViewById(R.id.spinner10);
        sec = (Spinner) findViewById(R.id.spinner9);
        sem = (Spinner) findViewById(R.id.spinner4);
        sub = (Spinner) findViewById(R.id.spinner5);
        uni = (Spinner) findViewById(R.id.spinner7);

        r1 = (RadioButton) findViewById(R.id.radioButton);

        r2 = (RadioButton) findViewById(R.id.radioButton1);

        r3 = (RadioButton) findViewById(R.id.radioButton2);

        r4 = (RadioButton) findViewById(R.id.radioButton3);

        r5 = (RadioButton) findViewById(R.id.radioButton4);

        r6 = (RadioButton) findViewById(R.id.radioButton5);

        r7 = (RadioButton) findViewById(R.id.radioButton6);

        r8 = (RadioButton) findViewById(R.id.radioButton7);

        r9 = (RadioButton) findViewById(R.id.radioButton9);

        r10 = (RadioButton) findViewById(R.id.radioButton10);

        r11 = (RadioButton) findViewById(R.id.radioButton11);


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
        dept.setAdapter(dataAdapter);
        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mDepartment = parent.getItemAtPosition(position).toString();


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
        sec.setAdapter(dataAdapter1);
        sec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

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
        year.setAdapter(dataAdapter3);
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mYear = parent.getItemAtPosition(position).toString();


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


        f = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item, semester);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, semester);

        // Drop down layout style - list view with radio button
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sem.setAdapter(dataAdapter6);

        sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSem = parent.getItemAtPosition(position).toString();
                if (mDepartment.equals("B.E CSE") && mYear.equals("I year")) {
                    if (mSem.equals("I semester")) {
                        subject = new ArrayList<String>();
                        subject.add("physicsI");
                        subject.add("chemistryI");
                        subject.add("M1");
                        subject.add("FOCP");
                        subject.add("EG");
                        subject.add("English1");

                        System.out.println(subject);
                        Toast.makeText(AttendanceActivity.this, "" + subject, Toast.LENGTH_SHORT).show();
                    } else if (mSem.equals("II semester")) {
                        subject.clear();
                        subject = new ArrayList<String>();
                        subject.add("physicsII");
                        subject.add("chemistryII");
                        subject.add("M2");
                        subject.add("PDS");

                        System.out.println(subject);
                        Toast.makeText(AttendanceActivity.this, "" + subject, Toast.LENGTH_SHORT).show();
                    }
                } else if (mDepartment.equals("B.E CSE") && mYear.equals("II year")) {
                    if (mSem.equals("III semester")) {
                        subject = new ArrayList<String>();
                        subject.add("PDSII");
                        subject.add("OPERATING SYSTEM");
                        subject.add("EVS");
                        subject.add("COMPUTER ARCHITECTURE");

                        System.out.println(subject);
                    } else if (mSem.equals("IV semester")) {
                        subject = new ArrayList<String>();
                        subject.add("MPMC");
                        subject.add("DAA");
                        subject.add("SE");
                        subject.add("DBMS");

                        System.out.println(subject);
                    }
                } else if (mDepartment.equals("B.E CSE") && mYear.equals("III year")) {
                    if (mSem.equals("V semester")) {
                        subject = new ArrayList<String>();
                        subject.add("AI");
                        subject.add("ADC");
                        subject.add("CG");
                        subject.add("CNS");

                        System.out.println(subject);
                    } else if (mSem.equals("VI semester")) {
                        subject = new ArrayList<String>();
                        subject.add("TOC");
                        subject.add("TQM");
                        subject.add("ST");
                        subject.add("IP");
                        dataAdapter4.notifyDataSetChanged();
                        System.out.println(subject);
                    }
                } else if (mDepartment.equals("B.E CSE") && mYear.equals("IV year")) {
                    if (mSem.equals("VII semester")) {
                        subject = new ArrayList<String>();
                        subject.add("MC");
                        subject.add("RMT");
                        subject.add("GTA");
                        subject.add("DA");

                        System.out.println(subject);
                    } else {

                        subject = new ArrayList<String>();
                        subject.add("PE");
                        subject.add("HCI");
                        subject.add("MCA");

                        System.out.println(subject);

                    }
                }

                dataAdapter4.clear();
                dataAdapter4 = new ArrayAdapter<>(AttendanceActivity.this, android.R.layout.simple_spinner_item, subject);

                // Drop down layout style - list view with radio button
                dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                sub.setAdapter(dataAdapter4);
                dataAdapter4.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements


        //  d = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item,subject);

        subject = new ArrayList<String>();
        subject.add("physicsI");
        subject.add("chemistryI");
        subject.add("M1");
        subject.add("FOCP");
        subject.add("EG");
        subject.add("English1");
        subject.add("physicsII");
        subject.add("chemistryII");
        subject.add("M2");
        subject.add("PDS");
        subject = new ArrayList<String>();
        subject.add("PDSII");
        subject.add("OPERATING SYSTEM");
        subject.add("EVS");
        subject.add("COMPUTER ARCHITECTURE");
        subject.add("MPMC");
        subject.add("DAA");
        subject.add("SE");
        subject.add("DBMS");
        subject.add("AI");
        subject.add("ADC");
        subject.add("CG");
        subject.add("CNS");
        subject.add("TOC");
        subject.add("TQM");
        subject.add("ST");
        subject.add("IP");
        subject.add("MC");
        subject.add("RMT");
        subject.add("GTA");
        subject.add("DA");
        subject.add("PE");
        subject.add("HCI");
        subject.add("MCA");


        // Creating adapter for spinner
        dataAdapter4 = new ArrayAdapter<>(AttendanceActivity.this, android.R.layout.simple_spinner_item, subject);

        // Drop down layout style - list view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sub.setAdapter(dataAdapter4);
        dataAdapter4.notifyDataSetChanged();
        sub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        e = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_spinner_item, unit);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unit);

        // Drop down layout style - list view with radio button
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        uni.setAdapter(dataAdapter5);
        uni.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


    public void aar(View v) {

        date = e1.getText().toString();
        sp1 = dept.getSelectedItem().toString();
        sp2 = year.getSelectedItem().toString();
        sp3 = sec.getSelectedItem().toString();
        sp4 = sem.getSelectedItem().toString();
        sp5 = sub.getSelectedItem().toString();
        sp6 = uni.getSelectedItem().toString();

        if (r1.isChecked()) {
            sRadioFirst = r1.getText().toString();
        } else {
            sRadioFirst = "0";
        }
        if (r2.isChecked()) {
            sRadioSecond = r2.getText().toString();
        } else {
            sRadioSecond = "0";
        }

        if (r3.isChecked()) {
            sRadioThird = r3.getText().toString();
        } else {
            sRadioThird = "0";
        }

        if (r4.isChecked()) {
            sRadioFour = r4.getText().toString();
        } else {
            sRadioFour = "0";
        }
        if (r5.isChecked()) {
            sRadioFive = r5.getText().toString();
        } else {
            sRadioFive = "0";
        }
        if (r6.isChecked()) {
            sRadioSix = r6.getText().toString();
        } else {
            sRadioSix = "0";
        }
        if (r7.isChecked()) {
            sRadioSeven = r7.getText().toString();
        } else {
            sRadioSeven = "0";
        }
        if (r8.isChecked()) {
            sRadioEight = r8.getText().toString();
        } else {
            sRadioEight = "0";
        }
        if (r9.isChecked()) {
            sRadioNine = r9.getText().toString();
        } else {
            sRadioNine = "0";
        }
        if (r10.isChecked()) {
            sRadioTen = r10.getText().toString();
        } else {
            sRadioTen = "0";
        }
        if (r11.isChecked()) {
            sRadioEleven = r11.getText().toString();
        } else {
            sRadioEleven = "0";
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
            nameValuePairs.add(new BasicNameValuePair("userid", userid));

            System.out.println("http://10.0.2.2:8080/attendance.php" + nameValuePairs);
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



