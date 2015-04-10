
public class Puzzle
{
	private String puzzleDesc;
	private Action[] solution;
	private int puzzleID;
	private String[][] results;
	private boolean isSolved;
	private int placeInSequence;
	private Item prizeItem;



	public String checkSolution(Action playerAction) 
	{
		String info;
		if (!isSolved)
		{
			if (playerAction == solution[placeInSequence])
			{
				info = getResult(0);
				placeInSequence++;
				if (placeInSequence >= solution.length)
				{
					markSolved();
					info += " Your rewards is a " + getItem().getDescription();
					info += ", it has been added to inventory";
				}
			}
			else
			{
				info = getResult(1);
			}
		}
		else info = "Puzzle is already solved.";
		return info;
	}

	private void markSolved() 
	{
		isSolved = true;
	}

	public String getPuzzleDescription() 
	{
		return puzzleDesc;
	}

	private Item getItem() 
	{

		return null;
	}

	private String getResult(int resultInt) 
	{
		return ;
	}

	public boolean isSolved() 
	{
		return isSolved;
	}

}
