package com.cognizant.SwampGame;

public class Zombie extends Enemy {

	private boolean fleshCraving = false;

	public Zombie()
	{
		super(5, true);
		fleshCraving = false;
	}
	
	public Zombie(int health, boolean awareness, boolean fleshCraving)
	{
		super(health, awareness);
		this.fleshCraving = fleshCraving;
	}
	
	public boolean getFleshCraving() {
		return fleshCraving;
	}

	public void setFleshCraving(boolean fleshCraving) {
		this.fleshCraving = fleshCraving;
	}
	
}
