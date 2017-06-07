//----------------------------------------------------------------------------
// ListInterface.java            by Dale/Joyce/Weems                 Chapter 6
//
// The lists permit duplicate elements, but do not allow null elements.
// As a general precondition, null elements are not passed as 
// arguments to any of the methods.
//
// The list has a special property called the current position - the position 
// of the next element to be accessed by getNext during an iteration through 
// the list. Only reset and getNext affect the current position.
//
// ajg Version: My array implementation is BOUNDED so I need both
//                 bounded and unbounded interfaces as done with stacks
//                 This file contains material common to bounded and unbounded
//              Format, add() moved to the extended interfaces
//----------------------------------------------------------------------------

package ch06.lists;
public interface ListInterface<T> {
    int size();              // Returns the number of elements on this list.

    // Remove an element e from this list such that e.equals(element)
    // and return true.  If no such element exists, return false. 
    boolean remove (T element);
  
    // Does list contains an element e such that e.equals(element)?
    boolean contains (T element);

    // Return an element e from this list such that e.equals(element).
    // If no such element exists, returns null.
    T get(T element);
  
    // Return a nicely formatted string that represents this list.
    String toString();
  
    // Initialize current position for an iteration through this list
    // to the first element.
    void reset();

    // Return the element at the current position on this list.
    // If the current position is the last element, it becomes the first element.
    // Otherwise, current position the the next element.
    // Preconditions: The list is not empty
    //                The list has been reset
    //                The list has not been modified since the most recent reset
    T getNext();
}
