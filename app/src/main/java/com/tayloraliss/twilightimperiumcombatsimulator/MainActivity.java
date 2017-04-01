package com.tayloraliss.twilightimperiumcombatsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    boolean p1Ready;
    boolean p2Ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // Hide the action bar
        findViewById(R.id.runSimulation).setEnabled(false); //Disable runSimulation button

        Button yourAssemble = (Button) findViewById(R.id.yourAssemble);
        yourAssemble.setOnClickListener(this);
        Button enemyAssemble = (Button) findViewById(R.id.enemyAssemble);
        enemyAssemble.setOnClickListener(this);
        Button runSimulation = (Button) findViewById(R.id.runSimulation);
        runSimulation.setOnClickListener(this);

        Bundle myBundle = getIntent().getExtras();

        if (myBundle != null) {
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

            p1Ready = myBundle.getBoolean("p1Ready");
            p2Ready = myBundle.getBoolean("p2Ready");
        }

        if (p1Ready) {
            yourAssemble.setText("ASSEMBLED");
        }
        if (p2Ready) {
            enemyAssemble.setText("ASSEMBLED");
        }
        if (p1Ready && p2Ready) {
            findViewById(R.id.runSimulation).setEnabled(true);
        }
    }

    @Override
    public void onClick(View b) {
        switch (b.getId()) {
            case R.id.yourAssemble:
                switchToAssembleFleet("you");
                break;
            case R.id.enemyAssemble:
                switchToAssembleFleet("enemy");
                break;
            case R.id.runSimulation:
                switchToSimulator();
                break;
        }
    }

    public void switchToAssembleFleet(String owner){
        Intent myIntent = new Intent(MainActivity.this, FleetAssembler.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        Bundle myBundle = new Bundle();

        //Pack up variables into bundle
        myBundle.putInt("yourFighters", yourFleetNumberOfFighters);
        myBundle.putInt("yourCarriers", yourFleetNumberOfCarriers);
        myBundle.putInt("yourDestroyers", yourFleetNumberOfDestroyers);
        myBundle.putInt("yourCruisers", yourFleetNumberOfCruisers);
        myBundle.putInt("yourDreadnaughts", yourFleetNumberOfDreadnaughts);
        myBundle.putInt("yourWarsuns", yourFleetNumberOfWarsuns);

        myBundle.putInt("enemyFighters", enemyFleetNumberOfFighters);
        myBundle.putInt("enemyCarriers", enemyFleetNumberOfCarriers);
        myBundle.putInt("enemyDestroyers", enemyFleetNumberOfDestroyers);
        myBundle.putInt("enemyCruisers", enemyFleetNumberOfCruisers);
        myBundle.putInt("enemyDreadnaughts", enemyFleetNumberOfDreadnaughts);
        myBundle.putInt("enemyWarsuns", enemyFleetNumberOfWarsuns);

        myBundle.putBoolean("p1Ready", p1Ready);
        myBundle.putBoolean("p2Ready", p2Ready);

        myBundle.putString("owner", owner);

        myIntent.putExtras(myBundle);

        this.startActivity(myIntent);
    }
    public void switchToSimulator(){
        Intent myIntent = new Intent(MainActivity.this, simulator.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        Bundle myBundle = new Bundle();

        //Pack up variables into bundle
        myBundle.putInt("yourFighters", yourFleetNumberOfFighters);
        myBundle.putInt("yourCarriers", yourFleetNumberOfCarriers);
        myBundle.putInt("yourDestroyers", yourFleetNumberOfDestroyers);
        myBundle.putInt("yourCruisers", yourFleetNumberOfCruisers);
        myBundle.putInt("yourDreadnaughts", yourFleetNumberOfDreadnaughts);
        myBundle.putInt("yourWarsuns", yourFleetNumberOfWarsuns);

        myBundle.putInt("enemyFighters", enemyFleetNumberOfFighters);
        myBundle.putInt("enemyCarriers", enemyFleetNumberOfCarriers);
        myBundle.putInt("enemyDestroyers", enemyFleetNumberOfDestroyers);
        myBundle.putInt("enemyCruisers", enemyFleetNumberOfCruisers);
        myBundle.putInt("enemyDreadnaughts", enemyFleetNumberOfDreadnaughts);
        myBundle.putInt("enemyWarsuns", enemyFleetNumberOfWarsuns);

        myIntent.putExtras(myBundle);

        this.startActivity(myIntent);
    }
}
