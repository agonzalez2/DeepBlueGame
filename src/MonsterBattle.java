/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: 
 */

/*
 * MAJOR CHANGES 4/9/2015
 * 1. monster will only have one damage value and one defense value
 * 2. Hard coded damage/defense values into battle because cannot correct get invt items
 */
public class MonsterBattle {

	private int currentMonsterID;
	
	//WHAT DID THE CURRENT MONSTER ID DO? 4/6/2015
	
	private Monster mTemp;
	
	//private boolean inBattle;  MOVED TO PLAYER CLASS

	private Action currentPlayerAction;

	private Action currentMonsterAction;
	
	private boolean playerTurn = false;
	
	private boolean monsterTurn = false;
	
	private boolean timeForUpdate = false;
	
	//NEED TO Replace all temporary variables with Game.getXXXXX
	Player pTemp;

	//MonsterBattle constructor 
	public MonsterBattle(Player player, Monster monster)
	{
		pTemp = player;
		currentMonsterID = monster.getMonsterID();
		mTemp = monster;
		
		playerTurn = true;
		Game.getInstance().toggleBattle();
		startBattle();
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
	/** COMPLETELY CHANGED THIS METHOD BELOW

	public void changeHealth() 
	{
		int pDmg = 2;
		//When monster attacks
		if(mTemp.getNextAction().equals(Action.attack))
		{
			//and player attack with pistol
			if(pTemp.getNextAction().equals(Action.attack_pistol))
			{
				//mTemp.updateHealth(mTemp.getHealth()-Integer.parseInt(pTemp.useItem(0)));
				mTemp.updateHealth(mTemp.getHealth()-pDmg);
				pTemp.updateHealth(pTemp.getHealth()-mTemp.getDamage());
			}
			//player attack with stungun
			if(pTemp.getNextAction().equals(Action.attack_stun))
			{
				mTemp.updateHealth(mTemp.getHealth()-pDmg*2);
				pTemp.updateHealth(pTemp.getHealth()-mTemp.getDamage());
			}
			//player defends
			if(pTemp.getNextAction().equals(Action.defend))
			{
				pTemp.updateHealth( pTemp.getHealth()-((int)(mTemp.getDamage()-mTemp.getDamage()*0.5)));
			}
			//player uses health pack
			if(pTemp.getNextAction().equals(Action.use))
			{
				pTemp.updateHealth(pTemp.getHealth()+pDmg*2);
				pTemp.updateHealth(pTemp.getHealth()-mTemp.getDamage());
			}
		}
		
		//When monster defends
		if(mTemp.getNextAction().equals(Action.defend))
		{
			double mDef = 0.5;
			//and player attack with pistol
			if(pTemp.getNextAction().equals(Action.attack_pistol))
			{
				//mTemp.updateHealth(mTemp.getHealth()-Integer.parseInt(pTemp.useItem(0)));
				mTemp.updateHealth((int)(mTemp.getHealth()-pDmg*mDef));
			}
			//player attack with stungun
			if(pTemp.getNextAction().equals(Action.attack_stun))
			{
				mTemp.updateHealth((int)(mTemp.getHealth()-pDmg*2*mDef));

			}
			//player defends
			if(pTemp.getNextAction().equals(Action.defend))
			{

			}
			//player uses health pack
			if(pTemp.getNextAction().equals(Action.use))
			{
				//pTemp.updateHealth(pTemp.getHealth()+pTemp.useItem(pTemp.getItem(healthpackID)))
				pTemp.updateHealth(pTemp.getHealth()+pDmg*2);
			}
		}
		
	
	}
	
	**/
	
	public void startBattle()
	{
		while(Game.getInstance().inBattle)
		{
			if(playerTurn)
			{
				requestPlayerAction(); //sets currentPlayerAction
				playerTurn = false;
				monsterTurn = true;
				
			}
			
			if(monsterTurn)
			{
				System.out.println("Monster Turn");
				currentMonsterAction = mTemp.getNextAction();
				monsterTurn = false;
				timeForUpdate = true;
			}
			
			if(timeForUpdate)
			{
				System.out.println("Time for update");
				changeHealth();
				UserInterface.setGameTextArea(getResult());
				timeForUpdate = false;
				playerTurn = true;
			}
		}
	}
	
	public void changeHealth() 
	{
		int pDmg = 2;
		//When monster attacks
		if(currentMonsterAction.equals(Action.attack))
		{
			//and player attack with pistol
			if(currentPlayerAction.equals(Action.attack_pistol))
			{
				//mTemp.updateHealth(mTemp.getHealth()-Integer.parseInt(pTemp.useItem(0)));
				mTemp.updateHealth(mTemp.getHealth()-pDmg);
				pTemp.updateHealth(pTemp.getHealth()-mTemp.getDamage());
			}
			//player attack with stungun
			if(currentPlayerAction.equals(Action.attack_stun))
			{
				mTemp.updateHealth(mTemp.getHealth()-pDmg*2);
				pTemp.updateHealth(pTemp.getHealth()-mTemp.getDamage());
			}
			//player defends
			if(currentPlayerAction.equals(Action.defend))
			{
				pTemp.updateHealth( pTemp.getHealth()-((int)(mTemp.getDamage()-mTemp.getDamage()*0.5)));
			}
			//player uses health pack
			if(currentPlayerAction.equals(Action.use))
			{
				pTemp.updateHealth(pTemp.getHealth()+pDmg*2);
				pTemp.updateHealth(pTemp.getHealth()-mTemp.getDamage());
			}
		}
		
		//When monster defends
		if(mTemp.getNextAction().equals(Action.defend))
		{
			double mDef = 0.5;
			//and player attack with pistol
			if(pTemp.getNextAction().equals(Action.attack_pistol))
			{
				//mTemp.updateHealth(mTemp.getHealth()-Integer.parseInt(pTemp.useItem(0)));
				mTemp.updateHealth((int)(mTemp.getHealth()-pDmg*mDef));
			}
			//player attack with stungun
			if(pTemp.getNextAction().equals(Action.attack_stun))
			{
				mTemp.updateHealth((int)(mTemp.getHealth()-pDmg*2*mDef));

			}
			//player defends
			if(pTemp.getNextAction().equals(Action.defend))
			{

			}
			//player uses health pack
			if(pTemp.getNextAction().equals(Action.use))
			{
				//pTemp.updateHealth(pTemp.getHealth()+pTemp.useItem(pTemp.getItem(healthpackID)))
				pTemp.updateHealth(pTemp.getHealth()+pDmg*2);
				Game.getInstance().currentPlayer.findAndUseHealthPack();
			}
		}
		
		
	}
	
	
	
	//WHY DO WE NEED THESE 2 METHODS?**********************
	public void requestPlayerAction() 
	{
		//get user input, parse into an action
		int userActionInput = UserInterface.promptUserForAction();
		
		if(userActionInput == 0)
		{
			currentPlayerAction = Action.attack_pistol;
		}
		
		if(userActionInput == 1)
		{
			currentPlayerAction = Action.attack_stun;
		}
		
		if(userActionInput == 2)
		{
			currentPlayerAction = Action.defend;
		}
		
		if(userActionInput == 3)
		{
			currentPlayerAction = Action.use;
		}
		
	}

	public Action getMonsterAction() 
	{
		return mTemp.getNextAction();
	}
	
	//is this suppose to be in battle? thought it was in game
	//MOVED TO PLAYER CLASS - ANDREW
	/**
	public void toggleBattle()
	{
		inBattle = !inBattle;
	}
	**/

	//Returns the changed health of player/monster and determines if game is over
	public String getResult() 
	{
		if(pTemp.getHealth() <= 0)
		{
			Game.getInstance().toggleBattle();
			UserInterface.gameButtonsOn(true);
			return "You have died! Game over.";
		
		}
		else
		if(mTemp.getHealth() <= 0)
		{
			Game.getInstance().toggleBattle();
			UserInterface.gameButtonsOn(true);
			return mTemp.getName() + " has been defeated! You win!";
		}
		else
		{
			return "Your health is now " + pTemp.getHealth() +". " 
					+mTemp.getName()+ " now has " +mTemp.getHealth() +" health. What is your next move?";
		}
	}
}
