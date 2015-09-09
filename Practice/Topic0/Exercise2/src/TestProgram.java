
public class TestProgram {

	public static void main(String[] args) {

		Builder smallHouseBuilder = new SmallHouseBuilder();
		Builder bigHouseBuilder = new BigHouseBuilder();
		Architect arch = new Architect();

		// construct a smallHouse using SmallHouseBuilder as Builder of
		// Architect
		arch.setBuilder(smallHouseBuilder);
		arch.constructHouse();
		System.out.println(arch.getHouse().toString());

		// construct a bigHouse using BigHouseBuilder as Builder of
		// Architect
		arch.setBuilder(bigHouseBuilder);
		arch.constructHouse();
		System.out.println(arch.getHouse().toString());

	}

}
