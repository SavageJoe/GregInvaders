import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel {
	
	
	//SETUP BOUNCE SO THE ANGLE OF THE BOUNCE WILL DEPEND ON THE PADDLE POSITION 
	
	// make some doubles and start testing what happens when the x movespeed becomes a decimal  

int delay = 15; //tick delay 
int wallWidth = 10;	//thickness of walls 
int gameX =400, gameY = 510;	//the width of the game area 450 500 
double moveSpeed = 2; //move speed of ball 
double defaultMoveSpeed = moveSpeed;
double playerSpeed = 2; //move speed of players
double defaultPlayerSpeed = playerSpeed;
JButton restart = new JButton("Try Again");

Direction left = new Direction("<");//move buttons 
Direction right = new Direction(">");


boolean rightHit = false; //if the paddle hits the right wall
boolean leftHit = false;




boolean win = false;


void restart(){
	t.start();
	win = false;
    b.setX(gameX/2);
    b.setY(gameY/2);
    b.setMoveY(-defaultMoveSpeed);
    b.setMoveX(defaultMoveSpeed);
    
    moveSpeed = defaultMoveSpeed;
    playerSpeed = defaultPlayerSpeed;
    levelTime =0;
    levelNumber =1;
	
}//sets play values to default 

public Game(){
	
	restart.setBounds(500, 250, 100, 50);
	this.add(restart);
	restart.setVisible(false);
	
	restart.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {//when RESTART is hit 
	       
	    	restart();
	        restart.setVisible(false);
	        
	        setVisible(false);
	       
	    
	         
	    }
	});//end actionpreformed 

	left.setBounds(440, gameY-100, 100, 25);
	this.add(left);
	
	
	
left.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {//when LEFT button is hit 
     
        
        if(rightHit){
        p.setX(gameX-p.getPaddleWidth()-1);
        p.setxMove(-playerSpeed);
        rightHit=false;
        }else{
        p.setxMove(-playerSpeed);
        
      
        
        }
    }
});//end actionpreformed 


right.setBounds(560, gameY-100, 100, 25);
this.add(right);

right.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {//when RIGHT button is hit 
    
        
        if(leftHit){
        p.setX(wallWidth+1);
        p.setxMove(playerSpeed);
        leftHit=false;
        }else{
        p.setxMove(playerSpeed);
        }
    }
});//end actionpreformed 


}//end constructor

int x;
int y;
	



	Ball b = new Ball(gameX,gameY, moveSpeed);
	Paddle p = new Paddle(false,gameX,gameY,wallWidth);
	Paddle c = new Paddle(true,gameX,gameY,wallWidth);
	

	int levelNumber = 1;
	String gameText= "Level "+ Integer.toString(levelNumber);
	
	public void paintComponent(Graphics g){
		
		
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, gameX, this.getHeight() ); //sets background 
		
		g.setColor(Color.black);
		g.fillRect(0, 0, gameX, wallWidth); //top wall
		g.fillRect(0, wallWidth, wallWidth, gameY - wallWidth);//left wall 
		g.fillRect(0, gameY, gameX, wallWidth);//bottom wall 
		g.fillRect(gameX,0,wallWidth,gameY+wallWidth);//right wall
		


		//p.getY() - b.getBallSize()
		
		b.paintComponent(g);
		p.paintComponent(g);
		c.paintComponent(g);
		
		
		
		g.setColor(Color.BLACK); //level text
		g.setFont(new Font("default", Font.BOLD, 20));
		g.drawString(gameText, 500, 200);
		
	//	g.setColor(Color.red);
	//	g.drawRect(b.getX()+b.getBallSize(), 0, 5, 500);
		
	}//end paint 
	

	
	
	
	ActionListener tick = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) { //what happens when timer ticks 
			
	
			moveC(); // moves the npc
			paddleBoundsStop(); //stops the player paddle from going through the wass
			ballBounce(); //bounce conditions for ball 
			
			nextLevelCheck();
			repaint();
			 x = b.getX();
			y = b.getY();
		}
		
	};//end actionlistener
	
	int levelTime;
	int nextLevelDelay=(1000/delay) * 10; //should be 30 seconds roughly 
	void nextLevelCheck(){
		levelTime++;
		
		if(levelTime>=nextLevelDelay){
			moveSpeed+=.5;
			
			levelNumber++;
			playerSpeed+=.2;
			levelTime=0;
			
		}
		


		
		//System.out.println(levelTime);
	}
	
	void moveC(){
	//get middle of paddle and ball 
		int ballMiddle = b.getX()+b.getBallSize()/2;
		int npcMiddle = c.getX()+c.getPaddleWidth()/2;
		
		if(ballMiddle > npcMiddle){ //the middle of the npc will try to match the middle of the ball
			c.setxMove(playerSpeed);
		}else{
			c.setxMove(-playerSpeed);
		}
		
		
		if(b.getX() <= 47 && c.getX() <=47) //47 is the xposition of the ball when the paddle starts warping into the wall
		c.setxMove(0); // stops paddle from going into wall... THIS IS TERRIBLE PROGRAMMING 
		
		if(b.getX() >= 340 && c.getX() + c.getPaddleWidth() >=340)
		c.setxMove(0);
		
	
	}//
	
	
	void paddleBoundsStop(){
		
		if(p.getX() + p.getPaddleWidth() >= gameX){ //right wall git
			p.setxMove(0);
			rightHit=true;
		}//end if
		
		if(p.getX() <= wallWidth){
			p.setxMove(0);
			leftHit=true;
		}
		
	}//end paddleboundsstop 

	void lost(){
		String lost = "Game Over";
		
			
			//moveSpeed=0;
			b.setMoveX(0);
			b.setMoveY(0);
			
			p.setxMove(0);
			c.setxMove(0);
			
			levelNumber=1;
		//	playerSpeed=0;

			gameText = lost;
			restart.setVisible(true);
			t.stop();
	}
	
	
	void ballBounce(){
		int size = b.getBallSize();
		int ballMid = b.getX() + b.getBallSize()/2;
		
		if(b.getX()+size>=gameX){ //right wall bounce
			b.setMoveX(-moveSpeed);
			
			
		}
		
		if(b.getX()<=wallWidth){ //left wall bounce
			b.setMoveX(+moveSpeed);
			
		}
		
		if(b.getY()<=wallWidth){ //up bounce
			b.setMoveY(+moveSpeed);
			win=true;
			//WINNER!
		}
		
		if(b.getY()>=gameY-wallWidth -size/2){ //down bounce
			b.setMoveY(-moveSpeed);
			lost();
			
		}else{
			gameText= "Level "+ Integer.toString(levelNumber);
		}
		
	
		
		if(b.getY() >= p.getY() - b.getBallSize() && b.getY() <= gameY - (wallWidth + 20)){  //down paddle hit
			
			
			if(b.getX()+b.getBallSize() >= p.getX() && b.getX() <= p.getX()+p.getPaddleWidth()){ //x bounds
			double relativePaddle = (ballMid - p.getX())*.01; 
		//	System.out.println(relativePaddle);
			b.setMoveY(-moveSpeed);
			if(relativePaddle >.5){
				b.setMoveX(moveSpeed);
			}else{
				b.setMoveX(-moveSpeed);
			}
			
//			int ballMid = b.getX() + b.getBallSize()/2;
//			int paddleMid = p.getX() + p.getPaddleWidth();
			
			//System.out.println("RELPAD" + relativePaddle);
			}
		}
		
		//CLOSER TO THE EDGE = SMALLER moveY 
		// use as a percentage 0(left of paddle) to 100 (right of paddle) 
		
		if(b.getY() <= c.getY() + c.getPaddleHeight()&& b.getY() >= c.getY()){ //up paddle hit 
			
			 
			if(b.getX()+b.getBallSize() >= c.getX() && b.getX() <= c.getX()+c.getPaddleWidth()){
			b.setMoveY(moveSpeed);
					}
		}//end if 
		
		//HOW SOULD THE EDGE HIT BEHAVE?
		// THE CLOSER TO THE EDGE THE BALL HITS, THE LESS Y SHOULD BE 
		// CLOSER EDGE HIT SHOULD ALSO MEAN MORE SPEED 
	//double debug = (b.getX() + b.getBallSize()/2 - p.getX())*.01;
//	System.out.println(debug);
		
	}//end ball
	
	Timer t = new Timer(delay, tick);
	
}//end class 
