package part_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


public class DisplayThree extends JFrame implements ActionListener {
	
	private static DisplayThree display = null;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int 
	WINDOW_WIDTH = screenSize.width / 2,			                
	//WINDOW_HEIGHT = screenSize.height / 2,	
	WINDOW_HEIGHT = (int) (WINDOW_WIDTH / 1.8),	
	OFFSET = WINDOW_WIDTH / 20,
	SELECTOR_WIDTH = OFFSET * 3,			               
	SELECTOR_HEIGHT = OFFSET * 5,	
	SELECTOR_Y = OFFSET,
	ROOM_SELECTOR_X = SELECTOR_Y,			                
	C_SELECTOR_X = OFFSET * 5,			                	                
	I_SELECTOR_X = OFFSET * 9,			                
	ADDING_BOX_WIDTH = OFFSET * 4,			                
	ADDING_BOX_HEIGHT = OFFSET * 6,			                
	ADDING_BOX_X = OFFSET * 13,	// - (OFFSET / 4)		                
	ADDING_BOX_Y = OFFSET,		
	INSTRUCTIONS_WIDTH = OFFSET * 11,
	INSTRUCTIONS_HEIGHT = OFFSET * 2,
	INSTRUCTIONS_X = OFFSET,
	INSTRUCTIONS_Y = OFFSET * 7,
	LABEL_WIDTH = OFFSET * 3,			               
	LABEL_HEIGHT = OFFSET,			                
	LABEL_Y = OFFSET,			                
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
			                			              			              
	JTextPane usageInstructions;
	
	JButton deleteCreatureButton;
	JButton deleteItemButton;
	JButton addItemButton;
	
	Selector roomSelector;
	CreatureSelector creatureSelector;
	ItemSelector itemSelector;
	AddBox addBox;
	
	public int selectedRoomID = 1;
	Vector<String> rooms = new Vector<String>();
	Vector<String> creaturesInRoom = new Vector<String>();
	Vector<String> itemsInRoom = new Vector<String>();
	Vector<String> allThatCanBeAddedToRoom = new Vector<String>();

//	static int armorsBegin = 0;
//	static int weaponsBegin = 0;
//	static int containersBegin = 0;
	
	static int itemsBegin = 0;
	
	public static DisplayThree getInstance() { 
        if (display == null) 
            display = new DisplayThree(); 
        return display; 
    } 
	
	private DisplayThree() {//FORMAT EVERYTHING CORRECTLY
		
		setLayout(null); 

		getContentPane().setBackground(new Color(230, 230, 230));;
		
		usageInstructions = new JTextPane();
		usageInstructions.setText(getInstructionString());
		usageInstructions.setBounds(INSTRUCTIONS_X, INSTRUCTIONS_Y, INSTRUCTIONS_WIDTH, INSTRUCTIONS_HEIGHT);
		usageInstructions.setBorder(new LineBorder(Color.BLACK));
		add(usageInstructions);


		rooms = DisplayThreeSQLHandler.getRooms();
		creaturesInRoom = DisplayThreeSQLHandler.getCreaturesInRoom(selectedRoomID);
		itemsInRoom = DisplayThreeSQLHandler.getItemsInRoom(selectedRoomID);
		allThatCanBeAddedToRoom = DisplayThreeSQLHandler.getAllThatCanBeAddedToRoom();

		roomSelector = new Selector(this, rooms);
		roomSelector.setBounds(ROOM_SELECTOR_X, SELECTOR_Y, SELECTOR_WIDTH, SELECTOR_HEIGHT);
		add(roomSelector);


		creatureSelector = new CreatureSelector(this, creaturesInRoom);
		creatureSelector.setBounds(C_SELECTOR_X, SELECTOR_Y, SELECTOR_WIDTH, SELECTOR_HEIGHT);
		add(creatureSelector);
		
		
		itemSelector = new ItemSelector(this, itemsInRoom);
		//itemSelector.setWhereNewItemTypesBegin(armorsBegin, weaponsBegin, containersBegin);
		itemSelector.setBounds(I_SELECTOR_X, SELECTOR_Y, SELECTOR_WIDTH, SELECTOR_HEIGHT);
		add(itemSelector);
		
		addBox = new AddBox(this, allThatCanBeAddedToRoom);
		addBox.setBounds(ADDING_BOX_X, ADDING_BOX_Y, ADDING_BOX_WIDTH, ADDING_BOX_HEIGHT);
		add(addBox);
		
		
		deleteCreatureButton = new JButton(" X "); //TODO: make it an image instead
		deleteCreatureButton.setBounds(C_DELETE_BUTTON_X, DELETE_BUTTON_Y, DELETE_BUTTON_WIDTH, DELETE_BUTTON_HEIGHT);
		deleteCreatureButton.addActionListener(this);
		add(deleteCreatureButton);

		deleteItemButton = new JButton(" X "); //TODO: make it an image instead
		deleteItemButton.setBounds(I_DELETE_BUTTON_X, DELETE_BUTTON_Y, DELETE_BUTTON_WIDTH, DELETE_BUTTON_HEIGHT);
		deleteItemButton.addActionListener(this);
		add(deleteItemButton);
		
		
		addItemButton = new AddButton("Add"); //TODO: make it an image instead
		addItemButton.setBounds(ADD_BUTTON_X, ADD_BUTTON_Y, ADD_BUTTON_DIAMETER, ADD_BUTTON_DIAMETER);
		addItemButton.addActionListener(this);
		add(addItemButton);
		
		
		setSize((int) WINDOW_WIDTH, (int) WINDOW_HEIGHT);
		setResizable(false);
		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == deleteCreatureButton) {

			creatureSelector.deleteSelectedAndRefresh();
									
		} else if (event.getSource() == deleteItemButton) {

			itemSelector.deleteSelectedAndRefresh();
									
		} else if (event.getSource() == addItemButton) {
			
			addBox.moveSelectedToRoom(selectedRoomID);
		}

	}
	
	public void changeSelectedRoom(int selectedRoom) {

		this.selectedRoomID = selectedRoom;
		
		creaturesInRoom = DisplayThreeSQLHandler.getCreaturesInRoom(selectedRoomID);
		creatureSelector.changeContentsToNewRoom(creaturesInRoom);
		
		itemsInRoom = DisplayThreeSQLHandler.getItemsInRoom(selectedRoomID);
		itemSelector.changeContentsToNewRoom(itemsInRoom);

	}
	
//	public void setAddBox(String type) {
//		addBox = null;
//
//		if (type == "generic") {
//			addBox = new AddBox("generic");
//		} else if (type == "armor") {
//			
//		} else if (type == "weapon") {
//			
//		} else if (type == "container") {
//			
//		} else {
//			System.out.println("delete this");
//		}
//	}
	
	public static void setWhereItemsStartInAddBox(int lineNum) {
		AddBox.itemsBegin = lineNum;
	}
	
	
	private String getInstructionString() {
		return "[instructions]";
	}

//	public static void setWhereNewItemTypesBegin(int itemType, int lineNum) {
//
//		if (itemType == 1) {
//			armorsBegin = lineNum;
//		} else if (itemType == 2) {
//			weaponsBegin = lineNum;
//		} else if (itemType == 3) {
//			containersBegin = lineNum;
//		}
//	}

}

//static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//public static final double WINDOW_HEIGHT = screenSize.getHeight() / 10;
//public static final double WINDOW_WIDTH = screenSize.getWidth() / 8;



/*
//JTextField f = new JTextField("You can select me");
////f.setEditable(false);
////f.setBorder(null);
//f.setForeground(UIManager.getColor("Label.foreground"));
//f.setFont(UIManager.getFont("Label.font"));
//JPanel j = new JPanel();
//
//j.setBounds(300, 50, 100, 200);
//
//j.setBackground(new Color(180,200,200));
//
//imageLabel = new JLabel("North");
//j.add(imageLabel);
//
//j.setLayout(new BoxLayout(j, BoxLayout.Y_AXIS));
//
//add(j);


JPanel p = new Selector();

add(p);


*/