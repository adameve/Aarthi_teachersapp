package com.example.jerem.teachersassistant;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    Intent i;
    EditText e3, e4;

    HttpClient httpclient;
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    String userid, password;
    String returnedstring;
    //  String studentStatus ="0";
    CharSequence t1 = "invalid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        e3 = (EditText) findViewById(R.id.login);
        e4 = (EditText) findViewById(R.id.password);


        nameValuePairs = new ArrayList<NameValuePair>();
        httpclient = new DefaultHttpClient();
        response = new BasicResponseHandler();
    }

    public void Login(View v) {


        userid = e3.getText().toString();
        password = e4.getText().toString();


        if (userid.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter loginid and password", Toast.LENGTH_LONG).show();
        } else {

            nameValuePairs.add(new BasicNameValuePair("userid", userid));
            nameValuePairs.add(new BasicNameValuePair("Password", password));


            httppost = new HttpPost("http://10.0.2.2:8080/check.php");
            try {
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                returnedstring = httpclient.execute(httppost, response);
                String[] split = returnedstring.split(",");
                String s1 = split[0];
                String s2 = split[1];
                System.out.println("res" + returnedstring);
                if (s1.equals("true")) {
                    SharedPreferences.Editor editor = getSharedPreferences("userid",MODE_PRIVATE).edit();
                    editor.putString("userid", s2);
                    editor.commit();

                    Intent s = new Intent(com.example.jerem.teachersassistant.LoginActivity.this, MainActivity.class);
                    startActivity(s);
                } else {
                    Snackbar.make(v, getString(R.string.validuser),Snackbar.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


        /*Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent assistant = new Intent(LoginActivity.this, MainActivity.class);
                assistant.putExtra("hello", "jerry");
                startActivity(assistant);
                finish();
            }
        });*/






