
/**
 * @author Alexander
 *
 */
public abstract class Item
{
	private String itemDescription;
	private int itemID;
	
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
