// Glenn Pantaleon 0789547
// This program is from the text book but had to be added in order for test class to work
package project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;



public class RefUnsortedList<T> implements ListInterface<T>   
{   
	protected int numElements;      // number of elements in this list   
	protected LLNode<T> currentPos; // current position for iteration set by find method
	protected boolean found;        // true if element found, else false   
	protected LLNode<T> location;   // node containing element, if found   
	protected LLNode<T> previous;   // node preceding location   
	public LLNode<T> list;       // first node on the list

	public RefUnsortedList() 
	{   
		numElements = 0; 
		list = null;
		currentPos = null;   
		}   
	
	public void add(T element)//Adds element to this list.
	  {
	LLNode<T> prevLoc; //trailing reference
	LLNode<T> location; //traveling reference  

	location = list; //set up search for insertion point
	prevLoc = null;

	while (location != null) //find insertion point
	  {  
	     prevLoc = location;
	     location = location.getLink();
	      }
	
	LLNode<T> newNode = new LLNode<T>(element); 
	
	if (prevLoc == null) //insert node as 1st node
    {
       newNode.setLink(list);
       list = newNode; 
     }
   else
     { 
      newNode.setLink(location);
      prevLoc.setLink(newNode);
     }
   numElements++;
}
	public String AccessIDCase2(String Target)  // ADDED CODE STARTS HERE
	 {
	 	LLNode<T> currnode = list; //sets new node to list.
	 	while(currnode != null) //the node hasnt reached the end ergo while loop
	 	{
	 		if (((Patient) currnode.getInfo()).getPatientid().equalsIgnoreCase(Target))//traversing the list to find the patient's id
	 		{
	 			currnode = currnode.getLink();
	 			return "ID in Existence";  
	 		}
	 		else
	 		{
	 			currnode = currnode.getLink(); 
	 		} 
	 	  
	 	}
	 	  
	 	return "Enter Patient's Information";
	 }
	
	public void AccessID(String Target) 
	{
		LLNode<T> currnode = list;
		
		while(currnode != null)//the node hasnt reached the end ergo while loop
		{
			if (((Patient) currnode.getInfo()).getPatientid().equalsIgnoreCase(Target))
			{
				
				System.out.println(((Patient)currnode.getInfo()).toStringsave());	//prints out toString by traversing
				currnode = currnode.getLink();
			}	
			else
			{
				currnode = currnode.getLink();
			}
			
		}		
	}
	public String getyoungest() // gets youngest patient
	{
		LLNode<T> currnode = list;
		int temp = 100;
		int compare = 0;
		String output = null;
		while(currnode != null) //the node hasnt reached the end ergo while loop
		{
		 compare = ((Patient) currnode.getInfo()).get_age(); //get_age method invoked
		if (temp > compare) //temporary (temp) age which is set to 100 is greater than our age,
			               //list will set it as the new temporary value to compare to other patients
		{
			temp = compare;
			currnode = currnode.getLink();
		}
		else
		{
			currnode.getLink();
		}
		}
		currnode = list; //resets the node to be list
		
		while(currnode != null)
		{
			if (((Patient) currnode.getInfo()).get_age()==temp)
			{
				
				output = ""+((Patient) currnode.getInfo()).toStringsave();	//saves the toString to output
				currnode = currnode.getLink();
			}	
			else{
			currnode = currnode.getLink();
			}
			
		}		
		
		return output;
	}
		
	public void getoverdue(){
		LLNode<T> currnode = list;
		int temporary = 0;
		while(currnode !=null)
		{
			temporary = ((Patient) currnode.getInfo()).get_time_since_last_visit();
			if(temporary >= 3)
			{
				System.out.println(currnode.getInfo());
				currnode = currnode.getLink();
			}
			else{
				currnode =currnode.getLink();
		}
		
		}
		
	}
	public double getAverageAge(){
	 	LLNode<T> currnode = list;
	 	double averageAge = 0;
	 	double sum = 0;
	 	while(currnode != null){
	 	  
	 	sum = sum + ((Patient)currnode.getInfo()).get_age();
	 	 currnode = currnode.getLink();
	 	 
	 	}
	 	averageAge = sum / size();
	 	return averageAge;
	 }	

	public String AccessIDCase4(String Target) 
	 {
	 	LLNode<T> currnode = list;
	 	LLNode<T> previous = null;
	 	LLNode<T> location = currnode;
	 	while(currnode != null)
	 	{
	 	if (((Patient) currnode.getInfo()).getPatientid().equalsIgnoreCase(Target))
	 	{
	 	if (list == location)        
	list = list.getLink();    // removes first node   
	else   
	previous.setLink(location.getLink());  // removes node at location   

	numElements--;
	 	currnode = currnode.getLink();
	 	return "Patient successfully removed";
	 	} 
	 	else
	 	{
	 	currnode = currnode.getLink();
	 	}
	 	}
	 	return "Patient not found";
	 }
	public void printout() //print outs to text file
	{
		LLNode<T> currnode = list;
		String name = null;
		String id = null;
		String address = null;
		Date birthDate = null;
		Date initial_Visit = null;
		Date last_Visit = null;
		double height = 0;
		double weight = 0.0;
		
		System.out.println("Enter the file name: ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.next(); //creates file name
		PrintWriter out = null;
		try {
			File file = new File(fileName); //creates file from keyboard input
			out = new PrintWriter(file);
					}
		catch(FileNotFoundException e) //catches error if file cannot open
			{
			System.out.println("Error opening the file.");
			System.exit(0);
			}
		
		System.out.println("The data was written to "+fileName); // formats file 
		while(currnode !=null) 									 //prints file by descending(top to bottom)
		{
			name = ((Patient) currnode.getInfo()).NAME;
			id = ((Patient) currnode.getInfo()).ID;
			address = ((Patient) currnode.getInfo()).ADDRESS;
			height = ((Patient) currnode.getInfo()).HEIGHT;
			weight = ((Patient) currnode.getInfo()).WEIGHT;
			birthDate = ((Patient) currnode.getInfo()).BIRTHDATE;
			initial_Visit = ((Patient) currnode.getInfo()).INTIALVISIT;
			last_Visit = ((Patient) currnode.getInfo()).LASTVISIT;
			out.println(name);
			out.println(id);
			out.println(address);
			out.println(height);
			out.println(weight);
			out.println(birthDate);
			out.println(initial_Visit);
			out.println(last_Visit);
			currnode = currnode.getLink();
		}
		out.close(); //close the file
	}				
	
	//ADDED CODE ENDS HERE
	
	
	
	protected void find(T element) 
	// Searches list for an occurrence of an element e such that 
	// e.equals(target). If successful, sets instance variables 
	// found to true, location to node containing e, and previous 
	// to the node that links to location. If not successful, sets  
	// found to false. 
	{   
		location = list; 
		found = false;   
		
		while (location != null)
		{   
			if (location.getInfo().equals(element))  // if they match   
			{   
				found = true; 
				return;   
			} 
			else 
			{   
				previous = location; 
				location = location.getLink();   		
			}   	
			}   
		}
	
	public int size() // Returns the number of elements on this list. 
	{   
		return numElements;   
		}   
	
	public boolean contains (T element) // Returns true if this list contains an element e such that  
										// e.equals(element); otherwise, returns false. 
	{   
		find(element); 
		return found;   
		}   
	
	public boolean remove (T element) // Removes an element e from this list such that e.equals(element) 
									// and returns true; if no such element exists, returns false. 
	{   
		find(element); 
		if (found) 
		{   
			if (list == location)        
				list = list.getLink();    // remove first node   
			else   
				previous.setLink(location.getLink());  // remove node at location   
			numElements--;   
			} 
		return found;   
		}

	public T get(T element) // Returns an element e from this list such that e.equals(element); 
							// if no such element exists, returns null. 
	{   
		find(element);     
		if (found)   
			return location.getInfo();   
		else   
			return null;   
		}   
	
	public String toString() // Returns a nicely formatted string that represents this list.

	{   
		LLNode<T> currNode = list; 
		String listString = "List:\n"; 
		while (currNode != null) {   
			listString = listString + "  " + currNode.getInfo() + "\n"; 
			currNode = currNode.getLink();   
			} 
		return listString;   
		}     
	
	public void reset() // Initializes current position for an iteration through this list, 
						// to the first element on this list. 
		{   
		currentPos  = list;   
		}   
	
	public T getNext() // Preconditions: The list is not empty
	// The list has been reset 
	// The list has not been modified since most recent reset 
	// Returns the element at the current position on this list. 
	// If the current position is the last element, then it advances the value  
	// of the current position to the first element; otherwise, it advances 
	// the value of the current position to the next element. 
	{   
		T next = currentPos.getInfo(); 
		if (currentPos.getLink() == null)   
			currentPos = list;   
		else   currentPos = currentPos.getLink();   
		return next;   
		}   		
	}
