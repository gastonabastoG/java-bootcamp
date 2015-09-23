
public class SmallHouseBuilder implements HouseBuilder {
	
	private House house;
	
	public SmallHouseBuilder() {
		house = new House();
	}
	
	@Override
	public void buildRoofType() {
		this.house.setRoofType("ceramic tiles");
	}

	@Override
	public void buildfloorQuantity() {
		this.house.setFloorQuantity(1);
		
	}

	@Override
	public void buildRoomQuantity() {
		this.house.setRoomQuantity(3);
	}

	@Override
	public House getHouse() {
		return this.house;
	}

}
