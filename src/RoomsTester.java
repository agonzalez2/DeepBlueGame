import java.util.ArrayList;


/**Class: RoomsTester.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 12, 2015 
 * 
 * 
 * This class – Test of the Room class, along with interactions of Items and player inventory. 
 * 
 * Purpose: – To test all methods of the Room class
 */
public class RoomsTester
{

	public static void main(String[] args)
	{
		System.out.println("Creating an empty room with no monster, no puzzle, and no items\n");
		Room test = new Room("Empty test room",new ArrayList<Item>(),-1,-1);
		
		System.out.println("Test constructor on proper intialization of variables\n");
		System.out.println(test);
		System.out.println("\nhasMonster value(actual): " + test.hasMonster() + ", expected: false");
		System.out.println("hasPuzzle value(actual): " + test.hasPuzzle() + ", expected: false");
		System.out.println("isComplete value(actual): " + test.isComplete() + ", expected: false");
		
		System.out.println("\nTest investigate method.\n"
				+ "Expected: string stating room is empty, mark room complete");
		System.out.println("Investigate result: " + test.investigate());
		System.out.println("isComplete value: " + test.isComplete());
		
		System.out.println("\nCreating a room with monster, puzzle, and 2 items\n");
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Weapon("Test weapon", 23, "Stun", 10));
		items.add(new AmmoPack("New AmmoPack", "Stun Ammo", 3, 20));
		Room test1 = new Room("Ocupied room",items,1,2);
		
		//Must initialize Game for this test, 
		//to avoid null pointer exception when adding to inventory,player must exist
		Game.getInstance().currentPlayer = new Player(100);
		
		System.out.println("Test constructor on proper intialization of variables\n");
		System.out.println(test1);
		System.out.println("\nhasMonster value(actual): " + test1.hasMonster() + ", expected: true");
		System.out.println("hasPuzzle value(actual): " + test1.hasPuzzle() + ", expected: true");
		System.out.println("isComplete value(actual): " + test1.isComplete() + ", expected: false");
		
		System.out.println("\nTest investigate method.\n"
				+ "Expected: string stating weapon has been added to inventory, room still incomplete");
		System.out.println("Investigate result: " + test1.investigate());
		System.out.println("isComplete value: " + test1.isComplete());
		
		System.out.println("\nTest investigate method second time.\n"
				+ "Expected: string stating ammo pack has been added to inventory, room still incomplete");
		System.out.println("Investigate result: " + test1.investigate());
		System.out.println("isComplete value: " + test1.isComplete());
		
		System.out.println("\nTest investigate method third time.\n"
				+ "Expected: string stating room is empty, mark room complete");
		System.out.println("Investigate result: " + test1.investigate());
		System.out.println("isComplete value: " + test1.isComplete());
	}

}
