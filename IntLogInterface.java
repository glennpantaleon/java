package ch02.stringLogs;

public interface IntLogInterface 
{
	//Three operations that might be useful
	// to export from a StringLog ADT
	int size();
	
	void clear();
	
	void insert(int element);
	
	//Operations used in this interface
	
	String getInt(int element);
	
	String setInt();
	
	
}
