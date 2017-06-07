
public class Circle implements Comparable<Circle>
{	
	protected float radius;
	protected static final float PI = 3.14f;

	public Circle(float radius) 
	{
		this.radius = radius;
	}
	
	public boolean equals(Circle  circle)
	{
		if (this.radius == circle.radius)
			return true;
		else
			return false;
	}
	
	public int compareTo(Circle circle)
	{
		if (this.radius < circle.radius)
			return -1;
		else
			if (this.radius == circle.radius)
				return 0;
			else
				return 1;
	}
	
	public float perimeter()
	{
		return(2 * PI * radius);
	}
	
	public float area()
	{
		return(PI * radius * radius);
	}

}
