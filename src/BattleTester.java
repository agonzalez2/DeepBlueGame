import java.util.ArrayList;

/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: 
 */

public class BattleTester
{
	public static  void main(String args[])
	{
		
		Monster[] monsterList = new Monster[16];
		Player p = new Player(50);
		Action[] typeA = {Action.attack,Action.defend,Action.attack,Action.defend};
		Action[] typeB = {Action.defend,Action.attack,Action.defend,Action.attack};
		Action[] typeC = {Action.attack,Action.attack,Action.attack,Action.attack};

		//return mTemp.getName() + " is " + mTemp.getDesc()
		Monster m1 = new Monster(1,"Sea Tortoise", "an angry spiky-shelled tortoise.", 50, 5, 0.9, typeA );		
		Monster m2 = new Monster(2,"Man-Shark", "a chimera with a human body and a shark head.", 55, 10, 0.3, typeB );		
		Monster m3 = new Monster(3,"Jaws", "the famous 25-foot shark with an appalling appetite for human flesh.", 55, 10, 0.1, typeB );		
		Monster m4 = new Monster(4,"Zoidberg", "a lobster who is a poor excuse for a human doctor.", 60, 5, 0, typeA );		
		Monster m5 = new Monster(5,"Giant Jellyfish", "the largest kind of cnidarian in the world with hundreds of tentacles.", 50, 10, 0.5, typeA );		
		Monster m6 = new Monster(6,"Sea Serpent", "an amphibious dragon with vicious fangs.", 60, 10, 0.6, typeA );
		Monster m7 = new Monster(7,"Spider-Crab", "staring at you intently with its eight eyes.", 60, 10, 0.7, typeC );
		Monster m8 = new Monster(8,"Mermaid", "a fabled creature with a torso of a human and a tail of a fish.",50, 5, 0.2, typeA );
		Monster m9 = new Monster(9,"Siren", "a seducing winged creature with a scream that could be heard from miles away.", 50, 10, 0.5, typeA );	
		Monster m10 = new Monster(10,"Hydra", "a multi-headed sea snake with regenerative abilties.", 55, 5, 1, typeA );
		Monster m11 = new Monster(11,"Medusa", "a famed sea serpent with powers to freeze you for a mere glance at her eyes.", 70, 10, 0.2, typeA );
		Monster m12 = new Monster(12,"Giant Squid", "a squid with tentacles amassing up to 44 feet.", 50, 5, 0.3, typeB );
		Monster m13 = new Monster(13,"Sea Bear", "an enormous fish with a bear head.", 65, 10, 0.5, typeA );	
		Monster m14 = new Monster(14,"Kraken", "the mysterious, merciless giant squid hungry for human.", 80, 15, 0.9, typeA );
		Monster m15 = new Monster(15,"Cthulhu", "the renowned sea god bearing the ability to control all sea creatures.", 100, 15, 1, typeC );	
				
		monsterList[1] = m1;
		monsterList[2] = m2;
		monsterList[3] = m3;
		monsterList[4] = m4;
		monsterList[5] = m5;
		monsterList[6] = m6;
		monsterList[7] = m7;
		monsterList[8] = m8;
		monsterList[9] = m9;
		monsterList[10] = m10;
		monsterList[11] = m11;
		monsterList[12] = m12;
		monsterList[13] = m13;
		monsterList[14] = m14;
		monsterList[15] = m15;
				
		p.addToInventory(new Weapon("Pistol", 0, "Pistol", 0));
		p.addToInventory(new Weapon("Stungun", 0, "Pistol", 0));
		p.addToInventory(new Weapon("Apples", 0, "Pistol", 0));
		p.addToInventory(new AmmoPack("Pistol Ammo","Pistol",0,10));
		
		System.out.println(p.getInventory());
		/*try {
			System.out.println(p.getItem("pistol").getDescription());
		} catch (InvalidItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//if(i.getDescription().equalsIgnoreCase(".*"+name+".*"))
	}
}
