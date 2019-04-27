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

public class view_no_show_screen extends AppCompatActivity {

    public EditText Sno1,Sno2,Sno3,Sno4,PId1,PId2,PId3,PId4,Date1,Date2,Date3,Date4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_no_show_screen);
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
                startActivity(new Intent(view_no_show_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup12() {

        Sno1 = (EditText) findViewById(R.id.etSNO31);
        Sno2 = (EditText) findViewById(R.id.etSNO32);
        Sno3 = (EditText) findViewById(R.id.etSNO33);
        Sno4 = (EditText) findViewById(R.id.etSNO34);

        PId1 = (EditText) findViewById(R.id.etPID31);
        PId2 = (EditText) findViewById(R.id.etPID32);
        PId3 = (EditText) findViewById(R.id.etPID33);
        PId4 = (EditText) findViewById(R.id.etPID34);

        Date1 = (EditText) findViewById(R.id.etDATE31);
        Date2 = (EditText) findViewById(R.id.etDATE32);
        Date3 = (EditText) findViewById(R.id.etDATE33);
        Date4 = (EditText) findViewById(R.id.etDATE34);

    }
}
