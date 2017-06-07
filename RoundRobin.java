import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class RoundRobin extends LinkedList<Robin>
{
	private int timeSlice;
	private long beginTime;
	private long waitTime,finishTime,timeCompleted;
	private int length;
	private int contextSwitch;

	public RoundRobin(int quantom, Robin... list) 
	{
	this(quantom,Arrays.asList(list));
	}

	public RoundRobin(int quantom, List<Robin> list) 
	{
		super(list);
		this.timeSlice = quantom;
		waitTime = 0;
		finishTime=0;
		timeCompleted=0;
		contextSwitch=0;
		length = list.size();

	}

}
