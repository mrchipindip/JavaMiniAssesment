package com.cognizant.SwampGame;

import java.util.ArrayList;
import java.util.Scanner;

public class SwampGame {

	public boolean gameWon = false;
	
	public static void main(String[] args)
	{
		SwampGame gameInstance = new SwampGame();
		Player mainPlayer = new Player();
			
		Treasure oneTreasure = new Treasure(5, 5, 1);
		Treasure twoTreasure = new Treasure();
		ArrayList<Treasure> treasureList = new ArrayList<Treasure>();
		treasureList.add(oneTreasure);
		treasureList.add(twoTreasure);
		
		Enemy skele1 = new Skeleton();
		Enemy skele2 = new Skeleton(5, true, true);
		Enemy zomb1 = new Zombie(5, true, true);
		ArrayList<Enemy> enemyList= new ArrayList<Enemy>();
		
		
		Compass mainCompass = new Compass(0.0f, "EAST", mainPlayer.getxCord(), mainPlayer.getyCord(), oneTreasure.getxCord(), oneTreasure.getyCord());
		gameInstance.startGame();
		
		gameInstance.doFirstRoom(mainCompass);
		gameInstance.mainLoop(mainPlayer, mainCompass, treasureList, enemyList);
	}
	
	
	//main body of the game loop
	public void mainLoop(Player player, Compass compass, ArrayList<Treasure> treasureList, ArrayList<Enemy> enemyList)
	{
		while (gameWon == false)
		{
			System.out.println("Enter Move:");
			String input = input();
			
			if(input.equals("NORTH"))
			{
				//System.out.println(player.getyCord());
				System.out.println("You trudge northward throught the dreary swamp");
				goNorth(player);
				//System.out.println("n");
				//System.out.println(player.getyCord());
				updateCompass(compass, player, treasureList.get(0));
			}
			else if(input.equals("SOUTH"))
			{
				System.out.println("You trudge southward throught the dreary swamp");
				goSouth(player);
				//System.out.println("s");
				updateCompass(compass, player, treasureList.get(0));
			}
			else if(input.equals("EAST"))
			{
				System.out.println("You trudge eastward throught the dreary swamp");
				goEast(player);
				//System.out.println("e");
				updateCompass(compass, player, treasureList.get(0));
			}
			else if(input.equals("WEST"))
			{
				System.out.println("You trudge westward throught the dreary swamp");
				goWest(player);
				//System.out.println("w");
				updateCompass(compass, player,treasureList.get(0));
			}
			
			for(int i = 0; i < enemyList.size(); i++)
			{
				if((player.getxCord() == enemyList.get(i).getxCoord()) && player.getyCord() == enemyList.get(i).getxCoord())
				{
					if(startEncounter(enemyList.get(i), player))
					{
						gameWon = true;
					}
				}
			}
			
			
			
			
			if((player.getxCord() == treasureList.get(0).getxCord()) && (player.getyCord() == treasureList.get(0).getyCord()))
			{
				System.out.println("You randomly stuble across a magical BOX!... It vanishes into thin air");
				
				treasureList.remove(0);
				
				if (treasureList.size() == 0)
				{
					System.out.println("You stumble accross the magical box again!");
					doSleep(1000);
					System.out.println("You wake up and reaslie it was all a dream!");
					doSleep(1000);
					System.out.println("GAME OVER");
					gameWon = true;
				}
				
				updateCompass(compass, player,treasureList.get(0));
				
			}
		}
	}
	//get input
	public String input()
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		input = input.toUpperCase();
		return input;
	}
	//start sequence
	public void startGame()
	{
		System.out.println("Loading Your new Adventure. Please wait ");
		for ( int i = 0; i <= 10; i++)
		{
			System.out.printf("-");
			//doSleep(750);
		}
		
		System.out.println("");
		System.out.println("Game Ready");
		System.out.println("Are You?   ");
		doSleep(1000);
		System.out.printf("Enter Yes or No to continue.");
		System.out.println(" ");
		while(!input().equals("YES"))
		{
			
		}
		
	}
	
	//all compass updating
	public void updateCompass(Compass compass, Player player, Treasure treasure)
	{
		compass.setCurrXCord(player.getxCord());
		compass.setCurrYCord(player.getyCord());
		compass.setTarXCord(treasure.getxCord());
		compass.setTarYCord(treasure.getyCord());
		compass.calcDirection();
		compass.calcDistance();
		System.out.println("The hands read:");
		System.out.println(compass.getDistanceToPoint() + " " + compass.getGetPointDir());
		
	}
	
	//Encouter method
	public boolean startEncounter(Enemy paramEnemy, Player player)
	{
		if(paramEnemy instanceof Skeleton)
		{
			Skeleton paramEnemyS = (Skeleton)paramEnemy;
			
			if(paramEnemyS.getHasWep())
			{
				System.out.println("You encouter a massive skeleton with a sword");
				
				if(paramEnemyS.isReady())
				{
					System.out.println("He sees you and immediatly murders you");
					return true;
				}
				else
				{
					System.out.println("He wasnt looking you get away");
				}
			}
			else
			{
				System.out.println("You encounter a lonely skelton but manage to get away!");
			}
		}
		else
		{
			Zombie paramEnemyZ = (Zombie)paramEnemy;
			
			if(paramEnemyZ.getFleshCraving())
			{
				System.out.println("You encouter a Zombie frothing at the mouht");
				
				if(paramEnemyZ.isReady())
				{
					System.out.println("He sees you and immediatly murders you");
					return true;
				}
				else
				{
					System.out.println("He wasnt looking you get away");
				}
			}
			else
			{
				System.out.println("You encounter a lonely skelton but manage to get away!");

			}
			
		}
		
		return false;
		
	}
	
	//Any Delays needed for easier reading
	public void doSleep(int sleepLength)
	{
		try {
			Thread.sleep(sleepLength);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//first room (as its a fixed sequence
	public void doFirstRoom(Compass mainCompass)
	{
		doSleep(1000);
		System.out.println("You Wrench your eyes open. Rough grey stone. A ceiling. Your head is banging, and you're lying on the floor");
		doSleep(1000);
		System.out.println("You're staring at the ceiling, its very grey, and you dont recognise it");
		System.out.println(" ");
		doSleep(1000);
		System.out.println("You roll over....");
		doSleep(1000);
		System.out.println("Bars");
		doSleep(1000);
		System.out.println("Its a Cell");
		doSleep(1000);
		System.out.println("You can see Stairs leading up the otherside of the door. You cant remember how you got here o where you are.");
		doSleep(1000);
		System.out.println("Try the Door?");
		
		while(!input().equals("YES"))
		{
			
		}
		
		System.out.println("You Leave");
		doSleep(1000);
		
		System.out.println("After Leaving up the stairs you emerge into a seemingly limitless dreary swamp.");
		doSleep(1000);
		
		System.out.println("You notice a small watch-like device in your left hand.");
		doSleep(1000);
		System.out.println("It has hands like a watch, but the hands don't seem to tell time.");
		doSleep(1000);
		
		System.out.println("The hands read:");
		System.out.println(mainCompass.getDistanceToPoint() + " " + mainCompass.getGetPointDir());
		
		System.out.println(" You can move by entering 'North' 'South' 'East' 'West'");


		
	}
	
	
	//MOVEMENT METHODS
	public void goNorth(Player player)
	{
		player.setyCord(player.getyCord() + 1);
	}
	
	public void goSouth(Player player)
	{
		player.setyCord(player.getyCord() - 1);
	}
	
	public void goEast(Player player)
	{
		player.setxCord(player.getxCord() + 1);
	}
	
	public void goWest(Player player)
	{
		player.setxCord(player.getxCord() - 1);
	}

}
