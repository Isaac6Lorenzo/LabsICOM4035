//Write a non-member method named arrayListMerger() which 
//receives as parameter two array lists of strings. 
//Both on these array lists are already sorted in 
//increasing order. The method merges the two lists 
//producing a new array list, with all the elements 
//ordered in increasing order.  The method takes time 
//O(N+M) where N = L1.size(), and M = L2.size(). 
//Solutions that are O(N*M) will only get 50% of the points. 
//
//For example if the first list L1 = {Ben, Ned, Zoe}, 
//and the second list L2 = {Apu, Cal, Sam, Xi}, then 
//the method returns the following list: {Apu, Ben, Cal, Ned, Sam, Xi, Zoe}. 
//
//Hint: First traverse both L1 and L2 simultaneously to 
//add to the result in the right order. Then, because the 
//lists might have different sizes, you will run out of
//elements from one of them. You then need to add the remainder
//elements of this one.



import java.util.Iterator;
import java.util.NoSuchElementException;

public class BigOh2Wrapper {

	public static interface List<E> extends Iterable<E> {

		public int size();

		public boolean isEmpty();

		public boolean isMember(E e);

		public int firstIndexOf(E e);

		public int lastIndexOf(E e);

		public void add(E e);

		public void add(E e, int index);

		public E get(int index);

		public E remove(int index);

		public boolean remove(E e);

		public int removeAll(E e);

		public E replace(int index, E newElement);

		public void clear();

		public Object[] toArray();	


	}

	@SuppressWarnings("unchecked")

	public static class ArrayList<E> implements List<E> {
		@SuppressWarnings("hiding")
		private class ArrayListIterator<E> implements Iterator<E> {

			private int currentPosition;



			public ArrayListIterator() {
				super();
				this.currentPosition = 0;

			}

			@Override
			public boolean hasNext() {
				return this.currentPosition < currentSize;
			}

			@Override
			public E next() {
				if (this.hasNext()) {
					E result = (E) elements[this.currentPosition++]; // elements is array in enclosing class
					return result;
				}
				else {
					throw new NoSuchElementException();
				}
			}

		}

		private E[] elements;
		private int currentSize;
		private static final int DEFAULT_SIZE = 10;

		public ArrayList(int initialSize) {
			if (initialSize < 1) {
				throw new IllegalArgumentException("Size must be at least 1.");
			}
			this.elements = (E[]) new Object[initialSize];
			this.currentSize = 0;
		}

		public ArrayList() {
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
		public boolean isMember(E e) {
			return this.firstIndexOf(e) >= 0;
		}

		@Override
		public int firstIndexOf(E e) {
			for (int i=0; i < this.size(); ++i) {
				if (this.elements[i].equals(e)) {
					return i;
				}
			}
			return -1;
		}

		@Override
		public void add(E e) {
			if (this.size() == this.elements.length) {
				this.reAllocate();
			}
			this.elements[this.currentSize++]  = e;
		}

		private void reAllocate() {
			E[] temp = (E[]) new Object[2*this.size()];
			for (int i=0; i < this.size(); ++i) {
				temp[i] = this.elements[i];
			}
			this.elements = temp;
		}

		@Override
		public void add(E e, int position) {
			if ((position < 0) || (position > this.currentSize)){
				throw new IndexOutOfBoundsException("Illegal position");
			}
			if (position == this.currentSize) {
				this.add(e);
			}
			else {
				if (this.size() == this.elements.length) {
					this.reAllocate();
				}
				for (int i=this.currentSize; i > position; --i) {
					this.elements[i] = this.elements[i-1];
				}
				this.elements[position] = e;
				this.currentSize++;
			}	
		}

		@Override
		public E get(int position) {
			if ((position < 0) || (position >= this.currentSize)) {
				throw new IndexOutOfBoundsException("Illegal position");
			}
			return this.elements[position];
		}

		@Override
		public E remove(int position) {
			if ((position < 0) || (position >= this.currentSize)) {
				throw new IndexOutOfBoundsException("Illegal position");
			}
			E result = this.elements[position];

			for (int i=position; i < this.size() - 1; ++i) {
				this.elements[i] = this.elements[i + 1];
			}
			this.elements[this.currentSize-1] = null;
			this.currentSize--;
			return result;

		}

		@Override
		public E replace(int position, E newElement) {
			if ((position < 0) || (position >= this.currentSize)) {
				throw new IndexOutOfBoundsException("Illegal position");
			}
			E result = this.elements[position];
			this.elements[position] = newElement;
			return result;
		}

		@Override
		public void clear() {
			while(!this.isEmpty()) {
				this.remove(0);
			}
		}

		@Override
		public Object[] toArray() {
			Object[] result = (E[]) new Object[this.size()];
			System.arraycopy(this.elements, 0, result, 0, this.size());
			//			for (int i=0; i < this.size(); ++i) {
			//				result[i] = this.elements[i];
			//			}
			return result;
		}

		@Override
		public Iterator<E> iterator() {
			return new ArrayListIterator<E>();
		}

		@Override
		public int lastIndexOf(E e) {
			for (int i=this.currentSize-1; i>= 0; --i) {
				if (this.elements[i].equals(e)) {
					return i;
				}
			}
			// not found
			return -1;
		}

		@Override
		public boolean remove(E e) {
			int target = this.firstIndexOf(e);
			if (target < 0) {
				return false;
			}
			else {
				this.remove(target);
				return true;
			}
		}

		@Override
		public int removeAll(E e) {
			int result = 0;
			while(this.remove(e)) {
				result++;
			}
			return result;
		}


	}

	public static ArrayList<String> arrayListMerger(ArrayList<String> L1, ArrayList<String> L2) {
		// ADD CODE HERE
		
		ArrayList<String> L3 = new ArrayList<String>();
		int i = 0;
		int j = 0;
		
		// First traverse simultaneously both lists, like we did in P1 with the add(Polynomial P2); method
		while (i < L1.size() && j < L2.size()) {
			
			//Add elements in order,
			int compare = L1.get(i).compareTo(L2.get(j));
			
			if (compare < 0) {
				L3.add(L1.get(i));
				i++;
			}
			else {
				L3.add(L2.get(j));
				j++;
			}
		}
		
		// Now add any left over of L1
		while(i < L1.size()) {
			L3.add(L1.get(i));
			i++;
		}
		// Now add any left over of L2
		while(j < L2.size()) {
			L3.add(L2.get(j));
			j++;
		}
		
		return L3;


		
		
//		ArrayList<String> L3 = new ArrayList<String>();
//		Iterator<String> it = L1.iterator();
//		int sizeL2 = L2.size();
//		int index = 0;
//		
//		while(it.hasNext() || index != sizeL2-1) {
//			String str1 = it.next();
//			String str2 = L2.get(index);
//			System.out.println("Index: " + index);
//			if (str1 != null && str2 != null) {
//				int compare = str1.compareTo(str2);
//
//				if (compare > 0) {
//					L3.add(str2);
//					L3.add(str1);
//				}
//				if (compare < 0) {
//					L3.add(str1);
//					L3.add(str2);
//				}
//				
//				else if(compare == 0) {
//					L3.add(str1);
//					L3.add(str2);
//				}
//			}
//
//
//			else if(str1 != null && str2 == null){
//				L3.add(str1);
//			}
//
//			else if(str1 == null && str2 != null){
//				L3.add(str1);
//			}
//			
//			index++;
//		}
//
//		//L3.add(L2.get(sizeL2 - 1));
//
//		return L3;
	}

	public static void main(String[] args) {
		ArrayList<String> L1 = new ArrayList<String>();
		L1.add("Al");
		L1.add("Joe");
		L1.add("Ned");
		ArrayList<String> L2 = new ArrayList<String>();
		L2.add("Cal");
		L2.add("Ned");
		L2.add("Xi");

		ArrayList<String> L3 = arrayListMerger(L1, L2); 
		
		for(String s : L3) {
			System.out.println("String: " + s);	

		}

	}
}
