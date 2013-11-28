package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cafitnessclub.model.POJO.com.Enrollment;
import cafitnessclub.model.POJO.com.Member;

public class Enrollments {
	//Generate Models
	public static Member createMember(ResultSet rs) throws SQLException
	{
		if(rs.next())
		{
			Member member = new Member (
					rs.getInt("memberID"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getInt("PIN"),
					rs.getString("email"),
					rs.getString("address"));
			return member;
		}
		return null;
	}
	
	//Insert
	
	
	//Select Queries
	 public static void insertEnrollment(Enrollment enrollment) throws SQLException
	   {
		   PreparedStatement st = null;
		   ResultSet rs = null;
		   String sqlQuery =
				   "INSERT into Enrollment (memberID, classID) values (?, ?)";
		   
		   st = Database.getConnection().prepareStatement(sqlQuery);
		  // st.setString(1, enrollment.getMember.get);
		   rs = st.executeQuery();
		   
	   }
	 
	   // Update Queries
	   public static void updateMember(Member member) throws SQLException
	   {
	         PreparedStatement stmt = null;
	         String updateString =
	            "UPDATE Member SET name = ?, password = ?, "
	                 + "PIN = ?, email = ?, address = ?";
	            // update record
	            stmt = Database.getConnection().prepareStatement(updateString);
	            stmt.setString(1, member.getName());
	            stmt.setString(2, member.getPassword());
	            stmt.setInt(3, member.getPIN());
	            stmt.setString(4, member.getEmail());
	            stmt.setString(5, member.getAddress());
	            stmt.execute();
	         
//	         } finally {
//	            try {
//	               if (stmt != null)
//	                  stmt.close();
//	            } catch (SQLException se) {
//	               se.printStackTrace();
//	            }
//	         }
	      }

	   
 }



