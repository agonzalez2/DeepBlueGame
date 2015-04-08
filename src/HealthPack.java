
/* update log
 * implemented use method to add health to player and remove item from inventory
 */

public class HealthPack extends Item 
{
	private int healAmount;

	public HealthPack(String itemDescription, int itemID)
	{
		super(itemDescription, itemID);
		// TODO Auto-generated constructor stub
	}

	public String use() 
	{
		Game.currentPlayer.updateHealth(healAmount);
		String info = "A health pack has been used. Health has been increased by " + healAmount;
		Game.currentPlayer.removeFromInventory(this);
		info += ", health pack has been removed from inventory.";
		return info;
	}

}
