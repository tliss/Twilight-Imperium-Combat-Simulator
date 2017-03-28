package com.tayloraliss.twilightimperiumcombatsimulator.ships;

public class Carrier extends Ship{
	
	public Carrier(){
		super("carrier",9, 1, 1);
	}
	
	public void initialize(){
		health = 1;
		this.activate();
	}
}
