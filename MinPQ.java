import java.util.NoSuchElementException;

/**
 * @author Kevin Noonan
 * MinPQ is the object class that stores items of type <E>
 * in order of lowest to highest. Also supports functions to insert items, 
 * return the size of the queue and to return or return and remove the lowest values, 
 * 
 * @param <E>
 */

public class MinPQ<E extends Comparable<E>> {
	// private data members
	private Node head;
	private Node tail;
	private int sz;

	/**
	 * constructor initializes MinPQ empty
	 * */
	public MinPQ() {
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		tail.previous = head;
		sz = 0;
	}

	/**
	 * finds, returns, and removes the minimum item
	 * 
	 * @return the minimum item
	 */
	public E deleteMin() {
		if (isEmpty()) {// nothing to pass back
			throw new NoSuchElementException();
		}
		Node min = new Node(null);
		min = head.next;
		min.next.previous = head;
		head.next = head.next.next;
		min.next = null;
		min.previous = null;

		sz--;
		return min.data;
	}

	/**
	 * finds the minimum item
	 * 
	 * @returns the minimum item
	 */
	public E min() {
		if (isEmpty()) {// nothing to pass back
			throw new NoSuchElementException();
		}
		return head.next.data;

	}

	/**
	 * adds an item into the MinPQ
	 * 
	 * @param item
	 */
	public void insert(E item) {
		Node tmp = new Node(item);
		Node current = head.next;
		if(isEmpty()){//checks if the queue is empty
			head.next = tmp;
			tail.previous = tmp;
			tmp.next = tail;
			tmp.previous = head;	
		}
		else if(tmp.data.compareTo(tail.previous.data) > 0){ //checks the item is larger then the whole queue
			tmp.previous = tail.previous;
			tmp.next = tail;
			tail.previous.next = tmp;
			tail.previous = tmp;
		}
		else{//checks every element and places the element where it belongs
			while(current != tail){
				if (tmp.data.compareTo(current.data) < 0){
					tmp.next = current;
					tmp.previous = current.previous;
					current.previous.next = tmp;
					current.previous = tmp;
					break;
				}
				current = current.next;
				}
				
			}
		
		sz++;//increment the size
		
	}

	/**
	 * checks if the MinPQ is empty
	 * 
	 * @returns true if empty, false if not
	 */
	public boolean isEmpty() {
		return sz == 0;
	}

	/**
	 * 
	 * @returns the number of items within the MinPQ
	 */
	public int size() {
		return sz;
	}

	private class Node {
		/**
		 * data holds the values next points to the next Node previous points to
		 * the previous Node
		 */

		private E data;
		private Node next;
		private Node previous;

		/**
		 * Constructor that adds in the element and sets its pointers null
		 * 
		 * @param E
		 *            x is the element that it to be attached to the linked list
		 */
		private Node(E x) {
			data = x;
			next = null;
			previous = null;
		}
	}
}