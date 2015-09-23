
public class HouseDirector {
	
	private HouseBuilder houseBuilder = null;
	
	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}
	
	public void constructHouse() {
		houseBuilder.buildfloorQuantity();
		houseBuilder.buildRoofType();
		houseBuilder.buildRoomQuantity();
	}
	
	public House getHouse() {
		return this.houseBuilder.getHouse();
	}

}
