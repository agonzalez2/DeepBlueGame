
public class PuzzleMaker
{
	public static void main(String[] args)
	{
		String desc = "The room contains a combination lock, but it is odd, there are no dials to it.";
		Action[] actions = {Action.hit,Action.relax,Action.attack_pistol};
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
		
		Puzzle p1 = new Puzzle(desc, actions, results, new ScubaGear("Snorkle", 0));
		System.out.println(p1.checkSolution(Action.drop));
		System.out.println(p1.checkSolution(Action.drop));
		System.out.println(p1.checkSolution(Action.hit));
	}
}
