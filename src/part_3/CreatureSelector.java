//Joshua Burdette
package part_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Select box that fills with the creatures that are
 * in the selected room.
 */
public class CreatureSelector extends Selector
{
	
	/**
	 * String holds the ID of the currently selected creature.
	 */
	protected String selectedCreature = "";
	
	/**
	 * Constructor calls superclass constructor.
	 *
	 * @param frame          sets the frame that this JPanel will be part.
	 * @param thingsInColumn is the vector of creatures or items
	 *                       that will populate the buttons.
	 */
	public CreatureSelector(JFrame frame, Vector<String> thingsInColumn)
	{
		super(frame, thingsInColumn);
	}
	
	/**
	 * Overridden functionality includes removing the changing of
	 * selected room on button click and adding the ability to
	 * change the selected creature ID.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		DisplayThree.getInstance().addBox.changeContents("CREATURE", true);
		
		if (e.getSource() == upArrowButton)
		{
			scrollUp();
			
		} else if (e.getSource() == downArrowButton)
		{
			scrollDown();
			
		} else if (e.getSource() == middleButtons[0])
		{
			selectedCreature = thingsInColumn.get(itemsVisible[0]);
			
		} else if (e.getSource() == middleButtons[1])
		{
			selectedCreature = thingsInColumn.get(itemsVisible[1]);
			
		} else if (e.getSource() == middleButtons[2])
		{
			selectedCreature = thingsInColumn.get(itemsVisible[2]);
			
		} else if (e.getSource() == middleButtons[3])
		{
			selectedCreature = thingsInColumn.get(itemsVisible[3]);
		}
	}
	
	/**
	 * Called when the corresponding delete button is pressed. Removes
	 * the selected creature from the list removes it from the room
	 * in the database. Also changes selectedCreature and updates the
	 * buttons.
	 */
	public void deleteSelectedAndRefresh()
	{
		DisplayThreeSQLHandler.changeRoom("CREATURE", selectedCreature, -1);
		
		removeElement(thingsInColumn.indexOf(selectedCreature));
		
		selectedCreature = thingsInColumn.get(itemsVisible[buttonLastPressed]);
		
		DisplayThree.getInstance().addBox.changeContents("CREATURE", false);
		;
		
		this.updateButtons();
	}
	
	/**
	 * Called when a new room is selected in roomSelector. Changes
	 * creaturesInRoom to what is in the newly-selected room and
	 * resets selectedCreature and itemsVisible so that what is
	 * shown starts from the beginning.
	 *
	 * @param creaturesInRoom is the new vector of creatures in the
	 *                        newly-selected room.
	 */
	public void changeContentsToNewRoom(Vector<String> creaturesInRoom)
	{
		selectedCreature = creaturesInRoom.get(0);
		
		itemsVisible[0] = 0;
		itemsVisible[1] = 1;
		itemsVisible[2] = 2;
		itemsVisible[3] = 3;
		
		thingsInColumn = creaturesInRoom;
		
		updateButtons();
	}
	
	/**
	 * Adds a new creature to the room and adjusts everything
	 * according. Calls method to add the creature to the
	 * database as well.
	 *
	 * @param creature
	 */
	public void addCreatureToRoom(String creature)
	{
		thingsInColumn.add(creature);
		updateButtons();
		
		DisplayThreeSQLHandler.changeRoom("CREATURE", creature
						, DisplayThree.getInstance().selectedRoomID);
	}
}