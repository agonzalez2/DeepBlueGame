/**Class: GameTester 
* @author Andrew Cronic 
* @version 1.0
* Course : ITEC 3150 Spring 2015 
* Written: April 12, 2015
* 
* 
* GameTester -
* This is a tester class to test the following Game-Related Classes: CreateGame, Game, UserInterface
* 
* Purpose: Verify that the above classes function as expected
*/ 
public class GameTester {
	
	public static int levelCount = 0;

	public static void main(String[] args) 
	{
		//TEST CreateGame Functionality in regards to Generating and Randomizing game-objects.
		CreateGame.populateLists();
		CreateGame.generateMonsters();
		CreateGame.generatePuzzles();
		CreateGame.generateItems();
		CreateGame.generateRooms();
		
		System.out.println("*****CREATEGAME CLASS TEST*****");
		System.out.println();
		System.out.println("*** Negative Numbers are treated as NULL ***");
		System.out.println();
		System.out.println("*** EXPECTED IN NEXT 3 ROOMS: One Monster, One Puzzle, One ScubaPart, and an Item in a room with a monster ***");
		

		for(int i = 0; i < CreateGame.tempRoomArray.length; i++)
		{
			if(levelCount == 3)
			{
				System.out.println("*** EXPECTED IN NEXT 3 ROOMS: One Monster, One Puzzle, One ScubaPart, and an Item in a room with a monster ***");
				levelCount = 0;
			}
			System.out.println(CreateGame.tempRoomArray[i].toString());
			
			levelCount++;
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//END CreateGame TEST
		
		
		//START GAME CLASS TEST
		
		System.out.println("*****GAME CLASS TEST*****");
		System.out.println("Constructor Test / Referencing Data Structures");
		System.out.println();
		
		//construct new game instance using CreateGame's data structures that have been filled
		Game testGame = new Game(CreateGame.tempRoomArray, CreateGame.tempMonsterArray, CreateGame.tempPuzzleArray);
		
		//reference testGame data structures using the Game.getInstance() method and print out contents of data structures to verify correctness
		//should match the output from the CreateGame test above
		for(int i = 0; i < testGame.roomArray.length; i++)
		{
			System.out.println((testGame.roomArray[i].toString()));
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		//GAME - Toggle Battle Test
		System.out.println("*** Game.toggleBattle() TEST ***");
		System.out.println();
		System.out.println("Current value of inBattle: " + testGame.inBattle);	
		testGame.toggleBattle();
		System.out.println("Value after calling toggleBattle() is " + testGame.inBattle);
		testGame.toggleBattle();
		System.out.println("Value after calling toggleBattle() is " + testGame.inBattle);
		testGame.toggleBattle();
		System.out.println("Value after calling toggleBattle() is " + testGame.inBattle);
		testGame.toggleBattle();
		System.out.println("Value after calling toggleBattle() is " + testGame.inBattle);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//GAME - Set Current Room Test
		System.out.println("*** Game.setCurrentRoom() TEST ***");
		System.out.println();
		System.out.println("Initial Room ID: " + testGame.currentRoomID);
		System.out.println("TEST CASE 1: ");
		testGame.setCurrentRoom(1);
		System.out.println("Current Room ID set to 1, EXPECTED: 1");
		System.out.println("Actual Current Room ID: " + testGame.currentRoomID);
		System.out.println("TEST CASE 2: ");
		testGame.setCurrentRoom(5);
		System.out.println("Current Room ID set to 5, EXPECTED: 5");
		System.out.println("Actual Current Room ID: " + testGame.currentRoomID);
		System.out.println("TEST CASE 3: ");
		testGame.setCurrentRoom(25);
		System.out.println("Current Room ID set to 25, EXPECTED: 25");
		System.out.println("Actual Current Room ID: " + testGame.currentRoomID);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("*** USERINTERFACE TEST ***");
		System.out.println();
		System.out.println();
		System.out.println("*** isInteger() TEST:");
		System.out.println("TEST CASE 1: ");
		System.out.println("INPUT: 1, EXPECTED: TRUE");
		System.out.println(UserInterface.isInteger("1"));
		System.out.println("TEST CASE 2: ");
		System.out.println("INPUT: 277, EXPECTED: TRUE");
		System.out.println(UserInterface.isInteger("277"));
		System.out.println("TEST CASE 3: ");
		System.out.println("INPUT: 'string', EXPECTED: FALSE");
		System.out.println(UserInterface.isInteger("string"));
		System.out.println("TEST CASE 4: ");
		System.out.println("INPUT: '!@#$', EXPECTED: FALSE");
		System.out.println(UserInterface.isInteger("!@#$"));
		System.out.println();
		System.out.println();
		
		System.out.println("*** updateInventory() TEST");
		System.out.println();
		System.out.println("TEST CASE 1:");
		System.out.println("INITIAL Pistol Ammo: " + UserInterface.quantityValue1);
		UserInterface.updateInventory(1, 5);
		System.out.println("ADDED 5 to Pistol Ammo, EXPECTED - 5 ACTUAL - " + UserInterface.quantityValue1);
		UserInterface.updateInventory(1, 10);
		System.out.println("ADDED 10 to Pistol Ammo, EXPECTED - 15 ACTUAL - " + UserInterface.quantityValue1);
		UserInterface.updateInventory(1, -7);
		System.out.println("REMOVED 7 from Pistol Ammo, EXPECTED - 8 ACTUAL - " + UserInterface.quantityValue1);
		System.out.println();
		System.out.println("TEST CASE 2:");
		System.out.println("INITIAL Stun Ammo: " + UserInterface.quantityValue2);
		UserInterface.updateInventory(2, 5);
		System.out.println("ADDED 5 to Stun Ammo, EXPECTED - 5 ACTUAL - " + UserInterface.quantityValue2);
		UserInterface.updateInventory(2, 10);
		System.out.println("ADDED 10 to Stun Ammo, EXPECTED - 15 ACTUAL - " + UserInterface.quantityValue2);
		UserInterface.updateInventory(2, -7);
		System.out.println("REMOVED 7 from Stun Ammo, EXPECTED - 8 ACTUAL - " + UserInterface.quantityValue2);
		System.out.println();
		System.out.println("TEST CASE 3:");
		System.out.println("INITIAL Health Pack: " + UserInterface.quantityValue3);
		UserInterface.updateInventory(3, 5);
		System.out.println("ADDED 5 to Health Pack, EXPECTED - 5 ACTUAL - " + UserInterface.quantityValue3);
		UserInterface.updateInventory(3, 10);
		System.out.println("ADDED 10 to Health Pack, EXPECTED - 15 ACTUAL - " + UserInterface.quantityValue3);
		UserInterface.updateInventory(3, -7);
		System.out.println("REMOVED 7 from Health Pack, EXPECTED - 8 ACTUAL - " + UserInterface.quantityValue3);
		System.out.println();
		System.out.println("TEST CASE 4:");
		System.out.println("INITIAL ScubaParts: " + UserInterface.quantityValue4);
		UserInterface.updateInventory(4, 5);
		System.out.println("ADDED 5 to Scuba Parts, EXPECTED - 5 ACTUAL - " + UserInterface.quantityValue4);
		UserInterface.updateInventory(4, 10);
		System.out.println("ADDED 10 to Scuba Parts, EXPECTED - 15 ACTUAL - " + UserInterface.quantityValue4);
		UserInterface.updateInventory(4, -7);
		System.out.println("REMOVED 7 from Scuba Parts, EXPECTED - 8 ACTUAL - " + UserInterface.quantityValue4);
		System.out.println();
		System.out.println();
		
		
		System.out.println("*** promptUserForRoom() TEST");
		System.out.println();
		
		int num0 = UserInterface.promptUserForRoom();
		int num1 = UserInterface.promptUserForRoom();
		int num2 = UserInterface.promptUserForRoom();
		int numNone = UserInterface.promptUserForRoom();
		System.out.println("EXPECTED SELECTION: 0, ACTUAL: " + num0);
		System.out.println("EXPECTED SELECTION: 1, ACTUAL: " + num1);
		System.out.println("EXPECTED SELECTION: 2, ACTUAL: " + num2);
		System.out.println("EXPECTED SELECTION: -1, ACTUAL: " + numNone);
		System.out.println();
		System.out.println();
		
		
		System.out.println("*** promptUserForAction() TEST");
		System.out.println();
		
		int action0 = UserInterface.promptUserForAction();
		int action1 = UserInterface.promptUserForAction();
		int action2 = UserInterface.promptUserForAction();
		int action3 = UserInterface.promptUserForAction();
		System.out.println("EXPECTED SELECTION: 0, ACTUAL: " + action0);
		System.out.println("EXPECTED SELECTION: 1, ACTUAL: " + action1);
		System.out.println("EXPECTED SELECTION: 2, ACTUAL: " + action2);
		System.out.println("EXPECTED SELECTION: 3, ACTUAL: " + action3);

		
	}

}
