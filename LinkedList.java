package stmining;

import java.util.Iterator;

/**
 * An implementation of a double-ended linked list.
 * Adapted from:
 *   LaFore's Data Structures and Algorithms, 2nd Ed, Chapter 5
 *   Curtin University's Software Technology 152 Lectures 3A and 3B
 * @param <Gen> The type of data to store.
 * @author sajuuk
 */

public class LinkedList<Gen> implements Iterable<Gen> {

  /** a pointer to the first link */
  private Link<Gen> first;

  /** a pointer to the last link */
  private Link<Gen> last;

  /**
   * default constructor
   */
  public LinkedList() {
    first = null;
    last = null;
  }

  /**
   * checks empty state of list
   * @return whether or not the list is empty
   */
  public boolean isEmpty() {
    if (first == null) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * inserts an item to front of list
   * @param object the item to be inserted to front
   */
  public void insertFirst(Gen object) {
    //create the link to be inserted
    Link<Gen> newLink = new Link<Gen>(object);
    //if list is empty set to last-pointer too
    if (isEmpty() == true) {
      last = newLink;
    }
    //set newLink's next-pointer to point to old first link (now second link)
    //this will be null if empty
    newLink.setNext(first);
    //set first-pointer to point to newLink
    first = newLink;
  }

  /**
   * inserts an item to rear of list
   * @param object the item to be inserted to rear
   */
  public void insertLast(Gen object) {
    Link<Gen> newLink = new Link<Gen>(object);
    //if list is empty then new last-Link will also be first link
    if (isEmpty() == true) {
      //make new Link first
      first = newLink;
    }
    else {
      //otherwise append new Link to last Link's next-pointer
      last.setNext(newLink);
    }
    //set last-pointer to new Link
    last = newLink;
  }

  /**
   * gets first Link
   * @return Link at front of list
   */
  Link<Gen> getFirst() {
    if (isEmpty() == true) {
      throw new IllegalStateException("cannot find first; queue is empty");
    }
    else {
      Link<Gen> front = new Link<Gen>(first);
      return front;
    }
  }

  /**
   * gets last Link
   * @return Link at rear of list
   */
  Link<Gen> getLast() {
    if (isEmpty() == true) {
      throw new IllegalStateException("cannot find last; list is empty");
    }
    else {
      Link<Gen> rear = new Link<Gen>(last);
      return rear;
    }
  }
  /**
   * removes the item at front of list
   * @return the removed item
   */
  public Link<Gen> deleteFirst() {
    if (isEmpty() == true) {
      throw new IllegalStateException("cannot delete; list is empty");
    }
    else {
      //create new Link to be returned
      Link<Gen> removed = first;
      //if there is only one item then set last to null
      if (first.getNext() == null) {
        last = null;
      }
      //increment first-pointer to second Link
      first = first.getNext();
      //return the now bypassed Link
      return removed;
    }
  }
  /**
   * creates an iterator for this class
   * @return new iterator
   */
  public Iterator<Gen> iterator() {
    return new LinkedListIterator<Gen>(this);
  }

  /**
   * subclass that iterates through parent
   * @param <OrePile>
   */
  private class LinkedListIterator<Gen> implements Iterator<Gen>{
    private Link<Gen> current;
    public LinkedListIterator (LinkedList<Gen> theList) {
      current = theList.getFirst();
    }

    /**
     * checks whether or not there is another link in list
     * @return boolean whether next Link exists
     */
    public boolean hasNext() {
      if (current == null) {
        return false;
      }
      else {
        return true;
      }
    }

    /**
     * increments along list
     * @return current Link data
     */
    public Gen next() {
      Gen value;
      if (current == null) {
        return null;
      }
      else {
        //pull the value of the current node
        value = current.getValue();
        //increment current reference
        current = current.getNext();
        //return what is now the previous node's content
        return value;
      }
    }

    /**
     * unnecessary method
     * implementation necessary but functionality not
     */
    public void remove() {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }
}