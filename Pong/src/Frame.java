import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
	
		setResizable(false);
		
		
		Win win = new Win();
		Game game = new Game();
		StartScreen start = new StartScreen(700,550);
		
		
		JPanel contentpane = new JPanel(new CardLayout(0,0));
		setContentPane(contentpane);
		contentpane.add(game);
		contentpane.add(start);
		contentpane.add(win);
		
		win.setLayout(null);
		game.setLayout(null);
		start.setLayout(null);
		
		win.setVisible(false);
		game.setVisible(false);
		start.setVisible(true);
		
		
		
		start.start.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {//when Start button is hit 
		    
		     game.setVisible(true); //true
		     start.setVisible(false);
		     win.setVisible(false);
		
		   
		     game.restart();
		    
		 
		    }
		});//end actionpreformed 
		
	
		
		game.t.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {//when timer does something
		        
		    	
			 if(game.win){ //when the game is won 
				 
				 game.t.stop();
					win.setVisible(true);
					game.setVisible(false);
					start.setVisible(false);
					win.t.start();
			 }
			        
			    }
			});//end actionpreformed 
	
		
		win.t.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {//when timer does something
		        
		    	
			 if(win.done){ //when win animation is over 
				 
				 win.t.stop();
					win.setVisible(false);
					game.setVisible(false);
					start.setVisible(true);
				
					win.reset();
			 }
			        
			    }
			});//end actionpreformed 
		
		
	}//end frame

}//end class
