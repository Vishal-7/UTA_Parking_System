package com.example.myapplication1;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class make_reservation_screen extends AppCompatActivity {

    SQLiteDatabase Db;
    public EditText Date, StartTime, Duration;
    public Spinner ParkType, ParkArea, Floor;
    public CheckBox Cart1, Camera1, History1;
    public static Button btn1;
    String Addons1, Addons2, Addons3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation_screen);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ParkType = (Spinner) findViewById(R.id.spinParkType);
        ParkArea = (Spinner) findViewById(R.id.SpinAreaNAme);
        Floor = (Spinner) findViewById(R.id.spinFloor);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingTypes));
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingAreaNames));
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Floor));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ParkType.setAdapter(myAdapter);
        ParkArea.setAdapter(myAdapter2);
        Floor.setAdapter(myAdapter3);
        UISetup8();

    }

    public void test1(View view) {
        btn1 = (Button) findViewById(R.id.mkResbtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder build1 = new AlertDialog.Builder(make_reservation_screen.this);
                build1.setMessage("Do you want to make the Reservation?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                   insertdata9();
                        Toast.makeText(getApplicationContext(),"Your reservation has been booked",Toast.LENGTH_LONG).show();
                    }
                })
                   .setNegativeButton("No", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.cancel();
                           Toast.makeText(getApplicationContext(),"Your reservation has not been made",Toast.LENGTH_LONG).show();

                       }
                   });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Reservation");
                alert.show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.action_logout:
                startActivity(new Intent(make_reservation_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup8() {

        Date = (EditText) findViewById(R.id.etDate);
        StartTime = (EditText) findViewById(R.id.etStartTime);
        Duration = (EditText) findViewById(R.id.etDuration);
        Cart1 = (CheckBox) findViewById(R.id.cboxCart1);
        Camera1 = (CheckBox) findViewById(R.id.cboxCamera1);
        History1 = (CheckBox) findViewById(R.id.cboxHistory1);

    }

    public void insertdata9() {

        String Date1 = Date.getText().toString();
        String StartTime1 = StartTime.getText().toString();
        String Duration1 = Duration.getText().toString();
        String Parktype1= ParkType.getSelectedItem().toString();
        String AreaName1 = ParkArea.getSelectedItem().toString();
        String Floor1=Floor.getSelectedItem().toString();
        Cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Cart1.isChecked()) {
                    Addons1 = "Cart";
                }
                else
                {
                    Addons1="No";
                }
            }
        });

        History1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (History1.isChecked()) {
                    Addons2 = "History";
                }
                else
                {
                    Addons2="No";
                }
            }
        });

        Camera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Camera1.isChecked()) {
                    Addons3 = "Camera";
                }
                else
                {
                    Addons3="No";
                }
            }
        });
        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);

        Db.execSQL("CREATE TABLE reservation(Date varchar(20),starttime varchar(20),duration varchar(20),parkingtype varchar(30)," +
                "parkingareaname varchar(20),floor varchar(20),"+
                "addons1 varchar(20),addons2 varchar(20),addons3 varchar(20) );");
        Db.execSQL("INSERT INTO reg VALUES('" + Date1 + "','" + StartTime1 + "','" + Duration1 + "','" + Parktype1 +
                "','" + AreaName1 + "','" + Floor1 + "','" + Addons1 + "','" + Addons2 + "','" + Addons3  + "'); ");


        System.out.println("sdfkhdsjkvbsckvbdxkv");
        Toast.makeText(this,"Registration Successfull!!",Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_user_registration_screen);
    }

}
