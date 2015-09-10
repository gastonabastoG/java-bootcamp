
/** Abstract Builder */
public abstract class Builder {

	protected Hospital hospital;

	public Hospital getHospital() {
		return hospital;
	}

	public void buildNewHospital() {
		hospital = new Hospital(200,5,"Concrete");
	}

	public abstract void buildArea();

	public abstract void buildQtyFloors();

	public abstract void buildMaterial();

}
