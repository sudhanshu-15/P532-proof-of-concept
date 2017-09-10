import java.awt.Color;
import java.awt.Graphics;

public class Paddle implements GameElementInterface {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private Color paddleColor;
	
	public Paddle(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.width = 40;
		this.height = 15;
		this.paddleColor = Color.GREEN;
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

}
