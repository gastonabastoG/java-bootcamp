
/** Director */
public class Architect {

	private Builder builder;

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public House getHouse() {
		return builder.getHouse();
	}

	public void constructHouse() {
		builder.buildNewHouse();
		builder.buildArea();
		builder.buildMaterial();
		builder.buildQtyFloors();
	}

}
