
public class SmallHouseBuilder extends Builder {

	@Override
	public void buildArea() {
		house.setArea(20);
	}

	@Override
	public void buildQtyFloors() {
		house.setQtyFloors(1);
	}

	@Override
	public void buildMaterial() {
		house.setMaterial("Wood");
	}

}
