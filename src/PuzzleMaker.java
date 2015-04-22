import java.util.Random;


public class PuzzleMaker
{
	public static void main(String[] args)
	{
		String desc = "The room contains a combination lock, but it is odd, there are no dials to it.";
		Action[] actions = {Action.hit,Action.relax,Action.attack_pistol};
		Action[] allActions = {Action.attack,Action.attack_pistol,Action.attack_stun,
				Action.defend,Action.drop,Action.eat,Action.hit,Action.jump,Action.move,
				Action.open_inventory,Action.relax,Action.reload_pistol,Action.reload_stun,
				Action.sit,Action.toss,Action.use,Action.yell};
		String r1 = "You've hit the lock, but it won't buldge. Your temper is going up.";
		String r2 = "Now that you relax, you get an idea to force the lock open...";
		String r3 = "That worked! The lock opens.";
		String r4 = "That doesn't work, try using brute force";
		String r5 = "Your not thinking clearly";
		String r6 = "Try breaking the lock";
		String[][] results = new String[2][3];
		results[0][0] = r1;
		results[0][1] = r2;
		results[0][2] = r3;
		results[1][0] = r4;
		results[1][1] = r5;
		results[1][2] = r6;
		
		Random r = new Random();
		
		Puzzle p1 = new Puzzle(desc, actions, results, new ScubaGear("Snorkle", 0));
		/*
		System.out.println(p1.checkSolution(Action.drop));
		System.out.println(p1.checkSolution(Action.drop));
		System.out.println(p1.checkSolution(Action.hit));
		System.out.println(p1.checkSolution(Action.relax));
		System.out.println(p1.checkSolution(Action.attack_pistol));
		*/
		for(int i = 0; i<=30;i++){
			int rt = r.nextInt(16);
			System.out.println(p1.checkSolution(allActions[rt]));
			System.out.println(allActions[rt]);
			for(Action a : p1.getPossibleActions())
				System.out.println("	"+a);
		}
		System.out.println(p1.getPuzzleDescription());
		System.out.println(p1.isSolved());
		
		//for(Action a : p1.getPossibleActions())
			//System.out.println(a);

	}
}
