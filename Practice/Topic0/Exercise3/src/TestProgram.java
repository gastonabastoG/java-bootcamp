
public class TestProgram {

	public static void main(String[] args) {

		Builder hospitalBuilder = new HospitalBuilder();
		Architect arch = new Architect();

		// construct a hospital using HospitalBuilder as Builder of
		// Architect
		arch.setBuilder(hospitalBuilder);
		arch.constructHouse();
		System.out.println("Builder Pattern=>" + arch.getHospital().toString());

		// construct two different hospitals using a BuildingFactory
		HospitalFactory bf = new HospitalFactory();
		
		Hospital hospital1 = (Hospital) bf.getBuilding("big hospital");
		Hospital hospital2 = (Hospital) bf.getBuilding("small hospital");
		System.out.println("Factory Pattern => " + hospital1.toString());				
		System.out.println("Factory Pattern => " + hospital2.toString());
	}

}
