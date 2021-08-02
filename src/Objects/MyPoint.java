package Objects;

public class MyPoint 
{
	public int x;
	public int y;
	
	public MyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public MyPoint(MyPoint p)
	{
		x = p.x;
		y = p.y;
	}
}
