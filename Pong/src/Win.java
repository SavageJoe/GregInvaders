import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Win extends Splash {
	
	int delay = 100;
	int fadWhite = 0;
	int fadYellow = 0;
	
	int textCut=60;
	
	int i=0; // loop counter 
	
	void reset(){
		 delay = 100;
		 fadWhite = 0;
		 fadYellow = 0;
		 paragraphCounter=100;
		 textCut=60;
		 i=0; // loop counter 
			 winString = winText.split("");
			hold = winText.substring(0, 1);
		done = false;
		
	}//sets values to default 
	
	String winText = "Congrats, the evil computer paddle has been destroyed.  You really showed"
			+ " alot of hustle in taking it down. Thank you for playing"
			+ " my amazing game... E3 is next..........";
	
	String[] winString = winText.split("");
	
	String hold = winText.substring(0, 1);
	
			
	ActionListener tick = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) { //what happens when timer ticks 
		//	System.out.println(fadWhite);
			colorChange();
			if(fadYellow>=50)
			spell();
			repaint();
			reSet(); //takes player back to menu 
					
		}
	};//end actionlistener
	
	boolean done = false;
	
	void reSet(){
		if(i == winText.length()){
			done = true;
			i=0;
		}
	}//end reset 
	
	void colorChange(){
		if(fadWhite<=50){
		fadWhite++;
		}else{
			fadYellow++;
		}
		
	}
	
	Timer t = new Timer(delay, tick);

	int paragraphCounter=100;
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Color fadeWhite = new Color(225, 225,225, fadWhite );
		Color fadeYellow = new Color(225, 225,0, fadYellow );
		
		if(fadWhite<=50){
		g.setColor(fadeWhite);
		g.fillRect(0, 0, getWidth(),getHeight() );
		}else{
			if(fadYellow<50){
			g.setColor(fadeYellow);
			g.fillRect(0, 0, getWidth(),getHeight() );
				}
					
				
		}
		
		if(fadYellow>=50){
			g.setColor(Color.black);
			g.setFont(new Font("default", Font.BOLD, 20));
			
			if(!(i % textCut == 0)){
			g.drawString(hold, 0, paragraphCounter);
			}else{
				paragraphCounter+=30;
			//	g.drawString(hold, 0, paragraphCounter);
			}
		}
		

		
		//(255, 225,0, 128 ); YELLOW
	}//end paint
	

	
	void spell(){
		i++;
		
		if(i % textCut ==0){
			
			if(hold.equals(" ")){
				hold="";
				
			}else{
				hold=winString[i];
				
			}
			
		}else{
		
		if(i<winString.length){
		hold+=winString[i];

		}//end if 
		
		}
		
	}


}//end class 
