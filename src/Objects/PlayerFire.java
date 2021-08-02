package Objects;



public class PlayerFire extends Vehicle
{
    
    private final int BULLET_SPEED = 9;
	public PlayerFire(String path, int x, int y)
	{
		super(path, x, y);
	}
	
	public PlayerFire(String path, MyPoint p)
	{
		super(path, p);
	}
	
    @Override
	public void move()
	{
        this.y-= BULLET_SPEED;

        if(this.y<=0)
        visibility = false;
	}
	 
    @Override
	public void Fire(){
	
		
	}
    @Override
        public void Dodge(Vehicle v){

        }  
    
 
} 
