//Consider a member method of the List ADT named addBefore(). 
//This method receives as parameters two objects e and f. 
//The methods adds element f before the first copy of the 
//element e in a list L. Implement this method for the SinglyLinkedList class.
//
//For example, if L = {Ken, Bob, Ron, Apu, Ron}, the
//L.addBefore("Ron", "Jim") makeL = {Ken, Bob, Jim, Ron, Apu, Ron}. 
//
//YOU MUST IMPLEMENT ANY AUXILIARY FUNCTION THAT YOU MIGHT NEED.


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWrapper {
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
		
		public void addBefore(E e, E f);

	}
	
	public static class SinglyLinkedList<E> implements List<E> {

		@SuppressWarnings("hiding")
		private class SinglyLinkedListIterator<E> implements Iterator<E>{
			private Node<E> nextNode;
			
			

			@SuppressWarnings("unchecked")
			public SinglyLinkedListIterator() {
				this.nextNode = (Node<E>) header.getNext();
			}
			@Override
			public boolean hasNext() {
				return nextNode != null;
			}

			@Override
			public E next() {
				if (this.hasNext()) {
					E result = this.nextNode.getElement();
					this.nextNode = this.nextNode.getNext();
					return result;
				}
				else {
					throw new NoSuchElementException();
				}
			}
			
		}
		
		private static class Node<E> {
			private E element;
			private Node<E> next;
			
			public Node(E element, Node<E> next) {
				super();
				this.element = element;
				this.next = next;
			}
			public Node() {
				super();
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

			
		}

		private Node<E> header;
		private int currentSize;
		
		public SinglyLinkedList() {
			this.header = new Node<>();
			this.currentSize = 0;
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
			int i = 0;
			for (Node<E> temp = this.header.getNext(); temp != null; 
					temp = temp.getNext(), ++i) {
				if (temp.getElement().equals(e)) {
					return i;
				}
			}
			// not found
			return -1;
		}

		@Override
		public void add(E e) {
			if (this.isEmpty()) {
				this.header.setNext(new Node<E>(e, null));
				this.currentSize++;
			}
			else {
				Node<E>temp= this.header.getNext();
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				Node<E> newNode = new Node<>(e, null);
				temp.setNext(newNode);
				this.currentSize++;
			}
			
		}

		@Override
		public void add(E e, int index) {
			if ((index < 0) || (index > this.currentSize)) {
				throw new IndexOutOfBoundsException();
			}
			if (index == this.currentSize) {
				this.add(e);
			}
			else {
				Node<E> temp = null;
				if (index == 0) {
					temp = this.header;
				}
				else {
					temp = this.getPosition(index -1);
				}
				Node<E> newNode = new Node<>();
				newNode.setElement(e);
				newNode.setNext(temp.getNext());			
				temp.setNext(newNode);
				this.currentSize++;
			}
		}

		@Override
		public E get(int position) {
			if ((position < 0) || position >= this.currentSize) {
				throw new IndexOutOfBoundsException();
			}
			
			Node<E> temp  = this.getPosition(position);
			return temp.getElement();
			
		}

		private Node<E> getPosition(int index){
			int currentPosition=0;
			Node<E> temp = this.header.getNext();
			
			while(currentPosition != index) {
				temp = temp.getNext();
				currentPosition++;
			}
			return temp;

		}
		
		@Override
		public E remove(int index) {
			if ((index < 0) || (index >= this.currentSize)){
				throw new IndexOutOfBoundsException();
			}
			else {
				Node<E> temp = this.header;
				int currentPosition =0;
				Node<E> target = null;
				
				while (currentPosition != index) {
					temp = temp.getNext();
					currentPosition++;
				}
				E result = null;
				target = temp.getNext();
				result = target.getElement();
				temp.setNext(target.getNext());
				target.setElement(null);
				target.setNext(null);
				this.currentSize--;
				return result;
				
			}
		}

		@Override
		public E replace(int position, E newElement) {
			if ((position < 0) || position >= this.currentSize) {
				throw new IndexOutOfBoundsException();
			}
			Node<E> temp  = this.getPosition(position);
			E result = temp.getElement();
			temp.setElement(newElement);
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
			Object[] result = new Object[this.size()];
			for (int i=0; i < this.size(); ++i) {
				result[i] = this.get(i);
			}
			return result;
		}


		@Override
		public Iterator<E> iterator() {
			return new SinglyLinkedListIterator<E>();
		}


		@Override
		public int lastIndexOf(E e) {
			int i = 0, result = -1;
			for (Node<E> temp = this.header.getNext(); temp != null; 
					temp = temp.getNext(), ++i) {
				if (temp.getElement().equals(e)) {
					result = i;
				}
			}
			// not found
			return result;
		}


		@Override
		public boolean remove(E e) {
			int i = this.firstIndexOf(e);
			if (i < 0) {
				return false;
			}else {
				this.remove(i);
				return true;
			}
		}


		@Override
		public int removeAll(E e) {
			int count = 0;
			while (this.remove(e)) {
				count++;
			}
			return count;
		}


		@Override
		public void addBefore(E e, E f) {
			// ADD  YOUR CODE HERE
//			int count = 0;
//			Iterator<E> it = this.iterator();
//			while(it.hasNext() || count != 1) {
//				E obj = it.next();
//				if (obj.equals(e)) {
//					int ePos = this.firstIndexOf(e);
//					this.add(f, ePos-1);
//					count ++;
//				}
//			}
			
			int position = this.firstIndexOf(e);
			if(position >= 0) {
				Node<E> nodePrev = this.getPosition(position - 1);
				
				Node<E> nodeE = this.getPosition(position);
				Node<E> nodeF = new Node<E>();
				nodeF.setElement(f);
				nodeF.setNext(nodeE);
				
				nodePrev.setNext(nodeF);
//				this.add(f, position-1);
			}
	
			
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			List list = new SinglyLinkedList();
			list.add("Ken");
			list.add("Ron");
			list.add("Joe");
			list.add("Amy");
			list.add("Xi");
			list.add("Ron");
			list.add("Bob");
			list.add("Lu");
			
			System.out.println("Iterator: ");
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Object obj = it.next();
				System.out.println(obj);
			}
			
			
			System.out.println();
			Object[] obj = list.toArray();
			for (int i = 0; i < obj.length; i++) {
				System.out.println(obj[i]);
			}
			
			System.out.println();
			list.addBefore("Lu", "Ned");
			
			Object[] obj2 = list.toArray();
			for (int i = 0; i < obj2.length; i++) {
				System.out.println(obj[i]);
			}
			
			

		}

	}
}
