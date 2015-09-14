package bootcamp.key2.Producto;

public class Pared extends Bean {
	private double ancho;
	private double largo;
	private double alto;
	private String tipo;
	
	public Pared() {
	}

	public Pared(int id, double ancho, double largo, double alto, String tipo) {
		super(id);
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
		this.tipo = tipo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
