import java.util.ArrayList;

public class Monster
{
	private Action[] actionSequence;
	private int monsterID;
	private String name;
	private String monsterDesc;
	private int health;
	private int nextAction;


	public Monster(int monsterID, String name,String monsterDesc, int health) 
	{
		this.monsterID = monsterID;
		this.name = name;
		this.monsterDesc = monsterDesc;
		this.health = health;
		nextAction = 0;
	}
	
	public int getMonsterID() 
	{
		return monsterID;
	}
	
	public String getName(){
		return name;
	}

	public String getDesc()
	{
		return monsterDesc;
	}

	public int getHealth() 
	{
		return health;
	}

	public void updateHealth(int amount) 
	{
		health -= amount;
	}

	public Action getNextAction()
	{
		nextAction++;
		return actionSequence[nextAction];
	}

	public Action performAction()
	{
		return null;
	}

	
}
