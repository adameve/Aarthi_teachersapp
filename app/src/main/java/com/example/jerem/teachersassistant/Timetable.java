package com.example.jerem.teachersassistant;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

public class Timetable extends AppCompatActivity {

    TextView t16,t17,t18,t19,t20,t21,t22,t24,t25,t26,t27,t28,t29,t30,t31,t33,t34,t35,t36,t37,t38,t39,t40,t42,t43,t44,t45,t46,t47,t48,t49,t51,t52,t53,t54,t55,t56,t57,t58,t68,t69,t70,t71,t72,t73,t74,t75,t76,t23;
 String m1,m2,m3,m4,m5,m6,m7,m8,t1,t2,t3,t4,t5,t6,t7,t8,w1,w2,w3,w4,w5,w6,w7,w8,th1,th2,th3,th4,th5,th6,th7,th8,f1,f2,f3,f4,f5,f6,f7,f8,s1,s2,s3,s4,s5,s6,s7,s8;
    HttpClient httpclient;
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    String returnedstring;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Spinner spinner = (Spinner) findViewById(R.id.travelType_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.timetable, R.layout.activity_timetable);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        t16 = (TextView) findViewById(R.id.t16);
        t17 = (TextView) findViewById(R.id.t17);
        t18 = (TextView) findViewById(R.id.t18);
        t19 = (TextView) findViewById(R.id.t19);
        t20 = (TextView) findViewById(R.id.t20);
        t21 = (TextView) findViewById(R.id.t21);
        t22 = (TextView) findViewById(R.id.t22);
        t24 = (TextView) findViewById(R.id.t24);
        t25 = (TextView) findViewById(R.id.t25);
        t26 = (TextView) findViewById(R.id.t27);
        t28 = (TextView) findViewById(R.id.t28);
        t29 = (TextView) findViewById(R.id.t29);
        t30= (TextView) findViewById(R.id.t30);
        t31 = (TextView) findViewById(R.id.t31);
        t33 = (TextView) findViewById(R.id.t33);
        t34= (TextView) findViewById(R.id.t34);
        t35 = (TextView) findViewById(R.id.t35);
        t36= (TextView) findViewById(R.id.t36);
        t37 = (TextView) findViewById(R.id.t37);
        t38 = (TextView) findViewById(R.id.t38);
        t39 = (TextView) findViewById(R.id.t39);
        t40 = (TextView) findViewById(R.id.t40);
        t42 = (TextView) findViewById(R.id.t42);
        t43 = (TextView) findViewById(R.id.t43);
        t44 = (TextView) findViewById(R.id.t44);
        t45= (TextView) findViewById(R.id.t45);
        t46 = (TextView) findViewById(R.id.t46);
        t47 = (TextView) findViewById(R.id.t47);
        t48 = (TextView) findViewById(R.id.t48);
        t49 = (TextView) findViewById(R.id.t49);
        t51 = (TextView) findViewById(R.id.t51);
        t52 = (TextView) findViewById(R.id.t52);
        t53 = (TextView) findViewById(R.id.t53);
        t54 = (TextView) findViewById(R.id.t54);
        t55 = (TextView) findViewById(R.id.t55);
        t56 = (TextView) findViewById(R.id.t56);
        t57 = (TextView) findViewById(R.id.t57);
        t58 = (TextView) findViewById(R.id.t58);
        t68= (TextView) findViewById(R.id.t68);
        t69 = (TextView) findViewById(R.id.t69);
        t70 = (TextView) findViewById(R.id.t70);
        t71 = (TextView) findViewById(R.id.t71);
        t72 = (TextView) findViewById(R.id.t72);
        t73= (TextView) findViewById(R.id.t73);
        t74 = (TextView) findViewById(R.id.t74);
        t75 = (TextView) findViewById(R.id.t75);
        t76 = (TextView) findViewById(R.id.t76);
        t23 = (TextView) findViewById(R.id.t23);
        nameValuePairs = new ArrayList<NameValuePair>();
        httpclient = new DefaultHttpClient();
        response = new BasicResponseHandler();
        displaydata();




    }
    public void displaydata(){


        m1= t16.getText().toString();
    m2=t17.getText().toString();
    m3 = t18.getText().toString();
    m4 = t19.getText().toString();
    m5= t20.getText().toString();
        m6= t21.getText().toString();
        m7=t23.getText().toString();
        m8 = t22.getText().toString();
        t1 = t24.getText().toString();
        t2= t25.getText().toString();
        t3 = t26.getText().toString();
        t4= t27.getText().toString();
        t5 = t28.getText().toString();
        t6= t29.getText().toString();
        t7 = t30.getText().toString();
        t8= t31.getText().toString();
        w1 = t33.getText().toString();
        w2= t34.getText().toString();
        w3 = t35.getText().toString();
        w4= t36.getText().toString();
        w5 = t37.getText().toString();
        w6= t38.getText().toString();
        w7 = t39.getText().toString();
        w8= t40.getText().toString();
        th1 = t42.getText().toString();
        th2= t43.getText().toString();
        th3 = t44.getText().toString();
        th4= t45.getText().toString();
        th5 = t46.getText().toString();
        th6= t47.getText().toString();
        th7 = t48.getText().toString();
        th8= t49.getText().toString();
        f1 = t51.getText().toString();
        f2= t52.getText().toString();
        f3 = t53.getText().toString();
        f4= t54.getText().toString();
        f5 = t55.getText().toString();
        f6= t56.getText().toString();
        f7 = t57.getText().toString();
        f8= t58.getText().toString();
        s1 = t69.getText().toString();
        s2= t70.getText().toString();
        s3 = t71.getText().toString();
        s4= t72.getText().toString();
        s5 = t73.getText().toString();
        s6= t74.getText().toString();
        s7 = t75.getText().toString();
        s8= t76.getText().toString();



        try {

        httppost = new HttpPost("http://10.0.2.2:8080/Timetable.php");
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        returnedstring = httpclient.execute(httppost, response);
        System.out.println("res"+returnedstring);

        JSONArray jsonArr = new JSONArray(returnedstring);

        for(int i=0;i<jsonArr.length();i++)
        {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            String m1  = jsonObj.getString("m1");
            String m2 = jsonObj.getString("m2");
            String m3 = jsonObj.getString("m3");
            String m4 = jsonObj.getString("m4");
            String m5 = jsonObj.getString("m5");
            String m6 = jsonObj.getString("m6");
            String m7 = jsonObj.getString("m7");
            String m8 = jsonObj.getString("m8");
            String t1 = jsonObj.getString("t1");
            String t2= jsonObj.getString("t2");
            String t3 = jsonObj.getString("t3");
            String t4 = jsonObj.getString("t4");
            String t5 = jsonObj.getString("t5");
            String t6 = jsonObj.getString("t6");
            String t7 = jsonObj.getString("t7");
            String t8= jsonObj.getString("t8");
            String w1 = jsonObj.getString("w1");
            String w2 = jsonObj.getString("w2");
            String w3 = jsonObj.getString("w3");
            String w4 = jsonObj.getString("w4");
            String w5 = jsonObj.getString("w5");
            String w6 = jsonObj.getString("w6");
            String w7 = jsonObj.getString("w7");
            String w8 = jsonObj.getString("w8");
            String th1 = jsonObj.getString("th1");
            String th2= jsonObj.getString("th2");
            String th3 = jsonObj.getString("th3");
            String th4 = jsonObj.getString("th4");
            String th5 = jsonObj.getString("th5");
            String th6 = jsonObj.getString("th6");
            String th7 = jsonObj.getString("th7");
            String th8= jsonObj.getString("th8");
            String f1 = jsonObj.getString("f1");
            String f2= jsonObj.getString("f2");
            String f3 = jsonObj.getString("f3");
            String f4 = jsonObj.getString("f4");
            String f5 = jsonObj.getString("f5");
            String f6 = jsonObj.getString("f6");
            String f7 = jsonObj.getString("f7");
            String f8= jsonObj.getString("f8");
            String s1 = jsonObj.getString("s1");
            String s2= jsonObj.getString("s2");
            String s3 = jsonObj.getString("s3");
            String s4 = jsonObj.getString("s4");
            String s5 = jsonObj.getString("s5");
            String s6 = jsonObj.getString("s6");
            String s7 = jsonObj.getString("s7");
            String s8= jsonObj.getString("s8");
            t16.setText(m1);
            t17.setText(m2);
            t18.setText(m3);
            t19.setText(m4);
            t20.setText(m5);
            t21.setText(m6);
            t22.setText(m8);
            t23.setText(m7);
            t24.setText(t1);
            t25.setText(t2);
            t26.setText(t3);
            t27.setText(t4);
            t28.setText(t5);
            t29.setText(t6);
            t30.setText(t7);
            t31.setText(t8);
            t33.setText(w1);
            t34.setText(w2);
            t35.setText(w3);
            t36.setText(w4);
            t37.setText(w5);
            t38.setText(w6);
            t39.setText(w7);
            t40.setText(w8);
            t42.setText(th1);
            t43.setText(th2);
            t44.setText(th3);
            t45.setText(th4);
            t46.setText(th5);
            t47.setText(th6);
            t48.setText(th7);
            t49.setText(th8);
            t51.setText(f1);
            t52.setText(f2);
            t53.setText(f3);
            t54.setText(f4);
            t55.setText(f5);
            t56.setText(f6);
            t57.setText(f7);
            t58.setText(f8);
            t69.setText(s1);
            t70.setText(s2);
            t71.setText(s3);
            t72.setText(s4);
            t73.setText(s5);
            t74.setText(s6);
            t75.setText(s7);
            t76.setText(s8);












        }


                /*Toast.makeText(getApplicationContext(), returnedstring, Toast.LENGTH_LONG).show();
                if(returnedstring.equals("true"))
                {
                    Intent s = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(s);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), t1 , Toast.LENGTH_LONG).show();
                }*/

    } catch (Exception e) {
        e.printStackTrace();
        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
    }
    }


            /*Intent i = new Intent(register.this, CombinedActivity.class);
            startActivity(i);*/
}

