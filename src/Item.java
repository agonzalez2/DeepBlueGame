
/**
 * @author Alexander
 *
 */
public abstract class Item //CHANGED BACK TO ABSTRACT A.G. 4/8/15
{
	private String itemDescription;
	private int itemID; //(pistolAmmo, stunAmmo, healthPak, scubaPart) = (1, 2, 3, 4)
	
	public Item(String itemDescription, int itemID) 
	{
		this.itemDescription = itemDescription;
		this.itemID = itemID;
	}

	public abstract String use();
	
	public String getDescription()
	{
		return itemDescription;
	}
	
	public int getID()
	{
		return itemID;
	}
	
}
