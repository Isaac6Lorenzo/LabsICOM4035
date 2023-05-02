public class Card {
	
	private String suit; //Suit of a card, it goes between Diamond, Spade, Club or Heart
	private int rank; // Rank of a card, it goes between 1 till 13 (In order of A, 2, 3,..., 10, J, Q, K)

	/**
	 * A constructor that requires a suit and rank input to initialize a card
	 * @param suit
	 * @param rank
	 */
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * A constructor that uses a different Card to initialize the new card.
	 * @param otherC
	 */
	public Card(Card otherC) {
		//Add code
		otherC.suit = this.suit;
		otherC.rank = this.rank;
		
	}
	
	
	/**
	 * Override of the method toSting this helps us control how to print a card object.
	 * @return The string "[R,S]" where R is rank and S is suit
	 */
	@Override
	public String toString() {
		return "[" + rank  + "," + suit + "]";
	}

	/**
	 * Override of the equals method to control how card objects are to be compared.
	 * @return comparison 
	 */
	@Override
	public boolean equals(Object c2) {
		if (!(c2 instanceof Card)) {
			throw new RuntimeException("Illegal argument to Card.equals()");
		}
		Card card2 = (Card) c2;
		return ((this.getSuit().equals(card2.getSuit())) && 
				(this.getRank() == card2.getRank()));
	}

	/**
	 * Suit Getter
	 * @return suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Rank Getter
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Suit Setter
	 * @return suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Rank Setter
	 * @return rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * Checks if two cards have the same suit
	 * @param card2
	 * @return boolean
	 */
	public boolean sameSuitAs(Card card2) {
		return (this.getSuit().equals(card2.getSuit()));
	}

	/**
	 * Checks if two cards have the same rank
	 * @param card2
	 * @return boolean
	 */
	public boolean sameRankAs(Card card2) {
		return (this.getRank() == card2.getRank());
	}
	
	/**
	 * Returns if a card is an ace
	 * @return boolean
	 */
	public boolean isAnA() { 
		//Add code
		return false; //Temporary Return 
//		return this.getRank("ACE"); //Temporary Return 

	}
	
	/**
	 * Checks if two cards have the same rank
	 * @param c
	 * @return boolean
	 */
    public boolean isPair(Card c) {
        //Add code
		return false; //Temporary Return
//		return sameRankAs(c); //Temporary Return

    }
    
    /**
	 * Checks if three cards have the same rank
	 * @param c1, c2
	 * @return boolean
	 */
    public boolean isTrio(Card c1, Card c2) {
        //Add code
		return false; //Temporary Return 
    }

    /**
	 * Checks if four cards have the same rank
	 * @param c1, c2, c3
	 * @return boolean
	 */
    public boolean isFourTuple(Card c1, Card c2, Card c3) {
        //Add code
		return false; //Temporary Return 
    }
    
   
    /**
     * A method that checks if the target card c1 is a rank
 	* higher than the object card.
 	* @return boolean
     */
    public boolean isConsecutive(Card c1) {
    	return rank + 1 == c1.getRank();
    }
    
    /**
	 * A method that returns true as soon a it has found
	 * that the given card exist in the deck
	 * @param target
	 * @return boolean
	 */
	public boolean cardExistsIn(Card[] deck) {
	    //Add code
		return false; //Temporary Return  
	}
	
	/**
	 * A method that returns true as soon as it has found an existing pair
	 * in the deck
	 * @return boolean
	 */
	public boolean pairExists(Card[] deck) {
		//Add code
		return false; //Temporary Return
	}
	
	/**
	 * A method that returns a boolean as soon as it knows if a 
	 * deck is a flush.
	 * Note: When we say flush, we mean that all the cards in
	 * the deck are of the same suit.
	 * @return boolean
	 */
	public boolean isFlush(Card[] deck) {
		//Add code
		return false; //Temporary Return
	}
	
	/**
	 * A method that returns a boolean as soon as it knows if a 
	 * deck is a consecutive straight.
	 * Note: When we say consecutive straight, we mean that all 
	 * the cards in the deck are in ascending order without
	 * ordering the cards themselves.
	 * @return boolean
	 */
	public boolean isConsecutiveStraight(Card[] deck) {
		//Add code
		return false; //Temporary Return
	}
	
	/**
	 * A method that checks if the deck is a consecutive
	 * straight flush with the previously mentioned restrains. 
	 * @return
	 */
	public boolean isConsecutiveStraightFlush(Card[] arr) {
		//Add code
		return false; //Temporary Return
	}
}