package EXAMEN01;

/**
 * Represents a wallet with dollar bills form various denominations
 */
public class Wallet {

	private int ones;
	private int fives;
	private int twenties;
	private int fifthies;
	private int hundreds;

	/**
	 * Traditional Constructor, it adds all bill quantities one by one
	 * @param ones
	 * @param fives
	 * @param tens
	 * @param twenties
	 * @param hundreds
	 */
	public Wallet(int ones, int fives, int twenties, int fifthies, int hundreds) {
		super();
		this.ones = ones;
		this.fives = fives;
		this.twenties = twenties;
		this.fifthies = fifthies;
		this.hundreds = hundreds;
	}
	
	/**
	 * EXERCISE #1
	 * 
	 * Creates a new wallet with exactly the same bills as the given wallet
	 */
	public Wallet(Wallet w) {
		// YOUR CODE HERE
		this.ones = w.ones;
		this.fives = w.fives;
		this.twenties = w.twenties;
		this.fifthies = w.fifthies;
		this.hundreds = w.hundreds;
	}
	
	/**
	 * EXERCISE #2
	 * 
	 * Creates a new wallet with the amount of dollars received as a parameter.
	 * Add the minimal number of bills necessary to represent the dollar amount.
	 * Hint: The modulus operation (%) gives you the remainder of a division.
	 */
	public Wallet(int dollars) {
		// TODO -- YOUR CODE HERE

		hundreds = dollars % 100;
		fifthies = dollars % 50;
		twenties = dollars % 20;
		fives = dollars % 5;
		ones = dollars % 1;
		
	}
	
	/**
	 * Return true if and only if the parameter wallet contains 
	 * exactly the same bills as the target object.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Wallet)) { return false; }
		Wallet w = (Wallet) o;
		return ((w.ones == this.ones) &&
				(w.fives == this.fives) &&
				(w.twenties == this.twenties) && 
				(w.fifthies == this.fifthies) &&
				(w.hundreds == this.hundreds));
	}


	// Getters 
	public int getOnes() { return ones; }
	public int getFives() { return fives; }
	public int getTwenties() { return twenties; }
	public int getFifthies() { return fifthies; }
	public int getHundreds() { return hundreds; }
	
	/**
	 * EXERCISE #3
	 * 
	 * Returns the total amount of money in dollars contained in the wallet.
	 */
	public int getAmount() {
		// TODO -- YOUR CODE HERE
		int totalAmount = (this.hundreds * 100) + (this.fifthies * 50) + (this.twenties * 20) + (this.fives * 5) + this.ones;
		return totalAmount; // Dummy return. Please replace.
	}
	
	/**
	 * EXERCISE #4
	 * 
	 * Modifies the target wallet to add (not replace) the bills from the
	 * parameter wallet to the target wallet. Returns the modified target Wallet.
	 */
	public Wallet add(Wallet w2) {
		// TODO -- YOUR CODE HERE
		this.ones = w2.ones + this.getOnes();
		this.fives = w2.fives + this.getFives();
		this.twenties = w2.twenties + this.getTwenties();
		this.fifthies = w2.fifthies + this.getFifthies();
		this.hundreds = w2.hundreds + this.getHundreds();
		return this;
	}

	/**
	 * EXERCISE #5
	 * 
	 * It checks that the wallet has enough funds to be able to pay the given bill amount.
	 */
	public boolean canPayBill(double bill) {
		// TODO -- YOUR CODE HERE
		int totalAmount = (this.hundreds * 100) + (this.fifthies * 50) + (this.twenties * 20) + (this.fives * 5) + this.ones;

		if(totalAmount >= bill) {
			return true;
		}
//		else if (totalAmount < bill) {
//		return false;
//		}// Dummy return. PLease replace.
		else
			return false;
	}

	/**
	 * EXERCISE #6
	 * 
	 * Calculate the average amount of bills in the wallet.
	 * Ex. If there is one dollar for each type of dollar the average is 1.
	 */
	public int averageBills() {
		// TODO -- YOUR CODE HERE
		int averageBill = ((this.hundreds) + (this.fifthies) + (this.twenties) + (this.fives) + this.ones)/5;
		return averageBill; // Dummy return. PLease replace.
	}
}