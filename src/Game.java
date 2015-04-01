
public class Game 
{
	//Public Game-Object Data Structures
	//public static Room[] roomArray = new Room[30];
	//public static Monster[] monsterArray = new Monster[10]; //CHECK VALUE
	//public static Puzzle[] puzzleArray = new Puzzle[15];  //Check Value
	
	private int GameSave = 0;
	private int GameID = 0;
	public int scubaPartCount = 0;
	private static int currentRoomID = 0;
	
	public static void Game()
	{
		//Constructor
	}
	
	private static void saveGame()
	{
		
	}
	
	public static void setCurrentRoom(int roomNum)
	{
		currentRoomID = roomNum;
	}
	
	private static void loadGame()
	{
		
	}
	
	private static void exit()
	{
		
	}
	
}
