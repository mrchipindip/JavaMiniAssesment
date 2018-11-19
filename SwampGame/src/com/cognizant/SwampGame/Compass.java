package com.cognizant.SwampGame;

public class Compass {

	private float distanceToPoint = 0.0f;
	private String getPointDir = "EAST";
	private int currXCord;
	private int currYCord;
	private int tarXCord;
	private int tarYCord;
	
	public Compass()
	{
		setDistanceToPoint(0.0f);
		setGetPointDir("EAST");
	}
	
	public Compass(float dist, String dir, int cXCord, int cYCord, int tXCord, int tYCord)
	{
		setDistanceToPoint(dist);
		setGetPointDir(dir);
		setCurrXCord(cXCord);
		setCurrYCord(cYCord);
		setTarXCord(tXCord);
		setTarYCord(tYCord);
		calcDistance();
		calcDirection();
	}

	
	public void calcDistance()
	{
		distanceToPoint = (float) Math.sqrt(Math.pow((currXCord - tarXCord), 2) + Math.pow((currYCord - tarYCord), 2));
	}
	
	//find the direction to go to get to treasure
	public void calcDirection()
	{
		if (currXCord < tarXCord)
		{
			//tar west east
			if(currYCord < tarYCord)
			{
				setGetPointDir("NORTHEAST");
			}
			else if(currYCord > tarYCord)
			{
				setGetPointDir("SOUTHEAST");
			}
			else
			{
				setGetPointDir("EAST");
			}
		}
		else if (currXCord > tarYCord)
		{
			//tar west
			if(currYCord < tarYCord)
			{
				setGetPointDir("NORTHWEST");
			}
			else if(currYCord > tarYCord)
			{
				setGetPointDir("SOUTHWEST");
			}
			else
			{
				setGetPointDir("WEST");
			}
		}
		else
		{
			//straight above or below
			if(currYCord < tarYCord)
			{
				setGetPointDir("NORTH");
			}
			else
			{
				setGetPointDir("SOUTH");
			}
		}
	}
	
	//GETTERS AND SETTERS
	public float getDistanceToPoint() {
		return distanceToPoint;
	}

	public void setDistanceToPoint(float distanceToPoint) {
		this.distanceToPoint = distanceToPoint;
	}

	public String getGetPointDir() {
		return getPointDir;
	}

	public void setGetPointDir(String getPointDir) {
		this.getPointDir = getPointDir;
	}

	public int getCurrXCord() {
		return currXCord;
	}

	public void setCurrXCord(int currXCord) {
		this.currXCord = currXCord;
	}

	public int getCurrYCord() {
		return currYCord;
	}

	public void setCurrYCord(int currYCord) {
		this.currYCord = currYCord;
	}

	public int getTarXCord() {
		return tarXCord;
	}

	public void setTarXCord(int tarXCord) {
		this.tarXCord = tarXCord;
	}

	public int getTarYCord() {
		return tarYCord;
	}

	public void setTarYCord(int tarYCord) {
		this.tarYCord = tarYCord;
	}
	
	
	
}
