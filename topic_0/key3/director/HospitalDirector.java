package topic_0.key3.director;

import topic_0.key3.builder.HospitalBuilder;
import topic_0.key3.producto.Hospital;


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

