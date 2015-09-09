
/** Product */
public class House {

	private int area = 0;
	private int qtyFloors = 0;
	private String material = "";

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
		return "House @ area=" + area + ", qtyFloors=" + qtyFloors + ", material=" + material;
	}
}
