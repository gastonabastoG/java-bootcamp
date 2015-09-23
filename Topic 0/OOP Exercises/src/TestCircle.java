
public class TestCircle {
	
	public static void main (String args[]) {
		Circle c1 = new Circle();
		
		System.out.println("The circle has a radius of " +
		c1.getRadius()+ " and an area of " + c1.getArea());
		
		Circle c2 = new Circle(2.0);
		
		System.out.println("The circle has a radius of " +
		c2.getRadius()+ " and an area of " + c2.getArea());
		
		Circle c3 = new Circle(3.0,"blue");
		
		System.out.println("The circle has a radius of " +
		c3.getRadius()+ " and an area of " + c3.getArea());
		
		// System.out.println(c3.color);
		// c3.radius = 10.0;
		//Variables are not visible from this class since they are private
		//Getters and setters should be used instead
		
		Circle c4 = new Circle();
		
		c4.setColor("black");
		c4.setRadius(5.5);
		
		System.out.println(c4);
	}
}

