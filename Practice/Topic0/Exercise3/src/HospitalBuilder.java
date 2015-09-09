
/** Concrete Builder */
public class HospitalBuilder extends Builder {

	@Override
	public void buildArea() {
		hospital.setArea(20);
	}

	@Override
	public void buildQtyFloors() {
		hospital.setQtyFloors(1);
	}

	@Override
	public void buildMaterial() {
		hospital.setMaterial("Wood");
	}

}
