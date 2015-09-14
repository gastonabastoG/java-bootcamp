package bootcamp.key3.Director;

import bootcamp.key3.Builder.HospitalBuilder;
import bootcamp.key3.Producto.Hospital;


public class HospitalDirector {
	/**
	 * @param builder who build a hospital.
	 * @return a brand new Hospital
	 */
	public Hospital constructHospital(HospitalBuilder builder) {
		Hospital hospital= builder.createHospital();
		hospital.setSectors(builder.createSectors(3));

		return hospital;
	}
	
	
}

