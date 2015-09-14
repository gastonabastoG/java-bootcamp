package bootcamp.key2.Producto;

public class Casa extends Bean{
	
	private Techo techo;
	private Piso piso;
	private Pared paredes; //Supongo 4 paredes iguales
	private int ambientes;
	
	
	public Casa(){}

	
	
	public Casa(int id, Techo techo, Piso piso, Pared paredes, int ambientes) {
		super(id);
		this.techo = techo;
		this.piso = piso;
		this.paredes = paredes;
		this.ambientes = ambientes;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Techo getTecho() {
		return techo;
	}

	public void setTecho(Techo techo) {
		this.techo = techo;
	}

	public Piso getPiso() {
		return piso;
	}

	public void setPiso(Piso piso) {
		this.piso = piso;
	}

	

	public Pared getParedes() {
		return paredes;
	}



	public void setParedes(Pared paredes) {
		this.paredes = paredes;
	}



	public int getAmbientes() {
		return ambientes;
	}



	public void setAmbientes(int ambientes) {
		this.ambientes = ambientes;
	}



	@Override
	public String toString() {
		return "Casa [techo=" + techo.getMaterial() + ", piso=" + piso.getTipo() + ", paredes="
				+ paredes.getTipo() + ", habitacion=" + ambientes + "]";
	}
	
	
	
	
}
