
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
	
		//grabs any peon furthest to the right
		int furthestRightPeon(Peon[] peonArray){
		
		int furthestRightPeon=0;
		int thisPeonX = 0;
		int thisPeonY = 0;
		
		for(int i = 0;i<peonArray.length;i++)
		{
			if(peonArray[i] != null)
			{
					//peonArray[i].paintComponent(g);
				
				int currentPeonX = peonArray[i].getxPos();
				int currentPeonY = peonArray[i].getyPos();
				
				
				
				if(currentPeonX>thisPeonX )//|| currentPeonY>thisPeonY)
				{
					
					thisPeonX = currentPeonX;
					thisPeonY= currentPeonY;
					
					furthestRightPeon = i;
								
				}
			}
			
		}
		return furthestRightPeon;
	}//end furthestRightPeon
		
		//top left
		int furthestLeftPeon(Peon[] peonArray){
			
		int furthestLeftPeon=0;
		int thisPeonX = 1000;
		int thisPeonY = 1000;
		
		for(int i = 0;i<peonArray.length;i++)
		{
			if(peonArray[i] != null)
			{
				
				int currentPeonX = peonArray[i].getxPos();
				int currentPeonY = peonArray[i].getyPos();
				
				if(currentPeonX<thisPeonX || currentPeonY<thisPeonY)
				{
					thisPeonX = currentPeonX;
					thisPeonY= currentPeonY;
					
					furthestLeftPeon = i;
						
				}
			}
			
		}
		return furthestLeftPeon;
	}//end furthestRightPeon
		
		//grabs one of the lowest peons
		int furthestDownPeon(Peon[] peonArray){
			
		int furthestRightPeon=0;
		int thisPeonX = 0;
		int thisPeonY = 0;
		
		for(int i = 0;i<peonArray.length;i++)
		{
			if(peonArray[i] != null)
			{
			
			
			int currentPeonX = peonArray[i].getxPos();
			int currentPeonY = peonArray[i].getyPos();
			
			if(currentPeonY>thisPeonY )//|| currentPeonY>thisPeonY)
			{
				
				thisPeonX = currentPeonX;
				thisPeonY= currentPeonY;
				
				furthestRightPeon = i;
							
			}
			}
			
		}
		return furthestRightPeon;
	}//end furthestRightPeon
		
		
}//end class 
