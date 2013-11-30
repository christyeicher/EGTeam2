package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.POJO.com.Room;

public class Rooms {
	
	//Factory
	private static Room createRoom(ResultSet rs) throws SQLException
	{
		if(rs.next())
		{
			Room room = new Room (
					rs.getInt("roomID"),
					rs.getString("roomName"),
					rs.getInt("maxCapacity"));
			return room;
		}
		return null;
	}
	
	private static Room[] returnRoomArray(ResultSet rs) throws SQLException
	{
		Room[] rooms = new Room[50];
		int i = 0;
		while(rs.next())
		{					
			Room room = new Room(
					rs.getInt("roomID"),
					rs.getString("roomName"),
					rs.getInt("maxCapacity"));
			
			rooms[i] = room;
			i++;
		}
		return rooms;
	}		
	
	private static String[] returnRoomNames(ResultSet rs) throws SQLException
	{
		String[] rooms = new String[50];
		int i = 0;
		while(rs.next())
		{					
			Room room = new Room(
					rs.getInt("roomID"),
					rs.getString("roomName"),
					rs.getInt("maxCapacity"));
			
			rooms[i] = room.toNameString();
			i++;
		}
		return rooms;
	}
	
	//Select 	
	public static Room getRoomById(int id) throws SQLException
	   {
		   PreparedStatement st = null;
		   ResultSet rs = null;
		   String sqlQuery =
				   "SELECT * from Room where roomID = ?";
		   
		   st = Database.getConnection().prepareStatement(sqlQuery);
		   st.setInt(1, id);
		   rs = st.executeQuery();
		   return createRoom(rs);		   
	   }
	
	public static Room[] getAllRooms() throws SQLException{
		   Statement st = null;
		   ResultSet rs = null;
		   String sqlQuery =
				   "SELECT * from Room";
		   
		   st = Database.getConnection().prepareStatement(sqlQuery);
		   rs = st.executeQuery(sqlQuery);
		   return returnRoomArray(rs);
	}
	
	public static String[] getAllRoomNames() throws SQLException{
		Statement st = null;
		   ResultSet rs = null;
		   String sqlQuery =
				   "SELECT * from Room";
		   
		   st = Database.getConnection().prepareStatement(sqlQuery);
		   rs = st.executeQuery(sqlQuery);
		   return returnRoomNames(rs);
	}
}
