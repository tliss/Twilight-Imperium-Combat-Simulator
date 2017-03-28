package com.tayloraliss.twilightimperiumcombatsimulator.ships;

public class Cruiser extends Ship {

	public Cruiser(){
		super("cruiser",7,1,1);
	}
	
	public void initialize(){
		health = 1;
		this.activate();
	}
}
