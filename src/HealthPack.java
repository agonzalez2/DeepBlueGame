
/* update log
 * implemented use method to add health to player and remove item from inventory
 */

/**Class: HealthPack.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class – A subclass of Item for the creation of HealthPack objects. 
 * This class overrides the use method of Item to handle certain criteria pertaining to using 
 * a health pack. <br>This class contains extra information such as the amount of health given by the pack. 
 * 
 * Purpose: – To represent a health pack that restores health to the player
 */
public class HealthPack extends Item 
{
	private static final long serialVersionUID = 1L;
	private int healAmount;

	/**
	 * The constructor for HealthPack object. 
	 * <br>The constructor expects the following parameters: 
	 * all necessary info for creating a generic Item object (see Item documentation), 
	 * and the amount of health the pack may restore.
	 * @param itemDescription String containing item description
	 * @param itemID an int determining id of ammo pack
	 * @param health an int containing the amount of health the pack may restore
	 */
	public HealthPack(String itemDescription, int itemID, int health)
	{
		super(itemDescription, itemID);
		healAmount = health;
	}

	/**
	 * A method that implements the use method of Item. 
	 * This method is public and can be called by anyone attempting to use the health pack. 
	 * ,br>This method works in the same manner the use method of an object does, 
	 * but it uses the amount of health to add health to the actor using the health pack.
	 */
	public String use() 
	{
		Game.getInstance().currentPlayer.updateHealth(healAmount);
		String info = "A health pack has been used. Health has been increased by " + healAmount;
		//remove pack from inventory to simulate being used
		Game.getInstance().currentPlayer.removeFromInventory(this);
		info += ", health pack has been removed from inventory.";
		return info;
	}
	
	public int getHealAmount()
	{
		return healAmount;
	}

}
