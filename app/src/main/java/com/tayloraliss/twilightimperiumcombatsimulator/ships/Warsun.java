package com.tayloraliss.twilightimperiumcombatsimulator.ships;

public class Warsun extends Ship {

	public Warsun(){
		super("warsun",3,2,3);
	}
	
	public void initialize(){
		health = 2;
		this.activate();
	}
}
