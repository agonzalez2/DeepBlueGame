import java.util.HashMap;


public class Game
{
	private static Game instance;
	
	//Public Game-Object Data Structures
	public static Room[] roomArray;
	public static Monster[] monsterArray; 
	public static Puzzle[] puzzleArray; 
	public static HashMap<Integer, Integer> levelMinimumSet = new HashMap<Integer, Integer>(); //stores minimum room index for that level
	public static HashMap<Integer, Integer> roomLevelSet = new HashMap<Integer, Integer>(); //stores all rooms and their levels by index
	
	public Player currentPlayer;
	private int GameSave = 0;
	private int GameID = 0;
	public int scubaPartCount = 0;
	public int currentRoomID = -1;
	
	public boolean inBattle = false;
	
	protected Game(Room[] r, Monster[] m, Puzzle[] p)
	{
		roomArray = r;
		monsterArray = m;
		puzzleArray = p;
	
		setLevels();
		
		instance = this; //i believe this actually works with the getInstance class to retain information not passed in constructor
		
	}
	
	public void run()
	{
		
		String firstGameString = "You wake up in a dark room.  There are three doors in front of you and nowhere else to go.  "
				+ '\n' + "Enter a number 1, 2, or 3 to choose a door.";
		UserInterface.setGameTextArea(firstGameString);
		promptUserForNext();

	}
	
	private static void setLevels()
	{
		
		levelMinimumSet.put(1, 0);
		levelMinimumSet.put(2, 3);
		levelMinimumSet.put(3, 6);
		levelMinimumSet.put(4, 9);
		levelMinimumSet.put(5, 12);
		levelMinimumSet.put(6, 15);
		levelMinimumSet.put(7, 18);
		levelMinimumSet.put(8, 21);
		levelMinimumSet.put(9, 24);
		levelMinimumSet.put(10, 27);
		
		roomLevelSet.put(-1, 0);
		roomLevelSet.put(0, 1);
		roomLevelSet.put(1, 1);
		roomLevelSet.put(2, 1);
		roomLevelSet.put(3, 2);
		roomLevelSet.put(4, 2);
		roomLevelSet.put(5, 2);
		roomLevelSet.put(6, 3);
		roomLevelSet.put(7, 3);
		roomLevelSet.put(8, 3);
		roomLevelSet.put(9, 4);
		roomLevelSet.put(10, 4);
		roomLevelSet.put(11, 4);
		roomLevelSet.put(12, 5);
		roomLevelSet.put(13, 5);
		roomLevelSet.put(14, 5);
		roomLevelSet.put(15, 6);
		roomLevelSet.put(16, 6);
		roomLevelSet.put(17, 6);
		roomLevelSet.put(18, 7);
		roomLevelSet.put(19, 7);
		roomLevelSet.put(20, 7);
		roomLevelSet.put(21, 8);
		roomLevelSet.put(22, 8);
		roomLevelSet.put(23, 8);
		roomLevelSet.put(24, 9);
		roomLevelSet.put(25, 9);
		roomLevelSet.put(26, 9);
		roomLevelSet.put(27, 10);
		roomLevelSet.put(28, 10);
		roomLevelSet.put(29, 10);
		
		
	}
	
	public static void promptUserForNext()
	{
		int currentRoom = Game.getInstance().currentRoomID;
		int currentLevel = roomLevelSet.get(currentRoom);
		int nextLevel = currentLevel + 1;
		int minimumRoomNumForLevel = levelMinimumSet.get(nextLevel);
		int nextRoom = UserInterface.promptUserForRoom();
		nextRoom = minimumRoomNumForLevel + nextRoom;
		Game.getInstance().currentRoomID = nextRoom;
		UserInterface.setGameTextArea(roomArray[nextRoom].getRoomDescription());
		if(roomArray[nextRoom].hasMonster())
		{
			int monsterInRoom = Game.roomArray[Game.getInstance().currentRoomID].getMonsterInRoom();
			String monstName = Game.monsterArray[monsterInRoom].getName();
			UserInterface.setGameTextArea("MONSTER IN ROOM! " + monstName);
		}
	

	}
	
	public void toggleBattle()
	{
		inBattle = !inBattle;
	}
	
	private static void saveGame()
	{
		
	}
	
	public void setCurrentRoom(int roomNum)
	{
		currentRoomID = roomNum;
	}
	
	private static void loadGame()
	{
		
	}
	
	private static void exit()
	{
		
	}
	
	public static Game getInstance()
	{
		if (instance == null)
		{
			instance = new Game(roomArray, monsterArray, puzzleArray);
		}
		return instance;
	}
}
