import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {
	
	private Fraction f1;
	private Fraction f2;
	private Fraction f3;
	private Fraction f4;
	private Fraction f5;
	private Fraction f6;
	private Fraction f7;
	private Fraction f8;
	private Fraction f9;
	private Fraction f10;
	
	@Before
	public void setUp() {
		f1 = new Fraction(2,10);
		f2 = new Fraction(59,73);
		f3 = new Fraction(19,38);
		f4 = new Fraction(12,16);
		f5 = new Fraction(60,144);
		f6 = new Fraction(3,10);
		f7 = new Fraction(3,72);
		f8 = new Fraction(19,114);
		f9 = new Fraction(1,1);
		f10 = new Fraction(0,1);
	}

	@Test
	public void testMinimize() {
		Fraction result = f1.minimize(); // Minimize 2/10
		assertNotSame("The method must not return the target object.",result,f1);

		f3.minimize(); // Minimize 19/38
		assertEquals("The method must not change the target object numerator.",19,f3.getNumerator());
		assertEquals("The method must not change the target object denominator.",38,f3.getDenominator());
		
		assertNotEquals("The method did not minimized the numerator.",2,result.getNumerator());
		assertNotEquals("The method did not minimized the denominator.",10,result.getDenominator());

		result = f2.minimize(); // Minimize 59/73
		assertEquals("The method minimized the numerator incorrectly.",59,result.getNumerator());
		assertEquals("The method minimized the denominator incorrectly.",73,result.getDenominator());

		result = f4.minimize(); // Minimize 12/16
		assertEquals("The method minimized the numerator incorrectly.",3,result.getNumerator());
		assertEquals("The method minimized the denominator incorrectly.",4,result.getDenominator());
	}
	
	@Test
	public void testAdd() {
		Fraction result = f5.add(f5); //  ((60/144) + (60/144))
		assertNotSame("The method must not return the target object.",result,f5);
		assertEquals("The method must not change the target object numerator.",60,f5.getNumerator());
		assertEquals("The method must not change the target object denominator.",144,f5.getDenominator());
		
		result = f6.add(f7); //  ((3/10) + (3/72))
		assertEquals("The resulting numerator is incorrect.",246,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",720,result.getDenominator());
		
		result = f5.add(f5); //  ((60/144) + (60/144))
		assertEquals("The resulting numerator is incorrect.",17280,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",20736,result.getDenominator());

		result = f7.add(f8); //  ((3/72) + (19/114))
		assertEquals("The resulting numerator is incorrect.",1710,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",8208,result.getDenominator());		
		
		result = f7.add(f10); //  ((3/72) + (0/1))
		assertEquals("By adding 0 the numerator must not change.",3,result.getNumerator());
		assertEquals("By adding 0 the denominator must not change.",72,result.getDenominator());
	}
	
	@Test
	public void testSubtract() {
		Fraction result = f5.subtract(f5); //  ((60/144) - (60/144))
		assertNotSame("The method must not return the target object.",result,f5);
		assertEquals("The method must not change the target object numerator.",60,f5.getNumerator());
		assertEquals("The method must not change the target object denominator.",144,f5.getDenominator());
		
		result = f6.subtract(f7); //  ((3/10) - (3/72))
		assertEquals("The resulting numerator is incorrect.",186,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",720,result.getDenominator());
		
		result = f5.subtract(f5); //  ((60/144) - (60/144))
		assertEquals("The resulting numerator is incorrect.",0,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",20736,result.getDenominator());

		result = f7.subtract(f8); //  ((3/72) - (19/114))
		assertEquals("The resulting numerator is incorrect.",-1026,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",8208,result.getDenominator());		
		
		result = f7.subtract(f10); //  ((3/72) - (0/1))
		assertEquals("By subtracting 0 the numerator must not change.",3,result.getNumerator());
		assertEquals("By subtracting 0 the denominator must not change.",72,result.getDenominator());
	}
	
	@Test
	public void testMultiply() {
		Fraction result = f5.multiply(f5); //  ((60/144) * (60/144))
		assertNotSame("The method must not return the target object.",result,f5);
		assertEquals("The method must not change the target object numerator.",60,f5.getNumerator());
		assertEquals("The method must not change the target object denominator.",144,f5.getDenominator());
		
		result = f6.multiply(f7); //  ((3/10) * (3/72))
		assertEquals("The resulting numerator is incorrect.",9,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",720,result.getDenominator());
		
		result = f5.multiply(f5); //  ((60/144) * (60/144))
		assertEquals("The resulting numerator is incorrect.",3600,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",20736,result.getDenominator());

		result = f7.multiply(f8); //  ((3/72) * (19/114))
		assertEquals("The resulting numerator is incorrect.",57,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",8208,result.getDenominator());		
		
		result = f7.multiply(f9); //  ((3/72) * (1/1))
		assertEquals("By multiplying 1 the numerator must not change.",3,result.getNumerator());
		assertEquals("By multiplying 1 the denominator must not change.",72,result.getDenominator());
	}
	
	@Test
	public void testDivide() {
		Fraction result = f5.divide(f5); //  ((60/144) ÷ (60/144))
		assertNotSame("The method must not return the target object.",result,f5);
		assertEquals("The method must not change the target object numerator.",60,f5.getNumerator());
		assertEquals("The method must not change the target object denominator.",144,f5.getDenominator());
		
		result = f6.divide(f7); //  ((3/10) ÷ (3/72))
		assertEquals("The resulting numerator is incorrect.",216,result.getNumerator());
		assertEquals("The resulting numerator is incorrect.",30,result.getDenominator());
		
		result = f5.divide(f5); //  ((60/144) ÷ (60/144))
		assertEquals("The resulting numerator is incorrect.",8640,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",8640,result.getDenominator());

		result = f7.divide(f8); //  ((3/72) ÷ (19/114))
		assertEquals("The resulting numerator is incorrect.",342,result.getNumerator());
		assertEquals("The resulting denominator is incorrect.",1368,result.getDenominator());		
		
		result = f7.divide(f9); //  ((3/72) ÷ (1/1))
		assertEquals("By multiplying 1 the numerator must not change.",3,result.getNumerator());
		assertEquals("By multiplying 1 the denominator must not change.",72,result.getDenominator());
	}
}