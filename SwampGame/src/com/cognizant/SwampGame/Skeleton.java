package com.cognizant.SwampGame;

public class Skeleton extends Enemy{
	private boolean hasWep = false;

	public Skeleton()
	{
		super(5, false);
		hasWep = false;
	}
	
	public Skeleton(int health, boolean awareness, boolean hasWep)
	{
		super(health, awareness);
		this.hasWep = hasWep;
	}
	
	public boolean getHasWep() {
		return hasWep;
	}

	public void setHasWep(boolean hasWep) {
		this.hasWep = hasWep;
	}
	
	
}
