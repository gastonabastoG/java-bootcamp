
/** Concrete Builder */
public class BigHouseBuilder extends Builder {

	@Override
	public void buildArea() {
		house.setArea(100);
	}

	@Override
	public void buildQtyFloors() {
		house.setQtyFloors(3);
	}

	@Override
	public void buildMaterial() {
		house.setMaterial("Concrete");
	}

}
