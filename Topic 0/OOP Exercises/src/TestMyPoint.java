
public class TestMyPoint {
	
	public static void main (String args[]) {
		
		MyPoint p1 = new MyPoint();
		p1.setX(5);
		p1.setY(5);
		
		MyPoint p2 = new MyPoint(6,2);
		
		MyPoint p3 = new MyPoint();
		p3.setXY(2, 9);
		
		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(10, 10));
		
		System.out.println(p1);
		
		MyPoint[] pointArray = new MyPoint[10];
		for (int i = 0; i < pointArray.length; i++) {
			pointArray[i] = new MyPoint(i,i);
		}
		
		for (MyPoint myPoint : pointArray) {
			System.out.println(myPoint);
		}
	
	}

}
