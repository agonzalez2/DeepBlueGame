/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: 
 */

import java.util.ArrayList;

public class Monster
{
	private Action[] actionSequence;
	private int monsterID;
	private String name;
	private String monsterDesc;
	private int health;
	private int nextAction;
	private int damage;

	//Monster constructor without an action sequence 
	//Should delte
	public Monster(int monsterID, String name,String monsterDesc, int health) 
	{
		this.monsterID = monsterID;
		this.name = name;
		this.monsterDesc = monsterDesc;
		this.health = health;
		nextAction = 0;
	}
	
	//Monster constuctor with set action sequence array
	//id,name,description,health,Action[]
	public Monster(int monsterID, String name,String monsterDesc, int health,int damage, Action[] actionSequence) 
	{
		this.monsterID = monsterID;
		this.name = name;
		this.monsterDesc = monsterDesc;
		this.health = health;
		this.damage = damage;
		this.actionSequence = actionSequence;
		nextAction = 0;
	}
	
	//Returns monster ID
	public int getMonsterID() 
	{
		return monsterID;
	}
	
	//Returns monster's name
	public String getName(){
		return name;
	}

	//Returns monster's description
	public String getDesc()
	{
		return monsterDesc;
	}

	//Returns monster's health
	public int getHealth() 
	{
		return health;
	}

	//Set the monster's health to a specific amount
	public void updateHealth(int newHealth) 
	{
		health = newHealth;
	}

	//Returns the monster's next action
	public Action getNextAction()
	{
		nextAction++;
		return actionSequence[nextAction];
	}

	//Initiate the damage or defense actions
	//Why does this return an action?
	public Action performAction()
	{
		return actionSequence[nextAction];
		//if(actionSequence[nextAction].equals(Action.attack))
	}
	
	public int getDamage()
	{
		return damage;
	}

	
}
