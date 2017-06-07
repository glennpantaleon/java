//----------------------------------------------------------------------------
// ArrayUnsortedList.java         by Dale/Joyce/Weems                Chapter 6
//
// Implements the ListInterface using an array.
//
// Null elements are not permitted on a list.
//
// ajg version: Extended BOUNDEDListInterface, DWC, format,
//              ListOverflowException and isFull() instead of enlarge()
//              find() is boolean, while-->for
//----------------------------------------------------------------------------

package ch06.lists;

public class ArrayUnsortedList <T> implements UnsortedListInterface<T> {

    protected T[] list;           // array to hold this list's elements
    protected int numElements = 0;// number of elements in this list
    protected int currentPos;     // current position for iteration
    protected int location;       // find() sets to location of element if found

    public ArrayUnsortedList(T[] list) { this.list = list; }

    // Search for an element e such that e.equals(target).  Return outcome.
    // If successful, set location to the array index of e.
    protected boolean find(T target) {
	for (location=0; location<numElements; location++)
	    if (list[location].equals(target))
		return true;
	return false;
    }

    public boolean isFull() { return numElements == list.length; }

 

    // Removes an element e such that e.equals(element).  Returns outcome
    public boolean remove (T element) {
	boolean found = find(element);
	if (found)
	    list[location] = list[--numElements];
	return found;
    }

    public int size() { return numElements; }

    // Does list contains an element e such that e.equals(element)?
    public boolean contains (T element)    { return find(element); }

    // Return an element e such that e.equals(element) or null if no such e
    public T get(T element) { return find(element) ? list[location] : null; }
  
    // Return a nicely formatted string that represents this list.
    public String toString() {
	String listString = "List:\n";
	for (int i = 0; i < numElements; i++)
	    listString = listString + "  " + list[i] + "\n";
	return listString;
    }

    // Initialize current position for an iteration through this list.
    public void reset() { currentPos  = 0; }

    // Return the element at the current position and advance to next position.
    // If (initially) at the last element, advance to the first element
    // 
    // Preconditions: The list is not empty
    //                The list has been reset
    //                The list has not been modified since the most recent reset
    public T getNext() {
	T next = list[currentPos];
	currentPos = (currentPos + 1) % numElements;
	return next;
    }

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		
	}

