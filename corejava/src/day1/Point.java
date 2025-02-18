package day1;

public class Point {
	
	public final static double ZERO = 0;
	private double x;
	private double y;
	
	public Point() {}
	
//	public void Point() {}
	
	public Point(final double x,final double y)	{
		this.x=x;
		this.y=y;
	}
	
	public final double getX() {
		return x;
	}
	
	public final double getY() {
		return y;
	}
	
	public final void setY(double y) {
		this.y = y;
	}
	
	public final void setX(double x) {
		this.x = x;
	}
	
//	public abstract void markMeOnScreen();
	
	public double distance()	{
		return distance(0,0);
	}
	
	public double distance(Point p)	{
		return distance(p.x,p.y);
	}
	
	public double distance(final double x1,final double y1)	{
		final double diffx = x1-x;
		final double diffy = y1-y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}
	
	public static void main(String[] args) {
		Point p = new Point(10,20);
		System.out.println(p);
		System.out.println(p.distance());
		System.out.println(p.distance(100,200));
		System.out.println(p.distance(p));
	}
	
	@Override
	public String toString() {
		return "Point X = "+x+" Y = "+y;
	}
	
	/**
	 * whole numbers
	 * byte - 8 bits  -128 to +127
	 * short - 16 bits -32536 to +32535 ie -(2^15) to 2^15-1
	 * int - 32 bits -(2^31) to 2^31-1
	 * long - 64 bits -(2^63) to 2^63-1
	 * 
	 * Decimal numbers
	 * float - 32 bits
	 * double - 64 bits
	 * 
	 * boolean - true or false
	 * 
	 * char - 16 bits
	 * 
	 * String 
	 */

}
