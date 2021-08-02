package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public abstract class Vehicle 
{
    public static ArrayList<EnemyFire> Enemybullets = new ArrayList<>();
     public static ArrayList<PlayerFire> Playerbullets = new ArrayList<>();
	protected Image[] images;
	protected int x;
	protected int y;
	protected int w;
    protected int h;
	protected int dx, dy;
	protected boolean visibility; // to delete the vehicles which are not visible
	protected long count = 0;
	private static int score=0;
	
	public Vehicle(String path, int x, int y)
	{
		this.x = x;
		this.y = y;
		visibility = true;
		images = new Image[3];
		
		for(int i=1; i<4; i++) // Iterating between 3 images for each aircraft
		{
		ImageIcon imageIcon = new ImageIcon(path + i + ".png" );
		images[i-1] = imageIcon.getImage();
		}		
		w = images[0].getWidth(null);
        h = images[0].getHeight(null);   
	}
	public Vehicle(String path, MyPoint p)
	{
		x = p.x;
		y = p.y;
		visibility = true;
		images = new Image[3];
		
		for(int i=1; i<4; i++)
		{
		ImageIcon imageIcon = new ImageIcon(path + i + ".png" );
		images[i-1] = imageIcon.getImage();
		}		
		w = images[0].getWidth(null);
        h = images[0].getHeight(null);    
	}
	
	public Rectangle getBounds() {
	    return new Rectangle(x-w/2, y-w/2, w, h);
	}
	
	
	
	public void paintComponent(Graphics2D g) 
	{
		int num = (int)(count%3);
		g.drawImage(images[num], x - images[num].getWidth(null)/2, y - images[num].getHeight(null)/2, null);
		g.setColor(new Color(255,0,0));
		g.drawRect(x-w/2, y-w/2, w, h);//Only to show image bounds, can be removed
		count++;

		
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public abstract void move();
	public abstract void Fire();
	public abstract void Dodge(Vehicle v);
	
	public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image[] getImage() {
        
        return images;
    }

	//returns visibility of the vehicle
	public boolean getVisibility(){
      return visibility;  
    }	
   
	//checks whether a vehicle is colliding with another vehicle
	public void Collision(Vehicle v2){
     Rectangle r1 = this.getBounds();
	 Rectangle r2 = v2.getBounds();
	 if(r1.intersects(r2))
	 {
	 visibility = false;
	 v2.visibility = false;
	 score = score + 10;
	 }
	}
	public int Getscore(){
		return score;
	}
}
