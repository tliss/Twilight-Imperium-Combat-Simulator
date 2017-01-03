package com.tayloraliss.twilightimperiumcombatsimulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void switchToAssembleFleet(View view){
        Intent myIntent = new Intent(this, FleetAssembler.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        this.startActivity(myIntent);
    }
}
