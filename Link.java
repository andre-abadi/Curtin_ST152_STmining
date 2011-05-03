package stmining;

/**
 * The link of a linked list.
 * Adapted from:
 *  Curtin University's Software Technology 152 Lectures 3A and 3B
 * @param <Gen> Type of Link to create.
 * @author    sajuuk
 */
public class Link<Gen> {
  private Gen data;
  private Link<Gen> next;

  /**
   * default constructor takes object to be stored
   * @param object
   */
  public Link(Gen object) {
    data = object;
    next = null;
  }

  /**
   * copy-constructor
   * @param link another object to be duplicated
   */
  public Link(Link<Gen> link) {
    data = link.getValue();
    next = link.getNext();
  }

  /**
   * gets the next Link
   * @return next Link in queue
   */
  public Link<Gen> getNext() {
    return next;
  }

  /**
   * sets next-pointer
   * @param newNext the desired destination of next-pointer
   */
  public void setNext(Link<Gen> newNext) {
    next = newNext;
  }

  /**
   * displays data stored in Link
   * @return data stored in link
   */
  public Gen getValue() {
    return data;
  }

  /**
   * sets data stored by Link
   * @param object the new data to be stored
   */
  public void setValue(Gen object) {
    data = object;
  }
}