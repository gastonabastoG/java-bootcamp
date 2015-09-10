
public abstract class Building {

	protected int area;
	protected int qtyFloors;
	protected String material;
			
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
		return "Building @ area=" + area + ", qtyFloors=" + qtyFloors + ", material=" + material;
	}
}
