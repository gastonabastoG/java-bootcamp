package topic_0.key3.builder;

import java.util.ArrayList;
import java.util.List;

import topic_0.key3.producto.Hospital;
import topic_0.key3.producto.Publico;
import topic_0.key3.producto.Sector;

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
			sectors.add(new Sector(String.valueOf(i), 2));
		
		return sectors;
	}
	
}
