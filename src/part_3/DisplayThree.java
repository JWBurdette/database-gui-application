//Joshua Burdette
package part_3;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

/**
 * The main UI window that contains all of the buttons and
 * selectors. It is a singleton.
 *
 * @author Joshua Burdette
 */
public class DisplayThree extends JFrame implements ActionListener
{
	/**
	 * The singleton instance of DisplayThree.
	 */
	private static DisplayThree display = null;
	
	/**
	 * Constants that are used to determine the various sizes and
	 * coordinates of components.
	 */
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int
					WINDOW_WIDTH = screenSize.width / 2,
					WINDOW_HEIGHT = (int) (WINDOW_WIDTH / 1.4),
					OFFSET = WINDOW_WIDTH / 20,
					SELECTOR_WIDTH = OFFSET * 3,
					SELECTOR_HEIGHT = OFFSET * 5,
					SELECTOR_Y = OFFSET,
					ROOM_SELECTOR_X = SELECTOR_Y,
					C_SELECTOR_X = OFFSET * 5,
					I_SELECTOR_X = OFFSET * 9,
					ADDING_BOX_WIDTH = OFFSET * 5,
					ADDING_BOX_HEIGHT = OFFSET * 6,
					ADDING_BOX_X = OFFSET * 13,
					ADDING_BOX_Y = OFFSET,
					ADDING_LABEL_WIDTH = ADDING_BOX_WIDTH,
					INSTRUCTIONS_WIDTH = OFFSET * 11,
					INSTRUCTIONS_HEIGHT = OFFSET * 5,
					INSTRUCTIONS_X = OFFSET,
					INSTRUCTIONS_Y = OFFSET * 7,
					INSTRUCTIONS_LABEL_X = OFFSET,
					INSTRUCTIONS_LABEL_Y = INSTRUCTIONS_Y - OFFSET + 8,
					LABEL_WIDTH = OFFSET * 3,
					LABEL_HEIGHT = OFFSET,
					LABEL_Y = OFFSET / 4,
					R_LABEL_X = ROOM_SELECTOR_X,
					C_LABEL_X = C_SELECTOR_X,
					I_LABEL_X = I_SELECTOR_X,
					ADD_LABEL_X = ADDING_BOX_X,
					DELETE_BUTTON_Y = (OFFSET * 6) + (OFFSET / 4),
					DELETE_BUTTON_WIDTH = OFFSET * 2,
					DELETE_BUTTON_HEIGHT = OFFSET / 2,
					C_DELETE_BUTTON_X = C_SELECTOR_X + (OFFSET / 2),
					I_DELETE_BUTTON_X = I_SELECTOR_X + (OFFSET / 2),
					ADD_BUTTON_DIAMETER = OFFSET * 2,
					ADD_BUTTON_X = ADDING_BOX_X + ((ADDING_BOX_WIDTH / 2) - (ADD_BUTTON_DIAMETER / 2)),
					ADD_BUTTON_Y = OFFSET * 7 + (OFFSET / 2);
	
	/**
	 * JComponents used in this class.
	 */
	JTextPane usageInstructions;
	JButton deleteCreatureButton;
	JButton deleteItemButton;
	JButton addItemButton;
	JLabel roomSelectorLabel;
	JLabel creatureSelectorLabel;
	JLabel itemSelectorLabel;
	JLabel addBoxLabel;
	JLabel instructionBoxLabel;
	
	/**
	 * My JPanel subclasses used in this class.
	 */
	Selector roomSelector;
	CreatureSelector creatureSelector;
	ItemSelector itemSelector;
	AddBox addBox;
	
	/**
	 * Integer that holds the currently-selected room ID.
	 */
	public int selectedRoomID = 1;
	
	/**
	 * Vectors used to populate the selectors.
	 */
	Vector<String> rooms = new Vector<String>();
	Vector<String> creaturesInRoom = new Vector<String>();
	Vector<String> itemsInRoom = new Vector<String>();
	Vector<String> allThatCanBeAddedToRoom = new Vector<String>();
	
	/**
	 * Singleton method that returns the instance of this class.
	 */
	public static DisplayThree getInstance()
	{
		if (display == null)
			display = new DisplayThree();
		return display;
	}
	
	/**
	 * Constructor that sets layout and color settings and creates
	 * the objects that will appear in the UI.
	 */
	private DisplayThree()
	{
		setLayout(null);
		getContentPane().setBackground(new Color(230, 230, 230));
		
		
		//FILL VECTORS 
		//REPLACED WITH HARD-CODED ARRAYS FOR DEMONSTRATION PURPOSES
//		rooms = DisplayThreeSQLHandler.getRooms();
//		creaturesInRoom = DisplayThreeSQLHandler.getCreaturesInRoom(selectedRoomID);
//		itemsInRoom = DisplayThreeSQLHandler.getItemsInRoom(selectedRoomID);
//		allThatCanBeAddedToRoom = DisplayThreeSQLHandler.getAllThatCanBeAddedToRoom("CREATURE");
		rooms = new Vector<String>(Arrays.asList("Room 1", "Room 2", "Room 3", "Room 4"));
		creaturesInRoom = new Vector<String>(Arrays.asList("Knight", "Zombie", "Skeleton", "Bear"));
		itemsInRoom = new Vector<String>(Arrays.asList("Sword", "Arrow", "Spear", "Hammer"));;
		allThatCanBeAddedToRoom = new Vector<String>(Arrays.asList("Bat", "Dog", "Snake", "Dragon", "Eagle", "Lion"));;
		
		
		//SET ALL LABELS
		roomSelectorLabel = new JLabel("Rooms", SwingConstants.CENTER);
		roomSelectorLabel.setBounds(R_LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		creatureSelectorLabel = new JLabel("Creatures", SwingConstants.CENTER);
		creatureSelectorLabel.setBounds(C_LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		itemSelectorLabel = new JLabel("Items", SwingConstants.CENTER);
		itemSelectorLabel.setBounds(I_LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		addBoxLabel = new JLabel("Add Creatures", SwingConstants.CENTER);
		addBoxLabel.setBounds(ADD_LABEL_X, LABEL_Y, ADDING_LABEL_WIDTH, LABEL_HEIGHT);
		instructionBoxLabel = new JLabel("Instructions");
		instructionBoxLabel.setBounds(INSTRUCTIONS_LABEL_X, INSTRUCTIONS_LABEL_Y, ADDING_LABEL_WIDTH, LABEL_HEIGHT);
		add(roomSelectorLabel);
		add(creatureSelectorLabel);
		add(itemSelectorLabel);
		add(addBoxLabel);
		add(instructionBoxLabel);
		
		
		//SET INSTRUCTIONS
		usageInstructions = new JTextPane();
		usageInstructions.setText(getInstructionString());
		usageInstructions.setEditable(false);
		usageInstructions.setBounds(INSTRUCTIONS_X, INSTRUCTIONS_Y, INSTRUCTIONS_WIDTH, INSTRUCTIONS_HEIGHT);
		usageInstructions.setBorder(new LineBorder(Color.BLACK));
		add(usageInstructions);
		
		
		//INITIALIZE ALL SELECTORS AND THE ADD BOX
		roomSelector = new Selector(this, rooms);
		roomSelector.setBounds(ROOM_SELECTOR_X, SELECTOR_Y, SELECTOR_WIDTH, SELECTOR_HEIGHT);
		add(roomSelector);
		
		creatureSelector = new CreatureSelector(this, creaturesInRoom);
		creatureSelector.setBounds(C_SELECTOR_X, SELECTOR_Y, SELECTOR_WIDTH, SELECTOR_HEIGHT);
		add(creatureSelector);
		
		itemSelector = new ItemSelector(this, itemsInRoom);
		itemSelector.setBounds(I_SELECTOR_X, SELECTOR_Y, SELECTOR_WIDTH, SELECTOR_HEIGHT);
		add(itemSelector);
		
		addBox = new AddBox(this, allThatCanBeAddedToRoom);
		addBox.setBounds(ADDING_BOX_X, ADDING_BOX_Y, ADDING_BOX_WIDTH, ADDING_BOX_HEIGHT);
		add(addBox);
		
		
		//INITIALIZE THE THREE BUTTONS
		deleteCreatureButton = new JButton(" X ");
		deleteCreatureButton.setBounds(C_DELETE_BUTTON_X, DELETE_BUTTON_Y, DELETE_BUTTON_WIDTH, DELETE_BUTTON_HEIGHT);
		deleteCreatureButton.addActionListener(this);
		deleteCreatureButton.setBackground(Color.RED);
		deleteCreatureButton.setContentAreaFilled(false);
		deleteCreatureButton.setOpaque(true);
		add(deleteCreatureButton);
		
		deleteItemButton = new JButton(" X ");
		deleteItemButton.setBounds(I_DELETE_BUTTON_X, DELETE_BUTTON_Y, DELETE_BUTTON_WIDTH, DELETE_BUTTON_HEIGHT);
		deleteItemButton.addActionListener(this);
		deleteItemButton.setBackground(Color.RED);
		deleteItemButton.setContentAreaFilled(false);
		deleteItemButton.setOpaque(true);
		add(deleteItemButton);
		
		addItemButton = new AddButton("Add");
		addItemButton.setBounds(ADD_BUTTON_X, ADD_BUTTON_Y, ADD_BUTTON_DIAMETER, ADD_BUTTON_DIAMETER);
		addItemButton.addActionListener(this);
		add(addItemButton);
		
		
		setSize((int) WINDOW_WIDTH, (int) WINDOW_HEIGHT);
		setResizable(false);
		setVisible(true);
	}
	
	
	/**
	 * Method runs if any of the action listeners detect an event. Calls
	 * appropriate methods for deleting and adding entities.
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == deleteCreatureButton)
		{
			creatureSelector.deleteSelectedAndRefresh();
			
		} else if (event.getSource() == deleteItemButton)
		{
			itemSelector.deleteSelectedAndRefresh();
			
		} else if (event.getSource() == addItemButton)
		{
			addBox.moveSelectedToRoom();
		}
	}
	
	
	/**
	 * Changes the selected room and changes what is displayed by the
	 * creature selector and room selector to match what is in the
	 * new room. Called by the room selector when its buttons are pressed.
	 *
	 * @param selectedRoom is the ID of the currently-selected room.
	 */
	public void changeSelectedRoom(int selectedRoom)
	{
		this.selectedRoomID = selectedRoom;
		
		creaturesInRoom = DisplayThreeSQLHandler.getCreaturesInRoom(selectedRoomID);
		creatureSelector.changeContentsToNewRoom(creaturesInRoom);
		
		itemsInRoom = DisplayThreeSQLHandler.getItemsInRoom(selectedRoomID);
		itemSelector.changeContentsToNewRoom(itemsInRoom);
	}
	
	/**
	 * Returns the usage instructions. Located down here to
	 * keep things cleaner.
	 */
	private String getInstructionString()
	{
		return "Click on a room ID. The boxes to the right will fill with "
									 + "all of the creatures and items that are in that room.\n\nSelect "
									 + "one and click the red button below it to remove it from the "
									 + "room.\n\nThe final box contains all of the entities of the type "
									 + "that you last clicked on that are not currently in a room. "
									 + "Select one and click the 'Add' button to add them to the room.";
	}
}

