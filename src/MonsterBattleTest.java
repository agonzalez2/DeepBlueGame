import static org.junit.Assert.*;

import org.junit.Test;


public class MonsterBattleTest 
{
	Action[] typeA = {Action.attack,Action.defend,Action.attack,Action.defend};
	Monster m1 = new Monster(1,"Sea Tortoise", "an angry spiky-shelled tortoise.",10, 1, 0.5, typeA );
	Player p = new Player();
	@Test
	public void testMonsterBattle()
	{
		assertNotNull(new MonsterBattle(p,m1));
	}

	@Test
	public void testStartBattle() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testChangeHealth() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRequestPlayerAction() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMonsterAction() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetResult() 
	{
		fail("Not yet implemented");
	}
}
