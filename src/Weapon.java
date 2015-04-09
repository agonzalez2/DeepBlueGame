
public class Weapon extends Item 
{
	private String weaponType;
	private int damageAmount;
	private int ammo;

	public Weapon(String itemDescription, int itemID, String type, int damage)
	{
		super(itemDescription, itemID);
		ammo = 5;
		damageAmount = damage;
		weaponType = type;
	}

	public String use() 
	{
		String info;
		if (ammo > 0)
		{
			info = weaponType + " has been fired.";
			ammo --;
			info += " Remaining ammo: ";
		}
		else
		{
			info = weaponType + "is out of ammo. Reload now!";
		}
		return info;
	}

	public void reload(AmmoPack magazine) 
	{
		ammo += Integer.parseInt(magazine.use());
	}
	
	public int getDamage()
	{
		return (ammo > 0)? damageAmount : 0; 
	}

}
