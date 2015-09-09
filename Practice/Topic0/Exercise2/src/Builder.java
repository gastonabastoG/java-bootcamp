
/** Abstract Builder */
public abstract class Builder {

	protected House house;

	public House getHouse() {
		return house;
	}

	public void buildNewHouse() {
		house = new House();
	}

	public abstract void buildArea();

	public abstract void buildQtyFloors();

	public abstract void buildMaterial();

}
