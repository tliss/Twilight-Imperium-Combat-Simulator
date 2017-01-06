package com.tayloraliss.twilightimperiumcombatsimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class FleetAssembler extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_assembler);
        getSupportActionBar().hide();

        final int BUTTON_COUNT = 12;

        for (int i2 = 0; i2 < BUTTON_COUNT; i2++) {
            final int i = i2;
            final int btn_id = getResources().getIdentifier("button_" + i, "id", getPackageName());

            Button btn = (Button) findViewById(btn_id );
            btn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if (i%2 == 0)
                    {
                        final int id = getResources().getIdentifier("ship_" + i, "id", getPackageName());
                        minus(id);
                        update(id);
                    }
                    else
                    {
                        final int id = getResources().getIdentifier("ship_" + (i-1), "id", getPackageName());
                        System.out.println("ID is " + id);
                        plus(id);
                        update(id);
                    }
                }
            });
        }
    }

    Map<Integer, Integer> values = new HashMap<>();

    public void plus(int id) {

        Integer oldValue = values.get(id);
        if (oldValue == null) {
            values.put(id, 1);
        }
        else
        {
            values.put(id, oldValue + 1);
        }
    }

    public void minus(int id) {
        Integer oldValue = values.get(id);
        if (oldValue == null) {
            values.put(id, 0);
        }
        else
        {
            if (oldValue == 0){
                return;
            }
            else {
                values.put(id, oldValue - 1);
            }
        }
    }

    public void update(int id) {
        TextView view = (TextView) findViewById(id);
        Integer value = values.get(id);
        if (value != null) {
            view.setText(String.valueOf(value));
        }
        else
        {
            view.setText("0");
        }
    }
}