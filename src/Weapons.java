
public class Weapons extends Item 
{
	private String WeaponType;
	private int DamageAmount;
	private int ammo;

	public Weapons(String itemDescription, int itemID, String[] possibleInfo)
	{
		super(itemDescription, itemID, possibleInfo);
		// TODO Auto-generated constructor stub
	}
	
	public String use() 
	{
		return null;
	}

	public void reload() 
	{

	}

}
