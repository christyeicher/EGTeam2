package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.POJO.com.Membership;

public class Memberships {
	
	//Generate Models
		private static Membership createMembership(ResultSet rs) throws SQLException
		{
			if(rs.next())
			{
				Membership membership = new Membership(
						rs.getInt("msID"),
						rs.getInt("m_memberID"),
						rs.getString("membershipType"),
						rs.getDate("experation").toString(),
						rs.getInt("cost"),
						rs.getInt("numClassesAllowed"));
				return membership;
			}
			return null;
		}
		//Insert
		public static void insertMembership(Membership membership) throws SQLException
		{
			 PreparedStatement st = null;
			 //boolean rs = null;
			 String sqlQuery =
					   "INSERT INTO Membership (m_memberID, membershipType, experation, "
					   + "cost, numClassesAllowed) values (?, ?, ?, ?, ?)";
			 Date date = new Date(System.currentTimeMillis());
			 st = Database.getConnection().prepareStatement(sqlQuery);
			 st.setInt(1, membership.getMemberID());
			 st.setString(2, membership.getMembershipType());
			 st.setDate(3,date);
			 st.setInt(4, membership.getCost());
			 st.setInt(5, membership.getNumClassesAllowed());
			 //rs = st.execute();
			 st.execute();
			
		}
		
		// Delete
		public static void deleteMembership(Membership membership) throws SQLException
		{
			PreparedStatement st = null;
			 ResultSet rs = null;
			 String sqlQuery =
					   "DELETE from Membership where memberID = ?";
			   
			 st = Database.getConnection().prepareStatement(sqlQuery);
			 st.setInt(1, membership.getMemberID());
			 rs = st.executeQuery();
			
		}
		//Select Queries
		 public static Membership getMembershipByMemberID(int memberID) throws SQLException
		   {
			   PreparedStatement st = null;
			   ResultSet rs = null;
			   String sqlQuery =
					   "SELECT * from Membership where m_memberID = ?";
			   
			   st = Database.getConnection().prepareStatement(sqlQuery);
			   st.setInt(1, memberID);
			   rs = st.executeQuery();
			   return createMembership(rs);
			   
		   }
		 
		   // Update Queries
		   public static void updateMembership(Membership membership) throws SQLException
		   {
		         PreparedStatement stmt = null;
		         String updateString =
		            "UPDATE Membership SET membershipType = ?, experation = ?, "
		                 + "cost = ? where m_memberID = ?";
		            // update record
		         Date date = new Date(System.currentTimeMillis());
		            stmt = Database.getConnection().prepareStatement(updateString);
		            stmt.setString(1, membership.getMembershipType());
		            stmt.setDate(2, date);
		            stmt.setInt(3, membership.getCost());
		            stmt.setInt(4, membership.getMemberID());
		            stmt.execute();

		      }

}
