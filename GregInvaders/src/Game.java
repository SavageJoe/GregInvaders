import java.awt.Color;
import java.awt.Graphics;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

//SETTING A PEONARRAY TO NULL WILL DELETE THE OBJECT 
//SETUP A FURTHEST UP VARIABLE IN AI 
public class Game extends JPanel implements KeyListener {
	
	private int gameX = 500;
	private int gameY = 460;
	private int wallWidth = 15;
	private int delay = 10;
	
	Wall Wall = new Wall(gameX,gameY,wallWidth);
	Player p = new Player(wallWidth, gameX, gameY);
	AI ai = new AI(wallWidth,gameX,gameY);

	
	//generates peons for the game
	Peon peonArray[] = ai.placePeons(10);
	
	private boolean hitRightBoundry = false;
	private boolean hitLeftBoundry = false;
	private boolean hitdownBoundry = false;
	private boolean hitUpBoundry = true;
	
	
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, gameX, gameY ); //sets background 
		
		Wall.paintComponent(g); //set wall
		p.paintComponent(g);

		
		peonArray[0]=null;
		
		//any peon furthest to the right
		int furthestRightPeon=ai.furthestRightPeon(peonArray);
		
		//top left peon
		int furthestLeftPeon=ai.furthestLeftPeon(peonArray);
		
		//any peon furthest to the bottom
		int furthestDownPeon=ai.furthestDownPeon(peonArray);

		for(int i = 0;i<peonArray.length;i++)
		{
			if(peonArray[i] != null)
			{
				peonArray[i].paintComponent(g);
			}
		}	
			//right bounds 
			if(peonArray[furthestRightPeon].getxPos()>=gameX-peonArray[furthestRightPeon].getWidth()
					&& !hitRightBoundry)
			{
				hitRightBoundry = true;
				hitLeftBoundry = false;
				hitdownBoundry = false;
				hitUpBoundry = false;
			
				
			}
	
			//left bounds 
			if(peonArray[furthestLeftPeon].getxPos()<=wallWidth)
			{
				hitLeftBoundry = true;
				hitRightBoundry = false;
				hitdownBoundry = false;
				hitUpBoundry = false;
			}
			
			//down bounds 
			if(peonArray[furthestDownPeon].getyPos()>=gameY-100 && !hitLeftBoundry)
			{
				 hitdownBoundry = true;
				 hitRightBoundry = false;
				 hitLeftBoundry = false;
				 hitUpBoundry = false;
			}
			
			//up bounds 
			if(peonArray[furthestLeftPeon].getyPos()<=wallWidth+10 && !hitRightBoundry)
			{
				 hitdownBoundry = false;
				 hitRightBoundry = false;
				 hitLeftBoundry = false;
				 hitUpBoundry = true;
			}
			
			
			
			for(int i = 0;i<peonArray.length;i++)
			{
				
			if(hitRightBoundry)
			{
				
				
				if(peonArray[i] != null)
				{
					peonArray[i].paintComponent(g);
				
				
				peonArray[i].setMoveLeft(false);
				peonArray[i].setMoveRight(false);
				peonArray[i].setMoveUp(false);
				peonArray[i].setMoveDown(true);
				
				}
			}
			
			if(hitdownBoundry)
			{
				if(peonArray[i] != null)
				{
					peonArray[i].paintComponent(g);
				
				peonArray[i].setMoveLeft(true);
				peonArray[i].setMoveRight(false);
				peonArray[i].setMoveUp(false);
				peonArray[i].setMoveDown(false);
				}
			}
			
			if(hitLeftBoundry)
			{
				if(peonArray[i] != null)
				{
					peonArray[i].paintComponent(g);
				
				peonArray[i].setMoveLeft(false);
				peonArray[i].setMoveUp(true);
				peonArray[i].setMoveDown(false);
				peonArray[i].setMoveRight(false);
				}
			}
			
			if(hitUpBoundry)
			{		
				if(peonArray[i] != null)
				{
					peonArray[i].paintComponent(g);
				
					peonArray[i].setMoveLeft(false);
					peonArray[i].setMoveUp(false);
					peonArray[i].setMoveDown(false);
					peonArray[i].setMoveRight(true);
				}
			}
		
			
			
		}//end loop
		
		
		
	}//end paint 
	
	

	
	
	ActionListener tick = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) { //what happens when timer ticks 
			
			
			
			repaint();
			
			if(rightP){
				p.setStartX(p.getStartX()+2);
			}
		}
		
	};//end actionlistener
	

	
	ActionListener rightTick = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) { //RIGHT TIMER 
			
			
		//	p.setStartX(p.getStartX()+2);
			
		
		}
		
	};//end actionlistener
	
	ActionListener leftTick = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) { //RIGHT TIMER 
			
			
			p.setStartX(p.getStartX()-2);
			
		
		}
		
	};//end actionlistener
	
	
	
	Timer t = new Timer(delay,tick); 
	Timer right = new Timer(delay,rightTick); 
	Timer left = new Timer(delay,leftTick); 
	
	
	Game(){
	
	     
	        setFocusable(true);
	        requestFocusInWindow();
	        addKeyListener(this);
	        
		
	}//end game 
	
	
	private int keyCode; //character code 
	
	private int[] keyCodeArray = new int[10];
	
	private boolean moveHeld = true;
	private int loop = 0;
	public void keyPressed(KeyEvent e){
		keyCode = e.getKeyCode();
		
		keyCodeArray[loop] =e.getKeyCode();
		
	
		System.out.println(keysPressed);
		if(keyCode== KeyEvent.VK_D || keyCode == KeyEvent.VK_A){
		checkRight();
		checkLeft();
	
			e.consume();
		}
		
		if(loop>keyCodeArray.length-2){
		loop=0;
		}else{
		loop++;
		}
		
		
		
	}//end keypressed
	
	
boolean rightP=false;

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		//for(int i=0; i<keyCodeArray.length;i++){
		
		if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_A){
		moveHeld=true;
		if(rightP){
		right.stop();
		rightP=false;
		}
		left.stop();
		System.out.println("A OR D was released");
		
		}
	
	//	}//end for
	
	}

	int keysPressed;
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	void checkRight(){//checks if "d" is pressed 
		
		if(keyCode == KeyEvent.VK_D && moveHeld){
			System.out.println("D was pressed");
			moveRight();
			
		}
	}//end checkright 
	
	void checkLeft(){
		if(keyCode == KeyEvent.VK_A && moveHeld){
			System.out.println("A was pressed");
			moveLeft();
			
		}
	}
	
	void moveRight(){
		right.start();
		moveHeld=false;
		rightP=true;
	}
	
	void moveLeft(){
		left.start();
		moveHeld=false;
		
	}
	
	
}//end game 
