
public class Hospital extends Building {

	// Constructor1
	public Hospital(int area, int qtyFloors, String material) {
		this.area = area;
		this.qtyFloors = qtyFloors;
		this.material = material;
	}

	@Override
	public String toString() {
		return "Hospital @ area=" + area + ", qtyFloors=" + qtyFloors + ", material=" + material;
	}

}
