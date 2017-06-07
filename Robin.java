
public class Robin {
	private int i;
	private String name;
	public int perform(int tS) 
	{
	i -= tS;
	return i;
	}


	public Robin(String name, int i) 
	{
		this.i = i;
		this.name=name;
	}
	
	public String getName()
	{return name;}

	public int remaingTime()
	{return i;}
	
	public String toString()
	{
		return name +" with "+i+" remaining";
	}

	public boolean isCompleted() 
	{
		return i<=0;
	}

}
