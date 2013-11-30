package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.POJO.com.Instructor;
import cafitnessclub.model.POJO.com.Room;

public class Classes {
	
	private static ClassObject createClass(ResultSet rs) throws SQLException
	{
		if(rs.next())
		{			
			ClassObject clase = new ClassObject(
					rs.getInt("classID"),
					rs.getString("name"),
					rs.getTime("startTime"),
					rs.getTime("endTime"),
					Instructors.getInstructorById(rs.getInt("c_instructorID")),
					Rooms.getRoomById(rs.getInt("c_roomID")));
			return clase;
		}
		return null;
	}
	
	private static ArrayList<ClassObject> createClasses(ResultSet rs) throws SQLException
	{
		ArrayList<ClassObject> classes = new ArrayList<ClassObject>();
		while(rs.next())
		{
			
			ClassObject clase = new ClassObject(
					rs.getInt("classID"),
					rs.getString("name"),
					rs.getTime("startTime"),
					rs.getTime("endTime"),
					Instructors.getInstructorById(rs.getInt("c_instructorID")),
					Rooms.getRoomById(rs.getInt("c_roomID")));
			
			classes.add(clase);
		}
		return classes;
	}
	
	//Select Queries
		public static ClassObject getClass(int id) throws SQLException
		{
			PreparedStatement st = null;
			ResultSet rs = null;
			String sqlQuery =
					   "SELECT * from Class where classID = ?";
			 st = Database.getConnection().prepareStatement(sqlQuery);
			 st.setInt(1, id);
			 rs = st.executeQuery();
			 return createClass(rs);
			 
			
		}
		 public static ArrayList<ClassObject> getClasses() throws SQLException
		   {
			   Statement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Class order by startTime;";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   rs = st.executeQuery(sqlQuery);
			   return createClasses(rs);			   
		   }
		 
		 public static ArrayList<ClassObject> getClassesByRoom() throws SQLException{
			 Statement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Class order by c_roomID;";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   rs = st.executeQuery(sqlQuery);
			   return createClasses(rs);
		 }
		 
		 public static ArrayList<ClassObject> getClassesByInstructor() throws SQLException{
			 Statement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Class order by c_instructorID;";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   rs = st.executeQuery(sqlQuery);
			   return createClasses(rs);
		 }

	// Insert Query
		 public static void addClass(ClassObject clase, Instructor instructor, Room room) throws SQLException{
			 	PreparedStatement st = null;
				String sqlQuery =
				"INSERT INTO Class (name, startTime, endTime, c_instructorID, c_roomID) values (?, ?, ?, ?, ?)";
						   
				 st = Database.getConnection().prepareStatement(sqlQuery);
				 st.setString(1, clase.getName());
				 st.setTime(2, clase.getStartTime());
				 st.setTime(3, clase.getEndTime());
				 st.setInt(4, instructor.getInstructorID());
				 st.setInt(5, room.getRoomID());
				 st.execute();
		 }
		 public static void updateClass(ClassObject clase, Instructor instructor, Room room) throws SQLException{
			 	PreparedStatement st = null;
			 	System.out.println("Instructor ID: " + instructor.getInstructorID());
			 	System.out.println("Room ID: " + room.getRoomID());
			 	
				String sqlQuery =
				"UPDATE Class SET name = ?, startTime = ?, endTime = ?, "
				+ "c_instructorID = ?, c_roomID = ? where classID = ?";
						   
				 st = Database.getConnection().prepareStatement(sqlQuery);
				 st.setString(1, clase.getName());
				 st.setTime(2, clase.getStartTime());
				 st.setTime(3, clase.getEndTime());
				 st.setInt(4, instructor.getInstructorID());
				 st.setInt(5, room.getRoomID());
				 st.setInt(6,  clase.getClassID());
				 st.execute();
		 }

	// Delete Query
		 public static void deleteClass(int classID) throws SQLException{
			 	PreparedStatement st = null;
				String sqlQuery =
				"delete from class where classID = ?;";
						   
				 st = Database.getConnection().prepareStatement(sqlQuery);
				 st.setInt(1, classID);
				 st.execute();
		 }
}
