import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Brick implements GameElementInterface {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private boolean dead;
	private Color brickColor;
	public Rectangle collider;
	
	
	public Brick(int x, int y){
		this.posX = x;
		this.posY = y;
		this.width = 40;
		this.height = 30;
		this.dead = false;
		this.collider = this.createCollider(posX, posY, width, height);
		
		Random ran = new Random();
		 int r = ran.nextInt(256);
		 int g = ran.nextInt(256);
		 int b = ran.nextInt(256);
		brickColor = new Color(r,g,b);
		 
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
	public void setX(int xCoOrdinate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int yCoOrdinate) {
		// TODO Auto-generated method stub

	}
	
	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(brickColor);
		g.fillRect(posX, posY, width, height);
	}
	
	public Rectangle createCollider(int x, int y, int w, int h){
		return new Rectangle(x, y, w, h);
	}

}
