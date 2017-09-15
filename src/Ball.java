import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball implements GameElementInterface, Observer{
	
	private int posX; 	//X-coordinate position of ball
	private int posY;	//Y-coordinate position of ball
	private int velX;	//Velocity on X-axis
	private int velY;
	private Color ballColor;
	public Rectangle ballCollider;
	
	public Ball(int posX, int posY, int velX, int velY, Color ballColor){
		this.posX = posX;
		this.posY = posY;
		
		this.velX = velX;
		this.velY = velY;
		this.ballColor = ballColor;
		this.ballCollider = this.createCollider(posX, posY, 20, 20);
		
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return posX;
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return posY;
	}
	@Override
	public void setX(int posX) {
		// TODO Auto-generated method stub
		this.posX = posX;
		
	}
	@Override
	public void setY(int posY) {
		// TODO Auto-generated method stub
		this.posY = posY;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public void draw(Graphics g){
		g.setColor(ballColor);				//TO-DO: Add variable for color
		g.fillOval(posX, posY, 20, 20); 		//TO-DO: Add import for constants and add dimensions
	}
	
	public void checkBounds(int boundaryX, int boundaryY){
		if (posX < 0 || posX > boundaryX){
			velX = -velX;
		}
		if (posY < 0 || posY > boundaryY){
			velY = -velY;
		}
	}
	
	public Rectangle createCollider(int x, int y, int w, int h){
		return new Rectangle(x, y, w, h);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Observer observer) {
		// TODO Auto-generated method stub
		Move move = new Move((Ball) observer);
		move.execute();
	}

}
