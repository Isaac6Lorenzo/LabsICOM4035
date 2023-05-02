//Write a member method for the class DoublyLinkedQueue named enqueueBefore(). This method enqueue an element f before the first occurrence  of element e from the end of the queue.  If element e is not present in the queue, then the element f is not added at all. The method receives as parameters the elements e and f. 
//
//For example, if Q = {Jim, Bob, Ron, Apu, Ned, Ron, Ken}, with Jim at the head of the queue, then Q.enqueueBefore(Ron, Tom) will turn Q into {Jim, Bob, Ron, Apu, Ned, Tom, Ron, Ken}.

import java.io.PrintStream;


public class ProblemQueue1Wrapper {
	public interface Queue<E> {

		public int size();

		public boolean isEmpty();

		public E front();

		public void enqueue(E e);

		public E dequeue();

		public void makeEmpty();

		public void print(PrintStream P);

		public void enqueueBefore(E e, E f);

	}

	public static class DoublyLinkedQueue<E> implements Queue<E> {

		private static class Node<E>{
			private E element;
			private Node<E> next;
			private Node<E> prev;

			public Node() {
				this.element = null;
				this.next = this.prev = null;

			}
			public E getElement() {
				return element;
			}
			public void setElement(E element) {
				this.element = element;
			}
			public Node<E> getNext() {
				return next;
			}
			public void setNext(Node<E> next) {
				this.next = next;
			}
			public Node<E> getPrev() {
				return prev;
			}
			public void setPrev(Node<E> prev) {
				this.prev = prev;
			}

		}

		private Node<E> header;
		private Node<E> tail;
		private int currentSize;

		public DoublyLinkedQueue() {
			this.currentSize = 0;
			this.header = new Node<>();
			this.tail = new Node<>();

			this.header.setNext(this.tail);
			this.tail.setPrev(this.header);
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
		public E front() {
			return (this.isEmpty() ? null : this.header.getNext().getElement());
		}

		@Override
		public E dequeue() {
			if (this.isEmpty()) {
				return null;
			}
			else {
				Node<E> target = null;
				target = this.header.getNext();
				E result = target.getElement();
				this.header.setNext(target.getNext());
				target.getNext().setPrev(this.header);
				target.setNext(null);
				target.setPrev(null);
				target.setElement(null);
				this.currentSize--;
				return result;
			}
		}

		@Override
		public void enqueue(E e) {
			Node<E> newNode = new Node<E>();
			newNode.setElement(e);
			newNode.setNext(this.tail);
			newNode.setPrev(this.tail.getPrev());
			this.tail.setPrev(newNode);
			newNode.getPrev().setNext(newNode);
			this.currentSize++;
		}

		@Override
		public void makeEmpty() {
			while (this.dequeue() != null);

		}

		@Override
		public void print(PrintStream P) {
			// TODO Auto-generated method stub
			Node<E> temp = this.header.getNext();
			while(temp != this.tail) {
				P.println(temp.getElement());
				temp = temp.getNext();
			}
		}

		@Override
		public void enqueueBefore(E e, E f) {
			// ADD CODE HERE
			int count = 0;
			int countE = 0 ;
			
			if (this.size() == 1 && this.front().equals(e)) {
				E str = this.dequeue();
				this.enqueue(f);
				this.enqueue(str);
			}
			
			
			
			if(this.size() > 2) {
			while(count < this.size()) {
				E str = this.front();
				if (str.equals(e)) {
					countE++;
//					if (countE > 1) {
					
						this.enqueue(f);
						
//					}

				}
//				else
					this.enqueue(this.dequeue());

				count++;
			}
		}
		}	

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> list = new DoublyLinkedQueue<String>();
		list.enqueue("Jim");
		list.enqueue("Bob");
		list.enqueue("Ron");
		list.enqueue("Apu");
		list.enqueue("Ned");
		list.enqueue("Ron");
		list.enqueue("Ken");
//		list.enqueue("Jim");
		list.enqueueBefore("Jim", "Mel");
		while(!list.isEmpty()) {
			System.out.println(list.dequeue());
		}
	}
}
	
	
//}
//
//Error description:
//On queue Q = {Jim, Bob, Ron, Apu, Ned, Ron, Ken}, Q.enqueueBefore(Jim, Mel) fails to make Q into {Mel, Jim, Bob, Ron, Apu, Ned, Ron, Ken}.
//On queue Q = {Jim, Bob, Ron, Apu, Ned, Ron, Ken}, Q.enqueueBefore(Ken, Xi) fails to make Q into {Jim, Bob, Ron, Apu, Ned, Ron, Xi, Ken}.
//On queue Q = {Jim, Bob, Ron, Apu, Ned, Ron, Ken}, Q.enqueueBefore(Ron, Amy) fails to make Q into {Jim, Bob, Amy, Ron, Apu, Ned, Amy, Ron, Ken}.
//On empty queue Q = {Bob}, Q.enqueueBefore(Bob, Xi) fails to make Q into {Xi, Bob}.

