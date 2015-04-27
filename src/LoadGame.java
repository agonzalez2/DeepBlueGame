import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;


public class LoadGame 
{
	
	private static Room[] tempRoomArray = new Room[29];
	private static Puzzle[] tempPuzzleArray = new Puzzle[9];
	private static Monster[] tempMonsterArray = new Monster[9];
	public static void load()
	{
		loadRooms(new File("room.ser"));
		loadMonsters(new File("monster.ser"));
		loadPuzzles(new File("puzzle.ser"));
		loadGameInstance(new File("game.ser"));
		UserInterface.resetInterface();
		UserInterface.gameButtonsOn(true);
	}
	
	
	public static void loadGameInstance(File inputFile)
	{
		ObjectInputStream input = null;
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(new File("log.txt"));
			input = new ObjectInputStream(new FileInputStream(inputFile));
			Game game = new Game(tempRoomArray, tempMonsterArray, tempPuzzleArray);//Game.getInstance()
			Game.setInstance(game);
			System.out.println("73");
			game.currentPlayer = (Player)input.readObject();
			Game.scubaPartCount = input.readInt();
			game.currentRoomID = input.readInt();
			
			game.run();
			
			System.out.println(game.currentPlayer.getInventory());
			System.out.println(game.currentPlayer.getInventory().size());
			
			System.out.println("Loaded Current Room ID: " + game.currentRoomID);
		}
		catch (EOFException eofe)
		{
		
			System.out.println("Game imported");
			System.out.println("Room ID : " + Game.getInstance().currentRoomID);
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Specified file not found.");
			fnfe.printStackTrace(output);
		}
		catch(Exception e)
		{
			System.out.println("Error occured while reading file: " + inputFile.getPath());
			e.printStackTrace();
		}
		finally
		{
			try
			{
				input.close();
				output.close();
			}
			catch (NullPointerException npe)
			{
				System.out.println("Could not read file. Blank game created");
				npe.printStackTrace(output);
				output.close();
			}
			catch (Exception e)
			{
				e.printStackTrace(output);
				output.close();
			}
		}
	}
	
	private static void loadMonsters(File inputFile)
	{
		ObjectInputStream input = null;
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(new File("log.txt"));
			input = new ObjectInputStream(new FileInputStream(inputFile));
			Game.monsterArray = new Monster[9];
			int position = 0;
			while (position < Game.monsterArray.length)
			{
				Game.monsterArray[position] = ((Monster)input.readObject());
				position++;
			}
			tempMonsterArray = Game.monsterArray;
			
		}
		catch (EOFException eofe)
		{
			System.out.println("Monster array imported");
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Specified file not found.");
			fnfe.printStackTrace(output);
		}
		catch(Exception e)
		{
			System.out.println("Error occured while reading file: " + inputFile.getPath());
			e.printStackTrace();
		}
		finally
		{
			try
			{
				input.close();
				output.close();
			}
			catch (NullPointerException npe)
			{
				System.out.println("Could not read file. Blank monster array created");
				npe.printStackTrace(output);
				output.close();
			}
			catch (Exception e)
			{
				e.printStackTrace(output);
				output.close();
			}
		}
	}
	
	private static void loadRooms(File inputFile)
	{
		ObjectInputStream input = null;
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(new File("log.txt"));
			input = new ObjectInputStream(new FileInputStream(inputFile));
			Game.roomArray = new Room[29];
			int position = 0;
			while (position < Game.roomArray.length)
			{
				Game.roomArray[position] = ((Room)input.readObject());
				position++;
			}
			
			tempRoomArray = Game.roomArray;
		}
		catch (EOFException eofe)
		{
			System.out.println("Room array imported");
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Specified file not found.");
			fnfe.printStackTrace(output);
		}
		catch(Exception e)
		{
			System.out.println("Error occured while reading file.");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				input.close();
				output.close();
			}
			catch (NullPointerException npe)
			{
				System.out.println("Could not read file. Blank room array created");
				npe.printStackTrace(output);
				output.close();
			}
			catch (Exception e)
			{
				e.printStackTrace(output);
				output.close();
			}
		}
	}
	
	private static void loadPuzzles(File inputFile)
	{
		ObjectInputStream input = null;
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(new File("log.txt"));
			input = new ObjectInputStream(new FileInputStream(inputFile));
			Game.puzzleArray = new Puzzle[9];
			int position = 0;
			while (position < Game.puzzleArray.length)
			{
				Game.puzzleArray[position] = ((Puzzle)input.readObject());
				position++;
			}
			
			tempPuzzleArray = Game.puzzleArray;
		}
		catch (EOFException eofe)
		{
			System.out.println("Puzzle array imported");
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Specified file not found.");
			fnfe.printStackTrace(output);
		}
		catch(Exception e)
		{
			System.out.println("Error occured while reading file.");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				input.close();
				output.close();
			}
			catch (NullPointerException npe)
			{
				System.out.println("Could not read file. Blank puzzle array created");
				npe.printStackTrace(output);
				output.close();
			}
			catch (Exception e)
			{
				e.printStackTrace(output);
				output.close();
			}
		}
	}
}
