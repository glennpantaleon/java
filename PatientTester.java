package project1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.*;
import java.io.IOException;

public class PatientTester {
public static void main(String args[]) 
{

	Scanner keyboard = new Scanner(System.in);


	Patient entry1 =null; //creates patient
	RefUnsortedList<Patient> NewList = new RefUnsortedList<Patient>(); //set patient as the object for linked list
	String name1 = null; //declaring each data type for use later
	String id1 = null;
	String address1 = null;
	String birthDate1 = null;
	String intialVisit1 = null;
	String lastVisit1 = null;
	int height1 = 0;
	double weight1 = 0.0;

	System.out.println("Please enter Filename:"); // initial file search
	String newString = keyboard.nextLine();
	File keysFile = new File(newString);
	try {
			Scanner A1 = new Scanner(keysFile);
	
	
		while(A1.hasNextLine())//saving each line on the text file in our linked list
		{
			name1 = A1.nextLine();
			id1 = A1.nextLine();
			address1 = A1.nextLine();
			height1 = Integer.parseInt(A1.nextLine());
			weight1 = Integer.parseInt(A1.nextLine());
			birthDate1 = A1.nextLine();
			intialVisit1 = A1.nextLine();
			lastVisit1 = A1.nextLine();
			entry1 = new Patient(name1, id1, address1, height1, weight1, birthDate1, intialVisit1, lastVisit1);
	
			NewList.add(entry1);
	
		}
		System.out.println(NewList);
		A1.close();
	
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();

		}
	
	// Main Menu display
	System.out.println("1. Display list");
	System.out.println("2. Add a new patient");
	System.out.println("3. Show information for a patient");
	System.out.println("4. Delete a patient");
	System.out.println("5. Show average patient age");
	System.out.println("6. Show information for the youngest patient");
	System.out.println("7. Show notification list");
	System.out.println("8. Quit");

		 
		boolean count = false;
		  while(count == false) // looping menu, as long as "count" is false, main menu will exist
		  {
			  System.out.println("Enter the menu option: ");
			  int option = keyboard.nextInt();
			switch(option)
		      {
		         case 1 :
		            System.out.println(NewList); //displays the list in format (name, id)
		            break;
		         case 2 :
		        
					System.out.println("Please enter the new Patient's ID: ");
					id1 = keyboard.next();
					String inputcase3 = NewList.AccessIDCase2(id1); //checks return type to see if its equal and in use
					if("ID Already in Use".equalsIgnoreCase(inputcase3))
					{
						System.out.println(inputcase3); //returns id is in existence and goes back to the main menu
						
					}
					else //displays to create a patient
					{
						System.out.println(NewList.AccessIDCase2(id1));
					System.out.println("Enter New Patient's name: ");
					name1 = keyboard.next();
					
					System.out.println("Enter New Patient's Address: ");
					address1 = keyboard.next();
					
					System.out.println("Enter New Patient's Height: ");
					height1 = keyboard.nextInt();
					
					System.out.println("Enter New Patient's Weight: ");
					weight1 = keyboard.nextDouble();
					
					System.out.println("Enter New Patient's Date of Birth: ");
					birthDate1 = keyboard.next();
					
					System.out.println("Enter New Patient's First/Intial Visit: ");
					System.out.println("Please use Format MM-DD-YYYY");
					intialVisit1 = keyboard.next();
					
					System.out.println("Enter New Patient's Last Visit: ");
					System.out.println("Please use Format MM-DD-YYYY");
					lastVisit1 = keyboard.next();
					
					entry1 = new Patient(name1, id1, address1, height1, weight1, birthDate1, intialVisit1, lastVisit1);
					//saving the entry and adding into the list
					NewList.add(entry1);
					}
		        	 break;
		         case 3 :
		            System.out.println("Enter the id for the patient: ");
		            String idcase3 = keyboard.next();
		            NewList.AccessID(idcase3);	        	 
		            break;
		         case 4 :
		        	 System.out.println("Enter the id for the patient: ");
			            String idcase4 = keyboard.next();
			            NewList.AccessIDCase4(idcase4);
		        	
		            break;
		         case 5 :
		        	 System.out.println("Displaying the average age: ");
		        	 System.out.println(NewList.getAverageAge());
			        break;
		         case 6 :
		        	 System.out.println("The youngest person is:");
		        	 System.out.println(NewList.getyoungest()); 
			        break;
		         case 7 :
			            NewList.getoverdue();
			        break;
		         case 8 :
		        	System.out.println("Would you like to save? (Y/N) ");//saves information
		        		String filesave = keyboard.next();
		        		if(filesave.equalsIgnoreCase("y"))
		        		{
		        			NewList.printout();
		        		//all the info is on refunsortedlist.java
		        		}
		
		        		else{
			        System.exit(0);//exits if user doesn't want to save
		        		}
			      break;
		         default :
		            System.out.println("Invalid Option");
		      
		    }
		  }
	}
}
