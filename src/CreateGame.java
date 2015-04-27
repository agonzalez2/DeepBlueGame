
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
	public static Monster[] tempMonsterArray = new Monster[15];
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
		Action[] typeA = {Action.attack,Action.defend,Action.attack,Action.defend};
		Action[] typeB = {Action.defend,Action.attack,Action.defend,Action.attack};
		Action[] typeC = {Action.attack,Action.attack,Action.attack,Action.attack};		
		
		//Monster objects are created and added to tempMonsterArray data structure
		tempMonsterArray[0] = new Monster(0,"Sea Tortoise", "an angry spiky-shelled tortoise.", 50, 5, 0.9, typeA );		
		tempMonsterArray[1] = new Monster(1,"Man-Shark", "a chimera with a human body and a shark head.", 55, 10, 0.3, typeA );		
		tempMonsterArray[2] = new Monster(2,"Jaws", "the famous 25-foot shark with an appalling appetite for human flesh.", 55, 10, 0.1, typeA );		
		tempMonsterArray[3] = new Monster(3,"Zoidberg", "a lobster who is a poor excuse for a human doctor.", 60, 5, 0, typeA );		
		tempMonsterArray[4] = new Monster(4,"Giant Jellyfish", "the largest kind of cnidarian in the world with hundreds of tentacles.", 50, 10, 0.5, typeA );		
		tempMonsterArray[5] = new Monster(5,"Sea Serpent", "an amphibious dragon with vicious fangs.", 60, 10, 0.6, typeA );
		tempMonsterArray[6] = new Monster(6,"Spider-Crab", "staring at you intently with its eight eyes.", 60, 10, 0.7, typeC );
		tempMonsterArray[7] = new Monster(7,"Mermaid", "a fabled creature with a torso of a human and a tail of a fish.",50, 5, 0.2, typeA );
		tempMonsterArray[8] = new Monster(8,"Siren", "a seducing winged creature with a scream that could be heard from miles away.", 50, 10, 0.5, typeA );	
		tempMonsterArray[9] = new Monster(9,"Hydra", "a multi-headed sea snake with regenerative abilties.", 55, 5, 1, typeA );
		tempMonsterArray[10] = new Monster(10,"Medusa", "a famed sea serpent with powers to freeze you for a mere glance at her eyes.", 70, 10, 0.2, typeA );
		tempMonsterArray[11] = new Monster(11,"Giant Squid", "a squid with tentacles amassing up to 44 feet.", 50, 5, 0.3, typeA );
		tempMonsterArray[12] = new Monster(12,"Sea Bear", "an enormous fish with a bear head.", 65, 10, 0.5, typeA );	
		tempMonsterArray[13] = new Monster(13,"Kraken", "the mysterious, merciless giant squid hungry for human.", 80, 15, 0.9, typeA );
		tempMonsterArray[14] = new Monster(14,"Cthulhu", "the renowned sea god bearing the ability to control all sea creatures.", 100, 15, 1, typeC );	

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

		String desc = "The room contains a combination lock, but it is odd, there are no dials to it.";
		Action[] actions = {Action.hit,Action.relax,Action.shoot};
		String r1 = "You've hit the lock, but it won't buldge. Your temper is going up.";
		String r2 = "Now that you relax, you get an idea to force the lock open...";
		String r3 = "That worked! The lock opens.";
		String r4 = "That doesn't work, try using brute force";
		String r5 = "Your not thinking clearly";
		String r6 = "Try breaking the lock";
		String[][] results = new String[2][3];
		results[0][0] = new String(r1);
		results[0][1] = new String(r2);
		results[0][2] = new String(r3);
		results[1][0] = new String(r4);
		results[1][1] = new String(r5);
		results[1][2] = new String(r6);

		tempPuzzleArray[0] = new Puzzle(new String(desc), actions, 1, results, new ScubaGear("Snorkle", 0));
		tempPuzzleArray[6] = new Puzzle(new String(desc), actions, 7, results, new ScubaGear("Goggles", 6));
		
		desc = "You see a command table in the corner of the room, "
				+ "there is a warning message about the pressure of the ship, its increasing..."
				+ "\nWhat do you do to release the pressure?";
		Action[] actions2 = {Action.search_manual,Action.find_key,Action.turn_release};
		r1 = "The manual says there is a release valve, but it requires a key";
		r2 = "You found the key in one of the drawers, and the release valve is in the command table";
		r3 = "Wow, that was close, the ship's pressure is stabilizing";
		r4 = "That didn't help. There should be some instructions to this.";
		r5 = "Hmm, maybe you should try searching for the key";
		r6 = "The release seems to be loose now...";
		String[][] results2 = new String[2][3];
		results2[0][0] = new String(r1);
		results2[0][1] = new String(r2);
		results2[0][2] = new String(r3);
		results2[1][0] = new String(r4);
		results2[1][1] = new String(r5);
		results2[1][2] = new String(r6);
		
		tempPuzzleArray[1] = new Puzzle(new String(desc), actions2, 2, results2, new ScubaGear("Oxygen tank", 1));
		tempPuzzleArray[8] = new Puzzle(new String(desc), actions2, 2, results2, new HealthPack("Health Pak",99,60));
		
		desc = "There are some test tubes in a table in this room. "
				+ "some are filled mid-way, and they are bubling..."
				+ "\nTry to neutralize the chemicals before this explodes!"
				+ "\nStart with the red one... the clear chemicals seem to be stable";
		Action[] actions3 = {Action.pour_blue,Action.pour_yellow,Action.pour_pink};
		r1 = "That turned it purple, but its slowing down";
		r2 = "Somehow that worked, its going back to a clear pink";
		r3 = "Who would have tought pink neautralized it. That was close.";
		r4 = "That didn't help. The chemical is heating up";
		r5 = "Careful, lets add clearer colors to the mix";
		r6 = "You're close, think clearly now."
				+ "\nThere is another pink chemical, and that seems stable, hmmm...";
		String[][] results3 = new String[2][3];
		results3[0][0] = new String(r1);
		results3[0][1] = new String(r2);
		results3[0][2] = new String(r3);
		results3[1][0] = new String(r4);
		results3[1][1] = new String(r5);
		results3[1][2] = new String(r6);
		
		tempPuzzleArray[2] = new Puzzle(new String(desc), actions3, 3, results3, new ScubaGear("Mask", 2));
		tempPuzzleArray[9] = new Puzzle(new String(desc), actions3, 10, results3, new AmmoPack("Stun Ammo","Stun Ammo",15,5));
		
		desc = "There are some test tubes in a table in this room. "
				+ "some are filled mid-way, and they are bubling..."
				+ "\nTry to neutralize the chemicals before this explodes!"
				+ "\nStart with the clear one... the dark chemicals seem to be stable";
		Action[] actions4 = {Action.pour_yellow,Action.pour_red,Action.pour_black};
		r1 = "That turned it yellow green, its slowing down";
		r2 = "Yes, adding the dark colors definitly works";
		r3 = "You saved the ship from sinking further.";
		r4 = "That didn't help. The chemical is heating up";
		r6 = "Lets try a dark color, it might work";
		r5 = "You're close, think clearly now.";
		String[][] results4 = new String[2][3];
		results4[0][0] = new String(r1);
		results4[0][1] = new String(r2);
		results4[0][2] = new String(r3);
		results4[1][0] = new String(r4);
		results4[1][1] = new String(r5);
		results4[1][2] = new String(r6);
		
		
		tempPuzzleArray[3] = new Puzzle(new String(desc), actions4, 4, results4, new ScubaGear("Upper Bod Suit", 3));
		tempPuzzleArray[4] = new Puzzle(new String(desc), actions4, 5, results4, new ScubaGear("Lower Body Suit", 4));
		
		desc = "The room contains a chest box closed by combination lock, there is one single dial"
				+ "\nIt moves up, down, left, rigth. What could be the combination?";
		Action[] actions5 = {Action.move_up,Action.move_right,Action.move_left};
		r1 = "Good, moving up worked. Hmm, the box contains lots of arrows pointing right...";
		r2 = "The lock clicks, you're getting close.\nThe last arrow is different, but it's blured";
		r3 = "That worked! The lock opens.";
		r4 = "That doesn't work, try another direction";
		r5 = "Your not thinking clearly";
		r6 = "Not that, try another direction";
		String[][] results5 = new String[2][3];
		results5[0][0] = new String(r1);
		results5[0][1] = new String(r2);
		results5[0][2] = new String(r3);
		results5[1][0] = new String(r4);
		results5[1][1] = new String(r5);
		results5[1][2] = new String(r6);
		
		tempPuzzleArray[5] = new Puzzle(new String(desc), actions5, 6, results5, new ScubaGear("Communicator", 5));
		tempPuzzleArray[6] = new Puzzle(new String(desc), actions5, 7, results5, new AmmoPack("Stun Ammo","Stun Ammo",23,5));
		tempPuzzleArray[7] = new Puzzle(new String(desc), actions5, 8, results5, new AmmoPack("Pistol Ammo","Pistol Ammo",22,7));

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
		itemTypeArray[0] = new AmmoPack("Pistol Ammo", "Pistol", 1,5);
		itemTypeArray[1] = new AmmoPack("Stun Ammo","Stun", 2,3);
		itemTypeArray[2] = new HealthPack("Health Pak", 3, 50);
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
		//1
		descriptionList.add("You open the door to find a flooded room.  Water rushes towards you"
				+ ", but you manage to keep your footing.  Flashing, red emergency lights illuminate the room.");
		//2
		descriptionList.add("The door slowly opens, and you enter a small engine room with noisy mechanical components and gadgets working"
				+" all around.  You see what looks like more doors across the room...");
		//3
		descriptionList.add("You enter one of the base's dining halls, food and trash is thrown everywhere and tables are flipped over"
				+ " and broken.  The overhead lights flicker, and a distant drone can be heard... ");
		//4
		descriptionList.add("The door swings open, revealing some of the sleeping quarters for the ship's workers.  There is no sign of "
				+ "anyone.  Everyone's belongings are still in place, so it looks like everyone left in a hurry.  The floors are wet and water"
				+ " is dripping from the ceiling.  You should probably get out of here...");
		//5
		descriptionList.add("The door swings open, revealing an eerie, abandoned auditorium.  There is a large window in the room showing"
				+ " a chilling view of the ocean depths.  You notice what looks like a way out of the room.");
		//6
		descriptionList.add("The door is stuck.  You bust down the door to find total darkness.  The only light source seems to be"
				+ " coming from across the room.  The room smells awful. You need to find a way out of here, quick.");
		//7
		descriptionList.add("You kick the door in.  The noise echoes through a huge room you have just entered containing"
				+ " prison-like cells.  I wonder what was kept inside these cells?");
		//8
		descriptionList.add("The door blows open from water pressure building inside the room.  Water races towards you, but you manage to "
				+ "climb up some stairs inside the room.  You stumble upon many computers in a large room with many cubicles.  "
				+ "Be careful, there are many places to hide in here...");
		//9
		descriptionList.add("You enter the room and are astonished to see a glass floor and huge glass window in front of you"
				+ " presenting a view of the deep ocean and the many fish surrounding the Underwater Base.  You notice it looks as though it is cracked,"
				+ " and you're going to have to walk on the glass floor to get to the exit.  Be careful.");
		//10
		descriptionList.add("When you walk into the room you see as though it looks like a Central Control room.  There were high-tech gadgets"
				+ " everywhere and many lighted buttons.  You have no idea what any of this does.  You can't see a way out. "
				+ " You'll have to look around for an exit.");
		//11
		descriptionList.add("You have to push the door open.  The room is a mess with many pieces of furniture blocking the entrance."
				+ " You climb over the bookcases and flipped over desks.  What could have done this?  You can't see well because the lights are"
				+ " broken out." );
		//12
		descriptionList.add("You enter the submarine launch bay.  Remnant submarines are still here but it looks as though the bay door is "
				+ "pinned shut.  You'll have to escape another way.  You can hear distant shrieks and are starting to panic..." );
		//13
		descriptionList.add("You enter the base library.  Bookshelves are flipped over, pages are torn from books and thrown throughout the room.  "
				+ " Again, you see more doorways across the room.  Where is the final exit!?");
		//14
		descriptionList.add("The door opens.  You slowly enter what seems to be a dressing room.  There are old, rusty showers leaking and"
				+ " bathroom stalls at the side of the room.  It smells badly.  You think you might hear noises from the stalls...");
		//15
		descriptionList.add("You press your palm on the door sensor.  A large metal door swings open.  Looks as though you found the Armory, but there"
				+ " are no leftover items to salvage.  It seems that the place was ransacked.  You continue walking through the long, winding, hall-like"
				+ " armory, hoping to reach an exit.");
		//16
		descriptionList.add("You turn the door handle and swing the door open.  This room looks like the base entertainment room.  There are couches and "
				+ "tables all around the room, and the TV is still on from the last time the place was occupied.");
		//17
		descriptionList.add("You enter the security room where you see many screens showing security camera footage from around the boat.  Many"
				+ " camera's look as though they have been broken.  You think you see a dark figure move on one of the screens...");
		//18
		descriptionList.add("You enter and find a large industrial kitchen.  There are grills, friers, and cooking tools throughout."
				+ "  You travel through the maze of kitchen machinery to find a way out.  You notice the grills are still on and hot.  No"
				+ " one bothered to turn them off...");
		//19
		descriptionList.add("You enter an enormous, formal dining room with large crystal chandelliers hanging above.  "
				+ "It is eerily empty and quiet.");
		//20
		descriptionList.add("You bust in the door.  You find an experimental lab filled with fragile beakers and cylinders.  "
				+ "You wonder what kind of experiments went on in here.");
		//21
		descriptionList.add("The door opens.  You think you may have found one of the main lobby areas.  There are large, exotic spiral stairways and red carpet."
				+ "  The downstairs area seems pretty flooded.  You decide look around upstairs...");
		//22
		descriptionList.add("You struggle to find a source of light when the door opens.  After a while your eyes adjust and you can make out "
				+ "a dim source of light coming from around a far corner of the room.  You decide to check it out...");
		//23
		descriptionList.add("You enter the barracks designated for the base's soldiers and military personnel.  "
				+ "This area seems untouched.  Everything is in place and in tact.  You look around for items...");
		//24
		descriptionList.add("You enter an area with a few large elevators... they seem to be malfunctioning and the control panel is fried. "
				+ "Looks like they may have been used to transport some kind of large vehicles.");
		//25
		descriptionList.add("The door opens and a hangar with a variety of advanced underwater vehicles appears.  Still no sign of any life.  "
				+ "You do not know how to function the vehicles so you continue searching for a way out...");
		//26
		descriptionList.add("The door opens to reveal a very long, dark, narrow hall.  You hear noises at the end of the hall, but you can't"
				+ "identify the sound.  Keep going.  You think you may be getting close.");
		//27
		descriptionList.add("The base computer lab is revealed when the door opens.  Hundreds of computers, printers, and other devices"
				+ " make up the room for the base residents to use.  ");
		//28
		descriptionList.add("The door swings open and you recognize that it is the gym area of the base.  Basketball and tennis courts line "
				+ "one side of the room, while the other contains gym excercise equipment.  It is quite messy now, with trash littered over the floor, "
				+ "and machinery broken.  You think the diving chambers are in one of the adjacent rooms and there might be a way out!");
		//29
		descriptionList.add("You arrive at a hospital / medical area where the injured are treated.  Strangely, no one is here. "
				+ "Everywhere you go, it is completely abandoned and silent.  Except for some loud noises you hear occasionally... You see a sign "
				+ "pointing towards the diving chambers!  You think that may be the way out.");
		//30
		descriptionList.add("You found the diving chambers!  Here there is a chamber that you can enter that will allow you to escape the base"
				+ " and swim to the surface.  The room doesn't look like it has much ScubaGear remaining.  Hope you brought your own!");
		
		/**
		for(int i = 0; i < 30; i++)
		{
			descriptionList.add("Room Description: " + i);
		}
		**/
		
		
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
	
	public static void resetVariables()
	{
		levelRemaining = 2;
		levelCount = 0;
		currentNumberOfMonsters = 0;
		currentNumberOfPuzzles = 0;
		
		monsterRoomSet.clear();
		puzzleRoomSet.clear();
		itemRoomSet.clear();
		scubaRoomSet.clear();
		otherItemRoomSet.clear();
		descriptionList.clear();
		
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
		resetVariables();
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
		
		
		//add one health pak
		p.addToInventory(itemTypeArray[2]);
		
		//add player weapons
		Weapon pistolWeapon = new Weapon("Pistol", 4, "Pistol", 10);
		Weapon stunWeapon = new Weapon("Stun Gun", 5, "Stun", 20);
		Shield shield = new Shield("Shield", 1, "Shield", 50);
		p.addToInventory(pistolWeapon);
		p.addToInventory(stunWeapon);
		p.addToInventory(shield);
		
		//add 3 pistol ammo packs
		for(int i = 0; i < 3; i++)
		{
			p.addToInventory(itemTypeArray[0]);
		}
		
		//add 2 stun ammo packs
		for(int i = 0; i < 2; i++)
		{
			p.addToInventory(itemTypeArray[1]);
		}

		
		System.out.println(p.getInventory());
		System.out.println(p.getInventory().size());
		test.run();
		
	}

}
