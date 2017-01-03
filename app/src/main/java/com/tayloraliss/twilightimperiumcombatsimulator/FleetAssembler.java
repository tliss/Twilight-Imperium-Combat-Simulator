package com.tayloraliss.twilightimperiumcombatsimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FleetAssembler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_assembler);
        getSupportActionBar().hide();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }
}
