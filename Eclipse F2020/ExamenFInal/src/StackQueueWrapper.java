public class StackQueueWrapper{
	
	public static interface Stack<E> {
		
		public int size();
		public boolean isEmpty();
		public void push(E e);
		public E pop();
		public E top();
		public void clear();
		 /* The toArray method is for testing purposes only; 
		  * it's not really part of the ADT */
		public E[] toArray();
	}
	
	public static interface Queue<E> {

		public void enqueue(E e);
		public E dequeue();
		public E front();
		public boolean isEmpty();
		public void clear();
		public int size();
		public E[] toArray();
	}
	
	public static class LinkedListStack<E> implements Stack<E> {

		// private fields
		private int currentSize;
		private Node header;
		
		@SuppressWarnings("unused")
		// node class
		
		private class Node {
			private E value;
			private Node next;
			
			public Node(E value, Node next) {
				this.value = value;
				this.next = next;
			}
			
			public Node(E value) {
				this(value, null); // Delegate to other constructor
			}
			
			public Node() {
				this(null, null); // Delegate to other constructor
			}

			public E getValue() {
				return value;
			}

			public void setValue(E value) {
				this.value = value;
			}

			public Node getNext() {
				return next;
			}

			public void setNext(Node next) {
				this.next = next;
			}
			
			public void clear() {
				value = null;
				next = null;
			}				
		} // End of Node class

		public LinkedListStack() {
			currentSize = 0;
			header = new Node();
		}

		@Override
		public int size() {
			return currentSize;
		}

		@Override
		public boolean isEmpty() {
			return size() == 0;
		}

		@Override
		public void push(E e) {
			if (e == null)
				throw new IllegalArgumentException("Parameter cannot be null");
			Node newNode = new Node(e, header.getNext());
			header.setNext(newNode);
			currentSize++;
		}

		@Override
		public E pop() {
			if (isEmpty())
				return null;
			Node rmNode = header.getNext();
			E result = rmNode.getValue();
			header.setNext(rmNode.getNext());
			rmNode.clear();
			currentSize--;
			return result;
		}

		@Override
		public E top() {
			if (isEmpty())
				return null;
			return header.getNext().getValue();
		}

		@Override
		public void clear() {
			while (!isEmpty())
				pop();
		}

		@SuppressWarnings("unchecked")
		@Override
		public E[] toArray() {
			E[] theArray = (E[]) new Object[size()];
			
			/* First node is top of the stack,
			 * which we want at the end of the array. */
			int i = size() - 1;
			for (Node curNode = header.getNext(); curNode != null; curNode = curNode.getNext())
				theArray[i--] = curNode.getValue();
			return theArray;
		}

	}
	
	/**
	 * Implementation of the Queue ADT using a Stack
	 * @author Fernando J. Bermudez & Gabriel Y. Diaz Morro
	 *
	 */
	public static class StackQueue<E> implements Queue<E>{
		private Stack<E> stack;
		private Stack<E> s2;
		
		
		public StackQueue() {
			stack = new LinkedListStack<>();
			s2 = new LinkedListStack<>();
	
		}
		
		/**
		 * EXERCISE A 
		 * 
		 * Implement the enqueue() method for the StackQueue ADT only using stack & s2
		 * 
		 * Restriction: You can only use push(), pop(), top() & isEmpty() methods 
		 * 
		 * HINT: 
		 * 		Keep in mind you are given two tacks to work with (stack & s2). 
		 * 		How can you take advantage of this to simulate the behavior of a queue?
		 *
		 * HINT: 
		 * 	 	Keep in mind that using the two stacks, the top() of one of the stacks 
		 * 		should represent the front() of the Queue so it can be accessed in O(1). 
		 *  
		 */
		@Override
		public void enqueue(E e) {
			//WRITE YOUR CODE HERE
			if(stack.isEmpty()) {
				stack.push(e);
			}

			while(!stack.isEmpty()) {
				s2.push(stack.pop());
			}

			stack.push(e);

			while(!s2.isEmpty()) {
				stack.push(s2.pop());
			}
		}
	
		
		/**
		 * EXERCISE B
		 * 
		 * Implement the dequeue() method for the StackQueue ADT only using stack & s2
		 * 
		 * Restriction: You can only use push(), pop(), top() & isEmpty() methods 
		 * 
		 * HINT: 
		 * 		Keep in mind you are given two tacks to work with (stack & s2).
		 *		These two data structures have many similarities in common when it comes to their behavior.
		 * 		How can you take advantage of this to simulate the behavior of a queue?
		 *  
		 */
		@Override
		public E dequeue() {
			//WRITE YOUR CODE HERE
			if (stack.isEmpty()) {
				return null;
			}
			return stack.pop();
		}
		
		
		/**
		 * EXERCISE Part C
		 * 
		 * Implement the top() method for the StackQueue ADT only using stack & s2
		 * 
		 * Restriction: You can only use push(), pop(), top() & isEmpty() methods from the stack field
		 * 
		 */
		@Override
		public E front() {
			//WRITE YOUR CODE HERE
			return stack.top();
		}
	
		@Override
		public boolean isEmpty() {
			return stack.isEmpty();
		}
	
		@Override
		public void clear() {
			stack.clear();
		}
	
		@Override
		public int size() {
			return stack.size();
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public E[] toArray() {
			E[] array = (E[]) new Object[size()];
			int i = 0;
			while(!isEmpty() && i < size()) {
				E value = dequeue();
				array[i++] = value;
				enqueue(value);
			}
			
			return array;
		}
	
	}
}
