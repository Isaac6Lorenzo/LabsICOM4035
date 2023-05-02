import java.util.Scanner;

public class CharacterMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a character for sequence 1:");
		sequence1(sc.nextLine().charAt(0));
		System.out.println();
		System.out.println("Please enter a character for sequence 2:");
		sequence2(sc.nextLine().charAt(0));
		sc.close();
	}

	/*
	 * Exercise 1:
	 * print true if ch is equal to 'a' and false otherwise 
	 * print true if ch is a digit and false otherwise 
	 * print true if ch is in lower-case and false otherwise
	 */

	public static void sequence1(char ch) {
		// write code
		/*
		  	Hint: if statement in java
			if(condition){
				//true condition statement
			} else{
				//alternative statement
			}
		 */
		if(ch =='a') {
			System.out.println("true");
		}
		else
			System.out.println("false");

		//2
		if(Character.isDigit(ch)) {
			System.out.println("true");

		}
		else
			System.out.println("false");

		//3
		if(Character.isLowerCase(ch)) {
			System.out.println("true");
		}
		else
			System.out.println("false");

	}

	/*
	 * Exercise 2:
	 * 1print true if ch is equal to 'Z' and false otherwise
	 * 2print true if ch is an alphabet letter and false otherwise
	 * 3print the lower case version of ch
	 * 4print true if ch is in upper-case and false otherwise
	 * 5print the upper case version of ch 
	 * 6print true if upper-case ch is equal to lower-case ch and false otherwise
	 */
	public static void sequence2(char ch) {
		// write code

		//1
		if(ch == 'Z') {
			System.out.println("true");
		}
		else
			System.out.println("false");

		//2
		if(Character.isAlphabetic(ch)) {
			System.out.println("true");
		}
		else
			System.out.println("false");

		//3
		System.out.println(Character.toLowerCase(ch));
	
		

		//4
		if(Character.isUpperCase(ch)) {

			System.out.println("true");
		}
		else
			System.out.println("false");

		//5
		System.out.println(Character.toUpperCase(ch));
		
		//6
		if(Character.toLowerCase(ch) == Character.toUpperCase(ch)) {
			System.out.println("true");
		}
		else
			System.out.println("false");

	}
}