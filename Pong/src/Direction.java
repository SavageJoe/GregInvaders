import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Direction extends JButton {

	
	private boolean move = false;

	Direction(String x){
		
		this.setText(x);
		
		
		
//	addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {//when button is hit 
//             System.out.println("Action performed" + x);
//             
//             if(notPressed){
//             move = true;
//             }else{
//            	 move = false;
//            	 notPressed = true;
//             }
//             
//           //  setDirection();
//             
//         }
//     });
//	}//end constructor 
	


	
	}
	//START GETTERS AND SETTERS



	
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}
}//end class
