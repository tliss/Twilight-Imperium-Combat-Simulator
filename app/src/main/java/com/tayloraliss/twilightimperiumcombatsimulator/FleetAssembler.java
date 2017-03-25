package com.tayloraliss.twilightimperiumcombatsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FleetAssembler extends AppCompatActivity implements View.OnClickListener{
//Read this: http://stackoverflow.com/questions/29304765/why-am-i-not-allowed-to-use-setonclicklistener-in-this-situation
//and This: http://stackoverflow.com/questions/40471106/why-do-we-implement-view-onclicklistener-if-we-can-have-to-set-androidonclick-e

    int numberOfFighters;
    int numberOfCarriers;
    int numberOfDestroyers;
    int numberOfCruisers;
    int numberOfDreadnaughts ;
    int numberOfWarsuns;

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_assembler);
        getSupportActionBar().hide();

        Bundle myBundle = getIntent().getExtras();

        numberOfFighters = myBundle.getInt("fighters");
        TextView fighterDisp = (TextView) findViewById(R.id.fighterNumText);
        fighterDisp.setText(String.valueOf(numberOfFighters));

        numberOfCarriers = myBundle.getInt("carriers");
        TextView carrierDisp = (TextView) findViewById(R.id.carrierNumText);
        carrierDisp.setText(String.valueOf(numberOfCarriers));

        numberOfDestroyers = myBundle.getInt("destroyers");
        TextView destroyerDisp = (TextView) findViewById(R.id.destroyerNumText);
        destroyerDisp.setText(String.valueOf(numberOfDestroyers));

        numberOfCruisers = myBundle.getInt("cruisers");
        TextView cruiserDisp = (TextView) findViewById(R.id.cruiserNumText);
        cruiserDisp.setText(String.valueOf(numberOfCruisers));

        numberOfDreadnaughts = myBundle.getInt("dreadnaughts");
        TextView dreadnaughtDisp = (TextView) findViewById(R.id.dreadnaughtNumText);
        dreadnaughtDisp.setText(String.valueOf(numberOfDreadnaughts));

        numberOfWarsuns = myBundle.getInt("warsuns");
        TextView warsunDisp = (TextView) findViewById(R.id.warsunNumText);
        warsunDisp.setText(String.valueOf(numberOfWarsuns));

        Button minusOne = (Button) findViewById(R.id.button_0);
        minusOne.setOnClickListener(this);
        Button plusOne = (Button) findViewById(R.id.button_1);
        plusOne.setOnClickListener(this);
        Button minusTwo = (Button) findViewById(R.id.button_2);
        minusTwo.setOnClickListener(this);
        Button plusTwo = (Button) findViewById(R.id.button_3);
        plusTwo.setOnClickListener(this);
        Button minusThree = (Button) findViewById(R.id.button_4);
        minusThree.setOnClickListener(this);
        Button plusThree = (Button) findViewById(R.id.button_5);
        plusThree.setOnClickListener(this);
        Button minusFour = (Button) findViewById(R.id.button_6);
        minusFour.setOnClickListener(this);
        Button plusFour = (Button) findViewById(R.id.button_7);
        plusFour.setOnClickListener(this);
        Button minusFive = (Button) findViewById(R.id.button_8);
        minusFive.setOnClickListener(this);
        Button plusFive = (Button) findViewById(R.id.button_9);
        plusFive.setOnClickListener(this);
        Button minusSix = (Button) findViewById(R.id.button_10);
        minusSix.setOnClickListener(this);
        Button plusSix = (Button) findViewById(R.id.button_11);
        plusSix.setOnClickListener(this);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View b) {

        TextView shipZeroNum;

        switch (b.getId()){
            case R.id.button_0:
                if (numberOfFighters > 0)
                    numberOfFighters -= 1;
                shipZeroNum = (TextView) findViewById(R.id.fighterNumText);
                shipZeroNum.setText(String.valueOf(numberOfFighters));
                break;
            case R.id.button_1:
                numberOfFighters += 1;
                shipZeroNum = (TextView) findViewById(R.id.fighterNumText);
                shipZeroNum.setText(String.valueOf(numberOfFighters));
                break;
            case R.id.button_2:
                if (numberOfCarriers > 0)
                    numberOfCarriers -= 1;
                shipZeroNum = (TextView) findViewById(R.id.carrierNumText);
                shipZeroNum.setText(String.valueOf(numberOfCarriers));
                break;
            case R.id.button_3:
                numberOfCarriers += 1;
                shipZeroNum = (TextView) findViewById(R.id.carrierNumText);
                shipZeroNum.setText(String.valueOf(numberOfCarriers));
                break;
            case R.id.button_4:
                if (numberOfDestroyers > 0)
                    numberOfDestroyers -= 1;
                shipZeroNum = (TextView) findViewById(R.id.destroyerNumText);
                shipZeroNum.setText(String.valueOf(numberOfDestroyers));
                break;
            case R.id.button_5:
                numberOfDestroyers += 1;
                shipZeroNum = (TextView) findViewById(R.id.destroyerNumText);
                shipZeroNum.setText(String.valueOf(numberOfDestroyers));
                break;
            case R.id.button_6:
                if (numberOfCruisers > 0)
                    numberOfCruisers -= 1;
                shipZeroNum = (TextView) findViewById(R.id.cruiserNumText);
                shipZeroNum.setText(String.valueOf(numberOfCruisers));
                break;
            case R.id.button_7:
                numberOfCruisers += 1;
                shipZeroNum = (TextView) findViewById(R.id.cruiserNumText);
                shipZeroNum.setText(String.valueOf(numberOfCruisers));
                break;
            case R.id.button_8:
                if (numberOfDreadnaughts > 0)
                    numberOfDreadnaughts -= 1;
                shipZeroNum = (TextView) findViewById(R.id.dreadnaughtNumText);
                shipZeroNum.setText(String.valueOf(numberOfDreadnaughts));
                break;
            case R.id.button_9:
                numberOfDreadnaughts += 1;
                shipZeroNum = (TextView) findViewById(R.id.dreadnaughtNumText);
                shipZeroNum.setText(String.valueOf(numberOfDreadnaughts));
                break;
            case R.id.button_10:
                if (numberOfWarsuns > 0)
                    numberOfWarsuns -= 1;
                shipZeroNum = (TextView) findViewById(R.id.warsunNumText);
                shipZeroNum.setText(String.valueOf(numberOfWarsuns));
                break;
            case R.id.button_11:
                numberOfWarsuns += 1;
                shipZeroNum = (TextView) findViewById(R.id.warsunNumText);
                shipZeroNum.setText(String.valueOf(numberOfWarsuns));
                break;

            //http://www.survivingwithandroid.com/2012/09/passing-data-between-activities-2.html
            case R.id.submit:
                Intent myIntent = new Intent(FleetAssembler.this, MainActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                Bundle myBundle = new Bundle();

                myBundle.putInt("fighters", numberOfFighters);
                myBundle.putInt("carriers", numberOfCarriers);
                myBundle.putInt("destroyers", numberOfDestroyers);
                myBundle.putInt("cruisers", numberOfCruisers);
                myBundle.putInt("dreadnaughts", numberOfDreadnaughts);
                myBundle.putInt("warsuns", numberOfWarsuns);

                myIntent.putExtras(myBundle);

                startActivity(myIntent);
        }
    }
}