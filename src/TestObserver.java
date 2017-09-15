import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestObserver extends JPanel{
	
	private Ball b;
	private GameObservable go;
	private GameElements ge;
	private static Boolean play;
	
	public TestObserver(){
		b = new Ball(120, 10, -5, -5, Color.blue);
		go = new GameObservable();
		ge = new GameElements(go);
		ge.add(b);
		play = true;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		b.draw(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestObserver to = new TestObserver();
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame jf = new JFrame();
				jf.setSize(600,600);
				jf.setTitle("Animation");
				jf.setVisible(true);
				to.requestFocusInWindow();
				to.setFocusable(true);
				to.setFocusTraversalKeysEnabled(false);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.add(to);
			}
			
		});
		
		new Thread(){
			public void run(){
				while(play){
					to.b.checkBounds(575, 575);
					to.go.frameChanged();
					to.repaint();
					try {
						java.lang.Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
	}

}
