public class Room 
{

	private String RoomDescription;
	private boolean monster;
	private boolean puzzle;
	private Item[] objectsInRoom;
	private int monsterInRoomID;
	private int puzzleInRoomID;
	private boolean complete = false;
	private int placeInObjects = 0;


	public Room(String roomDescription, Item[] objectsInRoom, int monsterInRoomID, int puzzleInRoomID)
	{
		RoomDescription = roomDescription;
		this.objectsInRoom = objectsInRoom;
		this.monsterInRoomID = monsterInRoomID;
		this.puzzleInRoomID = puzzleInRoomID;
		monster = (monsterInRoomID >= 0);
		puzzle = (puzzleInRoomID >= 0);
	}

	private void markRoomComplete() 
	{
		complete = true;
	}

	//still in progress
	public String investigate() 
	{
		String info;
		if (placeInObjects == objectsInRoom.length) 
		{
			info = "The room is now empty.";
			markRoomComplete();
		}
		else
		{
			Item roomObject = objectsInRoom[placeInObjects];
			info = "The room contained " + roomObject.getDescription();
			//Game.player.addToInventory(roomObject);
			info += ", it has been added to your inventory.";
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

}
