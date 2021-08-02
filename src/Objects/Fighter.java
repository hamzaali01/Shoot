package Objects;


import java.awt.Rectangle;
import java.util.ArrayList;
public class Fighter extends Vehicle
{
    private EnemyFire b;
    Rectangle rec;
      FactoryCreator factory = new ProjectileFactory();
	public Fighter(String path, int x, int y)
	{
		super(path, x, y);
	}
	
	public Fighter(String path, MyPoint p)
	{
		super(path, p);
	}
	
    @Override
       public void move()
	{
        this.y+=2;
        
        if(this.y>750)
        visibility = false;
        
        double rand = Math.random()*1000;
        if(rand<5)
            Fire();
	}
	
    @Override
       public void Fire(){
	b = (EnemyFire) factory.getProjectileFactory("ENEMYFIRE", x, y);
        Enemybullets.add(b); //Adding the bullet in the list	
       }
       
       
    //dodges another vehicle if it is near the fighter sprite
    @Override
    public void Dodge(Vehicle v){
     rec = getBounds();
     rec.height = rec.height + 150;
     Rectangle rec2 = v.getBounds();
     if(rec.intersects(rec2)==true)
     {
     if(rec.getCenterX()<=rec2.x)
     this.x -=5;
     else
     this.x +=5;
     }
    }
    
    public ArrayList getBullets(){
        return Enemybullets;
    }
} 