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

public class spot_details_search_screen extends AppCompatActivity {

    public static Button btn1;
    public static Button btn2;
    public Spinner ParkType,AreaName,Floor;
    public EditText SpotNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details_search_screen);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinParkType);
        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinAreaName);
        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinFloor);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingTypes));
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingAreaNames));
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Floor));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner1.setAdapter(myAdapter);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner3.setAdapter(myAdapter3);

    }

    public void test6(View view) {
        btn1 = (Button) findViewById(R.id.DelResbtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(spot_details_search_screen.this);
                build1.setMessage("Do you want to delete this reservation?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Your reservation has been deleted.",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Your reservation has not been deleted",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm reservation deletion");
                alert.show();
            }
        });
    }

    public void test7(View view) {
        btn2 = (Button) findViewById(R.id.MkSptunavail);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(spot_details_search_screen.this);
                build1.setMessage("Do you want make the spot unavailable?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The spot has been made unavailable",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The spot has not been made unavailable",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Closure");
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
                startActivity(new Intent(spot_details_search_screen.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"You have successfully Logged out!",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void UISetupviews1() {

        SpotNo = (EditText) findViewById(R.id.etSpotNo);
        ParkType = (Spinner) findViewById(R.id.spinParkType);
        AreaName = (Spinner) findViewById(R.id.spinAreaName);
        Floor = (Spinner) findViewById(R.id.spinFloor);

    }

    public void insertdata4() {

        String SpotNo1 = SpotNo.getText().toString();
        String ParkType1 = ParkType.getSelectedItem().toString();
        String AreaName1 = AreaName.getSelectedItem().toString();
        String Floor1 = Floor.getSelectedItem().toString();
    }
}
