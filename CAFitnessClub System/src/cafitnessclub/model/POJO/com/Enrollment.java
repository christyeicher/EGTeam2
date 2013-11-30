package cafitnessclub.model.POJO.com;

public class Enrollment {
	
	private int enrollmentID;
	private int classID;
	private int memberID;
	private Member member;
	private ClassObject clase;
	
	
	public Enrollment(int enrollmentID, int classID, int memberID){
		this.enrollmentID = enrollmentID;
		this.classID = classID;
		this.memberID = memberID;
	}
	
	public Enrollment(int enrollmentID, Member member, ClassObject clase)
	{
		this.enrollmentID = enrollmentID;
		this.member = member;
		this.clase = clase;
	}
	
	public Enrollment(int classID, int memberID){
		this.classID = classID;
		this.memberID = memberID;
	}
	
	public int getEnrollmentID(){
		return enrollmentID;
	}
	
	public int getClassID(){
		return classID;
	}
	
	public int getMemberID(){
		return memberID;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public ClassObject getClase() {
		return clase;
	}

	public void setClase(ClassObject clase) {
		this.clase = clase;
	}
	

}
