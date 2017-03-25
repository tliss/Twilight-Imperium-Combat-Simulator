package com.tayloraliss.twilightimperiumcombatsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int yourFleetNumberOfFighters;
    int yourFleetNumberOfCarriers;
    int yourFleetNumberOfDestroyers;
    int yourFleetNumberOfCruisers;
    int yourFleetNumberOfDreadnaughts;
    int yourFleetNumberOfWarsuns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // Hide the action bar
        ((Button)findViewById(R.id.runSimulation)).setEnabled(false);

        Bundle myBundle = getIntent().getExtras();

        if (myBundle != null) {

            yourFleetNumberOfFighters = myBundle.getInt("fighters");
            yourFleetNumberOfCarriers = myBundle.getInt("carriers");
            yourFleetNumberOfDestroyers = myBundle.getInt("destroyers");
            yourFleetNumberOfCruisers = myBundle.getInt("cruisers");
            yourFleetNumberOfDreadnaughts = myBundle.getInt("dreadnaughts");
            yourFleetNumberOfWarsuns = myBundle.getInt("warsuns");

        }
    }

    public void switchToAssembleFleet(View view){
        Intent myIntent = new Intent(MainActivity.this, FleetAssembler.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        Bundle myBundle = new Bundle();

        myBundle.putInt("fighters", yourFleetNumberOfFighters);
        myBundle.putInt("carriers", yourFleetNumberOfCarriers);
        myBundle.putInt("destroyers", yourFleetNumberOfDestroyers);
        myBundle.putInt("cruisers", yourFleetNumberOfCruisers);
        myBundle.putInt("dreadnaughts", yourFleetNumberOfDreadnaughts);
        myBundle.putInt("warsuns", yourFleetNumberOfWarsuns);

        myIntent.putExtras(myBundle);

        this.startActivity(myIntent);
    }





}
