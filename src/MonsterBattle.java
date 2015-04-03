public class MonsterBattle {

	private int currentMonsterID;
	
	private boolean inBattle;

	private Action currentPlayerAction;

	private Action currentMonsterAction;
	
	Player pTemp;

	public MonsterBattle(Player player, Monster monster) {
		pTemp = player;
		currentMonsterID = monster.getMonsterID();
	}

	public void changeHealth(int playerHealthChange, int monsterHealthChange) {

	}

	public void requestPlayerAction() {

	}

	public void getMonsterAction() {

	}
	
	public void toggleBattle(){
		inBattle = !inBattle;
	}

	public String getResult() {
		if(pTemp.getHealth() == 0)
			return "You have died!";
		else
			return "You win!";
	}

}
