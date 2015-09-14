package bootcamp.key2.Director;

import bootcamp.key2.Builder.CasaBuilder;
import bootcamp.key2.Producto.Casa;

public class CasaDirector {
	private CasaBuilder builder;
	
	public CasaDirector(){
		builder = new CasaBuilder();
	}
	
	public void buildCasa(){
		
		builder.buildAmbiente();
		builder.buildParedes();
		builder.buildPiso();
		builder.buildTecho();
		
	}
	
	public Casa getCasa(){
		return builder.getCasa();
	}
}
