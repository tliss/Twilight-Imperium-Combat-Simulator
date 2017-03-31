package com.tayloraliss.twilightimperiumcombatsimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tayloraliss.twilightimperiumcombatsimulator.ships.Player;
import com.tayloraliss.twilightimperiumcombatsimulator.ships.Ship;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class simulator extends AppCompatActivity {

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

        ArrayList<Integer> yourFleet = new ArrayList<Integer>();
        ArrayList<Integer> enemyFleet = new ArrayList<Integer>();

        Bundle myBundle = getIntent().getExtras();

        yourFleet.add(myBundle.getInt("yourFighters"));
        yourFleet.add(myBundle.getInt("yourCarriers"));
        yourFleet.add(myBundle.getInt("yourDestroyers"));
        yourFleet.add(myBundle.getInt("yourCruisers"));
        yourFleet.add(myBundle.getInt("yourDreadnaughts"));
        yourFleet.add(myBundle.getInt("yourWarsuns"));

        enemyFleet.add(myBundle.getInt("enemyFighters"));
        enemyFleet.add(myBundle.getInt("enemyCarriers"));
        enemyFleet.add(myBundle.getInt("enemyDestroyers"));
        enemyFleet.add(myBundle.getInt("enemyCruisers"));
        enemyFleet.add(myBundle.getInt("enemyDreadnaughts"));
        enemyFleet.add(myBundle.getInt("enemyWarsuns"));

        Player p1 = new Player(yourFleet);
        Player p2 = new Player(enemyFleet);

        int p1Win = 0;
        int p2Win = 0;
        int draw = 0;
        final int SIMLENGTH = 1000;

        //Simulation starts here
        for (int x=0; x<SIMLENGTH; x++){

            int round = 1;
            int p1Hits = 0;
            int p2Hits = 0;

            for (Ship ship : p1.fleet){
                ship.initialize();
            }

            for (Ship ship : p2.fleet){
                ship.initialize();
            }

            for (Ship ship : p1.fleet){
                System.out.println(ship.returnName() + " : " + ship.returnHealth() + " | ");
            }

            for (Ship ship : p2.fleet){
                System.out.println(ship.returnName() + " : " + ship.returnHealth() + " | ");
            }

            //"^^^^^COMBAT BEGINNING^^^^^

            // Destroyer's fire anti-fighter barrage
            if (p1.returnShipNumber("destroyer") > 0 || p2.returnShipNumber("destroyer") > 0){
                antiFighterBarrage(p1, p2);
            }

            // Main combat round
            while ((p1.fleetIsDead()) && (p2.fleetIsDead())){

                //p1 attacks
                p1Hits = p1.shipAttack();

                //p2 attacks
                p2Hits = p2.shipAttack();


                for (int i=p2Hits; i>0; i--){
                    if (p1.fleetIsDead()) {
                        System.out.print("Player 1's ");
                        p1.takeAHit();
                    }
                }

                for (int i=p1Hits; i>0; i--){
                    if (p2.fleetIsDead()) {
                        System.out.print("Player 2's ");
                        p2.takeAHit();
                    }
                }

                round++;
            }

            //"Player 1's fleet has been eliminated! Player 2 wins!"
            if ((p1.fleetIsDead()) && (p2.fleetIsDead())){

                p2Win++;
            }

            //"Player 2's fleet has been eliminated! Player 1 wins!"
            else if ((p1.fleetIsDead()) && (p2.fleetIsDead())){

                p1Win++;
            }

            //"Both fleets have been annihilated!"
            else if ((p1.fleetIsDead()) && (p2.fleetIsDead())){

                draw++;
            }
        }

        float chanceOfVictory;
        float chanceOfMAD;

        if (p1Win == 0){
            chanceOfVictory = 0;
            chanceOfMAD = 0;
        }
        else if (p1Win == 100){
            chanceOfVictory = 100;
            chanceOfMAD = 0;
        }
        else if (draw == 100){
            chanceOfVictory = 0;
            chanceOfMAD = 100;
        }
        else
        {
            chanceOfVictory = ((float)p1Win / (float)(p1Win+p2Win+draw)) * 100;
            chanceOfMAD = ((float)draw / (float)(p1Win+p2Win+draw)) * 100;
        }

        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);


        //System.out.println("Player 1 won " + p1Win + " battles.\nPlayer 2 won " + p2Win + " battles.\nBoth fleets were destroyed in " + draw + " battles.");
        //System.out.println("If you pursue this plan of action, your fleet has a " + df.format(chanceOfVictory) + "% chance of survival and there is a " + df.format(chanceOfMAD) + "% chance of both fleets being destroyed.");
    }

    // Destroyer anti-fighter barrage
    public static void antiFighterBarrage(Player pFirst, Player pSecond){

        int hits = 0;

        if (pSecond.returnShipNumber("fighter") > 0){
            for (int i=0; i<pFirst.returnShipNumber("destroyer"); i++){
                hits = hits + pFirst.destroyerBarrage();
                hits = hits + pFirst.destroyerBarrage();
            }
        }

        while ((hits > 0) && (pSecond.returnShipNumber("fighter") > 0)){
            pSecond.takeAHit();
            hits--;
        }

        hits = 0;
        if (pFirst.returnShipNumber("fighter") > 0){
            for (int i=0; i<pSecond.returnShipNumber("destroyer"); i++){
                hits = hits + pSecond.destroyerBarrage();
                hits = hits + pFirst.destroyerBarrage();
            }
        }

        while ((hits > 0) && (pFirst.returnShipNumber("fighter") > 0)){
            pFirst.takeAHit();
            hits--;
        }
    }
    }
}
