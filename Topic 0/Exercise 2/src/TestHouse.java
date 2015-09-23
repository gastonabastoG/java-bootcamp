
public class TestHouse {
	
	public static void main(String args[]) {
		//Construct small house using SmallHouseBuilder and print it
		HouseBuilder houseBuilder = new SmallHouseBuilder();
		HouseDirector houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		House h1 = houseDirector.getHouse();
		System.out.println(h1);
		
		//Construct medium house using MediumHouseBuilder and print it
		houseBuilder = new MediumHouseBuilder();
		houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		House h2 = houseDirector.getHouse();
		System.out.println(h2);
		
		//Construct big house using BigHouseBuilder and print it
		houseBuilder = new BigHouseBuilder();
		houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		House h3 = houseDirector.getHouse();
		System.out.println(h3);
		
		
	}

}
