
public class HospitalFactory extends AbstractFactory {

	public Building getBuilding(String building) {

		switch (building) {
		case "big hospital": {
			return new Hospital(200,5,"Concrete");
		}
		case "small hospital": {
			return new Hospital(50,1,"Concrete");
		}
		default:
			return null;
		}

	}

}
