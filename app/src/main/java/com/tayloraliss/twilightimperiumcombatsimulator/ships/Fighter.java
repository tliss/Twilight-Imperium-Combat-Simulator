package com.tayloraliss.twilightimperiumcombatsimulator.ships;

public class Fighter extends Ship {

	public Fighter(){
		super("fighter",9,1,1);
	}
	
	public void initialize(){
		health = 1;
		this.activate();
	}
}
