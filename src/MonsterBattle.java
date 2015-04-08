public class MonsterBattle {

	private int currentMonsterID;
	
	//WHAT DID THE CURRENT MONSTER ID DO? 4/6/2015
	
	private Monster mTemp;
	
	private boolean inBattle;

	private Action currentPlayerAction;

	private Action currentMonsterAction;
	
	Player pTemp;

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
	public void changeHealth() 
	{
		//player attacks with gun & monster attacks
		if(pTemp.getNextAction().equals(Action.attack_gun) && mTemp.getNextAction().equals(Action.attack))
		{
			//how the fuck do you get the monster's damage
			//also how about the player's weapon damage
			pTemp.updateHealth(pTemp.getHealth()-mTemp.getMonsterID());
			mTemp.updateHealth(mTemp.getHealth()-25);
		}
		//player attacks with gun & monster defends
		if(pTemp.getNextAction().equals(Action.attack_gun) && mTemp.getNextAction().equals(Action.attack))
		{
			//how the fuck do you get the monster's defence
			pTemp.updateHealth(pTemp.getHealth()-mTemp.getMonsterID());
			mTemp.updateHealth(mTemp.getHealth()-25);
		}
		//player attacks with stun gun and monster attacks
		if(pTemp.getNextAction().equals(Action.attack_stun) && mTemp.getNextAction().equals(Action.attack))
		{
			//how the fuck do you get the monster's damage
			pTemp.updateHealth(pTemp.getHealth()-mTemp.getMonsterID());
			mTemp.updateHealth(mTemp.getHealth()-25);
		}

	}
	
	//following the sdd
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
