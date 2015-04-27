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
		monsterList[0] = new Monster(0,"Sea Tortoise", "an angry spiky-shelled tortoise.", 50, 5, 0.9, typeA );		
		monsterList[1] = new Monster(1,"Man-Shark", "a chimera with a human body and a shark head.", 55, 10, 0.3, typeB );		
		monsterList[2] = new Monster(2,"Jaws", "the famous 25-foot shark with an appalling appetite for human flesh.", 55, 10, 0.1, typeB );		
		monsterList[3] = new Monster(3,"Zoidberg", "a lobster who is a poor excuse for a human doctor.", 60, 5, 0, typeA );		
		monsterList[4] = new Monster(4,"Giant Jellyfish", "the largest kind of cnidarian in the world with hundreds of tentacles.", 50, 10, 0.5, typeA );		
		monsterList[5] = new Monster(5,"Sea Serpent", "an amphibious dragon with vicious fangs.", 60, 10, 0.6, typeA );
		monsterList[6] = new Monster(6,"Spider-Crab", "staring at you intently with its eight eyes.", 60, 10, 0.7, typeC );
		monsterList[7] = new Monster(7,"Mermaid", "a fabled creature with a torso of a human and a tail of a fish.",50, 5, 0.2, typeA );
		monsterList[8] = new Monster(8,"Siren", "a seducing winged creature with a scream that could be heard from miles away.", 50, 10, 0.5, typeA );	
		monsterList[9] = new Monster(9,"Hydra", "a multi-headed sea snake with regenerative abilties.", 55, 5, 1, typeA );
		monsterList[10] = new Monster(10,"Medusa", "a famed sea serpent with powers to freeze you for a mere glance at her eyes.", 70, 10, 0.2, typeA );
		monsterList[11] = new Monster(11,"Giant Squid", "a squid with tentacles amassing up to 44 feet.", 50, 5, 0.3, typeB );
		monsterList[12] = new Monster(12,"Sea Bear", "an enormous fish with a bear head.", 65, 10, 0.5, typeA );	
		monsterList[13] = new Monster(13,"Kraken", "the mysterious, merciless giant squid hungry for human.", 80, 15, 0.9, typeA );
		monsterList[14] = new Monster(14,"Cthulhu", "the renowned sea god bearing the ability to control all sea creatures.", 100, 15, 1, typeC );	
				
		p.addToInventory(new Weapon("Pistol", 0, "Pistol", 0));
		p.addToInventory(new Weapon("Stun gun", 0, "Pistol", 0));
		p.addToInventory(new Weapon("Apples", 0, "stun", 0));
		p.addToInventory(new AmmoPack("Pistol Ammo","Pistol",0,10));
		
		System.out.println(p.getInventory());
			//System.out.println(p.getItem("Stun gun").use());
			System.out.println(p.getStun());
			System.out.println(p.getPistol());
			System.out.println(Double.valueOf("50")/100);
		/*try {
			System.out.println(p.getItem("pistol").getDescription());
		} catch (InvalidItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//if(i.getDescription().equalsIgnoreCase(".*"+name+".*"))
	}
}
