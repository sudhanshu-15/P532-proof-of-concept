import java.awt.Graphics;

public interface GameElementInterface {

	public int getX();

	public int getY();

	public void setX(int xCoOrdinate);

	public void setY(int yCoOrdinate);
	
	public void draw(Graphics g);
}
