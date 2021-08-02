package Objects;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Vehicle
{
    private static Player player;
    private PlayerFire b;
     FactoryCreator factory = new ProjectileFactory();
	private Player(String path, int x, int y)
	{
		super(path, x, y);
	}
	
	private Player(String path, MyPoint p)
	{
		super(path, p);
	}
        
        public static Player getInstance(String path, int x, int y){
            if(player==null)
                return new Player(path,x,y);
            else
                return player;
        }
         public static Player getInstance(String path,MyPoint p){
            if(player==null)
                return new Player(path,p);
            else
                return player;
        }
	
    @Override
	public void move()
	{
        if(x>=130 && x<=880 && y>=130 && y<=540) //making sure the player aircraft does not go beyond the screen limit
        {
		this.x += dx;
		this.y += dy;
        }
        //resetting the player position if he goes beyond screen limit
        else if(x<130)
        x=130;
        else if(x>880)
        x=880;
        else if(y<130)
        y=130;
        else if(y>540)
        y=540;
        
	}
	
	public void keyPressed(KeyEvent e) 
	{
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -4;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 4;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -4;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 4;
        }
        if (key == KeyEvent.VK_SPACE) {
            Fire();
        }
    }
    @Override
	public void Fire()
	{
        b = (PlayerFire) factory.getProjectileFactory("PLAYERFIRE", x, y);
        Playerbullets.add(b); //Adding the bullet in the list
	}

   
    public void keyReleased(KeyEvent e) 
    {        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    @Override
        public void Dodge(Vehicle v){
                  
    }
        public ArrayList<PlayerFire> getBullets(){
    return Playerbullets;
    }
}
