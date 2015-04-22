
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**Class: Create Game 
* @author Andrew Cronic 
* @version 2.0 
* Course : ITEC 3150 Spring 2015 
* Written: April 4, 2015
* 
* 
* Create Game -
* This class generates all game objects necessary to create / start a new game and initializes
* a new game, passing all generated data structures to the Game constructor.
* 
* Purpose: The purpose of this class is to provide algorithms to generate and randomize the order of 
* rooms, monsters and puzzles to create a unique game experience for each play-through.
*/ 
public class CreateGame 
{
	
	public static Room[] tempRoomArray = new Room[30];
	public static Monster[] tempMonsterArray = new Monster[10];
	public static Puzzle[] tempPuzzleArray = new Puzzle[10];
	public static ArrayList<String> descriptionList = new ArrayList<String>(30);
	
	public static Action[] tempActionSequence = new Action[4];
	
	public static Set<Integer> monsterRoomSet = new HashSet<Integer>();
	public static Set<Integer> puzzleRoomSet = new HashSet<Integer>();
	public static Set<Integer> itemRoomSet = new HashSet<Integer>();
	public static Set<Integer> otherItemRoomSet = new HashSet<Integer>(); //contains rooms -without monsters- designated for items
	public static Set<Integer> scubaRoomSet = new HashSet<Integer>();
	
	public static ArrayList<Integer> otherRoomList = new ArrayList<Integer>();
	
	public static Item[] itemTypeArray = new Item[4];
	
	public static int levelRemaining = 2;
	public static int levelCount = 0;
	public static int currentNumberOfMonsters = 0;
	public static int currentNumberOfPuzzles = 0;

	
	/**
	Method: generateMonsters()
	*
	Generates all Monster objects that will be used in the game and adds them to tempMonsterArray for later retrieval.
	Also pulls Action information from the tempActionSequence array in order to pass the action sequence to the constructor.
	*
	**/
	public static void generateMonsters()
	{
		
		//*** Basic Action Sequence Array used during Monster Construction ***
		tempActionSequence[0] = Action.attack;
		tempActionSequence[1] = Action.defend;
		tempActionSequence[2] = Action.attack;
		tempActionSequence[3] = Action.defend;
		
		//Monster objects are created and added to tempMonsterArray data structure
		tempMonsterArray[0] = new Monster(0, "Monster 1", "Desc. 1", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[1] = new Monster(1, "Monster 2", "Desc. 2", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[2] = new Monster(2, "Monster 3", "Desc. 3", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[3] = new Monster(3, "Monster 4", "Desc. 4", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[4] = new Monster(4, "Monster 5", "Desc. 5", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[5] = new Monster(5, "Monster 6", "Desc. 6", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[6] = new Monster(6, "Monster 7", "Desc. 7", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[7] = new Monster(7, "Monster 8", "Desc. 8", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[8] = new Monster(8, "Monster 9", "Desc. 9", 100, 10,0.5, tempActionSequence);
		tempMonsterArray[9] = new Monster(9, "Monster 10", "Desc. 10", 100, 10,0.5, tempActionSequence);
	
	}
	
	/**
	Method: generatePuzzles()
	*
	Generates all Puzzle objects that will be used in the game and adds them to tempPuzzleArray for later retrieval during
	Room generation.
	*
	**/
	public static void generatePuzzles()
	{
		String[][] resultString = new String[2][2];
		resultString[0][0] = "correct";
		resultString[0][1] = "incorrect";
		resultString[1][0] = "correct";
		resultString[1][1] = "incorrect";
		
		//Action[] solutionArray = new Action[1];
		ArrayList<Action> solutionArray = new ArrayList<Action>();
		solutionArray.add(Action.use);
		
		Item prizeItem = new AmmoPack("Pistol Ammo", "Pistol", 1,10);
		//*** PUZZLE ARRAY COMPONENTS ***
		tempPuzzleArray[0] = new Puzzle(0, "Puzzle 1", resultString, solutionArray, prizeItem);
		tempPuzzleArray[1] = new Puzzle(1, "Puzzle 2", resultString, solutionArray, prizeItem);
		tempPuzzleArray[2] = new Puzzle(2, "Puzzle 3", resultString, solutionArray, prizeItem);
		tempPuzzleArray[3] = new Puzzle(3, "Puzzle 4", resultString, solutionArray, prizeItem);
		tempPuzzleArray[4] = new Puzzle(4, "Puzzle 5", resultString, solutionArray, prizeItem);
		tempPuzzleArray[5] = new Puzzle(5, "Puzzle 6", resultString, solutionArray, prizeItem);
		tempPuzzleArray[6] = new Puzzle(6, "Puzzle 7", resultString, solutionArray, prizeItem);
		tempPuzzleArray[7] = new Puzzle(7, "Puzzle 8", resultString, solutionArray, prizeItem);
		tempPuzzleArray[8] = new Puzzle(8, "Puzzle 9", resultString, solutionArray, prizeItem);
		tempPuzzleArray[9] = new Puzzle(9, "Puzzle 10", resultString, solutionArray, prizeItem);
	}
	
	
	/**
	Method: generateItems()
	*
	Generates all Item objects that will be used in the game and adds them to itemTypeArray for later retrieval
	when items are randomly selected and added to rooms.
	*
	**/
	public static void generateItems()
	{
		//initialize the item types into an array for retrieval
		itemTypeArray[0] = new AmmoPack("Pistol Ammo", "Pistol", 1,10);
		itemTypeArray[1] = new AmmoPack("Stun Ammo","Stun", 2,5);
		itemTypeArray[2] = new HealthPack("Health Pak", 3, 100);
		itemTypeArray[3] = new ScubaGear("Scuba Part", 4);
		
	}
	
	
	/**
	Method: generateRooms()
	*
	Generates all Room objects that will be used in the game and adds them to tempRoomArray to later be used as a parameter
	when initializing a new game via the Game class constructor.
	*
	*The Game has 30 rooms over 10 levels - 3 rooms for each level.
	*At each level, one room is selected to enter. 10 rooms will be visited for each play-through.  
	*A monster and puzzle is assigned to a random room within each level.
	*Rooms with monsters have random items added to them from itemTypeArray.
	*5 Items are also added randomly to any rooms with no monsters.
	*One ScubaPart is added at each level.
	*
	*
	**/
	public static void generateRooms()
	{

		//Create 30 room objects and set room id's and descriptions from 0-29.  
		//One Monster and One puzzle is added to a randomly selected room from i to i+2 every 3 rooms.
		for (int i = 0; i < tempRoomArray.length; i++)
		{		
			int monsterInRoomID = -9; //unless changed, a negative number means the room will have no monster
			int puzzleInRoomID = -8; //unless changed, a negative number means the room will have no puzzle
			ArrayList<Item> itemsInRoom = new ArrayList<Item>(); //each iteration will initialize an ArrayList to store the room's items.
			
			//resets level variables after 3 iterations
			if(levelCount >= 3)
			{
				levelCount = 0;
				levelRemaining = 2;
			}

			//monsterRoomSet contains room numbers to add monsters to.
			if (monsterRoomSet.contains(i))
			{
				monsterInRoomID = currentNumberOfMonsters;
				currentNumberOfMonsters++;
			}
			
			//puzzleRoomSet contains room numbers to add puzzles to.
			if (puzzleRoomSet.contains(i))
			{
				puzzleInRoomID = currentNumberOfPuzzles;
				currentNumberOfPuzzles++;
			}
			
			//itemRoomSet contains room numbers to add items to that also contain monsters.
			if (itemRoomSet.contains(i))
			{
				Item tempItem = itemTypeArray[getRandomNumberFrom(0,2)]; //Excludes Scuba Parts
				itemsInRoom.add(tempItem);
			}
			
			//otherItemRoomSet contains 5 room numbers (without monsters) to add items to.
			if (otherItemRoomSet.contains(i))
			{
				Item tempItem = itemTypeArray[getRandomNumberFrom(0,2)]; //Excludes Scuba Parts
				itemsInRoom.add(tempItem);
			}
			
			//scubaRoomSet contains all room numbers (1 for each level) to add a ScubaPart to.
			if(scubaRoomSet.contains(i))
			{
				//Item scubaItem = itemTypeArray[3]; //Only Scuba Parts
				itemsInRoom.add(new ScubaGear("Scuba Gear", Game.getUniqueItemID()));
			}

			//a random number generated from zero to the number of rooms remaining for the current level
			int randomNum = getRandomNumberFrom(0, levelRemaining);
			//the random number is used to pull description information from descriptionList
			String tempRoomDescription = descriptionList.get(randomNum);
			//the description information used is removed from the ArrayList so it cannot be re-used
			descriptionList.remove(randomNum);
			
			//Room is constructed and added to tempRoomArray at the current index - i
			//the index in tempRoomArray represents the room's ID.  (from 0-29)
			//Rooms are added in order so that index 0 to 2 represents level 1 rooms, 3 to 5 represents level 2 rooms, etc.
			tempRoomArray[i] = new Room(tempRoomDescription, itemsInRoom, monsterInRoomID, puzzleInRoomID);

			//decrement LevelRemaining (i.e. rooms remaining for the current level)
			//this ensures correct description information is pulled from the descriptionList
			levelRemaining--;
			//increment levelCount so that when it reaches 3 - the level variables are reset
			levelCount++;
			
		}
	}
	
	/**
	Method: populateLists()
	*
	Populates data structures that are used in generateRooms().  Room descriptions are added to
	descriptionList to be used later.  Room Numbers are added to Sets that will later determine if monsters,
	puzzles, or items will be added to that specified room number.
	*
	**/
	public static void populateLists()
	{
		
		//add generic room descriptions to descriptionList
		for(int i = 0; i < 30; i++)
		{
			descriptionList.add("Room Description: " + i);
		}
		
		
		//determine rooms to put monsters, rooms to put puzzles, rooms to put scubagear, and rooms to put some items
		for (int i = 0; i <= 27; i = i + 3)
		{
			int roomToPutMonster = getRandomNumberFrom(i, i+2);
			monsterRoomSet.add(roomToPutMonster);
			int roomToPutPuzzle = getRandomNumberFrom(i, i+2);
			puzzleRoomSet.add(roomToPutPuzzle);
			int roomToPutScuba = getRandomNumberFrom(i, i +2);
			scubaRoomSet.add(roomToPutScuba);
			itemRoomSet.add(roomToPutMonster); //Room Numbers that contain monsters are added to itemRoomSet
		}
		
		//Finds all rooms without items and adds them to otherRoomList
		for (int i = 0; i < 30; i++)
		{
			if(!(monsterRoomSet.contains(i)))
			{
				otherRoomList.add(i);
			}
		}
		
		//Pick 5 rooms out of the rooms with no items in them (from otherRoomList) and add items
		for (int i = 0; i <= 4; i++)
		{
			int randomNum = getRandomNumberFrom(0, otherRoomList.size()-1);
			otherItemRoomSet.add(otherRoomList.get(randomNum));
			otherRoomList.remove(randomNum);
		}
	
	}
	
	
	/**
	Method: getRandomNumberFrom
	*
	Generates all Monster objects that will be used in the game and adds them to tempMonsterArray for later retrieval.
	Also pulls Action information from the tempActionSequence array in order to pass the action sequence to the constructor.
	*
	@param min - Lower end of range to generate random number in
	@param max - Higher end of range to generate random number in
	**/
	public static int getRandomNumberFrom(int min, int max) 
	{
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;

        return randomNumber;

    }
	
	
	/**
	Method: main()
	*
	-Calls all necessary Class methods to generate and fill data structures, and construct Room objects
	-Iterates through tempRoomArray and prints generated room information
	-Constructs a new Game by passing room, monster, and puzzle data structures as parameters
	-Creates a new Player and fills the initial inventory
	-Starts the game by calling Game.run() method
	*
	**/
	public static void main(String Args[])
	{
		populateLists();
		generateMonsters();
		generatePuzzles();
		generateItems();
		generateRooms();

		for(int i = 0; i < tempRoomArray.length; i++)
		{
			System.out.println(tempRoomArray[i].toString());
		}
		
		Game test = new Game(tempRoomArray, tempMonsterArray, tempPuzzleArray);
		Player p = new Player(100);
		Game.getInstance().currentPlayer = p;
		
		//add 10 pistol ammo
		for(int i = 0; i < 10; i++)
		{
			p.addToInventory(itemTypeArray[0]);
		}
		
		//add 5 stun ammo
		for(int i = 0; i < 5; i++)
		{
			p.addToInventory(itemTypeArray[1]);
		}
		
		//add one health pak
		p.addToInventory(itemTypeArray[2]);
		
		//add player weapons
		Weapon pistolWeapon = new Weapon("Pistol", 4, "Pistol", 10);
		Weapon stunWeapon = new Weapon("Stun Gun", 5, "Stun", 20);
		p.addToInventory(pistolWeapon);
		p.addToInventory(stunWeapon);
		
		test.run();
		
	}

}
