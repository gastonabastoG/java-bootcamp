
public class MyComplex {
	private double real;
	private double imag;
	
	public MyComplex (double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public void setValue(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public String toString() {
		return "(" + this.real + ", " + this.imag + "i)";	 
	}
	
	public boolean isReal() {
		if (imag == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isImaginary() {
		if (imag != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals (double real, double imag) {
		if (this.real == real && this.imag == imag) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals (MyComplex anotherComplex) {
		if (this.real == anotherComplex.getReal() && this.imag == anotherComplex.getImag()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double magnitude() {
		return Math.sqrt(real*real+imag*imag);
	}
	
	public double argumentInRadians() {
		return Math.atan2(this.real, this.imag);
	}
	
	public double argumentInDegrees() {
		return Math.toDegrees(argumentInRadians());
	}
	
	public MyComplex conjugate() {
		return new MyComplex(this.real,-this.imag);
	}
	
	public MyComplex add(double real, double imag) {
		return new MyComplex(this.real+real, this.imag+imag);
	}
	
	public MyComplex substract (double real, double imag) {
		return new MyComplex(this.real-real, this.imag-imag);
	}
	
	public MyComplex multiplyWith (MyComplex anotherComplex) {
		double aReal = anotherComplex.getReal();
		double aImag = anotherComplex.getImag();
		
		double newReal = this.real*aReal-this.imag*aImag;
		double newImag = this.real*aImag + this.imag*aReal;
		
		this.real = newReal;
		this.imag = newImag;
		return this;
	}
	
	public MyComplex divideBy (MyComplex anotherComplex) {
		double aReal = anotherComplex.getReal();
		double aImag = anotherComplex.getImag();
		
		return null; //Didn't understand how to divide imaginary numbers
		//(a + bi) / (c + di) = [(a + bi) * (c – di)] / (c2 + d2)
	}

}
