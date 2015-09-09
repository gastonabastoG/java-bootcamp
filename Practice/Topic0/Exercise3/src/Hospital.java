/** Product */
public class Hospital implements Build {

	private int area = 0;
	private int qtyFloors = 0;
	private String material = "";

	// Constructor1
	public Hospital() {
	}

	// Constructor2
	public Hospital(int area, int qtyFloors, String material) {
		this.area = area;
		this.qtyFloors = qtyFloors;
		this.material = material;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public void setQtyFloors(int qtyFloors) {
		this.qtyFloors = qtyFloors;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String toString() {
		return "Hospital @ area=" + area + ", qtyFloors=" + qtyFloors + ", material=" + material;
	}

}
