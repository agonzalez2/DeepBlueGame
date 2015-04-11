/**Class: Puzzle.java 
 * @author Alexander Gonzalez 
 * @version 1.0 <p> 
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015 
 * 
 * 
 * This class � A business class for the creation of puzzle objects. 
 * <br>Puzzle will contain pertinent information for the description of each puzzle, 
 * such as a String for the puzzle�s description, an array of actions to serve as the solution, 
 * an array of strings for possible results, a boolean of whether the puzzle has been solved, 
 * an item given as a prize, and an integer for the puzzle id. 
 * 
 * Purpose: � To represent a Puzzle to be implemented in a text based game
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
		//check if puzzle is already solved
		if (!isSolved)
		{
			if (playerAction == solution[placeInSequence])
			{
				//get positive result when player correctly performs next action of puzzle
				info = getResult(0);
				placeInSequence++;
				//check if player has reached the end of the action sequence
				if (placeInSequence >= solution.length)
				{
					markSolved();
					info += " Your rewards is a " + getPrizeItem().getDescription();
					info += ", it has been added to inventory.";
				}
			}
			else
			{
				//get negative result when player incorrectly performs an action
				info = getResult(1);
			}
		}
		else info = "Puzzle is already solved.";
		return info;
	}

	/**
	 * A method to change the isSolved boolean of the puzzle to true when the puzzle has been solved. 
	 * This method is private, and will be called by the checkSolution method when the player has 
	 * arrived at a solution to the puzzle. <br>A puzzle is solved when the player has completed a series 
	 * of actions in a specific order to obtain a solution to the problem given by the puzzle. 
	 * This method assumes all conditions have been checked prior to its call.
	 */
	private void markSolved() 
	{
		isSolved = true;
	}

	/**
	 * A method to get the description of the puzzle. 
	 * This method is public and should be called by the game interface to display the problem 
	 * of the puzzle to the user at the start of entering a Puzzle state. 
	 * <br>The description of the puzzle will contain the problem that the user has to solve. 
	 * @return a string containing the description of Puzzle that should be displayed to the user
	 */
	public String getPuzzleDescription() 
	{
		return puzzleDesc;
	}

	/**
	 * A method to obtain the item given as a prize for solving the puzzle. 
	 * This method is private and is called by the checkSolution method to obtain the prizeItem 
	 * after the puzzle has been solved. The item is also added toplayer's inventory.
	 * <br>This method will check if the puzzle has been solved, 
	 * and will only return the prizeItem if the result is true.
	 * @return the prize item for solving the puzzle, null if the puzzle has not been solved
	 */
	private Item getPrizeItem() 
	{
		//check if puzzle is solved
		if (isSolved)
		{
			Game.getInstance().currentPlayer.addToInventory(prizeItem);
			return prizeItem;
		}
		else return null;
	}

	/**
	 * A method to obtain a string containing a result to the player�s action. 
	 * This method is private and will be called by the checkSolution method 
	 * to obtain a string to be displayed to the user. 
	 * <br>This method assumes all necessary checks were made prior to its call.
	 * @param resultInt integer to determine if result is positive or negative
	 * @return a string containing the outcome of the user�s action
	 */
	private String getResult(int resultInt) 
	{
		return results[resultInt][placeInSequence];
	}

	/**
	 * A method to check if this puzzle has been solved. 
	 * This method is public and should be called by the game interface 
	 * after calling the checkSolution method. 
	 * @return a boolean: true if the puzzle has been solved, or false otherwise. 
	 */
	public boolean isSolved() 
	{
		return isSolved;
	}

}
