package com.example.myapplication1;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password extends AppCompatActivity {
    private EditText EmailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EmailId = (EditText)findViewById(R.id.etEid);

        Button btn1 = (Button) findViewById(R.id.resetBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"The link is sent to your registered Email",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void insertdata1() {
        String EmailId1 = EmailId.getText().toString();
    }
}
