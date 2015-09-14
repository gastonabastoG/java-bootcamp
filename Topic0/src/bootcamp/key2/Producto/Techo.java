package bootcamp.key2.Producto;

public class Techo extends Bean{
	private String material;
	private double ancho;
	private double largo;
	private double profundidad;
	
	public Techo() {
	}

	public Techo(int id, String material, double ancho, double largo,
			double profundidad) {
		super(id);
		this.material = material;
		this.ancho = ancho;
		this.largo = largo;
		this.profundidad = profundidad;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public double getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(double profundidad) {
		this.profundidad = profundidad;
	}
	
	
	
}
