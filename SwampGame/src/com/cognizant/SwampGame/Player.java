package com.cognizant.SwampGame;

public class Player {
	private int health;
	private boolean hasWep;
	private int xCord;
	private int yCord;
	
	public Player()
	{
		setHealth(5);
		setHasWep(false);
		setxCord(0);
		setyCord(0);
	}
	
	public Player(int paramHealth, boolean paramHasWep, boolean paramIsReady)
	{
		setHealth(paramHealth);
		setHasWep(paramHasWep);
		setxCord(0);
		setyCord(0);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isHasWep() {
		return hasWep;
	}

	public void setHasWep(boolean hasWep) {
		this.hasWep = hasWep;
	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		this.yCord = yCord;
	}

}
