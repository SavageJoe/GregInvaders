import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public abstract class Splash extends JPanel {
	int frameX=700;
	int frameY=550;
			

	@Override
	public abstract void paintComponent(Graphics g);


}//end class
