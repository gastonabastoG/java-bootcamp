
public class Hospital { 
	//Had to make the class not abstract (it should be)
	//so i could use it as the base for both the factory and the builder
	private String name;
	private int departmentQuantity;
	private int bedQuantity;
	private String fundedBy;
	private double sqFeet;
	private int ambulanceQuantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentQuantity() {
		return departmentQuantity;
	}
	public void setDepartmentQuantity(int departmentQuantity) {
		this.departmentQuantity = departmentQuantity;
	}
	public int getBedQuantity() {
		return bedQuantity;
	}
	public void setBedQuantity(int bedQuantity) {
		this.bedQuantity = bedQuantity;
	}
	public String getFundedBy() {
		return fundedBy;
	}
	public void setFundedBy(String fundedBy) {
		this.fundedBy = fundedBy;
	}
	public double getSqFeet() {
		return sqFeet;
	}
	public void setSqFeet(double sqFeet) {
		this.sqFeet = sqFeet;
	}
	public int getAmbulanceQuantity() {
		return ambulanceQuantity;
	}
	public void setAmbulanceQuantity(int ambulanceQuantity) {
		this.ambulanceQuantity = ambulanceQuantity;
	}
	
	public String toString() {
		return "Hospital Information: " + "\n" +
				"Name: " + this.name + "\n" +
				"Bed quantity: " + this.bedQuantity + "\n" +
				"Department quantity: " + this.bedQuantity + "\n" +
				"Square feet: " + this.sqFeet + "\n" +
				"Ambulance quantity: " + this.ambulanceQuantity + "\n" +
				"Funded by: " + this.fundedBy + "\n";
	}

}
