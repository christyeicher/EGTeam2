package cafitnessclub.model.POJO.com;

import java.sql.Date;

public class Membership {
	private int msID;
	private int memberID;
	private String membershipType;
	private Date expiration;
	private int cost;
	private int numClassesAllowed;	
	
	public Membership(int msID, int memberID, String membershipType,
			Date expiration, int cost, int numClassesAllowed) {
		this.msID = msID;
		this.memberID = memberID;
		this.membershipType = membershipType;
		this.expiration = expiration;
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
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
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
		return "Membership [msID=" + msID + ", memberID=" + memberID
				+ ", membershipType=" + membershipType + ", expiration="
				+ expiration + ", cost=" + cost + ", numClassesAllowed="
				+ numClassesAllowed + "]";
	}
	
	
	
	
	

}
