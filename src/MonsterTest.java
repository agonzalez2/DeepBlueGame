import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class MonsterTest
{
	Action[] typeA = {Action.attack,Action.defend,Action.attack,Action.defend};
	Monster m1 = new Monster(1,"Sea Tortoise", "an angry spiky-shelled tortoise.",10, 1, 0.5, typeA );
	@Test
	//Fails if monster is not initialized
	public void testMonsterIntStringStringIntIntDoubleActionArray() 
	{
		Action[] typeA = {Action.attack,Action.defend,Action.attack,Action.defend};
		Monster m1 = new Monster(1,"Sea Tortoise", "an angry spiky-shelled tortoise.",10, 1, 0.5, typeA );
		assertNotNull(m1);
	}

	@Test
	//Fails if getter retrieve incorrect information
	public void testGetMonsterID() 
	{
		assertEquals(1,m1.getMonsterID());
	}

	@Test
	//Fails if getter retrieve incorrect information
	public void testGetName()
	{
		assertEquals("Sea Tortoise",m1.getName());
	}

	@Test
	//Fails if getter retrieve incorrect information
	public void testGetDesc() 
	{
		assertEquals("an angry spiky-shelled tortoise.",m1.getDesc());
	}

	@Test
	//Fails if getter retrieve incorrect information
	public void testGetHealth() 
	{
		assertEquals(10,m1.getHealth());
	}

	@Test
	//Fails if setter updates incorrect information
	public void testUpdateHealth() 
	{
		m1.updateHealth(100);
		assertEquals(100,m1.getHealth());
	}

	@Test
	//Fails if getter retrieves incorrect information
	public void testGetNextAction()
	{
		assertTrue(m1.getNextAction().equals(Action.attack));
	}

	@Test
	@Ignore
	public void testPerformAction() 
	{
		fail("Not yet implemented");
	}

	@Test
	//Fails if getter retrieves incorrect information
	public void testGetDamage() 
	{
		assertEquals(1,m1.getDamage());
	}

	@Test
	//Fails if getter retrieves incorrect information
	public void testGetDefense() 
	{
		assertEquals(0.5,m1.getDefense());
	}

	@Test
	//Fails if retrieves incorrect information
	public void testToggleIsDefeated() 
	{
		assertTrue(m1.toggleIsDefeated());
	}

}
