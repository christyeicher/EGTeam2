package cafitnessclub.model.POJO.com;

import java.sql.Time;

public class ClassObject {
	
	private int classID;
	private String name;
	private Time startTime;
	private Time endTime;
	private Instructor instructor;
	private Room room;
	
	public ClassObject(int classID, String name, Time startTime, Time endTime,
			Instructor instructor, Room room) {
		
		this.classID = classID;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instructor = instructor;
		this.room = room;
	}
	public ClassObject(String name, Time startTime, Time endTime,
			Instructor instructor, Room room) {
		
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instructor = instructor;
		this.room = room;
	}

	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "ClassObject [classID=" + classID + ", name=" + name
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", instructor=" + instructor + ", room=" + room + "]";
	}
	
	
	
	
	
	
	
	

}
