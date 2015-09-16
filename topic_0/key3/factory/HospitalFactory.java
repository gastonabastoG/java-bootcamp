package topic_0.key3.factory;

import topic_0.key3.builder.HospitalBuilder;
import topic_0.key3.builder.PublicoBuilder;
import topic_0.key3.builder.PrivadoBuilder;
import topic_0.key3.director.HospitalDirector;
import topic_0.key3.producto.Hospital;



public class HospitalFactory {
	
	private HospitalFactory instance = null;
	
	public void getInstance(){
		if(instance != null) return;
		else {
			instance = new HospitalFactory();
		}
	}

	public static Hospital createHospital(Class<?> claseHospital) {
		HospitalDirector director = new HospitalDirector();
		HospitalBuilder builder;
		
		 switch ( claseHospital.getSimpleName())  {
	      case "Privado":{
	    	   builder = new PrivadoBuilder();
	    	   return director.constructHospital(builder);
	      }
	      case "Publico":{
	    	  builder = new PublicoBuilder();
	    	  return director.constructHospital(builder);
	      }
	      default:
	    	  return null;
	          
	      }
		
	}
	
}
