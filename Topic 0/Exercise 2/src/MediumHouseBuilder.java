
public class MediumHouseBuilder implements HouseBuilder {
	
	private House house;
	
	public MediumHouseBuilder () {
		this.house = new House();
	}

	@Override
	public void buildRoofType() {
		this.house.setRoofType("shingle");
	}

	@Override
	public void buildfloorQuantity() {
		this.house.setFloorQuantity(2);
	}

	@Override
	public void buildRoomQuantity() {
		this.house.setRoomQuantity(4);
	}

	@Override
	public House getHouse() {
		return this.house;
	}
	
	

}
