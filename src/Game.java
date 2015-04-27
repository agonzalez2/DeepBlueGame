import java.util.HashMap;

/**Class: Game 
* @author Andrew Cronic 
* @version 3.0 
* Course : ITEC 3150 Spring 2015 
* Written: April 4, 2015
* 
* 
* Game -
* This class stores all important Game information and game-related data structures [monsters, puzzles, rooms(and items within)]
* These structures are public and available to other classes to reference when necessary.
* 
* Purpose: hold all important game information, making it available to other classes and contains a run method which starts the game.
*/ 
public class Game
{
	private static Game instance;
	
	//Public Game-Object Data Structures
	public static Room[] roomArray;
	public static Monster[] monsterArray; 
	public static Puzzle[] puzzleArray; 
	public static HashMap<Integer, Integer> levelMinimumSet = new HashMap<Integer, Integer>(); //stores minimum room index for that level
	public static HashMap<Integer, Integer> roomLevelSet = new HashMap<Integer, Integer>(); //stores all rooms and their levels by index
	
	public static int currentNumberOfItems = 0; //reference for maintaining unique item id's
	
	public Player currentPlayer;
	//private int GameSave = 0;
	//private int GameID = 0;
	public static int scubaPartCount;
	public int currentRoomID;
	
	public boolean inBattle = false; //initially set to false
	
	
	/**
	Constructor: Game()
	*
	Constructs new Game and sets local game variables.
	*
	*@param r - Room Array that contains all room objects with their respective variables set from the CreateGame class
	*@param m - Monster Array containing all fixed monster objects - generated in CreateGame
	*@param p - Puzzle Array containing all fixed puzzle objects - generated in CreateGame
	**/
	protected Game(Room[] r, Monster[] m, Puzzle[] p)
	{
		roomArray = r;
		monsterArray = m;
		puzzleArray = p;
	
		setLevels(); //generates level information and stores in level Data Structures - levelMinimumSet, roomLevelSet
		
		instance = this; //works with the getInstance class to retain information not passed in constructor
		currentRoomID = -1;
		scubaPartCount = 0;
	}
	
	
	/**
	Method: run()
	*
	Displays the game's opening instructions to the UserInterface and performs the initial prompt to the user for the next room.
	After that, the game will essentially run itself based on what is passed to the User Interface's setGameTextArea method.
	*
	**/
	public void run()
	{
		UserInterface.resetInterface();
		String firstGameString = "You wake up in a dark room.  There are three doors in front of you and nowhere else to go.  "
				+ '\n' + "Enter a number 1, 2, or 3 to choose a door.";
		UserInterface.setGameTextArea(firstGameString);
		promptUserForNext();

	}
	
	/**
	Method: setLevels()
	*
	This method simply maps each level to its associated minimum room index number for that level in levelMinimumSet
	then maps ALL rooms to their associated levels.  These values are always fixed.
	*
	**/
	private static void setLevels()
	{
		
		//minimum room number for each level
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
		
		//maps rooms to their respective levels
		roomLevelSet.put(-1, 0); //currentRoomID is initially -1, this allows for the game to start before Level 1.
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
	
	/**
	Method: promptUserForNext()
	*
	Constructs new UserInterface, configures all components' visual information,
	and adds ActionListeners to necessary components.
	*
	**/
	public static void promptUserForNext()
	{
		if(roomLevelSet.get(Game.getInstance().currentRoomID) < 10)
		{
			int currentRoom = Game.getInstance().currentRoomID;
			int currentLevel = roomLevelSet.get(currentRoom); //retrieves the current room's Level
			int nextLevel = currentLevel + 1; //determines what the next level is
			int minimumRoomNumForLevel = levelMinimumSet.get(nextLevel); //determines what the minimum room number can be for the next level
			int nextRoom = UserInterface.promptUserForRoom(); //the user selects the nextRoom (will be 0, 1, or 2)
			nextRoom = minimumRoomNumForLevel + nextRoom; //adds the user selection to the minimum room number for the next level to determine the next room.
			Game.getInstance().currentRoomID = nextRoom; //update the currentRoomID
			System.out.println("Current Room ID is " + Game.getInstance().currentRoomID);
			
			//Display new room's description
			UserInterface.setGameTextArea(roomArray[nextRoom].getRoomDescription());
			//Display if room has monster to toggle monster battle (in UserInterface.setGameTextArea)
			if(roomArray[nextRoom].hasMonster())
			{
				int monsterInRoom = Game.roomArray[Game.getInstance().currentRoomID].getMonsterInRoom();
				String monstName = Game.monsterArray[monsterInRoom].getName();
				String monstDesc = Game.monsterArray[monsterInRoom].getDesc();
				UserInterface.setGameTextArea("MONSTER IN ROOM! " + monstName + " - " + monstDesc + " - "
						+ " is in the room! Defeat the monster!");
			}
		}
		
		else
		{
			UserInterface.promptGameOverMessage();
		}
	

	}
	
	/**
	Method: toggleBattle()
	*
	Changes the current boolean value of inBattle to its opposite value
	**/
	public void toggleBattle()
	{
		inBattle = !inBattle;
	}
	
	/**
	Method: setCurrentRoom()
	*
	Updates the currentRoomID to the integer parameter passed to the method
	*
	*@param roomNum - the new room number to set currentRoomID equal to.
	**/
	public void setCurrentRoom(int roomNum)
	{
		currentRoomID = roomNum;
	}
	
	/**
	Method: getInstance()
	*
	Method that returns the current Game instance so that other Classes can reference private class variables of an instance.
	*
	*@return instance - the current Game instance to be returned with all encapsulated data.
	**/
	public static Game getInstance()
	{
		if (instance == null)
		{
			instance = new Game(roomArray, monsterArray, puzzleArray);
		}
		return instance;
	}
	
	public static void setInstance(Game g)
	{
		instance = g;
		
	}
	
	public static int getUniqueItemID()
	{
		int newItemID = currentNumberOfItems;
		currentNumberOfItems++;
		return newItemID;
		
	}
	
	/**
	 * TO BE IMPLEMENTED AT A LATER POINT
	private static void saveGame()
	{
		
	}
	
	
	private static void loadGame()
	{
		
	}
		**/
	public static void exit()
	{
		System.exit(0);
	}

	
}
