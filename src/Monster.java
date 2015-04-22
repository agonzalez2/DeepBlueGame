import java.io.Serializable;

/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: Represents the non-playable characters the player must fight.
 */

public class Monster implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Action[] actionSequence;
	private int monsterID;
	private String name;
	private String monsterDesc;
	private int health;
	private int nextAction = 0;
	private int damage;
	private double defense;
	private boolean isDefeated = false;	
	
	/**
	 * Method: Monster constructor
	 * @param monsterID
	 * @param name
	 * @param monsterDesc
	 * @param health
	 * @param damage
	 * @param defense
	 * @param actionSequence
	 */
	public Monster(int monsterID, String name,String monsterDesc, int health,int damage, double defense, Action[] actionSequence) 
	{
		this.monsterID = monsterID;
		this.name = name;
		this.monsterDesc = monsterDesc;
		this.health = health;
		this.damage = damage;
		this.defense = defense;
		this.actionSequence = actionSequence;
	}
	
	/**
	 * Method: getMonsterID()
	 * @return monster ID number
	 */
	public int getMonsterID() 
	{
		return monsterID;
	}
	
	/**
	 * Method: getName()
	 * @return the monster's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Method: getDesc()
	 * @return monster's description
	 */
	public String getDesc()
	{
		return monsterDesc;
	}

	/**
	 * Method: getHealth()
	 * @return the monster's health
	 */
	public int getHealth() 
	{
		return health;
	}

	/**
	 * Method: updateHealth(int newHealth) 
	 * sets the monster's health to a specific amount
	 * @param newHealth
	 */
	public void updateHealth(int newHealth) 
	{
		health += newHealth;
	}

	/**
	 * Method: getNextAction()
	 * repeats actionSequence if at end of actionSequence
	 * @return the next action in the actionSequence
	 */
	public Action getNextAction()
	{
		if(nextAction >= actionSequence.length)
		{
			nextAction = 0;
			return actionSequence[nextAction];
		}else
		{
			return actionSequence[nextAction];
		}
	}

	/**
	 * Method: performAction()
	 * @return the next action in the actionSequence
	 */
	public Action performAction()
	{
		return actionSequence[nextAction];
		//if(actionSequence[nextAction].equals(Action.attack))
	}
	
	/**
	 * Method: getDamage()
	 * @return the damage amount
	 */
	public int getDamage()
	{
		return damage;
	}
	
	/**
	 * Method: getDefence()
	 * @return the defense amount
	 */
	public double getDefense()
	{
		return defense;
	}

	/**
	 * Method: toggleIsDefeated()
	 * isDefeated is default false since monsters are created
	 * at full health. Toggled if monster health decreases <0.
	 * @return true if the monster's health is 0
	 */
	public boolean toggleIsDefeated()
	{
		isDefeated = !isDefeated;
		return isDefeated;
	}
	
}
