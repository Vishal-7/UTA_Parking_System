package com.example.myapplication1;

import android.app.ActionBar;
import android.content.ContentValues;
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

public class manager_update_profile extends AppCompatActivity {

    public EditText LastName, FirstName, UTAId, PhoneNum, EmailId;
    SQLiteDatabase Db;String uname=MainActivity.Name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_update_profile);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        UISetup7();
        show();
        Button btn1 = (Button) findViewById(R.id.saveBtn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Toast.makeText(getApplicationContext(),"Your profile has been updated!.",Toast.LENGTH_LONG).show();
                startActivity(new Intent(manager_update_profile.this,manager_view_profile.class));
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
                startActivity(new Intent(manager_update_profile.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup7() {

        LastName = (EditText) findViewById(R.id.etFirstNameU);
        FirstName = (EditText) findViewById(R.id.etFirstName);
        UTAId = (EditText) findViewById(R.id.etUtaID);
        PhoneNum = (EditText) findViewById(R.id.etPhoneNum);
        EmailId = (EditText) findViewById(R.id.etEid);

    }

    public void getdata4() {

        String LastName3 = LastName.getText().toString();
        String FirstName3 = FirstName.getText().toString();
        String UTAId3 = UTAId.getText().toString();
        String PhoneNum3 = PhoneNum.getText().toString();
        String EmailId3 = EmailId.getText().toString();

    }
    public void show(){

        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);

        Cursor c = Db.rawQuery("SELECT * FROM  reg where username=?;",new String[]{uname});
        if (c !=  null&&c.moveToFirst()){
            LastName.setText(c.getString(1));
            FirstName.setText(c.getString(0));
            UTAId.setText(c.getString(4));
            PhoneNum.setText(c.getString(5));
            EmailId.setText(c.getString(6));
            c.close();
        }
        else {
            Toast.makeText(this,"No values",Toast.LENGTH_LONG).show();
        }
        //setContentView(R.layout.activity_user_prof_screen);
    }
    public void update(){
        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);
        ContentValues cv=new ContentValues();
        cv.put("fname",FirstName.getText().toString());
        cv.put("lname",LastName.getText().toString());
        //cv.put("username",Use.getText().toString());
        //cv.put("password",LastName1.getText().toString());
        cv.put("UTAID",UTAId.getText().toString());
        cv.put("phone",PhoneNum.getText().toString());
        cv.put("email",EmailId.getText().toString());
        cv.put("usertype","Manager");
        //cv.put("parkingtype","Basic");
        //cv.put("carinfo",Carinfo1.getText().toString());
        //cv.put("licenseno",License1.getText().toString());
        Db.update("reg",cv,"username=?",new String[]{uname});
        System.out.print("ndlksnfklsbfkdsbfksdbfd");
    }


}
