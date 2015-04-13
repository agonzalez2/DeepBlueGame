
/**Class: ItemTester.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 12, 2015 
 * 
 * 
 * This class – Test of the Item class, along with the implementation of the abstract use() method 
 * 
 * Purpose: – To test all methods of the Item class
 */
public class ItemTester
{

	public static void main(String[] args)
	{
		//create items
		Weapon weapon = new Weapon("Test weapon", 2, "Stun", 10); //By default, a new weapon has 5 ammo
		Item ammo = new AmmoPack("Test ammo", "Stun ammo", 1, 10);
		Item scubaPart = new ScubaGear("Snorkle mask", 0);
		Item health = new HealthPack("Test health pack", 3, 10);

		//create player with 50 health
		Player testPlayer = new Player(50);

		//add items to inventory
		testPlayer.addToInventory(weapon);
		testPlayer.addToInventory(ammo);
		testPlayer.addToInventory(scubaPart);

		//create Game instance and add player to game
		Game.getInstance().currentPlayer = testPlayer;

		//first test, test weapon use method
		System.out.println("Test weapon damage, and test use method");
		System.out.println("Expected: info stating weapon is used, ammo decreases\n, damage remain constant");
		for (int i = 5; i > 0; i--)
		{
			System.out.println("Weapon damage: " + weapon.getDamage());
			System.out.println(weapon.use());
		}


		System.out.println("\nTest use method on empty weapon, test weapon damage on empty weapon");
		System.out.println("Expected: info stating weapon is empty, damage of 0\n");
		System.out.println("Weapon damage: " + weapon.getDamage());
		System.out.println(weapon.use());

		//second test, load ammo to weapon, damage of loaded weapon
		System.out.println("\nTest weapon reload method, Test ammo use method, test damage of loaded weapon");
		System.out.println("Expected: weapon ammo increase allowing weapon to fire, "
				+ "ammo taken out fromm player inventory" + ", weapon damage greater than 0");

		System.out.println("\nPlayer inventory before reload");
		System.out.println(testPlayer.getInventory());

		weapon.reload((AmmoPack)ammo);

		System.out.println("\nPlayer inventory after reload");
		System.out.println(testPlayer.getInventory());

		System.out.println("Weapon damage after reload: " + weapon.getDamage());
		System.out.println(weapon.use());

		//third test
		System.out.println("\nTest use method of scuba gear");
		System.out.println("Expected: info stating part used, item addedto inventory");

		System.out.println("\nPlayer inventory before scuba use");
		System.out.println(testPlayer.getInventory());

		System.out.println(scubaPart.use());

		System.out.println("\nPlayer inventory after scuba use");
		System.out.println(testPlayer.getInventory());

		//fourth test
		System.out.println("\nTest use method of scuba gear");
		System.out.println("Expected: info stating part already used, item not added inventory");

		System.out.println("\nPlayer inventory before scuba use");
		System.out.println(testPlayer.getInventory());

		System.out.println(scubaPart.use());

		System.out.println("\nPlayer inventory after scuba use");
		System.out.println(testPlayer.getInventory());
		
		//fifth test

	}

}
