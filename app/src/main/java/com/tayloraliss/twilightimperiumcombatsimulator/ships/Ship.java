package com.tayloraliss.twilightimperiumcombatsimulator.ships;

public abstract class Ship{
	protected String name;
	protected int attack;
  	protected int health;
  	protected int attackNumber;
  	protected boolean isActive;
	
  	public Ship(String name, int attack, int health, int attackNumber){
  		this.name = name;
  		this.attack = attack;
  	    this.health = health;
  	    this.attackNumber = attackNumber;
  	    this.isActive = true;
  	 }
  	
  	public void deactivate(){
  		this.isActive = false;
  	}
  	
  	public boolean getIsActive(){
  		return isActive;
  	}
  	
  	public void activate(){
  		this.isActive = true;
  	}
  	
  	public String returnName(){
  		return this.name;
  	}
  	
  	public int returnHealth(){
  		return this.health;
  	}
  	
  	public void sustainDamage(){
  		this.health--;
  	}
  	
  	public int returnAttack(){
  		return attack;
  	}
  	
  	public void initialize(){
  	}
  }