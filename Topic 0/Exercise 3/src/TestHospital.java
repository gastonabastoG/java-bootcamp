
public class TestHospital {
	
	public static void main (String args[]) {
		//Get different types of hospitals from HospitalFactory
		//and show them in the console
		HospitalFactory hospitalFactory = new HospitalFactory();
		Hospital h1 = hospitalFactory.getHospital("general");
		System.out.println(h1);
		
		Hospital h2 = hospitalFactory.getHospital("childrens");
		System.out.println(h2);
		
		Hospital h3 = hospitalFactory.getHospital("clinic");
		System.out.println(h3);
		
		//Create another hospital using the builder instead of the factory
		HospitalBuilder hospitalBuilder = new PublicHospitalBuilder();
		HospitalDirector hospitalDirector = new HospitalDirector(hospitalBuilder);
		hospitalDirector.constructHospital();
		Hospital h4 = hospitalDirector.getHospital();
		System.out.println(h4);
		
	}

}
