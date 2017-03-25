package com.tayloraliss.twilightimperiumcombatsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // Hide the action bar
        ((Button)findViewById(R.id.runSimulation)).setEnabled(false);

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String value = extras.getString("my-int");
//            TextView unchanged = (TextView) findViewById(R.id.unchanged);
//            unchanged.setText(value);
//        }

        Bundle myBundle = getIntent().getExtras();

        if (myBundle != null) {
            Log.d("test", String.valueOf(myBundle.getInt("fighters")));
            String test = String.valueOf(myBundle.getInt("fighters"));
            TextView unchanged = (TextView) findViewById(R.id.unchanged);
            unchanged.setText(test);
        }

//
//        String text = getIntent().getExtras().getString("my-int");
//        TextView unchanged = (TextView)findViewById(R.id.unchanged);
//        if (text != null) {
//            unchanged.setText(text);
//        }


        //    String data = getIntent().getExtras().getString("keyName");
    }

    public void switchToAssembleFleet(View view){
        Intent myIntent = new Intent(this, FleetAssembler.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        this.startActivity(myIntent);
    }





}
