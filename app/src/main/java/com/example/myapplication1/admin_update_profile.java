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

public class admin_update_profile extends AppCompatActivity {

    public EditText LastName, FirstName, UTAID, PhoneNo, EmailID;
    SQLiteDatabase Db;
    String uname=MainActivity.Name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_profile);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        UISetup15();
        show();
        Button btn1 = (Button) findViewById(R.id.saveBtn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Toast.makeText(getApplicationContext(),"The Profile is updated.",Toast.LENGTH_LONG).show();
                startActivity(new Intent(admin_update_profile.this,admin_view_profile.class));
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
                startActivity(new Intent(admin_update_profile.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetup15() {

        LastName = (EditText) findViewById(R.id.etLastNameA);
        FirstName = (EditText) findViewById(R.id.etFirstNameA);
        UTAID = (EditText) findViewById(R.id.etUTAidA);
        PhoneNo = (EditText) findViewById(R.id.etPhoneNoA);
        EmailID = (EditText) findViewById(R.id.etEmailA);

    }

    public void insertData() {

        String LastNameA = LastName.getText().toString();
        String FirstNameA = FirstName.getText().toString();
        String UTAIDA = UTAID.getText().toString();
        String PhoneNoA = PhoneNo.getText().toString();
        String EmailIDA = EmailID.getText().toString();

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
    public void update(){
        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);
        ContentValues cv=new ContentValues();
        cv.put("fname",FirstName.getText().toString());
        cv.put("lname",LastName.getText().toString());
        //cv.put("username",Use.getText().toString());
        //cv.put("password",LastName1.getText().toString());
        cv.put("UTAID",UTAID.getText().toString());
        cv.put("phone",PhoneNo.getText().toString());
        cv.put("email",EmailID.getText().toString());
        cv.put("usertype","Admin");
        //cv.put("parkingtype","Basic");
        //cv.put("carinfo",Carinfo1.getText().toString());
        //cv.put("licenseno",License1.getText().toString());
        Db.update("reg",cv,"username=?",new String[]{uname});
        System.out.print("ndlksnfklsbfkdsbfksdbfd");
    }
}
