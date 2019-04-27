package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.SigningInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Signin;
    private int counter = 5;
    SQLiteDatabase Db;
    public static String uname="",pwd="",utype="",Name1,Password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etUsername);

        Password = (EditText)findViewById(R.id.etPassword);
        Signin = (Button)findViewById(R.id.SignInBtn);

        //final String u=Name.getText()+"",p=Password.getText().toString();

        Toast.makeText(getApplicationContext(),Name1,Toast.LENGTH_LONG).show();



            Signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    insertdata2();
                    Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);
                    Cursor c = Db.rawQuery("Select usertype from reg where username = ? and password= ?",new String[]{Name1,Password1});
                    if (c !=  null&&c.moveToFirst()){
                        utype=(c.getString(0));
                        c.close();
                    }
                    if(utype.equals("User"))
                    {
                        startActivity(new Intent(MainActivity.this, user_hs.class));}
                     else if(utype.equals("a"))
                    {
                        startActivity(new Intent(MainActivity.this, user_hs.class));}

                    else if(utype.equals("Manager"))
                    {
                        startActivity(new Intent(MainActivity.this, mgr_hs.class));
                    }
                    else if(utype.equals("Admin"))
                    {
                        startActivity(new Intent(MainActivity.this, admin_hs.class));
                    }
                }
            });




        Button Signup = (Button) findViewById(R.id.SignUpBtn);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,user_registration_screen.class));
            }
        });

        Button Forgotpass = (Button) findViewById(R.id.ForgotPassBtn);

        Forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, forgot_password.class));
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equalsIgnoreCase("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, admin_hs.class);
            startActivity(intent);
        }
        else {
            counter--;
                Toast.makeText(getApplicationContext(),"You still have " + String.valueOf(counter),Toast.LENGTH_LONG).show();
            if(counter == 0){

              Signin.setEnabled(false);
            }
        }

    }

    public void insertdata2() {
        Name1 = Name.getText().toString();
        Password1 = Password.getText().toString();
    }

}
