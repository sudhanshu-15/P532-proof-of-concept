import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle implements GameElementInterface {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private Color paddleColor;
	private int direction;
	
	public Paddle(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.width = 40;
		this.height = 15;
		this.paddleColor = Color.GREEN;
		this.setDirection(1000);
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
		posX = xCoOrdinate;
	}

	@Override
	public void setY(int yCoOrdinate) {
		// TODO Auto-generated method stub
		posY = yCoOrdinate;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(paddleColor);				
		g.fillRect(posX, posY, width, height);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public Rectangle createCollider(int x, int y, int w, int h){
		return new Rectangle(x, y, w, h);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void reset(){
		this.setX(300);
	}

}
