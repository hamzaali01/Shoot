/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import Objects.Player;
import Objects.Bomber;
import Objects.Fighter;
import Objects.Vehicle;
import Objects.PlayerFire;
import Objects.EnemyFire;
import Objects.FactoryCreator;
import Objects.PlaneFactory;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener
{
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private final int DELAY = 10;
    private Player player;
    private Bomber bomber;
    private Fighter fighter;
    private static ArrayList<Bomber> bombers = new ArrayList<>();
    private ArrayList<Fighter> fighters = new ArrayList<>();
    private ArrayList<PlayerFire> Playerbullets = new ArrayList<>();
    private static ArrayList<EnemyFire> Enemybullets = new ArrayList<>();
    private int w = 1024;
    private int h = 768;	
    private Timer timer;
    private int count = 0;
    JLabel scorelabel = new JLabel("Score = 0");
    public int score=0;
    public static final Color LIGHT_BLUE  = new Color(51,153,255);
	
       
    public Board() 
    {    	
        initBoard();
    }
    
    private void initBoard() //Initializes all the game objects
    {	
    	addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        add(scorelabel);
	
        player = Player.getInstance("src/Sprites/BF-109E/Type-1/Animation/", 0, 0);
        setPreferredSize(new Dimension((int)w, (int)h));   //Set the size of Window     
        player.moveTo((int)w/2, (int)h *3/4);
        timer = new Timer(DELAY, this); //Timer with 10 ms delay 
        timer.start();
    }
    
    
    @Override
    public void paintComponent(Graphics g) //Draws all the components on screen
    {
    	g.setColor(getBackground());		//get the background color
        g.clearRect(0 , 0, (int)w, (int)h);	//clear the entire window
    	Dimension size = getSize();  //get the current window size  	
        w = (int)size.getWidth();
        h = (int)size.getHeight();
        
        g.setColor(LIGHT_BLUE);
        g.fillRect(0, 0, w, h);

        Graphics2D g2d = (Graphics2D) g;
        
        if(player.getVisibility()==true)
        player.paintComponent(g2d);//paint the player 
       
        this.Playerbullets = Vehicle.Playerbullets;
        this.Enemybullets = Vehicle.Enemybullets;
        Draw(bombers,g);
        Draw(fighters,g);
        Draw(Playerbullets,g); // paints each bullet in the list
        Draw(Enemybullets,g); // paints each enemy bullet in the list
       
     
        Toolkit.getDefaultToolkit().sync();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
        step();
        count++;
    }
    
    private void step() 
    {    
        Random rand = new Random();
         FactoryCreator factory = new PlaneFactory();
        if(count==200)
        {
            int rand_int = rand.nextInt(w);
            fighter =  (Fighter) factory.getPlaneFactory("fighter", rand_int, 0);
            fighters.add(fighter); 
        }
        if(count>350)
        {
            int rand_int = rand.nextInt(w);
            bomber = (Bomber) factory.getPlaneFactory("bomber", rand_int, 0);
            bombers.add(bomber);
            count=0;
        }
        
        checkDodge(fighters,Playerbullets);

        player.move(); 
        move(Playerbullets);
        move(Enemybullets);
        move(bombers); 
        move(fighters);
         if(player.getVisibility()==true)
        SomeoneScored();
        repaint();
        
        Cleanup();	//clean the list from unwanted objects
    }    
    
    public void SomeoneScored(){
        score = player.Getscore();
        scorelabel.setText("Score = " + score);
        
    }
    private void Cleanup()
    {
        checkCollision(Playerbullets,bombers);
        checkCollision(Playerbullets,fighters);
        checkCollision(Enemybullets,player);
    }

    private class TAdapter extends KeyAdapter 
    {

        @Override
        public void keyReleased(KeyEvent e) 
        {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            if(player.getVisibility()==true)
            player.keyPressed(e);
        }
    }
    
    public void checkCollision(ArrayList vehicle1, ArrayList vehicle2){
       ArrayList<Vehicle> v1 = vehicle1;
       ArrayList<Vehicle> v2 = vehicle2;
    for(int i=0; i<vehicle1.size();i++){
       for(int j=0; j<vehicle2.size();j++){ 
       v1.get(i).Collision(v2.get(j));
       }
    }
    }
     public void checkCollision(ArrayList vehicle1,Player player){
       ArrayList<Vehicle> v1 = vehicle1;
    for(int i=0; i<vehicle1.size();i++){
       v1.get(i).Collision(player);
       }
    }
     public void checkDodge(ArrayList vehicle1, ArrayList vehicle2){
       ArrayList<Vehicle> v1 = vehicle1;
       ArrayList<Vehicle> v2 = vehicle2;
    for(int i=0; i<vehicle1.size();i++){
       for(int j=0; j<vehicle2.size();j++){ 
       v1.get(i).Dodge(v2.get(j));
       }
    }
    } 
     
    public void Draw(ArrayList vehicles, Graphics g){
        ArrayList<Vehicle> vehicles2 = vehicles;
        Graphics2D g2d = (Graphics2D) g;
       for(int i=0; i<vehicles2.size();i++){  
       vehicles2.get(i).paintComponent(g2d);
       }
    }
    
    public void move(ArrayList vehicles){
         ArrayList<Vehicle> vehicles2 = vehicles;
          for(int i=0; i<vehicles2.size();i++){  
       if(vehicles2.get(i).getVisibility()==false){
           vehicles2.remove(i);
       }
       else
           vehicles2.get(i).move();
       }
    }
}






