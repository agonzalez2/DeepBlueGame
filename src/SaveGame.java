import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


public class SaveGame 
{

	public static void writeToFile()
	{
		writeData(new File("room.ser"),Game.roomArray);
		writeData(new File("monster.ser"),Game.monsterArray);
		writeData(new File("puzzle.ser"),Game.puzzleArray);
		writeGame(new File("game.ser"));
	}

	private static void writeData(File libraryFile, Object[] array)
	{
		ObjectOutputStream output = null;
		PrintWriter logOutput = null;
		try
		{
			logOutput = new PrintWriter(new File("log.txt"));
			output = new ObjectOutputStream(new FileOutputStream(libraryFile));
			for(Object item : array)
			{
				output.writeObject(item);
			}
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Specified file not found.");
		}
		catch (Exception e)
		{
			e.printStackTrace(logOutput);
		}
		finally
		{
			try
			{
				output.close();
				logOutput.close();
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace(logOutput);
				logOutput.close();
			}
		}
	}
	
	private static void writeGame(File libraryFile)
	{
		ObjectOutputStream output = null;
		PrintWriter logOutput = null;
		try
		{
			logOutput = new PrintWriter(new File("log.txt"));
			output = new ObjectOutputStream(new FileOutputStream(libraryFile));
			Game game = Game.getInstance();
			output.writeObject(game.currentPlayer);
			output.writeObject(game.scubaPartCount);
			output.writeObject(game.currentRoomID);
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Specified file not found.");
		}
		catch (Exception e)
		{
			e.printStackTrace(logOutput);
		}
		finally
		{
			try
			{
				output.close();
				logOutput.close();
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace(logOutput);
				logOutput.close();
			}
		}
	}
	
}
