package topic_0.key2.builder;

import topic_0.key2.producto.Casa;

public interface ICasa {
	public void buildTecho();
	public void buildParedes();
	public void buildPiso();
	public void buildAmbiente();
	
	public Casa getCasa();
}
