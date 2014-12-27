import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Ball extends Shapes {


	private double moveX;
	private double moveY;
	private int ballSize =25;
	private int x;
	private int y;
	
	
	
	Ball(int xGame, int yGame, double moveSpeed){
		Random rand = new Random();
		boolean start = rand.nextBoolean();
		int moveStart = rand.nextInt(4);
			
		switch(moveStart){
		case 0:	
			moveY= -moveSpeed;
			moveX=-moveSpeed;
	
			break;
		case 1:
			moveX=moveSpeed;
			moveY=moveSpeed;
		
			break;
		case 2:
			moveX=-moveSpeed;
			moveY=moveSpeed;
			
			break;
		case 3:
			moveX=moveSpeed;
			moveY=-moveSpeed;
			break;
		}//end case THERE IS A BETTER WAY TO DO THIS USE A LOOP
		
		x = xGame/2;
		y= yGame/2;
		
	}//end contructor 
	

	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.BLUE);
		
			x+=moveX;
			y+=moveY;

		g.fillOval(x, y, ballSize, ballSize);
		
	}//end draw
	
	//Start getters and setters 
	public double getMoveX() {
		return moveX;
	}
	public void setMoveX(double moveSpeed) {
		this.moveX = moveSpeed;
	}
	public double getMoveY() {
		return moveY;
	}
	public void setMoveY(double moveY) {
		this.moveY = moveY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getBallSize() {
		return ballSize;
	}

	public void setBallSize(int ballSize) {
		this.ballSize = ballSize;
	}

	
	
	
}//end class 
