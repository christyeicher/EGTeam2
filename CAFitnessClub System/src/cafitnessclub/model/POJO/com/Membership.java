package cafitnessclub.model.POJO.com;

import java.sql.Date;

public class Membership {
	private int msID;
	private int memberID;
	private String membershipType;
	private String expiration;
	private int cost;
	private int numClassesAllowed;	
	
	public Membership(int msID, int memberID, String membershipType,
			String expiration, int cost, int numClassesAllowed) {
		this.msID = msID;
		this.memberID = memberID;
		this.membershipType = membershipType;
		this.expiration = expiration;
		this.cost = cost;
		this.numClassesAllowed = numClassesAllowed;
	}
	public Membership(int memberID, String membershipType,
			int cost, int numClassesAllowed) {
		
		this.memberID = memberID;
		this.membershipType = membershipType;
		this.cost = cost;
		this.numClassesAllowed = numClassesAllowed;
	}
	public int getMsID() {
		return msID;
	}
	public void setMsID(int msID) {
		this.msID = msID;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getNumClassesAllowed() {
		return numClassesAllowed;
	}
	public void setNumClassesAllowed(int numClassesAllowed) {
		this.numClassesAllowed = numClassesAllowed;
	}
	@Override
	public String toString() {
		return "Membership ID =" + msID + ", \n"
				+ "member ID =" + memberID
				+ ", \n Membership Type =" + membershipType + ",\n Expiration ="
				+ expiration + ", \n cost =" + cost + ", \n Number Of Classes Left ="
				+ numClassesAllowed;
	}
	
	
	
	
	

}
