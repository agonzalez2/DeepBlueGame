import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class UserInterface 
{
	

	private static JFrame frame = new JFrame("Deep Blue");
	
	//PANELS
	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel centerPanel = new JPanel();

	//BUTTONS
	private JButton userSubmitButton = new JButton("SUBMIT");
	private static JButton investigateButton = new JButton("Investigate");
	
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
	private static int quantityValue1 = 0;
	private static int quantityValue2 = 0;
	private static int quantityValue3 = 0;
	private static int quantityValue4 = 0;
	private static JLabel quantityLabel1 = new JLabel("QTY.  " + quantityValue1);
	private static JLabel quantityLabel2 = new JLabel("QTY.  " + quantityValue2);
	private static JLabel quantityLabel3 = new JLabel("QTY.  " + quantityValue3);
	private static JLabel quantityLabel4 = new JLabel("QTY.  " + quantityValue4);
	
	//Health / Inventory Components
	private static ImageIcon[] inventoryArray = new ImageIcon[4];
	private static ImageIcon[] healthArray = new ImageIcon[11];

	
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
		quantityLabel1.setFont(new Font("Serif", Font.BOLD, 18));
		quantityLabel2.setFont(new Font("Serif", Font.BOLD, 18));
		quantityLabel3.setFont(new Font("Serif", Font.BOLD, 18));
		quantityLabel4.setFont(new Font("Serif", Font.BOLD, 18));
		
		
		//SET EDITABLE
		gameTextArea.setEditable(false);
		gameTextArea.setSize(400,400);
		gameTextArea.setFont(new Font("Serif", Font.PLAIN, 14));
		
		//SET FONTS
		healthLabel.setFont(new Font("Serif", Font.BOLD, 16));
		userInputLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		//SET ICONS
		healthPic.setIcon(new ImageIcon("health10.jpg"));

		
		//CREATE / SET BORDERS
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
		southPanel.add(new JLabel());
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
            	CreateGame.main(args);
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
                		+ "HELP DOCUMENTATION HERE");
                aboutArea.setEditable(false);
                aboutFrame.setSize(450, 300);
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
		//READ IN HEALTH and INVENTORY IMAGES
		try {
			
			for(int i = 0; i < inventoryArray.length; i++)
			{
				String inventoryNum = "inventory" + (i) + ".jpg";
				ImageIcon tempInventory = new ImageIcon(ImageIO.read(new File(inventoryNum)));
				inventoryArray[i] = tempInventory;
				
			}
			
			for(int i = 0; i < healthArray.length; i++)
			{
				String healthNum = "health" + (i) + ".jpg";
				ImageIcon tempHealth = new ImageIcon(ImageIO.read(new File(healthNum)));
				healthArray[i] = tempHealth;
				
			}		
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		inventoryPic1.setIcon(inventoryArray[0]);
		inventoryPic2.setIcon(inventoryArray[1]);
		inventoryPic3.setIcon(inventoryArray[2]);
		inventoryPic4.setIcon(inventoryArray[3]);
		
		healthPic.setIcon(healthArray[0]); //SETS FULL HEALTH INITIALLY

		new UserInterface();

	}

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
	
	public static void updateInventory(int itemType, int updateValue)
	{
		if(itemType == 1)
		{
			int current = quantityValue1;
			int newValue = current + updateValue;
			quantityLabel1.setText("QTY.   " + newValue);
			quantityValue1 = newValue;
		}
		
		if(itemType == 2)
		{
			int current = quantityValue2;
			int newValue = current + updateValue;
			quantityLabel2.setText("QTY.   " + newValue);
			quantityValue2 = newValue;
		}
		
		if(itemType == 3)
		{
			int current = quantityValue3;
			int newValue = current + updateValue;
			quantityLabel3.setText("QTY.   " + newValue);
			quantityValue3 = newValue;
		}
		
		if(itemType == 4)
		{
			int current = quantityValue4;
			int newValue = current + updateValue;
			quantityLabel4.setText("QTY.   " + newValue);
			quantityValue4 = newValue;
		}
	}
	
	public static void setHealthPic(int healthNumber)
	{
		healthPic.setIcon(healthArray[healthNumber]);
	}
	
	
	public static void setGameTextArea(String s)
	{
		
	    gameTextArea.append('\n' + s + '\n');
		gameTextArea.setCaretPosition(gameTextArea.getDocument().getLength());
		
		if(s.equalsIgnoreCase("the room is empty."))
		{
			Game.promptUserForNext();
		}
		
		if(s.substring(0,7).equalsIgnoreCase("monster"))
		{
			System.out.println("MONSTER BATTLE ENTERED!");
			
			gameButtonsOn(false);
			int monsterInRoomIndex = Game.roomArray[Game.getInstance().currentRoomID].getMonsterInRoom();
			new MonsterBattle(Game.getInstance().currentPlayer, Game.monsterArray[monsterInRoomIndex]);
			Game.getInstance().toggleBattle();
		}
	}
	
	
	public static void gameButtonsOn(boolean areTheyOn)
	{
		if(areTheyOn == true)
		{
			investigateButton.setEnabled(true);
		}
		
		if(areTheyOn == false)
		{
			investigateButton.setEnabled(false);
		}
	}
	
	public static int promptUserForRoom()
	{
		int roomNumSelected = -1;

		Object[] options = {"Door 1",
		                    "Door 2",
		                    "Door 3"};
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
	
	public static int promptUserForAction()
	{
		int actionSelected = -1;

		Object[] options = {"Pistol Attack",
		                    "Stun Attack",
		                    "Defend",
		                    "Use Health Pack"};
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
	

}




