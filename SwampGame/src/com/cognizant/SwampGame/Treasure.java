package com.cognizant.SwampGame;

import java.util.Random;

public class Treasure {
	private int xCord;
	private int yCord;
	private int value;
	
	public Treasure()
	{
		Random rn = new Random();
		int answer = rn.nextInt(10) + 1;
		Random rn2 = new Random();
		int answer2 = rn2.nextInt(10) + 1;
		setxCord(answer);
		setyCord(answer2);
		setValue(1);
	}
	
	public Treasure(int paramX, int paramY, int paramValue)
	{

		setxCord(paramX);
		setyCord(paramY);
		setValue(paramValue);
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
