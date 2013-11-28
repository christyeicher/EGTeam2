package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
