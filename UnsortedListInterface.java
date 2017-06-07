//----------------------------------------------------------------------------
// UnsortedListInterface.java        by Dale/Joyce/Weems             Chapter 6
//
// Extends the ListInterface with methods specific to unsorted lists.
//----------------------------------------------------------------------------

package ch06.lists;

public interface UnsortedListInterface<T> extends ListInterface<T>
{
  void add(Object element);
  // Adds element to this list.
}