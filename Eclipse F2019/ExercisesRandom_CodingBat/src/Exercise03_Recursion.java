
public class Exercise03_Recursion {

//	We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
//
//
//	bunnyEars(0) → 0
//	bunnyEars(1) → 2
//	bunnyEars(2) → 4
//	https://codingbat.com/prob/p183649

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(bunnyEars(10));

	}

	public static int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}
		else
			return 2 + bunnyEars(bunnies - 1);
	}
}
