package bootcamp.key2.Builder;

import bootcamp.key2.Producto.Casa;

public interface ICasa {
	public void buildTecho();
	public void buildParedes();
	public void buildPiso();
	public void buildAmbiente();
	
	public Casa getCasa();
}
