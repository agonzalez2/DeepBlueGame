
/**Class: Item.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class – An abstract class to be used as the parent for creation of items in the game. 
 * This class contains all information shared among all items such as:
 * a description of the item, and an item ID.
 * This class also determines that each item must implement a use method to represent using an item 
 * 
 * Purpose: – To represent a generic Item in the game
 */
public abstract class Item //CHANGED BACK TO ABSTRACT A.G. 4/8/15
{
	private String itemDescription;
	private int itemID; //(pistolAmmo, stunAmmo, healthPak, scubaPart) = (1, 2, 3, 4)
	
	/**
	 * Basic constructor for all item objects
	 * @param itemDescription String containing item description
	 * @param itemID an int that determines the item ID
	 */
	public Item(String itemDescription, int itemID) 
	{
		this.itemDescription = itemDescription;
		this.itemID = itemID;
	}

	/**
	 * Abstract method that must be implemented by each child class.
	 * This method will be used to simulate using an item.
	 * @return String containing pertinent information as the result of using an item
	 */
	public abstract String use();
	
	/**
	 * Getter method for the description of the item
	 * @return String containing item description
	 */
	public String getDescription()
	{
		return itemDescription;
	}
	
	/**
	 * Getter method for the ID of the item
	 * @return an int that determines item ID
	 */
	public int getID()
	{
		return itemID;
	}
	
}
