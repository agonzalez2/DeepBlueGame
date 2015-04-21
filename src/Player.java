/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: Represents the internal class the user represents and 
 * interacts with the game environment with.
 */

import java.util.ArrayList;

public class Player
{

	private int health;
	
	private ArrayList<Item> inventory;

	private Action nextAction;

	/**
	 * Method: Player(int Health)
	 * Parameterized constructor allows for save/loading non-full health players
	 * @param health : specific amount of health
	 */
	public Player(int health) 
	{
		this.health = health;
		this.inventory = new ArrayList<Item>();
	}
	
	/**
	 * Method: Player()
	 * Creates new default player with default 
	 * health = 100 and empty inventory.
	 */
	public Player() 
	{
		health = 100;
	}

	/**
	 * Method: getNextAction()
	 * @return player's next action
	 */
	public Action getNextAction()
	{
		return nextAction;
	}

	/**
	 * Method: setNextAction(Action nextAction)
	 * Sets player's next action to user's input
	 * @param nextAction
	 */
	//INCOMPLETE: this is suppose to take user's input
	public void setNextAction(Action nextAction)
	{
		this.nextAction = nextAction;
	}
	
	/**
	 * Method: performAction(Action nextAction)
	 * Calls the use() method of items
	 * @param nextAction
	 */
	//INCOMPLETE
	public void performAction(Action nextAction)
	{
		//actionArray[0] is attack_pistol
		if(nextAction == Action.attack_pistol)
		{
			//useItem(getItem(0).getID());
			try {
				getItem("Pistol").use();
			} catch (InvalidItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//actionArray[1] is attack_stun
		if(nextAction == Action.attack_stun)
		{
			//useItem(getItem(1).getID());
			try {
				getItem("Stun Gun").use();
			} catch (InvalidItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//actionArray[2] is reload_pistol
		if(nextAction == Action.reload_pistol)
		{
			useItem(getItem(2).getID());
		} 
		//actionArray[3] is reload_stun
		if(nextAction == Action.reload_stun)
		{
			useItem(getItem(3).getID());
		}	
	} 
	
	/**
	 * Method: addToInventory(Item itemToAdd)
	 * Adds a specific item into the player's inventory
	 * @param itemToAdd
	 */
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

	/**
	 * Method: removeFromInventory(Item itemToRemove)
	 * Removes a specific item from the player's inventory 
	 * @param itemToRemove
	 * @return the name of what the item removed was
	 */
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

	/**
	 * Method: getInventory()
	 * outputs a list of objects inside the player's inventory
	 * @return a list of items inside of the player's inventory
	 */
	public ArrayList<String> getInventory() 
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(Item i : inventory)
		{
			temp.add(i.getDescription());
		}
		return temp;
	}

	/**
	 * Method: getItem(int itemIndex)
	 * outputs a specific item in the player's inventory
	 * @param itemIndex Array index of a specific item
	 * @return an item the user requests
	 */
	public Item getItem(int itemIndex)
	{
		return inventory.get(itemIndex);
	}
	
	/**
	 * Method: getItem(String name)
	 * outputs a specific item in the player's inventory
	 * @param name
	 * @return the item requested by the player
	 * @throws InvalidItemException if input is a known item
	 */
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
	
	/**
	 * Method: useItem(int itemPosition)
	 * calls the use() method of a specific item in the player's inventory.
	 * @param itemPosition item index in the player's inventory
	 * @return use() output of an item
	 */
	public String useItem(int itemPosition)
	{
		return inventory.get(itemPosition).use();
	}
	
	/**
	 * Method: moveToNext(int nextRoom)
	 * set the current room number. Serves to nagivate between
	 * different rooms.
	 * @param nextRoom new room numbers
	 */
	public void moveToNext(int nextRoom) 
	{
		Game.getInstance().setCurrentRoom(nextRoom);
	}
	
	/**
	 * Method: getHealth()
	 * @return current health of the player
	 */
	public int getHealth()
	{
		return health;
	}

	/**
	 * Method: updateHealth(int newHealth)
	 * Sets the player's health to a specific amount
	 * @param newHealth
	 */
	public void updateHealth(int newHealth) 
	{
		health = newHealth;
		
		if(health >= 100)
		{
			UserInterface.setHealthPic(10);
		}
		
		else
		{
			UserInterface.setHealthPic(getFirstDigit(newHealth));
		}
		
	}
	
	public static int getFirstDigit(int i) 
	{
		if (Math.abs((long)i) >= 10 ) 
		{
		    i = i / 10;
		    while (Math.abs(i) >= 10 ) 
		    {
		        i = i / 10;
		    }
		}
		return Math.abs(i);
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
