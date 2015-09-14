package bootcamp.key2;

import bootcamp.key2.Director.CasaDirector;
import bootcamp.key2.Producto.Casa;

public class Principal {

	public static void main(String[] args) {
		CasaDirector director = new CasaDirector(); // El director solo sabe hacer una casa o.O
		director.buildCasa();
		Casa casa = director.getCasa();
		
		System.out.println(casa);
	}

}
