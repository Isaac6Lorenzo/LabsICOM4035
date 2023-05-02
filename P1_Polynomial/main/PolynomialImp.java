package main;
import java.util.Iterator;
import java.util.StringTokenizer;


import Resources.ArrayList;
import Resources.List;

public class PolynomialImp implements Polynomial{

	private String string;
	private List<Term> terms;

	public PolynomialImp(String s) {
		this.string = s;
		this.terms = new ArrayList<Term>();
		//way to convert this to term 
		this.convertToTerm(this.getString());
	}


	@Override
	public Iterator<Term> iterator() {
		return this.getTerms() .iterator();
	}

	/**
	 * Addition method
	 * @param P2 polynomial to be add
	 * @return new polynomial after addition
	 */
	@Override
	public Polynomial add(Polynomial P2) {
		List<Term> p1 = this.getTerms();
		List<Term> p2 = P2.getTerms();

		List<Term> list = new ArrayList<Term>();

		Polynomial polynomial;

		Iterator<Term> it1 = p1.iterator();
		Iterator<Term> it2 = p2.iterator();

		while(it1.hasNext()) {
			Term term1 = it1.next();
			boolean add = true;
			for(int i = 0; i< p2.size(); i++) {
				Term term2 = p2.get(i);
				if (term1.getExponent() == term2.getExponent()) {
					Term term = new TermImp(term1.getCoefficient() + 
							term2.getCoefficient(), term1.getExponent());
					list.add(term);
					add = false;
					break;
				}
			}

			if(add) {				
				Term term = new TermImp(term1.getCoefficient(),
						term1.getExponent());
				list.add(term);
			}
		}

		//terms not add in p2 with different expo numbers
		while(it2.hasNext()) {
			Term term2 = it2.next();
			boolean notAdd = false;
			for(int i = 0; i< p1.size(); i++) {
				Term term1 = p1.get(i);
				if (term2.getExponent() == term1.getExponent()) {
					notAdd = true;
				}
			}

			if (!notAdd) {
				Term term = new TermImp(term2.getCoefficient(), term2.getExponent());
				list.add(term);
			}
		}

		polynomial = this.convertPolynomial(list);
		return polynomial;
	}

	/**Subtraction method
	 * @param P2 polynomial to be subtract
	 * @return new polynomial after subtraction
	 */
	@Override
	public Polynomial subtract(Polynomial P2) {
		return this.add(P2.multiply(-1));
	}

	/**Multiplication method
	 * @param P2 polynomial to be multiplicate
	 * @return new polynomial after multiplication
	 */
	@Override
	public Polynomial multiply(Polynomial P2) {
		List<Term> p1 = this.terms;
		List<Term> p2 = P2.getTerms();

		List<Polynomial> listPoly=new ArrayList<Polynomial>();

		for(Term term1: p1){
			Polynomial poly = new PolynomialImp("");
			for(Term term2: p2){
				Term newTerm = new TermImp(term1.getCoefficient()*term2.getCoefficient(),
						term1.getExponent()+term2.getExponent());
				poly.reorderTerm(newTerm);
			}
			//put all polynomial into an list to later sum all.
			listPoly.add(poly);
		}

		//sum all poly from the listPoly
		Polynomial P3 = new PolynomialImp("");
		for(Polynomial P: listPoly) {
			P3 = P3.add(P);
		}

		return P3;
	}

	/**Scalar Multiplication method
	 * @param c multiply it by a constant
	 * @return new polynomial after scalar multiplication
	 */
	@Override
	public Polynomial multiply(double c) {
		List<Term> listOfTerm = this.getTerms();

		Polynomial poly;
		//if c = 0 then poly = 0
		if(c==0){
			//this will return a polynomial equal to P=0
			poly = new PolynomialImp("0.00");			
			return poly;
		}

		List<Term> newList = new ArrayList<Term>();
		Iterator<Term> it = listOfTerm.iterator();

		while(it.hasNext()) {
			Term term = it.next();
			TermImp newT = new TermImp(term.getCoefficient() * c, 
					term.getExponent());
			newList.add(newT);		
		}

		poly = this.convertPolynomial(newList);
		return poly;
	}

	/**Derivative method
	 * @return new polynomial with the derivative
	 */
	@Override
	public Polynomial derivative() {
		List<Term> newList = new ArrayList<Term>();
		List<Term> listOfTerms = this.getTerms();

		Iterator<Term> it = listOfTerms.iterator();
		while(it.hasNext()) {
			Term term = it.next();
			Term newT = new TermImp(term.getCoefficient() * term.getExponent(), 
					term.