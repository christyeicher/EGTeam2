package cafitnessclub.model.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
						rs.getInt("memberID"),
						rs.getString("membershipType"),
						rs.getDate("expiration"),
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
			 ResultSet rs = null;
			 String sqlQuery =
					   "INSERT INTO Membership (memberID, membershipType, expiration, "
					   + "cost, numClassesAllowed) values (?, ?, ?, ?, ?)";
			   
			 st = Database.getConnection().prepareStatement(sqlQuery);
			 st.setInt(1, membership.getMemberID());
			 st.setString(2, membership.getMembershipType());
			 st.setDate(3, membership.getExpiration());
			 st.setInt(4, membership.getCost());
			 st.setInt(5, membership.getNumClassesAllowed());
			 rs = st.executeQuery();
			
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
		         
//		         } finally {
//		            try {
//		               if (stmt != null)
//		                  stmt.close();
//		            } catch (SQLException se) {
//		               se.printStackTrace();
//		            }
//		         }
		      }

}
