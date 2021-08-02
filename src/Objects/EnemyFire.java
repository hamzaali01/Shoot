/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author HP
 */
public class EnemyFire extends Vehicle {

    private final int BULLET_SPEED = 7;
	public EnemyFire(String path, int x, int y)
	{
		super(path, x, y);
	}
	
	public EnemyFire(String path, MyPoint p)
	{
		super(path, p);
	}
	
    @Override
	public void move()
	{
        this.y+= BULLET_SPEED;

        if(this.y>=750)
        visibility = false;
	}
	 
    @Override
	public void Fire(){
	
		
	}
    @Override
        public void Dodge(Vehicle v){

        }  
    
} 
