//----------------------------------------------------------------------------
// ArraySortedList.java          by Dale/Joyce/Weems                 Chapter 6
//
// Implements the ListInterface using an array. It is kept in increasing order
// as defined by the compareTo method of the added elements. Only Comparable
// elements may be added to a list.
//
// Null elements are not permitted on a list.
//
// ajg version: DWC, T extends Comparable, format, while-->for, new add()
//----------------------------------------------------------------------------

package ch06.lists;

public class ArraySortedList<T> extends ArrayUnsortedList<T> 
								implements ListInterface<T> 
{

    public ArraySortedList(T[] list)
    { 
    	super(list); 
    }

    public void add(T element) 
    {
 	if (numElements == list.length)
	    throw new ListOverflowException("Helpful message.");

	// slide existing elements down to make a slot for new element
	for (int location=numElements++; location>0; location--) 
	{
	    if (element.compareTo(list[location-1]) >= 0)
		break;		// new element goes here
	    list[location] = list[location-1];
	}
	list[location] = element;
    }

    // Remove an element e such that e.equals(element).  Return outcome.
    public boolean remove (T element) {
	boolean found = find(element);
	if (found) {
	    for (int i=location; i <= numElements-2; i++)
		list[i] = list[i+1];
	    list[--numElements] = null;
	}
	
	return found;
    }
}