package stmining;

import java.util.Iterator;

/**
 *Stack logic wrapping a home-brew double ended linked list.
 * @param <Gen> The type of data to store.
 * @author sajuuk
 */
public class LinkedStack<Gen> implements Iterable<Gen>{

  /** the stack object to be played with */
  private LinkedList<Gen> stack;

  /**
   * default constructor initializes stack
   */
  public LinkedStack() {
    stack = new LinkedList<Gen>();
  }

  /**
   * adds item to top of stack
   * @param object item to be added
   */
  public void push(Gen object) {
    stack.insertFirst(object);
  }

  /**
   * removes item from top of stack
   * @return item removed from top of stack
   */
  public Link<Gen> pop() {
    return stack.deleteFirst();
  }

  /**
   * gets item at top of stack without removing
   * @return item on top of stack
   */
  public Link<Gen> peek() {
    return stack.getFirst();
  }


  /**
   * checks whether stack is empty
   * @return whether or not the stack is empty
   */
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public Iterator<Gen> iterator() {
    return stack.iterator();
  }
}
