package Battle;

//import Action;

public class Monster {

	private String monsterDesc;

	private Action[] actionSequence;

	private int monsterID;

	private int health;

	private int nextAction;

	private String name;

	public Monster(int monsterID, String name,String monsterDesc, int health) {
		this.monsterDesc = monsterDesc;
		this.monsterID = monsterID;
		this.health = health;
		this.name = name;
	}

	public Action performAction() {
		return null;
	}

	public int getMonsterID() {
		return monsterID;
	}

	public String getDesc() {
		return monsterDesc;
	}

	public int getHealth() {
		return health;
	}

	public void decreaseHealth(int amount) {
		health -= amount;
	}

}
