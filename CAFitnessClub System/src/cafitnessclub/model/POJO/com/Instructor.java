package cafitnessclub.model.POJO.com;

public class Instructor {
	
	private int instructorID;
	private String name;
	private String email;
	private String address;
	
	public Instructor(int instructorID, String name, String email,
			String address) {
		this.instructorID = instructorID;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public Instructor(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

//	@Override
//	public String toString() {
//		return "Name: " + name	+ "\nEmail: "
//				+ email + "\nAddress: " + address;
//	}
	
	@Override
	public String toString() {
		return name + " ";
	}
	
	public boolean instructorCheck()
	{
		boolean result = true;
		if(this.email == null || this.name == null ||
				this.address == null)
			{				
				return false;
			}
		
		return result;
	}
}
