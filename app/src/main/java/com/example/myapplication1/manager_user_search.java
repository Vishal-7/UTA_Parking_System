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

public class manager_user_search extends AppCompatActivity {

    public EditText UserName;
    public EditText LastName;
    public EditText FirstName;
    public EditText UTAID;
    public EditText PhoneNo;
    public EditText EmailID;
    public EditText LicenseNo;
    public EditText NoShows;
    public EditText Violations;
    public EditText Date1;
    public EditText Date2;
    public EditText Date3;
    public EditText PID1;
    public EditText PID2;
    public EditText PID3;
    public CheckBox ChBox1;
    public CheckBox ChBox2;
    public CheckBox ChBox3;
    public static Button btn1;
    public static Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_user_search);

    }

    public void test4(View view) {
        btn1 = (Button) findViewById(R.id.snoshowbtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(manager_user_search.this);
                build1.setMessage("Do you want to set a no show for this reservation ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The reservation has been set to no show",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The reservation has not been set to no show",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm No Show");
                alert.show();
            }
        });
    }

    public void test5(View view) {
        btn2 = (Button) findViewById(R.id.sovrbtn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(manager_user_search.this);
                build1.setMessage("Do you want to set this reservation to overdue ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The reservation has been set to overdue",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The reservation has not been set to overdue",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Overdue");
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
                startActivity(new Intent(manager_user_search.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UIsetup5() {

        UserName = (EditText) findViewById(R.id.etUserName);
        LastName = (EditText) findViewById(R.id.etFirstNameU);
        FirstName = (EditText) findViewById(R.id.etFirstName);
        UTAID = (EditText) findViewById(R.id.etUTAID);
        PhoneNo = (EditText) findViewById(R.id.etPhoneNO);
        EmailID = (EditText) findViewById(R.id.etEid);
        LicenseNo = (EditText) findViewById(R.id.etLicenseNO);
        NoShows = (EditText) findViewById(R.id.etNOShows);
        Violations = (EditText) findViewById(R.id.etViolations);

        Date1 = (EditText) findViewById(R.id.etDATE41);
        Date2 = (EditText) findViewById(R.id.etDATE42);
        Date3 = (EditText) findViewById(R.id.etDATE43);

        PID1 = (EditText) findViewById(R.id.etPID41);
        PID2 = (EditText) findViewById(R.id.etPID42);
        PID3 = (EditText) findViewById(R.id.etPID43);

        ChBox1 = (CheckBox) findViewById(R.id.chBox41);
        ChBox2 = (CheckBox) findViewById(R.id.chBox42);
        ChBox3 = (CheckBox) findViewById(R.id.chBox43);

    }

    public void insertdata5() {

        String UserName1 = UserName.getText().toString();

    }
}
