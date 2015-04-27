import java.io.Serializable;
import java.util.ArrayList;

/**Class: Room.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class – A business class for the creation of room objects. 
 * Rooms will contain several important information such as: a description of the room, 
 * a list of objects, monster (if applicable), and puzzle (if applicable) that the player may encounter. 
 * <br>To help the game interface determine to activate a battle state or a puzzle state, 
 * the room will contain flags stating that a monster/puzzle is present in room. 
 * <br>In addition, a flag is available letting the game interface know whether 
 * the player has completed all possible interactions within the room. 
 * 
 * Purpose: – To represent a room that may contain a monster, a puzzle, and items
 */
public class Room implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String RoomDescription;
	private boolean monster;
	private boolean puzzle;
	private ArrayList<Item> objectsInRoom;
	private int monsterInRoomID;
	private int puzzleInRoomID;
	private boolean complete = false;

	/**
	 * The constructor for a Room object. 
	 * <br>The constructor expects the following parameters: 
	 * the description of the room, the id of the monster present in room, 
	 * the id of the puzzle present in room, and the objects in room. 
	 * <br>If puzzle or monster are not present in room, a negative number is expected. 
	 * The constructor will initialize all other variables accordingly.
	 * @param roomDescription String containing the description of the room
	 * @param objectsInRoom ArrayList of item containing the objects in room
	 * @param monsterInRoomID int containing the id of the monster present in room
	 * @param puzzleInRoomID int containing the id of the puzzle present in room
	 */
	public Room(String roomDescription, ArrayList<Item> objectsInRoom, int monsterInRoomID, int puzzleInRoomID)
	{
		this.RoomDescription = roomDescription;
		this.objectsInRoom = objectsInRoom;
		this.monsterInRoomID = monsterInRoomID;
		this.puzzleInRoomID = puzzleInRoomID;
		this.monster = (monsterInRoomID >= 0);
		this.puzzle = (puzzleInRoomID >= 0);
	}

	/**
	 * A method that will mark the room complete. 
	 * This method is private and should be called at the end of the investigate method.
	 * This method assumes all necessary condition checks have been made prior its call.
	 */
	private void markRoomComplete() 
	{
		complete = true;
	}

	/**
	 * A method that assist the player interact with the room. 
	 * This method is public and should be called by the player. 
	 * <br>This method adds the next object in room to the player's inventory. 
	 * A call to this method should be made multiple times to obtain all items in room. 
	 * Once all objects in room have been given to player, 
	 * this method will mark the room complete by calling the markRoomComplete method.
	 * @return
	 */
	public String investigate() 
	{
		String info;
		
		if(this.hasPuzzle() && !Game.puzzleArray[this.getPuzzleInRoom()].isSolved())
		{
			if(this.hasMonster() && Game.monsterArray[getMonsterInRoom()].getIsDefeated())
			{
				//UserInterface.setGameTextArea("puzzle in room");
				info = "puzzle in room";
				return info;
			}
			
			else
			{
				info = "puzzle in room";
				return info;
			}
			
		}
		
		else
		{
			if (objectsInRoom.size() == 0) 
			{
				info = "The room is empty.";
				markRoomComplete();
				
			}
			else
			{
				Item roomObject = objectsInRoom.remove(0);
				if (roomObject instanceof ScubaGear)
				{
					UserInterface.setGameTextArea(roomObject.use());
				}
				info = "The room contained " + roomObject.getDescription();
				Game.getInstance().currentPlayer.addToInventory(roomObject);
				info += ", it has been added to your inventory.";
			}
			return info;
		}
		
	}

	/**
	 * A method that gives the description of the room. 
	 * This method is public and should be called by the game interface after 
	 * the player has dealt with the monster (if applicable) and puzzle (if applicable) in the room. 
	 * The description of the room includes the number of objects in room, and some other info 
	 * as to the setting of the room (i.e. “A small closet with one crate in the middle of the floor”).
	 * <br>This method assumes that the hasMonster and hasPuzzle conditions 
	 * have been checked and dealt with prior to its call.
	 * @return a description of the room dealing with the setting of the room 
	 * and the number of objects contained within
	 */
	public String getRoomDescription() 
	{
		return RoomDescription;
	}

	/**
	 * A method that gets the monster in the room. 
	 * This method is public and should be called by the game interface 
	 * in preparation of entering battle state.
	 * <br> This method assumes the hasMonster condition was checked prior to its call.
	 * @return an integer representing the ID of the monster. 
	 * A negative number is given when the room contains no monster 
	 */
	public int getMonsterInRoom() 
	{
		return monsterInRoomID;
	}

	/**
	 * A method that gets the puzzle in the room. 
	 * This method is public and should be called by the game interface 
	 * in preparation of entering puzzle state.
	 * <br> This method assumes the hasPuzzle condition was checked prior to its call.
	 * @return an integer representing the ID of the puzzle. 
	 * A negative number is given when the room contains no puzzle 
	 */
	public int getPuzzleInRoom() 
	{
		return puzzleInRoomID;
	}

	/**
	 * A method to check if a monster is present in the room. 
	 * This method is public and should be called by the game interface 
	 * to determine if it should enter into a battle state. 
	 * <br>This method returns true or false depending on the above condition.
	 * @return boolean to determine presence of mosnter in room
	 */
	public boolean hasMonster() 
	{
		return monster;
	}

	/**
	 * A method to check if a monster is present in the room. 
	 * This method is public and should be called by the game interface 
	 * to determine if it should enter into a puzzle state. 
	 * <br>This method returns true or false depending on the above condition.
	 * @return boolean to determine presence of puzzle in room
	 */
	public boolean hasPuzzle() 
	{
		return puzzle;
	}

	/**
	 * A method to check if the room is complete. 
	 * This method is public and should be called by the game interface 
	 * to determine the state of the room. 
	 * <br>A room is complete if the user has successfully met the following conditions,
	 * Defeated the monster in the room (if applicable), 
	 * Solved the puzzle in the room (if applicable), 
	 * Collected or discarded all objects in the room (if applicable)
	 * @return boolean to determine state of room
	 */
	public boolean isComplete() 
	{
		return complete;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString()
	{
		String objectString = "";
		
		for(int i = 0; i < objectsInRoom.size(); i++)
		{
			objectString = objectString + objectsInRoom.get(i).getDescription() + ", ";
		}
		
		String roomString = "Monster ID: " + monsterInRoomID
				+ ",  Puzzle: " + puzzleInRoomID + " Items: " + objectString;
		
		return roomString;
	}

}
