package com.tayloraliss.twilightimperiumcombatsimulator.ships;

public class Dreadnaught extends Ship {

	public Dreadnaught(){
		super("dreadnaught",5,2,1);
	}
	
	public void initialize(){
		health = 2;
		this.activate();
	}
}
