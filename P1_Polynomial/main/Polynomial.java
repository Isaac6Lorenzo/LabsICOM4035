package main;
import java.util.Iterator;

import Resources.List;

public interface Polynomial extends Iterable<Term> {
	
	public Polynomial add(Polynomial P2);
	
	public Polynomial subtract(Polynomial P2);
	
	public Polynomial multiply(Polynomial P2);
	
	public Polynomial multiply(double c);

	public Polynomial derivative();
	
	public Polynomial indefiniteIntegral();
	
	public double definiteIntegral(double a, double b);
	
	public int degree();
	
	public double evaluate(double x);
	

	// new methods added to implements polynomialImp
	public List<Term> getTerms();
	public String getString();
	public void setString(String s);
	public void reorderTerm(Term t);
	public String toString();
	public boolean equals(Polynomial P);


	

}
