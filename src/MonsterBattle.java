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
		if(currentMonsterAction == Action.attack)
		{
			//and player attack with pistol
			if(currentPlayerAction == Action.attack_pistol)
			{
				pDmg = 100; //Temporarily 100 Damage
				//Game.getInstance().monsterArray[0].getDamage());
				mTemp.updateHealth(-pDmg);
				pTemp.updateHealth(-mTemp.getDamage());
			}
			//player attack with stungun
			if(currentPlayerAction == Action.attack_stun)
			{
				pDmg = 30;
				mTemp.updateHealth(-pDmg);
				pTemp.updateHealth(-mTemp.getDamage());
			}
			//player defends
			if(currentPlayerAction == Action.defend)
			{
				pTemp.updateHealth(-(-(mTemp.getDamage() - ));
			}
			//player uses health pack
			if(currentPlayerAction == Action.use)
			{
				pTemp.updateHealth(pTemp.findAndUseHealthPack());
				pTemp.updateHealth(-mTemp.getDamage());
			}
		}

		//When monster defends
		if(mTemp.getNextAction() == Action.defend)
		{
			double mDef = mTemp.getDefense();
			//and player attack with pistol
			if(pTemp.getNextAction() == Action.attack_pistol)
			{
				//mTemp.updateHealth(mTemp.getHealth()-Integer.parseInt(pTemp.useItem(0)));
				mTemp.updateHealth((int)(mTemp.getHealth()-pDmg*mDef));
			}
			//player attack with stungun
			if(pTemp.getNextAction() == Action.attack_stun)
			{
				mTemp.updateHealth((int)(mTemp.getHealth()-pDmg*2*mDef));

			}
			//player defends
			if(pTemp.getNextAction() == Action.defend)
			{

			}
			//player uses health pack
			if(pTemp.getNextAction() == Action.use)
			{
				//pTemp.updateHealth(pTemp.getHealth()+pTemp.useItem(pTemp.getItem(healthpackID)))
				pTemp.updateHealth(pTemp.getHealth()+pDmg*2);
				Game.getInstance().currentPlayer.findAndUseHealthPack();
			}
		}
		
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
			//update inventory on user interface
			Game.getInstance().currentPlayer.performAction(currentPlayerAction);
		}

		if(userActionInput == 1)
		{
			currentPlayerAction = Action.attack_stun;
			Game.getInstance().currentPlayer.performAction(currentPlayerAction);
		}

		if(userActionInput == 2)
		{
			currentPlayerAction = Action.defend;
			Game.getInstance().currentPlayer.performAction(currentPlayerAction);
		}

		if(userActionInput == 3)
		{
			currentPlayerAction = Action.use;
			Game.getInstance().currentPlayer.performAction(currentPlayerAction);
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
			UserInterface.gameButtonsOn(false);
			return "You have died! Game over.";
		}
		else
<<<<<<< HEAD
		if(mTemp.getHealth() <= 0)
		{
			Game.getInstance().toggleBattle();
			UserInterface.gameButtonsOn(true);
			mTemp.toggleIsDefeated();
			return mTemp.getName() + " has been defeated! You win! Continue investigating room...";
		
		}
		else
		{
			return "Your health is now " + pTemp.getHealth() +". " 
					+mTemp.getName()+ " now has " +mTemp.getHealth() +" health. What is your next move?";
		}
=======
			if(mTemp.getHealth() <= 0)
			{
				Game.getInstance().toggleBattle();
				UserInterface.gameButtonsOn(true);
				return mTemp.getName() + " has been defeated! You win! Continue investigating room...";
			}
			else
			{
				return "Your health is now " + pTemp.getHealth() +". " 
						+mTemp.getName()+ " now has " +mTemp.getHealth() +" health. What is your next move?";
			}
>>>>>>> origin/master
	}
	

}
