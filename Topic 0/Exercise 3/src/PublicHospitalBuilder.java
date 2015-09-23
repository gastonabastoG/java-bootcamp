
public class PublicHospitalBuilder implements HospitalBuilder{

	private Hospital hospital;
	
	public PublicHospitalBuilder() {
		this.hospital = new Hospital();
	}
	@Override
	public void buildName() {
		this.hospital.setName("Public Hospital");
	}

	@Override
	public void buildDepartmentQuantity() {
		this.hospital.setDepartmentQuantity(12);
	}

	@Override
	public void buildBedQuantity() {
		this.hospital.setBedQuantity(500);
	}

	@Override
	public void buildFundedBy() {
		this.hospital.setFundedBy("government");
	}

	@Override
	public void buildSqFeet() {
		this.hospital.setSqFeet(1500);
	}

	@Override
	public void buildAmbulanceQuantity() {
		this.hospital.setAmbulanceQuantity(50);
	}

	@Override
	public Hospital getHospital() {
		return this.hospital;
	}
	
	

}
