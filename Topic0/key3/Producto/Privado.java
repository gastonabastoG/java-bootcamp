package bootcamp.key3.Producto;


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
