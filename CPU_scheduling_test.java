import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public void start()
{
long currentTime = 0;
Robin prevRobin = null;
do{
Robin robin = pop();
int elapsed = Math.min(robin.remaingTime(), timeSlice);
robin.perform(elapsed);
currentTime+=elapsed;
waitTime+=currentTime;

if(!robin.isCompleted()){
this.addLast(robin);

}else{
long finalTime = System.nanoTime()-beginTime;
finishTime+=currentTime;
System.out.println(finishTime);
}

if(!robin.equals(prevRobin)) 
	{contextSwitch++;
	prevRobin = robin;
	}
while(!isEmpty());
timeCompleted=currentTime;
}

public long getAverageTurnAroundTime(){
return finishTime/length;
}

public long getAverageWaitTime(){
return waitTime/length;
}

public float getThroughput(){
return (float) length/(timeCompleted*contextSwitch-1);
}

public int getCpuUtilization(){
return (int) (((float)finishTime/(finishTime*contextSwitch-1))*100);
}

public void report(){
System.out.println("CPU Usage : "+getCpuUtilization()+"%");
System.out.println("Context Switch : "+contextSwitch);
System.out.println("Throughput : "+getThroughput());
System.out.println("Average Wait Time : "+getAverageWaitTime());
System.out.println("Average Turn Around Time: "+getAverageTurnAroundTime());
}

public static void main(String[] args){
List al = new ArrayList<Robin>();
al.add(new Robin("Robin 1",50));
al.add(new Robin("Robin 2",900));
al.add(new Robin("Robin 3",80));
RoundRobin round = new RoundRobin(100,al);
round.start();
round.report();
}
}
