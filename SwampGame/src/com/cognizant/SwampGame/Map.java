package com.cognizant.SwampGame;

public class Map {
	private int gridSize;
	private String[][] grid;
	
	public Map(int gridSize) {
		this.gridSize = gridSize;
		grid = new String [this.gridSize][this.gridSize];
		
		gridSetup();
	}
	
	public void gridSetup()
	{
		for (int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; i++)
			{
				grid[i][j] = "-";
			}
		}
	}
}
