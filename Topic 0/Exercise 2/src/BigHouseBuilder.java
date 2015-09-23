
public class BigHouseBuilder implements HouseBuilder {
	
	private House house;
	
	public BigHouseBuilder() {
		this.house = new House();
	}

	@Override
	public void buildRoofType() {
		this.house.setRoofType("membrane");
	}

	@Override
	public void buildfloorQuantity() {
		this.house.setFloorQuantity(3);		
	}

	@Override
	public void buildRoomQuantity() {
		this.house.setRoomQuantity(6);
	}

	@Override
	public House getHouse() {
		return this.house;
	}

}
