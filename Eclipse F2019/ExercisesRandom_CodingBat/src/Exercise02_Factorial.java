
public class Exercise02_Factorial {

	
//	Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
//			factorial(1) → 1
//			factorial(2) → 2
//			factorial(3) → 6
//	https://codingbat.com/prob/p154669
	
	
	public static void main(String[] args) {
		int n = 4; //cambiar el valor de n a voluntad

		int factorial = 1;

//		while (n != 0) {
//			factorial *= n;
//			n--;
//		}

		getFactorial(n);
		
		System.out.println(getFibo(n));

	}
	
	public static int getFactorial(int n) {
		if(n == 0)
			return 1;
		
		return getFactorial(n - 1 ) * n;
	}
	public static int getFibo(int f) {
		if (f == 1)
			return 1;
		if (f == 2) {
			return 2;
		}
		else
		return getFibo(f - 2) + getFibo(f - 1);
	}
 
}
