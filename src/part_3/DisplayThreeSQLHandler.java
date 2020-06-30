//Joshua Burdette
package part_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Static class that handles all of the SQL for Display 3.
 *
 * @author Joshua Burdette
 */
public class DisplayThreeSQLHandler
{
	/**
	 * Variable holds the database connection.
	 */
	private static Connection connection;
	
	/**
	 * Sets the database connection.
	 */
	public static void setConnection(Connection c)
	{
		connection = c;
	}
	
	/**
	 * Gets all of the rooms from the database (except -1) from the
	 * database and returns a vector of them.
	 */
	public static Vector<String> getRooms()
	{
		Vector<String> result = new Vector<String>();
		
		try
		{
			String selectData = "SELECT * FROM LOCATION WHERE L_ID != -1";
			
			PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next())
			{
				String data = rs.getString("L_ID");//getNString(1);
				result.add(data);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Gets all creatures in the current room from the database and
	 * returns them as a vector.
	 *
	 * @param roomID
	 */
	public static Vector<String> getCreaturesInRoom(int roomID)
	{
		Vector<String> result = new Vector<String>();
		
		try
		{
			String selectData = "CALL get_creatures(?)";
			
			PreparedStatement stmt = connection.prepareCall(selectData);
			stmt.setInt(1, roomID);
			stmt.execute();
			
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next())
			{
				String data = rs.getString("ID");
				result.add(data);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Gets all creatures in the current room from the database and
	 * returns them as a vector.
	 */
	public static Vector<String> getItemsInRoom(int roomID)
	{
		Vector<String> result = new Vector<String>();
		
		try
		{
			String selectData = "SELECT * FROM ITEM WHERE L_ID = " + roomID;
			PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next())
			{
				String data = rs.getString("ID");
				result.add(data);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Creates a stored procedure to get all creatures
	 * in a specified room.
	 */
	public static void setStoredProcedures()
	{
		try
		{
			String selectData = "DROP PROCEDURE IF EXISTS get_creatures";
			PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			
			selectData = "CREATE PROCEDURE get_creatures(IN n INT) BEGIN SELECT * FROM CREATURE WHERE L_ID = n; END";
			stmt = connection.prepareStatement(selectData);
			stmt.execute();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}


//	public static void deleteCreature(String ID, int L_ID)     UNUSED
//	{
//		try 
//		{	
//	        String selectData = "DELETE FROM CREATURE WHERE ID = " + ID + " AND L_ID = " + L_ID;
//	        PreparedStatement stmt = connection.prepareStatement(selectData);
//			stmt.execute();
//
//		} catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * Selects all creatures or items (depending on what is
	 * passed in) that are not in any room (L_ID = -1).
	 */
	public static Vector<String> getAllThatCanBeAddedToRoom(String type)
	{
		Vector<String> result = new Vector<String>();
		String selectData = "SELECT * FROM " + type + " WHERE L_ID = -1";
		
		try
		{
			PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next())
			{
				String data = rs.getString("ID");
				result.add(data);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Changes the L_ID of a creature or item.
	 *
	 * @param type                   is CREATURE or ITEM.
	 * @param selectedCreatureOrItem is the ID of the entity to move.
	 * @param selectedRoomID         is the room that is currently selected
	 *                               in the room selector.
	 */
	public static void changeRoom(String type, String selectedCreatureOrItem, int selectedRoomID)
	{
		try
		{
			String updateQuery = "UPDATE " + type + " SET L_ID = " + selectedRoomID + " WHERE ID = " + selectedCreatureOrItem;
			System.out.println(updateQuery);
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.execute();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
