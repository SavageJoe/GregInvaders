import java.awt.Color;
import java.awt.Graphics;


public class Player extends Shapes {

	private int startY;private int startX; //start positions, will also be used for moving 
	private int w=50;private int h=10; //base rect on the player
	private int finW=5; private int finH=10; //fins on the player
	private int gunW=10; private int gunH=30; //gun on player 

	private int hitPointGunY = startY-gunH -gunH;
	
	Player(int wallW, int gameX, int gameY){
		
		startY=gameY - (wallW*2);
		startX=gameX/2;
	}
	
	@Override
	void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.GREEN);
		g.fillRect(startX, startY, w, h); //base of player 
		g.fillRect(startX, startY-finH, finW, finH); //left fin
		g.fillRect(startX+w-finW, startY-finH, finW, finH); //right fin 
		g.fillRect(startX + (w/2-gunW/2),startY-gunH,gunW,gunH);
		
		
	}//end paint
	
	//START GETTERS AND SETTERS 

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getFinW() {
		return finW;
	}

	public void setFinW(int finW) {
		this.finW = finW;
	}

	public int getFinH() {
		return finH;
	}

	public void setFinH(int finH) {
		this.finH = finH;
	}

	public int getGunW() {
		return gunW;
	}

	public void setGunW(int gunW) {
		this.gunW = gunW;
	}

	public int getGunH() {
		return gunH;
	}

	public void setGunH(int gunH) {
		this.gunH = gunH;
	}

	public int getHitPointGunY() {
		return hitPointGunY;
	}

	public void setHitPointGunY(int hitPointGunY) {
		this.hitPointGunY = hitPointGunY;
	}

}//end player
