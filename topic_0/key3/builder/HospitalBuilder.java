package topic_0.key3.builder;

import java.util.List;

import topic_0.key3.producto.Hospital;
import topic_0.key3.producto.Sector;

public abstract class HospitalBuilder {
	
	
	protected Hospital hospital;
	protected List<Sector> sector;	
	
	public abstract Hospital createHospital();
	public abstract List<Sector> createSectors(int number);
	
}
