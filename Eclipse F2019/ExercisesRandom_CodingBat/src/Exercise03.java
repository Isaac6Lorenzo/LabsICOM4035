import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Exercise03 {
	
		//******URL: https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true********
	
	private static final Scanner scanner = new Scanner(System.in);
//	private static int min = 0;
//	private static int max = 0;

	public static void main(String[] args) {
		int[] arr = new int[5];

//		String[] arrItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < 5; i++) {
//			int arrItem = Integer.parseInt(arrItems[i]);
//			arr[i] = arrItem;
//		}
		
		getRandomInt(arr);
		printArray(arr);
		
		// ordSelAsc(arr);
		Arrays.sort(arr);
		printArray(arr);

		miniMaxSum(arr);

		//scanner.close();

	}

	// Complete the miniMaxSum function below.
	public static void miniMaxSum(int[] arr) {
		int min=0, max=0;
		// min
		for (int i = 0; i < arr.length - 1; ++i) {
			min += arr[i];
		}

		// max
		for (int i = 1; i < arr.length; ++i) {
			max += arr[i];
		}
		System.out.println(min + " " + max);

	}

	// PARA ORDENAR DE FORMA ASCENDENTE LOS INT DENTRO DEL ARRAY ARR
	// PARA USAR EN MIN & MAX METHOD IN ANY CASE

	public static void ordSelAsc(int[] arr) {
		// iteramos sobre los elementos del arreglo
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			// buscamos el menor número
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j; // encontramos el menor número
				}
			}
			if (i != min) {
				// permutamos los valores
				int aux = arr[i];
				arr[i] = arr[min];
				arr[min] = aux;
			}
		}
	}
	
	
	public static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println("");
	}
	
	public static int[] getRandomInt(int[] newArr) {
		Random gen = new Random();
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = gen.nextInt(10);
		}
		return newArr;
	}
	
//	public static int getMax() {
//		return max;
//	}
//	
//	public static int getMin() {
//		return min;
//	}

}
