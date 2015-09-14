package bootcamp.key2.Producto;

public class Piso extends Bean {
	private String tipo;
	private double superficie;
	
	public Piso() {
	}

	public Piso(int id, String tipo, double superficie) {
		super(id);
		this.tipo = tipo;
		this.superficie = superficie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	

}
