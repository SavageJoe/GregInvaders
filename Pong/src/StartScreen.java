import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;


public class StartScreen extends Splash{
int frameX;
int frameY;
String welcome = "Welcome to Greg Pong!";
String instr1 = "The movespeed of the ball will increase every ";
String instr2 =  "10 seconds... can you beat the computer paddle!?";
JButton start = new JButton();

	public StartScreen(int x, int y){
		frameX = x;
		frameY = y;
		
		
		start.setBounds(0, frameY-200, frameX, 200);
		start.setFont(new Font("default", Font.BOLD, 100));
		start.setText("Start");
		add(start);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fillRect(0, 0, frameX, frameY);
		
		g.setColor(Color.black);
		g.setFont(new Font("default", Font.BOLD, 20));
		
	g.drawString(welcome, frameX/2-100, frameY/2-200);
	g.drawString(instr1, frameX/2-200	, frameY/2-100);
	g.drawString(instr2, frameX/2-200, frameY/2+30-100);
		
	}

}//end splash
