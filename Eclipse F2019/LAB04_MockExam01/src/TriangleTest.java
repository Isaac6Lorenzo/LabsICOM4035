import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void testContructor1() {
		Triangle t1 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(4,0), new Point2D.Double(2, 4));
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(0,0), t1.getP1());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(4,0), t1.getP2());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(2,4), t1.getP3());
		Triangle t2 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(6,0), new Point2D.Double(3,3));
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(0,0), t2.getP1());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(6,0), t2.getP2());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(3,3), t2.getP3());
	}

	@Test
	public void testContructor2() {
		Triangle t2 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(6,0), new Point2D.Double(3,3));
		Triangle t1 = new Triangle(t2);
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(0,0), t1.getP1());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(6,0), t1.getP2());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(3,3), t1.getP3());
		assertFalse("Incorrect getter/costructor in Triangle class", t2 == t1);	
	}
	
	@Test
	public void testPerimeter() {
		Triangle t1 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(4,0), new Point2D.Double(2, 4));
		assertEquals("Incorrect perimetter in Triangle class", 12.9442, t1.perimeter(), 1e-3);
		Triangle t2 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(6,0), new Point2D.Double(3,3));
		assertEquals("Incorrect perimetter in Triangle class", 14.485, t2.perimeter(), 1e-3);
	}
	
	@Test
	public void testArea() {
		Triangle t1 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(4,0), new Point2D.Double(2, 4));
		assertEquals("Incorrect area in Triangle class", 8.0, t1.area(), 1e-3);
		Triangle t2 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(6,0), new Point2D.Double(3,3));
		assertEquals("Incorrect area in Triangle class", 9.0, t2.area(), 1e-3);
	}
	
	@Test
	public void testTranslate() {
		Triangle t1 = new Triangle(new Point2D.Double(0,0), new Point2D.Double(4,0), new Point2D.Double(2, 4));
		Triangle t2 = t1.translate(2, -2);
		assertNotNull("Incorrect translate in Triangle class", t2);
		assertEquals("Incorrect translate in Triangle class", 8.0, t2.area(), 1e-3);
		assertEquals("Incorrect translate in Triangle class", new Point2D.Double(2,-2), t2.getP1());
		assertEquals("Incorrect translate in Triangle class", new Point2D.Double(6,-2), t2.getP2());
		assertEquals("Incorrect translate in Triangle class", new Point2D.Double(4,2), t2.getP3());
		assertFalse("Incorrect translate in Triangle class", t1 == t2);
		t1 = t2.translate(-2,  2);
		assertNotNull("Incorrect translate in Triangle class", t1);
		assertEquals("Incorrect translate in Triangle class", 8.0, t1.area(), 1e-3);
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(0,0), t1.getP1());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(4,0), t1.getP2());
		assertEquals("Incorrect getter/costructor in Triangle class", new Point2D.Double(2,4), t1.getP3());
		assertFalse("Incorrect translate in Triangle class", t1 == t2);
	}
}