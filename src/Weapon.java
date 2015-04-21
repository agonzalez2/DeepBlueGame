
/**Class: Weapon.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class – A subclass of Item for the creation of weapon objects. 
 * This class overrides the use method of Item to handle certain criteria pertaining to using a weapon. 
 * <br>This class contains extra information such as weapon type, ammo amount, 
 * and the amount of damage it may inflict. 
 * 
 * Purpose: – To represent a weapon used by the player in a battle against a monster
 */
public class Weapon extends Item 
{
	private String weaponType;
	private int damageAmount;
	private int ammo;

	/**
	 * The constructor for Weapon object. 
	 * The constructor expects the following parameters: 
	 * all necessary info for creating a generic Item object (see Item documentation), 
	 * the type of weapon, and the damage the weapon may inflict. 
	 * @param itemDescription String containing item description
	 * @param itemID an int to determine item ID
	 * @param type String containing the type of weapon
	 * @param damage an int containing the amount of damage the weapon may inflict
	 */
	public Weapon(String itemDescription, int itemID, String type, int damage)
	{
		super(itemDescription, itemID);
		ammo = 5;
		damageAmount = damage;
		weaponType = type;
	}

	/**
	 * A method that implements the use method of Item. 
	 * This method is public and can be called by anyone attempting to use the weapon. 
	 * <br>This method works in the same manner the use method of an object does, 
	 * but it checks the ammo loaded to the weapon before the weapon can be used. 
	 * If no more ammo is loaded in weapon, the weapon can’t be used until it is reloaded. 
	 * If the weapon can be used, then the amount of ammo will be decreased by one
	 */
	public String use() 
	{
		String info;
		if (ammo > 0)
		{
			info = weaponType + " has been fired.";
			ammo--;
			info += " Remaining ammo: " + ammo;
			if(weaponType.equals("Pistol"))
			{
				System.out.println("USE WEAPON: Pistol");
				UserInterface.updateInventory(1, -1);
			}
			
			if(weaponType.equals("Stun"))
			{
				System.out.println("USE WEAPON: Stun Gun");
				UserInterface.updateInventory(2, -1);
			}
		
		}
		else
		{
			info = weaponType + "is out of ammo. Reload now!";
		}
		return info;
	}

	/**
	 * A method that will increase the ammo count of weapon by using the AmmoPack. 
	 * This method is public and should be called as needed to reload the weapon.
	 * @param magazine AmmoPack to be used to reload this weapon
	 */
	public void reload(AmmoPack magazine) 
	{
		ammo += Integer.parseInt(magazine.use());
	}

	/**
	 * A method that will get the damage amount this weapon can create.
	 * This method is public and should be called by the MonsterBattle class to determine the damage
	 * to be inflicted on monster BEFORE CALLING THE USE METHOD OF WEAPON.
	 * <br>This method will check if the weapon has ammo, if out of ammo zero is returned for damage amount
	 * @return int containing damge amount of weapon, zero if out of ammo
	 */
	public int getDamage()
	{
		return (ammo > 0)? damageAmount : 0; 
	}

}
