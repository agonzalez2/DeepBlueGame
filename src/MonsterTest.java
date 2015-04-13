import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class MonsterTest {
	Action[] typeA = {Action.attack,Action.defend,Action.attack,Action.defend};
	Monster m1 = new Monster(1,"Sea Tortoise", "an angry spiky-shelled tortoise.",10, 1, 0.5, typeA );
	@Test
	public void testMonsterIntStringStringIntIntDoubleActionArray() {
		Action[] typeA = {Action.attack,Action.defend,Action.attack,Action.defend};
		Monster m1 = new Monster(1,"Sea Tortoise", "an angry spiky-shelled tortoise.",10, 1, 0.5, typeA );
	}

	@Test
	public void testGetMonsterID() {
		assertEquals(1,m1.getMonsterID());
	}

	@Test
	public void testGetName() {
		assertEquals("Sea Tortoise",m1.getName());
	}

	@Test
	public void testGetDesc() {
		assertEquals("an angry spiky-shelled tortoise.",m1.getDesc());
	}

	@Test
	public void testGetHealth() {
		assertEquals(10,m1.getHealth());
	}

	@Test
	public void testUpdateHealth() {
		m1.updateHealth(100);
		assertEquals(100,m1.getHealth());
	}

	@Test
	public void testGetNextAction() {
		assertTrue(m1.getNextAction().equals(Action.attack));
	}

	@Test
	@Ignore
	public void testPerformAction() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDamage() {
		assertEquals(1,m1.getDamage());
	}

	@Test
	public void testGetDefense() {
		assertEquals(0.5,m1.getDefense());
	}

	@Test
	public void testToggleIsDefeated() {
		assertTrue(m1.toggleIsDefeated());
	}

}
