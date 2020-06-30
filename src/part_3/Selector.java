//Joshua Burdette
package part_3;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Displays a box with scroll arrows. Allows the user to scroll
 * through a list of entities passed in as a vector.
 *
 * @author Joshua Burdette
 */
class Selector extends JPanel implements ActionListener
{
	
	/**
	 * Integers that store the width and height of the selector.
	 */
	public int WIDTH;
	public int HEIGHT;
	
	/**
	 * JButtons that store the up and down buttons and the buttons
	 * that hold the entities in the list.
	 */
	protected JButton[] middleButtons = new JButton[4];
	JButton upArrowButton, downArrowButton;
	
	/**
	 * Variables to record which entities in the list should be
	 * visible, which room is selected, and what was the last button
	 * that was pressed.
	 */
	protected int[] itemsVisible = {0, 1, 2, 3};
	protected static int selectedRoom;
	protected int buttonLastPressed;
	
	/**
	 * Vector that stores the things in the database
	 * column that is passed in.
	 */
	protected Vector<String> thingsInColumn;
	
	/**
	 * Constructor that adds all buttons to JPanel and passes in the
	 * vector that will be used to populate it.
	 *
	 * @param frame          is the JFrame that the selector will be in.
	 * @param thingsInColumn is the list of things in database
	 *                       that are passed in.
	 */
	public Selector(JFrame frame, Vector<String> thingsInColumn)
	{
		this.thingsInColumn = thingsInColumn;
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setDimensions();
		
		this.addUpArrow();
		
		this.assignColumnItemsToButton();
		for (JButton j : middleButtons)
		{
			this.add(j);
		}
		
		this.addDownArrow();
		
		this.setLayout(null);
		this.setBorder(new LineBorder(Color.BLACK));
	}
	
	/**
	 * Alternative constructor that exists so that AddBox can change
	 * the width, height, and color when it extends it.
	 *
	 * @param frame
	 * @param thingsInColumn
	 * @param width
	 * @param height
	 * @param color
	 */
	public Selector(JFrame frame, Vector<String> thingsInColumn, int width, int height, Color color)
	{
		this.thingsInColumn = thingsInColumn;
		this.setBackground(color);
		
		WIDTH = width;
		HEIGHT = height;
		
		this.addUpArrow();
		
		this.assignColumnItemsToButton();
		
		for (JButton j : middleButtons)
		{
			this.add(j);
		}
		
		this.addDownArrow();
		
		this.setLayout(null);
		
		this.setBorder(new LineBorder(Color.BLACK));
	}
	
	
	/**
	 * Sets the width and height of the selector.
	 */
	protected void setDimensions()
	{
		WIDTH = DisplayThree.SELECTOR_WIDTH;
		HEIGHT = DisplayThree.SELECTOR_HEIGHT;
	}
	
	/**
	 * Creates up arrow and adds it.
	 */
	private void addUpArrow()
	{
		Image upArrow = new ImageIcon("img/UpArrow.PNG").getImage()
														.getScaledInstance((int) (WIDTH), HEIGHT / 7, Image.SCALE_SMOOTH);
		
		upArrowButton = new JButton();
		upArrowButton.setSize(WIDTH, HEIGHT / 8);
		upArrowButton.setBorder(new LineBorder(Color.BLACK));
		upArrowButton.setIcon(new ImageIcon(upArrow));
		upArrowButton.setLocation(0, 0);
		upArrowButton.addActionListener(this);
		
		this.add(upArrowButton);
	}
	
	/**
	 * Creates down arrow and adds it.
	 */
	private void addDownArrow()
	{
		Image downArrow = new ImageIcon("img/downArrow.PNG").getImage()
															.getScaledInstance((int) (WIDTH), HEIGHT / 7, Image.SCALE_SMOOTH);
		
		downArrowButton = new JButton();
		downArrowButton.setSize(WIDTH, HEIGHT / 8);
		downArrowButton.setBorder(new LineBorder(Color.BLACK));
		downArrowButton.setIcon(new ImageIcon(downArrow));
		downArrowButton.setLocation(0, HEIGHT - downArrowButton.getHeight());
		downArrowButton.addActionListener(this);
		
		this.add(downArrowButton);
	}
	
	/**
	 * Associates each of the 4 middle buttons with the appropriate
	 * entity in thingsInColumn.
	 */
	protected void assignColumnItemsToButton()
	{
		for (int i = 0; i < middleButtons.length; i++)
		{
			if (i >= thingsInColumn.size())
			{
				middleButtons[i] = new JButton("");
				middleButtons[i].setVisible(false);
				middleButtons[i].setEnabled(false);
				
			} else
			{
				middleButtons[i] = new JButton(thingsInColumn.get(i));//thingsInColumn.get(i)
			}
			middleButtons[i].addActionListener(this);
			middleButtons[i].setContentAreaFilled(false);
			middleButtons[i].setBorderPainted(false);
			middleButtons[i].setOpaque(false);
			middleButtons[i].setSize(WIDTH, HEIGHT / 8);
			middleButtons[i].setLocation(0, upArrowButton.getHeight() +
																							(i * ((HEIGHT - (upArrowButton.getHeight() * 2)) / 4) + 2));
		}
	}
	
	/**
	 * Performs actions based on which button is pressed. If the
	 * source is the up or down arrows, it will scroll up or down.
	 * If it is one of the middle buttons, it will change the selected
	 * room and call methods in DisplayThree to change what is in
	 * the other selectors.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == upArrowButton)
		{
			scrollUp();
			
		} else if (e.getSource() == downArrowButton)
		{
			scrollDown();
			
		} else if (e.getSource() == middleButtons[0])
		{
			buttonLastPressed = 0;
			selectedRoom = Integer.parseInt(thingsInColumn.get(itemsVisible[0]));
			DisplayThree.getInstance().changeSelectedRoom(Integer
																														.parseInt(thingsInColumn.get(itemsVisible[0])));
			
		} else if (e.getSource() == middleButtons[1])
		{
			buttonLastPressed = 1;
			selectedRoom = Integer.parseInt(thingsInColumn.get(itemsVisible[1]));
			DisplayThree.getInstance().changeSelectedRoom(Integer
																														.parseInt(thingsInColumn.get(itemsVisible[1])));
			
		} else if (e.getSource() == middleButtons[2])
		{
			buttonLastPressed = 2;
			selectedRoom = Integer.parseInt(thingsInColumn.get(itemsVisible[2]));
			DisplayThree.getInstance().changeSelectedRoom(Integer
																														.parseInt(thingsInColumn.get(itemsVisible[2])));
			
		} else if (e.getSource() == middleButtons[3])
		{
			buttonLastPressed = 3;
			selectedRoom = Integer.parseInt(thingsInColumn.get(itemsVisible[3]));
			DisplayThree.getInstance().changeSelectedRoom(Integer
																														.parseInt(thingsInColumn.get(itemsVisible[3])));
		}
	}
	
	/**
	 * Changes the items that are visible to what they would
	 * be if they were all moved down.
	 */
	protected void scrollUp()
	{
		if (thingsInColumn.size() <= 4)
		{
			return;
		}
		
		if (itemsVisible[0] != 0)
		{
			for (int i = 0; i < itemsVisible.length; i++)
			{
				itemsVisible[i]--;
			}
			
			for (int i = 0; i <= 3; i++)
			{
				middleButtons[i].setText(thingsInColumn.get(itemsVisible[i]));
			}
		}
	}
	
	/**
	 * Changes the items that are visible to what they would
	 * be if they were all moved up.
	 */
	protected void scrollDown()
	{
		if (itemsVisible[3] != thingsInColumn.size() - 1)
		{
			for (int i = 0; i < itemsVisible.length; i++)
			{
				itemsVisible[i]++;
			}
			
			for (int i = 0; i <= 3; i++)
			{
				//TODO: if (itemsVisible.length >= 3) {}      //add ability to display less than 4 items correctly
				middleButtons[i].setText(thingsInColumn.get(itemsVisible[i]));
			}
		}
	}
	
	/**
	 * Changes the text of the middle buttons to match up with
	 * what items are visible.
	 */
	public void updateButtons()
	{
		for (int i = 0; i < middleButtons.length; i++)
		{
			middleButtons[i].setVisible(true);
			
			if (i < thingsInColumn.size())
			{
				middleButtons[i].setText(thingsInColumn.get(itemsVisible[i]));
			} else
			{
				middleButtons[i].setText("");
				middleButtons[i].setVisible(false);
			}
		}
	}
	
	/**
	 * Removes the element at the specified index in thingsInColumn.
	 */
	public void removeElement(int indexToRemove)
	{
		if (thingsInColumn.size() > indexToRemove)
		{
			thingsInColumn.removeElementAt(indexToRemove);
			
			updateButtons();
		}
	}
}
