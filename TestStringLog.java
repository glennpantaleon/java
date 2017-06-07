package ch02.stringLogs;

public class TestStringLog 
{
	public static void main(String[] args) 
	{
		// Testing code for Exercise 22
		ArrayStringLog test = new ArrayStringLog("Input values:");   
		test.insert("One"); 
		test.insert("Two");
		test.insert("Three");
		test.insert("Three");
		test.insert("Four");
		test.insert("Five"); 
		System.out.println(test); 
        System.out.println("The Log Size is: " + test.size()); 
        System.out.println("Value 'One' is in the log: " + test.contains("One")); 
        System.out.println("Value 'Two' is in the log: " + test.contains("Two")); 
        System.out.println("Value 'Three' is in the log repeated for " + test.howMany("Three") + " times");
        System.out.println("Value 'Four' is in the log repeated for " + test.howMany("Four") + " times");
        System.out.println("Value 'Five' is in the log repeated for " + test.howMany("Five") + " times"); 
        
        //Testing code for Exercise 23
		System.out.println("Value 'Three' exist in String: " + test.uniqInsert("Three"));
		System.out.println("Value 'Four' exist in String: " + test.uniqInsert("Four"));
		System.out.println("Value 'Six' exist in String: " + test.uniqInsert("Six"));
		
		//Testing Code for Exercise 26
		System.out.println("The smallest string is " + test.smallest());
	}

}
