package com.example.jerem.teachersassistant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
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
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    TextView e3, e4, e5, e6, e7, e8, e9, e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24;

    HttpClient httpclient;
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    String Employee_code,Password,First_Name,Middle_Name,Surname,Father_Name,Mother_Name,DOB,Gender,Religion,Community,Nationality,Caste,Martial_Status,Blood_Group,Aadhaar_No,Pancard_No,Phone_Number,Personal_Email,Current_Address,Country,State,District,Pin_code;
    String returnedstring;
    //  String studentStatus ="0";
    CharSequence t1="invalid";
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences prefs = getSharedPreferences("userid", MODE_PRIVATE);
        userid = prefs.getString("userid", null); //0 is the default value.

        System.out.print(userid);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(edit);
            }
        });
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        e3 = (TextView) findViewById(R.id.e3);
        e4 = (TextView) findViewById(R.id.e4);
        e5 = (TextView) findViewById(R.id.e5);
        e6 = (TextView) findViewById(R.id.e6);
        e7 = (TextView) findViewById(R.id.e7);
        e8 = (TextView) findViewById(R.id.e8);
        e9 = (TextView) findViewById(R.id.e9);
        e10 = (TextView) findViewById(R.id.e10);
        e11 = (TextView) findViewById(R.id.e11);
        e12 = (TextView) findViewById(R.id.e12);
        e13 = (TextView) findViewById(R.id.e13);
        e14 = (TextView) findViewById(R.id.e14);
        e15 = (TextView) findViewById(R.id.e15);
        e16 = (TextView) findViewById(R.id.e16);
        e17 = (TextView) findViewById(R.id.e17);
        e18 = (TextView) findViewById(R.id.e18);
        e19 = (TextView) findViewById(R.id.e19);
        e20 = (TextView) findViewById(R.id.e20);
        e21 = (TextView) findViewById(R.id.e21);
        e22 = (TextView) findViewById(R.id.e22);
        e23 = (TextView) findViewById(R.id.e23);
        e24 = (TextView) findViewById(R.id.e24);

        nameValuePairs = new ArrayList<NameValuePair>();
        httpclient = new DefaultHttpClient();
        response = new BasicResponseHandler();
        updateData();
    }


    public void updateData() {



        First_Name = e3.getText().toString();
        Middle_Name = e4.getText().toString();
        Surname = e5.getText().toString();
        Father_Name = e6.getText().toString();
        Mother_Name= e7.getText().toString();
        DOB = e8.getText().toString();
        Gender= e9.getText().toString();
        Religion = e10.getText().toString();
        Community = e11.getText().toString();
        Nationality = e12.getText().toString();
        Caste = e13.getText().toString();
        Martial_Status= e14.getText().toString();
        Blood_Group = e15.getText().toString();
        Aadhaar_No = e16.getText().toString();
        Pancard_No= e17.getText().toString();
        Phone_Number= e18.getText().toString();
        Personal_Email= e19.getText().toString();
        Current_Address = e20.getText().toString();
        Country= e21.getText().toString();
        State= e22.getText().toString();
        District= e23.getText().toString();
        Pin_code = e24.getText().toString();







            try {
                nameValuePairs.add(new BasicNameValuePair("userid", userid));
                httppost = new HttpPost("http://10.0.2.2/display.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                returnedstring = httpclient.execute(httppost, response);
                System.out.println("res:-------"+returnedstring);


                //Toast.makeText(getApplicationContext(), returnedstring, Toast.LENGTH_LONG).show();

                    JSONArray jsonArr = new JSONArray(returnedstring);

                    for(int i=0;i<jsonArr.length();i++)
                    {
                        JSONObject jsonObj = jsonArr.getJSONObject(i);
                        String firstname = jsonObj.getString("First_Name");
                        String middlename = jsonObj.getString("Middle_Name");
                        String surname = jsonObj.getString("Surname");
                        String fathername = jsonObj.getString("Father_Name");
                        String mothername = jsonObj.getString("Mother_Name");
                        String dob = jsonObj.getString("DOB");
                        String gender = jsonObj.getString("Gender");
                        String religion = jsonObj.getString("Religion");
                        String community = jsonObj.getString("Community");
                        String nationality = jsonObj.getString("Nationality");
                        String caste = jsonObj.getString("Caste");
                        String martial_status = jsonObj.getString("Martial_Status");
                        String blood_group = jsonObj.getString("Blood_Group");
                        String aadhar = jsonObj.getString("Aadhaar_No");
                        String pan = jsonObj.getString("Pancard_No");
                        String phoneno = jsonObj.getString("Phone_Number");
                        String email = jsonObj.getString("Personal_Email");
                        String address = jsonObj.getString("Current_Address");
                        String country = jsonObj.getString("Country");
                        String state = jsonObj.getString("State");
                        String district = jsonObj.getString("District");
                        String pincode = jsonObj.getString("Pin_code");
                        e3.setText(firstname);
                        e4.setText(middlename);
                        e5.setText(surname);
                        e6.setText(fathername);
                        e7.setText(mothername);
                        e8.setText(dob);
                        e9.setText(gender);
                        e10.setText(religion);
                        e11.setText(community);
                        e12.setText(nationality);
                        e13.setText(caste);
                        e14.setText(martial_status);
                        e15.setText(blood_group);
                        e16.setText(aadhar);
                        e17.setText(pan);
                        e18.setText(phoneno);
                        e19.setText(email);
                        e20.setText(address);
                        e21.setText(country);
                        e22.setText(state);
                        e23.setText(district);
                        e24.setText(pincode);

                    }


            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }


            /*Intent i = new Intent(register.this, CombinedActivity.class);
            startActivity(i);*/
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.nav_gallery) {
            Intent act = new Intent(MainActivity.this,AttendanceActivity.class);
            startActivity(act);

        } else if (id == R.id.nav_slideshow) {

        } else if(id == R.id.nav_internal){
            Intent act = new Intent(MainActivity.this,InternalActivity.class);
            startActivity(act);

        } else if (id==R.id.nav_activity){
            Intent act = new Intent(MainActivity.this,LogActivity.class);
            startActivity(act);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
