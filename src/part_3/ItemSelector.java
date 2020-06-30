//Joshua Burdette
package part_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Select box that fills with the items that are
 * in the selected room.
 *
 * @author Joshua Burdette
 */
public class ItemSelector extends Selector
{
	/**
	 * String holds the ID of the currently selected item.
	 */
	protected String selectedItem = "";
	
	/**
	 * Constructor calls superclass constructor.
	 *
	 * @param frame          sets the frame that this JPanel will be part.
	 * @param thingsInColumn is the vector of creatures or items
	 *                       that will populate the buttons.
	 */
	public ItemSelector(JFrame frame, Vector<String> thingsInColumn)
	{
		super(frame, thingsInColumn);
	}
	
	/**
	 * Overridden functionality includes removing the changing of
	 * selected room on button click and adding the ability to
	 * change the selected item ID.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		DisplayThree.getInstance().addBox.changeContents("ITEM", true);
		
		if (e.getSource() == upArrowButton)
		{
			scrollUp();
			
		} else if (e.getSource() == downArrowButton)
		{
			scrollDown();
			
		} else if (e.getSource() == middleButtons[0])
		{
			selectedItem = thingsInColumn.get(itemsVisible[0]);
			
		} else if (e.getSource() == middleButtons[1])
		{
			selectedItem = thingsInColumn.get(itemsVisible[1]);
			
		} else if (e.getSource() == middleButtons[2])
		{
			selectedItem = thingsInColumn.get(itemsVisible[2]);
			
		} else if (e.getSource() == middleButtons[3])
		{
			selectedItem = thingsInColumn.get(itemsVisible[3]);
		}
	}
	
	/**
	 * Called when the corresponding delete button is pressed. Removes
	 * the selected item from the list removes it from the room
	 * in the database. Also changes selectedItem and updates the
	 * buttons.
	 */
	public void deleteSelectedAndRefresh()
	{
		DisplayThreeSQLHandler.changeRoom("ITEM", selectedItem, -1);
		
		removeElement(thingsInColumn.indexOf(selectedItem));
		
		DisplayThree.getInstance().addBox.changeContents("ITEM", false);
		
		this.updateButtons();
	}
	
	/**
	 * Called when a new room is selected in roomSelector. Changes
	 * itemsInRoom to what is in the newly-selected room and
	 * resets selectedItem and itemsVisible so that what is
	 * shown starts from the beginning.
	 *
	 * @param itemsInRoom is the new vector of items in the
	 *                    newly-selected room.
	 */
	public void changeContentsToNewRoom(Vector<String> itemsInRoom)
	{
		selectedItem = itemsInRoom.get(0);
		
		itemsVisible[0] = 0;
		itemsVisible[1] = 1;
		itemsVisible[2] = 2;
		itemsVisible[3] = 3;
		
		thingsInColumn = itemsInRoom;
		
		updateButtons();
	}
	
	/**
	 * Adds a new item to the room and adjusts everything
	 * according. Calls method to add the item to the
	 * database as well.
	 *
	 * @param item
	 */
	public void addItemToRoom(String item)
	{
		thingsInColumn.add(item);
		updateButtons();
		
		DisplayThreeSQLHandler.changeRoom("ITEM", item
						, DisplayThree.getInstance().selectedRoomID);
	}
}