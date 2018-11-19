package com.cognizant.SwampGame;

import java.util.Random;

public class Enemy {
	private int health;
	private boolean isReady;
	private int xCoord;
	private int yCoord;
	
	public Enemy()
	{
		setHealth(5);
		setReady(true);
		
		Random rn = new Random();
		int answer = rn.nextInt(10) + 1;
		Random rn2 = new Random();
		int answer2 = rn2.nextInt(10) + 1;
		setxCoord(answer);
		setyCoord(answer2);
	}
	
	public Enemy(int paramHealth, boolean paramIsReady)
	{
		setHealth(paramHealth);
		setReady(paramIsReady);
		
		Random rn = new Random();
		int answer = rn.nextInt(10) + 1;
		Random rn2 = new Random();
		int answer2 = rn2.nextInt(10) + 1;
		setxCoord(answer);
		setyCoord(answer2);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}


	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
}
