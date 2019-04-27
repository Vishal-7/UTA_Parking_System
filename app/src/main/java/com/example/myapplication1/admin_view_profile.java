package com.example.myapplication1;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_view_profile extends AppCompatActivity {

    public EditText LastName,FirstName,UTAID,PhoneNo,EmailID;
    SQLiteDatabase Db;
    String uname=MainActivity.Name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_profile);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        UISetup14();
        show();
        Button btn1 = (Button) findViewById(R.id.updateBtn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin_view_profile.this, admin_update_profile.class));
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
                startActivity(new Intent(admin_view_profile.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup14() {

        LastName = (EditText) findViewById(R.id.etLastNAME);
        FirstName = (EditText) findViewById(R.id.etFirstNAME);
        UTAID = (EditText) findViewById(R.id.etUtaID);
        PhoneNo = (EditText) findViewById(R.id.etPHONEno);
        EmailID = (EditText) findViewById(R.id.etEMAILid);

    }
    public void show(){

        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);

        Cursor c = Db.rawQuery("SELECT * FROM  reg where username=?;",new String[]{uname});
        if (c !=  null&&c.moveToFirst()){
            LastName.setText(c.getString(1));
            FirstName.setText(c.getString(0));
            UTAID.setText(c.getString(4));
            PhoneNo.setText(c.getString(5));
            EmailID.setText(c.getString(6));

            c.close();
        }
        else {
            Toast.makeText(this,"No values",Toast.LENGTH_LONG).show();
        }
        //setContentView(R.layout.activity_user_prof_screen);
    }
}
