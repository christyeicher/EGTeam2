package cafitnessclub.model.POJO.com;

public class Room {
	
	private int roomID;
	private String roomName;
	private int maxCapacity;
	
	
	public Room(int roomID, String roomName, int maxCapacity) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.maxCapacity = maxCapacity;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	@Override
	public String toString() {
		return "\n Room [roomID=" + roomID + ", roomName=" + roomName
				+ ", maxCapacity=" + maxCapacity + "]";
	}
	
	
	
	

}
