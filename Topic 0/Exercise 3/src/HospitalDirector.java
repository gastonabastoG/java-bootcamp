
public class HospitalDirector {
	
	private HospitalBuilder hospitalBuilder = null;
	
	public HospitalDirector(HospitalBuilder hospitalBuilder) {
		this.hospitalBuilder = hospitalBuilder;
	}
	
	public void constructHospital() {
		hospitalBuilder.buildName();
		hospitalBuilder.buildDepartmentQuantity();
		hospitalBuilder.buildBedQuantity();
		hospitalBuilder.buildSqFeet();
		hospitalBuilder.buildAmbulanceQuantity();
		hospitalBuilder.buildFundedBy();
	}
	
	public Hospital getHospital() {
		return this.hospitalBuilder.getHospital();
	}

}
