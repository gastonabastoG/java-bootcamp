package bootcamp.key3;

import bootcamp.key3.Builder.HospitalBuilder;
import bootcamp.key3.Builder.PublicoBuilder;
import bootcamp.key3.Builder.PrivadoBuilder;
import bootcamp.key3.Director.HospitalDirector;
import bootcamp.key3.Producto.Hospital;



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
