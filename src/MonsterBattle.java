/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: Controls interaction between a single monster and player.
 * Retrieves the action of each character for every turn and changes
 * health accordingly.
 */

/*
 * MAJOR CHANGES 4/9/2015
 * 1. monster will only have one damage value and one defense value
 * 2. Hard coded damage/defense values into battle because cannot correct get invt items
 */
public class MonsterBattle {
	
	//WHAT DID THE CURRENT MONSTER ID DO? 4/6/2015
	
	//private boolean inBattle;  MOVED TO PLAYER CLASS

	private Action currentPlayerAction;

	private Action currentMonsterAction;
	
	private boolean playerTurn = false;
	
	private boolean monsterTurn = false;
	
	private boolean timeForUpdate = false;
	
	//NEED TO Replace all temporary variables with Game.getXXXXX
	private Player pTemp = Game.getInstance().currentPlayer;
	private Monster mTemp = Game.getInstance().monsterArray[Game.getInstance().roomArray[Game.getInstance().currentRoomID].getMonsterInRoom()];
	
	/**
	 * Method: MonsterBattle(Player player, Monster monster)
	 * Constructor creates a new battle instance for every
	 * encounter the player has with a monster.
	 * 
	 * @param player : current player of the game instance
	 * @param monster : current monster of the current battle
	 */
	public MonsterBattle(Player player, Monster monster)
	{
		pTemp = player;
		mTemp = monster;
		
		playerTurn = true;
		Game.getInstance().toggleBattle();
		startBattle();
	}
	
	/**
	 * Method: startBattle()
	 * Determines who has the current turn in the battle.
	 * Calls the user for input if user's turn. Calls
	 * monster's actionSequence if monster's turn.
	 */
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
	
	/**
	 * Method: changeHealth()
	 * Battle processing unit where health is changed according to different actions.
	 */
	public void changeHealth() 
	{
		int pDmg = 2;
		//When monster attacks
		if(currentMonsterAction.equals(Action.attack))
		{
			//and player attack with pistol
			if(currentPlayerAction.equals(Action.attack_pistol))
			{
				//Game.getInstance().monsterArray[0].getDamage());
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
			double mDef = mTemp.getDefense();
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
		//Finalizes the changes in health/this must be changed/deleted
		Game.getInstance().currentPlayer = pTemp;
		Game.getInstance().monsterArray[Game.getInstance().roomArray[Game.getInstance().currentRoomID].getMonsterInRoom()] = mTemp;		
	}
	
	/**
	 * Method: requestPlayerAction()
	 * Parses user's input into an action.
	 */
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
	
	/**
	 * Method: getMonsterAction()
	 * @return monster's next action in the sequence
	 */
	public Action getMonsterAction() 
	{
		return mTemp.getNextAction();
	}
	
	/**
	 * Method: getResult()
	 * Returns the changed health of player/monster and determines 
	 * if game/battle is over.
	 * @return String output to inform user of current health and battle status.
	*/
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
