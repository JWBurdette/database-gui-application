//Joshua Burdette
package part_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Select box that fills with list of all creatures or items that have
 * not been put in a room (L_ID = -1). Displays creatures or items
 * depending on what was last clicked in main window.
 *
 * @author Joshua Burdette
 */
public class AddBox extends Selector
{
	
	/**
	 * Instance variables to determine whether to display creatures or
	 * items, and keep track of the selected index and the last button
	 * that was pressed.
	 */
	String itemOrCreature = "CREATURE";
	public int selectedIndex = 0;
	private Boolean[] buttonLastPressed = {false, false, false, false};
	
	public AddBox(JFrame frame, Vector<String> thingsInColumn)
	{
		super(frame, thingsInColumn, DisplayThree.ADDING_BOX_WIDTH,
						DisplayThree.ADDING_BOX_HEIGHT, Color.WHITE);
	}
	
	/**
	 * Overridden functionality includes removing the changing of
	 * selected room on button click and changing the the way the
	 * last button pushed is kept track of.
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
			selectedIndex = itemsVisible[0];
			for (Boolean b : buttonLastPressed)
			{
				b = false;
			}
			buttonLastPressed[0] = true;
			
		} else if (e.getSource() == middleButtons[1])
		{
			selectedIndex = itemsVisible[1];
			for (Boolean b : buttonLastPressed)
			{
				b = false;
			}
			buttonLastPressed[1] = true;
			
		} else if (e.getSource() == middleButtons[2])
		{
			selectedIndex = itemsVisible[2];
			for (Boolean b : buttonLastPressed)
			{
				b = false;
			}
			buttonLastPressed[2] = true;
			
		} else if (e.getSource() == middleButtons[3])
		{
			selectedIndex = itemsVisible[3];
			for (Boolean b : buttonLastPressed)
			{
				b = false;
			}
			buttonLastPressed[3] = true;
		}
	}
	
	/**
	 * Calls methods to move the selected creature or
	 * item to the new room and remove it from the AddBox.
	 */
	public void moveSelectedToRoom()
	{
		addSelectedToRoom();
		removeElement(selectedIndex);
	}
	
	/**
	 * Changes the contents of the AddBox. Used both to refresh
	 * it when a new thing is added or to make it display a
	 * different type of entity.
	 *
	 * @param iOrC             is the type of entity to display instead of
	 *                         the current one
	 * @param checkIfUnchanged if false it will not check to
	 *                         see if a different type of entity needs to be displayed.
	 */
	public void changeContents(String iOrC, boolean checkIfUnchanged)
	{
		if (checkIfUnchanged && (itemOrCreature == iOrC))
		{
			return;
		}
		
		selectedIndex = 0;
		itemsVisible[0] = 0;
		itemsVisible[1] = 1;
		itemsVisible[2] = 2;
		itemsVisible[3] = 3;
		this.itemOrCreature = iOrC;
		
		if (iOrC == null)
		{
			thingsInColumn = DisplayThreeSQLHandler.getAllThatCanBeAddedToRoom(this.itemOrCreature);
		} else
		{
			thingsInColumn = DisplayThreeSQLHandler.getAllThatCanBeAddedToRoom(iOrC);
		}
		updateButtons();
		
		if (iOrC == "CREATURE")
		{
			DisplayThree.getInstance().addBoxLabel.setText("Add Creature");
		} else
		{
			DisplayThree.getInstance().addBoxLabel.setText("Add Item");
		}
	}
	
	
	/**
	 * Calls methods from DisplayThreeSQLHandler to move the selected
	 * entity to the selected room in the database.
	 */
	private void addSelectedToRoom()
	{
		if (itemOrCreature == "CREATURE")
		{
			DisplayThree.getInstance().creatureSelector
							.addCreatureToRoom(thingsInColumn.get(selectedIndex));
			
		} else if (itemOrCreature == "ITEM")
		{
			DisplayThree.getInstance().itemSelector
							.addItemToRoom(thingsInColumn.get(selectedIndex));
			
		} else
		{
			System.out.println("this is wrong");
		}
	}
}