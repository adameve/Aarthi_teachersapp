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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Timetable extends AppCompatActivity {

    TextView  t17, t18, t19, t20, t21, t22,t23, t24, t25, t26, t27, t28, t29, t30, t31,t32, t33, t34, t35, t36, t37, t38, t39, t40, t41,t42, t43, t44, t45, t46, t47, t48, t49,t50, t51, t52, t53, t54, t55, t56, t57, t58,t59,t60, t61, t62, t63, t64, t65, t66, t67, t68, t69,t70,t71,t72,t73,t74,t75,t76,t77,t78,t79,t80,t81,t82,t83;
    String dys,dept,yr,aa,aa1,ab,ab1,ac,ac1,ad,ad1,ae,ae1,af,af1,ag,ag1,ba,ba1;
    // String m1,m2,m3,m4,m5,m6,m7,m8,t1,t2,t3,t4,t5,t6,t7,t8,w1,w2,w3,w4,w5,w6,w7,w8,th1,th2,th3,th4,th5,th6,th7,th8,f1,f2,f3,f4,f5,f6,f7,f8,s1,s2,s3,s4,s5,s6,s7,s8;
    HttpClient httpclient;
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    String returnedstring;

    ArrayList<HashMap<String,String>> exampleArray = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }




/*
        t17 = (TextView) findViewById(R.id.t17);
        t18 = (TextView) findViewById(R.id.t18);
        t19 = (TextView) findViewById(R.id.t19);
        t20 = (TextView) findViewById(R.id.t20);
        t21 = (TextView) findViewById(R.id.t21);
        t22 = (TextView) findViewById(R.id.t23);
        t23 = (TextView) findViewById(R.id.t23);
        t24 = (TextView) findViewById(R.id.t24);
        t25 = (TextView) findViewById(R.id.t25);
        t26 = (TextView) findViewById(R.id.t26);
        t27 = (TextView) findViewById(R.id.t27);
        t28 = (TextView) findViewById(R.id.t28);
        t29 = (TextView) findViewById(R.id.t29);
        t30 = (TextView) findViewById(R.id.t30);
        t31 = (TextView) findViewById(R.id.t31);
        t32 = (TextView) findViewById(R.id.t32);
        t33 = (TextView) findViewById(R.id.t33);
        t34 = (TextView) findViewById(R.id.t34);
        t35 = (TextView) findViewById(R.id.t35);
        t36 = (TextView) findViewById(R.id.t36);
        t37 = (TextView) findViewById(R.id.t37);
        t38 = (TextView) findViewById(R.id.t38);
        t39 = (TextView) findViewById(R.id.t39);
        t40 = (TextView) findViewById(R.id.t40);
        t41 = (TextView) findViewById(R.id.t41);
        t42 = (TextView) findViewById(R.id.t42);
        t43 = (TextView) findViewById(R.id.t43);
        t44 = (TextView) findViewById(R.id.t44);
        t45 = (TextView) findViewById(R.id.t45);
        t46 = (TextView) findViewById(R.id.t46);
        t47 = (TextView) findViewById(R.id.t47);
        t48 = (TextView) findViewById(R.id.t48);
        t49 = (TextView) findViewById(R.id.t49);
        t50 = (TextView) findViewById(R.id.t50);
        t51 = (TextView) findViewById(R.id.t51);
        t52 = (TextView) findViewById(R.id.t52);
        t53 = (TextView) findViewById(R.id.t53);
        t54 = (TextView) findViewById(R.id.t54);
        t55 = (TextView) findViewById(R.id.t55);
        t56 = (TextView) findViewById(R.id.t56);
        t57 = (TextView) findViewById(R.id.t57);
        t58 = (TextView) findViewById(R.id.t58);
        t59 = (TextView) findViewById(R.id.t59);
        t60 = (TextView) findViewById(R.id.t60);
        t61 = (TextView) findViewById(R.id.t61);
        t62 = (TextView) findViewById(R.id.t62);
        t63 = (TextView) findViewById(R.id.t63);
        t64 = (TextView) findViewById(R.id.t64);
        t65 = (TextView) findViewById(R.id.t65);
        t66 = (TextView) findViewById(R.id.t66);
        t67 = (TextView) findViewById(R.id.t67);
        t68 = (TextView) findViewById(R.id.t68);
        t69 = (TextView) findViewById(R.id.t69);
        t70 = (TextView) findViewById(R.id.t70);
        t71 = (TextView) findViewById(R.id.t71);
        t72 = (TextView) findViewById(R.id.t72);
        t73 = (TextView) findViewById(R.id.t73);
        t74 = (TextView) findViewById(R.id.t74);
        t75 = (TextView) findViewById(R.id.t75);
        t76 = (TextView) findViewById(R.id.t76);
        t77 = (TextView) findViewById(R.id.t77);
        t78 = (TextView) findViewById(R.id.t78);
        t79 = (TextView) findViewById(R.id.t79);
        t80 = (TextView) findViewById(R.id.t80);
        t81 = (TextView) findViewById(R.id.t81);
        t82 = (TextView) findViewById(R.id.t82);
        t83 = (TextView) findViewById(R.id.t83);*/

        nameValuePairs = new ArrayList<NameValuePair>();
        httpclient = new DefaultHttpClient();
        response = new BasicResponseHandler();
        displayData();

    }

    public void displayData() {

        try {

            httppost = new HttpPost("http://10.0.2.2:8080/Timetable.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            returnedstring = httpclient.execute(httppost, response);
            System.out.println("res ----" + returnedstring);

            JSONArray jsonArr = new JSONArray(returnedstring);

            for (int i = 0; i < jsonArr.length(); i++) {
                TableLayout tl = (TableLayout)findViewById(R.id.tablelayout);
                JSONObject timetable = jsonArr.getJSONObject(i);
                TableRow row = new TableRow(this);
                TextView tv1 = new TextView(this);
                TextView tv2 = new TextView(this);
                TextView tv3 = new TextView(this);
                TextView tv4 = new TextView(this);
                TextView tv5 = new TextView(this);
                TextView tv6 = new TextView(this);
                TextView tv7 = new TextView(this);
                TextView tv8 = new TextView(this);
                TextView tv9 = new TextView(this);
                TextView tv10 = new TextView(this);
                TextView tv11 = new TextView(this);



                dys = timetable.getString("dys");
                    dept = timetable.getString("dept");
                    yr = timetable.getString("yr");
                    aa = timetable.getString("aa");
                    aa1 = timetable.getString("aa1");
                    ab = timetable.getString("ab");
                    ab1 = timetable.getString("ab1");
                    ac = timetable.getString("ac");
                    ac1 = timetable.getString("ac1");
                    ad = timetable.getString("ad");
                    ad1 = timetable.getString("ad1");
                    ae = timetable.getString("ae");
                    ae1 = timetable.getString("ae1");
                    af = timetable.getString("af");
                    af1 = timetable.getString("af1");
                    ag = timetable.getString("ag");
                    ag1 = timetable.getString("ag1");
                    ba = timetable.getString("ba");
                    ba1 = timetable.getString("ba1");

                tv1.setText(dys +"  ");
                tv2.setText(dept +"  ");
                tv3.setText(yr +"  ");
                tv4.setText(aa +"-"+ aa1+"  ");
                tv5.setText(ab +"-"+ ab1+"  ");
                tv6.setText(ac +"-" +ac1+"  ");
                tv7.setText(ad +"-"+ ad1+"  ");
                tv8.setText(ae +"-"+ ae1+"  ");
                tv9.setText(af +"-"+ af1+"  ");
                tv10.setText(ag +"-" +ag1+"  ");
                tv11.setText(ba +"-"+ ba1+"  ");

                tl.addView(row);
                row.addView(tv1);
                row.addView(tv2);
                row.addView(tv3);
                row.addView(tv4);
                row.addView(tv5);
                row.addView(tv6);
                row.addView(tv7);
                row.addView(tv8);
                row.addView(tv9);
                row.addView(tv10);
                row.addView(tv11);
                //set the layout of the view
                //setContentView(R.layout.activity_timetable);

//
//                    HashMap<String, String> map = new HashMap<>();
//                    map.put("dys", dys);
//                    map.put("dept", dept);
//                    map.put("yr", yr);
//                    map.put("aa", aa);
//                    map.put("aa1", aa1);
//                    map.put("ab", ab);
//                    map.put("ab", ab1);
//                    map.put("ac", ac);
//                    map.put("ac1", ac1);
//                    map.put("ad", ad);
//                    map.put("ad1", ad1);
//                    map.put("ae", ae);
//                    map.put("ae1", ae1);
//                    map.put("af", af);
//                    map.put("ae", ae);
//                    map.put("ae1", ae1);
//                    map.put("ag", ag);
//                    map.put("ag1", ag1);
//                    map.put("ba", ba);
//                    map.put("ba1", ba1);
//
//                    exampleArray = new ArrayList<>();
//                    exampleArray.add(map);

//                    t17.setText(dys);
//                    t18.setText(dept);
//                    t19.setText(yr);
//                    t20.setText(aa + aa1);
//                    t21.setText(ab + ab1);
//                    t23.setText(ac + ac1);
//                    t24.setText(ad + ad1);
//                    t25.setText(ae + ae1);
//                    t26.setText(af + af1);
//                    t27.setText(ag + ag1);
//                    t28.setText(ba + ba1);
                    /*t29.setText(dys);
                    t30.setText(dept);
                    t31.setText(yr);
                    t32.setText(aa + aa1);
                    t33.setText(ab + ab1);
                    t34.setText(ac + ac1);
                    t35.setText(ad + ad1);
                    t36.setText(ae + ae1);
                    t37.setText(af + af1);
                    t38.setText(ag + ag1);
                    t39.setText(ba + ba1);
*/
            }


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}

