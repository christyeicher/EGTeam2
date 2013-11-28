package cafitnessclub.model.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cafitnessclub.model.POJO.com.ClassObject;

public class Classes {
	
	private static ClassObject createClass(ResultSet rs) throws SQLException
	{
		if(rs.next())
		{
//			int roomID = rs.getInt("c_roomID");
//			Room room = Rooms.getRoomById(rs.getInt("c_roomID"));
			
			/*int instID = rs.getInt("c_instructorID");
			Instructor inst = Instructors.getInstructorById(rs.getInt("c_instructorID"));*/
			
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
		 public static void addClass(Class clase) throws SQLException{
			 	/*PreparedStatement st = null;
				String sqlQuery =
				"INSERT INTO Class (name, email, address) values (?, ?, ?)";
						   
				 st = Database.getConnection().prepareStatement(sqlQuery);
				 st.setString(1, instructor.getName());
				 st.setString(4, instructor.getEmail());
				 st.setString(5, instructor.getAddress());
				 st.execute();*/
		 }
}
