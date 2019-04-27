package com.example.myapplication1;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class view_violation_screen extends AppCompatActivity {

    public EditText Sno1,Sno2,Sno3,Sno4,Pid1,Pid2,Pid3,Pid4,Date1,Date2,Date3,Date4,Stime1,Stime2,Stime3,Stime4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_violation_screen);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.action_logout:
                startActivity(new Intent(view_violation_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup9() {

        Sno1 = (EditText) findViewById(R.id.etSNO1);
        Sno2 = (EditText) findViewById(R.id.etSNO2);
        Sno3 = (EditText) findViewById(R.id.etSNO3);
        Sno4 = (EditText) findViewById(R.id.etSNO4);

        Pid1 = (EditText) findViewById(R.id.etPID1);
        Pid2 = (EditText) findViewById(R.id.etPID2);
        Pid3 = (EditText) findViewById(R.id.etPID3);
        Pid4 = (EditText) findViewById(R.id.etPID4);

        Date1 = (EditText) findViewById(R.id.etDATE1);
        Date2 = (EditText) findViewById(R.id.etDATE2);
        Date3 = (EditText) findViewById(R.id.etDATE3);
        Date4 = (EditText) findViewById(R.id.etDATE4);

        Stime1 = (EditText) findViewById(R.id.etSTIME1);
        Stime2 = (EditText) findViewById(R.id.etSTIME2);
        Stime3 = (EditText) findViewById(R.id.etSTIME3);
        Stime4 = (EditText) findViewById(R.id.etSTIME4);

    }
}
