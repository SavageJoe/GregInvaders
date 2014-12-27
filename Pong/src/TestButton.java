import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class TestButton extends JButton {

	TestButton(String text){

		setText(text);
		
		 addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {
	                //Execute when button is pressed
	                System.out.println("You clicked the button");
	            }
	        });      
	
}
	
	
}
