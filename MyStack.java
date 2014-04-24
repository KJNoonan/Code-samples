import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<E> {
	private Node first;// first address of the first node
	private int sz;// keep track of how many nodes there are

	public MyStack() {
		first = null;
		sz = 0;
	}

	public int size() {
		return sz;
	}

	public void push(E x) {
		Node tmp;
		tmp = new Node(x);
		if (isEmpty()) {
			first = tmp;
		} else {
			first.next = tmp;
			first = tmp;
		}
		sz++;
	}
	public E peek(){
		return first.data;
		
	}
	
	public E pop() {
		E x;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else if (size() == 1) {
			x = first.data;
			first = null;
		} else {
			x = first.data;
			first = first.next;
		}
		sz--;
		return x;
	}

	public boolean isEmpty() {
		return sz == 0;
	}

	/*
	 * public Iterator<E> iterator() {
	 * 
	 * }
	 */

	private class Node {
		private E data;
		private Node next;// reference to another node

		private Node(E x) {
			data = x;
			next = null;
		}
	}

}
