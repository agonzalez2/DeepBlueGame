/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: 
 */

import java.util.ArrayList;

import javax.activity.InvalidActivityException;

/*Change Log as of 3/30/2015
 * Included no parameter default constructor
 * changed capitalization of health, inventory
 * inventory is now arrayList
 * performAction parameter changed from int to Action
 * temporary item class was created thus rooms.Item is changed to just Item
 * Action class is independent of any package (wat)
 * changed removeFromInventory parameter from int to Item and changed to String
 * changed getInventory return type from item[] to String because of toString of inventory 
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

	private Action[] actionArray = {Action.attack_pistol,
						Action.attack_stun,
						Action.reload_pistol,
						Action.reload_stun,
						Action.move,
						Action.open_inventory,
						Action.use};
	private Action nextAction;

	//paramatrized constructor allows for save/loading non-full health players
	public Player(int health) 
	{
		this.health = health;
		this.inventory = new ArrayList<Item>();
		
	}
	
	//Default constructor of new player (Health = 100)
	public Player() 
	{
		health = 100;
	}

	//Returns player's current action
	public Action getNextAction()
	{
		return nextAction;
	}

	//NOT NEEDED IF GAME.USERINPUT IS ACCESSIBLE
	//Stores user's current command
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
		{
			useItem(getItem(0).getID());
		}
		//actionArray[1] is attack_stun
		if(nextAction.equals(actionArray[1]))
		{
			useItem(getItem(1).getID());
		}
		//actionArray[2] is reload_pistol
		if(nextAction.equals(actionArray[2]))
		{
			useItem(getItem(2).getID());
		} 		//actionArray[3] is reload_stun
		if(nextAction.equals(actionArray[3]))
		{
			useItem(getItem(3).getID());
		}

	
	}
	//NEED SPECIFICATION ON HOW USER INPUT IS PARSED
	//Adds an item to inventory when player obtains an item
	public void addToInventory(Item itemToAdd) 
	{
		inventory.add(itemToAdd);
		if(itemToAdd instanceof AmmoPack)
		{
	
			if(itemToAdd.getDescription().equalsIgnoreCase("pistol ammo"))
			{
				UserInterface.updateInventory(1, 1);
			}
			
			else if (itemToAdd.getDescription().equalsIgnoreCase("stun ammo"))
			{
				UserInterface.updateInventory(2, 1);
			}
		}
		if(itemToAdd instanceof HealthPack)
		{
			UserInterface.updateInventory(3, 1);
		}

		if(itemToAdd instanceof ScubaGear)
		{
			UserInterface.updateInventory(4, 1);
		}

	}

	//Removes an item from inventory by player request or item use
	public String removeFromInventory(Item itemToRemove) 
	{
		inventory.remove(inventory.indexOf(itemToRemove));
		
		if(itemToRemove instanceof AmmoPack)
		{
			if(itemToRemove.getDescription().equalsIgnoreCase("pistol ammo"))
			{
				UserInterface.updateInventory(1, -1);
			}
			
			else if (itemToRemove.getDescription().equalsIgnoreCase("stun ammo"))
			{
				UserInterface.updateInventory(2, -1);
			}
		}
			
		if(itemToRemove instanceof HealthPack)
		{
			UserInterface.updateInventory(3, -1);
		}
	
		if(itemToRemove instanceof ScubaGear)
		{
			UserInterface.updateInventory(4, -1);
		}
			return itemToRemove.toString() + "Has been removed!";
	}

	//Returns a list of items inside of the player's inventory
	public ArrayList getInventory() 
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(Item i : inventory)
		{
			temp.add(i.getDescription());
		}
		return temp;
	}

	//Returns an item the user requests
	public Item getItem(int itemIndex)
	{
		return inventory.get(itemIndex);
	}
	
	public Item getItem(String name) throws InvalidItemException
	{
		for (Item i : inventory)
		{
			if(i.getDescription().equalsIgnoreCase(name))
			{
				return i;
			}
		}
		throw new InvalidItemException();
	}
	
	//Uses an actual item specified by the user
	//Alexander added this, should work but may need more thinking
	public String useItem(int itemPosition)
	{
		return inventory.get(itemPosition).use();
	}
	
	//Currently purely just teleporting
	//Navigation between rooms
	public void moveToNext(int nextRoom) 
	{
		Game.getInstance().setCurrentRoom(nextRoom);
	}
	
	//Returns health of player
	public int getHealth()
	{
		return health;
	}

	//Sets the health to a specific amount (TOTAL HEALTH)
	public void updateHealth(int newHealth) 
	{
		health = newHealth;
		
	}
	
	//This can be modified to incorporate all items
	public void findAndUseHealthPack()
	{
		
		for (Item i : inventory)
		{
			if(i.getDescription().equalsIgnoreCase("Health Pak"))
			{
				i.use();
				inventory.remove(i);
			}
		}
	}
}
class InvalidItemException extends Exception
{
	public InvalidItemException(){}
}
