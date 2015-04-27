import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**Class: UserInterface
* @author Andrew Cronic 
* @version 2.5 
* Course : ITEC 3150 Spring 2015 
* Written: April 4, 2015
* 
* 
* UserInterface -
* This class builds a user-friendly interface that allows the user to interact with the Game and send game-related commands
* 
* Purpose: The purpose of this class is to provide an interface that allows for Game objects to be explored and interacted with through
* the game's user.  The interface also displays important Game information to allow the player to keep track of health and inventory, as well
* as read game information and respond to any game-related prompts
*/ 
public class UserInterface 
{
	//FRAME
	private static JFrame frame = new JFrame("Deep Blue");
	
	//PANELS
	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel centerPanel = new JPanel();

	//BUTTONS
	private static JButton userSubmitButton = new JButton("SUBMIT");
	private static JButton investigateButton = new JButton("Investigate");
	private static JButton useHealthPackButton = new JButton("Use Health Pack");
	
	//MENU and MENUITEMS
	private JMenuBar menu = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu help = new JMenu("Help");
	private JMenuItem newGame = new JMenuItem("New Game");
	private JMenuItem loadGame = new JMenuItem("Load Game");
	private JMenuItem saveGame = new JMenuItem("Save Game");
	private JMenuItem quit = new JMenuItem("Quit");
	private JMenuItem about = new JMenuItem("How to Play");

	//TEXTAREA
	private static JTextArea userInputArea = new JTextArea();
	private static JTextArea gameTextArea = new JTextArea("Welcome to Deep Blue! Navigate to File > New Game"
			+ " to begin a new game - Or load a previous game to continue your progress!" + '\n');
	
	//LABELS
	private static JLabel userInputLabel = new JLabel("USER INPUT:");
	private static JLabel inventoryPic1 = new JLabel();
	private static JLabel inventoryPic2 = new JLabel();
	private static JLabel inventoryPic3 = new JLabel();
	private static JLabel inventoryPic4 = new JLabel();
	private static JLabel healthPic = new JLabel();
	private static JLabel healthLabel = new JLabel("HEALTH: 100%");
	public static int quantityValue1 = 0;
	public static int quantityValue2 = 0;
	public static int quantityValue3 = 0;
	public static int quantityValue4 = 0;
	public static JLabel quantityLabel1 = new JLabel("QTY.  " + quantityValue1);
	public static JLabel quantityLabel2 = new JLabel("QTY.  " + quantityValue2);
	public static JLabel quantityLabel3 = new JLabel("QTY.  " + quantityValue3);
	public static JLabel quantityLabel4 = new JLabel("QTY.  " + quantityValue4);
	
	//Health / Inventory Components
	private static ImageIcon[] inventoryArray = new ImageIcon[4];
	private static ImageIcon[] healthArray = new ImageIcon[11];

	/**
	Method: UserInterface()
	*
	Constructs new UserInterface, configures all components' visual information,
	and adds ActionListeners to necessary components.
	*
	**/
	public UserInterface()
	{    
		//CONFIGURE FRAME  
		frame.setBackground(Color.blue);
		frame.setSize(1200,850);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		//Set COMPONENT Layouts and COLORS
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(new Color(70,130,180));
		westPanel.setLayout(new GridLayout(4,2));
		westPanel.setBackground(new Color(128,128,128));
		eastPanel.setLayout(new BorderLayout());
		eastPanel.setBackground(new Color(211,211,211));
		southPanel.setLayout(new GridLayout(0,2,0,0));
		southPanel.setBackground(new Color(211,211,211));
		northPanel.setBackground(new Color(211,211,211));
		northPanel.setLayout(new BorderLayout());
		userSubmitButton.setBackground(new Color(255,255,51));
		userSubmitButton.setForeground(Color.BLACK);
		quantityLabel1.setForeground(Color.white);
		quantityLabel2.setForeground(Color.white);
		quantityLabel3.setForeground(Color.white);
		quantityLabel4.setForeground(Color.white);
		
		//SET EDITABLE
		gameTextArea.setEditable(false);
		gameTextArea.setSize(400,400);
		gameTextArea.setLineWrap(true);
		gameTextArea.setWrapStyleWord(true);

		
		//SET FONTS
		healthLabel.setFont(new Font("Serif", Font.BOLD, 16));
		userInputLabel.setFont(new Font("Serif", Font.BOLD, 18));
		quantityLabel1.setFont(new Font("Serif", Font.BOLD, 18));
		quantityLabel2.setFont(new Font("Serif", Font.BOLD, 18));
		quantityLabel3.setFont(new Font("Serif", Font.BOLD, 18));
		quantityLabel4.setFont(new Font("Serif", Font.BOLD, 18));
		gameTextArea.setFont(new Font("Serif", Font.PLAIN, 14));
		
		
		//SET ICONS
		URL url = UserInterface.class.getResource("/health10.jpg");
		healthPic.setIcon(new ImageIcon(url));

		//CREATE and SET BORDERS
		Border titleBorder = (BorderFactory.createEmptyBorder(0,25,25,25));
		centerPanel.setBorder(BorderFactory.createTitledBorder(titleBorder, "Deep Blue", 
				TitledBorder.LEFT, TitledBorder.RIGHT, 
				new Font("Serif", Font.BOLD, 28), Color.white));
		southPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		BorderFactory.createTitledBorder(titleBorder, "Deep Blue");
		eastPanel.setBorder(BorderFactory.createEmptyBorder(15,25,25,25));
		westPanel.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(211,211,211)));
		inventoryPic1.setBorder(BorderFactory.createEmptyBorder(0,15,0,15));
		inventoryPic2.setBorder(BorderFactory.createEmptyBorder(0,15,0,15));
		inventoryPic3.setBorder(BorderFactory.createEmptyBorder(0,15,0,15));
		inventoryPic4.setBorder(BorderFactory.createEmptyBorder(0,15,0,15));
		

		//ADD COMPONENTS
		menu.add(file);
		menu.add(help);
		file.add(newGame);
		file.add(loadGame);
		file.add(saveGame);
		file.add(quit);
		help.add(about);
		//NORTH PANEL
		northPanel.add(menu, BorderLayout.NORTH);
		//CENTER PANEL
		centerPanel.add(westPanel, BorderLayout.WEST);
		centerPanel.add(eastPanel, BorderLayout.EAST);
		centerPanel.add(new JScrollPane(gameTextArea), BorderLayout.CENTER);
		//SOUTH PANEL
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		southPanel.add(investigateButton);
		southPanel.add(useHealthPackButton);
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		southPanel.add(new JScrollPane(userInputArea));
		southPanel.add(userSubmitButton);
		//WEST PANEL
		westPanel.add(inventoryPic1);
		westPanel.add(quantityLabel1);
		westPanel.add(inventoryPic2);
		westPanel.add(quantityLabel2);
		westPanel.add(inventoryPic3);
		westPanel.add(quantityLabel3);
		westPanel.add(inventoryPic4);
		westPanel.add(quantityLabel4);
		//EAST PANEL
		healthPic.setHorizontalAlignment(JLabel.CENTER);
		eastPanel.add(healthPic, BorderLayout.CENTER);
		eastPanel.add(healthLabel, BorderLayout.SOUTH);
		
		//FRAME
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.add(eastPanel, BorderLayout.EAST);
		frame.add(westPanel, BorderLayout.WEST);
		frame.add(centerPanel, BorderLayout.CENTER);
		
		//SET VISIBLE
		quit.setVisible(true);
		help.setVisible(true);
		file.setVisible(true);
		menu.setVisible(true);
		about.setVisible(true);
		gameTextArea.setVisible(true);
		northPanel.setVisible(true);
		southPanel.setVisible(true);
		eastPanel.setVisible(true);
		westPanel.setVisible(true);
		centerPanel.setVisible(true);
		frame.setVisible(true);
		
	
		//ACTION LISTENERS
		newGame.addActionListener(new ActionListener()
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
            	String[] args = {};
            	CreateGame.main(args); //Calls the Create Game main to generate a new Game instance.
            	gameButtonsOn(true);
            }
            
        }); 
		
		saveGame.addActionListener(new ActionListener()
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
            	SaveGame.writeToFile();
            	
            }
            
        }); 
		
		loadGame.addActionListener(new ActionListener()
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
            	LoadGame.load();
            	//Game.getInstance().run();
            	System.out.println(Game.getInstance().currentRoomID);
            }
            
        });
		
		investigateButton.addActionListener(new ActionListener() 
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
                String investigateString = Game.roomArray[Game.getInstance().currentRoomID].investigate();
                setGameTextArea(investigateString);
            }
        }); 
		
		useHealthPackButton.addActionListener(new ActionListener() 
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
                try {
					Game.getInstance().currentPlayer.getItem("Health Pak").use();
				} catch (InvalidItemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }); 
		
		quit.addActionListener(new ActionListener() 
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }); 
		
		about.addActionListener(new ActionListener() 
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
                JFrame aboutFrame = new JFrame("Game Documentation - Help");
                JTextArea aboutArea = new JTextArea("HOW TO PLAY THE GAME: " +'\n'
                		+ '\n' + "Navigating Rooms:" + '\n' + '\n' +
                		"To navigate between rooms, select from door 1, 2, or 3 when prompted."
                		+ "Then, click the investigate button to search the room for puzzles and items!"
                		+'\n' + '\n' + "Fighting Monsters:" + '\n' + '\n' +
                		"If a monster is in a room, you will enter a MonsterBattle where you can choose from"
                		+" several actions to take against the monster.  Depending on the monster's attack strategy, "
                		+ "you may have to experiment with the actions you choose and in what order you choose them."
                		+ '\n' + '\n' + "Solving Puzzles: " +'\n' + '\n'
                		+ "If a room contains a puzzle, you will be prompted for an action to take to solve the puzzle"
                		+ " when you come across one.");
                
                aboutArea.setEditable(false);
                aboutArea.setLineWrap(true);
                aboutArea.setWrapStyleWord(true);
                aboutFrame.setSize(450, 380);
                aboutFrame.setLocationRelativeTo(null);
                aboutFrame.add(aboutArea);
                aboutFrame.setVisible(true);
            }
        }); 
		
		
		userSubmitButton.addActionListener(new ActionListener() 
		{
	       	 
            public void actionPerformed(ActionEvent e)
            {
            	String input = userInputArea.getText();
            	
            	if(isInteger(input))
            	{
            		Game.getInstance().setCurrentRoom(Integer.parseInt(input));
                	setGameTextArea(Game.roomArray[Game.getInstance().currentRoomID].getRoomDescription());
                	
                	if(Game.roomArray[Game.getInstance().currentRoomID].hasMonster())
                	{
                		int monsterInRoom = Game.roomArray[Game.getInstance().currentRoomID].getMonsterInRoom();
                		String monstName = Game.monsterArray[monsterInRoom].getName();
                		setGameTextArea("MONSTER IN ROOM! " + monstName);
                	}
            	}
            	
            	if(input.equals("investigate"))
    			{
            		setGameTextArea(Game.roomArray[Game.getInstance().currentRoomID].investigate());
    			}
            		
                System.out.println("User Input " + input + " Submitted.");
                userInputArea.setText(null);
     
            }
        }); 	
	}

	
	
	public static void main(String Args[])
	{
		//READ IN HEALTH and INVENTORY IMAGES into respective arrays
		try 
		{
			
			for(int i = 0; i < inventoryArray.length; i++)
			{
				URL url = UserInterface.class.getResource("/inventory" + i + ".jpg");
				//String inventoryNum = "/inventory" + (i) + ".jpg";
				//ImageIcon tempInventory = new ImageIcon(ImageIO.read(new File(inventoryNum)));
				ImageIcon tempInventory = new ImageIcon(ImageIO.read(url));
				inventoryArray[i] = tempInventory;
				
			}
			
			for(int i = 0; i < healthArray.length; i++)
			{
				URL url = UserInterface.class.getResource("/health" + i + ".jpg");
				//String healthNum = "/health" + (i) + ".jpg";
				//ImageIcon tempHealth = new ImageIcon(ImageIO.read(new File(healthNum)));
				ImageIcon tempHealth = new ImageIcon(ImageIO.read(url));
				healthArray[i] = tempHealth;
				
			}		
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//set fixed inventory icons
		inventoryPic1.setIcon(inventoryArray[0]);
		inventoryPic2.setIcon(inventoryArray[1]);
		inventoryPic3.setIcon(inventoryArray[2]);
		inventoryPic4.setIcon(inventoryArray[3]);
		
		//SET FULL HEALTH INITIALLY
		healthPic.setIcon(healthArray[0]); 

		new UserInterface();

	}

	
	/**
	Method: isInteger()
	*
	Tests whether a String is an integer value when parsed.
	*
	*@param input - The String input that is being checked whether is an integer or not
	*@return -  Returns true if the String is an integer when parsed, false otherwise.
	**/
	public static boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch(Exception e)
	   {
	      return false;
	   }
	}
	
	/**
	Method: updateInventory()
	*
	Updates quantity values that are displayed on the UserInterface next to associated items in the player inventory.
	*
	*@param itempType - the itemType to be updated (1,2,3,4) = (PistolAmmo, StunAmmo, HealthPak, ScubaPart)
	*@param updateValue - the number to be added to the current quantity value - can be negative or positive.
	**/
	public static void updateInventory(int itemType, int updateValue)
	{
		//Pistol Ammo
		if(itemType == 1)
		{
			int current = quantityValue1;
			int newValue = current + updateValue;
			quantityLabel1.setText("QTY.   " + newValue);
			quantityValue1 = newValue;
		}
		
		//Stun Ammo
		if(itemType == 2)
		{
			int current = quantityValue2;
			int newValue = current + updateValue;
			quantityLabel2.setText("QTY.   " + newValue);
			quantityValue2 = newValue;
		}
		
		//Health Pack
		if(itemType == 3)
		{
			int current = quantityValue3;
			int newValue = current + updateValue;
			quantityLabel3.setText("QTY.   " + newValue);
			quantityValue3 = newValue;
		}
		
		//Scuba Part
		if(itemType == 4)
		{
			int current = quantityValue4;
			int newValue = current + updateValue;
			quantityLabel4.setText("QTY.   " + newValue);
			quantityValue4 = newValue;
		}
	}
	
	/**
	Method: setHealthPic()
	*
	Sets the Health displayed on the UserInterface to an icon existing in healthArray.
	*@param healthNumber - the number of health to be displayed 0-10 (Percent Health = healthNumber * 10)
	 * 
	**/
	public static void setHealthPic(int healthNumber)
	{
		
		healthPic.setIcon(healthArray[healthNumber]);
		
		healthLabel.setText("HEALTH: " + Game.getInstance().currentPlayer.getHealth() + "%");
		
	}
	
	/**
	Method: setGameTextArea()
	*
	Sets the text area in the center of the UserInterface to a passed string parameter.  This method is used
	to update the user with important game information and prompt the user for information when necessary.
	*
	*@param s - the String to be appended and displayed within the gameTextArea component.
	**/
	public static void setGameTextArea(String s)
	{
		
	    gameTextArea.append('\n' + s + '\n');
		gameTextArea.setCaretPosition(gameTextArea.getDocument().getLength()); //automatically scrolls to the bottom of the TextArea
		
		//When the room is empty, prompt user to choose a room (1, 2, or 3) for the next level.
		if(s.equalsIgnoreCase("the room is empty."))
		{
			Game.promptUserForNext();
		}
		
		
		//When a monster is in the room, disable the investigate button, and initialize a new Monster Battle
		//with the currentPlayer and the monster associated with the currentRoomID.
		if(s.contains("MONSTER IN ROOM"))
		{
			//s.substring(0,15).equalsIgnoreCase("monster in room")
			System.out.println("MONSTER BATTLE ENTERED!");
			
			//disable investigate button
			gameButtonsOn(false);
			//the index that this room's monster can be retrieved within monsterArray
			int monsterInRoomIndex = Game.roomArray[Game.getInstance().currentRoomID].getMonsterInRoom(); 
			//Construct new MonsterBattle
			new MonsterBattle(Game.getInstance().currentPlayer, Game.monsterArray[monsterInRoomIndex]);
		}
		
		if(s.contains("puzzle in room"))
		{
			System.out.println("PUZZLE ENTERED!");
			
			//disable investigate button
			gameButtonsOn(false);
			//the index that this room's monster can be retrieved within monsterArray
			int puzzleInRoomIndex = Game.roomArray[Game.getInstance().currentRoomID].getPuzzleInRoom();
			System.out.println("476");
			
			setGameTextArea(Game.puzzleArray[puzzleInRoomIndex].getPuzzleDescription());
			
			//Construct new MonsterBattle
			if(Game.getInstance().roomArray[Game.getInstance().currentRoomID].hasMonster() &&
					Game.monsterArray[Game.roomArray[Game.getInstance().currentRoomID].getMonsterInRoom()].getIsDefeated())
			{
				System.out.println("480");
				Game.puzzleArray[puzzleInRoomIndex].startPuzzle();
			}
			else if(Game.getInstance().roomArray[Game.getInstance().currentRoomID].hasPuzzle())
			{
				System.out.println("485");
				Game.puzzleArray[puzzleInRoomIndex].startPuzzle();
				System.out.println("488");
			}
			
		}
	}

	/**
	Method: gameButtonsOn()
	*
	Enables or Disables game buttons from being interacted with or clicked (usually during a MonsterBattle)
	*
	*@param areTheyOn - boolean value passed to determine if game buttons are enabled or disabled (true = enabled, false = disabled)
	**/
	public static void gameButtonsOn(boolean areTheyOn)
	{
		if(areTheyOn == true)
		{
			investigateButton.setEnabled(true);
			useHealthPackButton.setEnabled(true);
			userSubmitButton.setEnabled(true);
			userInputArea.setEnabled(true);
		}
		
		if(areTheyOn == false)
		{
			investigateButton.setEnabled(false);
			useHealthPackButton.setEnabled(false);
			userSubmitButton.setEnabled(false);
			userInputArea.setEnabled(false);
		}
	}
	
	public static void resetInterface()
	{
		quantityValue1 = 0;
		quantityValue2 = 0;
		quantityValue3 = 0;
		quantityValue4 = 0;
		
		
		ArrayList<Item> inventory = Game.getInstance().currentPlayer.getInventory();
		
		for (Item i: inventory)
		{
			if (i instanceof Weapon)
			{
				if (i.getDescription().equalsIgnoreCase("Pistol"))
				{
					quantityValue1 = Game.getInstance().currentPlayer.getPistol().getAmmo();
				}
				
				if (i.getDescription().equalsIgnoreCase("Stun Gun"))
				{
					quantityValue2 = Game.getInstance().currentPlayer.getStun().getAmmo();
				}
			}
			
			if (i instanceof HealthPack)
			{
				quantityValue3++;
			}
			
			if (i instanceof ScubaGear)
			{
				quantityValue4++;
			}
		}
		
		quantityLabel1.setText("QTY.   " + quantityValue1);
		quantityLabel2.setText("QTY.   " + quantityValue2);
		quantityLabel3.setText("QTY.   " + quantityValue3);
		quantityLabel4.setText("QTY.   " + quantityValue4);
		
		int currentPlayerHealth = Game.getInstance().currentPlayer.getHealth();
		setHealthPic(currentPlayerHealth/10);
		UserInterface.healthLabel.setText("HEALTH: " + currentPlayerHealth + "%");
	}
	
	
	/**
	Method: promptUserForRoom()
	*
	Method that when invoked, prompts the user to enter choose a room (1, 2, or 3) via a JOptionPane dialog.
	*
	**/
	public static int promptUserForRoom()
	{
		int roomNumSelected = -1;

		//options array containing choices for user to select from
		Object[] options = {"Door 1",
		                    "Door 2",
		                    "Door 3"};
		
		//Integer that stores the user's selection (index in the options array)
		int n = JOptionPane.showOptionDialog(frame,
		    "Choose a door to continue to the next room.",
		    "Choose your path.",
		    JOptionPane.YES_NO_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[2]);
	
		
		System.out.println("You Selected Door " + n);

		roomNumSelected = n;
		
		return roomNumSelected;
	}
	
	/**
	Method: promptUserForAction()
	*
	This method is invoked during a MonsterBattle to prompt the user to select the action
	they would like to perform against the encountered Monster.  The player can choose from
	Pistol Attack, Stun Attack, Defend, or Use Health Pack.
	*
	**/
	public static int promptUserForAction()
	{
		int actionSelected = -1;
		
		//array of options for user to select from
		Object[] options = {"Pistol Attack",
		                    "Stun Attack",
		                    "Defend",
		                    "Use Health Pack"};
		
		//integer storing user's selection (index in options array)
		int n = JOptionPane.showOptionDialog(frame,
		    "Choose an action to take against the encountered monster.",
		    "Choose your action.",
		    JOptionPane.YES_NO_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[2]);
	
		
		System.out.println("You Selected Action " + n);

		actionSelected = n;
		
		//if a valid selection was not made
		while(actionSelected < 0)
		{
			n = JOptionPane.showOptionDialog(frame,
				    "Choose an action to take against the encountered monster.",
				    "Choose a VALID action.",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[2]);
			
			actionSelected = n;
		}
		
		
		return actionSelected;
	}
	
	
	public static Action promptUserForPuzzle()
	{
		int actionSelected = -1;
		

		
		//array of options for user to select from
		Action[] options = Game.puzzleArray[Game.roomArray[Game.getInstance().currentRoomID].getPuzzleInRoom()].getPossibleActions();
		
		
		
		//integer storing user's selection (index in options array)
		int n = JOptionPane.showOptionDialog(frame,
		    "Choose an action to take for the puzzle.",
		    "Choose your action.",
		    JOptionPane.YES_NO_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[2]);
	
		actionSelected = n;
		System.out.println("You Selected Action " + n);

		Action tempActionSelected = options[n];
		
		//if a valid selection was not made
		while(actionSelected < 0)
		{
			n = JOptionPane.showOptionDialog(frame,
				    "Choose an action to take for the puzzle.",
				    "Choose a VALID action.",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[2]);
			
			actionSelected = n;
		}
		
		
		return tempActionSelected;
	}
	
	
	
	public static void promptGameOverMessage()
	{
		if(Game.getInstance().scubaPartCount >= 2)
		{
			JOptionPane.showMessageDialog(frame, "You have collected enough Scuba Parts to escape!  You survive!");
			UserInterface.setGameTextArea("Great Job!  Navigate to File > New Game to play again!");
			gameButtonsOn(false);
		}
		
		else
		{
			JOptionPane.showMessageDialog(frame, "You do not have enough scuba parts to escape!  You lose and die.");
			UserInterface.setGameTextArea("Better luck next time!  Navigate to File > New Game to try again!");
			gameButtonsOn(false);
		}
		
	}
	

}




