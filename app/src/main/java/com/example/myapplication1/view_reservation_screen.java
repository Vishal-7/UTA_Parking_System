package com.example.myapplication1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class view_reservation_screen extends AppCompatActivity {

    public EditText PID1,PID2,PID3,Date1,Date2,Date3,Stime1,Stime2,Stime3,PIDShow,SpotNoShow,DateShow,StartTimeShow,DurationShow,ParkTypeShow,AreaNameShow,FloorShow,CostShow;
    public CheckBox ChBox1,ChBox2,ChBox3,CartShow,CameraShow,HistoryShow;

    public static Button btn0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservation_screen);

        Button btn1 = (Button) findViewById(R.id.modifyres);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view_reservation_screen.this, modify_reservation_screen.class));
            }
        });
    }

    public void test2(View view) {
        btn0 = (Button) findViewById(R.id.cancelres);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(view_reservation_screen.this);
                build1.setMessage("Do you want to cancel the Reservation?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Your reservation has been canelled",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Your reservation has not been cancelled",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Cancellation");
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
                startActivity(new Intent(view_reservation_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup10() {

        PID1 = (EditText) findViewById(R.id.etPID11);
        PID2 = (EditText) findViewById(R.id.etPID12);
        PID3 = (EditText) findViewById(R.id.etPID13);

        Date1 = (EditText) findViewById(R.id.etDATE11);
        Date2 = (EditText) findViewById(R.id.etDATE12);
        Date3 = (EditText) findViewById(R.id.etDATE13);

        Stime1 = (EditText) findViewById(R.id.etSTIME11);
        Stime2 = (EditText) findViewById(R.id.etSTIME12);
        Stime3 = (EditText) findViewById(R.id.etSTIME13);

        ChBox1 = (CheckBox) findViewById(R.id.cbox1);
        ChBox2 = (CheckBox) findViewById(R.id.cbox2);
        ChBox3 = (CheckBox) findViewById(R.id.cbox3);

        PIDShow = (EditText) findViewById(R.id.etPIDShow);
        SpotNoShow = (EditText) findViewById(R.id.etSPOTNOShow);
        DateShow = (EditText) findViewById(R.id.etDATEShow);
        StartTimeShow = (EditText) findViewById(R.id.etSTIMEShow);
        DurationShow = (EditText) findViewById(R.id.etDURATIONShow);
        ParkTypeShow = (EditText) findViewById(R.id.etPARKTYPEShow);
        AreaNameShow = (EditText) findViewById(R.id.etAREANAMEShow);
        FloorShow = (EditText) findViewById(R.id.etFLOORShow);
        CostShow = (EditText) findViewById(R.id.etCOSTShow);

        CartShow = (CheckBox) findViewById(R.id.cboxCARTShow);
        CameraShow = (CheckBox) findViewById(R.id.cboxCAMERAShow);
        HistoryShow = (CheckBox) findViewById(R.id.cboxHISTORYShow);


    }
}

