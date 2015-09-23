
public class TestMyCircle {
	
	public static void main (String args[]) {
		MyCircle c1 = new MyCircle(new MyPoint(2,3), 4);
		MyCircle c2 = new MyCircle(7, 3, 2);
		
		System.out.println(c1);
		System.out.println(c2);
	}
}
