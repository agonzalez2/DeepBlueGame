/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: Controls interaction between a single monster and player.
 * Retrieves the action of each character for every turn and changes
 * health accordingly.
 */

public class MonsterBattle {

	private Action currentPlayerAction;

	private Action currentMonsterAction;

	private boolean playerTurn = false;

	private boolean monsterTurn = false;

	private boolean timeForUpdate = false;

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
	 * @throws NumberFormatException 
	 */
	public void changeHealth() throws NumberFormatException 
	{
		int pDmg = pTemp.getPistol().getDamage();
		int sDmg = pTemp.getStun().getDamage();
		//When monster attacks
		if(currentMonsterAction == Action.attack)
		{
			//and player attack with pistol
			if(currentPlayerAction == Action.attack_pistol)
			{
				UserInterface.setGameTextArea(pTemp.getPistol().use());
				pDmg = pTemp.getPistol().getDamage();
				mTemp.updateHealth(-pDmg);
				pTemp.updateHealth(-mTemp.getDamage());
			}
			//player attack with stungun
			if(currentPlayerAction == Action.attack_stun)
			{
				UserInterface.setGameTextArea(pTemp.getStun().use());
				pDmg = pTemp.getStun().getDamage();
				mTemp.updateHealth(-sDmg);
				pTemp.updateHealth(-mTemp.getDamage());
			}
			//player defends
			if(currentPlayerAction == Action.defend)
			{
				//pTemp.updateHealth(-(-(mTemp.getDamage() - 10))); // change to use shield
				try 
				{
					pTemp.updateHealth(-(int)(mTemp.getDamage()*(Double.valueOf(pTemp.getItem("Shield").use())/100)));
				} catch (InvalidItemException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					UserInterface.setGameTextArea("ERROR IN SHIELD DEFENSE");
				}
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
				UserInterface.setGameTextArea(pTemp.getPistol().use());
				pDmg = pTemp.getPistol().getDamage();
				mTemp.updateHealth((int)-(pDmg*mDef));
			}
			//player attack with stungun
			if(pTemp.getNextAction() == Action.attack_stun)
			{
				UserInterface.setGameTextArea(pTemp.getStun().use());
				pDmg = pTemp.getStun().getDamage();
				mTemp.updateHealth((int)-(sDmg*mDef));
			}
			//player defends
			if(pTemp.getNextAction() == Action.defend)
			{
			}
			//player uses health pack
			if(pTemp.getNextAction() == Action.use)
			{
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
			//Game.getInstance().currentPlayer.performAction(currentPlayerAction);
		}

		if(userActionInput == 1)
		{
			currentPlayerAction = Action.attack_stun;
			//Game.getInstance().currentPlayer.performAction(currentPlayerAction);
		}

		if(userActionInput == 2)
		{
			currentPlayerAction = Action.defend;
			//Game.getInstance().currentPlayer.performAction(currentPlayerAction);
		}

		if(userActionInput == 3)
		{
			currentPlayerAction = Action.use;
			//Game.getInstance().currentPlayer.performAction(currentPlayerAction);
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
		String result = "Your health is now " + pTemp.getHealth() +". " 
				+ mTemp.getName()+ " now has " +mTemp.getHealth() +" health.";
		String askNextMove = "What is your next move?";
		
		if(pTemp.getHealth() <= 0)
		{
			Game.getInstance().toggleBattle();
			UserInterface.gameButtonsOn(false);
			result = "You have died! Game over.\n" + result;
			if(mTemp.getHealth() < 0)
			{
				mTemp.updateHealth(Math.abs(mTemp.getHealth()));
			}
		}
		else if(mTemp.getHealth() <= 0)
		{
			Game.getInstance().toggleBattle();
			UserInterface.gameButtonsOn(true);
			mTemp.toggleIsDefeated();
			if(mTemp.getHealth() < 0)
			{
				mTemp.updateHealth(Math.abs(mTemp.getHealth()));
			}
			result =  mTemp.getName() + " has been defeated! You win! Continue investigating room...\n" + result;
		}
		else
		{
			return result;
		}	
		return result;
	}

}
