
public class MyComplexTest {
	
	public static void main (String args[]) {
		MyComplex mc1 = new MyComplex(3.4, 1.2);
		MyComplex mc2 = new MyComplex(1.7, 2.2);
		MyComplex mc3 = new MyComplex(5.1, 7.4);
		MyComplex mc4 = new MyComplex(3.2, 0);
		
		System.out.println(mc1.isReal() + " " + mc4.isImaginary());		
		System.out.println(mc1.equals(mc1));
		System.out.println(mc1.equals(5.3,1.2));
		System.out.println(mc3.magnitude());
		System.out.println(mc2.argumentInDegrees() + " \n" + mc2.argumentInRadians());
		System.out.println(mc2.conjugate());
		System.out.println(mc1.add(2, 2));
		System.out.println(mc3.substract(2, 4));
		System.out.println(mc1.multiplyWith(mc2));
	}

}
