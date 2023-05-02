//Write a non-member method named bottomQueue() that receives
//as parameters a queue Q and a integer N. The method 
//returns last N elements in the queue Q. After completion, 
//the queue Q must be left as it was at the beginning of 
//the function. The method returns an empty queue if Q has 
//less than N elements. 
//
//For example if Q = {Joe, Ned, Amy, Bob, Kim, Ron}, 
//with Joe at the head, then bottomQueue(Q, 3), returns 
//the queue {Bob, Kim, Ron}.

import java.io.PrintStream;

import java.util.*;

public class ProblemQueue2Wrapper {
	public interface Queue<E> {

		public int size();

		public boolean isEmpty();

		public E front();

		public void enqueue(E e);

		public E dequeue();

		public void makeEmpty();

		public void print(PrintStream P);


	}

	public static class DoublyLinkedQueue<E> implements Queue<E>{

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
	}

	public static Queue<String> bottomQueue(Queue<String> Q , int N){
		// ADD CODE HERE
		Queue<String> list = new DoublyLinkedQueue<String>();
		Queue<String> result = new DoublyLinkedQueue<String>();

		if (Q.size() < N) {
			return list;
		}

		int count = 0;
		while(count < Q.size()) {
			String string = Q.dequeue();
			list.enqueue(string);
			Q.enqueue(string);
			count++;
		}

		int y = Q.size() - N;
		int i=0;
		
		while(!list.isEmpty()) {
			if (i >= y) {
				result.enqueue(list.front());

			}
			
			list.dequeue();
			i++;

		}
		
//		while(!list.isEmpty()) {
//			System.out.println(list.dequeue());
//		}



		return result;
	}

	public static void main(String[] args) {
		Queue<String> list = new DoublyLinkedQueue<String>();
		list.enqueue("Joe");
		list.enqueue("Ned");
		list.enqueue("Amy");
		list.enqueue("Bob");
		list.enqueue("Kim");
		list.enqueue("Ron");
		list.enqueue("Ed");

		//		String str = list.toString();
		//		String[] array = str.split(",");
		Queue<String> newList = bottomQueue(list, 4);
		while(!newList.isEmpty()) {

			String string = newList.dequeue();
			System.out.println("String: " + string);

		}





	}


	//Error description:
	//On queue Q = {Joe, Ned, Amy, Bob, Kim, Ron} bottomQueue(Q, 1) 
	//fails to return queue {Ron} and leaveQ as it was.
	//On queue Q = {Joe, Ned, Amy, Bob, Kim, Ron} bottomQueue(Q, 2) 
	//fails to return queue {Kim, Ron} and leaveQ as it was.
	//On queue Q = {Joe, Ned, Amy, Bob, Kim, Ron} bottomQueue(Q, 3) 
	//fails to return queue {Bob, Kim, Ron} and leaveQ as it was.
	//On queue Q = {Joe, Ned, Amy, Bob, Kim, Ron, Ed} bottomQueue(Q, 4) 
	//fails to return queue {Bob, Kim, Ron, Ed} and leave Q as it was.




}
