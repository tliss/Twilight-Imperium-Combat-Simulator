package com.tayloraliss.twilightimperiumcombatsimulator.ships;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	String name;
	ArrayList<Ship> fleet = new ArrayList<Ship>();
	
	public Player(String startName){
		name = startName;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Ship> getFleet(){
		return fleet;
	}
	
	public void setFleet(ArrayList<Ship> newFleet){
		for (Ship ship : newFleet){
			this.fleet.add(ship);
		}
	}
	
	public void clearFleet(){
		this.fleet.clear();
	}
	
	public void buildFleet(){
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("How many fighters?");
		
		int fighters = Integer.parseInt(userInput.next());
		
		while (fighters > 0){
			fleet.add(new Fighter());
			fighters--;
		}
		
		System.out.println("How many carriers?");
		
		int carriers = Integer.parseInt(userInput.next());
		
		while (carriers > 0){
			fleet.add(new Carrier());
			carriers--;
		}	
		
		System.out.println("How many destroyers?");
		
		int destroyers = Integer.parseInt(userInput.next());
		
		while (destroyers > 0){
			fleet.add(new Destroyer());
			destroyers--;
		}
		
		System.out.println("How many cruisers?");
		
		int cruisers = Integer.parseInt(userInput.next());
		
		while (cruisers > 0){
			fleet.add(new Cruiser());
			cruisers--;
		}
		
		System.out.println("How many dreadnaughts:");
		
		int dreadnaughts = Integer.parseInt(userInput.next());
		
		while (dreadnaughts > 0){
			fleet.add(new Dreadnaught());
			dreadnaughts--;
		}
		
		System.out.println("How many warsuns?");
		
		int warsuns = Integer.parseInt(userInput.next());
		
		while (warsuns > 0){
			fleet.add(new Warsun());
			warsuns--;
		}
	}
	
	// Checks for a specified ship
	public int returnShipNumber(String type) {
		int numberOfShips = 0;
		
		for (Ship ship : this.fleet){
			if (ship.returnName() == type){
				numberOfShips++;
			}
		}
		
		return numberOfShips;
	}
	
	// Gets a random number between 1 and 10
	public int returnRoll() {
		return (int)(Math.random() * 10) + 1;
	}
	
	//Returns +1 per successful attack
	public int shipAttack(){
		
		int hitCounter = 0;

		for (Ship ship : this.fleet){
			if (ship.returnName() != "warsun" && ship.getIsActive() == true){
				int roll = returnRoll();
				if (roll >= ship.returnAttack()){
					hitCounter++;
				}
			}
			else if (ship.returnName() == "warsun" && ship.getIsActive() == true){
				for (int i=0; i<3; i++){
					int roll = returnRoll();
					if (roll >= ship.returnAttack()){
						hitCounter++;
					}
				}
			}
		}
		return hitCounter;
	}
	
	public int destroyerBarrage(){
		int hitCounter = 0;
		
		int roll = returnRoll();
		if (roll >= 9){
			System.out.println("Destroyer's barrage rolled " + roll + "! Hit!");
			hitCounter++;
		}
		else {
			System.out.println("Destroyer's barrage rolled " + roll + "! Miss!");
		}
		
		return hitCounter;
	}
	
	// Returns the number of ships in the fleet
	public int returnFleetSize(){
		return this.fleet.size();
	}
	
	// Prints out all the ships in the fleet
	public void viewFleet(){
		for(Ship ship : this.fleet){
			System.out.print(ship.returnName() + " | ");
		}
		System.out.println("");
	}
	
	public boolean fleetIsDead(){
		boolean dead = true;
		for (Ship ship : fleet){
			if (ship.getIsActive() == true){
				dead = false;
			}
		}
		return dead;
	}
	
	// This is the logic for when a fleet takes a hit and the player must decide what ship to destroy.
	public void takeAHit(){
		
		boolean hitPending = true;
		
		int fighterCount = 0;
		int carrierCount = 0;
		int destroyerCount = 0;
		int cruiserCount = 0;
		int dreadnaughtUndamagedCount = 0;
		int dreadnaughtDamagedCount = 0;
		int warsunUndamagedCount = 0;
		int warsunDamagedCount = 0;
		
		for (Ship ship : fleet){
			if (ship instanceof Fighter && ship.getIsActive() == true){
				fighterCount++;
			}
			else if (ship instanceof Carrier && ship.getIsActive() == true){
				carrierCount++;
			}
			else if (ship instanceof Destroyer && ship.getIsActive() == true){
				destroyerCount++;
			}
			else if (ship instanceof Cruiser && ship.getIsActive() == true){
				cruiserCount++;
			}
			else if (ship instanceof Dreadnaught && ship.returnHealth() == 2 && ship.getIsActive() == true){
				dreadnaughtUndamagedCount++;
			}
			else if (ship instanceof Dreadnaught && ship.returnHealth() == 1 && ship.getIsActive() == true){
				dreadnaughtDamagedCount++;
			}
			else if (ship instanceof Warsun && ship.returnHealth() == 2 && ship.getIsActive() == true){
				warsunUndamagedCount++;
			}
			else if (ship instanceof Warsun && ship.returnHealth() == 1 && ship.getIsActive() == true){
				warsunDamagedCount++;
			}
		}
		
		while (hitPending){
			
			if (fighterCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Fighter && fleet.get(i).getIsActive() == true){
						fleet.get(i).deactivate();
						//"fighter was destroyed!"
						hitPending=false;
						break;
					}
				}
			}
			
			else if (carrierCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Carrier && fleet.get(i).getIsActive() == true){
						fleet.get(i).deactivate();
						//"carrier was destroyed!"
						hitPending=false;
						break;
					}
				}
			}
			
			else if (destroyerCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Destroyer && fleet.get(i).getIsActive() == true){
						fleet.get(i).deactivate();
						//"destroyer was destroyed!"
						hitPending=false;
						break;
					}
				}
			}
			
			else if (cruiserCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Cruiser && fleet.get(i).getIsActive() == true){
						fleet.get(i).deactivate();
						//"cruiser was destroyed!"
						hitPending=false;
						break;
					}
				}
			}
			
			else if (dreadnaughtUndamagedCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Dreadnaught && fleet.get(i).returnHealth() == 2 && fleet.get(i).getIsActive() == true){
						fleet.get(i).sustainDamage();
						//"dreadnaught sustained damage!"
						hitPending=false;
						break;
					}
				}
			}
			
			else if (dreadnaughtDamagedCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Dreadnaught && fleet.get(i).returnHealth() == 1 && fleet.get(i).getIsActive() == true){
						fleet.get(i).deactivate();
						//"dreadnaught was destroyed!"
						hitPending=false;
						break;
					}
				}
			}
			
			else if (warsunUndamagedCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Warsun && fleet.get(i).returnHealth() == 2 && fleet.get(i).getIsActive() == true){
						fleet.get(i).sustainDamage();
						//"warsun sustained damage!"
						hitPending=false;
						break;
					}
				}
			}
			
			else if (warsunDamagedCount > 0) {
				for (int i = 0; i < fleet.size(); i++){
					if (fleet.get(i) instanceof Warsun && fleet.get(i).returnHealth() == 1 && fleet.get(i).getIsActive() == true){
						fleet.get(i).deactivate();
						//"warsun was destroyed!"
						hitPending=false;
						break;
					}
				}
			}
		}
	}
}
