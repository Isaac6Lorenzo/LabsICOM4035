package edu.uprm.cse.ds.sortedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SortedCircularDoublyLinkedList<E extends Comparable<E>> implements SortedList<E> {

	//class of node
	public static class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> previous;

		//constructor of node
		public Node(E element, Node<E> next, Node<E> previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}

		public Node(E element) {
			this.element = element;
			this.next = null;
			this.previous = null;
		}

		public Node() {
			this.element = null;
			this.next = null;
			this.previous = null;
		}

		//getters and setters
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> node) {
			this.next = node;
		}

		public Node<E> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<E> node) {
			this.previous = node;
		}
	}


	private int currentSize;
	private Node<E> header;

	//constructor of SCDLL
	public SortedCircularDoublyLinkedList() {
		this.currentSize = 0;
		this.header = new Node<E>();
	}

	/**
	 * Add method
	 * @param obj object to be add to the sorted 
	 * circular doubly linked list
	 * @return confirmation of the addition to the SCDLL
	 */
	@Override
	public boolean add(E obj) {

		//basic case
		if(this.isEmpty()) {
			Node<E> newNode = new Node<E>(obj, this.header, this.header);
			this.header.setNext(newNode);
			this.header.setPrevious(this.header.getNext());
			this.currentSize++;
			return true;			
		}

		else if(!obj.equals(null)){
			int count = 0;
			Node<E> temp = header;

			while (count < this.size()) {
				if (temp.getNext().getElement().compareTo(obj) < 0) {
					temp = temp.getNext();
				}

				else {
					//change the pointer to add the new node
					Node<E> newNode = new Node<E>(obj, temp.getNext(), temp);
					temp.getNext().setPrevious(newNode);
					temp.setNext(newNode);
					break;
				}

				count ++;
			}

			if (count == this.size()) { 
				//the end of the list
				Node<E> newNode = new Node<E>(obj, header, temp);
				temp.setNext(newNode);
				header.setPrevious(newNode);
			}

			this.currentSize++;
			return true;
		}

		else
			return false;
	}

	/**
	 * Size method
	 * @return the size of SCDLL
	 */
	@Override
	public int size() {
		return this.currentSize;
	}

	/**
	 * Remove method using an object
	 * @param obj object to be remove from the SCDLL
	 * @return confirmation of the remove of the SCDLL
	 */
	@Override
	public boolean remove(E obj) {

		if (this.isEmpty()) {
			return false;
		}

		int index = this.firstIndex(obj);

		if (index < 0) {
			return false;
		}

		else {
				
			return this.remove(index);	
		}
	}

	/**
	 * Remove method using an index
	 * @param index to find the object to be remove from the SCDLL
	 * @return confirmation of the remove of the SCDLL
	 */
	@Override
	public boolean remove(int index) {
		if (this.isEmpty()) {
			return false;
		}

		if ((index < 0) || (index >= this.size())){
			throw new IndexOutOfBoundsException();
		}

		//special case index = 0
		if (index == 0) {
			Node<E> node = this.header.getNext();
			this.header.setNext(node.getNext());
			node.getNext().setPrevious(this.header);

			//remove reference to the node
			node.setElement(null);
			node.setNext(null);
			node.setPrevious(null);

			this.currentSize--;
			return true;			
		}

		else if (index > 0) {
			//the getNode method has the parameter of IndexOutOfBoundsException include
			Node<E> temp = this.getNode(index - 1);
			Node<E> removeNode = temp.getNext();

			temp.setNext(removeNode.getNext());
			temp.getNext().setPrevious(temp);

			//remove reference to the node
			removeNode.setElement(null);
			removeNode.setNext(null);
			removeNode.setPrevious(null);

			this.currentSize--;
			return true;		
		}

		return false;
	}

	/**
	 * Remove All method using an object
	 * @param obj remove all object from the SCDLL
	 * @return count of object was remove from SCDLL
	 */
	@Override
	public int removeAll(E obj) {
		int count = 0;
		while(this.remove(obj)) {
			count++;
		}

		return count;
	}

	/**
	 * Get First Method from the SCDLL
	 * @return the first object in the SCDLL or null if is empty
	 */
	@Override
	public E first() {
		if(this.isEmpty()) {
			return null;
		}		
		return this.header.getNext().getElement();
	}

	/**
	 * Get Last Method from the SCDLL
	 * @return the last object in the SCDLL or null if is empty
	 */
	@Override
	public E last() {
		if(this.isEmpty()) {
			return null;
		}		
		return this.header.getPrevious().getElement();
	}

	/**
	 * Get method using an index
	 * @param index using an index to find an object inside of the SCDLL
	 * @return the element from the node with the index selected
	 */
	@Override
	public E get(int index) {
		//the getNode method has the parameter of IndexOutOfBoundsException include
		Node<E> temp = this.getNode(index);
		return temp.getElement();	
	}

	/**
	 * Clear method
	 */
	@Override
	public void clear() {
		while(!this.isEmpty()) {
			this.remove(0);
		}
	}

	@Override
	public boolean contains(E e) {
		int index = this.firstIndex(e);
		if (index >= 0) {
			return true;
		}

		return false;
	}

	/**
	 * Empty Method
	 * @return confirmation, if the SCDLL is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}


	/**
	 * First Index Method using an object
	 * @param e find the object inside the SCDLL
	 * @return the first index of the object e
	 */
	@Override
	public int firstIndex(E e) {
		Node<E> temp = this.header;
		int index = 0;

		while(index < this.size()) {
			if (temp.getNext().getElement().equals(e)) {
				return index;
			}

			temp = temp.getNext();
			index++;
		}

		return -1;
	}

	/**
	 * Last Index Method using an object
	 * @param e find the object inside the SCDLL
	 * @return the last index of the object e
	 */
	@Override
	public int lastIndex(E e) {
		Node<E> temp = this.header;
		int index = 0;
		int foundIndex = 0;

		while(index < this.size()) {
			if (temp.getNext().getElement().equals(e)) {
				foundIndex = index;
			}

			temp = temp.getNext();
			index++;
		}

		if (foundIndex > 0) {
			return foundIndex;
		}

		return -1;	
	}

	/**
	 * Iterator
	 * @return Forward Iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new ForwardIterator<E>();
	}

	/**
	 * Iterator with index
	 * @return Forward Iterator with index
	 */
	@Override
	public Iterator<E> iterator(int index) {
		return new ForwardIterator<E>(index);
	}	

	/**
	 * Reverse Iterator
	 * @return Reverse List Iterator
	 */
	@Override
	public ReverseIterator<E> reverseIterator() {
		return new ReverseListIterator<E>();
	}

	/**
	 * Reverse Iterator with index
	 * @return Reverse List Iterator with index
	 */
	@Override
	public ReverseIterator<E> reverseIterator(int index) {
		return new ReverseListIterator<E>(index);
	}

	/**
	 * Get Node using an index
	 * @param index using an index to find the correct node
	 * @return Node return the node with the index selected
	 */
	private Node<E> getNode(int index){
		if ((index < 0) || (index >= this.size())){
			throw new IndexOutOfBoundsException();
		}

		Node<E> node = this.header.getNext();
		int count = 0;

		while(count < index) {
			node = node.getNext();
			count++;
		}
		return node;
	}

	//ForwardIterator class
	@SuppressWarnings("hiding")
	private class ForwardIterator<E> implements Iterator<E>{

		private Node<E> currentNode;

		@SuppressWarnings("unchecked")
		public ForwardIterator() {
			this.currentNode = (Node<E>) header;

		}

		@SuppressWarnings("unchecked")
		public ForwardIterator(int index) {
			//the getNode method has the parameter of IndexOutOfBoundsException include
			this.currentNode = (Node<E>) getNode(index - 1);

		}

		@Override
		public boolean hasNext() {
			return this.currentNode.getNext() != header;
		}

		@Override
		public E next() {
			if (this.hasNext()) {
				E obj = this.currentNode.getNext().getElement();
				this.currentNode = this.currentNode.getNext();
				return obj;
			}
			else {
				throw new NoSuchElementException();				
			}
		}
	}


	//ReverseListIterator class
	@SuppressWarnings("hiding")
	private class ReverseListIterator<E> implements ReverseIterator<E> {

		private Node<E> currentNode;

		@SuppressWarnings("unchecked")
		public ReverseListIterator() {
			this.currentNode = (Node<E>) header;
		}

		@SuppressWarnings("unchecked")
		public ReverseListIterator(int index) {
			if (index == size() - 1) {
				this.currentNode = (Node<E>) header;
			}

			else
				//the getNode method has the parameter of IndexOutOfBoundsException include
				this.currentNode = (Node<E>) getNode(index + 1);

		}

		@Override
		public boolean hasPrevious() {
			return this.currentNode.getPrevious() != header;
		}

		@Override
		public E previous() {
			if (this.hasPrevious()) {
				E obj = this.currentNode.getPrevious().getElement();
				this.currentNode = this.currentNode.getPrevious();
				return obj;
			}
			else
				throw  new NoSuchElementException();
		}
	}
}
