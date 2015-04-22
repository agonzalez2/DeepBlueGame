
/**Class: ScubaGear.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class – A subclass of Item for the creation of ScubaGear objects. 
 * This class overrides the use method of Item to handle certain criteria pertaining to using ScubaGear. 
 * 
 * Purpose: – To represent a ScubaGear part that the user must collect to win the game
 */
public class ScubaGear extends Item 
{
	private static final long serialVersionUID = 1L;
	private boolean used;

	/**
	 * The constructor for ScubaGear object. 
	 * <br>The constructor expects the following parameters: 
	 * all necessary info for creating a generic Item object (see Item documentation)
	 * @param itemDescription String containing item description
	 * @param itemID int that determines item id
	 */
	public ScubaGear(String itemDescription, int itemID)
	{
		super(itemDescription, itemID);
		used = false;
	}

	/**
	 * A method that implements the use method of Item. 
	 * This method is public and can be called by anyone attempting to use the ScubaGear. 
	 * <br>This method works in the same manner the use method of an object does, 
	 * but it checks if the user has already used this part, if not then
	 * it will update the scuba parts count of Game and return the proper message
	 */
	public String use() 
	{
		String info;
		if (!used)
		{
			Game.scubaPartCount = Game.scubaPartCount + 1;
			info = "You found a Scuba Gear part.";
			info += "\nYou now have " + Game.scubaPartCount + " Scuba Gear parts";
			this.used = true;
			
		}
		else info = "This Scuba Gear part has already been counted/used.";
		return info;
	}

}
