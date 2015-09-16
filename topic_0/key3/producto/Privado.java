package topic_0.key3.producto;


public class Privado extends Hospital {

	public String getDescripcion(){
		return ("building a Private hospital");
	}

	public void registerGuest() {
		for (Sector sector : sectors) {
			if(	sector.registerGuest() )
				break;
		}
	}

	
}
