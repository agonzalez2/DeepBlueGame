import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;


public class PlayerTest
{
	@Test
	//Will fail if exceptions are thrown
	public void testPlayerInt()
	{
		new Player((int)Math.random()*100);
	}

	@Test
	//Will fail if exceptions are thrown
	public void testPlayer()
	{
		new Player();
	}

	@Test
	//Will fail if method fails to retrieve player's nextAction
	public void testGetNextAction()
	{
		Player p = new Player();
		p.setNextAction(Action.attack_pistol);
		assertTrue(p.getNextAction().equals(Action.attack_pistol));
	}

	@Test
	//Will fail if player's nextAction is set incorrectly 
	public void testSetNextAction() 
	{
		Player p = new Player();
		p.setNextAction(Action.attack_pistol);
		assertTrue(p.getNextAction().equals(Action.attack_pistol));
	}

	@Test
	//Will always error out
	public void testPerformAction() 
	{
		Player p = new Player();
		p.addToInventory(new Weapon("Pistol", 0, "Pistol", 0));
		p.setNextAction(Action.attack_pistol);
		p.performAction(p.getNextAction());
	}

	@Test
	//Fails if item is not added to inventory
	public void testAddToInventory()
	{
		Player p = new Player();
		ArrayList<Item> correct = new ArrayList<Item>();
		p.addToInventory(new Weapon("Pistol", 0, "Pistol", 0));
		assertEquals(correct, p.getInventory());
	}

	@Test
	//Fails if item is still inside the inventory
	public void testRemoveFromInventory()
	{
		Player p = new Player();
		p.addToInventory(new Weapon("Pistol", 0, "Pistol", 0));
		p.removeFromInventory(p.getItem(0));
		assertTrue(p.getInventory().isEmpty());
	}

	@Test
	//Fails if inventory output is incorrect
	public void testGetInventory()
	{
		Player p = new Player();
		ArrayList<Item> correct = new ArrayList<Item>();
		Weapon tempWeapon = new Weapon("Pistol", 0, "Pistol", 0);
		correct.add(tempWeapon);
		p.addToInventory(tempWeapon);
		assertEquals(correct, p.getInventory());
	}

	@Test
	//Fails if item is not found
	public void testGetItem()
	{
		Player p = new Player();
		Weapon tempWeapon = new Weapon("Pistol", 0, "Pistol", 0);
		p.addToInventory(tempWeapon);
		assertEquals(tempWeapon, p.getItem(0));
	}

	@Test
	//Fails if item is not found
	public void testGetItemString() 
	{
		Player p = new Player();
		Weapon tempWeapon = new Weapon("Pistol", 0, "Pistol", 0);
		p.addToInventory(tempWeapon);
		try
		{
			assertEquals(tempWeapon, p.getItem("pistol"));
		} catch (InvalidItemException e)
		{
			fail();
		}
	}

	@Test
	//Fails if item is not found
	public void testUseItem() 
	{
		Player p = new Player();
		Weapon tempWeapon = new Weapon("Pistol", 0, "Pistol", 0);
		p.addToInventory(tempWeapon);
		assertEquals(tempWeapon.use(), p.useItem(0));
	}

	@Test
	@Ignore
	public void testMoveToNext()
	{
		fail("Not yet implemented");
	}

	@Test
	//Fails if player's health is incorrectly retrieved
	public void testGetHealth()
	{
		int tempHealth = (int)Math.random()*100;
		Player p = new Player(tempHealth);
		assertEquals(tempHealth,p.getHealth());
	}

	@Test
	//Fails if player's health is incorrectly updated
	public void testUpdateHealth() 
	{
		Player p = new Player(50);
		p.updateHealth(75);
		assertEquals(75, p.getHealth());
	}

	@Test
	@Ignore
	public void testFindAndUseHealthPack()
	{
		fail("Not yet implemented");
	}
}
