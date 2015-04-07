import java.util.ArrayList;


public class Room 
{

	private String RoomDescription;
	private boolean monster;
	private boolean puzzle;
	private ArrayList<Item> objectsInRoom;
	private int monsterInRoomID;
	private int puzzleInRoomID;
	private boolean complete = false;
	private int placeInObjects = 0;


	public Room(String roomDescription, ArrayList<Item> objectsInRoom, int monsterInRoomID, int puzzleInRoomID)
	{
		this.RoomDescription = roomDescription;
		this.objectsInRoom = objectsInRoom;
		this.monsterInRoomID = monsterInRoomID;
		this.puzzleInRoomID = puzzleInRoomID;
		this.monster = (monsterInRoomID >= 0);
		this.puzzle = (puzzleInRoomID >= 0);
	}

	private void markRoomComplete() 
	{
		complete = true;
	}

	//still in progress
	public String investigate() 
	{
		String info;
		if (placeInObjects == objectsInRoom.size()) 
		{
			info = "The room is empty.";
			markRoomComplete();
		}
		else
		{
			Item roomObject = objectsInRoom.get(placeInObjects);
			info = "The room contained " + roomObject.getDescription();
			Game.currentPlayer.addToInventory(roomObject);
			info += ", it has been added to your inventory.";
			placeInObjects++;
		}
		return info;
	}

	public String getRoomDescription() 
	{
		return RoomDescription;
	}

	public int getMonsterInRoom() 
	{
		return monsterInRoomID;
	}

	public int getPuzzleInRoom() 
	{
		return puzzleInRoomID;
	}

	public boolean hasMonster() 
	{
		return monster;
	}

	public boolean hasPuzzle() 
	{
		return puzzle;
	}

	public boolean isComplete() 
	{
		return complete;
	}
	
	public String roomtoString()
	{
		String objectString = "";
		
		for(int i = 0; i < objectsInRoom.size(); i++)
		{
			objectString = objectString + objectsInRoom.get(i).getDescription() + ", ";
		}
		
		String roomString = RoomDescription + ",  Monster ID: " + monsterInRoomID
				+ ",  Puzzle: " + puzzleInRoomID + " Items: " + objectString;
		
		return roomString;
	}

}
