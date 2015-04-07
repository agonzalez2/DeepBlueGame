
public class Game
{
	//Public Game-Object Data Structures
	public static Room[] roomArray = new Room[30];
	public static Monster[] monsterArray = new Monster[10]; 
	public static Puzzle[] puzzleArray = new Puzzle[10]; 
	
	public static Player currentPlayer;
	private int GameSave = 0;
	private int GameID = 0;
	public int scubaPartCount = 0;
	public static int currentRoomID = 0;
	
	public Game(Room[] r, Monster[] m, Puzzle[] p)
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
