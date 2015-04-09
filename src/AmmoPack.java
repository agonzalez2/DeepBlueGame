

public class AmmoPack extends Item 
{
	private String ammoType;
	private int ammoAmmount;
	
	public AmmoPack(String itemDescription, int itemID, int ammo)
	{
		super(itemDescription, itemID);
		ammoAmmount = ammo;
	}

	public String use() 
	{
		Game.getInstance().currentPlayer.removeFromInventory(this);
		return "" + ammoAmmount;
	}

}
