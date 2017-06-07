package ch06.lists;
public class ListExer 
{

	public static void main(String[] args) 
	{
		ListInterface <String> list1 
		= new ArrayUnsortedList<String>();
		list1.add("apple");
		list1.add("peach");
		list1.add("orange");
		list1.add("pear");
		list1.remove("peach");
		
		ListInterface<String> list2 
		= new ArraySortedList<String>();
		list2.add("apple");
		list2.add("peach");
		list2.add("orange");
		list2.add("pear");
		list2.remove("peach");
		
		IndexedListInterface <String> list3 
		 = new ArrayIndexedList<String>();
		list3.add(0. "apple");
		list3.add(0."peach");
		list3.add(1."orange");
		list3.add(0."peach");
		list3.add(2."plum");
		list3.remove("peach");
		
		System.out.print("Unsorted");
		System.out.println(list1);
		System.out.print("Sorted");
		System.out.println(list2);
		System.out.print("Indexed");
		System.out.println(list3);
	}

}
