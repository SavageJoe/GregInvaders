import java.awt.Color;
import java.awt.Graphics;


public class Paddle extends Shapes {

	boolean upPaddle; //if the paddle is at the top of the screen this will be true
private int x;
private int y;
private double xMove=0;
	int yUp; 
	int yDown;
private int paddleWidth = 100;
private int paddleHeight = 20;
	public Paddle(boolean up, int width, int height, int ww ){
		
	x = width/2	; //width = length of game area 
	yUp= ww+10; 
	yDown= height - (ww+20);
	upPaddle = up;

}//end contructor
		
	@Override
	public void paintComponent(Graphics g) {
	
	g.setColor(Color.black);
	
	if(upPaddle == true){
		y=yUp; 
	}else{
		y=yDown;
	}
	
	
	g.fillRect(x, y, paddleWidth, paddleHeight);
	
	x+=xMove;
	
	}//end paint 

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getxMove() {
		return xMove;
	}

	public void setxMove(double playerSpeed) {
		this.xMove = playerSpeed;
	}



	public int getPaddleWidth() {
		return paddleWidth;
	}

	public void setPaddleWidth(int paddleWidth) {
		this.paddleWidth = paddleWidth;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPaddleHeight() {
		return paddleHeight;
	}

	public void setPaddleHeight(int paddleHeight) {
		this.paddleHeight = paddleHeight;
	}

}//end class
