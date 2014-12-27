import java.awt.Color;
import java.awt.Graphics;


public class Wall extends Shapes {

	int gameX; int gameY; int wallWidth;
	
	Wall(int X, int Y, int W){
		gameX=X;
		gameY=Y;
		wallWidth=W;
		
	}
	
	
	
	@Override
	void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.green);
		g.fillRect(0, 0, gameX, wallWidth); //top wall
		g.fillRect(0, wallWidth, wallWidth, gameY - wallWidth);//left wall 
		g.fillRect(0, gameY, gameX, wallWidth);//bottom wall 
		g.fillRect(gameX,0,wallWidth,gameY+wallWidth);//right wall
		
		
	}

}
