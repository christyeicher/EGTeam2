package cafitnessclub.model.POJO.com;

public class Member {
	private int memberID;
	private String name;
	private String password;
	private int PIN;
	private String email;
	private String address;
	private Membership membership;
		
	public Member(int memberID, String name, String password, int pIN,
			String email, String address) {
		this.memberID = memberID;
		this.name = name;
		this.password = password;
		PIN = pIN;
		this.email = email;
		this.address = address;
	}
		
	public Member(String name, String password, int pIN, String email,
			String address) {
		this.name = name;
		this.password = password;
		PIN = pIN;
		this.email = email;
		this.address = address;
	}
	
	
	
	public Member(int memberID, String name, String email) {
		
		this.memberID = memberID;
		this.name = name;
		this.email = email;
	}

	public int getMemberID() {
		return memberID;
	}
	
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getPIN() {
		return PIN;
	}
	
	public void setPIN(int pIN) {
		PIN = pIN;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean memberCheck()
	{
		boolean result = true;
		if(this.email == null || this.name == null ||
				this.address == null || this.password == null)
			{
				
				return false;
			}
		return result;
	}
	
	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	@Override
	public String toString() {
		
		return "Member ID: " + memberID + "\n Name: " + name
				+ "\n PIN: " + PIN + "\n Email: "
				+ email + ",\n Address: " + address
				+ "\n Membership: " + membership;
	}
}
