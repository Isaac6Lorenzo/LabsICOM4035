import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Triangle {

	private Point2D.Double p1;
	private Point2D.Double p2;
	private Point2D.Double p3;

	// Constructors

	/*
	 * Constructs a Triangle object with the given parameters
	 */
	public Triangle(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	/*
	 * Constructs a Triangle object with the same properties as the parametter
	 * triangle
	 */
	public Triangle(Triangle t2) {
		// YOUR CODE HERE
		// Triangle t2 = new Triangle(t2.getP1(), t2.getP2(), t2.getP3());
		this(t2.getP1(), t2.getP2(), t2.getP3());
	}

	// Getters
	// YOUR CODE HERE
	public Double getP1() {
		return p1;
	}

	public Double getP2() {
		return p2;
	}

	public Double getP3() {
		return p3;
	}

	/*
	 * Returns the perimeter of the target Triangle object The perimeter is the sum
	 * of the lengths of the sides HINT: Check for useful methods in the
	 * Point2D.Double class
	 */
	public double perimeter() {

		// YOUR CODE HERE
		double perimeter, a, b, c;
		a = Point.distance(p3.getX(), p3.getY(), p1.getX(), p1.getY());
		b = Point.distance(p3.getX(), p3.getY(), p2.getX(), p2.getY());
		c = Point.distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		perimeter = a + b + c;
		return perimeter; // Dummy return
	}

	/*
	 * Returns the area of the target Triangle object HINT: Use Heron's formula of
	 * area using 3 sides
	 */
	public double area() {
		// YOUR CODE HERE
		double area, s, a, b, c;
		double s1, s2, s3;
		a = Point.distance(p3.getX(), p3.getY(), p1.getX(), p1.getY());
		b = Point.distance(p3.getX(), p3.getY(), p2.getX(), p2.getY());
		c = Point.distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());

//		a = p3-p1;
//		b = p3-p2;
//		c = p1-p2;
		s = ((a + b + c) / 2);
		s1 = s - a;
		s2 = s - b;
		s3 = s - c;

		area = Math.sqrt(s * s1 * s2 * s3);
		return area;
	}

	/*
	 * Return a NEW Triangle that represents the translation of the target Triangle
	 * by detaX units horizontally and deltaY units vertically
	 */
	public Triangle translate(double deltaX, double deltaY) {

		// YOUR CODE HERE
		//new point plus delta 
		//and new triangle to return with new point translate
		Point2D.Double P1 = new Point2D.Double(p1.x + deltaX, p1.y + deltaY);
		Point2D.Double P2 = new Point2D.Double(p2.x + deltaX, p2.y + deltaY);
		Point2D.Double P3 = new Point2D.Double(p3.x + deltaX, p3.y + deltaY);

		//return null; // Dummy return
	
		return new Triangle(P1, P2, P3);
				
	}

}