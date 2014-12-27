
public class AI {
	
	private int wallWidth;
	private int gameX;
	private int gameY;
	
	AI(int ww, int x,int y){
		
		wallWidth = ww;
		gameX=x;
		gameY=y;
	}

	//creates an array of Peons that space themselves out evenly on the game 
		Peon[] placePeons(int numberOfPeons)
		{
			

			int xPos = wallWidth+20;
			int yPos = wallWidth+20;
			int xSpacing = gameX/3;
			
			Peon[] peon = new Peon[numberOfPeons];
			
			for(int i=0;i<peon.length;i++)
			{
				//when a thrid peon has been generated accross 

					peon[i] = new Peon(xPos,yPos);
					xPos+=xSpacing;
				
					if((i+1)%3==0)
					{
						xPos -= xSpacing*3; 
						yPos += 50;
					
					}
			}
			
			return peon;
		}//end placePeons 
	
		

		
}//end class 
