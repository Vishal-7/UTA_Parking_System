package com.example.myapplication1;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class modify_reservation_screen extends AppCompatActivity {

    public EditText ParkingID, SpotNo, Date, StartTime, Duration;
    public Spinner ParkingType, ParkingArea, ParkingFloor;
    public CheckBox Cart, History, Camera;
    String Addon1, Addon2, Addon3;

    public static Button btnconfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_reservation_screen);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ParkingType = (Spinner) findViewById(R.id.spinParkType);
        ParkingArea = (Spinner) findViewById(R.id.spinAreaName);
        ParkingFloor = (Spinner) findViewById(R.id.spinFloor);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingTypes));
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingAreaNames));
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Floor));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ParkingType.setAdapter(myAdapter);
        ParkingArea.setAdapter(myAdapter2);
        ParkingFloor.setAdapter(myAdapter3);
    }

    public void test3(View view) {
        btnconfirm = (Button) findViewById(R.id.confirmbtn1);
        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(modify_reservation_screen.this);
                build1.setMessage("Do you want to confirm the Reservation?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Your reservation has been modified",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Your reservation has not been modified",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Modification");
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
                startActivity(new Intent(modify_reservation_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISteup6() {

        ParkingID = (EditText) findViewById(R.id.etParkingId);
        SpotNo = (EditText) findViewById(R.id.etSpotNo);
        Date = (EditText) findViewById(R.id.etDate);
        StartTime = (EditText) findViewById(R.id.etStartTime);
        Duration = (EditText) findViewById(R.id.etDuration);
        Cart = (CheckBox) findViewById(R.id.cboxCart);
        History = (CheckBox) findViewById(R.id.cboxHistory);
        Camera = (CheckBox) findViewById(R.id.cboxCamera);

    }

    public void insertdata3() {

        String ParkingID1 = ParkingID.getText().toString();
        String SpotNo1 = SpotNo.getText().toString();
        String Date1 = Date.getText().toString();
        String StartTime1 = StartTime.getText().toString();
        String Duration1 = Duration.getText().toString();

        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Cart.isChecked()) {
                    Addon1 = "Cart";
                }
            }
        });
        
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (History.isChecked()) {
                    Addon2 = "History";
                }
            }
        });
        
        Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Camera.isChecked()) {
                    Addon3 = "Camera";
                }
            }
        });

    }
}
