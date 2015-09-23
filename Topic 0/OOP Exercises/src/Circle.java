
public class Circle {
	
	private String color;
	private double radius;
	
	public Circle() {
		this.color = "red";
		this.radius = 1.0;
	}
	
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		   return "Circle: radius=" + radius + " color=" + color;
	}

}
