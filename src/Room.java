
public class Room 
{

	private String RoomDescription;
	private boolean monster;
	private boolean puzzle;
	private Item[] objectsInRoom;
	private int monsterInRoomID;
	private int puzzleInRoomID;
	private boolean complete;

	public void markRoomComplete() 
	{

	}

	public String investigate() 
	{
		return null;
	}

	public String getRoomDescription() 
	{
		return null;
	}

	public int getMonsterInRoom() 
	{
		return monsterInRoomID;
	}

	public int getPuzzleInRoom() {
		return puzzleInRoomID;
	}

	public boolean hasMonster() {
		return monster;
	}

	public boolean hasPuzzle() {
		return puzzle;
	}

	public boolean isComplete() {
		return false;
	}

}
