import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecursionB {

	/**
	 * Exercise #1
	 * Returns the kth power of n modulo m
	 * MUST BE RECURSIVE
	 * @param n
	 * @param k
	 * @param m
	 * @return
	 */
	public static int powerMod(int n, int k, int m) {
		// TODO YOUR CODE HERE

		//https://www.geeksforgeeks.org/modular-exponentiation-recursive/
		// Base cases  
		if (n == 0)  
			return 0;  
		if (k == 0)  
			return 1;  

		// If B is even  
		long y;  
		if (k % 2 == 0) 
		{  
			y = powerMod(n, k / 2, m);  
			y = (y * y) % m;  
		}  

		// If B is odd  
		else 
		{  
			y = k % m;  
			y = (y * powerMod(n, k - 1, m) % m) % m;  
		}  

		return (int)((y + m) % m);  



		//		return -1; // Dummy return

	}

	/**
	 * Exercise #2
	 * Returns a string representing the input String with the first
	 * k occurrences of the pattern removed.
	 */
	public static String deleteK(String input, String pattern, int k) {
		// TODO YOUR CODE HERE
		if(input.length() == 0) {return input;}

		boolean find = input.matches(pattern);

		return null; // Dummy return
	}


	/**
	 * Exercise #3 
	 * Returns all possible committees of k members that can be formed from
	 * an assembly of n members. Every member is represented by a String consisting
	 * of his/her full name.  Both assemblies and committees are represented 
	 * as Set's of members (Strings).
	 * 
	 * MUST BE RECURSIVE2
	 */
	public static ArrayList<Set<String>> kCommittees(Set<String> assembly, int k) {
		ArrayList<Set<String>> result = new ArrayList<Set<String>>();
		// TODO YOUR CODE HERE

		return null; // Dummy Return
	}


}