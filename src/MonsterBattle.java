/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: 
 */

public class MonsterBattle {

	private int currentMonsterID;
	
	//WHAT DID THE CURRENT MONSTER ID DO? 4/6/2015
	
	private Monster mTemp;
	
	private boolean inBattle;

	private Action currentPlayerAction;

	private Action currentMonsterAction;
	
	Player pTemp;

	//MonsterBattle constructor 
	public MonsterBattle(Player player, Monster monster)
	{
		pTemp = player;
		currentMonsterID = monster.getMonsterID();
		mTemp = monster;
	}
	
	//removed int playerHealthChange, int monsterHealthChange parameters 
	/*
	 * possibilities
	 * gun v atk
	 * gun v def
	 * stun v atk
	 * stun v def
	 * item v atk
	 * item v def
	 * run v atk
	 * run v def
	 * 
	 * I suggest branch off of 
	 * if(mTemp.getNextAction().equals(Action.attack))
	 * {
	 * if(p.blah)
	 * }
	 */
	
	//Battle processing unit where health is changed according to different actions
	public void changeHealth() 
	{
		//When monster attacks
		if(mTemp.getNextAction().equals(Action.attack))
		{
			//pTemp.updateHealth(mTemp.getMonsterID());//this is suppose to be mTemp.getDamage()
			//so whereever the line above is, correct with getDamage
			//and player attack with pistol
			if(pTemp.getNextAction().equals(Action.attack_pistol))
			{
				//next line changes player's health according to monster's damage
				pTemp.updateHealth(mTemp.getDamage());
				//This is where we try to change monster's health using weapon's damage amount
				//how do you get the player's pistol's damage amount?
				mTemp.updateHealth(Integer.parseInt(pTemp.useItem(0)));
			}else 
			//player attack with stungun
			if(pTemp.getNextAction().equals(Action.attack_stun))
			{
				pTemp.updateHealth(mTemp.getDamage());
				mTemp.updateHealth(Integer.parseInt(pTemp.useItem(0)));
			}else
			//player defends
			if(pTemp.getNextAction().equals(Action.defend))
			{
				pTemp.updateHealth((int)(mTemp.getDamage()-mTemp.getDamage()*0.5));
			}
		}
		
		//When monster defends
		if(mTemp.getNextAction().equals(Action.defend))
		{
			
		}
		
		
	}
	
	//WHY DO WE NEED THESE 2 METHODS?**********************
	public void requestPlayerAction() 
	{
		//get user input, parse into an action
		pTemp.setNextAction(Action.attack);
	}

	public void getMonsterAction() 
	{
		
	}
	
	//is this suppose to be in battle? thought it was in game
	public void toggleBattle()
	{
		inBattle = !inBattle;
	}

	//Returns the changed health of player/monster and determines if game is over
	public String getResult() 
	{
		if(pTemp.getHealth() == 0)
		{
			toggleBattle();
			return "You have died! Game over.";
		}
		else
		{
			return "Your health is now " + pTemp.getHealth() +". " +mTemp.getName()+ " now has " +mTemp.getHealth() +"health.";
		}
	}
}
