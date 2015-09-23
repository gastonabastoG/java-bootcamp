
public class House {
	
	
	private String roofType;
	private int floorQuantity;
	private int roomQuantity;
	
	
	
	public String getRoofType() {
		return roofType;
	}
	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}
	public int getFloorQuantity() {
		return floorQuantity;
	}
	public void setFloorQuantity(int floorQuantity) {
		this.floorQuantity = floorQuantity;
	}
	public int getRoomQuantity() {
		return roomQuantity;
	}
	public void setRoomQuantity(int roomsQuantity) {
		this.roomQuantity = roomsQuantity;
	}
	
	public String toString() {
		return "Roof type: " + this.roofType + " N° of floors: " +
				this.floorQuantity + " N° of rooms: " + this.roomQuantity;
	}
	

}
