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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class admin_edit_user_profile extends AppCompatActivity {

    public EditText LastName,FirstName,UTAID,PhoneNo,EmailID,LicenseNo,NoShows,Violations;
    public Spinner UserType;

    public static Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_user_profile);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        UserType = (Spinner) findViewById(R.id.spinUserType3);


        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.UserTypes));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        UserType.setAdapter(myAdapter1);

    }

    public void test8(View view) {
        btn1 = (Button) findViewById(R.id.Savebtn12);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(admin_edit_user_profile.this);
                build1.setMessage("Do you want to save the changes ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The Profile has been updated",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The Profile has not been updated",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm update profile");
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
                startActivity(new Intent(admin_edit_user_profile.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup17() {

        LastName = (EditText) findViewById(R.id.etLastName3);
        FirstName = (EditText) findViewById(R.id.etFirstName3);
        UTAID = (EditText) findViewById(R.id.etUTAID3);
        PhoneNo = (EditText) findViewById(R.id.etPhoneNo3);
        EmailID = (EditText) findViewById(R.id.etEmailID3);
        LicenseNo = (EditText) findViewById(R.id.etLicenseNo3);
        NoShows = (EditText) findViewById(R.id.etNoShow3);
        Violations = (EditText) findViewById(R.id.etViolations3);

    }

    public void insertData14() {

        String LastName8 = LastName.getText().toString();
        String FirstName8 = FirstName.getText().toString();
        String UTAID8 = UTAID.getText().toString();
        String PhoneNo8 = PhoneNo.getText().toString();
        String EmailID8 = EmailID.getText().toString();
        String LicenseNo8 = LicenseNo.getText().toString();
        String NoShows8 = NoShows.getText().toString();
        String Violations8 = Violations.getText().toString();
        String USerType = UserType.getSelectedItem().toString();

    }

}
