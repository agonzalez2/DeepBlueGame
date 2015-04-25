import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;


public class LoadGame 
{
	public static void load()
	{
		loadRooms(new File("room.ser"));
		loadMonsters(new File("monster.ser"));
		loadPuzzles(new File("puzzle.ser"));
		loadGameInstance(new File("game.ser"));
		updateGUI();
	}
	
	public static void updateGUI()
	{
		Player p = Game.getInstance().currentPlayer;
		int stun = 0;
		int pistol = 0;
		int health = 0;
		
		//get count of items in inventory
		for(Item i : p.getInventory())
		{
			if (i instanceof AmmoPack)
			{
				AmmoPack a = (AmmoPack)i;
				if (a.getType().equalsIgnoreCase("pistol ammo"))
				{
					pistol++;
				}
				if (a.getType().equalsIgnoreCase("stun ammo"))
				{
					stun++;
				}
			}
			if (i instanceof HealthPack)
			{
				health++;
			}
		}
		
		//update values in GUI for inventory
		UserInterface.updateInventory(1, pistol);
		UserInterface.updateInventory(2, stun);
		UserInterface.updateInventory(3, health);
		UserInterface.updateInventory(4, Game.scubaPartCount);
		
		//update player health in GUI
		Game.getInstance().currentPlayer.updateHealth(0);
	}
	
	public static void loadGameInstance(File inputFile)
	{
		ObjectInputStream input = null;
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(new File("log.txt"));
			input = new ObjectInputStream(new FileInputStream(inputFile));
			Game game = Game.getInstance();
	
			game.currentPlayer = (Player)input.readObject();
			Game.scubaPartCount = input.readInt();
			game.currentRoomID = input.readInt();
			
		}
		catch (EOFException eofe)
		{
			System.out.println("Game imported");
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
			Game.monsterArray = new Monster[10];
			int position = 0;
			while (true)
			{
				Game.monsterArray[position] = ((Monster)input.readObject());
				position++;
			}
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
			Game.roomArray = new Room[30];
			int position = 0;
			while (true)
			{
				Game.roomArray[position] = ((Room)input.readObject());
				position++;
			}
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
			Game.puzzleArray = new Puzzle[30];
			int position = 0;
			while (true)
			{
				Game.puzzleArray[position] = ((Puzzle)input.readObject());
				position++;
			}
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
