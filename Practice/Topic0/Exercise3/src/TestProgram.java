
public class TestProgram {

	public static void main(String[] args) {

		Builder hospitalBuilder = new HospitalBuilder();
		Architect arch = new Architect();

		// construct a hospital using HospitalBuilder as Builder of
		// Architect
		arch.setBuilder(hospitalBuilder);
		arch.constructHouse();
		System.out.println("Builder Pattern=>" + arch.getHospital().toString());

		// construct a hospital using a HospitalFactory
		HospitalFactory hf = new HospitalFactory();
		Hospital hospital = hf.getProduct();
		System.out.println("Factory Pattern => " + hospital.toString());
	}

}
