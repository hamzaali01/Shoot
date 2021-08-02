package Objects;


public class Bomber extends Vehicle
{
	public Bomber(String path, int x, int y)
	{
		super(path, x, y);
	}
	
	public Bomber(String path, MyPoint p)
	{
		super(path, p);
	}
	
        @Override
	public void move()
	{
        this.y+=2;
        
        if(this.y>750)
        visibility = false;
	}
	
        @Override
	public void Fire()
	{
		
	}
        @Override
        public void Dodge(Vehicle v){

        }
} 