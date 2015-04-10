
public class ScubaGear extends Item 
{
	private boolean used;

	public ScubaGear(String itemDescription, int itemID)
	{
		super(itemDescription, itemID);
		used = false;
	}

	public String use() 
	{
		String info;
		if (!used)
		{
			info = "You found a Scuba Gear part.";
			info += "\nYou now have " + ++Game.getInstance().scubaPartCount + " Scuba Gear parts";
			used = true;
		}
		else info = "This Scuba Gear part has already been counted/used.";
		return info;
	}

}
