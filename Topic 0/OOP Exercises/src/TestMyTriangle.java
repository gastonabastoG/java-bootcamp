
public class TestMyTriangle {
	
	public static void main (String args[]) {
		MyTriangle t1 = new MyTriangle(
				new MyPoint(1,1), new MyPoint(2,2), new MyPoint(3,1));
		
		MyTriangle t2 = new MyTriangle(4,2,5,1,3,9);
		
		System.out.println(t1);
		System.out.println(t1.printType());
		System.out.println(t1.getPerimeter());
		
		System.out.println(t2);
		System.out.println(t2.printType());
		System.out.println(t2.getPerimeter());
	}
	
	

}
