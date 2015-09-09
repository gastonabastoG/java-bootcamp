
public class HospitalFactory extends Factory {

	@Override
	public Hospital getProduct() {
		return new Hospital(200, 4, "Concrete");
	}

}
