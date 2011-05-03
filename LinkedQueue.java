package stmining;

import java.util.Iterator;

/**
 * Queue logic wrapping a home-brew double ended linked list.
 * @param <Gen> The type of data to store.
 * @author sajuuk
 */
public class LinkedQueue<Gen> implements Iterable<Gen>{

  /** the queue object to be played with */
  private LinkedList<Gen> queue;

  /**
   * default constructor initializes queue
   */
  public LinkedQueue() {
    queue = new LinkedList<Gen>();
  }

  /**
   * adds item to the end of the queue
   * @param object item to be added
   */
  public void enqueue(Gen object) {
    queue.insertLast(object);
  }

  /**
   * removes the item at the front of the queue
   * @return removed item
   */
  public Link<Gen> dequeue() {
    Link<Gen> front = queue.deleteFirst();
    return front;
  }

  /**
   * gets the item at the front without removing it
   * @return item at front of queue
   */
  public Link<Gen> peek() {
    Link<Gen> front = queue.getFirst();
    return front;
  }

  /**
   * checks whether queue is empty
   * @return whether or not queue is empty
   */
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public Iterator<Gen> iterator() {
    return queue.iterator();
  }
}