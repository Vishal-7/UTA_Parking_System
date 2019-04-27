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
import android.widget.EditText;
import android.widget.Toast;

public class admin_search_user extends AppCompatActivity {

    public EditText UserName,LastName,FirstName,UTAID,PhoneNo,EmailID,LicenseNo,NoShows,Violations,UserType;

    public static Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_search_user);

        Button btn1 = (Button) findViewById(R.id.Editbtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin_search_user.this, admin_edit_user_profile.class));
            }
        });

    }

    public void test9(View view) {
        btn2 = (Button) findViewById(R.id.RevokeUserbtn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(admin_search_user.this);
                build1.setMessage("Do you want to revoke this user ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The user has been revoked",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The user has not been revoked",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Revoke");
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
                startActivity(new Intent(admin_search_user.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup16() {

        UserName = (EditText) findViewById(R.id.etUserName0);
        LastName = (EditText) findViewById(R.id.etLastName3);
        FirstName = (EditText) findViewById(R.id.etFirstName3);
        UTAID = (EditText) findViewById(R.id.etUTAID3);
        PhoneNo = (EditText) findViewById(R.id.etPhoneNo3);
        EmailID = (EditText) findViewById(R.id.etEmailID3);
        LicenseNo = (EditText) findViewById(R.id.etLicenseNo3);
        NoShows = (EditText) findViewById(R.id.etNoShow3);
        Violations = (EditText) findViewById(R.id.etViolations3);
        UserType = (EditText) findViewById(R.id.etUserType0);

    }
}
