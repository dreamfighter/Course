package com.example.zeger.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    String tag = "ACTIVITY_LIFECYCLE";
    String var = "";
    EditText passED;

    boolean wrongPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // informasi activity ini menggunakan layout yang mana
        setContentView(R.layout.activity_main);

        passED = (EditText)findViewById(R.id.password_textview);
        EditText userED = (EditText)findViewById(R.id.username_textview);
        Button butLogin = (Button) findViewById(R.id.login_button);

        Log.d(tag, "The onCreate() event");

        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!passED.getText().toString().equals("bayu")){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setMessage("password anda salah");
                    dialog.create().show();
                    wrongPassword = true;
                }else{
                    Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                    startActivity(intent);

                }
            }
        });



        if(savedInstanceState!=null){
            //var = savedInstanceState.getString("variable_var");

            wrongPassword = savedInstanceState.getBoolean("wrong_pass");
        }


        if(wrongPassword){
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setMessage("password anda salah");
            dialog.create().show();
        }


        /*
        Button but = (Button) findViewById(R.id.but);
        Log.d(tag, "var = "+var);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("ini dialog");
                dialog.create().show();
                wrongPassword = true;
            }
        });
        */
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "The onStart() event");
        //Log.d(tag, "var = "+var);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "The onResume() event");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(tag, "The onConfigurationChanged() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "The onPause() event");
        //var = "onPause";
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "The onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //var = "destroy";
        Log.d(tag, "The onDestroy() event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "The onRestart() event");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString("variable_var",var);
        //outState.putBoolean("wrong_pass",wrongPassword);
        outState.putBoolean("wrong_pass",wrongPassword);

        Log.d(tag, "The onSaveInstanceState() event");
    }
}
