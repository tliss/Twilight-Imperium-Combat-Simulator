package com.tayloraliss.twilightimperiumcombatsimulator.ships;

public class Destroyer extends Ship {
	
	public Destroyer(){
		super("destroyer",9,1,1);
	}
	
	public void initialize(){
		health = 1;
		this.activate();
	}
}