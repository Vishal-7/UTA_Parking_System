package com.example.myapplication1;

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

public class user_edit_prof_screen extends AppCompatActivity {
    public EditText LastName1,FirstName1,UTAid1,PhoneNo1,Email1,Carinfo1,License1;
    SQLiteDatabase Db;
    String uname=MainActivity.Name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_prof_screen);
        System.out.println(uname);
        Button btn1 = (Button) findViewById(R.id.SaveBtn1);
        LastName1 = (EditText) findViewById(R.id.etLastNameU);
        FirstName1 = (EditText) findViewById(R.id.etFirstNameU);
        UTAid1 = (EditText) findViewById(R.id.etUTAid);
        PhoneNo1 = (EditText) findViewById(R.id.etPhNo);
        Email1 = (EditText) findViewById(R.id.etEmail);
        Carinfo1 = (EditText) findViewById(R.id.etCarInfo);
        License1 = (EditText) findViewById(R.id.etLicense);
        show();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Toast.makeText(getApplicationContext(),"Profile Updated",Toast.LENGTH_LONG).show();
                startActivity(new Intent(user_edit_prof_screen.this,user_prof_screen.class));
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
                startActivity(new Intent(user_edit_prof_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void insertdata3() {

        String LastName2 = LastName1.getText().toString();
        String FirstName2 = FirstName1.getText().toString();
        String UTAid2 = UTAid1.getText().toString();
        String PhoneNo2 = PhoneNo1.getText().toString();
        String Email2 = Email1.getText().toString();
        String Carinfo2 = Carinfo1.getText().toString();
        String License2 = License1.getText().toString();

    }
    public void show(){

        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);

        Cursor c = Db.rawQuery("SELECT * FROM  reg where username=?;",new String[]{uname});
        if (c !=  null&&c.moveToFirst()){
            LastName1.setText(c.getString(1));
            FirstName1.setText(c.getString(0));
            UTAid1.setText(c.getString(4));
            PhoneNo1.setText(c.getString(5));
            Email1.setText(c.getString(6));
            Carinfo1.setText(c.getString(9));
            License1.setText(c.getString(10));

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
        cv.put("fname",FirstName1.getText().toString());
        cv.put("lname",LastName1.getText().toString());
        //cv.put("username",Use.getText().toString());
        //cv.put("password",LastName1.getText().toString());
        cv.put("UTAID",UTAid1.getText().toString());
        cv.put("phone",PhoneNo1.getText().toString());
        cv.put("email",Email1.getText().toString());
        cv.put("usertype","User");
        cv.put("parkingtype","Basic");
        cv.put("carinfo",Carinfo1.getText().toString());
        cv.put("licenseno",License1.getText().toString());
        Db.update("reg",cv,"username=?",new String[]{uname});
        System.out.print("ndlksnfklsbfkdsbfksdbfd");
    }
}
