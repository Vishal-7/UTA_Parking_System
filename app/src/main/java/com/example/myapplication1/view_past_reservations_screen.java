package com.example.myapplication1;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class view_past_reservations_screen extends AppCompatActivity {

    public EditText Sno1,Sno2,Sno3,Sno4,Sno5,PId1,PId2,PId3,PId4,PId5,Date1,Date2,Date3,Date4,Date5,Stime1,Stime2,Stime3,Stime4,Stime5,Duration1,Duration2,Duration3,Duration4,Duration5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_past_reservations_screen);

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
                startActivity(new Intent(view_past_reservations_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup11() {

        Sno1 =(EditText) findViewById(R.id.etSNO21);
        Sno2 = (EditText) findViewById(R.id.etSNO22);
        Sno3 = (EditText) findViewById(R.id.etSNO23);
        Sno4 = (EditText) findViewById(R.id.etSNO24);
        Sno5 = (EditText) findViewById(R.id.etSNO25);

        PId1 = (EditText) findViewById(R.id.etPID21);
        PId2 = (EditText) findViewById(R.id.etPID22);
        PId3 = (EditText) findViewById(R.id.etPID23);
        PId4 = (EditText) findViewById(R.id.etPID24);
        PId5 = (EditText) findViewById(R.id.etPID25);

        Date1 = (EditText) findViewById(R.id.etDATE21);
        Date2 = (EditText) findViewById(R.id.etDATE22);
        Date3 = (EditText) findViewById(R.id.etDATE23);
        Date4 = (EditText) findViewById(R.id.etDATE24);
        Date5 = (EditText) findViewById(R.id.etDATE25);

        Stime1 = (EditText) findViewById(R.id.etSTIME21);
        Stime2 = (EditText) findViewById(R.id.etSTIME22);
        Stime3 = (EditText) findViewById(R.id.etSTIME23);
        Stime4 = (EditText) findViewById(R.id.etSTIME24);
        Stime5 = (EditText) findViewById(R.id.etSTIME25);

        Duration1 = (EditText) findViewById(R.id.etDURATION21);
        Duration2 = (EditText) findViewById(R.id.etDURATION22);
        Duration3 = (EditText) findViewById(R.id.etDURATION23);
        Duration4 = (EditText) findViewById(R.id.etDURATION24);
        Duration5 = (EditText) findViewById(R.id.etDURATION25);

    }
}
