
	import java.util.Iterator;
	import java.util.NoSuchElementException;

	/**
	 * A linear collection that supports insertion at the back and front
	 * and deletion from the front and back. 
	 * @author Kevin Noonan
	 *
	 * @param <E> type of elements inserted
	 */
	
	public class Deque<E> implements Iterable<E> {
		/**
		 * first references the first Node in Deque
		 * last references the last Node in the Deque
		 * If the Deque is empty first = last = null
		 * sz is the number of elements stored in the Deque
		 */
		private Node first;
		private Node last;
		private int sz;

		/**
		 * Constructor initializes the Deque as empty
		 */
		public Deque()
		{
			first = null;
			last = null;
			sz = 0;
		}

		/**
		 * @return number of items stored in the Deque
		 */
		public int size()
		{
			return sz;
		}

		/**
		 * Insert x at the end of the Deque
		 * @param x item to be inserted
		 */
		public void addLast(E x)
		{
			if (x == null) {//case where the user passes a null element
				throw new NullPointerException();
			}
			
			Node tmp;
			tmp = new Node(x);
			
			if ( isEmpty() ) {//Deque is empty
				first = tmp;
				last = tmp;
				
			} else {//Deque has an element in it
				tmp.previous = last;
				last.next = tmp;
				last = tmp;
			}
			sz++;
		}

		/**
		 * remove the first item in the Deque
		 * @throws NoSuchElementException if the Deque is empty
		 * @return the item that was at the front of the Deque
		 */
		public E removeFirst()
		{
			E x;
			if (isEmpty()) {//Deque is empty
				throw new NoSuchElementException();
				
			} else if (size() == 1) {//Deque has one element left
				x = first.data;		
				first = null;
				last = null;
				
			} else {//Deque has more than 1 element
				x = first.data;
				first = first.next;
			}
			sz--;
			return x;
		}
		
		/**
		 * Insert x at the beginning of the Deque
		 * @param x item to be inserted
		 */
		public void addFirst(E x){
			if (x == null) {
				throw new NullPointerException();
			}
			Node tmp;
			tmp = new Node(x);
			if ( isEmpty() ) {//Deque is Empty
				first = tmp;
				last = tmp;
				
			} else {//Deque has an element in it
				first.previous = tmp;
				tmp.next = first;
				first = tmp;
			}
			sz++;
		}
		
		/**
		 * remove the last item in the Deque
		 * @throws NoSuchElementException if the Deque is empty
		 * @return the item that was at the end of the Deque
		 */
		public E removeLast(){
			E x;
			if (isEmpty()) {//Deque is empty
				throw new NoSuchElementException();
			} else if (size() == 1) {//Deque has 1 element left
				x = last.data;
				first = null;
				last = null;
			} else {//Deque has more than 1 element left
				x = last.data;
				last = last.previous;
				last.next = null;//unlink the old node
			}
			sz--;
			return x;
		}
		
		/**
		 * @return true if Deque is empty, false if Deque is not empty
		 */
		public boolean isEmpty()
		{
			return sz == 0;
		}

		/**
		 * @return an Iterator for the elements in the Deque
		 */
		public Iterator<E> iterator()
		{
			return new DequeIterator();
		}
		
		/**
		 * Doubly linked node used by the containing Deque class to create linked list representation
		 * of the Deque elements.
		 * @author Kevin Noonan
		 */
		private class Node
		{
			/**
			 * data holds the values
			 * next points to the next Node
			 * previous points to the previous Node*/
			
			private E data;
			private Node next;
			private Node previous;
			/**
			 * Constructor that adds in the element and sets its pointers null
			 * @param E x is the element that it to be attached to the linked list*/
			private Node(E x)
			{
				data = x;
				next = null;
				previous = null;
			}
		}
		
		/**
		 * An Iterator for the containing Deque instance
		 * @author Kevin Noonan
		 *
		 */
		private class DequeIterator implements Iterator<E>
		{
			private Node current;//current references a Node in a the Deque instance that instantiates this DequeIterator
			/**
			 * Constructor class begins current with the first element of the Deque
			 */
			private DequeIterator()
			{
				current = first;
			}
			/**
			 * @return true if there another Node current is representing, false if there is not
			 */
			@Override
			public boolean hasNext() {
				return current != null;
			}
			
			/**
			 * @throws NoSuchElementException if hasNext determines there are no more elements
			 * @return the data of the current Node
			 */
			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				E x  = current.data;
				current = current.next;
				return x;
			}
			/**
			 * @throws UnsupportedOperationException whenever the method is called
			 */
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		}

	}

