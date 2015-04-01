package Battle;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleTester
{
	public static  void main(String args[])
	{
		
		Monster[] monsterList = new Monster[15];
		Player p = new Player();
		Monster m1 = new Monster(1,"Sea Turtle", "Angry spiky-shelled monster", 100);		
		Monster m2 = new Monster(2,"Man-Shark", "", 100);		
		Monster m3 = new Monster(3,"Jaws", "", 100);		
		Monster m4 = new Monster(4,"Zoidberg", "", 100);		
		Monster m5 = new Monster(5,"Giant Jellyfish", "", 100);		
		Monster m6 = new Monster(6,"Sea Serpent", "", 100);		
		Monster m7 = new Monster(7,"Spider-Crab", "", 100);		
		Monster m8 = new Monster(8,"Mermaid", "", 100);		
		Monster m9 = new Monster(9,"Siren", "", 100);		
		Monster m10 = new Monster(10,"Hydra", "", 100);		
		Monster m11 = new Monster(11,"Medusa", "", 100);		
		Monster m12 = new Monster(12,"Giant Squid", "", 100);		
		Monster m13 = new Monster(13,"Sea Bear", "", 100);		
		Monster m14 = new Monster(14,"Kraken", "", 100);		
		Monster m15 = new Monster(15,"Cthulhu", "", 100);		
				
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

		MonsterBattle b = new MonsterBattle(p,m1);
		
		
	}

}
