package bootcamp.key3.Builder;

import java.util.ArrayList;
import java.util.List;

import bootcamp.key3.Producto.Hospital;
import bootcamp.key3.Producto.Publico;
import bootcamp.key3.Producto.Sector;

public class PublicoBuilder extends HospitalBuilder {

	@Override
	public Hospital createHospital() {
		return new Publico();
	}

	@Override
	public List<Sector> createSectors(int numberOfSectors) {
		List<Sector> sectors=new ArrayList<>();
		
		//populate with sectors
		for(int i=0; i<numberOfSectors; i++)
			sectors.add(new Sector(""+i, 2));
		
		return sectors;
	}
	
}
