/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: 
 */

import java.util.ArrayList;

/*Change Log as of 3/30/2015
 * Included no parameter default constructor
 * changed capitalization of health, inventory
 * inventory is now arrayList
 * performAction parameter changed from int to Action
 * temporary item class was created thus rooms.Item is changed to just Item
 * Action class is independent of any package (wat)
 * changed removeFromInventory parameter from int to Item and changed to String
 * changed getInventory return type from item[] to String because of toString of inventory
 * 
<<<<<<< HEAD
 * 
 * in game, there is 1 single player instance
 * the player has a inventory arraylist
 * that is it
 * to get items from the inventory
 * inventory.get(item's index)
 * how would you get the item index?
 * inventory.indexOf(item object)
 * how would player get the item object?
 * if(player.input
 * 
*/

public class Player
{

	private int health;
	
	private ArrayList<Item> inventory;

	private Action[] actionArray = new Action[5];
	private Action nextAction;
	
	//Possible actions player can before
	private void popActionArray()
	{
		actionArray[0] = Action.attack_pistol;
		actionArray[1] = Action.attack_stun;
		actionArray[2] = Action.reload_pistol;
		actionArray[3] = Action.reload_stun;
		actionArray[4] = Action.move;
		actionArray[5] = Action.open_inventory;
		actionArray[6] = Action.use;
	}
	
	//Parameterized constructor allows for save/loading non-full health players
=======

 */
public class Player 
{

	private int health;

	private ArrayList<Item> inventory = new ArrayList<Item>();
	private Action[] actionArray = new Action[2];
	private Action nextAction;

	public Player() 
	{
		this.health = 100;
	}

	//paramatrized constructor allows for save/loading non-full health players
>>>>>>> origin/master
	public Player(int health) 
	{
		this.health = health;
	}
<<<<<<< HEAD
	
	//Default constructor of new player
	public Player() 
=======

	private void popActionArray()
>>>>>>> origin/master
	{
		actionArray[0] = Action.attack;
		actionArray[1] = Action.defend;
	}
<<<<<<< HEAD
	
	//Returns player's current action
=======

	//stores player's current action
>>>>>>> origin/master
	public Action getNextAction()
	{
		return nextAction;
	}
<<<<<<< HEAD
	
	//NOT NEEDED IF GAME.USERINPUT IS ACCESSIBLE
	//Stores user's current command
=======

>>>>>>> origin/master
	public void setNextAction(Action nextAction)
	{
		this.nextAction = nextAction;
	}
	
	//@incomplete
	//All these actions are called by the monsterBattle class
	public void performAction(Action nextAction)
	{
		//actionArray[0] is attack_pistol
		if(nextAction.equals(actionArray[0]))
<<<<<<< HEAD
		{
			//parse the user input here?
			
		}
		if(nextAction.toString().equals(Action.defend.toString()))
		{
			
		}
	}
	//NEED SPECIFICATION ON HOW USER INPUT IS PARSED
=======
			//processes defend command
			if(nextAction.toString().equals(Action.defend.toString()))
			{

			}
			else switch(nextAction)
			{
			//Attack calls upon weapon's damage amount
			case attack:
				//Defends calls upon shield's defend amount
			case defend:
			}
	}

>>>>>>> origin/master
	//Adds an item to inventory when player obtains an item
	public void addToInventory(Item itemToAdd) 
	{
		inventory.add(itemToAdd);
		if(itemToAdd instanceof AmmoPack)
		{
			if (itemToAdd.getDescription().equalsIgnoreCase("stun ammo"))
			{
				UserInterface.updateInventory(1, 1);
			}
			else if(itemToAdd.getDescription().equalsIgnoreCase("pistol ammo"))
			{
				UserInterface.updateInventory(2, 1);
			}
		}
		if(itemToAdd instanceof HealthPack)
		{
			UserInterface.updateInventory(3, 1);
		}

		if(itemToAdd.getID() == 4)
		{
			UserInterface.updateInventory(4, 1);
		}

	}

	//Removes an item from inventory by player request or item use
	public String removeFromInventory(Item itemToRemove) 
	{
		inventory.remove(inventory.indexOf(itemToRemove));

		if(itemToRemove.getID() == 1)
		{
			UserInterface.updateInventory(1, -1);
		}

		if(itemToRemove.getID() == 2)
		{
			UserInterface.updateInventory(2, -1);
		}

		if(itemToRemove.getID() == 3)
		{
			UserInterface.updateInventory(3, -1);
		}

		if(itemToRemove.getID() == 4)
		{
			UserInterface.updateInventory(4, -1);
		}

		return itemToRemove.toString() + "Has been removed!";
	}

	//Returns a list of items inside of the player's inventory
	public String getInventory() 
	{
		return inventory.toString();
	}

<<<<<<< HEAD
	//Returns an item the user requests
	public Item getItem(int item)
	{
		return inventory.get(item);
	}
	
	//Uses an actual item specified by the user
=======
	//Alexander added this, should work but may need more thinking
>>>>>>> origin/master
	public String useItem(int itemPosition)
	{
		return inventory.get(itemPosition).use();
	}
<<<<<<< HEAD
	
	//Currently purely just teleporting
	//Navigation between rooms
	public void moveToNext(int nextRoom) 
	{
		Game.setCurrentRoom(nextRoom);
	}
	
	//Returns health of player
=======

	//Navigation 
	public void moveToNext(int nextRoom) 
	{
		//		setCurrentRoomID(nextRoom);
	}


>>>>>>> origin/master
	public int getHealth()
	{
		return health;
	}

	//Sets the health to a specific amount (TOTAL HEALTH)
	public void updateHealth(int newHealth) 
	{
		health = newHealth;
	}
}
