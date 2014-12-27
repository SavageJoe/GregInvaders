import java.awt.Color;
import java.awt.Graphics;

//basic enemy 
public class Peon extends Shapes{

	//initial x
	private int xPos;
	//initial y
	private int yPos;

	private int width = 100;
	private int heigth = 25;
	
	//move positions
	private boolean moveRight = false;
	private boolean moveLeft = false;
	private boolean moveUp = false;
	private boolean moveDown = false;
	
	Peon(int x, int y){
		xPos = x;
		yPos = y;
	}
	
	
	@Override
	void paintComponent(Graphics g) {

		if(moveRight)
		{
			xPos++;
		}
		
		if(moveLeft)
		{
			xPos--;
		}
		
		if(moveDown)
		{
			yPos++;
		}
		
		if(moveUp)
		{
			yPos--;
		}
		
	//main body	
	g.setColor(Color.green);
		g.fillRect(xPos, yPos,width , heigth);
		
	//windows
		int windowPlace = xPos+7;
		g.setColor(new Color(0,102,0));
		
		for(int i=0;i<4;i++)
		{
			int x = windowPlace;
			int y =yPos+heigth/2-5;
			g.fillRect(x, y, 10, 10);
			windowPlace += width/4;
		}
		
		
		
	}//end paint


	//START GETTERS AND SETTERS 

	public int getxPos() {
		return xPos;
	}



	public void setxPos(int xPos) {
		this.xPos = xPos;
	}



	public int getyPos() {
		return yPos;
	}



	public void setyPos(int yPos) {
		this.yPos = yPos;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeigth() {
		return heigth;
	}



	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}



	public boolean isMoveRight() {
		return moveRight;
	}



	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}


	public boolean isMoveLeft() {
		return moveLeft;
	}


	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}


	public boolean isMoveUp() {
		return moveUp;
	}


	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}


	public boolean isMoveDown() {
		return moveDown;
	}


	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}

}//end class 
