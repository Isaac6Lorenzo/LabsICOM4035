/*
 * Immutable Fraction class holds a rational number represented 
 * by an integer numerator and an integer denominator
 */
public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	
	/*
	 * Returns the greatest common divisor of a and b
	 */
	public int gcd(int a, int b) {
		if (a % b == 0) return b;
		return gcd(b, a%b);
	}

	/*
	 * Return a new fraction equivalent to the target fraction but expressed in 
	 * minimal terms. That is, the numerator and the denominator may not have a 
	 * gcd larger than one.
	 */
	public Fraction minimize() {
		// YOUR CODE HERE
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int min = gcd(n1,d1);
		int numMin = (n1/min);
		int denMin = (d1/min);

		
		return new Fraction (numMin, denMin); // Dummy return. Please change and remove this comment
	}
	
	/*
	 * Returns a new fraction representing the sum of the target and argument
	 * fractions.  The resulting fraction may not be expressed in minimal terms.
	 */
	public Fraction add(Fraction f2) {
		// YOUR CODE HERE
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = f2.getNumerator();
		int d2 = f2.getDenominator();
		
		int num = (n1 * d2) + (n2 * d1);
		int den = (d1 * d2);
		
		return new Fraction (num, den); // Dummy return. Please change and remove this comment
	}
	
	/*
	 * Returns a new fraction representing the subtraction of the argument
	 * fraction from the target fraction. The resulting fraction may not be 
	 * expressed in minimal terms.
	 */
	public Fraction subtract(Fraction f2) {
		// YOUR CODE HERE
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = f2.getNumerator();
		int d2 = f2.getDenominator();
		
		int num = (n1 * d2) - (n2 * d1);
		int den = (d1 * d2);
		
		return new Fraction (num, den);	// Dummy return. Please change and remove this comment

		
	}
	
	/*
	 * Returns a new fraction representing the product of the target times
	 * the argument fraction.  The resulting fraction may not be expressed 
	 * in minimal terms.
	 */
	public Fraction multiply(Fraction f2) {
		// YOUR CODE HERE
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = f2.getNumerator();
		int d2 = f2.getDenominator();
		
		int num = (n1 *n2);
		int den = (d1 * d2);
		
		return new Fraction (num, den);	 // Dummy return. Please change and remove this comment

	}
	
	/*
	 * Returns a new fraction representing the division of the target fraction
	 * by the argument fraction.  Remember that a/b divided by c/d is equivalent
	 * to a/b times d/c.  The resulting fraction may not be expressed in minimal
	 * terms.
	 */
	public Fraction divide(Fraction f2) {
		// YOUR CODE HERE
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = f2.getNumerator();
		int d2 = f2.getDenominator();
		
		int num = (n1 * d2);
		int den = (d1 * n2);
		
		return new Fraction (num, den);	 // Dummy return. Please change and remove this comment

	}

}