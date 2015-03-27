
/**
 * @author Alexander
 *
 */
public class Item 
{
	protected String itemDescription;
	protected int itemID;
	protected String[] possibleInfo;
	
	
	
	public Item(String itemDescription, int itemID, String[] possibleInfo) 
	{
		this.itemDescription = itemDescription;
		this.itemID = itemID;
		this.possibleInfo = possibleInfo;
	}

	public String use()
	{
		return possibleInfo[0];
	}
	
	public String getDescription()
	{
		return itemDescription;
	}
	
	public int getID()
	{
		return itemID;
	}
}
