
/**Class: Shield.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class – A subclass of Item for the creation of Shield objects. 
 * This class overrides the use method of Item to handle certain criteria pertaining to using a shield. 
 * ,br>This class contains extra information such as shield type, 
 * and the amount of damage it may resist/defend. 
 * 
 * Purpose: – To represent a shield used by the player to resist damage in a battle against a monster
 */
public class Shield extends Item
{
	private String shieldType;
	private int defendAmount;
	
	/**
	 * The constructor for a Shield object. 
	 * <br>The constructor expects the following parameters: 
	 * all necessary info for creating a generic Item object (see Item documentation), 
	 * the type of Shield, and the amount of damage the shield may deflect. 
	 * @param itemDescription String containing item description
	 * @param itemID int that determines item ID
	 * @param type String containing the type of Shield
	 * @param strength an integer containing the amount of damage the shield may deflect
	 */
	public Shield(String itemDescription, int itemID, String type, int strength)
	{
		super(itemDescription, itemID);
		shieldType = type;
		defendAmount = strength;
	}

	/**
	 * A method that implements the use method of Item. 
	 * This method is public and can be called by anyone attempting to use shield. 
	 * <br>This method works in the same manner the use method of an object does, 
	 * but it uses the amount of defense to deflect that amount of damage.
	 */
	public String use() 
	{
		return null;
	}

}
