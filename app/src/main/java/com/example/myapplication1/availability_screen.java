package com.example.myapplication1;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class availability_screen extends AppCompatActivity {

    public EditText SpecificTime,AvailSpots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability_screen);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SpecificTime = (EditText) findViewById(R.id.etSpecTime);
        AvailSpots = (EditText) findViewById(R.id.etAvailSpots);
        Spinner mySpinner10 = (Spinner) findViewById(R.id.ParkTySpin1);
        Spinner mySpinner11 = (Spinner) findViewById(R.id.AreaNspinner2);

        ArrayAdapter<String> myAdapter10 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingTypes));
        ArrayAdapter<String> myAdapter11 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingAreaNames));


        myAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mySpinner10.setAdapter(myAdapter10);
        mySpinner11.setAdapter(myAdapter11);

    }


    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.action_logout:
                startActivity(new Intent(availability_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
