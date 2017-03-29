package com.tayloraliss.twilightimperiumcombatsimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class simulator extends AppCompatActivity {

    int yourFleetNumberOfFighters;
    int yourFleetNumberOfCarriers;
    int yourFleetNumberOfDestroyers;
    int yourFleetNumberOfCruisers;
    int yourFleetNumberOfDreadnaughts;
    int yourFleetNumberOfWarsuns;

    int enemyFleetNumberOfFighters;
    int enemyFleetNumberOfCarriers;
    int enemyFleetNumberOfDestroyers;
    int enemyFleetNumberOfCruisers;
    int enemyFleetNumberOfDreadnaughts;
    int enemyFleetNumberOfWarsuns;

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator);
        getSupportActionBar().hide();

        Bundle myBundle = getIntent().getExtras();

        yourFleetNumberOfFighters = myBundle.getInt("yourFighters");
        yourFleetNumberOfCarriers = myBundle.getInt("yourCarriers");
        yourFleetNumberOfDestroyers = myBundle.getInt("yourDestroyers");
        yourFleetNumberOfCruisers = myBundle.getInt("yourCruisers");
        yourFleetNumberOfDreadnaughts = myBundle.getInt("yourDreadnaughts");
        yourFleetNumberOfWarsuns = myBundle.getInt("yourWarsuns");

        enemyFleetNumberOfFighters = myBundle.getInt("enemyFighters");
        enemyFleetNumberOfCarriers = myBundle.getInt("enemyCarriers");
        enemyFleetNumberOfDestroyers = myBundle.getInt("enemyDestroyers");
        enemyFleetNumberOfCruisers = myBundle.getInt("enemyCruisers");
        enemyFleetNumberOfDreadnaughts = myBundle.getInt("enemyDreadnaughts");
        enemyFleetNumberOfWarsuns = myBundle.getInt("enemyWarsuns");
    }
}
