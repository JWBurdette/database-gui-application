package part_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DisplayThreeSQLHandler {
	
	private static Connection connection;
	
//	public DisplayThreeSQLHandler() {}
	
	public static void setConnection(Connection c) {
		connection = c;
	}
	

	public static Vector<String> getRooms() {
		Vector<String> result = new Vector<String>();
			
        try {
        	
            String selectData = "SELECT * FROM LOCATION WHERE L_ID != -1";

            PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				
				String data = rs.getString("L_ID");//getNString(1);
				result.add(data);
			}

        } catch (SQLException e) {
        	e.printStackTrace();
        }
 
        return result;    
		

	}

	public static Vector<String> getCreaturesInRoom(int roomID) {
		Vector<String> result = new Vector<String>();

		
        try {
            String selectData = "CALL get_creatures(?)";

            PreparedStatement stmt = connection.prepareCall(selectData);
			stmt.setInt(1, roomID);
			stmt.execute();

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {

				String data = rs.getString("ID");
				result.add(data);

			}

        } catch (SQLException e) {
        	e.printStackTrace();
        }
 

        return result;        
		
	}
	

	public static Vector<String> getItemsInRoom(int roomID) {
		
		Vector<String> result = new Vector<String>();
		
        try {
	        String selectData = "SELECT * FROM ITEM WHERE L_ID = " + roomID;
	        PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				String data = rs.getString("ID");
				result.add(data);
			}
			
		
//			DisplayThree.setWhereNewItemTypesBegin(1, i);
//	        selectData = "SELECT a.A_ID FROM ARMOR as a, ITEM as i WHERE a.I_ID = i.ID and i.L_ID = " + roomID;
//	        stmt = connection.prepareStatement(selectData);
//			stmt.execute();
//			rs = stmt.getResultSet();
//			while (rs.next()) {
//				String data = rs.getString("A_ID");
//				result.add(data);
//				i++;
//			}
        } catch (SQLException e) {
        	e.printStackTrace();
        }
 

        return result; 
		
	}

	public static void setStoredProcedures() {
		
		try {
			
            String selectData = "DROP PROCEDURE IF EXISTS get_creatures";
            PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			
		
            selectData = "CREATE PROCEDURE get_creatures(IN n INT) BEGIN SELECT * FROM CREATURE WHERE L_ID = n; END";
            stmt = connection.prepareStatement(selectData);
			stmt.execute();
			
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void deleteCreature(String ID, int L_ID) {

		try {
			

			
	        String selectData = "DELETE FROM CREATURE WHERE ID = " + ID + " AND L_ID = " + L_ID;
	        PreparedStatement stmt = connection.prepareStatement(selectData);
			stmt.execute();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static Vector<String> getAllThatCanBeAddedToRoom() {
		
		Vector<String> result = new Vector<String>();
        String selectData = "SELECT * FROM CREATURE WHERE L_ID = -1";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(selectData);
		    stmt.execute();
		     
			ResultSet rs = stmt.getResultSet();
		    int i = 0;
		    while (rs.next()) {
		    	String data = rs.getString("ID");
		    	result.add(data);
		    	i++;
		    }
		    for (String s : result) {System.out.print(s + "  ");};
				
		    DisplayThree.setWhereItemsStartInAddBox(i);		
				
			selectData = "SELECT * FROM ITEM WHERE L_ID = -1";
			stmt = connection.prepareStatement(selectData);
		    stmt.execute();
				
		    rs = stmt.getResultSet();
		    while (rs.next()) {
		    	String data = rs.getString("ID");
		    	result.add(data);
		    }
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	    System.out.println();
	    System.out.println("yeeee");
	    System.out.println();


	    for (String s : result) {System.out.print(s + "  ");};

		 	
		return result;
	}


	public static void changeRoomOfCreature(String creatureID) {
		
		try {
						
	        String updateQuery = "UPDATE CREATURE SET L_ID = " + DisplayThree.getInstance().selectedRoomID + " WHERE ID = " + creatureID;
	        PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.execute();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
