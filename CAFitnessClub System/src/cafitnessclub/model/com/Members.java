package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.POJO.com.Membership;

public class Members {
	//Generate Models
	private static Member createMember(ResultSet rs) throws SQLException
	{
		Membership membership = null;
		if(rs.next())
		{
			Member member = new Member (
					rs.getInt("memberID"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getInt("PIN"),
					rs.getString("email"),
					rs.getString("address"));
			
			// we need to fetch the member's membership
			membership = Memberships.getMembershipByMemberID(member.getMemberID());
			if(membership != null)
			{
				member.setMembership(membership);
			}
			return member;
		}
		return null;
	}
	
	private static ArrayList<Member> createMembers(ResultSet rs) throws SQLException{
		ArrayList<Member> members = new ArrayList<Member>();
		while(rs.next())
		{
			Member member = new Member (
					rs.getInt("memberID"),
					rs.getString("name"),
					rs.getString("email"));
			
			
			members.add(member);
			
		}
		return members;
			
	}
	//Select Queries
	 	public static Member getMemberByEmail(String email) throws SQLException
	   {
		   PreparedStatement st = null;
		   ResultSet rs = null;
		   String sqlQuery =
				   "SELECT * from Member where email = ?";
		   
		   st = Database.getConnection().prepareStatement(sqlQuery);
		   st.setString(1, email);
		   rs = st.executeQuery();
		   return createMember(rs);
		   
	   }
	 
	// Update Queries
	   public static void updateMember(Member member) throws SQLException
	   {
	         PreparedStatement stmt = null;
	         String updateString =
	            "UPDATE Member SET name = ?, password = ?, "
	                 + "PIN = ?, email = ?, address = ?"
	                 + "where memberID = ?";
	            // update record
	            stmt = Database.getConnection().prepareStatement(updateString);
	            stmt.setString(1, member.getName());
	            stmt.setString(2, member.getPassword());
	            stmt.setInt(3, member.getPIN());
	            stmt.setString(4, member.getEmail());
	            stmt.setString(5, member.getAddress());
	            stmt.setInt(6, member.getMemberID());
	            stmt.execute();
	         
	      }
	   
	   public static ArrayList<Member> getClassRoster(int classID) throws SQLException{
		
			 PreparedStatement st = null;
			 ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Member, Enrollment where Enrollment.e_classID = ? "
					   + "AND Member.memberID = Enrollment.e_memberID";
			  
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   st.setInt(1, classID);
			   rs = st.executeQuery();
			   return createMembers(rs);
			
			
		}
	   
	// Delete
		public static void deleteMember(Member member) throws SQLException
		{
				PreparedStatement st = null;
				 //ResultSet rs = null;
				 String sqlQuery =
						   "DELETE from Member where memberID = ?";
				   
				 st = Database.getConnection().prepareStatement(sqlQuery);
				 st.setInt(1, member.getMemberID());
				 st.execute();				
		}
	
	//Insert
		public static void insertMember(Member member) throws SQLException
		{
			PreparedStatement st = null;
			//ResultSet rs = null;
			String sqlQuery =
			"INSERT INTO Member (name, password, PIN, email, address) values (?, ?, ?, ?, ?)";
					   
			 st = Database.getConnection().prepareStatement(sqlQuery);
			 st.setString(1, member.getName());
			 st.setString(2, member.getPassword());
			 st.setInt(3, member.getPIN());
			 st.setString(4, member.getEmail());
			 st.setString(5, member.getAddress());
			 st.execute();					
		}   
 }