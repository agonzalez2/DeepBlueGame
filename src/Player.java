import java.util.ArrayList;

//import Rooms.Item;
//import Action;

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
	public Player(int health) 
	{
		this.health = health;
	}

	private void popActionArray()
	{
		actionArray[0] = Action.attack;
		actionArray[1] = Action.defend;
	}

	//stores player's current action
	public Action getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(Action nextAction)
	{
		this.nextAction = nextAction;
	}

	//All these actions are called by the monsterBattle class
	public void performAction(Action nextAction)
	{
		if(nextAction.equals(actionArray[0]))
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

	//Alexander added this, should work but may need more thinking
	public String useItem(int itemPosition)
	{
		return inventory.get(itemPosition).use();
	}

	//Navigation 
	public void moveToNext(int nextRoom) 
	{
		//		setCurrentRoomID(nextRoom);
	}


	public int getHealth()
	{
		return health;
	}

	public void updateHealth(int num) 
	{
		health += num;
	}
}
