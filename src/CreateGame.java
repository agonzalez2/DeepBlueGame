
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


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

	
	public static void generateMonsters()
	{
		
		//*** MONSTER ARRAY COMPONENTS ***
		
		tempActionSequence[0] = Action.attack;
		tempActionSequence[1] = Action.defend;
		tempActionSequence[2] = Action.attack;
		tempActionSequence[3] = Action.defend;
		
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
	
	public static void generatePuzzles()
	{
		
		//*** PUZZLE ARRAY COMPONENTS ***
		tempPuzzleArray[0] = new Puzzle();
	}
	
	public static void generateItems()
	{
		//initialize the item types into an array for retrieval
		itemTypeArray[0] = new AmmoPack("Pistol Ammo", 1,10);
		itemTypeArray[1] = new AmmoPack("Stun Ammo", 2,5);
		itemTypeArray[2] = new HealthPack("Health Pak", 3, 2);
		itemTypeArray[3] = new ScubaGear("Scuba Part", 4);
	}
	
	public static void generateRooms()
	{

		//Create 30 room objects and set room id's and descriptions from 0-29.  Monsters and puzzles randomly added every 3 rooms.
		for (int i = 0; i < tempRoomArray.length; i++)
		{		
			
			int monsterInRoomID = -9;
			int puzzleInRoomID = -8;
			ArrayList<Item> itemsInRoom = new ArrayList<Item>();
			
			if(levelCount >= 3)
			{
				levelCount = 0;
				levelRemaining = 2;
			}

			
			if (monsterRoomSet.contains(i))
			{
				monsterInRoomID = currentNumberOfMonsters;
				currentNumberOfMonsters++;
			}
			
			if (puzzleRoomSet.contains(i))
			{
				puzzleInRoomID = currentNumberOfPuzzles;
				currentNumberOfPuzzles++;
			}
			
			if (itemRoomSet.contains(i))
			{
				Item tempItem = itemTypeArray[getRandomNumberFrom(0,2)]; //Excludes Scuba Parts
				itemsInRoom.add(tempItem);
			}
			
			if (otherItemRoomSet.contains(i))
			{
				Item tempItem = itemTypeArray[getRandomNumberFrom(0,2)]; //Excludes Scuba Parts
				itemsInRoom.add(tempItem);
			}
			
			if(scubaRoomSet.contains(i))
			{
				Item scubaItem = itemTypeArray[3]; //Only Scuba Parts
				itemsInRoom.add(scubaItem);
			}

			int randomNum = getRandomNumberFrom(0, levelRemaining);
			String tempRoomDescription = descriptionList.get(randomNum);
			descriptionList.remove(randomNum);
			
			tempRoomArray[i] = new Room(tempRoomDescription, itemsInRoom, monsterInRoomID, puzzleInRoomID);

			
			levelRemaining--;
			levelCount++;
			
		}
	}
	
	public static void populateLists()
	{
		//*** ROOM ARRAY COMPONENTS ***
		
		//add generic room descriptions
		for(int i = 0; i < 30; i++)
		{
			descriptionList.add("Room Description: " + i);
		}
		
		//determine rooms for monsters and puzzles and add items to rooms with monsters in them
		for (int i = 0; i <= 27; i = i + 3)
		{
			int roomToPutMonster = getRandomNumberFrom(i, i+2);
			monsterRoomSet.add(roomToPutMonster);
			int roomToPutPuzzle = getRandomNumberFrom(i, i+2);
			puzzleRoomSet.add(roomToPutPuzzle);
			int roomToPutScuba = getRandomNumberFrom(i, i +2);
			scubaRoomSet.add(roomToPutScuba);
			itemRoomSet.add(roomToPutMonster);
		}
		
		//find all rooms without items
		for (int i = 0; i < 30; i++)
		{
			if(!(monsterRoomSet.contains(i)))
			{
				otherRoomList.add(i);
			}
		}
		
		//Pick 5 rooms out of the rooms with no items in them to add items to
		for (int i = 0; i <= 4; i++)
		{
			int randomNum = getRandomNumberFrom(0, otherRoomList.size()-1);
			otherItemRoomSet.add(otherRoomList.get(randomNum));
			otherRoomList.remove(randomNum);
		}
	
	}
	
	public static int getRandomNumberFrom(int min, int max) 
	{
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;

        return randomNumber;

    }
	
	
	public static void main(String Args[])
	{
		populateLists();
		generateMonsters();
		generatePuzzles();
		generateItems();
		generateRooms();

		for(int i = 0; i < tempRoomArray.length; i++)
		{
			System.out.println(tempRoomArray[i].roomtoString());
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
		
		test.run();
		
	}

}
