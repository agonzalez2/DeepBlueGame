
public class Room 
{

	private String RoomDescription;
	private boolean monster;
	private boolean puzzle;
	private Item[] objectsInRoom;
	private int monsterInRoomID;
	private int puzzleInRoomID;
	private boolean complete;
	private int placeInObjects;
	
	
	public Room(String roomDescription, Item[] objectsInRoom, int monsterInRoomID, int puzzleInRoomID)
	{
		RoomDescription = roomDescription;
		this.objectsInRoom = objectsInRoom;
		this.monsterInRoomID = monsterInRoomID;
		this.puzzleInRoomID = puzzleInRoomID;
		monster = (monsterInRoomID >= 0);
		puzzle = (puzzleInRoomID >= 0);
		complete = false;
	}

	private void markRoomComplete() 
	{
		complete = true;
	}

	//still in progress
	public String investigate() 
	{
		
		if (placeInObjects == objectsInRoom.length) markRoomComplete();
		return null;
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

}
