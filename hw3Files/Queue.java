
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * A linked list implementation of a Queue.
 * 
 * @param <E>
 */
public class Queue<E> implements Iterable<E> {
  private LinkedList<E> q;
  /**
   * Initializes an empty queue.
   */
  public Queue()
  {
    q = new LinkedList<E>();
  }
  /**
   * Adds x to the end of the queue.
   * @param x
   */
  public void enqueue(E x)
  {
    q.add(x);
  }
  
  /**
   * Removes and returns the first element of the queue
   * @return the first element of the queue is removed and returned
   * @throws NoSuchElementException if the queue is empty
   */
  public E dequeue()
  {
    if (q.isEmpty()) {
      throw new NoSuchElementException();
    }
    E x = q.removeFirst();
    return x;
  }
  /**
   * Checks if the queue is empty
   * @return true if empty, else false
   */
  public boolean isEmpty()
  {
    return q.isEmpty();
  }
  @Override
  /**
   * Returns an iterator for the queue elements.
   * The elements are returned in order starting at the front element.
   * @returns an iterator for the elements in the queue. If the queue is not empty 
   * the iterator is initially positioned at the front element.
   */
  public Iterator<E> iterator() {
    return q.iterator();
  }
}
