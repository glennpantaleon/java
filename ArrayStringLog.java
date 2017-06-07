package ch02.stringLogs;

public class ArrayStringLog implements stringLogsInterface
{
	protected String name;
	protected String [] log;
	protected int lastIndex = -1;
	
	public ArrayStringLog(String name, int maxSize)
	{
		log = new String [maxSize];
		this.name = name;
	}
	
	public ArrayStringLog(String name)
	{
		log = new String [100];
		this.name = name;
		
	}
	
	public void insert(String element)
	{
		lastIndex++;
		log[lastIndex] = element;
	}
	
	public boolean isFull()
	{
		if(lastIndex == (log.length-1))
			return true;
		else
			return false;
	}
	
	public int size()
	{
		return (lastIndex + 1);
	}
	
	public boolean contains(String element)
	{
		int location = 0;
		while (location <= lastIndex)
		{
			if (element.equalsIgnoreCase(log[location]))
				return true;
			else
				location++;
		}
		return false;
	}
	
	public void clear()
	{
		for (int i = 0; i <= lastIndex; i++)
			log[i] = null;
		lastIndex = -1;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		String logString = "Log: " + name + "\n\n";
		for (int i = 0; i <= lastIndex; i++)
			logString = logString + (i+1) + ". "+ log[i] + "\n";
		return logString;
	}
	
	//From Exercise 22
	public int howMany(String element)
	{
		int repeatAmt = 0;
	    for (int i = 0; i < log.length; i++)
	    {
	    if (element.equalsIgnoreCase(log[i]))
		    repeatAmt = repeatAmt+1;                    
	    }
		    return repeatAmt;
	} 
	
	//From Exercise 23
	public boolean uniqInsert(String element)
	{
		int count = 0;
		while (count <= lastIndex) 
	    {
	        if (element.equalsIgnoreCase(log[count]))
	            return false;
	        else count++;
	    }
	        lastIndex++; log[lastIndex] = element; 
	        return true;

	}
	
	//From Exercise 26
	public String smallest()
	{
		int smallestVal = 0; 
		for(int i = 1; i < this.size(); i++) 
			if(log[i].compareTo(log[smallestVal]) <= 0) 
				smallestVal = i; 
		return log[smallestVal]; 
	}
}


