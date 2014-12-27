import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


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
		
		Game g = new Game();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		//g.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		g.setLayout(null);
		g.setVisible(true);
		setContentPane(g);
		g.t.start(); 
		
		
//		Panel p = new Panel();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		p.setBorder(new EmptyBorder(5, 5, 5, 5));
//		p.setLayout(new BorderLayout(0, 0));
//		setContentPane(p);
		
	}

}//end class 
