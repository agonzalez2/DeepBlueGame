import java.lang.reflect.Array;


public class CreateGame 
{
	public static TestRoom[] tempRoomArray = new TestRoom[30];
	
	
	public static void generateMonsters()
	{
		
	}
	
	public static void generatePuzzles()
	{
		
	}
	
	public static void generateItems()
	{
		
	}
	
	public static void generateRooms()
	{
		
		for (int i = 0; i < tempRoomArray.length; i++)
		{
			
			TestRoom tempRoom = new TestRoom(i);
			tempRoomArray[i] = tempRoom;
			//System.out.println(tempRoomArray[i].getRoomID());
		}
	}
	
	public static void main(String Args[])
	{
		generateRooms();
		
			//System.out.println(tempRoomArray[5].getRoomID());
			//System.out.println(tempRoomArray[15].getRoomID());
			
			for (int i = 0; i < tempRoomArray.length; i++)
			{
				System.out.println(tempRoomArray[i].getRoomID());
			}
	}

}
