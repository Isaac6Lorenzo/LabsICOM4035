//Suppose you are given an array list of Set<Integer> instances. 
//Write a non-member static method called checkDisjoint() which 
//returns true if the intersection of the array list of sets is 
//empty, or false otherwise.  If the array list is empty, them 
//the method returns true. 

import java.io.PrintStream;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Lab03P2Wrapper {
	public static interface Set<E> {

		public int size();

		public boolean isEmpty();

		public boolean isMember(E obj);

		public boolean add(E obj);

		public boolean remove(E obj);

		public void clear();

		public Set<E> union(Set<E> S2); // this union S2

		public Set<E> difference(Set<E> S2);

		public Set<E> intersection(Set<E> S2);

		public boolean isSubset(Set<E> S2);

		public Object[] toArray();

		public void print(PrintStream out);

	}

	public static class ArraySet<E> implements Set<E> {

		private E[] elements;

		private int currentSize;

		private static final int DEFAULT_SIZE = 10;

		public ArraySet(int initialSize){
			if (initialSize < 1){
				throw new IllegalArgumentException("Set size must be at least 1.");
			}
			this.currentSize = 0;
			this.elements = (E[]) new Object[initialSize];
		}
		public ArraySet(){
			this(DEFAULT_SIZE);
		}
		@Override
		public int size() {
			return this.currentSize;
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public boolean isMember(E obj) {
			for (int i=0; i < this.size(); ++i){
				if (this.elements[i].equals(obj)){
					// found
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean add(E obj) {
			if (this.isMember(obj)){
				return false;
			}
			else {
				// add it

				// check space
				if (this.size() == this.elements.length){
					// re-allocate
					this.reAllocate();
				}
				this.elements[this.currentSize++] = obj;
				return true;
			}

		}

		private void reAllocate() {
			int newSize = this.size() * 2;
			E[] newElements = (E[]) new Object[newSize];

			// copia pelo a pelo
			// tambien puede usar arrayCopy de System
			// para ser vago y no hacer el loop
			for (int i=0; i < this.size(); ++i){
				newElements[i] = this.elements[i];
			}

			// does not work
			//newElements = this.elements;

			this.elements = newElements;
			return;
		}

		@Override
		public boolean remove(E obj) {
			for (int i=0; i < this.size(); ++i){
				if (this.elements[i].equals(obj)){
					// found it!!
					this.elements[i] = this.elements[this.currentSize-1]; // replace with last one
					this.elements[this.currentSize-1] = null; // remove extra copy
					this.currentSize--;
					return true;
				}
			}
			return false;
		}

		@Override
		public void clear() {
			for (int i=0; i < this.size(); ++i){
				this.elements[i] = null;
			}
			this.currentSize = 0;
			// this.elements = null;  // Danger - null pointer
		}


		@Override
		public Set<E> union(Set<E> S2) {
			// this -> S1
			// S2 -> S2
			// result -> S3


			// this is what I meant to be S1
			// result holds
			Set<E> result = new ArraySet<E>(this.size() + S2.size());
			for (int i=0; i < this.size(); ++i){
				result.add(this.elements[i]);
			}
			//E[] temp2 = ((ArraySet<E>)S2).elements;

			E[] temp = (E[]) S2.toArray();
			if (temp !=null) {
				for (int i = 0; i < S2.size(); ++i) {
					result.add(temp[i]);
					//result.add(((ArraySet<E>)S2).elements[i]);
					///result.add((E) S2.toArray()[i]);

				}
			}
			return result; // S3
		}

		@Override
		public Set<E> difference(Set<E> S2) {
			Set<E> result = new ArraySet<E>();

			for (int i =0; i < this.size(); ++i){
				if (!S2.isMember(this.elements[i])){
					result.add(this.elements[i]);
				}
			}
			return result;
		}

		@Override
		public Set<E> intersection(Set<E> S2) {
			//        Set<E> result = new ArraySet<E>();
			//        for (int i =0; i < this.size(); ++i){
			//            if (S2.isMember(this.elements[i])){
			//                result.add(this.elements[i]);
			//            }
			//        }
			//        return result; //Fo! too 4010/4015

			// in one line??

			return this.difference(this.difference(S2));
		}

		@Override
		public boolean isSubset(Set<E> S2) {

			// S1 = this
			// S2 = S2
			// If S1 is subset of S2
			//        for (int i=0; i < this.size(); ++i){
			//            if (!S2.isMember(this.elements[i])){
			//                return false;
			//            }
			//        }
			//        return true; // Not cool

			return this.difference(S2).isEmpty();
			//return this.difference(S2).size() == 0;
		}

		@Override
		public Object[] toArray() {
			if (this.size() == 0){
				return null;
			}
			else {
				Object[] result = new Object[this.size()];
				for (int i = 0; i < this.size(); ++i){
					result[i] = this.elements[i];
				}
				return result;
			}
		}

		@Override
		public void print(PrintStream out) {
			//for (E e: this.elements){
			for (int i=0 ; i < this.size(); ++i){
				out.print(this.elements[i]);
				out.print(" ");
			}
			out.println();
		}
	}

	// Non-member method of class Lab03P1Wrapper
	public static boolean checkDisjoint(ArrayList<Set<Integer>> sets){
		// ADD YOUR CODE HERE
		if (sets.isEmpty()) {
			return true;
		}

		Object[] obj =  sets.toArray();
		for(int i=0; i<obj.length; i++){
			for (int j = 0; j < obj.length; j++) {
				if(((Set) obj[i]).intersection((Set)obj[j]).isEmpty()) {
					return true;
				}
			}
		}


		return false;

	}

	public static <E> void main(String[] args) {
		Set<E> temp = new  ArraySet<E>(1);
		Set<E> temp1 = new  ArraySet<E>(1);
		Set<E> temp2 = new  ArraySet<E>(1);
		Set<E> temp3 = new  ArraySet<E>(1);

		Set<String> S1 = new  ArraySet<String>(1);
		Set<String> S2 = new  ArraySet<String>(1);
		Set<E> S3 = new  ArraySet<E>(1);


		S1.add("Ron");
		S1.add( "Jil");
		S1.add( "Ken");
		S1.add( "Ron");


		S2.add( "Ned");
		S2.add( "Ron");

		Set<String> S4 = S2.difference(S1.union(S2));
		System.out.println(S4.isEmpty());
//		Object[] obj = S4.toArray();
//		for (int i = 0; i < obj.length; i++) {
//			System.out.println(obj[i]);
//		}
		//	ArrayList<Set<Integer>> obj = new ArrayList<Set<Integer>>();
		//	temp.add((E) "10");
		//	temp.add((E) "1");
		//	temp.add((E) "20");
		//
		//	temp1.add((E) "2");
		//
		//	temp2.add((E) "-1");
		//	temp2.add((E) "0");
		//
		//	temp3.add((E) "0");
		//
		//	obj.add((Set<Integer>) temp3);
		//	obj.add((Set<Integer>) temp2);
		//	obj.add((Set<Integer>) temp1);
		//	obj.add((Set<Integer>) temp);
		//
		//	//print sequencia
		//	
		//	boolean info = checkDisjoint(obj);
		//	System.out.println("boolen answer: " + info);
	}
}
