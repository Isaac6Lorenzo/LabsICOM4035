//Write a non-member method named successors, which 
//returns a List with all the successors of an element 
//e in a List L of strings.
//
//For example, if L = {Bob, Ned, Amy, Ned, Ron}, then a 
//call to successors(L, �Ned�) returns {Amy, Ned, Ron}. 
//The method returns null if e is not in L.



import java.util.Iterator;
import java.util.NoSuchElementException;



public class Exam1a1List1Wrapper {
	public static interface List<E> extends Iterable<E> {
		
		public int size();
		
		public boolean isEmpty();
		
		public boolean isMember(E e);
		
		public int firstIndexOf(E e);
		
		public int lastIndexOf(E e);

		public void add(E e);
		
		public void add(E e, int position);
		
		public E get(int position);
		
		public E remove(int position);
		
		public E replace(int position, E newElement);
		
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

	}
	// NON-MEMBER METHODS
	
	public static List<String> successors(List<String> L, String e){
		// ADD YOUR CODE HERE
		if (!L.isMember(e)) {
			return null;
		}
	
		
		List<String> list = new ArrayList<String>();
		Iterator<String> it = L.iterator();
		while(it.hasNext()) {
			String str = it.next();
			if (str.equals(e)) {
				while (it.hasNext()) {
					String str2 = it.next();
					list.add(str2);
				}
			}
		}
		
		return list;
	}
}