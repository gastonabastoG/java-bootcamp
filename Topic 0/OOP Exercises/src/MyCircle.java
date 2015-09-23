
public class MyCircle {
	
	private MyPoint center;
	private int radius;
	
	public MyCircle (int x, int y, int radius) {
		this.center = new MyPoint(x,y);
		this.radius = radius;
	}
	
	public MyCircle (MyPoint center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public MyPoint getCenter() {
		return center;
	}

	public void setCenter(MyPoint center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getCenterX() {
		return this.center.getX();
	}
	
	public int getCenterY() {
		return this.center.getY();
	}
	
	public void setCenterXY(int x, int y) {
		this.center.setXY(x, y);
	}
	
	public String toString() {
		return "Circle @ (" + this.center.getX() + ", " 
		+ this.center.getY() + ") radius= " + this.radius;
	}
	
	public double getArea() {
		return this.radius*this.radius*Math.PI;	
	}
	

}
