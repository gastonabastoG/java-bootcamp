
public class Architect {

	private Builder builder;

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public Hospital getHospital() {
		return builder.getHospital();
	}

	public void constructHouse() {
		builder.buildNewHospital();
		builder.buildArea();
		builder.buildMaterial();
		builder.buildQtyFloors();
	}

}
