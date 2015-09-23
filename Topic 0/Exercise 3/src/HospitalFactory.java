
public class HospitalFactory {
	
	public Hospital getHospital(String type) {
		if (type.equals("general")) {
			return new GeneralHospital();
		}
		else 
			if (type.equals("childrens")) {
				return new ChildrensHospital();
			}		
		else 
			if (type.equals("clinic")) {
				return new Clinic();
			}
		return null;
	}
}
