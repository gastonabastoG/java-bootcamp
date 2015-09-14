package bootcamp.key3.Builder;

import java.util.List;

import bootcamp.key3.Producto.Hospital;
import bootcamp.key3.Producto.Sector;

public abstract class HospitalBuilder {
	
	
	protected Hospital hospital;
	protected List<Sector> sector;	
	
	public abstract Hospital createHospital();
	public abstract List<Sector> createSectors(int number);
	
}
