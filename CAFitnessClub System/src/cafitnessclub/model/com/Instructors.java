package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.POJO.com.Instructor;
import cafitnessclub.model.POJO.com.Room;

public class Instructors {
	
	//Factory
		private static Instructor createInstructor(ResultSet rs) throws SQLException
		{
			if(rs.next())
			{
				Instructor instructor= new Instructor (
						rs.getInt("InstructorID"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("address"));
				return instructor;
			}
			return null;
		}
		
		private static Instructor[] returnInstructorArray(ResultSet rs) throws SQLException
		{
			Instructor[] instructors = new Instructor[50];
			int i = 0;
			while(rs.next())
			{					
				Instructor instructor = new Instructor(
						rs.getInt("instructorID"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("address"));
				
				instructors[i] = instructor;
				i++;
			}
			return instructors;
		}		
		
		private static String[] returnInstructorNames(ResultSet rs) throws SQLException
		{
			String[] instructors = new String[50];
			int i = 0;
			while(rs.next())
			{					
				Instructor instructor = new Instructor(
						rs.getInt("instructorID"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("address"));
				
				instructors[i] = instructor.toNameString();
				i++;
			}
			return instructors;
		}
		
	//Select 		
		public static Instructor getInstructorById(int id) throws SQLException
		   {
			   PreparedStatement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Instructor where instructorID = ?";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   st.setInt(1, id);
			   rs = st.executeQuery();
			   return createInstructor(rs);			   
		   }
		
		public static Instructor getInstructorByEmail(String email) throws SQLException
		   {
			   PreparedStatement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Instructor where email = ?";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   st.setString(1, email);
			   rs = st.executeQuery();
			   return createInstructor(rs);			   
		   }
		
		public static Instructor[] getAllInstructors() throws SQLException{
			   Statement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Instructor";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   rs = st.executeQuery(sqlQuery);
			   return returnInstructorArray(rs);
		}
		
		public static String[] getAllInstructorNames() throws SQLException{
			Statement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Instructor";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   rs = st.executeQuery(sqlQuery);
			   return returnInstructorNames(rs);
		}
	
	// Update
		public static void updateInstructor(Instructor instructor) throws SQLException{
			PreparedStatement stmt = null;
	         String updateString =
	            "UPDATE Instructor SET name = ?, email = ?, address = ?"
	                 + "where instructorID = ?";
	            // update record
	            stmt = Database.getConnection().prepareStatement(updateString);
	            stmt.setString(1, instructor.getName());
	            stmt.setString(2, instructor.getEmail());
	            stmt.setString(3, instructor.getAddress());
	            stmt.setInt(4, instructor.getInstructorID());
	            stmt.execute();
		}
		
	// Delete
		public static void deleteInstructor(Instructor instructor) throws SQLException{
			PreparedStatement st = null;
			 String sqlQuery =
					   "DELETE from Instructor where InstructorID = ?";
			   
			 st = Database.getConnection().prepareStatement(sqlQuery);
			 st.setInt(1, instructor.getInstructorID());
			 st.execute();
		}
		
	// Insert
		public static void insertInstructor(Instructor instructor) throws SQLException{
			PreparedStatement st = null;
			String sqlQuery =
			"INSERT INTO Instructor (name, email, address) values (?, ?, ?)";
					   
			 st = Database.getConnection().prepareStatement(sqlQuery);
			 st.setString(1, instructor.getName());
			 st.setString(2, instructor.getEmail());
			 st.setString(3, instructor.getAddress());
			 st.execute();
		}
}
