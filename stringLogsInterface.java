package ch02.stringLogs;

public interface stringLogsInterface 
{
	void insert(String element);
	
	boolean isFull();
	
	int size();
	
	boolean contains(String element);
	
	void clear();
	
	String getName();
	
	String toString();
}
