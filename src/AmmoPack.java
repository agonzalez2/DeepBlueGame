/**Class: AmmoPack.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class – A subclass of Item for the creation of AmmoPack objects. 
 * This class overrides the use method of Item to handle certain criteria pertaining 
 * to using an ammo pack. <br>This class contains extra information such as the amount 
 * of ammo contained by the pack. 
 * 
 * Purpose: – To represent a pack of ammo used to reload a weapon
 */

public class AmmoPack extends Item 
{
	private static final long serialVersionUID = 1L;
	private String ammoType;
	private int ammoAmmount;
	
	/**
	 * The constructor for AmmoPack object. 
	 * The constructor expects the following parameters: 
	 * all necessary info for creating a generic Item object (see Item documentation), 
	 * and the amount of ammo the pack may restore.
	 * @param itemDescription String containing item description
	 * @param type String containing type of weapon the ammo pack will reload
	 * @param itemID int determining id of ammo pack
	 * @param ammo an int containing the amount of ammo the pack may restore
	 */
	public AmmoPack(String itemDescription, String type, int itemID, int ammo)
	{
		super(itemDescription, itemID);
		ammoAmmount = ammo;
		ammoType = type;
	}

	/**
	 * A method that implements the use method of Item. 
	 * <br>This method is public and can be called by anyone attempting to use the ammo pack. 
	 * This method works in the same manner the use method of an object does, 
	 * but it uses the amount of ammo to add ammo to the weapon using the ammo pack.(see Weapon.reload(ammoPack)
	 */
	public String use() 
	{
		//remove this item from player's inventory to simulate being used
		Game.getInstance().currentPlayer.removeFromInventory(this);
		
		/**
		
		if(ammoType.equals("Pistol"))
		{
			//UserInterface.updateInventory(1, -1); handled in weapon use for now
			Game.getInstance().currentPlayer.getPistol().reload(this);
		}
		
		if(ammoType.equals("Stun"))
		{
			//UserInterface.updateInventory(1, -1);
			Game.getInstance().currentPlayer.getStun().reload(this);
		}
		**/
		
		
		return "" + ammoAmmount;
	}
	
	public String getType()
	{
		return ammoType;
	}

}
