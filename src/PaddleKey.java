import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PaddleKey implements KeyListener {
	
	private Paddle p;
	
	public PaddleKey(Paddle p){
		this.p = p;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		p.setDirection(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
