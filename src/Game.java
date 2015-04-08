
public class Game
{
	private static Game instance;
	
	//Public Game-Object Data Structures
	public static Room[] roomArray;
	public static Monster[] monsterArray; 
	public static Puzzle[] puzzleArray; 
	
	public Player currentPlayer;
	private int GameSave = 0;
	private int GameID = 0;
	public int scubaPartCount = 0;
	public int currentRoomID = 0;
	
	protected Game(Room[] r, Monster[] m, Puzzle[] p)
	{
		roomArray = r;
		monsterArray = m;
		puzzleArray = p;
	}
	
	public void run()
	{
		String firstGameString = "You wake up in a dark room.  There are three doors in front of you and nowhere else to go.  Choose a door.";
		UserInterface.setGameTextArea(firstGameString);
		
		//while(true)
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
