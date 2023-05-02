package mainw;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import mainw.P3Wrapper.BinarySearchTree;
import mainw.P3Wrapper.KeyValuePair;


public class P3WrapperTestStd {
	
	BinarySearchTree<Integer, Integer> T1;
	BinarySearchTree<Integer, Integer> T2;

	//// 
	/// Integer Comparator
	public static class IntegerComparator implements Comparator<Integer> {
		
		public IntegerComparator() {
			
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
		 
	}
	
	public static void print(ArrayList<KeyValuePair<Integer, Integer>> l, PrintStream P) {
		P.print("[ ");
			
		for (KeyValuePair<Integer, Integer> o: l) {
			P.print(o.getValue() + " ");
		}
		
		P.println("]");
		
	}
	@Before
	public void setUp() throws Exception {
		T1 = new BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T1.put(50, 50);
		T1.put(10, 10);
		T1.put(56, 56);
		T1.put(2, 2);
		T1.put(23, 23);
		T1.put(70, 70);
		T1.put(0, 0);
		T1.put(61, 61);
		
		T2 = new BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T2.put(20, 20);
 
	}

	@Test
	public void test1() {
		System.err.println("**Test 1 tree T1: \n");
		this.T1.print(System.err);
		
		ArrayList<KeyValuePair<Integer, Integer>> L = T1.lessThanValues(3);
		System.err.println("*Test 1 T1.lessThanValues(3): \n");
		print(L, System.err);
		assertEquals("Fails lessThanValues(3) on T1. Expected value: [2, 0]", true, 
				L.get(0).getValue() == 2 && L.get(1).getValue() == 0);
		System.err.println("\n**Passes Test1 \n");

	}

	@Test
	public void test2() {
		System.err.println("**Test 2 tree T2: \n");
		this.T2.print(System.err);
		
		ArrayList<KeyValuePair<Integer, Integer>> L = T2.lessThanValues(10);
		System.err.println("*Test 2 T2.lessThanValues(10): \n");
		print(L, System.err);
		assertEquals("Fails lessThanValues(10) on T2. Expected value: []", true, L.isEmpty());
		System.err.println("\n**Passes Test2 \n");

	}


}