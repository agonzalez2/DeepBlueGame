/**Class: Puzzle.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 4, 2015 
 * 
 * 
 * This class – Business class of a Puzzle. 
 * 
 * Purpose: – To represent a Puzzle to be implemented in a text based game
 */

public class Puzzle
{
	private String puzzleDesc;
	private Action[] solution;
	private int puzzleID;
	private String[][] results;
	private boolean isSolved;
	private int placeInSequence;
	private Item prizeItem;

	/**
	 * A method to check whether the action taken by the player is part of the solution 
	 * to the puzzle. This method is public, and should be called by the game interface 
	 * after a player performs an action to solve the puzzle. 
	 * @param playerAction
	 * @return a string that should be displayed to the user to let him 
	 * know what result the action taken yielded.
	 */
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
		Game.getInstance().currentPlayer.addToInventory(prizeItem);
		return prizeItem;
	}

	private String getResult(int resultInt) 
	{
		return results[resultInt][placeInSequence];
	}

	public boolean isSolved() 
	{
		return isSolved;
	}

}
